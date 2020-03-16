package com.finablr.platform.notification.service.impl;

import java.time.Instant;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.finablr.platform.notification.domain.NotificationRequest;
import com.finablr.platform.notification.domain.NotificationTemplate;
import com.finablr.platform.notification.dto.AddNotificationRequestDto;
import com.finablr.platform.notification.enumStatus.NotificationStatus;
import com.finablr.platform.notification.exceptionhandler.model.BusinessException;
import com.finablr.platform.notification.exceptionhandler.model.DataNotFoundException;
import com.finablr.platform.notification.jmsconfiguration.MessageSender;
import com.finablr.platform.notification.repository.NotificationRequestRepository;
import com.finablr.platform.notification.repository.NotificationTemplateRepository;
import com.finablr.platform.notification.service.NotificationRequestService;
import com.finablr.platform.notification.util.MergePlaceHolder;

@Service
public class NotificationRequestServiceImpl implements NotificationRequestService {

	@Autowired
	private NotificationRequestRepository notificationRequestRepository;
	
	@Autowired
	private NotificationTemplateRepository notificationTemplateRepository;

	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	MessageSender messageSender;

	@Override
	public Long addRequest(AddNotificationRequestDto addNotificationRequestDto) {
		
		Instant time = Instant.now();
		
		if(addNotificationRequestDto.getReceipientDetails().isEmpty())
			throw new DataNotFoundException("Receipient Detail can't be null");
			
		NotificationTemplate notificationTemplate = notificationTemplateRepository.findByTemplateCode(addNotificationRequestDto.getTemplateCode());
		
		if(notificationTemplate == null)
			throw new DataNotFoundException("Template Not Found");
		
		if(time.isBefore(notificationTemplate.getEffectiveFrom()) || time.isAfter(notificationTemplate.getEffectiveTo()))
			throw new BusinessException("Template Not available");
		
		if(notificationTemplate.getNotificationChannel().isDisable())
			throw new BusinessException("Template Not Found");
		

		if(notificationTemplate.getNotificationContentType().isDisable())
			throw new BusinessException("Template Not Found");
		
		
		NotificationRequest notificationRequest = modelmapper.map(addNotificationRequestDto, NotificationRequest.class);
		notificationRequest.setRetryCount(0);
		notificationRequest.setStatus(NotificationStatus.PENDING.name());
		notificationRequest.setRequestTime(Instant.now());
		notificationRequest.setTemplateId(notificationTemplate);
		String templateBody = notificationTemplate.getTemplateBody();
		String templateSubject = notificationTemplate.getTemplateSubject();
		
		notificationTemplate.setTemplateBody(MergePlaceHolder.replacePlaceholders(addNotificationRequestDto.getNotificationData(), templateBody));
		notificationRequest.setNotificationBody(notificationTemplate.getTemplateBody());
		
		notificationTemplate.setTemplateBody(MergePlaceHolder.replacePlaceholders(addNotificationRequestDto.getNotificationData(), templateSubject));
		notificationRequest.setNotificationSubject(notificationTemplate.getTemplateSubject());
		notificationRequestRepository.save(notificationRequest);
		
		//messageSender.sendMessage(notificationRequest);
		return notificationRequest.getId();
	}

	@Override
	public String getStatus(Long id) {
		Optional<NotificationRequest> notification = notificationRequestRepository.findById(id);
		if (!notification.isPresent())
			throw new DataNotFoundException("Request Id Not Found");
		return notification.get().getStatus();
	}
}

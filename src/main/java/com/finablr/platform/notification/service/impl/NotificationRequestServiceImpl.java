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
import com.finablr.platform.notification.repository.NotificationRequestRepository;
import com.finablr.platform.notification.repository.NotificationTemplateRepository;
import com.finablr.platform.notification.service.NotificationRequestService;

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

	@Override
	public Long addRequest(AddNotificationRequestDto addNotificationRequestDto) {
		
		Instant time = Instant.now();
		
		if(addNotificationRequestDto.getReceipientDetails().isEmpty())
			throw new DataNotFoundException("Bad Request");
			
		NotificationTemplate notificationTemplate = notificationTemplateRepository.findByTemplateCode(addNotificationRequestDto.getTemplateCode());
		
		if(notificationTemplate == null)
			throw new DataNotFoundException("Template Not Found");
		
		if(time.isBefore(notificationTemplate.getEffectiveFrom()) || time.isAfter(notificationTemplate.getEffectiveTo()))
			throw new BusinessException("Template Not available");
		
		if(notificationTemplate.getNotificationChannel().isDisable())
			throw new BusinessException("Template Not Found");
		

		if(notificationTemplate.getNotificationContentType().isDisable())
			throw new BusinessException("Template Not Found");
		
		
		NotificationRequest notificationRequestMapper = modelmapper.map(addNotificationRequestDto, NotificationRequest.class);
		notificationRequestMapper.setRetryCount(0);
		notificationRequestMapper.setStatus(NotificationStatus.PENDING.name());
		notificationRequestMapper.setRequestTime(Instant.now());
		notificationRequestMapper.setTemplateId(notificationTemplate);
		
//		for(String key:addNotificationRequestDto.getNotificationData().keySet())  
//			notificationTemplate.getTemplateBody().replaceAll("\\{\\{"+ key +"\\}\\}", addNotificationRequestDto.getNotificationData().get(key));	
		notificationRequestMapper.setNotificationBody(notificationTemplate.getTemplateBody());
		
//		for(String key:addNotificationRequestDto.getNotificationData().keySet())  
//			notificationTemplate.getTemplateSubject().replaceAll("\\{\\{"+ key +"\\}\\}", addNotificationRequestDto.getNotificationData().get(key));
		notificationRequestMapper.setNotificationSubject(notificationTemplate.getTemplateSubject());
		
		return notificationRequestRepository.save(notificationRequestMapper).getId();
		
//		ConfigurableApplicationContext context = SpringApplication.run(JmsConfiguration.class);
//		jmsTemplate = context.getBean(JmsTemplate.class);
//		jmsTemplate.convertAndSend("jms.message.endpoint", AddRequestMapper);
//		return AddRequestMapper.getId();
	}

	@Override
	public String getStatus(Long id) {
		Optional<NotificationRequest> notification = notificationRequestRepository.findById(id);
		if (!notification.isPresent())
			throw new DataNotFoundException("Request Id Not Found");
		return notification.get().getStatus();
	}
}

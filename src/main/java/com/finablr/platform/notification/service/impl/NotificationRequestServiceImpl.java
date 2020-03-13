package com.finablr.platform.notification.service.impl;

import java.time.Instant;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.finablr.platform.notification.domain.NotificationRequest;
import com.finablr.platform.notification.domain.NotificationTemplate;
import com.finablr.platform.notification.dto.AddNotificationRequestDto;
import com.finablr.platform.notification.enumStatus.NotificationStatus;
import com.finablr.platform.notification.exceptionhandler.model.BusinessException;
import com.finablr.platform.notification.exceptionhandler.model.DataNotFoundException;
import com.finablr.platform.notification.jmsconfiguration.JmsConfiguration;
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
	public Long addRequest(AddNotificationRequestDto notificationDto) {
		
		Instant time = Instant.now();
		
		if(notificationDto.getNotificationData().isEmpty())
			throw new DataNotFoundException("Invalid input");
		
//		if(notificationDto.getReceipientDetails().isEmpty())
//			throw new DataNotFoundException("Invalid input");
			
		Optional<NotificationTemplate> notificationTemplate= notificationTemplateRepository.findByTemplateCode(notificationDto.getTemplateCode());
		if(!notificationTemplate.isPresent())
			throw new DataNotFoundException("Template Not Found");
		
		if(!time.isAfter(notificationTemplate.get().getEffectiveFrom()) && time.isBefore(notificationTemplate.get().getEffectiveTo()) )
			throw new BusinessException("Template Not available");
		
//		if(!notificationTemplate.get().getNotificationChannel().isDisable())
//			throw new BusinessException("Template Not Found");
		

//		if(!notificationTemplate.get().getNotificationContentType().isDisable())
//		throw new BusinessException("Template Not Found");
		
		
		NotificationRequest AddRequestMapper = modelmapper.map(notificationDto, NotificationRequest.class);
		AddRequestMapper.setRetryCount(0);
		AddRequestMapper.setStatus(NotificationStatus.PENDING.name());
		AddRequestMapper.setRequestTime(Instant.now());
		AddRequestMapper.setTemplateId(notificationTemplate.get());
		for(String key:notificationDto.getNotificationData().keySet())  
			notificationTemplate.get().getTemplateBody().replaceAll("\\{\\{"+ key +"\\}\\}", notificationDto.getNotificationData().get(key));	
		AddRequestMapper.setNotificationBody(notificationTemplate.get().getTemplateBody());
		AddRequestMapper.setNotificationSubject(notificationTemplate.get().getTemplateSubject());
		notificationRequestRepository.save(AddRequestMapper);
		
		ConfigurableApplicationContext context = SpringApplication.run(JmsConfiguration.class);
		jmsTemplate = context.getBean(JmsTemplate.class);
		jmsTemplate.convertAndSend("jms.message.endpoint", AddRequestMapper);
		return AddRequestMapper.getId();
	}

	@Override
	public String getStatus(Long id) {
		Optional<NotificationRequest> notification = notificationRequestRepository.findById(id);
		if (!notification.isPresent())
			throw new DataNotFoundException("Request Id Not Found");
		return notification.get().getStatus();
	}
}

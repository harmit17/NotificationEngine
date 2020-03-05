package com.finablr.platform.notification.service.impl;

import java.time.Instant;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finablr.platform.notification.domain.NotificationRequest;
import com.finablr.platform.notification.domain.NotificationTemplate;
import com.finablr.platform.notification.dto.AddNotificationRequestDto;
import com.finablr.platform.notification.enumStatus.NotificationStatus;
import com.finablr.platform.notification.exceptionhandler.model.DataNotFoundException;
import com.finablr.platform.notification.repository.NotificationRequestRepository;
import com.finablr.platform.notification.repository.NotificationTemplateRepository;
import com.finablr.platform.notification.service.NotificationRequestService;

@Service
public class NotificationRequestImpl implements NotificationRequestService {

	@Autowired
	private NotificationRequestRepository notificationRequestRepository;
	
	@Autowired
	private NotificationTemplateRepository notificationTemplateRepository;

	@Autowired
	private ModelMapper modelmapper;

	@Override
	public Long addRequest(AddNotificationRequestDto notificationDto) {
		NotificationRequest getStatus = modelmapper.map(notificationDto, NotificationRequest.class);
		System.out.println(notificationDto);
		getStatus.setNotificationData(notificationDto.getNotificationData());
		getStatus.setReceipientDetails(notificationDto.getReceipientDetails());
		getStatus.setRetryCount(0);
		getStatus.setStatus(NotificationStatus.PENDIND.name());
		getStatus.setRequestTime(Instant.now());
		Optional<NotificationTemplate> notificationTemplate= notificationTemplateRepository.findByTemplateCode(notificationDto.getTemplateCode());
		if(!notificationTemplate.isPresent())
			throw new DataNotFoundException("Template Not Found");
		getStatus.setTemplateId(notificationTemplate.get());
		getStatus.setNotificationBody(notificationTemplate.get().getTemplateBody());
		getStatus.setNotificationSubject(notificationTemplate.get().getTemplateSubject());
		notificationRequestRepository.save(getStatus);
		return getStatus.getId();
	}

	@Override
	public String getStatus(Long id) {
		Optional<NotificationRequest> notification = notificationRequestRepository.findById(id);
		if (!notification.isPresent())
			throw new DataNotFoundException("Request Id Not Found");
		return notification.get().getStatus();
	}
}

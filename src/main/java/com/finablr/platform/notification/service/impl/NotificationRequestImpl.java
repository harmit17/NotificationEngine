package com.finablr.platform.notification.service.impl;

import java.time.Instant;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finablr.platform.notification.domain.NotificationRequest;
import com.finablr.platform.notification.dto.AddNotificationRequestDto;
import com.finablr.platform.notification.enumStatus.NotificationStatus;
import com.finablr.platform.notification.exceptionhandler.model.NotificationRequestIdNotFoundException;
import com.finablr.platform.notification.repository.NotificationRequestRepository;
import com.finablr.platform.notification.service.NotificationRequestService;

@Service
public class NotificationRequestImpl implements NotificationRequestService {

	@Autowired
	private NotificationRequestRepository notoficationRequestRepo;

	@Autowired
	private ModelMapper modelmapper;

	@Override
	public void addRequest(AddNotificationRequestDto notificationDto) {
		NotificationRequest getStatus = modelmapper.map(notificationDto, NotificationRequest.class);
		System.out.println(notificationDto);
		getStatus.setNotificationData(notificationDto.getNotificationData());
		getStatus.setReceipientDetails(notificationDto.getRecieptionDetails());
		getStatus.setRetryCount(0);
		getStatus.setStatus(NotificationStatus.PENDIND.name());
		getStatus.setRequestTime(Instant.now());
		notoficationRequestRepo.save(getStatus);
	}

	@Override
	public String getStatus(Long id) {
		if (notoficationRequestRepo.existsById(id)) {
			return notoficationRequestRepo.getOne(id).getStatus();
		} else {
			throw new NotificationRequestIdNotFoundException("Id Not Found");
		}
	}
}

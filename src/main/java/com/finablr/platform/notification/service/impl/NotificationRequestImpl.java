package com.finablr.platform.notification.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finablr.platform.notification.domain.NotificationRequest;
import com.finablr.platform.notification.dto.GetNotificationRequestStatusDto;
import com.finablr.platform.notification.repository.NotificationRequestRepository;
import com.finablr.platform.notification.service.NotificationRequestService;

@Service
public class NotificationRequestImpl implements NotificationRequestService {

	@Autowired
	private NotificationRequestRepository notoficationRequestRepo;

	@Autowired
	private ModelMapper modelmapper;

	@Override
	public void addRequest(GetNotificationRequestStatusDto notificationDto) {
		GetNotificationRequestStatusDto getStatus = modelmapper.map(new NotificationRequest(),
				GetNotificationRequestStatusDto.class);
	}

	@Override
	public String getStatus(Long id) {
		try {
			if (notoficationRequestRepo.existsById(id)) {
				return notoficationRequestRepo.getOne(id).getStatus();
			} else {
				return "Id not found";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}

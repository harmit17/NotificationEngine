package com.finablr.platform.notification.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finablr.platform.notification.Dto.GetNotificationRequestStatusDTO;
import com.finablr.platform.notification.domain.NotificationRequest;
import com.finablr.platform.notification.repository.NotificationRequestRepository;
import com.finablr.platform.notification.service.NotificationRequestService;

@Service
public class NotificationRequestIMPL implements NotificationRequestService {

	@Autowired
	private NotificationRequestRepository notoficationRequestRepo;

	@Autowired
	private ModelMapper modelmapper;

	@Override
	public void addRequest(GetNotificationRequestStatusDTO notificationDto) {
		GetNotificationRequestStatusDTO getStatus = modelmapper.map(new NotificationRequest(),
				GetNotificationRequestStatusDTO.class);
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

package com.finablr.platform.notification.service;

import com.finablr.platform.notification.dto.AddNotificationRequestDto;

public interface NotificationRequestService {
	
	void addRequest(AddNotificationRequestDto notificationDto);

	String getStatus(Long id);
	
		
}

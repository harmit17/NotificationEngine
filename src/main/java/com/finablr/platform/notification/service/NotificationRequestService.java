package com.finablr.platform.notification.service;

import com.finablr.platform.notification.dto.AddNotificationRequestDto;

public interface NotificationRequestService {
	
	Long addRequest(AddNotificationRequestDto notificationDto);

	String getStatus(Long id);
	
		
}

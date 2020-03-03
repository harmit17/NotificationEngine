package com.finablr.platform.notification.service;

import com.finablr.platform.notification.dto.GetNotificationRequestStatusDto;

public interface NotificationRequestService {
	
	void addRequest(GetNotificationRequestStatusDto notificationDto);

	String getStatus(Long id);
	
		
}

package com.finablr.platform.notification.service;

import com.finablr.platform.notification.Dto.GetNotificationRequestStatusDTO;

public interface NotificationRequestService {
	
	void addRequest(GetNotificationRequestStatusDTO notificationDto);

	String getStatus(Long id);
	
		
}

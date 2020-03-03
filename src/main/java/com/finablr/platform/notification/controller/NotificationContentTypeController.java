package com.finablr.platform.notification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finablr.platform.notification.domain.NotificationContentType;
import com.finablr.platform.notification.service.NotificationContentTypeService;
import com.finablr.platform.notification.service.impl.NotificationContentTypeServiceImpl;

@RestController
public class NotificationContentTypeController {

	@Autowired
	public NotificationContentTypeServiceImpl notificationContentTypeServiceImpl;
	
	@RequestMapping("/api/v1/notification-content-types")
	public List<NotificationContentType> getAllNotificationContentType() {
		System.out.println(notificationContentTypeServiceImpl.getAllNotificationContentType());
		return notificationContentTypeServiceImpl.getAllNotificationContentType();
	}

	@RequestMapping("/api/v1/notification-content-types/toggle/status/{id}")
	public NotificationContentType getNotificationContentType(@PathVariable Long id) {
		return notificationContentTypeServiceImpl.toggleNotificationContentType(id);
	}
}

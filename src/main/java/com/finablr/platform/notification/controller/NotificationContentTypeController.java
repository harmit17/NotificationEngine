package com.finablr.platform.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finablr.platform.notification.service.NotificationContentTypeService;

@RestController
public class NotificationContentTypeController {

	@Autowired
	public NotificationContentTypeService notificationContentTypeService;

	@RequestMapping("/addNotificationContentType")
	public void addNotificationContentType() {
		notificationContentTypeService.addNotificationContentType();
	}

	@RequestMapping("/")
	public void getNotificationContentType() {
		notificationContentTypeService.getNotificationContentType();
	}
}

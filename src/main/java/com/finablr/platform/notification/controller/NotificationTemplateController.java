package com.finablr.platform.notification.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finablr.platform.notification.service.NotificationTemplateService;

@RestController
public class NotificationTemplateController {
	
	public NotificationTemplateService notificationTemplateService;
	
	@RequestMapping("/addNotificationTemplateData")
	public void addNotificationTemplateData()
	{
		notificationTemplateService.addNotificationTemplate();
	}
	
	@RequestMapping("/updateNotificationTemplateData")
	public void updateNotificationTemplateData()
	{
		notificationTemplateService.updateNotificationTemplate();
	}

}

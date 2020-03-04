package com.finablr.platform.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finablr.platform.notification.dto.GetAllNotificationTemplatesDto;

import com.finablr.platform.notification.service.impl.NotificationTemplateServiceImpl;
import com.finablr.platform.notification.util.Response;

@RestController
public class NotificationTemplateController {

	@Autowired
	public NotificationTemplateServiceImpl notificationTemplateService;

	@RequestMapping("/addNotificationTemplateData")
	public void addNotificationTemplateData() {
		notificationTemplateService.addNotificationTemplate();
	}

	@RequestMapping("/updateNotificationTemplateData")
	public void updateNotificationTemplateData() {
		notificationTemplateService.updateNotificationTemplate();
	}

	@RequestMapping(value="/api/v1/notification-templates", method = RequestMethod.GET)
	public Response<Page<GetAllNotificationTemplatesDto>> getAllNotificationsData(Pageable pageable) {
		return new Response<Page<GetAllNotificationTemplatesDto>>(200, notificationTemplateService.getAllNotificationTemplates(pageable), "Notification templates fetched successfully",null);
	}
}

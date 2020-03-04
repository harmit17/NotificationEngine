package com.finablr.platform.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Http2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import com.finablr.platform.notification.dto.GetAllNotificationTemplatesDto;

import com.finablr.platform.notification.service.impl.NotificationTemplateServiceImpl;
import com.finablr.platform.notification.util.Response;

@RestController
public class NotificationTemplateController {

	@Autowired
	private NotificationTemplateServiceImpl notificationTemplateService;

	@RequestMapping("/addNotificationTemplateData")
	public void addNotificationTemplateData() {
		notificationTemplateService.addNotificationTemplate();
	}

	@RequestMapping("/updateNotificationTemplateData")
	public void updateNotificationTemplateData() {
		notificationTemplateService.updateNotificationTemplate();
	}

	@GetMapping("/api/v1/notification-templates")
	public Response<Page<GetAllNotificationTemplatesDto>> getAllNotificationsData(Pageable pageable) {
		return new Response<Page<GetAllNotificationTemplatesDto>>(HttpStatus.OK.value(), notificationTemplateService.getAllNotificationTemplates(pageable), "Notification templates fetched successfully",null);
	}
}

package com.finablr.platform.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.finablr.platform.notification.dto.GetAllNotificationTemplatesDto;
import com.finablr.platform.notification.service.NotificationTemplateService;
import com.finablr.platform.notification.util.Response;

@RestController
@RequestMapping(value = "/user")
public class NotificationTemplateController {

	@Autowired
	public NotificationTemplateService notificationTemplateService;
	
	@GetMapping("/api/v1/notification-templates")
	public Response<Page<GetAllNotificationTemplatesDto>> getAllNotificationsData(Pageable pageable) {
		return new Response<Page<GetAllNotificationTemplatesDto>>(HttpStatus.OK.value(), notificationTemplateService.getAllNotificationTemplates(pageable), "Successfully Retrived",null);
	}
}

package com.finablr.platform.notification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finablr.platform.notification.domain.NotificationContentType;
import com.finablr.platform.notification.dto.GetNotificationContentTypeDto;
import com.finablr.platform.notification.service.NotificationContentTypeService;
import com.finablr.platform.notification.service.impl.NotificationContentTypeServiceImpl;
import com.finablr.platform.notification.util.Response;

@RestController
public class NotificationContentTypeController {

	@Autowired
	public NotificationContentTypeService notificationContentTypeService;
	
	@GetMapping("/api/v1/notification-content-types")
	public Response<List<GetNotificationContentTypeDto>> getAllNotificationContentType() {
		return new Response<List<GetNotificationContentTypeDto>>(200,notificationContentTypeService.getAllNotificationContentType(),"Successfully Retrived",null);
	}

	@PatchMapping("/api/v1/notification-content-types/toggle/status/{id}")
	public Response<GetNotificationContentTypeDto> toggleNotificationContentTypeStatus(@PathVariable Long id) {
		return new Response<GetNotificationContentTypeDto>(200,notificationContentTypeService.toggleNotificationContentType(id),"Status toggled",null);
	}
}
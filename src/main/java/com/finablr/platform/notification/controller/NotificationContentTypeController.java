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

@RestController
public class NotificationContentTypeController {

	@Autowired
	public NotificationContentTypeServiceImpl notificationContentTypeServiceImpl;
	
	@GetMapping("/api/v1/notification-content-types")
	public List<GetNotificationContentTypeDto> getAllNotificationContentType() {
		//System.out.println(notificationContentTypeServiceImpl.getAllNotificationContentType());
		return notificationContentTypeServiceImpl.getAllNotificationContentType();
	}

	@PatchMapping("/api/v1/notification-content-types/toggle/status/{id}")
	public GetNotificationContentTypeDto getNotificationContentType(@PathVariable Long id) {
		return notificationContentTypeServiceImpl.toggleNotificationContentType(id);
	}
}
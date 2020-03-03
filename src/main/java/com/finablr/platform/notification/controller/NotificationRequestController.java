package com.finablr.platform.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.ResponseBody;
>>>>>>> Dto package created
import org.springframework.web.bind.annotation.RestController;

import com.finablr.platform.notification.domain.NotificationRequest;
import com.finablr.platform.notification.dto.GetNotificationRequestStatusDto;
import com.finablr.platform.notification.service.NotificationRequestService;


@RestController
public class NotificationRequestController {
	
	@Autowired
	public NotificationRequestService service;

	/*
	 * Add notification request controller method
	 */
	@PostMapping("/api/v1/notification-requests")
	public void addNotificationRequest(GetNotificationRequestStatusDto notificationDto) {
		service.addRequest(notificationDto);
	}

	/*
	 * get notification status controller method
	 */
	@ResponseBody
	@GetMapping("/api/v1/notification-requests/status/{id}")
	public String getNotificationStatus(@PathVariable Long id) {
		return service.getStatus(id);
	}
	
}

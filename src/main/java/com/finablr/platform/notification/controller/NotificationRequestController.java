package com.finablr.platform.notification.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finablr.platform.notification.dto.AddNotificationRequestDto;
import com.finablr.platform.notification.service.NotificationRequestService;
import com.finablr.platform.notification.util.Response;

@RestController
public class NotificationRequestController {

	@Autowired
	public NotificationRequestService notificationRequestService;

	/*
	 * Add notification request controller method
	 */
	@PostMapping("/api/v1/notification-requests")
	public Response<Long> addNotificationRequest(@Valid @RequestBody AddNotificationRequestDto notificationDto) {
		return new Response<Long>(HttpStatus.OK.value(), notificationRequestService.addRequest(notificationDto),
				"Successfully Add Request", null);
	}

	/*
	 * get notification status controller method
	 */
	@GetMapping("/api/v1/notification-requests/status/{id}")
	public Response<String> getNotificationStatus(@NotBlank @PathVariable Long id) {
		return new Response<String>(HttpStatus.OK.value(), notificationRequestService.getStatus(id), "Successfully retrive", null);
	}

}

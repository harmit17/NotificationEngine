package com.finablr.platform.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finablr.platform.notification.service.NotificationRequestService;


@RestController
public class NotificationRequestController {
	
	@Autowired
	public NotificationRequestService service;

	/*
	 * Add notification request controller method
	 */
	@RequestMapping("/addNotificationRequest")	
	public void addNotificationRequest() {
		service.addRequest();
	}

	/*
	 * get notification status controller method
	 */
	@RequestMapping("/getNotificationStatus")
	public void getNotificationStatus() {
		service.getStatus();
	}


}

package com.finablr.platform.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finablr.platform.notification.services.Services;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	private Services service;

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

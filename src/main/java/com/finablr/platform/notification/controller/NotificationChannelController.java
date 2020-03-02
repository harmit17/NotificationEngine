package com.finablr.platform.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finablr.platform.notification.service.NotificationChannelService;

@RestController
public class NotificationChannelController {

	@Autowired
	public NotificationChannelService channelService;
	
	//retrieve all available Notification Channel 
	@RequestMapping("/getNotificationChannels")
	public void getNotificationChannels() {
		
		channelService.getAllChannels();
	}
	
	//change status of Notification Channel
	@RequestMapping("/toggleNotificationChannelStatus")
	public void toggleNotificationChannelStatus() {
		
		channelService.toggleChannelStatus();
	}
}

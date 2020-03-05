package com.finablr.platform.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.finablr.platform.notification.domain.NotificationChannel;
import com.finablr.platform.notification.service.NotificationChannelService;

@RestController
public class NotificationChannelController {

	@Autowired
	public NotificationChannelService channelService;
	
	//retrieve all available Notification Channel 
	@GetMapping("/api/v1/notification-channels")
	public List<NotificationChannel> getNotificationChannels() {
		
		return channelService.getAllChannels();
	}
	
	//change status of Notification Channel
	@PatchMapping("/api/v1/notification-channels/toggle/status/{channelId}")
	public void toggleNotificationChannelStatus(@PathVariable Long channelId) {
		
		channelService.toggleChannelStatus();
	}
}

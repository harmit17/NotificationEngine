package com.finablr.platform.notification.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.finablr.platform.notification.domain.NotificationChannel;
import com.finablr.platform.notification.dto.NotificationChannelDto;
import com.finablr.platform.notification.service.NotificationChannelService;
import com.finablr.platform.notification.util.Response;

@RestController
public class NotificationChannelController {

	@Autowired
	public NotificationChannelService channelService;
	
	public NotificationChannelDto channelDto;
	ModelMapper modelMapper = new ModelMapper();
	
	
	//retrieve all available Notification Channel 
	@GetMapping("/api/v1/notification-channels")
	public Response<List<NotificationChannelDto>> getNotificationChannels() {
		
		String message = "Successfully retrieved";
		Object error = null;
		return new Response<List<NotificationChannelDto>>(HttpStatus.OK.value(), channelService.getAllChannels(), message, error);
	}
	
	//change status of Notification Channel
	@PatchMapping("/api/v1/notification-channels/toggle/status/{channelId}")
	public Response<NotificationChannelDto> toggleNotificationChannelStatus(@PathVariable Long channelId) {
		
		String message = "Status is successfully changed";
		Object error = null;
		return new Response<NotificationChannelDto>(HttpStatus.OK.value(), channelService.toggleChannelStatus(channelId), message, error);
	}
}

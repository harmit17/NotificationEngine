package com.finablr.platform.notification.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finablr.platform.notification.domain.NotificationChannel;
import com.finablr.platform.notification.repository.NotificationChannelRepository;
import com.finablr.platform.notification.service.NotificationChannelService;

@Service
public class NotificationChannelServiceImpl implements NotificationChannelService{
	
	@Autowired
	public NotificationChannelRepository notificationChannelRepository;

	@Override
	public List<NotificationChannel> getAllChannels() {
		
		return notificationChannelRepository.findAll();
	}
	
	@Override
	public void toggleChannelStatus() {
		
		
	}
}

package com.finablr.platform.notification.service;

import java.util.List;

import com.finablr.platform.notification.domain.NotificationChannel;

public interface NotificationChannelService {

	List<NotificationChannel> getAllChannels();
	void toggleChannelStatus();
}

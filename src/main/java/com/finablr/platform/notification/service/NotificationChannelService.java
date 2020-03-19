package com.finablr.platform.notification.service;

import java.util.List;

import com.finablr.platform.notification.dto.NotificationChannelDto;

public interface NotificationChannelService {

	List<NotificationChannelDto> getAllChannels();
	NotificationChannelDto toggleChannelStatus(Long id);
}

package com.finablr.platform.notification.service;

import java.util.List;

import com.finablr.platform.notification.domain.NotificationContentType;
import com.finablr.platform.notification.dto.GetNotificationContentTypeDto;

public interface NotificationContentTypeService {

	List<GetNotificationContentTypeDto> getAllNotificationContentType();

	GetNotificationContentTypeDto toggleNotificationContentType(Long id);
}

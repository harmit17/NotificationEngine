package com.finablr.platform.notification.service;

import java.util.List;

import com.finablr.platform.notification.domain.NotificationContentType;

public interface NotificationContentTypeService {

	List<NotificationContentType> getAllNotificationContentType();

	NotificationContentType toggleNotificationContentType(Long id);
}

package com.finablr.platform.notification.service;

<<<<<<< HEAD
import java.util.List;

import com.finablr.platform.notification.domain.NotificationTemplate;
=======

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.finablr.platform.notification.dto.GetAllNotificationTemplatesDto;
>>>>>>> Created API for getting all notification templates with services

public interface NotificationTemplateService {

	void addNotificationTemplate();

	void updateNotificationTemplate();
	

	Page<GetAllNotificationTemplatesDto> getAllNotificationTemplates(Pageable pageable);
}

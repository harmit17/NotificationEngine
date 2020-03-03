package com.finablr.platform.notification.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.finablr.platform.notification.dto.GetAllNotificationTemplatesDto;


public interface NotificationTemplateService {

	Page<GetAllNotificationTemplatesDto> getAllNotificationTemplates(Pageable pageable);
}

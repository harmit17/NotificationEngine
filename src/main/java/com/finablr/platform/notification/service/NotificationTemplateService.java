package com.finablr.platform.notification.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.finablr.platform.notification.dto.AddNotificationTemplateDto;
import com.finablr.platform.notification.dto.GetAllNotificationTemplatesDto;
import com.finablr.platform.notification.dto.UpdateNotificationTemplateDto;

public interface NotificationTemplateService {
	
	Long addNotificationTemplate(AddNotificationTemplateDto addNotificationTemplateDto);
	
	Long updateNotificationTemplate(UpdateNotificationTemplateDto updateNotificationTemplateDto);

	Page<GetAllNotificationTemplatesDto> getAllNotificationTemplates(Pageable pageable);

}

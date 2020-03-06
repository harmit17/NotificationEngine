package com.finablr.platform.notification.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.finablr.platform.notification.dto.DownloadNotificationTemplateDto;
import com.finablr.platform.notification.dto.GetAllNotificationTemplatesDto;
import com.finablr.platform.notification.dto.NotificationTemplateFileDto;



public interface NotificationTemplateService {

	void addNotificationTemplate();

	void updateNotificationTemplate();
	

	Page<GetAllNotificationTemplatesDto> getAllNotificationTemplates(Pageable pageable);

	
	NotificationTemplateFileDto downloadNotificationTemplateFile(DownloadNotificationTemplateDto downloadNotificationTemplateDto);

}

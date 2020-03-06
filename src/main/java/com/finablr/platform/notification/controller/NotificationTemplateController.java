package com.finablr.platform.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.finablr.platform.notification.dto.DownloadNotificationTemplateDto;
import com.finablr.platform.notification.dto.GetAllNotificationTemplatesDto;
import com.finablr.platform.notification.dto.NotificationTemplateFileDto;
import com.finablr.platform.notification.service.NotificationTemplateService;
import com.finablr.platform.notification.util.Response;

@RestController
public class NotificationTemplateController {

	@Autowired
	private NotificationTemplateService notificationTemplateService;

	@RequestMapping("/addNotificationTemplateData")
	public void addNotificationTemplateData() {
		notificationTemplateService.addNotificationTemplate();
	}

	@RequestMapping("/updateNotificationTemplateData")
	public void updateNotificationTemplateData() {
		notificationTemplateService.updateNotificationTemplate();
	}

	@GetMapping("/api/v1/notification-templates")
	public Response<Page<GetAllNotificationTemplatesDto>> getAllNotificationsData(Pageable pageable) {
		return new Response<Page<GetAllNotificationTemplatesDto>>(HttpStatus.OK.value(),
				notificationTemplateService.getAllNotificationTemplates(pageable), "Successfully Retrived", null);

	}

	@PostMapping("/api/v1/notification-templates/download")
	public Response<NotificationTemplateFileDto> getNotificationTemplateFile(
			@RequestBody DownloadNotificationTemplateDto downloadNotificationTemplateDto) {
		return new Response<NotificationTemplateFileDto>(HttpStatus.OK.value(),notificationTemplateService.downloadNotificationTemplateFile(downloadNotificationTemplateDto),"Successfully Retrived",null);
	}
}

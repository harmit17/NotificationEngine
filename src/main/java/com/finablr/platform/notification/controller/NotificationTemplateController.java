package com.finablr.platform.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finablr.platform.notification.dto.DownloadNotificationTemplateDto;
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

	@PostMapping("/test")
	public Response<NotificationTemplateFileDto> getNotificatonTemplateFile(
			@RequestBody DownloadNotificationTemplateDto downloadNotificationTemplateDto) {
		return new Response<NotificationTemplateFileDto>(HttpStatus.OK.value(),
				notificationTemplateService.downloadNotificationTemplateFile(downloadNotificationTemplateDto),
				"Successfully Retrived", null);
	}
}

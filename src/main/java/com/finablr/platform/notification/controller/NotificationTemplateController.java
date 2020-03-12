package com.finablr.platform.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finablr.platform.notification.dto.AddNotificationTemplateDto;
import com.finablr.platform.notification.dto.GetAllNotificationTemplatesDto;
import com.finablr.platform.notification.dto.UpdateNotificationTemplateDto;
import com.finablr.platform.notification.service.NotificationTemplateService;
import com.finablr.platform.notification.util.Response;

@RestController
public class NotificationTemplateController {

	@Autowired
	public NotificationTemplateService notificationTemplateService;
	
	@RequestMapping(value="/api/v1/notification-templates",method = RequestMethod.POST)
	public Response<Long> addNotificationTemplateData(@RequestBody AddNotificationTemplateDto addNotificationTemplateDto)
	{
		return new Response<Long>(HttpStatus.OK.value(),this.notificationTemplateService.addNotificationTemplate(addNotificationTemplateDto),"Notification Template Data Add Successfully",null);
	}
	
	@RequestMapping(value="/api/v1/notification-templates",method = RequestMethod.PUT)
	public Response<Long> updateNotificationTemplateData(@RequestBody UpdateNotificationTemplateDto updateNotificationTemplateDto)
	{
		return new Response<Long>(HttpStatus.OK.value(),this.notificationTemplateService.updateNotificationTemplate(updateNotificationTemplateDto),"Notification Template Data Update Successfully",null);
	}
	
	@GetMapping("/api/v1/notification-templates")
	public Response<Page<GetAllNotificationTemplatesDto>> getAllNotificationsData(Pageable pageable) {
		return new Response<Page<GetAllNotificationTemplatesDto>>(HttpStatus.OK.value(), notificationTemplateService.getAllNotificationTemplates(pageable), "Successfully Retrived",null);
	}
}

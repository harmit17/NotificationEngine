package com.finablr.platform.notification.service.impl;



import java.time.Instant;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.finablr.platform.notification.domain.NotificationTemplate;
import com.finablr.platform.notification.dto.DownloadNotificationTemplateDto;
import com.finablr.platform.notification.dto.GetAllNotificationTemplatesDto;
import com.finablr.platform.notification.dto.NotificationTemplateFileDto;


import org.springframework.stereotype.Service;


import com.finablr.platform.notification.exceptionhandler.model.DataNotFoundException;
import com.finablr.platform.notification.repository.NotificationTemplateRepository;
import com.finablr.platform.notification.service.NotificationTemplateService;
import com.finablr.platform.notification.util.MergePlaceHolder;

@Service
public class NotificationTemplateServiceImpl implements NotificationTemplateService {

	@Autowired
	private NotificationTemplateRepository notificationTemplateRepository;

	@Autowired
	private ModelMapper modelMapper;


	@Override
	public void addNotificationTemplate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateNotificationTemplate() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("null")
	@Override
	public Page<GetAllNotificationTemplatesDto> getAllNotificationTemplates(Pageable pageable) {
		Page<NotificationTemplate> notificationTemplates = notificationTemplateRepository.findAll(pageable);
		if (notificationTemplates.getContent().isEmpty()) {
			throw new DataNotFoundException("No templates Found");
		}
		Page<GetAllNotificationTemplatesDto> notificationTemplatePages = notificationTemplates.map(notificationTemplate -> {
			GetAllNotificationTemplatesDto getAllNotificationTemplatesDto = new GetAllNotificationTemplatesDto();
			modelMapper.map(notificationTemplate, getAllNotificationTemplatesDto);
			return getAllNotificationTemplatesDto;
		});
		return notificationTemplatePages;
	}

	@Override
	public NotificationTemplateFileDto downloadNotificationTemplateFile(
			DownloadNotificationTemplateDto downloadNotificationTemplateDto) {
		NotificationTemplate notificationTemplate;
		try{
			notificationTemplate = notificationTemplateRepository.findById(downloadNotificationTemplateDto.getId()).get();
		}
		catch(Exception exception) {
			throw new DataNotFoundException("Template Not Found");
		}
		if(!(notificationTemplate.getEffectiveFrom().isBefore(Instant.now()) && notificationTemplate.getEffectiveTo().isAfter(Instant.now()))) {
			throw new DataNotFoundException("Template Expired");
		}
		Map<String , String> templateData = downloadNotificationTemplateDto.getNotificationData();
		notificationTemplate.setTemplateBody(new MergePlaceHolder().replacePlaceholders(templateData,notificationTemplate.getTemplateBody()));
		NotificationTemplateFileDto notificationTemplateFileDto = modelMapper.map(notificationTemplate, NotificationTemplateFileDto.class);
		return notificationTemplateFileDto;
	}

	
	
	

	
}

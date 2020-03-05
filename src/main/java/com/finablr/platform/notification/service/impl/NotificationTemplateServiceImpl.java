package com.finablr.platform.notification.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.finablr.platform.notification.domain.NotificationTemplate;
import com.finablr.platform.notification.dto.DownloadNotificationTemplateDto;
import com.finablr.platform.notification.dto.GetAllNotificationTemplatesDto;
import com.finablr.platform.notification.dto.NotificationTemplateFileDto;
import com.finablr.platform.notification.exceptionhandler.model.DataNotFoundException;
import com.finablr.platform.notification.repository.NotificationTemplateRepository;
import com.finablr.platform.notification.service.NotificationTemplateService;

public class NotificationTemplateServiceImpl implements NotificationTemplateService{
	
	@Autowired
	NotificationTemplateRepository notificationTemplateRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
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
		Iterator<NotificationTemplate> notificationTemplatesIterator = notificationTemplates.iterator();
		List<GetAllNotificationTemplatesDto> getAllNotificationTemplatesDtos = null;
		while(notificationTemplatesIterator.hasNext()) {
			getAllNotificationTemplatesDtos.add(new GetAllNotificationTemplatesDto(notificationTemplatesIterator.next()));	
		}
		Page<GetAllNotificationTemplatesDto> notificationTemplatesPage = new PageImpl<>(getAllNotificationTemplatesDtos);
		return notificationTemplatesPage;
	}

	@Override
	public NotificationTemplateFileDto downloadNotificationTemplateFile(
			DownloadNotificationTemplateDto downloadNotificationTemplateDto) {
		NotificationTemplate notificationTemplate = notificationTemplateRepository.findById(downloadNotificationTemplateDto.getId()).get();
		if(notificationTemplate == null) {
			throw new DataNotFoundException("Template Not Found");
		}
		
		Map<String , String> templateData = downloadNotificationTemplateDto.getNotificationData();
		for(String key : templateData.keySet()) {
			notificationTemplate.getTemplateBody().replaceAll("{{"+key+"}}", templateData.get(key));
		}
		NotificationTemplateFileDto notificationTemplateFileDto = modelMapper.map(notificationTemplate, NotificationTemplateFileDto.class);
		return notificationTemplateFileDto;
	}
	
}

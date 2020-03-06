package com.finablr.platform.notification.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.finablr.platform.notification.domain.NotificationTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.finablr.platform.notification.dto.GetAllNotificationTemplatesDto;
import com.finablr.platform.notification.exceptionhandler.model.DataNotFoundException;
import com.finablr.platform.notification.repository.NotificationChannelRepository;
import com.finablr.platform.notification.repository.NotificationContentTypeRepository;

import com.finablr.platform.notification.repository.NotificationTemplateRepository;
import com.finablr.platform.notification.service.NotificationTemplateService;

@Service
public class NotificationTemplateServiceImpl implements NotificationTemplateService {

	@Autowired
	public NotificationTemplateRepository notificationTemplateRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	NotificationChannelRepository notificationChannelRepository;
	
	@Autowired
	NotificationContentTypeRepository notificationContentTypeRepository;
	
	
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
}

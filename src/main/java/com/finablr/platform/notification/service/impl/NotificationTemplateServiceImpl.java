package com.finablr.platform.notification.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.finablr.platform.notification.domain.NotificationTemplate;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.finablr.platform.notification.dto.GetAllNotificationTemplatesDto;
import com.finablr.platform.notification.exceptionhandler.model.DataNotFoundException;
import com.finablr.platform.notification.repository.NotificationTemplateRepository;
import com.finablr.platform.notification.service.NotificationTemplateService;

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
		List<GetAllNotificationTemplatesDto> getAllNotificationTemplatesDtos = new ArrayList<GetAllNotificationTemplatesDto>();
		modelMapper.map(notificationTemplates.getContent(), getAllNotificationTemplatesDtos );
		if(notificationTemplates.getContent().isEmpty()) {
			throw new DataNotFoundException("No templates Found");
		}
		Page<GetAllNotificationTemplatesDto> notificationTemplatesPage = new PageImpl<>(
				getAllNotificationTemplatesDtos);
		return notificationTemplatesPage;
	}

}

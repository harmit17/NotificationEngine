package com.finablr.platform.notification.service.impl;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;

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
		Page<GetAllNotificationTemplatesDto> notificationTemplatePages = notificationTemplates
				.map(notificationTemplate -> {
					GetAllNotificationTemplatesDto getAllNotificationTemplatesDto = new GetAllNotificationTemplatesDto();
					modelMapper.map(notificationTemplate, getAllNotificationTemplatesDto);
					return getAllNotificationTemplatesDto;
				});
		return notificationTemplatePages;
	}

	@Override
	public NotificationTemplateFileDto downloadNotificationTemplateFile(
			DownloadNotificationTemplateDto downloadNotificationTemplateDto) {
		Optional<NotificationTemplate> notificationTemplate;
		notificationTemplate = notificationTemplateRepository.findById(downloadNotificationTemplateDto.getId());
		if (notificationTemplate.isPresent()) {
			throw new DataNotFoundException("Template Not Found");
		}

		if (!(notificationTemplate.get().getEffectiveFrom().isBefore(Instant.now())
				&& notificationTemplate.get().getEffectiveTo().isAfter(Instant.now()))) {
			throw new DataNotFoundException("Template Expired");
		}
		Map<String, String> templateData = downloadNotificationTemplateDto.getNotificationData();
		notificationTemplate.get().setTemplateBody(
				new MergePlaceHolder().replacePlaceholders(templateData, notificationTemplate.get().getTemplateBody()));
		NotificationTemplateFileDto notificationTemplateFileDto = modelMapper.map(notificationTemplate,
				NotificationTemplateFileDto.class);
		return notificationTemplateFileDto;
	}

}

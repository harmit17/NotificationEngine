package com.finablr.platform.notification.service.impl;

import java.time.Instant;
import java.util.Map;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.finablr.platform.notification.domain.NotificationChannel;
import com.finablr.platform.notification.domain.NotificationContentType;
import com.finablr.platform.notification.domain.NotificationTemplate;

import com.finablr.platform.notification.dto.DownloadNotificationTemplateDto;
import com.finablr.platform.notification.dto.GetAllNotificationTemplatesDto;
import com.finablr.platform.notification.dto.NotificationTemplateFileDto;

import org.springframework.stereotype.Service;

import com.finablr.platform.notification.dto.AddNotificationTemplateDto;

import com.finablr.platform.notification.dto.UpdateNotificationTemplateDto;

import com.finablr.platform.notification.exceptionhandler.model.DataNotFoundException;
import com.finablr.platform.notification.repository.NotificationChannelRepository;
import com.finablr.platform.notification.repository.NotificationContentTypeRepository;

import com.finablr.platform.notification.repository.NotificationTemplateRepository;
import com.finablr.platform.notification.service.NotificationTemplateService;
import com.finablr.platform.notification.util.MergePlaceHolder;

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

	public void checkFutureDatesValidation(Instant effectiveFrom, Instant effectiveTo) {
		if ((effectiveFrom.isBefore(Instant.now()) || effectiveTo.isBefore(Instant.now()))) {
			throw new DataNotFoundException("Template Expired");
		}
	}

	public void checkToDateFromDateValidation(Instant effectiveFrom, Instant effectiveTo) {
		if (effectiveTo.isBefore(effectiveFrom)) {
			throw new DataNotFoundException("ToDate Should Be After FromDate");
		}
	}

	@Override
	public Long addNotificationTemplate(AddNotificationTemplateDto addNotificationTemplateDto) {

			Optional<NotificationChannel> notificationChannel = notificationChannelRepository.findById(addNotificationTemplateDto.getNotificationChannelId());
			Optional<NotificationContentType> notificationContentType = notificationContentTypeRepository.findById(addNotificationTemplateDto.getNotificationContentTypeId());
	
			if (!notificationChannel.isPresent()) 
			{
				throw new DataNotFoundException("Notification Channel is not Present for Given ID "+ addNotificationTemplateDto.getNotificationChannelId());
			}
	
			if (!notificationContentType.isPresent()) 
			{
				throw new DataNotFoundException("Notification Content Type is not Present for Given ID "+ addNotificationTemplateDto.getNotificationContentTypeId());
			}
	
			if (notificationChannel.get().isDisable()) 
			{
				throw new DataNotFoundException("NotificationChannel "+notificationChannel.get().getChannelName()+" Is Not enable");
	
			}
	
			if (notificationContentType.get().isDisable()) 
			{
				throw new DataNotFoundException("NotificationContentType "+notificationContentType.get().getName()+" Is Not enable");
			}
	
			checkFutureDatesValidation(addNotificationTemplateDto.getEffectiveFrom(),addNotificationTemplateDto.getEffectiveTo());
			
			checkToDateFromDateValidation(addNotificationTemplateDto.getEffectiveFrom(),addNotificationTemplateDto.getEffectiveTo());
	
			if (notificationTemplateRepository.findByTemplateCode(addNotificationTemplateDto.getTemplateCode()) != null) 
			{
				throw new DataNotFoundException("Template Code Already Exists");
			}
	
			if ((notificationChannel.get().getChannelName().equalsIgnoreCase("WhatsApp") && notificationContentType.get().getName().equalsIgnoreCase("html"))) 
			{
				throw new DataNotFoundException("Channel is not competable with content type");
			}
	
			NotificationTemplate notificationTemplate=new NotificationTemplate();
			notificationTemplate.setTemplateCode(addNotificationTemplateDto.getTemplateCode());
			notificationTemplate.setName(addNotificationTemplateDto.getName());
			notificationTemplate.setDescription(addNotificationTemplateDto.getDescription());
			notificationTemplate.setTemplateSubject(addNotificationTemplateDto.getTemplateSubject());
			notificationTemplate.setTemplateBody(addNotificationTemplateDto.getTemplateBody());
			notificationTemplate.setMaxRetry(addNotificationTemplateDto.getMaxRetry());
			notificationTemplate.setEffectiveFrom(addNotificationTemplateDto.getEffectiveFrom());
			notificationTemplate.setEffectiveTo(addNotificationTemplateDto.getEffectiveTo());
			notificationTemplate.setNotificationChannel(notificationChannel.get());
			notificationTemplate.setNotificationContentType(notificationContentType.get());
	
			return (notificationTemplateRepository.save(notificationTemplate)).getTemplateId();
	}

	@Override
	public Long updateNotificationTemplate(UpdateNotificationTemplateDto updateNotificationTemplateDto) {

			Optional<NotificationTemplate> notificationTemplate = notificationTemplateRepository.findById(updateNotificationTemplateDto.getTemplateId());
			if (!notificationTemplate.isPresent()) 
			{
				throw new DataNotFoundException("Template Not Found");
			}
	
			checkFutureDatesValidation(updateNotificationTemplateDto.getEffectiveFrom(),updateNotificationTemplateDto.getEffectiveTo());
			checkToDateFromDateValidation(updateNotificationTemplateDto.getEffectiveFrom(),updateNotificationTemplateDto.getEffectiveTo());
	
			notificationTemplate.get().setTemplateSubject(updateNotificationTemplateDto.getTemplateSubject());
			notificationTemplate.get().setTemplateBody(updateNotificationTemplateDto.getTemplateBody());
			notificationTemplate.get().setEffectiveFrom(updateNotificationTemplateDto.getEffectiveFrom());
			notificationTemplate.get().setEffectiveTo(updateNotificationTemplateDto.getEffectiveTo());
	
			notificationTemplateRepository.save(notificationTemplate.get());
			return notificationTemplate.get().getTemplateId();
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
		Instant current_time = Instant.now();
		notificationTemplate = notificationTemplateRepository.findById(downloadNotificationTemplateDto.getId());
		if (!notificationTemplate.isPresent()) {
			throw new DataNotFoundException("Template Not Found");
		}
		if (current_time.isAfter(notificationTemplate.get().getEffectiveTo())
				|| current_time.isBefore(notificationTemplate.get().getEffectiveFrom())) {
			throw new DataNotFoundException("Template Expired");
		}
		Map<String, String> templateData = downloadNotificationTemplateDto.getNotificationData();
		String templateBody = notificationTemplate.get().getTemplateBody();
		String templateSubject = notificationTemplate.get().getTemplateSubject();
		notificationTemplate.get()
				.setTemplateBody(MergePlaceHolder.replacePlaceholders(templateData, templateBody));
		notificationTemplate.get()
				.setTemplateSubject(MergePlaceHolder.replacePlaceholders(templateData, templateSubject));
		NotificationTemplateFileDto notificationTemplateFileDto = modelMapper.map(notificationTemplate.get(),
				NotificationTemplateFileDto.class);
		return notificationTemplateFileDto;

	}

}

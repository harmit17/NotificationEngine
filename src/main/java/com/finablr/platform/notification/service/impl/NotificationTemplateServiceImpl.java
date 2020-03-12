package com.finablr.platform.notification.service.impl;

import java.time.Instant;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.finablr.platform.notification.domain.NotificationTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.finablr.platform.notification.dto.AddNotificationTemplateDto;
import com.finablr.platform.notification.dto.GetAllNotificationTemplatesDto;
import com.finablr.platform.notification.dto.UpdateNotificationTemplateDto;
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

	@Override
	public Long addNotificationTemplate(AddNotificationTemplateDto addNotificationTemplateDto) {
		Long notificationChannelId=addNotificationTemplateDto.getNotificationChannelId();
		Long notificationContentTypeId=addNotificationTemplateDto.getNotificationContentTypeId();
		NotificationTemplate notificationTemplate = modelMapper.map(addNotificationTemplateDto,NotificationTemplate.class);
		if(!(notificationTemplate.getEffectiveFrom().isAfter(Instant.now()) && notificationTemplate.getEffectiveTo().isAfter(Instant.now()))) {
			throw new DataNotFoundException("Template Expired");
		}
		if(!(notificationTemplate.getEffectiveTo().isAfter(notificationTemplate.getEffectiveFrom())))
		{
			throw new DataNotFoundException("ToDate Should Be After FromDate");
		}
		if(notificationTemplateRepository.findByTemplateCode(addNotificationTemplateDto.getTemplateCode())!=null)
		{
			throw new DataNotFoundException("Template Code Already Exists");
		}
		notificationTemplate.setTemplateId(Long.valueOf(0));
		notificationTemplate.setNotificationChannel(notificationChannelRepository.findById(notificationChannelId).get());
		notificationTemplate.setNotificationContentType(notificationContentTypeRepository.findById(notificationContentTypeId).get());
		if(notificationTemplate.getNotificationChannel().getChannelName()==null||notificationTemplate.getNotificationContentType().getName()==null||(notificationTemplate.getNotificationChannel().isDisable()==true||notificationTemplate.getNotificationContentType().isDisable()==true))
		{
			throw new DataNotFoundException("NotificationChannelName or NotificationContentType Is Not found or NotificationChannelName or NotificationContentType Is Not enable");
		}
		if(!(notificationTemplate.getNotificationChannel().getChannelName().equals("WhatsApp") && notificationTemplate.getNotificationContentType().getName
				().equals("text"))){
					throw new DataNotFoundException("Channel is not competable with content type");
				}
		NotificationTemplate notificationTemplate1=notificationTemplateRepository.save(notificationTemplate);
		return notificationTemplate1.getTemplateId();
	}

	@Override
	public Long updateNotificationTemplate(UpdateNotificationTemplateDto updateNotificationTemplateDto) {
		NotificationTemplate notificationTemplate = modelMapper.map(updateNotificationTemplateDto,NotificationTemplate.class);
		try{
			notificationTemplate=notificationTemplateRepository.findById(updateNotificationTemplateDto.getTemplateId()).get();
		}
		catch(Exception e){
			throw new DataNotFoundException("Template Not Found");
		}
		notificationTemplate.setTemplateSubject(updateNotificationTemplateDto.getTemplateSubject());
		notificationTemplate.setTemplateBody(updateNotificationTemplateDto.getTemplateBody());
		notificationTemplate.setEffectiveFrom(updateNotificationTemplateDto.getEffectiveFrom());
		notificationTemplate.setEffectiveTo(updateNotificationTemplateDto.getEffectiveTo());
		if(!(notificationTemplate.getEffectiveFrom().isAfter(Instant.now()) && notificationTemplate.getEffectiveTo().isAfter(Instant.now()))) {
			throw new DataNotFoundException("Template Expired");
		}
		if(!(notificationTemplate.getEffectiveTo().isAfter(notificationTemplate.getEffectiveFrom())))
		{
			throw new DataNotFoundException("ToDate Should Be After FromDate");
		}
		notificationTemplateRepository.save(notificationTemplate);
		return notificationTemplate.getTemplateId();
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

}

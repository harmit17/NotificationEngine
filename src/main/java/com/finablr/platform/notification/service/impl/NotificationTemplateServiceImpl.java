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
		Long d=addNotificationTemplateDto.getNotificationChannelId();
		Long e=addNotificationTemplateDto.getNotificationContentTypeId();
		NotificationTemplate notificationTemplate = modelMapper.map(addNotificationTemplateDto,NotificationTemplate.class);
		if(!(notificationTemplate.getEffectiveForm().isAfter(Instant.now()) && notificationTemplate.getEffectiveTo().isAfter(Instant.now()))) {
			throw new DataNotFoundException("Template Expired");
		}
		if(notificationTemplateRepository.findByTemplateCode(addNotificationTemplateDto.getTemplateCode())!=null)
		{
			throw new DataNotFoundException("Template Code Already Exists");
		}
		notificationTemplate.setTemplateId(Long.valueOf(0));
		notificationTemplate.setNotificationChannel(notificationChannelRepository.findById(d).get());
		notificationTemplate.setNotificationContentType(notificationContentTypeRepository.findById(e).get());
		if(notificationTemplate.getNotificationChannel().getChannelName()==null||notificationTemplate.getNotificationContentType().getName()==null)
		{
			throw new DataNotFoundException("NotificationChannelName or NotificationContentType Is Not found");
		}
		if(!(notificationTemplate.getNotificationChannel().isDisable()==false||notificationTemplate.getNotificationContentType().isDisable()==false))
		{
			throw new DataNotFoundException("NotificationChannelName or NotificationContentType Is Not enable"); 
		}
		if(!(notificationTemplate.getNotificationChannel().getChannelName().equals("WhatsApp") && notificationTemplate.getNotificationContentType().getName
				().equals("text"))){
					throw new DataNotFoundException("Channel is not competable with content type");
				}
		notificationTemplateRepository.save(notificationTemplate);
		System.out.println(notificationTemplate.getTemplateId());
		NotificationTemplate notificationTemplate1=notificationTemplateRepository.findByTemplateCode(addNotificationTemplateDto.getTemplateCode());
		return notificationTemplate1.getTemplateId();
	}

	@Override
	public Long updateNotificationTemplate(UpdateNotificationTemplateDto updateNotificationTemplateDto) {
		try{
			notificationTemplateRepository.findById(updateNotificationTemplateDto.getTemplateId()).get();
		}
		catch(Exception e){
			throw new DataNotFoundException("Template Not Found");
		}
		NotificationTemplate notificationTemplate = modelMapper.map(updateNotificationTemplateDto,NotificationTemplate.class);
		notificationTemplate=notificationTemplateRepository.findById(updateNotificationTemplateDto.getTemplateId()).get();
		notificationTemplate.setTemplateSubject(updateNotificationTemplateDto.getTemplateSubject());
		notificationTemplate.setTemplateBody(updateNotificationTemplateDto.getTemplateBody());
		notificationTemplate.setEffectiveForm(updateNotificationTemplateDto.getEffectiveForm());
		notificationTemplate.setEffectiveTo(updateNotificationTemplateDto.getEffectiveTo());
		if(!(notificationTemplate.getEffectiveForm().isAfter(Instant.now()) && notificationTemplate.getEffectiveTo().isAfter(Instant.now()))) {
			throw new DataNotFoundException("Template Expired");
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

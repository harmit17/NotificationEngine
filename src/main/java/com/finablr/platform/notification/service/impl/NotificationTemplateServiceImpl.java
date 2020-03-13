package com.finablr.platform.notification.service.impl;

import java.time.Instant;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.finablr.platform.notification.domain.NotificationChannel;
import com.finablr.platform.notification.domain.NotificationContentType;
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
	
	public void checkFutureDatesValidation(Instant effectiveFrom,Instant effectiveTo)
	{
		if((effectiveFrom.isBefore(Instant.now()) || effectiveTo.isBefore(Instant.now()))) 
		{
			throw new DataNotFoundException("Template Expired");
		}
	}
	
	public void checkToDateFromDateValidation(Instant effectiveFrom,Instant effectiveTo)
	{
		if(effectiveTo.isBefore(effectiveFrom)) 
		{
			throw new DataNotFoundException("ToDate Should Be After FromDate");
		}
	}
	
	@Override
	public Long addNotificationTemplate(AddNotificationTemplateDto addNotificationTemplateDto) {
		
		Optional<NotificationChannel> notificationChannel = notificationChannelRepository.findById(addNotificationTemplateDto.getNotificationChannelId());
		Optional<NotificationContentType> notificationContentType=notificationContentTypeRepository.findById(addNotificationTemplateDto.getNotificationContentTypeId());
		
		if(!notificationChannel.isPresent())
		{
			throw new DataNotFoundException("Notification Channel is not Present for Given ID "+addNotificationTemplateDto.getNotificationChannelId());
		}
		
		if(!notificationContentType.isPresent())
		{
			throw new DataNotFoundException("Notification Content Type is not Present for Given ID "+addNotificationTemplateDto.getNotificationContentTypeId());
		}
		
		if(notificationChannel.get().isDisable())
		{
			throw new DataNotFoundException("NotificationChannelName Is Not enable");
			
		}
		
		if(notificationContentType.get().isDisable())
		{
			throw new DataNotFoundException("NotificationContentType Is Not enable");
		}
		
		checkFutureDatesValidation(addNotificationTemplateDto.getEffectiveFrom(), addNotificationTemplateDto.getEffectiveTo());
		
		checkToDateFromDateValidation(addNotificationTemplateDto.getEffectiveFrom(), addNotificationTemplateDto.getEffectiveTo());
		
		if(notificationTemplateRepository.findByTemplateCode(addNotificationTemplateDto.getTemplateCode())!=null)
		{
			throw new DataNotFoundException("Template Code Already Exists");
		}
		
		if((notificationChannel.get().getChannelName().equalsIgnoreCase("WhatsApp") && notificationContentType.get().getName().equalsIgnoreCase("html")))
		{
					throw new DataNotFoundException("Channel is not competable with content type");
		}
		
		NotificationTemplate notificationTemplate = modelMapper.map(addNotificationTemplateDto,NotificationTemplate.class);
		notificationTemplate.setTemplateId(Long.valueOf(0));
		notificationTemplate.setNotificationChannel(notificationChannel.get());
		notificationTemplate.setNotificationContentType(notificationContentType.get());
		
		NotificationTemplate notificationTemplate1=notificationTemplateRepository.save(notificationTemplate);
		return notificationTemplate1.getTemplateId();
	}

	@Override
	public Long updateNotificationTemplate(UpdateNotificationTemplateDto updateNotificationTemplateDto) {
		
		Optional<NotificationTemplate> notificationTemplate = notificationTemplateRepository.findById(updateNotificationTemplateDto.getTemplateId());
		if(!notificationTemplate.isPresent())
		{
			throw new DataNotFoundException("Template Not Found");
		}
		
		checkFutureDatesValidation(updateNotificationTemplateDto.getEffectiveFrom(), updateNotificationTemplateDto.getEffectiveTo());
		checkToDateFromDateValidation(updateNotificationTemplateDto.getEffectiveFrom(), updateNotificationTemplateDto.getEffectiveTo());
		
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
		Page<GetAllNotificationTemplatesDto> notificationTemplatePages = notificationTemplates.map(notificationTemplate -> {
			GetAllNotificationTemplatesDto getAllNotificationTemplatesDto = new GetAllNotificationTemplatesDto();
			modelMapper.map(notificationTemplate, getAllNotificationTemplatesDto);
			return getAllNotificationTemplatesDto;
		});
		return notificationTemplatePages;
	}	

}

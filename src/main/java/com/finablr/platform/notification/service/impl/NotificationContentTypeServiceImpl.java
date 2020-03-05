package com.finablr.platform.notification.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.Filter;

import org.modelmapper.Converters.Collection;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finablr.platform.notification.domain.NotificationContentType;
import com.finablr.platform.notification.dto.GetNotificationContentTypeDto;
import com.finablr.platform.notification.exceptionhandler.model.DataNotFoundException;
import com.finablr.platform.notification.repository.NotificationContentTypeRepository;
import com.finablr.platform.notification.service.NotificationContentTypeService;

@Service
public class NotificationContentTypeServiceImpl implements NotificationContentTypeService {

	@Autowired
	NotificationContentTypeRepository notificationContentTypeRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<GetNotificationContentTypeDto> getAllNotificationContentType() {

		List<NotificationContentType> notificationContentTypes = notificationContentTypeRepository.findAll();
		if (notificationContentTypes.isEmpty())
			throw new DataNotFoundException("No Content types available");

		return notificationContentTypes.stream().map(entity -> {
			GetNotificationContentTypeDto dto = new GetNotificationContentTypeDto();
			modelMapper.map(entity, dto);
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public GetNotificationContentTypeDto toggleNotificationContentType(Long id) {

		Optional<NotificationContentType> notificationContentTypeOptional = notificationContentTypeRepository
				.findById(id);
		if (notificationContentTypeOptional.isPresent()) {

			notificationContentTypeOptional.get().setDisable(!notificationContentTypeOptional.get().isDisable());
			notificationContentTypeRepository.save(notificationContentTypeOptional.get());

			return modelMapper.map(notificationContentTypeOptional.get(), GetNotificationContentTypeDto.class);
		}
		throw new DataNotFoundException("Notification Content Type not found with " + id);
	}

}

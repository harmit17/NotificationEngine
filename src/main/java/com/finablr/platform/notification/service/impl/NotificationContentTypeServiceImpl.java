package com.finablr.platform.notification.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finablr.platform.notification.domain.NotificationContentType;
import com.finablr.platform.notification.repository.NotificationContentTypeRepository;
import com.finablr.platform.notification.service.NotificationContentTypeService;

@Service
public class NotificationContentTypeServiceImpl implements NotificationContentTypeService {

	@Autowired
	public NotificationContentTypeRepository notificationContentTypeRepository;

	@Override
	public List<NotificationContentType> getAllNotificationContentType() {
		// TODO Auto-generated method stub
		return notificationContentTypeRepository.findAll();
	}

	@Override
	public NotificationContentType toggleNotificationContentType(Long id) {
		// TODO Auto-generated method stub
		Optional<NotificationContentType> notifiOptional = notificationContentTypeRepository.findById(id);
		if (notifiOptional.isPresent()) {
			return notifiOptional.get();
		}
		// EXception
		return null;
	}

}

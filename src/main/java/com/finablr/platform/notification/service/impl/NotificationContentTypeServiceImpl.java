package com.finablr.platform.notification.service.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finablr.platform.notification.domain.NotificationContentType;
import com.finablr.platform.notification.dto.GetNotificationContentTypeDto;
import com.finablr.platform.notification.repository.NotificationContentTypeRepository;
import com.finablr.platform.notification.service.NotificationContentTypeService;

@Service
public class NotificationContentTypeServiceImpl implements NotificationContentTypeService {

	@Autowired
	NotificationContentTypeRepository notificationContentTypeRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<GetNotificationContentTypeDto> getAllNotificationContentType(){
		List<NotificationContentType> notificationContentTypes = notificationContentTypeRepository.findAll();
		List<GetNotificationContentTypeDto> getNotificationContentTypeDtos = new ArrayList<GetNotificationContentTypeDto>();
		
		Iterator<NotificationContentType> notiIterator = notificationContentTypes.iterator();
		while(notiIterator.hasNext()) {
			getNotificationContentTypeDtos.add(modelMapper.map(notiIterator.next(),GetNotificationContentTypeDto.class));
		}
		return getNotificationContentTypeDtos;
	}
	
	@Override
	public GetNotificationContentTypeDto toggleNotificationContentType(Long id) {
		// TODO Auto-generated method stub
		Optional<NotificationContentType> notificationContentTypeOptional = notificationContentTypeRepository.findById(id);
		
		if (notificationContentTypeOptional.isPresent()) {
			
			if(notificationContentTypeOptional.get().isDisable() == true)
			{
				notificationContentTypeOptional.get().setDisable(false);
			}
			else
			{
				notificationContentTypeOptional.get().setDisable(true);
			}
			notificationContentTypeRepository.save(notificationContentTypeOptional.get());
			return modelMapper.map(notificationContentTypeOptional.get(),GetNotificationContentTypeDto.class);
		}
		// EXception
		return null;
	}

}

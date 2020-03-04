package com.finablr.platform.notification.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finablr.platform.notification.domain.NotificationChannel;
import com.finablr.platform.notification.dto.NotificationChannelDto;
import com.finablr.platform.notification.repository.NotificationChannelRepository;
import com.finablr.platform.notification.service.NotificationChannelService;

@Service
public class NotificationChannelServiceImpl implements NotificationChannelService {

	@Autowired
	public NotificationChannelRepository notificationChannelRepository;

	public NotificationChannelDto channelDto;
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<NotificationChannelDto> getAllChannels() {

		/*
		 * findAll() method will give data in List Iterator is used to iterate
		 * NotificationChannel(Entity) List and add in NotificationChannel(Dto) list
		 */
		List<NotificationChannel> notificationChannel = notificationChannelRepository.findAll();
		List<NotificationChannelDto> channelDto = new ArrayList<NotificationChannelDto>();

		Iterator<NotificationChannel> channelItr = notificationChannel.iterator();
		while (channelItr.hasNext()) {

			channelDto.add(modelMapper.map(channelItr.next(), NotificationChannelDto.class));
		}
		return channelDto;
	}

	@Override
	public NotificationChannelDto toggleChannelStatus(Long id) {

		Optional<NotificationChannel> channelOptional = notificationChannelRepository.findById(id);
		if (channelOptional.isPresent()) {

			if (channelOptional.get().isDisable() == true)
				channelOptional.get().setDisable(false);
			else
				channelOptional.get().setDisable(true);

			notificationChannelRepository.save(channelOptional.get());

			return modelMapper.map(channelOptional.get(), NotificationChannelDto.class);
		}
		return null;
	}
}

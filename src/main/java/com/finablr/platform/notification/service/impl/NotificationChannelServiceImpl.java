package com.finablr.platform.notification.service.impl;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finablr.platform.notification.domain.NotificationChannel;
import com.finablr.platform.notification.dto.NotificationChannelDto;
import com.finablr.platform.notification.exceptionhandler.model.DataNotFoundException;
import com.finablr.platform.notification.repository.NotificationChannelRepository;
import com.finablr.platform.notification.service.NotificationChannelService;

@Service
public class NotificationChannelServiceImpl implements NotificationChannelService {

	@Autowired
	public NotificationChannelRepository notificationChannelRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<NotificationChannelDto> getAllChannels() {

		List<NotificationChannel> notificationChannel = notificationChannelRepository.findAll();
		if (notificationChannel.isEmpty())
			throw new DataNotFoundException("No Data found");

		List<NotificationChannelDto> channelDto = notificationChannel.stream().map(channelEntity -> {
			NotificationChannelDto dto = new NotificationChannelDto();
			modelMapper.map(channelEntity, dto);
			return dto;
		}).collect(Collectors.toList());

		return channelDto;
	}

	@Override
	public NotificationChannelDto toggleChannelStatus(Long id) {

		Optional<NotificationChannel> channelOptional = notificationChannelRepository.findById(id);
		if (channelOptional.isPresent()) {

			channelOptional.get().setDisable(!channelOptional.get().isDisable());
			notificationChannelRepository.save(channelOptional.get());

			return modelMapper.map(channelOptional.get(), NotificationChannelDto.class);
		}
		throw new DataNotFoundException("No Data Found");
	}
}

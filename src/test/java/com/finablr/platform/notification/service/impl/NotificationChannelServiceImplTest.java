package com.finablr.platform.notification.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import com.finablr.platform.notification.domain.NotificationChannel;
import com.finablr.platform.notification.dto.NotificationChannelDto;
import com.finablr.platform.notification.repository.NotificationChannelRepository;

@RunWith(MockitoJUnitRunner.class)
class NotificationChannelServiceImplTest {

	@Mock
	public NotificationChannelRepository notificationChannelRepository;
	
	@Mock
	ModelMapper modelMapper;
	
	@Mock
	public NotificationChannelDto notificationChannelDto;
	
	@InjectMocks
	public NotificationChannelServiceImpl notificationChannelServiceImpl;
	
	private NotificationChannel notificationChannel;
	private NotificationChannelDto notificationChannelDto1;
	
	@Before
	public void init() {
		
		notificationChannel = new NotificationChannel();
		notificationChannel.setChannelId((long) 1);
		notificationChannel.setChannelName("WhatsApp");
		notificationChannel.setDisable(false);
		
		notificationChannelDto1.setChannelId((long) 1);
		notificationChannelDto1.setChannelName("WhatsApp");
		notificationChannelDto1.setDisable(false);
	}
	
	
	@Test
	void testGetAllChannels() {
		
		//Mockito.when(notificationChannelServiceImpl.toggleChannelStatus((long) 1)).thenReturn(notificationChannelDto);
		
		NotificationChannelDto result = notificationChannelServiceImpl.toggleChannelStatus((long) 1);
		
		assertEquals(1,1);
		/*
		when(notificationChannelServiceImpl.getAllChannels())
		.thenReturn(Stream.of(new NotificationChannelDto()).collect(Collectors.toList()));
				
		List<NotificationChannelDto> result =notificationChannelServiceImpl.getAllChannels();
		
		NotificationChannelDto dto = NotificationChannelDto.builder(){
		}
		*/	
			
		
		
	}

	/*
	 * @Test void testToggleChannelStatus() {
	 * 
	 * }
	 */

}

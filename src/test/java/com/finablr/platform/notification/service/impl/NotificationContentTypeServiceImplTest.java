package com.finablr.platform.notification.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.finablr.platform.notification.repository.NotificationContentTypeRepository;

@RunWith(MockitoJUnitRunner.class)
public class NotificationContentTypeServiceImplTest {
	
	@InjectMocks
	private NotificationContentTypeServiceImpl notificationContentTypeServiceImpl;
	
	@Mock
	private NotificationContentTypeRepository notificationContentTypeRepository;
	
	
}

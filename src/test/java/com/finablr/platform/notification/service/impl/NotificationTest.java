package com.finablr.platform.notification.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.finablr.platform.notification.repository.NotificationRequestRepository;
import com.finablr.platform.notification.repository.NotificationTemplateRepository;

@RunWith(MockitoJUnitRunner.class)
public class NotificationTest {

	@InjectMocks
	public NotificationRequestServiceImpl notificationRequestsImpl;

	@Mock
	public NotificationRequestRepository notificationRequestRepository;

	@Mock
	public NotificationTemplateRepository notificationTemplateRepository;
	
	@Test
	public void test() {
		//when(methodCall)
	}
	
}

package com.finablr.platform.notification.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.finablr.platform.notification.domain.NotificationRequest;
import com.finablr.platform.notification.repository.NotificationTemplateRepository;

@RunWith(MockitoJUnitRunner.class)
class NotificationRequestImplTest {

	@InjectMocks
	private NotificationRequestImpl notificationRequestsImpl;

	@Mock
	private com.finablr.platform.notification.repository.NotificationRequestRepository NotificationRequestRepository;

	@Mock
	private NotificationTemplateRepository NotificationTemplateRepository;
	
	@Test
	void getRequestStatus() {
		Long id = 1l;
		NotificationRequest notificationRequest = new NotificationRequest();
		notificationRequest.setStatus("pending");
		when(NotificationRequestRepository.findById(id)).thenReturn(Optional.of(notificationRequest));
		String status = notificationRequestsImpl.getStatus(id);
		
		assertNotNull(status);
		assertEquals("pending", status);

	}
	
	@Test
	void AddNotificationRequest() {
		String TemplateCode = "Test";
		Map<String,String> NotificationData = new HashMap<String, String>();
		NotificationData.put("abc", "xyz");
		Map<String,String> receipientDetails = new HashMap<String, String>();
		receipientDetails.put("abc", "xyz");
		
		
		
	}

}

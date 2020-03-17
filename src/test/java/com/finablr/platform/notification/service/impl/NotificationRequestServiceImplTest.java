package com.finablr.platform.notification.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.finablr.platform.notification.domain.NotificationRequest;
import com.finablr.platform.notification.dto.AddNotificationRequestDto;
import com.finablr.platform.notification.enumStatus.NotificationStatus;
import com.finablr.platform.notification.repository.NotificationRequestRepository;
import com.finablr.platform.notification.repository.NotificationTemplateRepository;

@RunWith(MockitoJUnitRunner.class)
class NotificationRequestServiceImplTest {

	@InjectMocks
	private NotificationRequestServiceImpl notificationRequestsImpl;

	@Mock
	private NotificationRequestRepository notificationRequestRepository;

	@Mock
	private NotificationTemplateRepository notificationTemplateRepository;
	
//	@Mock
//	private NotificationStatus notificationStatus;
	
	@Test
	void getRequestStatus() {
		Long id = 1L;
		NotificationRequest notificationRequest = new NotificationRequest();
		notificationRequest.setId(1L);
		notificationRequest.setStatus(NotificationStatus.PENDING.name());
		when(notificationRequestRepository.findById(id)).thenReturn(Optional.of(null));
		String status = notificationRequestsImpl.getStatus(id);
		
		assertNotNull(status);
		//assertEquals("PENDING", status);
	}
	
	@Test
	void addNotificationRequest() {
		NotificationRequest notificationRequest = new NotificationRequest();
		AddNotificationRequestDto AddNotificationRequestDto = new AddNotificationRequestDto();
		when(notificationRequest.getId()).thenReturn(1l);
		Long id = notificationRequestsImpl.addRequest(AddNotificationRequestDto);
		
		assertEquals(1l, id);
	}

}

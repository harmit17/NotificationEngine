package com.finablr.platform.notification.service.impl;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.jms.core.JmsTemplate;

import com.finablr.platform.notification.domain.NotificationRequest;
import com.finablr.platform.notification.dto.AddNotificationRequestDto;
import com.finablr.platform.notification.enumStatus.NotificationStatus;
import com.finablr.platform.notification.repository.NotificationRequestRepository;
import com.finablr.platform.notification.repository.NotificationTemplateRepository;

@RunWith(MockitoJUnitRunner.class)
class NotificationRequestServiceImplTest {

	@InjectMocks
	public NotificationRequestServiceImpl notificationRequestsImpl;

	@Mock
	public NotificationRequestRepository notificationRequestRepository;

	@Mock
	public NotificationTemplateRepository notificationTemplateRepository;

	@Mock
	public ModelMapper modelmapper;

	@Mock
	public JmsTemplate jmsTemplate;

	@Test
	void getRequestStatus() {
		Long id = 1L;
		NotificationRequest notificationRequest = new NotificationRequest();
		notificationRequest.setId(1L);
		notificationRequest.setStatus(NotificationStatus.PENDING.name());
		Optional<NotificationRequest> notifiOptional = Optional.of(notificationRequest);
		
		when(notificationRequestRepository.findById(id)).thenReturn(notifiOptional);
		
		String status = notificationRequestsImpl.getStatus(id);

		// assertNotNull(status);
		//assertEquals("PENDING", status);
	}

	@Test
	void addNotificationRequest() {
		NotificationRequest notificationRequest = new NotificationRequest();
		AddNotificationRequestDto AddNotificationRequestDto = new AddNotificationRequestDto();
		when(notificationRequest.getId()).thenReturn(1l);
		Long id = notificationRequestsImpl.addRequest(AddNotificationRequestDto);

		//assertEquals(1l, id);
	}
	
	@Test
	public void test() {
		
	}

}

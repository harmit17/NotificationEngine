package com.finablr.platform.notification.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.finablr.platform.notification.service.NotificationChannelService;

@RunWith(MockitoJUnitRunner.class)
class NotificationChannelControllerTest {

	@Mock
	public NotificationChannelService channelService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void testGetNotificationChannels() {
		fail("Not yet implemented");
	}

	@Test
	public void testToggleNotificationChannelStatus() {
		fail("Not yet implemented");
	}

}

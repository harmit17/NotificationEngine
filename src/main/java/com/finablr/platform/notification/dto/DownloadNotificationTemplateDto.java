package com.finablr.platform.notification.dto;

import java.util.Map;

import javax.validation.constraints.NotNull;

public class DownloadNotificationTemplateDto {
	@NotNull
	private Long id;
	
	private Map<String, String> notificationData;

	public Map<String, String> getNotificationData() {
		return notificationData;
	}

	public void setNotificationData(Map<String, String> notificationData) {
		this.notificationData = notificationData;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

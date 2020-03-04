package com.finablr.platform.notification.dto;

import com.finablr.platform.notification.domain.NotificationContentType;

public class GetNotificationContentTypeDto {
	
	private Long id;
	private String name;
	private boolean isDisable;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isDisable() {
		return isDisable;
	}
	public void setDisable(boolean isDisable) {
		this.isDisable = isDisable;
	}
	
}

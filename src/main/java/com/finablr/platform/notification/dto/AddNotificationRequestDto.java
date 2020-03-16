package com.finablr.platform.notification.dto;

import java.util.Map;

import com.sun.istack.NotNull;

public class AddNotificationRequestDto {

	@NotNull
	private String templateCode;
	@NotNull
	private Map<String, String> notificationData;
	@NotNull
	private Map<String, String> receipientDetails;
	
	private Long id; 

	public Long getId() {
		return id;
	}

	public Map<String, String> getNotificationData() {
		return notificationData;
	}

	public void setNotificationData(Map<String, String> notificationData) {
		this.notificationData = notificationData;
	}

	public Map<String, String> getReceipientDetails() {
		return receipientDetails;
	}

	public void setReceipientDetails(Map<String, String> receipientDetails) {
		this.receipientDetails = receipientDetails;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}
}

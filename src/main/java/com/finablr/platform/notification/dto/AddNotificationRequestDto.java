package com.finablr.platform.notification.dto;

import java.util.Map;

public class AddNotificationRequestDto {
	
	private String templateCode;
	
	private Map<String,String> notificationData; 

	private Map<String,String> recieptionDetails;
	
	
	public Map<String, String> getNotificationData() {
		return notificationData;
	}
	public void setNotificationData(Map<String, String> notificationData) {
		this.notificationData = notificationData;
	}
	public Map<String, String> getRecieptionDetails() {
		return recieptionDetails;
	}
	public void setRecieptionDetails(Map<String, String> recieptionDetails) {
		this.recieptionDetails = recieptionDetails;
	}
	public String getTemplateCode() {
		return templateCode;
	}
	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}
	@Override
	public String toString() {
		return "AddNotificationRequestDto [templateCode=" + templateCode + ", notificationData=" + notificationData
				+ ", recieptionDetails=" + recieptionDetails + "]";
	}

	
	
	
}

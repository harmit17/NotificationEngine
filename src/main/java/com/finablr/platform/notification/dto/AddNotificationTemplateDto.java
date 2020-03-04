package com.finablr.platform.notification.dto;

import java.time.Instant;

import com.finablr.platform.notification.domain.NotificationChannel;
import com.finablr.platform.notification.domain.NotificationContentType;

public class AddNotificationTemplateDto {
	

	private String templateCode;
	private String name;
	private String description;
	private String templateSubject;
	private String templateBody;
	private Integer maxRetry;
	private Instant effectiveForm;
	private Instant effectiveTo;
	//private NotificationChannel notificationChannelId;
	//private NotificationContentType notificationContentTypeId;
	private Long notificationChannelId;
	private Long notificationContentType;
	
	public String getTemplateCode() {
		return templateCode;
	}
	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTemplateSubject() {
		return templateSubject;
	}
	public void setTemplateSubject(String templateSubject) {
		this.templateSubject = templateSubject;
	}
	public String getTemplateBody() {
		return templateBody;
	}
	public void setTemplateBody(String templateBody) {
		this.templateBody = templateBody;
	}
	public Integer getMaxRetry() {
		return maxRetry;
	}
	public void setMaxRetry(Integer maxRetry) {
		this.maxRetry = maxRetry;
	}
	public Instant getEffectiveForm() {
		return effectiveForm;
	}
	public void setEffectiveForm(Instant effectiveForm) {
		this.effectiveForm = effectiveForm;
	}
	public Instant getEffectiveTo() {
		return effectiveTo;
	}
	public void setEffectiveTo(Instant effectiveTo) {
		this.effectiveTo = effectiveTo;
	}
	public Long getNotificationChannelId() {
		return notificationChannelId;
	}
	public void setNotificationChannelId(Long notificationChannelId) {
		this.notificationChannelId = notificationChannelId;
	}
	public Long getNotificationContentType() {
		return notificationContentType;
	}
	public void setNotificationContentType(Long notificationContentType) {
		this.notificationContentType = notificationContentType;
	}

	
}

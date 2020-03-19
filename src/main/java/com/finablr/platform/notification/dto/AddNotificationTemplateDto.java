package com.finablr.platform.notification.dto;

import java.time.Instant;

import javax.validation.constraints.NotNull;

public class AddNotificationTemplateDto {
	
	@NotNull
	private String templateCode;
	@NotNull
	private String name;
	@NotNull
	private String description;
	@NotNull
	private String templateSubject;
	@NotNull
	private String templateBody;
	@NotNull
	private Integer maxRetry;
	@NotNull
	private Instant effectiveFrom;
	@NotNull
	private Instant effectiveTo;
//	private NotificationChannel notificationChannelId;
//	private NotificationContentType notificationContentTypeId;
	@NotNull
	private Long notificationChannelId;
	@NotNull
	private Long notificationContentTypeId;
	
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
	public Instant getEffectiveFrom() {
		return effectiveFrom;
	}
	public void setEffectiveFrom(Instant effectiveForm) {
		this.effectiveFrom = effectiveForm;
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
	public Long getNotificationContentTypeId() {
		return notificationContentTypeId;
	}
	public void setNotificationContentTypeId(Long notificationContentTypeId) {
		this.notificationContentTypeId = notificationContentTypeId;
	}


	
}

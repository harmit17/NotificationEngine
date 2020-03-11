package com.finablr.platform.notification.dto;

import java.time.Instant;

public class GetAllNotificationTemplatesDto {

	private Long templateId;

	private String templateCode;

	private String name;

	private String description;

	private String templateSubject;

	private String templateBody;

	private Integer maxRetry;

	private Instant effectiveFrom;

	private Instant effectiveTo;

	private Long notificationChannelId;

	private Long notificationContentTypeId;
	

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

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

	public void setEffectiveFrom(Instant effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
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

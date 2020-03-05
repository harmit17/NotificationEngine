package com.finablr.platform.notification.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="notification_template")
public class NotificationTemplate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long templateId;
	
	@Column(length = 50,nullable = false,unique = true)
	private String templateCode;
	
	@Column(length = 50,nullable = false)
	private String name;
	
	@Column(length = 255,nullable = false)
	private String description;
	
	@Column(length = 255,nullable = false)
	private String templateSubject;
	
	@Column(length = 1000,nullable = false)
	private String templateBody;
	
	@Column(precision=1, scale=0,nullable = false)
	private Integer maxRetry;
	
	@Column(nullable = false)
	private Instant effectiveForm;
	
	private Instant effectiveTo;
	
	@Column(nullable = false)
	private Long notificationChannelId;
	
	@Column(nullable = false)
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

	public Long getNotificationContentTypeId() {
		return notificationContentTypeId;
	}

	public void setNotificationContentTypeId(Long notificationContentTypeId) {
		this.notificationContentTypeId = notificationContentTypeId;
	}

			
}

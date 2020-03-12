package com.finablr.platform.notification.dto;

import java.time.Instant;

public class UpdateNotificationTemplateDto {
	
	private Long templateId;
	private String templateSubject;
	private String templateBody;
	private Instant effectiveFrom;
	private Instant effectiveTo;
	public Long getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
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
	public Instant getEffectiveFrom() {
		return effectiveFrom;
	}
	public void setEffectiveForm(Instant effectiveForm) {
		this.effectiveFrom = effectiveForm;
	}
	public Instant getEffectiveTo() {
		return effectiveTo;
	}
	public void setEffectiveTo(Instant effectiveTo) {
		this.effectiveTo = effectiveTo;
	}	

}

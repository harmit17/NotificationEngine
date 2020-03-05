package com.finablr.platform.notification.dto;

import java.time.Instant;

public class UpdateNotificationTemplateDto {
	
	private Long templateId;
	private String templateSubject;
	private String templateBody;
	private Instant effectiveForm;
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

}

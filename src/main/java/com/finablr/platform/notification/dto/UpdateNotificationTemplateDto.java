package com.finablr.platform.notification.dto;

import java.time.Instant;

import javax.validation.constraints.NotNull;

public class UpdateNotificationTemplateDto {
	
	@NotNull
	private Long templateId;
	@NotNull
	private String templateSubject;
	@NotNull
	private String templateBody;
	@NotNull
	private Instant effectiveFrom;
	@NotNull
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

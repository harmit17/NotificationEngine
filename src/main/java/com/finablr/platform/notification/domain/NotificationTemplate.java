package com.finablr.platform.notification.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	private Instant effectiveForm;
	
	private Instant effectiveTo;
	
	@Column(nullable = false)
	private Long notificationChannelId;
	
	@Column(nullable = false)
	private Long notificationContentTypeId;
}

package com.finablr.platform.notification.domain;

import java.time.Instant;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "notification_request")
public class NotificationRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Map<String, String> notificationData;
	
	@Column(nullable = false)
	private Map<String, String> receipientDetails;
	
	@Column(nullable = false)
	private Integer retryCount;
	
	private String notificationSubject;
	
	private String notificationBody;
	
	@Column(nullable = false)
	private String status;
	
	private Instant lastDeliveryAttempt;
	
	private Instant requestTime;
	
	@Column(nullable = false)
	private Long notificationTemplateId;

	
}

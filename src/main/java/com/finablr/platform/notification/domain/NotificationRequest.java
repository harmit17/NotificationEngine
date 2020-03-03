package com.finablr.platform.notification.domain;

import java.time.Instant;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

<<<<<<< HEAD

=======
>>>>>>> Dto package created
@Entity
@Table(name = "notification_request")
public class NotificationRequest {

	@Id
	@Column(name = "request_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "notification_data",nullable = false)
	@ElementCollection
	private Map<String, String> notificationData;

	@Column(name = "receipient_details",nullable = false)
	@ElementCollection
	private Map<String, String> receipientDetails;

	@Column(name = "retry_count",nullable = false)
	private Integer retryCount;

	@Column(name = "notification_subject")
	private String notificationSubject;

	@Column(name = "notification_body")
	private String notificationBody;

	@Column(name = "request_status",nullable = false)
	private String status;

	@Column(name = "last_delivert_attempt")
	private Instant lastDeliveryAttempt;

	@Column(name = "request_time")
	private Instant requestTime;

	//@ManyToOne
    //@JoinColumn(name="notification_template_id",nullable = false)
	private Long notificationTemplateId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<String, String> getNotificationData() {
		return notificationData;
	}

	public void setNotificationData(Map<String, String> notificationData) {
		this.notificationData = notificationData;
	}

	public Map<String, String> getReceipientDetails() {
		return receipientDetails;
	}

	public void setReceipientDetails(Map<String, String> receipientDetails) {
		this.receipientDetails = receipientDetails;
	}

	public Integer getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
	}

	public String getNotificationSubject() {
		return notificationSubject;
	}

	public void setNotificationSubject(String notificationSubject) {
		this.notificationSubject = notificationSubject;
	}

	public String getNotificationBody() {
		return notificationBody;
	}

	public void setNotificationBody(String notificationBody) {
		this.notificationBody = notificationBody;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Instant getLastDeliveryAttempt() {
		return lastDeliveryAttempt;
	}

	public void setLastDeliveryAttempt(Instant lastDeliveryAttempt) {
		this.lastDeliveryAttempt = lastDeliveryAttempt;
	}

	public Instant getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Instant requestTime) {
		this.requestTime = requestTime;
	}

	public Long getNotificationTemplateId() {
		return notificationTemplateId;
	}

	public void setNotificationTemplateId(Long notificationTemplateId) {
		this.notificationTemplateId = notificationTemplateId;
	}
	
	

}

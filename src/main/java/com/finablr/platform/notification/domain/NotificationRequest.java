package com.finablr.platform.notification.domain;

import java.time.Instant;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the notificationData
	 */
	public Map<Integer, String> getNotificationData() {
		return notificationData;
	}

	/**
	 * @param notificationData the notificationData to set
	 */
	public void setNotificationData(Map<Integer, String> notificationData) {
		this.notificationData = notificationData;
	}

	/**
	 * @return the receipientDetails
	 */
	public Map<Integer, String> getReceipientDetails() {
		return receipientDetails;
	}

	/**
	 * @param receipientDetails the receipientDetails to set
	 */
	public void setReceipientDetails(Map<Integer, String> receipientDetails) {
		this.receipientDetails = receipientDetails;
	}

	/**
	 * @return the retryCount
	 */
	public Integer getRetryCount() {
		return retryCount;
	}

	/**
	 * @param retryCount the retryCount to set
	 */
	public void setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
	}

	/**
	 * @return the notificationSubject
	 */
	public String getNotificationSubject() {
		return notificationSubject;
	}

	/**
	 * @param notificationSubject the notificationSubject to set
	 */
	public void setNotificationSubject(String notificationSubject) {
		this.notificationSubject = notificationSubject;
	}

	/**
	 * @return the notificationBody
	 */
	public String getNotificationBody() {
		return notificationBody;
	}

	/**
	 * @param notificationBody the notificationBody to set
	 */
	public void setNotificationBody(String notificationBody) {
		this.notificationBody = notificationBody;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the lastDeliveryAttempt
	 */
	public Instant getLastDeliveryAttempt() {
		return lastDeliveryAttempt;
	}

	/**
	 * @param lastDeliveryAttempt the lastDeliveryAttempt to set
	 */
	public void setLastDeliveryAttempt(Instant lastDeliveryAttempt) {
		this.lastDeliveryAttempt = lastDeliveryAttempt;
	}

	/**
	 * @return the requestTime
	 */
	public Instant getRequestTime() {
		return requestTime;
	}

	/**
	 * @param requestTime the requestTime to set
	 */
	public void setRequestTime(Instant requestTime) {
		this.requestTime = requestTime;
	}

	/**
	 * @return the notificationTemplateId
	 */
	public Long getNotificationTemplateId() {
		return notificationTemplateId;
	}

	/**
	 * @param notificationTemplateId the notificationTemplateId to set
	 */
	public void setNotificationTemplateId(Long notificationTemplateId) {
		this.notificationTemplateId = notificationTemplateId;
	}
	
	
	
	
}

package com.finablr.platform.notification.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "notification_request")
public class NotificationRequest {
	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NonNull
	private String notificationData;
	@NonNull
	private String receipientDetails;
	@NonNull
	private int retryCount;
	@NonNull
	private String notificationSubject;
	@NonNull
	private String notificationBody;
	@NonNull
	private String status;
	@NonNull
	private Date lastDeliveryAttempt;
	@NonNull
	private Date requestTime;
	@NonNull
	private long notificationTemplateId;
	
	
	/*
	 * generated constructor using fields
	 */
	public NotificationRequest(long id, String notificationData, String receipientDetails, int retryCount,
			String notificationSubject, String notificationBody, String status, Date lastDeliveryAttempt,
			Date requestTime, long notificationTemplateId) {
		//super();
		this.id = id;
		this.notificationData = notificationData;
		this.receipientDetails = receipientDetails;
		this.retryCount = retryCount;
		this.notificationSubject = notificationSubject;
		this.notificationBody = notificationBody;
		this.status = status;
		this.lastDeliveryAttempt = lastDeliveryAttempt;
		this.requestTime = requestTime;
		this.notificationTemplateId = notificationTemplateId;
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}


	/**
	 * @return the notificationData
	 */
	public String getNotificationData() {
		return notificationData;
	}


	/**
	 * @param notificationData the notificationData to set
	 */
	public void setNotificationData(String notificationData) {
		this.notificationData = notificationData;
	}


	/**
	 * @return the receipientDetails
	 */
	public String getReceipientDetails() {
		return receipientDetails;
	}


	/**
	 * @param receipientDetails the receipientDetails to set
	 */
	public void setReceipientDetails(String receipientDetails) {
		this.receipientDetails = receipientDetails;
	}


	/**
	 * @return the retryCount
	 */
	public int getRetryCount() {
		return retryCount;
	}


	/**
	 * @param retryCount the retryCount to set
	 */
	public void setRetryCount(int retryCount) {
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
	public Date getLastDeliveryAttempt() {
		return lastDeliveryAttempt;
	}


	/**
	 * @param lastDeliveryAttempt the lastDeliveryAttempt to set
	 */
	public void setLastDeliveryAttempt(Date lastDeliveryAttempt) {
		this.lastDeliveryAttempt = lastDeliveryAttempt;
	}


	/**
	 * @return the requestTime
	 */
	public Date getRequestTime() {
		return requestTime;
	}


	/**
	 * @param requestTime the requestTime to set
	 */
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}


	/**
	 * @return the notificationTemplateId
	 */
	public long getNotificationTemplateId() {
		return notificationTemplateId;
	}


	/**
	 * @param notificationTemplateId the notificationTemplateId to set
	 */
	public void setNotificationTemplateId(long notificationTemplateId) {
		this.notificationTemplateId = notificationTemplateId;
	}
	
	
	
}

package com.finablr.platform.notification.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "notification_channel")
public class NotificationChannel {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long channelId;
	@Column(nullable = false)
	private String channelName;
	@Column(nullable = false)
	private boolean isDisable;
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public boolean isDisable() {
		return isDisable;
	}
	public void setDisable(boolean isDisable) {
		this.isDisable = isDisable;
	}
}

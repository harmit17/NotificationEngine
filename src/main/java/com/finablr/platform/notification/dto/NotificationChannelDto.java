package com.finablr.platform.notification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class NotificationChannelDto {

	@NotNull @JsonProperty("channelId")
	private Long channelId;
	@NotNull @JsonProperty("channelName")
	private String channelName;
	@NotNull @JsonProperty("isDisable")
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

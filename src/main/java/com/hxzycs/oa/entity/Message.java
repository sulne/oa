package com.hxzycs.oa.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long messageId;
	private Long fromId;
	private String fromName;
	private Long toId;
	private String messageText;
	private Timestamp messageDate;

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public Long getFromId() {
		return fromId;
	}

	public void setFromId(Long fromId) {
		this.fromId = fromId;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public Long getToId() {
		return toId;
	}

	public void setToId(Long toId) {
		this.toId = toId;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public Timestamp getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Timestamp messageDate) {
		this.messageDate = messageDate;
	}

	@Override
	public String toString() {
		return "Message{" + "messageId=" + messageId + ", fromId=" + fromId + ", fromName='" + fromName + '\''
				+ ", toId=" + toId + ", messageText='" + messageText + '\'' + ", messageDate=" + messageDate + '}';
	}
}

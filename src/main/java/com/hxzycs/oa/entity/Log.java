package com.hxzycs.oa.entity;

import java.io.Serializable;

public class Log implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String content;
	private Long userId;
	private String createDate;
	private String operation;
	private String parameters;
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getParameters() {
		return parameters;
	}
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Log{"
			+ "userid = " + userId
			+ ", content = " + content
			+ ", operation = " + operation
			+ ", createDate = " + createDate
			+ ", parameters = " + parameters
			+ "}";
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
}

package com.hxzycs.oa.entity;

import java.io.Serializable;

public class Menu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4219461526377281385L;
	private Long id;// ���
	private Menu parent; // �����˵�
	private String parentIds; // ���и������
	private String name; // ����
	private String href; // ����
	private String target; // Ŀ�꣨ mainFrame��_blank��_self��_parent��_top��
	private String icon; // ͼ��
	private Integer sort; // ����
	private Integer isShow; // �Ƿ��ڲ˵�����ʾ��1����ʾ��0������ʾ��
	private String permission; // Ȩ�ޱ�ʶ
	public Menu() {
		isShow = 1;
	}
	
	public Long getParentId() {
		return parent != null && parent.getId() != null ? parent.getId() : 0;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Menu getParent() {
		return parent;
	}
	public void setParent(Menu parent) {
		this.parent = parent;
	}
	public String getParentIds() {
		return parentIds;
	}
	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getIsShow() {
		return isShow;
	}
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
}

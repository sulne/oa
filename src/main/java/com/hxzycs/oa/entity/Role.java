package com.hxzycs.oa.entity;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;// 编号
	private String role;// 角色名称
	private String description; // 角色描述
	private Integer useable;// 是否可用
	private List<Menu> menus; // 拥有菜单列表
	private User user;// 根据用户条件查找角色
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getUseable() {
		return useable;
	}

	public void setUseable(Integer useable) {
		this.useable = useable;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
}

package com.hxzycs.oa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3151252988628774465L;
	private Long id; // 编号
	private String email;// 邮箱
	private String username; // 用户名
	private String password; // 密码
	private String salt; // 加密密码的盐
	private List<Role> roles; // 拥有的角色列表
	private Role role;// 根据角色条件查用户
	private Boolean locked = Boolean.FALSE;// 锁定状态
	private Long createBy;// 创建者
	private String createDate;// 创建时间
	private Long updateBy;// 更新者
	private String updateDate;// 更新时间
	private String remarks;// 备注
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("User{"
				+ "id = %d"
				+ ", email = %s"
				+ ", username = %s"
				+ ", password = %s"
				+ ", salt = %s"
				+ ", rolesSize = %d"
				+ ", locked = %b"
				+ "}",id,email,username,password,salt,getRoles().size(),locked);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public List<Role> getRoles() {
		if(roles == null) {
            roles = new ArrayList<Role>();
        }
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
}

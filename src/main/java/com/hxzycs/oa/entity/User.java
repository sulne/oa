package com.hxzycs.oa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3151252988628774465L;
	private Long id; // ���
	private String email;// ����
	private String username; // �û���
	private String password; // ����
	private String salt; // �����������
	private List<Role> roles; // ӵ�еĽ�ɫ�б�
	private Role role;// ���ݽ�ɫ�������û�
	private Boolean locked = Boolean.FALSE;// ����״̬
	private Long createBy;// ������
	private String createDate;// ����ʱ��
	private Long updateBy;// ������
	private String updateDate;// ����ʱ��
	private String remarks;// ��ע
	
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

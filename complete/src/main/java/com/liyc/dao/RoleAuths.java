package com.liyc.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @package com.liyc.dao
 * @author liyuchang
 * @date 2016年3月15日
 */
@Entity
@Table(name = "s_role_auths")
public class RoleAuths implements Serializable{
  private static final long serialVersionUID = -2741751955435400605L;
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
  @Column(name="role_id")
  private Long roleId;
  @Column(name="auth_id")
  private Long authId;
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getAuthId() {
		return authId;
	}
	public void setAuthId(Long authId) {
		this.authId = authId;
	}
  
}

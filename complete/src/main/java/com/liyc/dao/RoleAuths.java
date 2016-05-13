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
  private Long role_id;
  @Column(name="auth_id")
  private Long auth_id;
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Long getRole_id() {
    return role_id;
  }
  public void setRole_id(Long role_id) {
    this.role_id = role_id;
  }
  public Long getAuth_id() {
    return auth_id;
  }
  public void setAuth_id(Long auth_id) {
    this.auth_id = auth_id;
  }
  
}

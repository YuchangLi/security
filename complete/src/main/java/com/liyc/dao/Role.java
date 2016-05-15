package com.liyc.dao;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @package com.liyc.dao
 * @author liyuchang
 * @date 2016年3月15日
 *
 */
@Entity
@Table(name = "s_role")
public class Role implements Serializable{
	private static final long serialVersionUID = 4272964744767057L;
	@Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uid", insertable = false, updatable = false)
	private User user;
	@ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
	private Set<Authority> authoritys;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
  public Set<Authority> getAuthoritys() {
    return authoritys;
  }
  public void setAuthoritys(Set<Authority> authoritys) {
    this.authoritys = authoritys;
  }
	
}

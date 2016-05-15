package com.liyc.dao;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @package com.liyc.dao
 * @author liyuchang
 * @date 2016年3月15日
 */
@Entity
@Table(name = "s_authority")
public class Authority implements Serializable{
  private static final long serialVersionUID = -2824478464442752954L;
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String url;
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
  @JoinTable(name = "s_role_auths", 
          joinColumns = { @JoinColumn(name = "auth_id", referencedColumnName = "id", insertable = false, updatable = false) }, 
          inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false) })
	private Set<Role> roles ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}

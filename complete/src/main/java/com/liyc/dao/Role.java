package com.liyc.dao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private Integer id;
	private String name;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uid")
	private User user;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	
}

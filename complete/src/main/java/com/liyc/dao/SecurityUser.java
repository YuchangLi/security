package com.liyc.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @package com.liyc.dao
 * @author liyuchang
 * @date 2016年3月15日
 *
 */
public class SecurityUser extends User implements UserDetails {
	private static final long serialVersionUID = -6709219272741462393L;

	public SecurityUser() {}
	public SecurityUser(User user) {
		super(user.getId(),user.getName(),user.getEmail(),user.getPassword(),user.getCreateTime(),user.getRoles());
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		Set<Role> userRoles = this.getRoles();
		if (userRoles != null) {
			userRoles.forEach(role->{
				System.out.println("role: "+role.getName());
				Set<Authority> authoritys = role.getAuthoritys();
				if(authoritys!=null){
					System.out.print(" auths: ");
					authoritys.parallelStream().forEach(auth->{
						System.out.print(auth.getUrl()+";");
						SimpleGrantedAuthority authority = new SimpleGrantedAuthority(auth.getUrl());
						authorities.add(authority);
					});
				}
			});
		}
		return authorities;
	}

	@Override
	public String getUsername() {
		return super.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

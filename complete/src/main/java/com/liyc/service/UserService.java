package com.liyc.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.liyc.dao.User;

/**
 * @package com.liyc
 * @author liyuchang
 * @date 2016年3月15日
 *
 */
public interface UserService extends UserDetailsService {
	List<User> findAll();
	
	User create(User user);
	
	User login(String email, String password);

	User findUserById(int id);
	
	User findUserByEmail(String email);
	
	User update(User user);
	
	void deleteUser(int id);
	
}

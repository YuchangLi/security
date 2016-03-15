package com.liyc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.liyc.dao.SecurityUser;
import com.liyc.dao.User;
import com.liyc.dao.repository.UserRepository;
import com.liyc.service.UserService;

/**
 * @package com.liyc.service.impl
 * @author liyuchang
 * @date 2016年3月16日
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findByEmail(username);
		System.out.println("username="+username+"user is null : "+(user==null));
		if (user == null) {
			throw new UsernameNotFoundException("UserName " + username + " not found");   
		}
		// SecurityUser实现UserDetails并将SUser的Email映射为username   return new SecurityUser(user); //code9
		return new SecurityUser(user);
	}

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	@Override
	public User create(User user) {
		return this.userRepository.save(user);
	}

	/* (non-Javadoc)
	 * @see com.liyc.service.UserService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public User login(String email, String password) {
		return this.userRepository.findByEmailAndPassword(email, password);
	}

	/* (non-Javadoc)
	 * @see com.liyc.service.UserService#findUserById(int)
	 */
	@Override
	public User findUserById(int id) {
		return this.userRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.liyc.service.UserService#findUserByEmail(java.lang.String)
	 */
	@Override
	public User findUserByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

	/* (non-Javadoc)
	 * @see com.liyc.service.UserService#update(com.liyc.dao.User)
	 */
	@Override
	public User update(User user) {
		return this.userRepository.save(user);
	}

	/* (non-Javadoc)
	 * @see com.liyc.service.UserService#deleteUser(int)
	 */
	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		this.userRepository.delete(id);
	}

}

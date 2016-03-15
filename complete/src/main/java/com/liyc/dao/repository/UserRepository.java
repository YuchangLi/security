package com.liyc.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.liyc.dao.User;

/**
 * @package com.liyc.dao.repository
 * @author liyuchang
 * @date 2016年3月15日
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select u from User u where u.email=?1 and u.password=?2")
	User login(String email, String password);

	User findByEmailAndPassword(String email, String password);

	User findByEmail(String email);
}

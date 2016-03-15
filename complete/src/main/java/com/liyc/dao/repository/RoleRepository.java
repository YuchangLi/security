package com.liyc.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liyc.dao.Role;

/**
 * @package com.liyc.dao.repository
 * @author liyuchang
 * @date 2016年3月15日
 *
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
}

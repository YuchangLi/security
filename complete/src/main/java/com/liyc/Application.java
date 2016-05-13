package com.liyc;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.liyc.config.Appctx;
import com.liyc.dao.Role;
import com.liyc.dao.User;
import com.liyc.dao.repository.RoleRepository;
import com.liyc.service.UserService;

@SpringBootApplication
public class Application {

	
  public static void main(String[] args) throws Throwable {
  	Appctx.ctx = SpringApplication.run(Application.class, args);
  	RoleRepository roleRepository = (RoleRepository)  Appctx.ctx.getBean("roleRepository");
  	if(roleRepository==null)
  		throw new RuntimeException("roleRepository is null");
  	UserService userService = (UserService)  Appctx.ctx.getBean("userService");
  	if(userService.findUserByEmail("648821884@qq.com")==null){
	  	User user = new User();
	  	user.setName("李玉长");
	  	user.setEmail("648821884@qq.com");
	    BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);
	    user.setPassword(bc.encode("123456")); 
	    user.setCreateTime(new Date());
	    userService.update(user);
	    System.out.println(user.getId());
	    Role role = new Role();
	    role.setName("ADMIN");
	    role.setUser(user);
	    roleRepository.save(role);
  	}
  }
  
}

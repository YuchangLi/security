package com.liyc.config;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;

/**
 * @Package com.liyc.config
 * @author liyuchang
 * @date 2016年5月13日
 * @Description: TODO 	
 */
public class AppAccessDecisionManager implements AccessDecisionManager {

  @Override
  public void decide(Authentication authentication, Object object,
      Collection<ConfigAttribute> configAttributes)
      throws AccessDeniedException, InsufficientAuthenticationException {
    System.out.println(authentication.getName());
    authentication.getAuthorities().forEach(x->System.out.println(x.getAuthority()));
    System.out.println("object");
    System.out.println(object);
    System.out.println("configAttributes");
    configAttributes.forEach(x->System.out.println(x.getAttribute()));
  }

  @Override
  public boolean supports(ConfigAttribute attribute) {
    return false;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return false;
  }

}

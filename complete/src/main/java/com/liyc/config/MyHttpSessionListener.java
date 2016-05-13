/**
 * @Package com.liyc.config
 * @author liyuchang
 * @date 2016年5月13日
 * @Description: TODO 	
 */
package com.liyc.config;

import javax.servlet.http.HttpSessionEvent;

import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @Package com.liyc.config
 * @author liyuchang
 * @date 2016年5月13日
 * @Description: TODO 	
 */
//@Component
public class MyHttpSessionListener extends HttpSessionEventPublisher {

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    System.out.println("session created");
    super.sessionCreated(se);
  }
//
//  @Override
//  public void sessionDestroyed(HttpSessionEvent se) {
//    System.out.println("session Destroyed");
//
//  }

}

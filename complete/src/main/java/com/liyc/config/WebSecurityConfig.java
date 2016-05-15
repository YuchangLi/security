package com.liyc.config;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import com.liyc.dao.Authority;
import com.liyc.dao.repository.AuthorityRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		@Resource
		private UserDetailsService userService;
		@Resource 
		private DataSource dataSource;
		@Resource 
		private AuthorityRepository authorityRepository;
		
		@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(false);
//        auth.
//        inMemoryAuthentication()
//            .withUser("user")
//                .password("password")
//                .roles("USER");
    }
		
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        loadAuthoritys(http)
            .authorizeRequests()
            //.accessDecisionManager(accessDecisionManager())
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .successHandler(loginSuccessHandler())
                .defaultSuccessUrl("/home")
                .and()
            .logout()
                .permitAll()
                .invalidateHttpSession(true)
                .and()
            //登录后记住用户，下次自动登录 数据库中必须存在名为persistent_logins的表
            .rememberMe()
                .tokenValiditySeconds(1209600)
                .tokenRepository(tokenRepository())
                .and()
            .sessionManagement()
                .maximumSessions(1)
//                .maxSessionsPreventsLogin(true)
                .expiredUrl("/login?expired");
                
    }
    private HttpSecurity loadAuthoritys(HttpSecurity http) {
      List<Authority> authoritys = this.authorityRepository.findAll();
      authoritys.parallelStream().forEach(authority->{
        try {
        	System.out.println("authority="+authority.getUrl());
          http.authorizeRequests().antMatchers(authority.getUrl()).hasAuthority(authority.getUrl());
        } catch (Exception e) {
          e.printStackTrace();
        }
      });
      return http;
    }

    public AccessDecisionManager accessDecisionManager() {
      return new AppAccessDecisionManager();
    }

    //    @Bean
//    public HttpSessionEventPublisher httpSessionEventPublisher() {
//        return new HttpSessionEventPublisher();
//    }
    @Bean
    public LoginSuccessHandler loginSuccessHandler() {
    	return new LoginSuccessHandler();
    }

    @Bean
    public JdbcTokenRepositoryImpl tokenRepository() {
			JdbcTokenRepositoryImpl j = new JdbcTokenRepositoryImpl();
			j.setDataSource(dataSource);
			return j;
		}

    @Bean
		public BCryptPasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder(4);
		}

}

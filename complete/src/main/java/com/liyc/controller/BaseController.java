package com.liyc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.liyc.dao.SecurityUser;
import com.liyc.dao.User;

@RestController
@RequestMapping("/base")
public class BaseController {
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<Map<String,String>> regist(@PathParam("username") String username,@PathParam("password") String password, HttpServletRequest request) {
		System.out.println("request.getRemoteUser()="+request.getRemoteUser());
		System.out.println("request.getUserPrincipal().getName()="+request.getUserPrincipal().getName());
		SecurityContext	ctx = SecurityContextHolder.getContext();
		Authentication auth = ctx.getAuthentication();
		System.out.println("auth.getName()="+auth.getName());
		SecurityUser user  = (SecurityUser)auth.getPrincipal();
		System.out.println("username="+user.getName());
		auth.getAuthorities().forEach(x->System.out.println(x.getAuthority()));
		user.getAuthorities().forEach(x->System.out.println(x.getAuthority()));
		Map<String,String> map = new HashMap<String,String>();
		System.out.println("auth.getCredentials()="+auth.getCredentials());
		map.put("username", username);
		map.put("password", password);
	 		return ResponseEntity.ok(map);
	 }
	@RequestMapping(value = "/testUpdate", method = RequestMethod.GET)
	public ResponseEntity<Map<String,String>> testUpdate(@PathParam("username") String username,@PathParam("password") String password, HttpServletRequest request) {
		System.out.println("request.getRemoteUser()="+request.getRemoteUser());
		System.out.println("request.getUserPrincipal().getName()="+request.getUserPrincipal().getName());
		SecurityContext	ctx = SecurityContextHolder.getContext();
		Authentication auth = ctx.getAuthentication();
		System.out.println("auth.getName()="+auth.getName());
		SecurityUser user  = (SecurityUser)auth.getPrincipal();
		System.out.println("username="+user.getName());
		auth.getAuthorities().forEach(x->System.out.println(x.getAuthority()));
		user.getAuthorities().forEach(x->System.out.println(x.getAuthority()));
		Map<String,String> map = new HashMap<String,String>();
		System.out.println("auth.getCredentials()="+auth.getCredentials());
		map.put("username", username);
		map.put("password", password);
		return ResponseEntity.ok(map);
	}
	@RequestMapping(value = "/testDelete", method = RequestMethod.GET)
	public ResponseEntity<Map<String,String>> testDelete(@PathParam("username") String username,@PathParam("password") String password, HttpServletRequest request) {
		System.out.println("request.getRemoteUser()="+request.getRemoteUser());
		System.out.println("request.getUserPrincipal().getName()="+request.getUserPrincipal().getName());
		SecurityContext	ctx = SecurityContextHolder.getContext();
		Authentication auth = ctx.getAuthentication();
		System.out.println("auth.getName()="+auth.getName());
		SecurityUser user  = (SecurityUser)auth.getPrincipal();
		System.out.println("username="+user.getName());
		auth.getAuthorities().forEach(x->System.out.println(x.getAuthority()));
		user.getAuthorities().forEach(x->System.out.println(x.getAuthority()));
		Map<String,String> map = new HashMap<String,String>();
		System.out.println("auth.getCredentials()="+auth.getCredentials());
		map.put("username", username);
		map.put("password", password);
		return ResponseEntity.ok(map);
	}
}

package com.hiber.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AuthorizeInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	HttpSession session;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		if(session.getAttribute("account") == null) {
			session.setAttribute("back-uri", request.getRequestURI());
			response.sendRedirect("/login");
			return false;
		}
		if(session.getAttribute("User") == null) {
			session.setAttribute("back-uri", request.getRequestURI());
			response.sendRedirect("/login");
			return false;
		}
		System.out.println("");
		return true;
	}
}

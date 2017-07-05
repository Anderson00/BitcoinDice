package com.example.Spring.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		if(uri.endsWith("/") || uri.endsWith("login") || uri.endsWith("signup")){
			if(request.getSession().getAttribute("userID") != null)
				response.sendRedirect("home");
			return true;
		}
		if(request.getSession().getAttribute("userID") != null)
			return true;
			
		response.sendRedirect("/");
		return false;
	}
}

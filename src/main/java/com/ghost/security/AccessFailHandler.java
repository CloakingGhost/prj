package com.ghost.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Service;

@Service
public class AccessFailHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("AccessFailHandler");
		accessDeniedException.printStackTrace();
		response.sendRedirect("/");
//		if(accessDeniedException instanceof AccessDeniedException) {
//			request.setAttribute("LoginFailMessage", "접근 권한이 없는 계정입니다.");
//		}
	}

}

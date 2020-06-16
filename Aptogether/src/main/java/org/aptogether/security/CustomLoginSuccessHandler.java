package org.aptogether.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aptogether.domain.CustomUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		CustomUser a = (CustomUser) authentication.getPrincipal();
		log.warn("login success");
		log.warn(authentication.getDetails());
		log.warn(authentication.getCredentials());
		CustomUser user = (CustomUser) authentication.getPrincipal();
		System.out.println(user);
		if (user.getType().equals("ROLE_TENANT")) {
			response.sendRedirect("/tenant/dashboard");
			return;
		} else if (user.getType().equals("ROLE_KEEPER")) {
			response.sendRedirect("/keeper/dashboard");
			return;
		} else {
			
		}

		log.warn(authentication.getAuthorities());
		response.sendRedirect("/");
	}
}

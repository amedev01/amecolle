package jp.co.amedev.amecolle.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

		SimpleGrantedAuthority roleId = null;
		if (!authentication.getAuthorities().isEmpty() && authentication.getAuthorities().toArray()[0] instanceof SimpleGrantedAuthority){
			roleId = (SimpleGrantedAuthority)authentication.getAuthorities().toArray()[0];
		}
		
		switch(roleId.toString()){
		case "0" : response.sendRedirect(request.getContextPath() + "/home");break;
		case "1" : response.sendRedirect(request.getContextPath() + "/adminHome");break;
		default : throw new RuntimeException();
		}
	}

}

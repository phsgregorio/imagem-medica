package com.puc.imagemmed.login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.puc.imagemmed.usuario.Usuario;
import com.puc.imagemmed.usuario.UsuarioRN;

@WebFilter("/sistema/*")
public class SessionFilter implements Filter {

    public SessionFilter() { }

	public void destroy() { }


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		
		try {

			String url = ((HttpServletRequest)request).getRequestURL().toString();
			
			if (url.indexOf("Login.do")==-1 && url.indexOf("login.jsp")==-1) {
				
				Usuario usuario = (Usuario) session.getAttribute("usuario");
				Usuario existente = new UsuarioRN().validar(usuario);
				
				if (existente==null) {
					((HttpServletResponse)response).sendRedirect("/sistema/login.jsp");
				}
			}

			chain.doFilter(request, response);
		} catch (Exception e) {
			((HttpServletResponse)response).sendRedirect("/sistema/login.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException { }
}

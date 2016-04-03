package de.mb.filzobjekt.filter;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import de.mb.filzobjekt.business.IAuthorizationService;
import de.mb.filzobjekt.business.factory.AuthorizationFactory;

/**
 * Servlet Filter implementation class Admin
 */
@WebFilter("/*")
@Component
public class AdminFilter implements Filter {

	private static IAuthorizationService auth_service;

	/**
	 * Default constructor.
	 */
	public AdminFilter() {
		auth_service = AuthorizationFactory.getService();
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String admin = (String) req.getAttribute("admin");
		if (admin != null && admin.equals("true")) {
			System.out.println("Admin true");
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		Pattern p = Pattern.compile("^.+?js/.*$|^.+css/.*$|^.+ckeditor/.*$");
		Matcher m = p.matcher(req.getRequestURI());
		if (m.matches()) {
			chain.doFilter(req, res);
			return;
		}
		String uri = req.getRequestURI();
		p = Pattern.compile("^.+?rest/login$");
		m = p.matcher(uri);
		System.out.println(req.getRequestURI());
		String token = null;
		if (m.matches()) {
			String username = req.getParameter("username");
			String pw = req.getParameter("password");
			if (auth_service.loginAdmin(username, pw)) {
				token = auth_service.getToken(username, request.getRemoteAddr());
				System.out.println(token);
				res.setHeader("authorization", token);
				chain.doFilter(req, res);
				return;
			}
			// TODO include logging for monitoring
			res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}
		
		token = req.getHeader("authorization");
		
		p = Pattern.compile("^.+?rest/*$");
		m = p.matcher(uri);
		if (m.matches()) {
			if (token != null && auth_service.checkToken(token)) {
				req.setAttribute("admin", "true");
				chain.doFilter(req, res);
			} else {
				// TODO include logging for monitoring
				res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
			return;
		}
		p = Pattern.compile("^.+?/*$");
		m = p.matcher(uri);
		if (m.matches()) {
			if (token != null && auth_service.checkToken(token)) {
				System.out.println("Token is valid");
				req.setAttribute("admin", "true");
			}
			chain.doFilter(req, res);
			return;
		}
		// pass the request along the filter chain
		System.out.println("Request was blocked: " + req.getRequestURI());
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

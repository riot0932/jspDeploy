package kr.or.ddit.locale;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class localeFilter
 */
@WebFilter("/localeSelect")
public class localeFilter implements Filter {
	
	private Logger logger = LoggerFactory.getLogger(localeFilter.class);

    public localeFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//전처리
		HttpServletRequest req = (HttpServletRequest)request;
		
		logger.debug(req.getRequestURI()+"localeFilter doFilter");
		
		localeWrapper localeWrapper = new localeWrapper(req);
		
		chain.doFilter(localeWrapper, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}

package com.javanos.project.common.filter;

import java.io.IOException;

import com.javanos.project.common.wrapper.EncryptRequestWrapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

/* member 서비스인 경우에만 암호화 처리 할 수 있도록 한다. */
@WebFilter("/user/*")
public class PasswordEncryptFilter implements Filter {

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// 로그인을 하는 경우 자동 암호화된 값으로 비교하게 되면 비교할 수 없음
		// 로그인 요청은 암호화되는 필터에서 암호화 처리되지 않도록 설정
		HttpServletRequest hrequest = (HttpServletRequest) request;
		
		String uri = hrequest.getRequestURI();
		
		String intent = uri.substring(uri.lastIndexOf("/"));
		
		// 로그인 요청이 아닌 경우에만 암호화
		if(!"/login".equals(intent) && !"/mypage".equals(intent) && !"/check-pwd".equals(intent)) {
			EncryptRequestWrapper wrapper = new EncryptRequestWrapper(hrequest);
			chain.doFilter(wrapper, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}

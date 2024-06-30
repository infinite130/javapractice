package com.javanos.project.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javanos.project.user.model.dto.UserDTO;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/user/*", "/community/*", "/notice/*", "/lnf/*", "/down/*", "/reportmain", "/CheckBoard"})
public class AuthenticationFilter implements Filter {
	
	Map<String, List<String>> permitURIList;
	
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest) request;
		String uri = hrequest.getRequestURI();
		String intent = uri.replace(hrequest.getContextPath(), "");
		
		System.out.println("intent : " + intent);
		
		/* 세션에 권한이 있는지 확인하여 허용된 url에만 접근 가능하도록 설정한다. */
		HttpSession requestSession = hrequest.getSession();
		UserDTO loginUser = (UserDTO) requestSession.getAttribute("loginUser");
		
		boolean isAuthorized = false;
		if(loginUser != null) {
			boolean isPermitAdmin = permitURIList.get("adminPermitList").contains(intent);
			boolean isPermitUser = permitURIList.get("userPermitList").contains(intent);
			boolean isPermitAll = permitURIList.get("allPermitList").contains(intent);
			
			if("ROLE_ADMIN".equals(loginUser.getUserRole())) {
				if(isPermitAdmin || isPermitUser || isPermitAll) {
					isAuthorized = true;
				}
			} else if("ROLE_USER".equals(loginUser.getUserRole())) {
				if((isPermitUser || isPermitAll) && !isPermitAdmin) {
					isAuthorized = true;
				}
			}
			
			if(isAuthorized) {
				chain.doFilter(request, response);
			} else {
				((HttpServletResponse) response).sendError(403);
			}
			
		} else {
			
			if(permitURIList.get("allPermitList").contains(intent)) {
				chain.doFilter(request, response);
			} else {
				request.setAttribute("message", "로그인이 필요한 서비스 입니다.");
				request.setAttribute("code", "loginUser");
				request.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(hrequest, response);
			}
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
		permitURIList = new HashMap<>();
		List<String> allPermitList = new ArrayList<>();
		List<String> userPermitList = new ArrayList<>();
		List<String> adminPermitList = new ArrayList<>();
		
		allPermitList.add("/user/check-id");
		allPermitList.add("/user/check-nickname");
		allPermitList.add("/user/check-email");
		allPermitList.add("/user/check-pwd");
		allPermitList.add("/user/join");
		allPermitList.add("/user/login");
		allPermitList.add("/user/logout");
		allPermitList.add("/lnf/first");
		allPermitList.add("/lnf/main");
		allPermitList.add("/lnf/search");
		allPermitList.add("/community/list");
		allPermitList.add("/community/detail");
		allPermitList.add("/notice/list");
		allPermitList.add("/notice/detail");
		allPermitList.add("/notice/noticeSearchList");
		
		userPermitList.add("/user/mypage");
		userPermitList.add("/user/delete");
		userPermitList.add("/down/enroll");
		userPermitList.add("/down/delete");
		userPermitList.add("/lnf/insert");
		userPermitList.add("/lnf/detail");
		userPermitList.add("/lnf/modify");
		userPermitList.add("/lnf/delete");
		userPermitList.add("/community/insert");
		userPermitList.add("/community/update");
		userPermitList.add("/community/delete");
		userPermitList.add("/reportmain");
		
		adminPermitList.add("/lnf/detail");
		adminPermitList.add("/lnf/modify");
		adminPermitList.add("/lnf/delete");
		adminPermitList.add("/notice/insert");
		adminPermitList.add("/notice/update");
		adminPermitList.add("/notice/delete");
		adminPermitList.add("/CheckBoard");
		
		permitURIList.put("adminPermitList", adminPermitList);
		permitURIList.put("userPermitList", userPermitList);
		permitURIList.put("allPermitList", allPermitList);
	}
}
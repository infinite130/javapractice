package com.javanos.project.common.wrapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.javanos.project.user.model.dto.UserDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpSession;

public class EncryptRequestWrapper extends HttpServletRequestWrapper {
	
	// 부모쪽에 기본생성자가 존재하지 않기 때문에 request를 전달해주는 생성자가 필요
	public EncryptRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String key) {
		
		String value = super.getParameter(key);
		if ("userPwd".equals(key) || "newPwd".equals(key)) {
			// 마이페이지에서 비밀번호 변경을 진행하지 않았을 때 기본값 설정
			if (value == null || value.trim().isEmpty()) {
				HttpSession session = ((HttpServletRequest) getRequest()).getSession();
				UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
				if (loginUser != null) {
					value = loginUser.getUserPwd();
				}
			} else {
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				value = passwordEncoder.encode(value);
			}
		}

		return value;
	}
}
package com.javanos.project.common.wrapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class EncryptRequestWrapper extends HttpServletRequestWrapper {
	
	// 부모쪽에 기본생성자가 존재하지 않기 때문에 request를 전달해주는 생성자가 필요
	public EncryptRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String key) {
		
		String value = "";
		if("userPwd".equals(key)) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			value = passwordEncoder.encode(super.getParameter(key));
		} else {
			value = super.getParameter(key);
		}
		
		return value;
	}
}
package com.ohgiraffers.auth.admin.model.service;

import static com.ohgiraffers.auth.common.mybatis.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.ohgiraffers.auth.admin.model.dao.AdminDAO;
import com.ohgiraffers.auth.admin.model.dto.MemberDTO;

public class AdminService {
	
	// TODO 3. AdminDAO를 필드로 선언
	private AdminDAO adminDAO;
	
	// TODO 4. SqlSession을 얻어 AdminDAO를 통해 MemberDTO 리스트 반환받기
	public int memberList(MemberDTO requestMember) {
		
		SqlSession session = getSqlSession();
		adminDAO = session.getMapper(AdminDAO.class);
		
		int result = adminDAO.insertMember(requestMember);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
		
	}
	
	// TODO 7. 반환받은 memberList를 컨트롤러에게 반환하기
	
	
	

}

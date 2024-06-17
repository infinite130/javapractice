package com.ohgiraffers.auth.admin.model.dao;

import com.ohgiraffers.auth.admin.model.dto.MemberDTO;

public interface AdminDAO {
	
	// TODO 5. memberList를 조회하여 반환할 메소드 선언
	int insertMember(MemberDTO requestMembe);
	
	// TODO 6. main의 resources 폴더 하위에 해당 인터페이스와 매핑되는 xml 파일을 만들어 쿼리 작성
	
	
	// TODO 6+ 이때, 해당 xml 파일은 mybatis-config 하위에 등록해야 함

}

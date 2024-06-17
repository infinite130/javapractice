package com.ohgiraffers.auth.member.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ohgiraffers.auth.member.model.dao.MemberDAO;
import com.ohgiraffers.auth.member.model.dto.MemberDTO;

import static com.ohgiraffers.auth.common.mybatis.Template.getSqlSession;

public class BoardService {
	
	// TODO LV.2 > ST.1 > 2. BoardDAO 필드 선언
	
	// TODO LV.2 > ST.1 > 3. BoardList를 조회하는 서비스 로직 작성
	// 3-1) SqlSession 얻기
	// 3-2) mapper 얻기
	// 3-3) 메소드 호출해서 BoardList 반환받기
	// 3-4) 자원 반납
	// 3-5) boardList 반환하기
	
	// TODO LV.2 > ST.2 > 6. BoardDTO를 등록하는 서비스 로직 작성
	// 6-1) SqlSession 얻기
	// 6-2) mapper 얻기
	// 6-3) 메소드 호출해서 BoardDTO 등록하기
	// 6-4) 등록 결과에 따른 commit, rollback 처리 후 자원 반납
	// 6-5) 결과 int로 반환하기
	
	// TODO LV.2 > ST.3 > 5. BoardDTO를 조회하는 서비스 로직 작성
	// 5-1) SqlSession 얻기
	// 5-2) mapper 얻기
	// 5-3) 메소드 호출해서 BoardDTO 조회하기
	// 5-4) 자원 반납
	// 5-5) 결과 반환하기
	
	// TODO LV.2 > ST.4 > 6. 대상 게시글 정보를 수정하는 서비스 로직 작성
	// 6-1) SqlSession 얻기
	// 6-2) mapper 얻기
	// 6-3) 메소드 호출해서 BoardDTO 넘겨주며 대상 정보 수정하기
	// 6-4) 수정 결과에 따른 commit, rollback 처리 후 자원 반납
	// 6-5) 결과 int로 반환하기
	
	// TODO LV.2 > ST.5 > 5. 대상 게시글을 삭제 (board_status를 N으로 update) 서비스 로직 작성
	// 5-1) SqlSession 얻기
	// 5-2) mapper 얻기
	// 5-3) 메소드 호출해서 boardNo 넘겨주며 board_status 수정하게 하기
	// 5-4) 수정 결과에 따른 commit, rollback 처리 후 자원 반납
	// 5-5) 결과 int로 반환하기
}

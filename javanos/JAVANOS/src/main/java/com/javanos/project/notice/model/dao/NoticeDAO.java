package com.javanos.project.notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.javanos.project.notice.model.dto.NoticeDTO;

public interface NoticeDAO {
	
	// db 테이블에 접근, 작업수행하는 메소드 선언하기
	
	// 전체 조회 메소드
	public List<NoticeDTO> selectAllNoticeList();
	
//	// 새 공지 삽입 메소드
//	public int insertNotice(NoticeDTO newNotice);
//	
//	// 조회수 증가 메소드
//	// 매개변수는 조회수 증가시킬 공지사항의 번호
//	public int incrementNoticeCount(int no);
//	
//	// 상세보기 조회 메소드
//	// 매개변수: 조회할 공지사항의 번호
//	public NoticeDTO selectNoticeDetail(int no);

}

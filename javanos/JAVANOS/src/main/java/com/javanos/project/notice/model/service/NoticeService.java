package com.javanos.project.notice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.javanos.project.notice.model.dao.NoticeDAO;
import com.javanos.project.notice.model.dto.NoticeDTO;

import static com.javanos.project.common.mybatis.Template.getSqlSession;

public class NoticeService {
	
	private NoticeDAO noticeDAO;
	
	// db 연결 관리 (SqlSession - close)
	
	// 전체 목록 조회 메소드 (db로부터 가져옴)
	public List<NoticeDTO> selectAllNoticeList(){
		
		SqlSession session = getSqlSession();
		noticeDAO = session.getMapper(NoticeDAO.class);
		
		List<NoticeDTO> noticeList = noticeDAO.selectAllNoticeList();
		
		session.close();
		
		return noticeList;	
	}
	
	
	// 신규 공지 등록 메소드
//	public int insertNotice(NoticeDTO newNotice) {
//		
//		SqlSession session = getSqlSession();
//		noticeDAO = session.getMapper(NoticeDAO.class);
//		
//		int result = noticeDAO.insertNotice(newNotice);
//		
//		// 신규 공지 삽입 성공 및 실패 여부에 따른 데이터삽입?
//		if(result > 0) {
//			session.commit();
//		}else {
//			session.rollback();
//		}
//		
//		session.close();
//		
//		return result;
//	}
//	
//	
//	// 공지사항 상세보기 메소드
//	public NoticeDTO selectNoticeDetail(int no) {
//		
//		SqlSession session = getSqlSession();
//		noticeDAO= session.getMapper(NoticeDAO.class);
//		
//		// 공지사항 상세정보 담을 객체 초기화
//		NoticeDTO noticeDetail = null;
//		
//		// 공지사항 조회수 증가시키는 메소드 호출, 그 결과 result 변수에 저장
//		int result = noticeDAO.incrementNoticeCount(no);
//		
//		// 조회수 증가 성공하면 상세정보를 조회하는 조건문
//		if(result > 0 ) {
//			
//			noticeDetail = noticeDAO.selectNoticeDetail(no);
//			
//			// 상세정보 가져오면 트랜잭션 커밋(db)
//			if(noticeDetail != null) {
//				session.commit();
//			}else {
//				session.rollback();
//			}
//			
//		}else {
//			session.rollback();
//		}
//		
//		session.close();
//		
//		return noticeDetail;		
//	}
}

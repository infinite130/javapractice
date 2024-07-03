package com.javanos.project.notice.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.javanos.project.user.model.dao.UserDAO;
import com.javanos.project.common.paging.Pagenation;
import com.javanos.project.common.paging.SelectCriteria;
import com.javanos.project.community.model.dao.CommunityDAO;
import com.javanos.project.community.model.dto.CommunityDTO;
import com.javanos.project.notice.model.dao.NoticeDAO;
import com.javanos.project.notice.model.dto.NoticeDTO;

import static com.javanos.project.common.mybatis.Template.getSqlSession;

public class NoticeService {

	private NoticeDAO noticeDAO;

	// db 연결 관리 (SqlSession - close)

	 /* 페이징 처리를 위한 전체 게시물 수 조회용 메소드 */
    public int selectTotalCount(Map<String, String> searchMap) {
        
        SqlSession session = getSqlSession(); // MyBatis SqlSession 객체 생성
        noticeDAO = session.getMapper(NoticeDAO.class); // NoticeDAO 인터페이스의 매퍼 구현체를 가져옴
        
        int totalCount = noticeDAO.selectTotalCount(searchMap); // DAO를 통해 전체 게시물 수를 조회
        
        session.close(); // SqlSession 닫기
        
        return totalCount; // 조회된 전체 게시물 수 반환
    }
	
	// 전체 목록 조회 메소드 (페이징 처리 추가)
    public List<NoticeDTO> selectAllNoticeList(SelectCriteria selectCriteria) {
    	
        SqlSession session = getSqlSession();
        noticeDAO = session.getMapper(NoticeDAO.class);
        
        selectCriteria.setStartRow(selectCriteria.getStartRow() - 1); // 시작 행 설정

        List<NoticeDTO> noticeList = noticeDAO.selectAllNoticeList(selectCriteria);

        session.close();

        return noticeList;
    }

	// 신규 공지 등록 메소드
	public int insertNotice(NoticeDTO newNotice) {

		SqlSession session = getSqlSession();
		noticeDAO = session.getMapper(NoticeDAO.class);

		int result = noticeDAO.insertNotice(newNotice);

		// 신규 공지 삽입 성공 및 실패 여부에 따른 데이터삽입?
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		session.close();

		return result;
	}

	// 공지사항 상세보기 메소드
	public NoticeDTO selectNoticeDetail(int no) {

		SqlSession session = getSqlSession();
		noticeDAO = session.getMapper(NoticeDAO.class);

		// 공지사항 상세정보 담을 객체 초기화
		NoticeDTO noticeDetail = null;

		// 공지사항 조회수 증가시키는 메소드 호출, 그 결과 result 변수에 저장
		int result = noticeDAO.incrementNoticeCount(no);

		// 조회수 증가 성공하면 상세정보를 조회하는 조건문
		if (result > 0) {

			noticeDetail = noticeDAO.selectNoticeDetail(no);

			// 상세정보 가져오면 트랜잭션 커밋(db)
			if (noticeDetail != null) {
				session.commit();
			} else {
				session.rollback();
			}

		} else {
			session.rollback();
		}

		session.close();

		return noticeDetail;
	}

	// 공지사항 수정
	public int updateNotice(NoticeDTO originNotice) {
		SqlSession session = getSqlSession();
		noticeDAO = session.getMapper(NoticeDAO.class);

		int result = noticeDAO.updateNotice(originNotice);
		System.out.println("service의 result : " + result);

		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		session.close();

		return result;
	}

	// 공지사항 삭제
	public int deleteNotice(int no) {

		SqlSession session = getSqlSession();
		noticeDAO = session.getMapper(NoticeDAO.class);

		int result = noticeDAO.deleteNotice(no);
		System.out.println("dao.xml result : " + result);

		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		session.close();

		return result;
	}

}

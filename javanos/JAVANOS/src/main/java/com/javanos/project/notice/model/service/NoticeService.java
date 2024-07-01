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
		
		SqlSession session = getSqlSession();
		noticeDAO = session.getMapper(NoticeDAO.class);
		
		int totalCount = noticeDAO.selectTotalCount(searchMap);
		
		session.close();
		
		return totalCount;
	}
	
	// 전체 목록 조회 메소드 (페이징 처리 추가)
    public List<NoticeDTO> selectAllNoticeList(SelectCriteria selectCriteria) {
        SqlSession session = getSqlSession();
        noticeDAO = session.getMapper(NoticeDAO.class);

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

	// 제목으로 공지사항 검색 메소드
	public List<NoticeDTO> searchNoticeByTitle(String title) {

		SqlSession session = getSqlSession();
		noticeDAO = session.getMapper(NoticeDAO.class);

		List<NoticeDTO> searchResult = noticeDAO.searchNoticeByTitle(title);

		session.close();

		return searchResult;
	}

	// 내용으로 공지사항 검색 메소드
	public List<NoticeDTO> searchNoticeByBody(String body) {
		
		SqlSession session = getSqlSession();
		noticeDAO = session.getMapper(NoticeDAO.class);
		
		List<NoticeDTO> searchResult = noticeDAO.searchNoticeByBody(body);
		
		session.close();
		
		return searchResult;
	}

	// 제목 또는 내용으로 공지사항 검색 메소드
	public List<NoticeDTO> searchNoticeByTitleAndBody(String keyword) {
		SqlSession session = getSqlSession();
		noticeDAO = session.getMapper(NoticeDAO.class);

		List<NoticeDTO> noticeList = noticeDAO.searchNoticeByTitleAndBody(keyword);

		session.close();

		return noticeList;
	}
	


    // 제목 또는 내용으로 검색된 공지사항 수 조회 메소드
    public int getSearchNoticeCount(String searchCondition, String searchValue) {
        SqlSession session = getSqlSession();
        noticeDAO = session.getMapper(NoticeDAO.class);

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        int totalCount = noticeDAO.selectTotalCount(searchMap);

        session.close();

        return totalCount;
    }

   
}

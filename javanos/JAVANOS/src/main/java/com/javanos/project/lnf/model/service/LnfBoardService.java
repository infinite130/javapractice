package com.javanos.project.lnf.model.service;

import static com.javanos.project.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.javanos.project.lnf.model.dao.LnfDAO;
import com.javanos.project.lnf.model.dto.LnfBoardDTO;
import com.javanos.project.notice.model.dto.NoticeDTO;

public class LnfBoardService {
	
	private LnfDAO lnfDAO;
	
//	/* 페이징 처리를 위한 전체 게시물 수 조회용 메소드 */
//	public int selectTotalCount(Map<String, String> searchMap) {
//		
//		SqlSession session = getSqlSession();
//		lnfDAO = session.getMapper(LnfDAO.class);
//		
//		int totalCount = LnfDAO.selectTotalCount(searchMap);
//		
//		session.close();
//		
//		return totalCount;
//	}
	
	// 게시글 삽입
	public int enrollBoard(LnfBoardDTO enrollBoard) {
		
		SqlSession session = getSqlSession();
		lnfDAO = session.getMapper(LnfDAO.class);
		
		int result = lnfDAO.enrollBoard(enrollBoard);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
		
	}
	
	// 게시판 목록 조회
	public List<LnfBoardDTO> selectAllBoardList() {
		
		SqlSession session = getSqlSession();	
		lnfDAO = session.getMapper(LnfDAO.class);
		
		List<LnfBoardDTO> lnfBoardList = lnfDAO.selectAllBoardList();
		
		session.close();
		
		return lnfBoardList;
	}
	
	// 게시글 상세 보기 조회
		public LnfBoardDTO selectBoardDetail (int no) {
				
			SqlSession session = getSqlSession();
			lnfDAO = session.getMapper(LnfDAO.class);
				
			LnfBoardDTO lnfDetail = lnfDAO.selectBoardDetail(no);
			
			session.close();
			
			return lnfDetail;
		}

		
	// 게시글 수정
	public int modifyBoard(LnfBoardDTO modifyBoard) {
			
		SqlSession session = getSqlSession();
		lnfDAO = session.getMapper(LnfDAO.class);

		int result = lnfDAO.modifyBoard(modifyBoard);
		System.out.println(result);
			
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
			
		session.close();
			
		return result;
			
	}
		
	// 게시글 삭제
	public int deleteBoard(int no) {
			
		SqlSession session = getSqlSession();
		lnfDAO = session.getMapper(LnfDAO.class);
			
		int result = lnfDAO.deleteBoard(no);
			
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
			
		session.close();
			
		return result;
	}

	
	// <검색>
	
	// 호선으로 검색
		public List<LnfBoardDTO> searchByLine(String staLine) {

		SqlSession session = getSqlSession();
		lnfDAO = session.getMapper(LnfDAO.class);

		List<LnfBoardDTO> searchResult = lnfDAO.searchByLine(staLine);

		session.close();

		return searchResult;
	}

	// 역으로 검색
		public List<LnfBoardDTO> searchByStation(String staName) {
		
		SqlSession session = getSqlSession();
		lnfDAO = session.getMapper(LnfDAO.class);
		
		List<LnfBoardDTO> searchResult = lnfDAO.searchByStation(staName);
		
		session.close();
		
		return searchResult;
	}

	// 분실 품목으로 검색
		public List<LnfBoardDTO> searchByMissing(String missing) {
	
		SqlSession session = getSqlSession();
		lnfDAO = session.getMapper(LnfDAO.class);
	
		List<LnfBoardDTO> searchResult = lnfDAO.searchByMissing(missing);
	
		session.close();
	
		return searchResult;
	}
	
}
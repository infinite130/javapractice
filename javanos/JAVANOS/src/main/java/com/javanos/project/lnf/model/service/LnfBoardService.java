package com.javanos.project.lnf.model.service;

import static com.javanos.project.common.mybatis.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.javanos.project.lnf.model.dao.LnfDAO;
import com.javanos.project.lnf.model.dto.LnfBoardDTO;
import com.javanos.project.lnf.model.dto.StationDTO;

public class LnfBoardService {
	
	private LnfDAO lnfDAO;
	
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
		
	// 게시글 수정
	public int modifyBoard(LnfBoardDTO modifyBoard) {
			
		SqlSession session = getSqlSession();
		lnfDAO = session.getMapper(LnfDAO.class);
			
		int result = lnfDAO.enrollBoard(modifyBoard);
			
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
			
		session.close();
			
		return result;
			
	}
		
	// 게시글 삭제
	public int deleteBoard(LnfBoardDTO deleteBoard) {
			
		SqlSession session = getSqlSession();
		lnfDAO = session.getMapper(LnfDAO.class);
			
		int result = lnfDAO.enrollBoard(deleteBoard);
			
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
			
		session.close();
			
		return result;
	}
		
	// 게시글 상세 보기 조회
	public List<LnfBoardDTO> selectBoardDetail(int no) {
			
		SqlSession session = getSqlSession();
		lnfDAO = session.getMapper(LnfDAO.class);
			
		List<LnfBoardDTO> detailBoardList = lnfDAO.selectBoardDetail();
			
		session.close();
					
		return detailBoardList;
	}
		
	// 첫화면 
//	public String StaLine selectStaLine(){
//		
//		SqlSession session = getSqlSession();
//		lnfDAO = session.getMapper(LnfDAO.class);
//		
//		List<StationDTO> selectStaLine = lnfDAO.selectStaLine();
//		
//		session.close();
//		
//		return selectStaLine;
//		
//	}

}

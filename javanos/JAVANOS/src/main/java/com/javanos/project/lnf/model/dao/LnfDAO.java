package com.javanos.project.lnf.model.dao;

import java.util.List;
import java.util.Map;

import com.javanos.project.common.paging.SelectCriteria;
import com.javanos.project.lnf.model.dto.LnfBoardDTO;

public interface LnfDAO {
	
	// 게시글 삽입
	public int enrollBoard(LnfBoardDTO enrollBoard);
	
	// 게시판 목록 조회
	public List<LnfBoardDTO> selectAllBoardList();
	
	// 게시글 수정
	public int modifyBoard(LnfBoardDTO modifyBoard);
	
	// 게시글 삭제
	public int deleteBoard(int no);
	
	// 게시글 상세 보기 조회
	public LnfBoardDTO selectBoardDetail(int no);

	// paging
	public int selectTotalCount(Map<String, String> searchMap);
	
	public List<LnfBoardDTO> selectBoardList(SelectCriteria selectCriteria);
	
	
	// 호선으로 검색 메소드
		public List<LnfBoardDTO> searchByLine(String staLine);

	// 역으로 검색 메소드
		public List<LnfBoardDTO> searchByStation(String station);

	// 분실 품목으로 검색 메소드
	    public List<LnfBoardDTO> searchByMissing(String missing);
	




}

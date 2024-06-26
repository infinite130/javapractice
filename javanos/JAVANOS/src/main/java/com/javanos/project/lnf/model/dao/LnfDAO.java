package com.javanos.project.lnf.model.dao;

import java.util.List;

import com.javanos.project.lnf.model.dto.LnfBoardDTO;
import com.javanos.project.lnf.model.dto.StationDTO;

public interface LnfDAO {
	
	// 게시글 삽입
	public int enrollBoard(LnfBoardDTO enrollBoard);
	
	// 게시판 목록 조회
	public List<LnfBoardDTO> selectAllBoardList();
	
	// 게시글 수정
	public int modifyBoard(LnfBoardDTO modifyBoard);
	
	// 게시글 삭제
	public int deleteBoard(LnfBoardDTO deleteBoard);
	
	// 게시글 상세 보기 조회
	public List<LnfBoardDTO> selectBoardDetail();
	
	// 첫화면 
	public List<StationDTO> getAllStationLine();

	public List<StationDTO> getStationNamesByLine(String staLine);

}

package com.javanos.project.down.model.dao;

import java.util.Map;

import java.util.List;
import java.util.Map;

import com.javanos.project.common.paging.SelectCriteria;
//import com.javanos.project.common.paging.SelectCriteria;
import com.javanos.project.down.model.dto.DownDTO;
import com.javanos.project.lnf.model.dto.StationDTO;

public interface DownDAO {
	
	public List<DownDTO> selectDownList(SelectCriteria selectCriteria); 
	
	public int selectTotalCount(Map<String, String> searchMap);
	
	/*역 정보 조회 메소드 */      
	public List<StationDTO> selectStationList();
	                        
	/* 내려요 게시글 목록 전체 조회 메소드 */
	public List<DownDTO> selectAllDownList();
	
	/* 내려요 게시글 테이블 삽입용 메소드 */
	public int insertDown(DownDTO newDown);

	/* 내려요 게시글 삭제 메소드 */
   public int deleteDown(int deletedw);
  

	

}

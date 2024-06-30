package com.javanos.project.down.model.service;

import org.apache.ibatis.session.SqlSession;
import static com.javanos.project.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import com.javanos.project.common.paging.SelectCriteria;
import com.javanos.project.down.model.dao.DownDAO;
import com.javanos.project.down.model.dto.DownDTO;
import com.javanos.project.notice.model.dao.NoticeDAO;

public class DownService {

	private DownDAO downDAO;
	

	/* 페이징 처리를 위한 전체 게시물 수 조회용 메소드 */
	public int selectTotalCount(Map<String, String> searchMap) {

		SqlSession session = getSqlSession();
		downDAO = session.getMapper(DownDAO.class);

		int totalCount = downDAO.selectTotalCount(searchMap);

		session.close();

		return totalCount;
	}

	/* 게시물 전체 조회용 메소드 */ 
	public List<DownDTO> selectDownList(SelectCriteria selectCriteria) { 
		SqlSession session = getSqlSession();
		downDAO = session.getMapper(DownDAO.class);

		selectCriteria.setStartRow(selectCriteria.getStartRow() - 1);
		/*
		 * 페이징 처리 관련 메소드
		 */ List<DownDTO> downList = downDAO.selectDownList(selectCriteria);

		session.close();

		return downList;
	}

	/* 신규 게시물 등록용 메소드 */
	public int insertDown(DownDTO newDown) {

		SqlSession session = getSqlSession();
		downDAO = session.getMapper(DownDAO.class);

		int result = downDAO.insertDown(newDown);

		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		session.close();

		return result;
	}
	
	/* 내려요 게시물 삭제 메소드 */
	public int deleteDown(int deletedw) {

		SqlSession session = getSqlSession();
		downDAO = session.getMapper(DownDAO.class);

		int result = downDAO.deleteDown(deletedw);

		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		session.close();

		return result;
	}
}

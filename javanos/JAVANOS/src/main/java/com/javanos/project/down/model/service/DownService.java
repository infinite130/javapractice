package com.javanos.project.down.model.service;

import org.apache.ibatis.session.SqlSession;
import static com.javanos.project.common.mybatis.Template.getSqlSession;
import com.javanos.project.down.model.dao.DownDAO;
import com.javanos.project.down.model.dto.DownDTO;

public class DownService {
	
	private DownDAO downDAO;
	
	/* 게시물 전체 조회용 메소드 */

	/* 신규 게시물 등록용 메소드 */
	public int insertDown(DownDTO newDown) {
		
		SqlSession session = getSqlSession();
		downDAO = session.getMapper(DownDAO.class);
		
		int result = downDAO.insertDown(newDown);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}
}


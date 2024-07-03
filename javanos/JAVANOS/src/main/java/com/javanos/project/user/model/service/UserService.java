package com.javanos.project.user.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.javanos.project.community.model.dto.CommunityDTO;
import com.javanos.project.user.model.dao.UserDAO;
import com.javanos.project.user.model.dto.UserDTO;

import static com.javanos.project.common.mybatis.Template.getSqlSession;

import java.util.List;

public class UserService {

	private UserDAO userDAO;

	public int checkDupUserId(String userId) {
		SqlSession session = getSqlSession();
		userDAO = session.getMapper(UserDAO.class);

		int result = userDAO.selectCountByUserId(userId);

		session.close();
		return result;
	}
	
	public int checkDupUserNickname(String userNickname) {
		SqlSession session = getSqlSession();
		userDAO = session.getMapper(UserDAO.class);
		
		int result = userDAO.selectCountByUserNickname(userNickname);
		
		session.close();
		return result;
	}
	
	public int checkDupUserEmail(String userEmail) {
		SqlSession session = getSqlSession();
		userDAO = session.getMapper(UserDAO.class);
		
		int result = userDAO.selectCountByUserEmail(userEmail);
		
		session.close();
		return result;
	}

	public int joinUser(UserDTO requestUser) {
		SqlSession session = getSqlSession();
		userDAO = session.getMapper(UserDAO.class);

		int result = userDAO.insertUser(requestUser);

		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public UserDTO loginCheck(UserDTO requestUser) {
		SqlSession session = getSqlSession();
		userDAO = session.getMapper(UserDAO.class);

		UserDTO loginUser = null;

		// 로그인 아이디와 비밀번호가 null이 아닌 경우에 로그인 처리
		if (requestUser.getUserId() != null && requestUser.getUserPwd() != null) {
			String storedPwd = userDAO.selectPwd(requestUser);

			if (storedPwd != null) {
				// 로그인 요청한 원문 비밀번호와 저장되어있는 평문화 비밀번호가 일치하는지 확인 (admin계정)
				if (storedPwd.equals(requestUser.getUserPwd())) {
					loginUser = userDAO.selectLoginUser(requestUser);
				} else {
					BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

					// 로그인 요청한 원문 비밀번호와 저장되어있는 암호화된 비밀번호가 일치하는지 확인
					// 비밀번호가 일치하는 경우에만 회원 정보를 조회
					if (passwordEncoder.matches(requestUser.getUserPwd(), storedPwd)) {
						loginUser = userDAO.selectLoginUser(requestUser);
					}
				}
			}
		}

		session.close();
		return loginUser;
	}

	public UserDTO updateUser(UserDTO originUser) {
		SqlSession session = getSqlSession();
		userDAO = session.getMapper(UserDAO.class);
		
		UserDTO updateUser = null;
		
		int result = userDAO.updateUser(originUser);
		if(result > 0) {
			session.commit();
			updateUser = userDAO.selectLoginUser(originUser);
		} else {
			session.close();
		}
		
		return updateUser;
	}

	public int deleteUser(UserDTO loginUser) {
		SqlSession session = getSqlSession();
		userDAO = session.getMapper(UserDAO.class);
		
		int result  = userDAO.deleteUser(loginUser);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public String checkPwd(UserDTO loginUser) {
		SqlSession session = getSqlSession();
		userDAO = session.getMapper(UserDAO.class);
		
		String userPwd = userDAO.selectPwd(loginUser);
		
		return userPwd;
	}

	public List<CommunityDTO> selectBoardList(UserDTO loginUser) {
		
		SqlSession session = getSqlSession();
		userDAO = session.getMapper(UserDAO.class);
		
		List<CommunityDTO> communityList = userDAO.selectBoardList(loginUser);
		
		System.out.println("service : " + communityList);
		
		session.close();
		
		return communityList;
	}

}
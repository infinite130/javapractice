package com.javanos.project.user.model.dao;

import com.javanos.project.user.model.dto.UserDTO;

public interface UserDAO {
	
	int selectCountByUserId(String userId);
	
	int selectCountByUserNickname(String userNickname);
	
	int selectCountByUserEmail(String userEmail);

	int insertUser(UserDTO requestUser);
	
	String selectPwd(UserDTO requestUser);

	UserDTO selectLoginUser(UserDTO requestUser);

	int updateUser(UserDTO originUser);

	int deleteUser(UserDTO loginUser);

}

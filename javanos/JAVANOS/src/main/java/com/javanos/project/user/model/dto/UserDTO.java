package com.javanos.project.user.model.dto;

import java.sql.Date;

public class UserDTO implements java.io.Serializable {

	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String userNickname;
	private String userEmail;
	private String userRole;
	private Date userEnrollDate;
	private String userStatus;
	private Date userStopDate;

	public UserDTO() {
		super();
	}

	public UserDTO(int userNo, String userId, String userPwd, String userName, String userNickname, String userEmail,
			String userRole, Date userEnrollDate, String userStatus, Date userStopDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userEmail = userEmail;
		this.userRole = userRole;
		this.userEnrollDate = userEnrollDate;
		this.userStatus = userStatus;
		this.userStopDate = userStopDate;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Date getUserEnrollDate() {
		return userEnrollDate;
	}

	public void setUserEnrollDate(Date userEnrollDate) {
		this.userEnrollDate = userEnrollDate;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public Date getUserStopDate() {
		return userStopDate;
	}

	public void setUserStopDate(Date userStopDate) {
		this.userStopDate = userStopDate;
	}

	@Override
	public String toString() {
		return "UserDTO [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", userNickname=" + userNickname + ", userEmail=" + userEmail + ", userRole=" + userRole
				+ ", userEnrollDate=" + userEnrollDate + ", userStatus=" + userStatus + ", userStopDate=" + userStopDate
				+ "]";
	}

}

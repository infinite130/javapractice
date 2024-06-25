package com.javanos.project.community.model.dto;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import com.javanos.project.user.model.dto.UserDTO;

public class CommunityDTO implements java.io.Serializable{

	private int communityNo;
	private String communityTitle;
	private String communityBody;
	private int communityCount;
	private LocalDateTime communityEnrollDate;
	private LocalDateTime communityModifyDate;
	private String communityBoardStatus;
	private int userNo;
	private UserDTO user;
	private List<PictureDTO> pictureList;
	
	public CommunityDTO() {
		super();
	}

	public CommunityDTO(int communityNo, String communityTitle, String communityBody, int communityCount,
			LocalDateTime communityEnrollDate, LocalDateTime communityModifyDate, String communityBoardStatus, int userNo, UserDTO user,
			List<PictureDTO> pictureList) {
		super();
		this.communityNo = communityNo;
		this.communityTitle = communityTitle;
		this.communityBody = communityBody;
		this.communityCount = communityCount;
		this.communityEnrollDate = communityEnrollDate;
		this.communityModifyDate = communityModifyDate;
		this.communityBoardStatus = communityBoardStatus;
		this.userNo = userNo;
		this.user = user;
		this.pictureList = pictureList;
	}

	public int getCommunityNo() {
		return communityNo;
	}

	public void setCommunityNo(int communityNo) {
		this.communityNo = communityNo;
	}

	public String getCommunityTitle() {
		return communityTitle;
	}

	public void setCommunityTitle(String communityTitle) {
		this.communityTitle = communityTitle;
	}

	public String getCommunityBody() {
		return communityBody;
	}

	public void setCommunityBody(String communityBody) {
		this.communityBody = communityBody;
	}

	public int getCommunityCount() {
		return communityCount;
	}

	public void setCommunityCount(int communityCount) {
		this.communityCount = communityCount;
	}

	public LocalDateTime getCommunityEnrollDate() {
		return communityEnrollDate;
	}

	public void setCommunityEnrollDate(LocalDateTime communityEnrollDate) {
		this.communityEnrollDate = communityEnrollDate;
	}

	public LocalDateTime getCommunityModifyDate() {
		return communityModifyDate;
	}

	public void setCommunityModifyDate(LocalDateTime communityModifyDate) {
		this.communityModifyDate = communityModifyDate;
	}

	public String getCommunityBoardStatus() {
		return communityBoardStatus;
	}

	public void setCommunityBoardStatus(String communityBoardStatus) {
		this.communityBoardStatus = communityBoardStatus;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public List<PictureDTO> getPictureList() {
		return pictureList;
	}

	public void setPictureList(List<PictureDTO> pictureList) {
		this.pictureList = pictureList;
	}

	@Override
	public String toString() {
		return "CommunityDTO [communityNo=" + communityNo + ", communityTitle=" + communityTitle + ", communityBody="
				+ communityBody + ", communityCount=" + communityCount + ", communityEnrollDate=" + communityEnrollDate
				+ ", communityModifyDate=" + communityModifyDate + ", communityBoardStatus=" + communityBoardStatus
				+ ", userNo=" + userNo + ", user=" + user + ", pictureList=" + pictureList + "]";
	}

	
	
	
	
	
}

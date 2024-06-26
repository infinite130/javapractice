package com.javanos.project.lnf.model.dto;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import com.javanos.project.user.model.dto.UserDTO;

public class LnfBoardDTO implements java.io.Serializable  {
	
	private int lnfNo;
	private String missing;
	private Date findDate;
	private Time findTime;
	private String keep;
	private String description;
	private LocalDateTime enrollDate;
	private LocalDateTime modifyDate;
	private String boardStatus;
	private UserDTO userNo;
	private StationDTO staNo;
	
	public LnfBoardDTO() {
		super();
	}

	public LnfBoardDTO(int lnfNo, String missing, Date findDate, Time findTime, String keep, String description,
			LocalDateTime enrollDate, LocalDateTime modifyDate, String boardStatus, UserDTO userNo, StationDTO staNo) {
		super();
		this.lnfNo = lnfNo;
		this.missing = missing;
		this.findDate = findDate;
		this.findTime = findTime;
		this.keep = keep;
		this.description = description;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.boardStatus = boardStatus;
		this.userNo = userNo;
		this.staNo = staNo;
	}

	public int getLnfNo() {
		return lnfNo;
	}

	public void setLnfNo(int lnfNo) {
		this.lnfNo = lnfNo;
	}

	public String getMissing() {
		return missing;
	}

	public void setMissing(String missing) {
		this.missing = missing;
	}

	public Date getFindDate() {
		return findDate;
	}

	public void setFindDate(Date findDate) {
		this.findDate = findDate;
	}

	public Time getFindTime() {
		return findTime;
	}

	public void setFindTime(Time findTime) {
		this.findTime = findTime;
	}

	public String getKeep() {
		return keep;
	}

	public void setKeep(String keep) {
		this.keep = keep;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(LocalDateTime enrollDate) {
		this.enrollDate = enrollDate;
	}

	public LocalDateTime getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(LocalDateTime modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getBoardStatus() {
		return boardStatus;
	}

	public void setBoardStatus(String boardStatus) {
		this.boardStatus = boardStatus;
	}

	public UserDTO getUserNo() {
		return userNo;
	}

	public void setUserNo(UserDTO userNo) {
		this.userNo = userNo;
	}

	public StationDTO getStaNo() {
		return staNo;
	}

	public void setStaNo(StationDTO staNo) {
		this.staNo = staNo;
	}

	@Override
	public String toString() {
		return "LnfBoardDTO [lnfNo=" + lnfNo + ", missing=" + missing + ", findDate=" + findDate + ", findTime="
				+ findTime + ", keep=" + keep + ", description=" + description + ", enrollDate=" + enrollDate
				+ ", modifyDate=" + modifyDate + ", boardStatus=" + boardStatus + ", userNo=" + userNo + ", staNo="
				+ staNo + "]";
	}
	
	

}
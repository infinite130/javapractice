package com.javanos.project.down.model.dto;

import java.sql.Date;

import com.javanos.project.lnf.model.dto.StationDTO;
import com.javanos.project.user.model.dto.UserDTO;

public class DownDTO implements java.io.Serializable {

	private int downNo;
	private String downRoom; //칸
	private String downFull; //혼잡도
	private Date downEnrollDate; //등록일(작성일)
	private Date downModifyDate; //수정일
	private String downStatus; //게시판 삭제
	private int userNo;
	private UserDTO user; //객체 가져다가 , 닉네임과 아이디 사용 할 수 있음 
	private int inStationNo;
	private StationDTO inStation; //현재역
    private int downStationNo;
	private StationDTO downStation; //내릴역
	
	public DownDTO() {
		
	}

	public DownDTO(int downNo, String downRoom, String downFull, Date downEnrollDate, Date downModifyDate,
			String downStatus, int userNo, UserDTO user, int inStationNo, StationDTO inStation, int downStationNo,
			StationDTO downStation) {
		super();
		this.downNo = downNo;
		this.downRoom = downRoom;
		this.downFull = downFull;
		this.downEnrollDate = downEnrollDate;
		this.downModifyDate = downModifyDate;
		this.downStatus = downStatus;
		this.userNo = userNo;
		this.user = user;
		this.inStationNo = inStationNo;
		this.inStation = inStation;
		this.downStationNo = downStationNo;
		this.downStation = downStation;
	}

	public int getDownNo() {
		return downNo;
	}

	public void setDownNo(int downNo) {
		this.downNo = downNo;
	}

	public String getDownRoom() {
		return downRoom;
	}

	public void setDownRoom(String downRoom) {
		this.downRoom = downRoom;
	}

	public String getDownFull() {
		return downFull;
	}

	public void setDownFull(String downFull) {
		this.downFull = downFull;
	}

	public Date getDownEnrollDate() {
		return downEnrollDate;
	}

	public void setDownEnrollDate(Date downEnrollDate) {
		this.downEnrollDate = downEnrollDate;
	}

	public Date getDownModifyDate() {
		return downModifyDate;
	}

	public void setDownModifyDate(Date downModifyDate) {
		this.downModifyDate = downModifyDate;
	}

	public String getDownStatus() {
		return downStatus;
	}

	public void setDownStatus(String downStatus) {
		this.downStatus = downStatus;
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

	public int getInStationNo() {
		return inStationNo;
	}

	public void setInStationNo(int inStationNo) {
		this.inStationNo = inStationNo;
	}

	public StationDTO getInStation() {
		return inStation;
	}

	public void setInStation(StationDTO inStation) {
		this.inStation = inStation;
	}

	public int getDownStationNo() {
		return downStationNo;
	}

	public void setDownStationNo(int downStationNo) {
		this.downStationNo = downStationNo;
	}

	public StationDTO getDownStation() {
		return downStation;
	}

	public void setDownStation(StationDTO downStation) {
		this.downStation = downStation;
	}

	@Override
	public String toString() {
		return "DownDTO [downNo=" + downNo + ", downRoom=" + downRoom + ", downFull=" + downFull + ", downEnrollDate="
				+ downEnrollDate + ", downModifyDate=" + downModifyDate + ", downStatus=" + downStatus + ", userNo="
				+ userNo + ", user=" + user + ", inStationNo=" + inStationNo + ", inStation=" + inStation
				+ ", downStationNo=" + downStationNo + ", downStation=" + downStation + "]";
	}

	
}
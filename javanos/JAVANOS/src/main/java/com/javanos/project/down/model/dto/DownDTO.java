package com.javanos.project.down.model.dto;

import java.sql.Date;

import com.javanos.project.lnf.model.dto.StationDTO;
import com.javanos.project.user.model.dto.UserDTO;

public class DownDTO implements java.io.Serializable {

	private int downNo;
	private String downRoom;
	private String downFull;
	private Date downEnrollDate;
	private Date downModifyDate;
	private String downStatus;
	private UserDTO userName; //객체 가져다가 , 닉네임과 아이디 사용 할 수 있음 
	private StationDTO station;
	
	
	public DownDTO() {
		super();
		
	}

	public DownDTO(int downNo, String downRoom, String downFull, Date downEnrollDate, Date downModifyDate,
			String downStatus, UserDTO userName, StationDTO station) {
		super();
		this.downNo = downNo;
		this.downRoom = downRoom;
		this.downFull = downFull;
		this.downEnrollDate = downEnrollDate;
		this.downModifyDate = downModifyDate;
		this.downStatus = downStatus;
		this.userName = userName;
		this.station = station;
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

	public UserDTO getUserName() {
		return userName;
	}

	public void setUserName(UserDTO userName) {
		this.userName = userName;
	}

	public StationDTO getStation() {
		return station;
	}

	public void setStation(StationDTO station) {
		this.station = station;
	}

	@Override
	public String toString() {
		return "DownDTO [downNo=" + downNo + ", downRoom=" + downRoom + ", downFull=" + downFull + ", downEnrollDate="
				+ downEnrollDate + ", downModifyDate=" + downModifyDate + ", downStatus=" + downStatus + ", userName="
				+ userName + ", station=" + station + "]";
	}
	
	
	
}

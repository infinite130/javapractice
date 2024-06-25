package com.javanos.project.community.model.dto;

import javax.tools.JavaCompiler;

public class PictureDTO implements java.io.Serializable{
	
	private int picNo;
	private String originalName;
	private String saveName;
	private String savePath;
	private String fileType;
	private String thumbnailPath;
	private String picBoardStatus;
	private int communityNo;
	
	
	public PictureDTO() {
		super();
	}


	public PictureDTO(int picNo, String originalName, String saveName, String savePath, String fileType,
			String thumbnailPath, String picBoardStatus, int communityNo) {
		super();
		this.picNo = picNo;
		this.originalName = originalName;
		this.saveName = saveName;
		this.savePath = savePath;
		this.fileType = fileType;
		this.thumbnailPath = thumbnailPath;
		this.picBoardStatus = picBoardStatus;
		this.communityNo = communityNo;
	}


	public int getPicNo() {
		return picNo;
	}


	public void setPicNo(int picNo) {
		this.picNo = picNo;
	}


	public String getOriginalName() {
		return originalName;
	}


	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}


	public String getSaveName() {
		return saveName;
	}


	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}


	public String getSavePath() {
		return savePath;
	}


	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}


	public String getFileType() {
		return fileType;
	}


	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	public String getThumbnailPath() {
		return thumbnailPath;
	}


	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}


	public String getPicBoardStatus() {
		return picBoardStatus;
	}


	public void setPicBoardStatus(String picBoardStatus) {
		this.picBoardStatus = picBoardStatus;
	}


	public int getCommunityNo() {
		return communityNo;
	}


	public void setCommunityNo(int communityNo) {
		this.communityNo = communityNo;
	}


	@Override
	public String toString() {
		return "PictureDTO [picNo=" + picNo + ", originalName=" + originalName + ", saveName=" + saveName
				+ ", savePath=" + savePath + ", fileType=" + fileType + ", thumbnailPath=" + thumbnailPath
				+ ", picBoardStatus=" + picBoardStatus + ", communityNo=" + communityNo + "]";
	}


	
	
	

}

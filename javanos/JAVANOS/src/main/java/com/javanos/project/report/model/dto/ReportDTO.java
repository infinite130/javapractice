package com.javanos.project.report.model.dto;

import java.sql.Date;

import com.javanos.project.community.model.dto.CommunityDTO;
import com.javanos.project.user.model.dto.UserDTO;

public class ReportDTO {
	
	
	private int reportNo;
	private UserDTO reporter;
	private Date reportDate;
	private String reportReason;
	private String reportStatus;
	private UserDTO reported;
	private CommunityDTO communityNo;
	
	public ReportDTO() {
		super();
	}

	public ReportDTO(int reportNo, UserDTO reporter, Date reportDate, String reportReason, String reportStatus,
			UserDTO reported, CommunityDTO communityNo) {
		super();
		this.reportNo = reportNo;
		this.reporter = reporter;
		this.reportDate = reportDate;
		this.reportReason = reportReason;
		this.reportStatus = reportStatus;
		this.reported = reported;
		this.communityNo = communityNo;
	}

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public UserDTO getReporter() {
		return reporter;
	}

	public void setReporter(UserDTO reporter) {
		this.reporter = reporter;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportReason() {
		return reportReason;
	}

	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}

	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

	public UserDTO getReported() {
		return reported;
	}

	public void setReported(UserDTO reported) {
		this.reported = reported;
	}

	public CommunityDTO getCommunityNo() {
		return communityNo;
	}

	public void setCommunityNo(CommunityDTO communityNo) {
		this.communityNo = communityNo;
	}

	@Override
	public String toString() {
		return "ReportDTO [reportNo=" + reportNo + ", reporter=" + reporter + ", reportDate=" + reportDate
				+ ", reportReason=" + reportReason + ", reportStatus=" + reportStatus + ", reported=" + reported
				+ ", communityNo=" + communityNo + "]";
	}
	
	
	
	
	
}

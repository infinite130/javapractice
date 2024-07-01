package com.javanos.project.report.model.dto;

import java.sql.Date;
import com.javanos.project.user.model.dto.UserDTO;

public class ReportDTO implements java.io.Serializable {

    private int reportNo;
    private String reportReason;
    private Date reportDate;
    private String reportStatus;
    private UserDTO reportUser;  // 신고자
    private UserDTO reportedUser;  // 신고당한 회원

    // 기본 생성자
    public ReportDTO() {
        super();
    }

    // 모든 필드를 포함한 생성자
    public ReportDTO(int reportNo, String reportReason, Date reportDate, String reportStatus, UserDTO reportUser, UserDTO reportedUser) {
        super();
        this.reportNo = reportNo;
        this.reportReason = reportReason;
        this.reportDate = reportDate;
        this.reportStatus = reportStatus;
        this.reportUser = reportUser;
        this.reportedUser = reportedUser;
    }

    // Getters and Setters
    public int getReportNo() {
        return reportNo;
    }

    public void setReportNo(int reportNo) {
        this.reportNo = reportNo;
    }

    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    public UserDTO getReportUser() {
        return reportUser;
    }

    public void setReportUser(UserDTO reportUser) {
        this.reportUser = reportUser;
    }

    public UserDTO getReportedUser() {
        return reportedUser;
    }

    public void setReportedUser(UserDTO reportedUser) {
        this.reportedUser = reportedUser;
    }

    @Override
    public String toString() {
        return "ReportDTO [reportNo=" + reportNo + ", reportReason=" + reportReason + ", reportDate=" + reportDate + ", reportStatus=" + reportStatus + ", reportUser=" + reportUser + ", reportedUser=" + reportedUser + "]";
    }
}
package com.javanos.project.report.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.javanos.project.report.model.dto.ReportDTO;
import com.javanos.project.user.model.dto.UserDTO;

public interface ReportDAO {
    List<ReportDTO> selectAllReports();
    int insertReport(ReportDTO report);
    ReportDTO selectReportByNo(int reportNo);
    
    UserDTO selectUserByUserId(@Param("userId") String userId);
    
    int deleteReport(int reportNo);

    String selectUserNicknameByUserNo(@Param("userNo") int userNo);
    
    // 회원 정지 메서드
    int banUserByUserNo(@Param("userNo") int userNo);
    int updateReportStatus(@Param("reportNo") int reportNo, @Param("reportStatus") String reportStatus);
}
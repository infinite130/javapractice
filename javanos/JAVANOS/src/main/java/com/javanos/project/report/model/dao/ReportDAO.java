package com.javanos.project.report.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.javanos.project.report.model.dto.ReportDTO;
import com.javanos.project.user.model.dto.UserDTO;

public interface ReportDAO {
    List<ReportDTO> selectAllReports();
    int insertReport(ReportDTO report);
    ReportDTO selectReportByNo(int reportNo);
    
    // UserDTO 조회 메서드 추가
    //UserDTO selectUserByUserId(@Param("userId") String userId);
    UserDTO selectUserByUserId(String userId);
}
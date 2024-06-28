package com.javanos.project.report.model.dao;

import java.util.List;
import com.javanos.project.report.model.dto.ReportDTO;

public interface ReportDAO {
	
	 // 모든 신고를 조회
    List<ReportDTO> getAllReports();
    
    // 특정 ID로 신고를 조회
    ReportDTO getReportById(int reportId);
    
    // 새로운 신고를 추가
    int addReport(ReportDTO report);
    
    // 신고 정보를 업데이트
    int updateReport(ReportDTO report);
    
    // 특정 ID의 신고를 삭제
    int deleteReport(int reportId);
}

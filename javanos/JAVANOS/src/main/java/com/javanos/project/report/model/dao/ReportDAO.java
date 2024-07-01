package com.javanos.project.report.model.dao;

import java.util.List;
import com.javanos.project.report.model.dto.ReportDTO;
import com.javanos.project.user.model.dto.UserDTO;

public interface ReportDAO {
    List<ReportDTO> selectAllReports();
    int insertReport(ReportDTO report);
    ReportDTO selectReportByNo(int reportNo);
    UserDTO selectUserByUserNo(int userNo);
    int deleteReport(int reportNo); // 신고 삭제 메서드
}

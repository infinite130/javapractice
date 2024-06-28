package com.javanos.project.report.model.service;

import java.util.List;
import com.javanos.project.report.model.dao.ReportDAO;
import com.javanos.project.report.model.dto.ReportDTO;
import com.javanos.project.common.mybatis.Template;
import org.apache.ibatis.session.SqlSession;

public class ReportService {
    private ReportDAO reportDAO;

    public ReportService() {
        SqlSession sqlSession = Template.getSqlSession();
        this.reportDAO = sqlSession.getMapper(ReportDAO.class);
    }

    // 모든 신고를 조회
    public List<ReportDTO> getAllReports() {
        return reportDAO.getAllReports();
    }

    // 특정 ID로 신고를 조회
    public ReportDTO getReportById(int reportId) {
        return reportDAO.getReportById(reportId);
    }

    // 새로운 신고를 추가
    public void addReport(ReportDTO report) {
        reportDAO.addReport(report);
    }

    // 신고 정보를 업데이트
    public void updateReport(ReportDTO report) {
        reportDAO.updateReport(report);
    }

    // 특정 ID의 신고를 삭제
    public void deleteReport(int reportId) {
        reportDAO.deleteReport(reportId);
    }
}

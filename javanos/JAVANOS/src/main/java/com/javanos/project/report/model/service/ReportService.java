package com.javanos.project.report.model.service;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import static com.javanos.project.common.mybatis.Template.getSqlSession;
import com.javanos.project.report.model.dao.ReportDAO;
import com.javanos.project.report.model.dto.ReportDTO;
import com.javanos.project.user.model.dto.UserDTO;

public class ReportService {
    private ReportDAO reportDAO;

    public List<ReportDTO> selectAllReports() {
        SqlSession session = getSqlSession();
        reportDAO = session.getMapper(ReportDAO.class);
        List<ReportDTO> reportList = reportDAO.selectAllReports();
        session.close();
        return reportList;
    }

    public int insertReport(ReportDTO report) {
        SqlSession session = getSqlSession();
        reportDAO = session.getMapper(ReportDAO.class);
        int result = reportDAO.insertReport(report);
        if (result > 0) {
            session.commit();
        } else {
            session.rollback();
        }
        session.close();
        return result;
    }

    public ReportDTO selectReportByNo(int reportNo) {
        SqlSession session = getSqlSession();
        reportDAO = session.getMapper(ReportDAO.class);
        ReportDTO report = reportDAO.selectReportByNo(reportNo);
        session.close();
        return report;
    }

    public UserDTO selectUserByUserId(String userId) {
        SqlSession session = getSqlSession();
        reportDAO = session.getMapper(ReportDAO.class);
        UserDTO user = reportDAO.selectUserByUserId(userId);
        session.close();
        return user;
    }
}
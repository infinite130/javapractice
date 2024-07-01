package com.javanos.project.report.model.service;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import static com.javanos.project.common.mybatis.Template.getSqlSession;
import com.javanos.project.report.model.dao.ReportDAO;
import com.javanos.project.report.model.dto.ReportDTO;
import com.javanos.project.user.model.dto.UserDTO;
import com.javanos.project.user.model.service.UserService;

public class ReportService {
    private ReportDAO reportDAO;
    private UserService userService = new UserService();

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

    public UserDTO selectUserByUserNo(int userNo) {
        SqlSession session = getSqlSession();
        reportDAO = session.getMapper(ReportDAO.class);
        UserDTO user = reportDAO.selectUserByUserNo(userNo);
        session.close();
        return user;
    }

    public int deleteReport(int reportNo) {
        SqlSession session = getSqlSession();
        reportDAO = session.getMapper(ReportDAO.class);
        int result = reportDAO.deleteReport(reportNo);
        if (result > 0) {
            session.commit();
        } else {
            session.rollback();
        }
        session.close();
        return result;
    }
    
    public void suspendUserAccount(String userId) throws Exception {
        userService.suspendUserAccount(userId); // UserService의 메서드 호출
    }
}

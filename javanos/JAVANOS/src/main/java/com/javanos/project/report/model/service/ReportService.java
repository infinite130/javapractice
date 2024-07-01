package com.javanos.project.report.model.service;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import static com.javanos.project.common.mybatis.Template.getSqlSession;

import com.javanos.project.report.model.dao.ReportDAO;
import com.javanos.project.report.model.dto.ReportDTO;
import com.javanos.project.user.model.dto.UserDTO;

public class ReportService {
    private ReportDAO reportDAO;
    
    public ReportService() {
        // ReportDAO 인터페이스를 직접 인스턴스화할 수 없습니다.
    }

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
    
    public boolean deleteReport(int reportNo) {
        SqlSession session = getSqlSession();
        reportDAO = session.getMapper(ReportDAO.class);
        int result = reportDAO.deleteReport(reportNo);
        System.out.println("deleteReport result: " + result); // 디버깅 정보 출력
        if (result > 0) {
            session.commit();
            return true;
        } else {
            session.rollback();
            return false;
        }
    }
    
    public String getUserNicknameByUserNo(int userNo) {
        SqlSession session = getSqlSession();
        reportDAO = session.getMapper(ReportDAO.class);
        String userNickname = reportDAO.selectUserNicknameByUserNo(userNo);
        session.close();
        return userNickname;
    }

    public boolean banUserByUserNo(int userNo) {
        SqlSession session = getSqlSession();
        reportDAO = session.getMapper(ReportDAO.class);
        int result = reportDAO.banUserByUserNo(userNo);
        System.out.println("banUserByUserNo result: " + result); // 디버깅 정보 출력
        if (result > 0) {
            session.commit();
            return true;
        } else {
            session.rollback();
            return false;
        }
    }

    public boolean updateReportStatus(int reportNo, String reportStatus) {
        SqlSession session = getSqlSession();
        reportDAO = session.getMapper(ReportDAO.class);
        int result = reportDAO.updateReportStatus(reportNo, reportStatus);
        System.out.println("updateReportStatus result: " + result); // 디버깅 정보 출력
        if (result > 0) {
            session.commit();
            return true;
        } else {
            session.rollback();
            return false;
        }
    }
}
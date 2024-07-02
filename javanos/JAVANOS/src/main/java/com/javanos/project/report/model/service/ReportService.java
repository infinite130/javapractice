package com.javanos.project.report.model.service;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.javanos.project.common.mybatis.Template.getSqlSession;

import com.javanos.project.report.model.dao.ReportDAO;
import com.javanos.project.report.model.dto.ReportDTO;
import com.javanos.project.user.model.dto.UserDTO;
import com.javanos.project.community.model.dto.CommunityDTO; 
import com.javanos.project.common.paging.SelectCriteria; // Import 추가

public class ReportService {
    private ReportDAO reportDAO;
    private static final Logger logger = LoggerFactory.getLogger(ReportService.class);

    public ReportService() {
        // ReportDAO 인터페이스를 직접 인스턴스화할 수 없습니다.
    }

    public int selectTotalCount() {
        SqlSession session = getSqlSession();
        reportDAO = session.getMapper(ReportDAO.class);
        int totalCount = reportDAO.selectTotalCount();
        session.close();
        return totalCount;
    }

    public List<ReportDTO> selectReports(SelectCriteria selectCriteria) {
        SqlSession session = getSqlSession();
        reportDAO = session.getMapper(ReportDAO.class);

        // startRow를 미리 계산하여 전달
        selectCriteria.setStartRow(selectCriteria.getStartRow() - 1);

        List<ReportDTO> reportList = reportDAO.selectReports(selectCriteria);
        session.close();
        return reportList;
    }


    public List<ReportDTO> selectAllReports() {
        SqlSession session = getSqlSession();
        reportDAO = session.getMapper(ReportDAO.class);
        List<ReportDTO> reportList = reportDAO.selectAllReports();
        logger.debug("selectAllReports - reportList: {}", reportList);
        session.close();
        return reportList;
    }

    public int insertReport(ReportDTO reportDTO) {
        SqlSession session = getSqlSession();
        reportDAO = session.getMapper(ReportDAO.class);
        int result = reportDAO.insertReport(reportDTO);
        session.commit();
        session.close();
        return result;
    }

    public UserDTO selectUserByUserId(String userId) {
        SqlSession session = getSqlSession();
        reportDAO = session.getMapper(ReportDAO.class);
        UserDTO user = reportDAO.selectUserByUserId(userId);
        logger.debug("selectUserByUserId - userId: {}, user: {}", userId, user);
        session.close();
        return user;
    }
    
    public boolean deleteReport(int reportNo) {
        SqlSession session = getSqlSession();
        reportDAO = session.getMapper(ReportDAO.class);
        int result = reportDAO.deleteReport(reportNo);
        logger.debug("deleteReport - reportNo: {}, result: {}", reportNo, result);
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
        logger.debug("getUserNicknameByUserNo - userNo: {}, userNickname: {}", userNo, userNickname);
        session.close();
        return userNickname;
    }

    public boolean banUserByUserNo(int userNo) {
        SqlSession session = getSqlSession();
        reportDAO = session.getMapper(ReportDAO.class);
        int result = reportDAO.banUserByUserNo(userNo);
        logger.debug("banUserByUserNo - userNo: {}, result: {}", userNo, result);
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
        logger.debug("updateReportStatus - reportNo: {}, reportStatus: {}, result: {}", reportNo, reportStatus, result);
        if (result > 0) {
            session.commit();
            return true;
        } else {
            session.rollback();
            return false;
        }
    }
    
    public ReportDTO selectReportByNo(int reportNo) {
        SqlSession session = getSqlSession();
        reportDAO = session.getMapper(ReportDAO.class);
        ReportDTO report = reportDAO.selectReportByNo(reportNo);
        logger.debug("selectReportByNo - reportNo: {}, report: {}", reportNo, report);
        session.close();
        return report;
    }
}

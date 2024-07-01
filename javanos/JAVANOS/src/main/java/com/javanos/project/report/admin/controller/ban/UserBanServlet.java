package com.javanos.project.report.admin.controller.ban;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.javanos.project.report.model.service.ReportService;
import java.io.IOException;

@WebServlet("/banUser")
public class UserBanServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String reportedUserNo = request.getParameter("reportedUserNo");
        String reportNo = request.getParameter("reportNo");

        // 디버깅 정보 출력
        System.out.println("Reported User No: " + reportedUserNo);
        System.out.println("Report No: " + reportNo);

        if (reportedUserNo != null && reportNo != null) {
            ReportService reportService = new ReportService();
            boolean isBanned = reportService.banUserByUserNo(Integer.parseInt(reportedUserNo));

            // 계정 정지 결과 출력
            System.out.println("Is Banned: " + isBanned);

            if (isBanned) {
                boolean isStatusUpdated = reportService.updateReportStatus(Integer.parseInt(reportNo), "계정정지완료");

                // 신고 상태 업데이트 결과 출력
                System.out.println("Is Status Updated: " + isStatusUpdated);

                if (isStatusUpdated) {
                    response.getWriter().println("<script>alert('계정이 성공적으로 정지되었습니다.'); location.href='" + request.getContextPath() + "/CheckBoard';</script>");
                } else {
                    response.getWriter().println("<script>alert('신고 상태 업데이트에 실패했습니다. 다시 시도해 주세요.'); location.href='" + request.getContextPath() + "/reportdetail?reportNo=" + reportNo + "';</script>");
                }
            } else {
                response.getWriter().println("<script>alert('계정 정지에 실패했습니다. 다시 시도해 주세요.'); location.href='" + request.getContextPath() + "/reportdetail?reportNo=" + reportNo + "';</script>");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/reportdetail?reportNo=" + reportNo);
        }
    }
}
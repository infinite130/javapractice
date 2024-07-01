package com.javanos.project.report.admin.controller.confim;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.javanos.project.report.model.dto.ReportDTO;
import com.javanos.project.report.model.service.ReportService;

@WebServlet("/reportdetail")
public class ReportDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReportService reportService = new ReportService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // GET 요청으로 전달된 매개변수를 가져옴
            int reportNo = Integer.parseInt(request.getParameter("reportNo"));

            // 신고 내용을 조회하여 request 속성에 설정
            ReportDTO report = reportService.selectReportByNo(reportNo);
            request.setAttribute("report", report);

            // JSP 페이지로 포워딩
            request.getRequestDispatcher("/WEB-INF/views/report/reportdetail.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            // 잘못된 reportNo가 전달된 경우 오류 처리
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid report number.");
        } catch (Exception e) {
            e.printStackTrace();
            // 기타 예외 처리
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("Action: " + action); // 디버깅용 출력

        if ("delete".equals(action)) {
            try {
                // 삭제 요청 처리
                int reportNo = Integer.parseInt(request.getParameter("reportId"));
                boolean isDeleted = reportService.deleteReport(reportNo);
                // 삭제 성공 메시지 설정
                System.out.println("Delete Report No: " + reportNo); // 디버깅용 출력
                System.out.println("Is Report Deleted: " + isDeleted); // 디버깅용 출력

                if (isDeleted) {
                    request.getSession().setAttribute("message", "신고글이 삭제되었습니다.");
                } else {
                    request.getSession().setAttribute("message", "신고글 삭제에 실패했습니다.");
                }
                response.sendRedirect(request.getContextPath() + "/CheckBoard");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // 잘못된 reportNo가 전달된 경우 오류 처리
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid report number.");
            } catch (Exception e) {
                e.printStackTrace();
                // 기타 예외 처리
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request.");
            }
        } else if ("confirm".equals(action)) {
            try {
                int reportNo = Integer.parseInt(request.getParameter("reportId"));
                boolean isConfirmed = reportService.updateReportStatus(reportNo, "계정정지완료");

                // 상태 업데이트 결과 출력
                System.out.println("Confirm Report No: " + reportNo); // 디버깅용 출력
                System.out.println("Is Report Confirmed: " + isConfirmed); // 디버깅용 출력

                if (isConfirmed) {
                    response.sendRedirect(request.getContextPath() + "/CheckBoard");
                } else {
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to update report status.");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // 잘못된 reportNo가 전달된 경우 오류 처리
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid report number.");
            } catch (Exception e) {
                e.printStackTrace();
                // 기타 예외 처리
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request.");
            }
        } else {
            doGet(request, response);
        }
    }
}
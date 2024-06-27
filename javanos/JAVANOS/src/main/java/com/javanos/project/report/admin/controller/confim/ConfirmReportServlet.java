package com.javanos.project.report.admin.controller.confim;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/confirmReport")
public class ConfirmReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // GET 요청을 통해서 처리할 내용 작성
        // 이 부분에서는 GET 요청을 처리할 필요가 없으므로, doPost 메서드로 리디렉션
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        // 요청으로부터 데이터를 가져오기
        String reportId = request.getParameter("reportId");
        String action = request.getParameter("action"); // 'confirm' or 'reject' 같은 액션 값

        // 신고 내역을 처리하는 로직 추가

        //신고 내역을 콘솔에 출력
        System.out.println("신고 ID: " + reportId);
        System.out.println("액션: " + action);

        // 처리 결과를 사용자에게 피드백
        request.setAttribute("message", "신고 처리가 완료되었습니다.");
        request.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(request, response);
    }
}

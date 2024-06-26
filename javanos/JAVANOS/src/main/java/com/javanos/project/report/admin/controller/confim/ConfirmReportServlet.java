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
        // GET 요청을 통해서 처리할 내용을 작성합니다.
        // 이 부분에서는 GET 요청을 처리할 필요가 없으므로, doPost 메서드로 리디렉션합니다.
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // POST 요청을 통해서 신고 내용을 확인하고 필요한 액션을 취합니다.
        
        // 요청으로부터 데이터를 가져옵니다.
        String reportId = request.getParameter("reportId");
        String action = request.getParameter("action"); // 'confirm' or 'reject' 같은 액션 값

        // 신고 내역을 처리하는 로직을 여기에 추가합니다.
        // 예를 들어, 데이터베이스에서 신고 내역을 확인하고 업데이트합니다.

        // 예시: 신고 내역을 콘솔에 출력
        System.out.println("신고 ID: " + reportId);
        System.out.println("액션: " + action);

        // 처리 결과를 사용자에게 피드백합니다.
        request.setAttribute("message", "신고 처리가 완료되었습니다.");
        request.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(request, response);
    }
}

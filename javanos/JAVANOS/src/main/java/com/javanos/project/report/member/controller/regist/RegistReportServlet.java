package com.javanos.project.report.member.controller.regist;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/RegistReport")
public class RegistReportServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 로그인된 사용자 아이디 가져오기
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        // reportregistmain 에서 입력한 데이터 수신
        String check1 = request.getParameter("check1");
        String additionalText = request.getParameter("additionalText");
        
        // 현재 날짜 가져오기
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = formatter.format(new Date());

        // 수신받은 데이터를 콘솔에 출력
        System.out.println("작성자: " + userId);
        System.out.println("신고 내용: " + check1);
        if (additionalText != null && !additionalText.isEmpty()) {
            System.out.println("기타 내용: " + additionalText);
        }
        System.out.println("등록일: " + currentDate);

        // 수신받은 데이터를 리스트에 저장
        synchronized (getServletContext()) {
            List<String[]> reports = (List<String[]>) getServletContext().getAttribute("reports");
            if (reports == null) {
                reports = new ArrayList<>();
                getServletContext().setAttribute("reports", reports);
            }
            reports.add(new String[]{userId, check1, additionalText, currentDate});
        }

        // 사용자에게 "신고가 완료되었습니다" 메시지 표시 후 리다이렉트
        request.setAttribute("successCode", "reportSubmitted");
        request.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(request, response);
    }
}

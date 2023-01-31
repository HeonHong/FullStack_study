package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PersonServlet")
public class personServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 데이터
		String name = request.getParameter("name");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String color = request.getParameter("color");
		String[] hobby = request.getParameterValues("hobby");
		String[] subject = request.getParameterValues("subject");
		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		
		out.println("<style type=\"text/css\"> "
				+ "div{ color : "+color+";}"
						+ "</style>");
		
		out.println("<body>");
		out.println("<div>");
		out.println("이름 : " + name + "<br>");
		out.println("성별 : " + gender + "<br>");
		out.print("색깔 : " + color + "<br>"); 
		out.print("취미 : ");
		for(int i=0;i<hobby.length;i++) { 
			out.print(hobby[i] + " "); 
			}
		
		out.print("<br>과목 : ");
		for(int i=0;i<subject.length;i++) { 
			out.print(subject[i] + " "); 
			}
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
	
}
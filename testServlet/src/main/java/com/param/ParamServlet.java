package com.param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ParamServlet") //xml에 써놓은 써블릿이 이 클래스라는 의미이다. 다만 xml에만 적던지 이것만 적던지 해야한다.
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@Override
	public void init() throws ServletException {
	}
		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		//데이터- http://localhost:8080/testServlet/ParamServlet?name=%ED%99%8D&age=25 > 원래 name쪽의 한글은 유니코드 방식으로 온다.
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		//응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Hello Servlet!!<br>");
		out.println(name + "님의 나이는 " + age + "살 이므로");
		if(age>=19) out.println("성인입니다.");
		else out.println("청소년입니다.");
		out.println("</body>");
		out.println("</html>");
	}
}

package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;//longtype임을 알리고 시작
       
	public void init() {
		System.out.println("init() 메소드");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("doGet() 메소드");
		
		response.setContentType("text/html;charset=UTF-8");
		//이렇게 하면 자바에서 이하로 작성하는 문장은 html로 인식하라는 의미이다.
		try {
			PrintWriter out = response.getWriter();//객체생성
			
			out.println("<html>");
			out.println("<body>");
			out.println("Hello Servlet!!<br>");//여기서 ln은 소스코드를 볼 때 줄바꿈을 하는 용도이다. 결과값에서 줄을 바꾸려면 br태그 사용
			out.println("안녕하세요 서블릿!!");
			out.println("</body>");
			out.println("</html>");

		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
	}
	
	public void destroy() {
		System.out.println("destroy() 메소드");
	}
}


//인터페이스??
//톰캣은 자바 파일을 모른다. 그래서 xml에 넣어준다? xml은 톰캣이 실행할 때 가장 먼저 읽는 파일이다. springboot에서는 사용하지 않는다.
//그래서 @해준다.
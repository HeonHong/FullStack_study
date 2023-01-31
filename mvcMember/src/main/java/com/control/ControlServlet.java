package com.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns = {"*.do"},
		//이렇게 불러준다.
		initParams= {
				@WebInitParam(name="propertyConfig", value ="command.properties")
				} 
		)
//urlpattern을 어떻게 작성할 것인지, command properties들이 어딨는지 알려줘야한다. 
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> map = new HashMap<String,Object>();
       
	
	public void init(ServletConfig config) throws ServletException {
		//환경설정은 한 번만 하면 되니까.
		String propertyConfig = config.getInitParameter("propertyConfig");
		//web.xml에 준 이름을 읽어 와라
		System.out.println("propertyConfig = " + propertyConfig);
		
		String realFolder = config.getServletContext().getRealPath("/WEB-INF");
		//command.properties의 위치 알아서 알아온다.
		String realPath = realFolder + "/" + propertyConfig;
		System.out.println("realPath=" + realPath);
		
		
		FileInputStream fin = null;//이 두 줄은 오늘 설명하지 않을 예정
	    Properties properties = new Properties();
	      
	    try {
	         //fin = new FileInputStream(propertyConfig);
	    	//위에 건 web.xml에 적어줬었기 때문에 했던 것이다.
	         fin = new FileInputStream(realPath);       
	         properties.load(fin);
	         System.out.println("properties = "+properties);
	         
	      } catch (IOException e) {
	         e.printStackTrace();
	      }finally{
	         try {
	            fin.close();
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	      }
	      System.out.println();
	      
	      Iterator it = properties.keySet().iterator();
	      while(it.hasNext()) {
	         String key = (String)it.next();
	         System.out.println("key = "+key);
	         
	         String className = properties.getProperty(key);
	         System.out.println("className = "+className);
	         
	         try {
	            Class<?> classType = Class.forName(className);
	            Object ob = classType.newInstance();
	            
	            System.out.println("ob = "+ob);
	            
	            map.put(key, ob);
	            
	         } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	         } catch (InstantiationException e) {
	            e.printStackTrace();
	         } catch (IllegalAccessException e) {
	            e.printStackTrace();
	         } catch (IllegalArgumentException e) {
	            e.printStackTrace();
	         } 
	         
	         System.out.println();
	      }//while  
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println();
		if(request.getMethod().equals("POST"))
			request.setCharacterEncoding("UTF-8");
			//GET방식은 해줄 필요 없으나 POST 방식은 꼭 설정해줘야한다.
		
		//요청이 들어왔을 때 - http://localhost:8080/mvcmember/member/writeForm.do
	      String category = request.getServletPath();
	      //앞에 컨텍스트명까지 자른다. why? command.properties에 있는 주소를 확인해서 WriteFormService로 이동하니까
	      System.out.println("category = "+category); //   결과 : /member/writeForm.do
	      
	      CommandProcess com = (CommandProcess)map.get(category); //member.service.WriteFormService
	      String view = null;
			
	      try {
	          view = com.requestPro(request, response); //"/member/writeForm.jsp"
	       } catch (Throwable e) {
	          e.printStackTrace();
	       }
	       
	       //forward
	       RequestDispatcher dispatcher = request.getRequestDispatcher(view);//상대번지
	       dispatcher.forward(request, response);//제어권 넘기기
			 	}
}

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
    
    request.setAttribute("apple","사과");
  	//parameter는 받는 역할이었다면 attribute는 이 페이지에서만 데이터들을 세팅하는 것이다.
  	//넣으면 넣는대로 계속 데이터가 들어간다.
  
  
    //페이지 이동
    RequestDispatcher dispatcher = request.getRequestDispatcher("./forwardResult.jsp");
    //상대번지로 사용해줘야 다음 페이지랑 병합된다.
    dispatcher.forward(request, response);//제어권을 forwardResult로 넘겨주는 것이다.
    //이 두 코드는 세트이다. 안적어주면 error
    %>
   <%--  <jsp:forward page="forwardResult.jsp"/>  위에 줄이랑 동일 역할--%>
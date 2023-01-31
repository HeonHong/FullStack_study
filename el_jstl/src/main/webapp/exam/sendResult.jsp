<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String apple = (String)request.getAttribute("apple");
/* String apple = (String)request.getParameter("apple");
이것도 안 됨.*/

%>    

결과=<%=apple%>
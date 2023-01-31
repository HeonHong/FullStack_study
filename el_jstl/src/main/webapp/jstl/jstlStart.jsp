<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "com.jstl.PersonDTO"
        import = "java.util.List"
    import = "java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
List<String> list = new ArrayList<String>();
list.add("호랑이");
list.add("사자");
list.add("고양이");
list.add("강아지");
list.add("귀엽지");
list.add("지렁이");

List<PersonDTO> list2 = new ArrayList<PersonDTO>();
PersonDTO aa = new PersonDTO("홍길동", 25);
PersonDTO bb = new PersonDTO("네  오", 23);
PersonDTO cc = new PersonDTO("프로도", 30);

list2.add(aa);
list2.add(bb);
list2.add(cc);
request.setAttribute("list",list);
request.setAttribute("list2",list2);
//페이지 이동
/* response.sendRedirect("jstlEnd.jsp"); */
RequestDispatcher dispatcher = request.getRequestDispatcher("jstlEnd.jsp");
dispatcher.forward(request, response);
%>
<%-- 
<jsp:forward page="jstlEnd.jsp"/> --%>


</body>
</html>
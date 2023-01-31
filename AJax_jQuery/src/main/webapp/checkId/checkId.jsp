<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 
DB로 연동 - id가 "hong" 이면 이미 DB에 저장된 아이디로 취급. true(중복)을 전달.
--%>


<c:set var="result" value="false" />
<c:if test="${param.user_id  == 'hong'}">
   <c:set var="result" value="true" />
</c:if>

<?xml version="1.0" encoding="UTF-8"?>
<check_id>
   <result>${result} </result>
</check_id>
 <%-- 서버역할 --%>    
<%-- contentType="text/xml; 이제부터 받는 값들을 모두 xml형식을 받는다?
주석값 이렇게 처리 안해놓으면 읽는다--%> 

<%-- 
DB연동 - 아이디가 "hong"이면 이미 DB에 저장된 아이디(true를 전달)
 --%> 
 
 <%-- jstl사용
 1. jar
 2. taglib
 --%>
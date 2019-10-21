<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- header ------------------------------------------ -->
	<header>
		<div class="container">
			<div class="logo"><a href="main.do">
			<img width="110px" height="130px" alt="main.do" title="메인으로" src="/images/egovframework/main.png"></a></div>
			<ul class="sidemenu">
				<c:if test="${sessionScope.userId != null}">
					<li>${sessionScope.userId}</li>
				</c:if>
				<li><a href="main.do">Home</a></li>
			</ul>
		</div>
	</header>
	<!-- //header -->
</body>
</html>
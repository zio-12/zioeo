<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- nav --------------------------------------------- -->
	<nav>
		<div class="container">
			<ul class="leftMenu">
				<li class="active"><a href="main.do">Home</a></li>
				<li><a href="notice.do?boardValue=1">공지사항</a></li>
				<li class="dropBox">게시판
				<span class="dropmenu"> 
					<span><a href="notice.do?boardValue=3">자유 게시판</a></span>
					 <span><a href="notice.do?boardValue=2">질문 게시판</a></span>
				</span>
				</li>
			</ul>
			<ul class="rightMenu">
				<c:choose>
					<c:when test="${sessionScope.userId != null}">
						<li style="width: auto; cursor: default;"><a href="myPage.do">마이페이지</a></li>
						<li><a href="logout.do">로그아웃</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="join.do">회원가입</a></li>
						<li><a href="login.do">로그인</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</nav>
	<!-- //nav -->
</body>
</html>
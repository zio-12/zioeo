<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>질문게시판</title>
<link type="text/css" rel="stylesheet" href="/css/egovframework/mainStyle.css">
</head>
<body>
<!-- header ------------------------------------------ -->
	<%@ include file="include/fixingheader.jsp"%>
	<!-- //header -->
	<!-- nav --------------------------------------------- -->
	<%@ include file="include/fixingNav.jsp" %>
	<!-- //nav -->
	<section id="section">
		<div class="container">
		<b class="alignleft" style="color: #0aa9de; font-size: 30px;"><a href="notice.do">질문게시판</a></b>
		<b class="aligncenter"style="color: #0aa9de; font-size: 50px;">&nbsp;</b>
		<c:choose>
			<c:when test="${sessionScope.userId != null}">
			<b class="alignright" style="color: #0aa9de;font-size: 20px;"><a href="notice/write.do">글쓰기</a></b>
			</c:when>
			<c:otherwise>
			<b class="alignright">&nbsp;</b>
			</c:otherwise>
		</c:choose>
		<br><br><br>
					<table class="type1">
						<thead>
							<tr>
								<th><b>글 번호</b></th>
								<th><b>제목</b></th>
								<th><b>작성자</b></th>
								<th><b>작성 일자</b></th>
								<th><b>조회수</b></th>
							</tr>
						</thead>
						<tbody>
						<c:choose>
						<c:when test="${list.size() != 0}">
							<c:forEach items='${list}' var='list'>
								<tr>
									<td><a href="notice/read?boardNo=${boardNo}"><c:out value='${list.boardNo}'/></a></td>
									<td><a href="notice/read?boardNo=${boardNo}"><c:out value='${list.boardTitle}' /></a></td>
									<td><c:out value='${list.boardUser}'/></td>
									<td><c:out value='${list.boardTime}' /></td>
									<td><c:out value='${list.boardCount}' /></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="3"><img height="100px" width="100px" src="image/Oh_sleep.gif"><br>
								 <b> 등록된 글이 없습니다.</b></td>
							</tr>
						</c:otherwise>
					</c:choose>
						</tbody>
					</table>
			</div>
		</section>
</body>
</html>
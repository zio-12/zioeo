<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
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
		<c:choose>
			<c:when test="${boardValue eq 1}">
			<b class="alignleft" style="color: #0aa9de; font-size: 30px;">
			<a href="notice.do?boardValue=1">공지사항</a></b>
			</c:when>
			<c:when test="${boardValue eq 2}">
			<b class="alignleft" style="color: #0aa9de; font-size: 30px;">
			<a href="notice.do?boardValue=2">질문게시판</a></b>
			</c:when>
			<c:when test="${boardValue eq 2}">
			<b class="alignleft" style="color: #0aa9de; font-size: 30px;">
			<a href="notice.do?boardValue=3">자유게시판</a></b>
			</c:when>
			<c:otherwise>
			<b class="alignleft" style="color: #0aa9de; font-size: 30px;">
			<a href="notice.do?boardValue=3">검색결과</a></b>
			</c:otherwise>
		</c:choose>
		<form action="search.do?boardValue=4" method="post">
		<b class="aligncenter"style="color: #0aa9de;">
					<select name="searchNo" style="height: 23px;">
									<option value="1">전체</option>
									<option value="2">작성자</option>
									<option value="3">제목</option>
									</select>&nbsp;&nbsp;
									<input type="text" name="searchName"size="30" placeholder="검색할 내용을 입력해주세요">
									<input type="submit" name="search" value="검색">
		</b>
		</form>
		<c:choose>
			<c:when test="${sessionScope.userId != null || boardValue ne 4}">
			<b class="alignright" style="color: #0aa9de;font-size: 20px;"><a href="write.do">글쓰기</a></b>
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
							<c:forEach items='${list}' var='list'
							begin="${page.startWriting -1}" end="${page.endWriting -1}">
							<c:set var='j' value='${j+1}' />
								<tr>
									<td><a href="read.do?boardNo=${list.boardNo}"><c:out
												value='${page.startWriting + j - 1}' /></a></td>
									<td><a href="read.do?boardNo=${list.boardNo}"><c:out value='${list.boardTitle}' /></a></td>
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
					
					<!-- 페이징 -->
					<div align="center">
					<c:if test="${page.startPage != curPage}">
					<a href="notice.do?boardValue=${boardValue}&curPage=${page.startPage}">처음으로</a>
				</c:if>
				<c:forEach var='i' begin="${page.startPage}" end="${page.endPage}">
						<c:choose>
						<c:when test="${ i == curPage }">
							<b><c:out value="${i}"/></b>
						</c:when>
						<c:otherwise>
						<a href="notice.do?boardValue=${boardValue}&curPage=${i}"><c:out value="${i}"/></a>
						</c:otherwise>
						</c:choose>
					</c:forEach>
				<c:if test="${page.endPage != curPage}">
					<a href="notice.do?boardValue=${boardValue}&curPage=${page.endPage}">끝으로</a>
				</c:if>
				</div>
			</div>
		</section>
		
		
<script type="text/javascript">
function main() { //메인으로 버튼
		history.back();
}
</script>
</body>
</html>
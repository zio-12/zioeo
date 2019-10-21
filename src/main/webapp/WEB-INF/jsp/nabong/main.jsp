<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>페이지 제작</title>
<link type="text/css" rel="stylesheet" href="/css/egovframework/mainStyle.css">
<!-- <link type="text/css" rel="stylesheet" href="/css/egovframework/css/bootstrap.css"> -->
</head>
<body>
	<!-- header ------------------------------------------ -->
	<%@ include file="include/fixingheader.jsp"%>
	<!-- //header -->
	<!-- nav --------------------------------------------- -->
	<%@ include file="include/fixingNav.jsp" %>
	<!-- //nav -->

	<!-- section --------------------------------------------- -->
	<section id="section">
		<div class="container">
			<div class="leftBox">
				<!-- width: 50%; height: 50%; float: left; -->
				<div class="graph1" style="width: 50%; height: 50%; float: left;">
					<!-- 그래프1 추가  -->
					<b class="alignleft">질문게시판</b><b class="aligncenter">&nbsp;</b>
					<b class="alignright"><a href="notice.do?boardValue=2">더보기</a></b><br><!--여기는 최신순으로-->
					<table class="type1">
						<thead>
							<tr> 
								<th><b>제목</b></th>
								<th><b>작성 일자</b></th>
								<th><b>조회수</b></th>
							</tr>
						</thead>
						<tbody>
						<c:choose>
						<c:when test="${QnAList.size() != 0}">
							<c:forEach items='${QnAList}' var='QnA' begin="0" end="2">
								<tr>
									<td><a href="read.do?boardNo=${QnA.boardNo}"><c:out value='${QnA.boardTitle}'/></a></td>
									<td><c:out value='${QnA.boardTime}' /></td>
									<td><c:out value='${QnA.boardCount}' /></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="3"><img height="100px" width="100px" src="/images/egovframework/Oh_sleep.gif"><br>
								 <b> 등록된 글이 없습니다.</b></td>
							</tr>
						</c:otherwise>
					</c:choose>
						</tbody>
					</table>
				</div>
				<div class="graph2" style="width: 50%; height: 50%; float: left;" align="center">
					<b class="alignleft">자유게시판</b><b class="aligncenter">&nbsp;</b>
					<b class="alignright"><a href="notice.do?boardValue=3">더보기</a></b><br><!--여기는 최신순으로-->
					<table class="type1">
						<thead>
							<tr>
								<th><b>제목</b></th>
								<th><b>작성 일자</b></th>
								<th><b>조회수</b></th>
							</tr>
						</thead>
						<tbody>
						<c:choose>
						<c:when test="${FreeList.size() != 0}">
							<c:forEach items='${FreeList}' var='free' begin="0" end="2">
								<tr>
									<td><a href="read.do?boardNo=${free.boardNo}"><c:out value='${free.boardTitle}'/></a></td>
									<td><c:out value='${free.boardTime}' /></td>
									<td><c:out value='${free.boardCount}' /></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="3"><img height="100px" width="100px" src="/images/egovframework/Oh_sleep.gif"><br>
								 <b> 등록된 글이 없습니다.</b></td>
							</tr>
						</c:otherwise>
					</c:choose>
						</tbody>
					</table>
				</div>
			</div>
			<div class="rightBox">
				<div class="imgBox" style="width: 50%; height: 50%; float: left;" align="center">
				<b>게시글 검색하기</b><br>
					<div align="center">
					<form action="search.do">
					<select name="searchNo" style="height: 23px;">
									<option value="1">전체</option>
									<option value="2">작성자</option>
									<option value="3">제목</option>
									</select>&nbsp;&nbsp;
									<input type="text" name="searchName"size="30" placeholder="검색할 내용을 입력해주세요">
									<input type="submit" name="search" value="검색">
					</form>
						</div>
					
				</div>
				<div class="table" style="width: 50%; height: 50%; float: left;">
					<!-- 공지사항 추가 -->
					<b class="alignleft">공지사항</b><b class="aligncenter">&nbsp;</b>
					<b class="alignright"><a href="notice.do?boardValue=1">더보기</a></b><br><!--여기는 최신순으로-->
					<table class="type1">
						<thead>
							<tr>
								<th><b>제목</b></th>
								<th><b>작성 일자</b></th>
								<th><b>조회수</b></th>
							</tr>
						</thead>
						<tbody>
						<c:choose>
						<c:when test="${boardList.size() != 0}">
							<c:forEach items='${boardList}' var='notice' begin="0" end="2">
								<tr>
									<td><a href="read.do?boardNo=${notice.boardNo}"><c:out value='${notice.boardTitle}'/></a></td>
									<td><c:out value='${notice.boardTime}' /></td>
									<td><c:out value='${notice.boardCount}' /></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="3"><img height="100px" width="100px" src="/images/egovframework/Oh_sleep.gif"><br>
								 <b> 등록된 글이 없습니다.</b></td>
							</tr>
						</c:otherwise>
					</c:choose>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
	<div class="clear"></div>
	<!-- //section -->
	<footer>
		<div class="top">
			<div class="container">
				<span>다운로드</span> <span>개인정보처리방침</span> <span>광고문의</span> <span>
				<a href="https://github.com/nabong0112/gogoWebProject">GitHub</a></span>
			</div>
		</div>
		<div class="container">
			<strong> 주소 : 대전광역시 중구 유천로 136 나이스타운 801호 번호 : 010-5795-6030
				이름 : 전나현 </strong>
			<div class="copyright">
				<!-- COPYRIGHT &copy; 남가람북스's BLOG IS POWERED BY DAUM / DESIGNED BY TISTORY -->
			</div>
		</div>
	</footer>
</body>
</html>
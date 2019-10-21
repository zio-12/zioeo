<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세보기</title>
<link type="text/css" rel="stylesheet" href="/css/egovframework/mainStyle.css">
<link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="/css/egovframework/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
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
		<div>
		<c:choose>
			<c:when test="${list.boardValue eq 1}">
			<b class="alignleft" style="color: #0aa9de; font-size: 30px;">
			<a href="notice.do?boardValue=${list.boardValue}">공지사항</a></b>
			</c:when>
			<c:when test="${list.boardValue eq 2}">
			<b class="alignleft" style="color: #0aa9de; font-size: 30px;">
			<a href="notice.do?boardValue=${list.boardValue}">질문게시판</a></b>
			</c:when>
			<c:otherwise>
			<b class="alignleft" style="color: #0aa9de; font-size: 30px;">
			<a href="notice.do?boardValue=${list.boardValue}">자유게시판</a></b>
			</c:otherwise>
		</c:choose>
		<b class="aligncenter"style="color: #0aa9de; font-size: 30px;">&nbsp;</b>
			<b class="alignright" style="color: #0aa9de;font-size: 30px;">&nbsp;</b><br><br><br>
		</div>
					<table class="type2" align="center">
						<thead>
							<tr>
								<th><b>제목</b></th>
								<td>
									<c:out value="${list.boardTitle}"/>
								</td>
								<th><b>작성일자</b></th>
								<td>
									<c:out value="${list.boardDateTime}"/>
								</td>
							</tr>
							<tr>
								<th><b>작성자</b></th>
								<td><input type="hidden" name="boardUser" value="${sessionScope.userId}">
									<c:out value="${list.boardUser}"/>
								</td>
								<th><b>조회수</b></th>
								<td>
									<c:out value="${list.boardCount}"/>
								</td>
							</tr>
							<tr height="250px">
								<th><b>내용</b></th>
								<td colspan="3">
									<p id ="boardText">${list.boardText}</p>
								</td>
							</tr>
							<tr>
								<th colspan="2"><b>첨부파일</b></th>
								<c:choose>
									<c:when test="${not empty list.fileName}">
										<th colspan="2"> <a href="fileDownload.do?boardNo=${list.boardNo}"><c:out value="${list.fileName}"/></a> </th>
									</c:when>
									<c:otherwise>
										<th colspan="2">첨부파일 없음</th>
									</c:otherwise>
								</c:choose>
								
							</tr>
						</thead>
						<tbody>
						<tr>
						<td colspan="4" align="center">
						<input type="button" class="dropbtn" name="back" value="돌아가기" onclick="javascript:Back();">
						<c:if test="${sessionScope.userId == list.boardUser}">
						<a onclick="return confirm('수정하시겠습니까?')"
							href="update.do?boardNo=${list.boardNo}&check=update" style="text-decoration: none;">
						<input type="button" class="dropbtn" name="update" value="수정하기"></a>
						<a onclick="return confirm('글을 삭제하시겠습니까? 삭제하시면 복구할 수 없습니다!')"
							href="delete.do?boardNo=${list.boardNo}" style="text-decoration: none;">
						<input type="button" class="dropbtn" name="delete" value="삭제하기"></a>
					</c:if>
						</td>
						</tbody>
						<tr>
					</table>
					<!--                                              댓글                                                      -->
					<form method="post" action="insertComment.do?boardNo=${list.boardNo}">
						<table class="type2">
						<thead>
							<tr align="right">
								<td colspan="3"><b>댓글 :
									${commentList.size()}개</b></td>
							</tr>
							<tr align="center">
								<th width="120px"><b>작성자</b></th>
								<th width="720px">내용</th>
								<th width="180px"><b>작성 일자</b></th>
							</tr>
						</thead>
							<c:choose>
								<c:when test="${commentList.size() != 0}">
									<c:forEach items='${commentList}' var='comment'>
										<c:set var='i' value='${i+1}' />
										<tr align="center">
											<td><c:out value='${comment.commentUser}' /></td>
											<td><c:out value='${comment.commentText}' /> 
											<input type="text" size="10px" id="update" style="visibility: hidden;" value="${comment.commentText}">
												<button id="updateCheck" type="submit" class="dropbtn" style="visibility: hidden;" onclick="javascript:updateCheck();">수정</button></td>
											<td><c:out value='${comment.commentTime}' /><br> 
												<c:if test="${comment.commentUser == sessionScope.userId}">
													<!-- <a id="updateButton" href="javascript:updateComment();">수정하기(업데이트 예정)</a> -->
													<a onclick="return confirm('댓글을 삭제하시겠습니까? 삭제하시면 복구할 수 없습니다!')"
														href="deleteComment.do?boardNo=${list.boardNo}&commentNo=${comment.commentNo}">
														삭제하기</a><br>
												</c:if> 
											</td>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr align="center">
										<td colspan="4"><b> 댓글이 없습니다! </b></td>
									</tr>
								</c:otherwise>
							</c:choose>

							<c:if test="${sessionScope.userId != null}">
								<tr align="center" id="comment">
									<td>${sessionScope.userId}</td>
									<td><textarea name="commentText" placeholder="소중한 댓글을 입력해주세요."
											style="resize: none; width: 500px; height: 30px;"></textarea>
										<input type="hidden" name="commentUser" value="${sessionScope.userId}"></td>
									<td><button type="submit" class="dropbtn">댓글달기</button></td>
								</tr>
							</c:if>
						</table>
					</form>
				</div>
				<div class="comment">
					
				</div>
		</section>
<script type="text/javascript">
function Back() { //돌아가기 버튼
		history.back();
}

function fn_fileDownload(boardNo) {
    $("#detailForm").append("<input type='hidden' name='boardNo' value='" + boardNo + "'/>");
    $("#detailForm").attr("method", "POST");
    $("#detailForm").attr("action", "<c:url value='/isdm/bbs/bbsFileDownload.do'/>");
    $("#detailForm").submit();

}
</script>
</body>
</html>
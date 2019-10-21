<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보</title>
<link type="text/css" rel="stylesheet" href="/css/egovframework/loginStyle.css">
     <link type="text/css" rel="stylesheet" href="/css/egovframework/mainStyle.css">
</head>
<body>
<!-- header ------------------------------------------ -->
	<%@ include file="include/fixingheader.jsp"%>
	<!-- //header -->
	<!-- nav --------------------------------------------- -->
	<%@ include file="include/fixingNav.jsp" %>
	<!-- //nav -->

<section id="section2">
        <div class="container">
            <div class="loginBox">
                <div>
                    <div class="box">
                        <div class="logo">
                            <h1>내 가입 정보</h1>
                        </div>
                        	<p> 가입한 날짜 : <c:out value="${info.joinTime }"/> </p>
							<p> 내 아이디 : <c:out value="${info.userId}"/> </p>
							<p> 내 비밀번호 : <c:out value="${info.userPw}"/> </p>
							<p> 내 이름 : <c:out value="${info.userName}"/> </p>
							<p> 성별 : <c:out value="${info.userJender}"/> </p>
							<p> 질문 : <c:out value="${info.userIdQustion}"/> </p>
							<p> 답 : <c:out value="${info.userIdAnswer}"/> </p>
                    </div>
                    <div class="box">
                    <div align="center">
                   <c:choose>
					<c:when test="${info.userJender == 'Male'}">
						<img width="180px" height="290px" alt="#" src="/images/egovframework/my_Page_Img.png">
					</c:when>
					<c:otherwise>
						<img width="180px" height="290px" alt="#" src="/images/egovframework/my_Page_Img_girl.png">
					</c:otherwise>
				</c:choose>
				</div>
                    </div>
                    <div class="clear"></div>
                    <div class="alert">
                        <h1>계정 설정하기</h1>
                        <p>
                            <button>회원정보 수정하기</button>
                            <button>회원 탈퇴하기</button>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
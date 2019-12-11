<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>페이지 제작</title>
    <link type="text/css" rel="stylesheet" href="/css/egovframework/loginStyle.css">
     <link type="text/css" rel="stylesheet" href="/css/egovframework/mainStyle.css">
     <script type="text/javascript">
        function popUp(){
            var url = "popup.html";
            var name = "popup test";
            var option = "width = 500, height = 500, top = 100, left = 200, location = no"
            window.open(url, name, option);
        }
    </script>
</head>
<body> 
<!-- header ------------------------------------------ -->
	<%@ include file="include/fixingheader.jsp"%>
	<!-- //header -->
	<!-- nav --------------------------------------------- -->
	<%@ include file="include/fixingNav.jsp" %>
	<!-- //nav -->

     <!-- section --------------------------------------------- -->
    <section id="section2">
        <div class="container">
            <div class="loginBox">
                <div>
                    <div class="box">
                        <div class="logo">
                            <h1>로그인</h1>
                        </div>
                        <form action="loginCheck.do" method="post">
                            <input type="text" name="userId" placeholder="아이디">
                            <input type="password" name="userPw" placeholder="비밀번호">
                            <a href="javascript:popUp();">팝업</a>
                            <c:choose>
                            	<c:when test="${check eq 'false' }">
                            	<br><p style="color: red">아이디 또는 비밀번호를 확인하세요!</p>
                            	</c:when>
                            	<c:when test="${check eq 'login' }">
                            	<br><p style="color: red">로그인이 필요한 서비스입니다</p>
                            	</c:when>
                            	<c:when test="${check eq 'joinOk' }">
                            	<br><p style="color: blue">회원가입을 축하드립니다! 로그인해주세요!</p>
                            	</c:when>
                            	<c:otherwise>
                            	<br><p style="color: red">&nbsp;</p>
                            	</c:otherwise>
                            </c:choose>
                            <button type="submit">로그인</button>
                        </form>
                    </div>
                    <div class="box">
                    <div align="center">
                    <c:choose>
                    	<c:when test="${check eq 'false' }">
                    	<img alt="계정정보 틀림" src="/images/egovframework/nooo.gif">
                    	</c:when>
                    	<c:otherwise>
                    	<img alt="방가" src="/images/egovframework/Oh_main.gif">
                    	</c:otherwise>
                    </c:choose>
                    </div>
                    </div>
                    <div class="clear"></div>
                    <div class="alert">
                        <h1><a href="join.do">도움이 필요하신가요?</a></h1>
                        <p>
                            <button onclick="javascript:join();">회원가입</button>
                            <button>아이디 / 비밀번호 찾기</button>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <div class="clear"></div>
    <!-- //section -->
</body>
</html>
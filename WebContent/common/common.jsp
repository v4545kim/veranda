<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	int twelve = 12 ;
%>
<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Cake Template">
    <meta name="keywords" content="Cake, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>베란다에서 온 파프리카</title>


    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@400;500;600;700;800;900&display=swap"
    rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700;800;900&display=swap"
    rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/flaticon.css" type="text/css">
    <link rel="stylesheet" href="css/barfiller.css" type="text/css">
    <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    
    <!-- 로그인 상태 정보 -->
	<c:set var="whologin" value="0"/>
	
	<!-- 미로그인 상태 -->
	<c:if test="${empty sessionScope.loginfo}">
		<c:set var="whologin" value="0"/>
	</c:if>
	
	<c:if test="${not empty sessionScope.loginfo}">
		<!-- 관리자 로그인 상태 -->
		<c:if test="${sessionScope.loginfo.id == 'admin'}">
			<c:set var="whologin" value="2"/>
		</c:if>
		
		<!-- 회원 로그인 상태 -->
		<c:if test="${sessionScope.loginfo.id != 'admin'}">
			<c:set var="whologin" value="1"/>
		</c:if>
	</c:if>	
</head>
<body>
<%	
	String contextPath = request.getContextPath();
	String mappingName = "/veranda";
	
	String FormYes = contextPath + mappingName;
	String FormNo = contextPath + mappingName + "?command=";
%>
	<header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="header__top__inner">
                            <div class="header__logo">
                                <a href="<%=FormNo%>main"><img src="img/logo.png" alt=""></a>
                            </div>
                            <div class="header__top__left">
                                <div class="header__top__right__links">
                                    <ul>
										<li>
											<c:if test="${whologin == 0}">
												<a href="<%=FormNo%>meLogin">
													로그인
												</a>
												<a href="<%=FormNo%>meInsert">
													회원 가입
												</a>
												<a href="<%=FormNo%>myPage">
													마이 페이지
												</a>
											</c:if>
											<c:if test="${whologin != 0}">
												<a href="<%=FormNo%>meLogout">
													로그아웃
												</a>
												<a href="<%=FormNo%>meUpdate">
													회원 정보 수정
												</a>	
											</c:if>
											<c:if test="${whologin == 1}">
												<a href="<%=FormNo%>meDelete&id=${sessionScope.loginfo.id}">
													회원 탈퇴
												</a>
											</c:if>
											<c:if test="${whologin == 2}">
												<a href="<%=FormNo%>meList">
													회원 목록 보기
												</a>
											</c:if>
										</li>
									</ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="canvas__open">
                	<i class="fa fa-bars">
                	</i>
                </div>
            </div>
        </div>
		<div class="container">
	            <div class="row">
	                <div class="col-lg-12">
	                    <nav class="header__menu mobile-menu">
	                        <ul>
	                            <li class="active">
	                            	<a href="<%=FormNo%>main">
	                            		home
	                            	</a>
	                            </li>
	                            <li>
	                            	<a href="<%=FormNo%>noList">
	                            		공지사항
	                            	</a>
	                            </li>
	                            <li>
	                            	<a href="<%=FormNo%>prList">
	                            		상품 게시판
	                            	</a>
	                            </li>
	                            <li>
	                            	<a href="<%=FormNo%>coList">
	                            		커뮤니티
	                            	</a>
	                            </li>
	                            <li>
	                            	<a href="<%=FormNo%>qnaList">
	                            		Q&A
	                            	</a>
	                            </li>
	                        </ul>
	                    </nav>
	                </div>
	            </div>
	        </div>
        </header>
	<br>
	<!-- Js Plugins -->
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery.barfiller.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/jquery.slicknav.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.nicescroll.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>
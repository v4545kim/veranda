<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Insert title here</title>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">

p.groove {border-style: groove; border-color: white; }

p {
   padding-top: 55px;
   padding-right: 55px;
   padding-bottom: 55px;
   padding-left: 55px;
    } 
</style>
</head>
<body>


    <div class="blog-hero set-bg" data-setbg="img/picto/야채1.jpg">
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="col-lg-7">
                    <div class="blog__hero__text">
                        <div class="label">neighborhood</div>
                        <h2>이웃페이지</h2>
                        <ul>
                            <li>By <span>베란다에서 온 파프리카</span></li>
                            <li>15 May 2021</li>
                            <li>112 Views</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
  
    
     <section class="blog-details spad">
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="col-lg-8">
                    <div class="blog__details__content">
                        <div class="blog__details__author">
                            <div class="blog__details__author__pic">
                                <img src="img/blog/details/blog-author.jpg">
                            </div>
                            <div class="blog__details__author__text">
                                <h6>아이디 : ${bean.user_id}</h6>
                                <h6>닉네임 : ${bean.user_nickname}</h6>
                                <h6>이름 : ${bean.user_name}</h6>
                                <h6>생년월일 : ${bean.user_birth}</h6>
                                <h6>성별 : ${bean.user_gender}</h6>
                                <h6>우편번호 : ${bean.user_postcode}</h6>
                                <h6>주소 : ${bean.user_address} ${bean.user_address1} ${bean.user_address2}</h6>
                            </div>
                            	<a href="<%=FormNo%>foApply&follower=${bean.no}&followee=${sessionScope.loginfo.no}" class="primary-btn">팔로우</a>
                            	<a href="<%=FormNo%>foCancel&follower=${bean.no}&followee=${sessionScope.loginfo.no}" class="primary-btn">팔로우 취소</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="<%=FormNo%>foList" class="primary-btn">팔로워 : ${requestScope.followCnt}</a>
                            <a href="#" class="primary-btn">팔로잉 : ${requestScope.followeeCnt}</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    </body>
    
<%@ include file="./../common/footer.jsp"%>
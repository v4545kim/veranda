<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%
	/* position for grid system */	
	int offset = 2 ;
	int mywidth = twelve - 2 * offset ;
	int formleft = 3 ;
	int formright = twelve - formleft ;
	int rightButton = 2 ;
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/bootstrap.min2.css" type="text/css">
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
                                <h6>닉네임 : ${bean.user_nickname}</h6>
                                <h6>생년월일 : ${bean.user_birth}</h6>
                                <h6>성별 : ${bean.user_gender}</h6>
                                <h6>우편번호 : ${bean.user_postcode}</h6>
                                <h6>주소 : ${bean.user_address} ${bean.user_address1} ${bean.user_address2}</h6>
                            </div>
                            <c:if test="${cnt == 0}">
                            	<a href="<%=FormNo%>foApply&follower=${bean.no}&followee=${sessionScope.loginfo.no}&user_no=${bean.no}" class="primary-btn">팔로우</a>
                            </c:if>
                            <c:if test="${cnt == 1}">
                            	<a href="<%=FormNo%>foCancel&follower=${bean.no}&followee=${sessionScope.loginfo.no}&user_no=${bean.no}" class="primary-btn">팔로우 취소</a>
                            </c:if>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="<%=FormNo%>foList" class="primary-btn">팔로워 : ${requestScope.followCnt}</a>
                            <a href="#" class="primary-btn">팔로잉 : ${requestScope.followeeCnt}</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    <div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="panel panel-primary">
			<ul class="nav nav-tabs">
				<li class="active"><a class="nav-link active" data-toggle="tab" href="#community">커뮤니티</a></li>
				<li><a class="nav-link" data-toggle="tab" href="#qna">Q&A</a></li>
				<li><a class="nav-link" data-toggle="tab" href="#product">상품</a></li>
			</ul>
			<div class="tab-content">
				<div id="community" class="tab-pane fade in">
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">글 번호</th>
								<th scope="col">카테고리</th>
								<th scope="col" colspan="2">글 제목</th>
								<th scope="col">날짜</th>
								<th scope="col"><a href="#">더보기</a></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="bean" items="${requestScope.colists}">
								<tr>
									<th scope="row">${bean.no}</th>
									<td>${bean.category}</td>
									<td colspan="2"><a
										href="<%=FormNo%>coDetailView&no=${bean.no}">${bean.title}</a></td>
									<td>${bean.date}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div id="qna" class="tab-pane fade in">
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">글 번호</th>
								<th scope="col">카테고리</th>
								<th scope="col" colspan="2">글 제목</th>
								<th scope="col">날짜</th>
								<th scope="col"><a href="#">더보기</a></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="bean" items="${requestScope.qnalists}">
								<tr>
									<th scope="row">${bean.no}</th>
									<td>${bean.category}</td>
									<td colspan="2"><a
										href="<%=FormNo%>qnaDetailView&no=${bean.no}">${bean.title}</a></td>
									<td>${bean.date}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div id="product" class="tab-pane fade in">
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">글 번호</th>
								<th scope="col">판매 상태</th>
								<th scope="col" colspan="2">글 제목</th>
								<th scope="col">날짜</th>
								<th scope="col"><a href="#">더보기</a></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="bean" items="${requestScope.prlists}">
								<tr>
									<th scope="row">${bean.no}</th>
									<td>${bean.state}</td>
									<td colspan="2"><a
										href="<%=FormNo%>prDetailView&no=${bean.no}">${bean.title}</a></td>
									<td>${bean.date}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>	
</body>
</html>
    
<%@ include file="./../common/footer.jsp"%>
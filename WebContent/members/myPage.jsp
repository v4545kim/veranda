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
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="css/bootstrap.min2.css" type="text/css">
</head>
<body>
	 <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Blog Hero Begin -->
    <div class="blog-hero set-bg" data-setbg="img/blog/details/blog-hero.jpg">
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="col-lg-7">
                    <div class="blog__hero__text">
                        <h2>마이 페이지</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Blog Hero End -->

    <!-- Blog Details Section Begin -->
    <section class="blog-details spad">
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="col-lg-8">
                    <div class="blog__details__content">
                        <div class="blog__details__author">
                            <div class="blog__details__author__pic">
                                <img src="img/blog/details/blog-author.jpg" alt="">
                            </div>
                            <div class="blog__details__author__text">
                                <h6>아이디 : ${loginfo.user_id}</h6>
                                <h6>닉네임 : ${loginfo.user_nickname}</h6>
                                <h6>이름 : ${loginfo.user_name}</h6>
                                <h6>생년월일 : ${loginfo.user_birth}</h6>
                                <h6>성별 : ${loginfo.user_gender}</h6>
                                <h6>우편번호 : ${loginfo.user_postcode}</h6>
                                <h6>주소 : ${loginfo.user_address} ${loginfo.user_address1} ${loginfo.user_address_mark}</h6>
                            </div>
                            <a href="<%=FormNo%>meUpdate&id=${sessionScope.loginfo.user_id}" class="primary-btn">회원 정보 수정</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="#" class="primary-btn"> 1 follwer / 2 following</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Blog Details Section End -->

	<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="panel panel-primary">
			<ul class="nav nav-tabs">
				<li class="active"><a class="nav-link active" data-toggle="tab"
					href="#zim">찜</a></li>
				<li><a class="nav-link" data-toggle="tab" href="#community">커뮤니티</a></li>
				<li><a class="nav-link" data-toggle="tab" href="#qna">Q&A</a></li>
				<li><a class="nav-link" data-toggle="tab" href="#product">상품</a></li>
			</ul>
			<div class="tab-content">
				<div id="zim" class="tab-pane fade in active">
					<h3>찜</h3>
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
							<c:forEach var="bean" items="${requestScope.lists}">
								<c:if test="${bean.user_no == sessionScope.loginfo.no}">
									<tr>
										<th scope="row">${bean.no}</th>
										<td>${bean.category}</td>
										<td colspan="2"><a
											href="<%=FormNo%>qnaDetailView&no=${bean.no}">${bean.title}</a></td>
										<td>${bean.date}</td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</div>
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
								<c:if test="${bean.user_no == sessionScope.loginfo.no}">
									<tr>
										<th scope="row">${bean.no}</th>
										<td>${bean.category}</td>
										<td colspan="2"><a
											href="<%=FormNo%>qnaDetailView&no=${bean.no}">${bean.title}</a></td>
										<td>${bean.date}</td>
									</tr>
								</c:if>
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
								<c:if test="${bean.user_no == sessionScope.loginfo.no}">
									<tr>
										<th scope="row">${bean.no}</th>
										<td>${bean.category}</td>
										<td colspan="2"><a
											href="<%=FormNo%>qnaDetailView&no=${bean.no}">${bean.title}</a></td>
										<td>${bean.date}</td>
									</tr>
								</c:if>
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
								<c:if test="${bean.user_no == sessionScope.loginfo.no}">
									<tr>
										<th scope="row">${bean.no}</th>
										<td>${bean.state}</td>
										<td colspan="2"><a
											href="<%=FormNo%>qnaDetailView&no=${bean.no}">${bean.title}</a></td>
										<td>${bean.date}</td>
									</tr>
								</c:if>
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
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
	mypage입니다.
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
                                <h6>아이디 : v4545kim</h6>
                                <h6>이름 : 김순섭</h6>
                                <h6>닉네임 : 기수서</h6>
                            </div>
                            <a href="#" class="primary-btn">회원 정보 수정</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="#" class="primary-btn"> 1 follwer / 2 following</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Blog Details Section End -->

	<!-- 게시판 리스트 시작 -->
	<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="panel panel-primary">
			<ul class="nav nav-tabs">
				<li class="nav-item"><a class="nav-link active"
					data-bs-toggle="tab" href="#home">찜</a></li>
				<li class="nav-item"><a class="nav-link" data-bs-toggle="tab"
					href="#profile">커뮤니티</a></li>
					<li class="nav-item"><a class="nav-link" data-bs-toggle="tab"
					href="#profile">Q&A</a></li>
					<li class="nav-item"><a class="nav-link" data-bs-toggle="tab"
					href="#profile">상품</a></li>
			</ul>
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">글 번호</th>
						<th scope="col">카테고리</th>
						<th scope="col" colspan="2">글 제목</th>
						<th scope="col">날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bean" items="${requestScope.lists}">
						<tr>
							<th scope="row">${bean.no}</th>
							<td>${bean.category}</td>
							<td colspan="2"><a
								href="<%=FormNo%>qnaDetailView&no=${bean.no}">${bean.title}</a></td>
							<td>${bean.date}</td>
						</tr>
					</c:forEach>
					<tr>
						<td align="center" colspan="4">
							<form action="" class="form-inline" role="form" name="myform"
								method="get">
								<div class="form-group">
									<select id="mode" name="mode" class="form-control">
										<option value="all" selected="selected">선택하세요.
										<option>제목
										<option>제목+내용
										<option>작성자
										<option>불편사항
										<option>이용문의
									</select>
								</div>
								&nbsp;&nbsp;
								<div class="form-group">
									<input type="text" class="form-control" name="keyword"
										id="keyword">
								</div>
								&nbsp;&nbsp;
								<button class="btn btn-default" type="button"
									onclick="search();">검색</button>
								&nbsp;&nbsp; ${pageInfo.pagingStatus}
							</form>
						</td>
						<td>
							<button class="btn btn-default" type="button"
								onclick="writeForm();">글 등록</button>
						</td>
					</tr>
				</tbody>
			</table>
			<div align="center">
				<footer>${pageInfo.pagingHtml}</footer>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<script type="text/javascript">
		/* 필드 검색 상태 보존 */
		$('#mode option').each(function() {
			if ($(this).val() == '${pageInfo.mode}') {
				$(this).attr('selected', 'selected');
			}
		});

		$('#keyword').val('${pageInfo.keyword}');
	</script>
	<br>
	<!-- 게시판 리스트 끝 -->



</body>
</html>
<%@ include file="./../common/footer.jsp"%>
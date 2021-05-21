<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="./../common/common.jsp"%>

<%
/* position for grid system */
int offset = 2;
int mywidth = twelve - 2 * offset;
int formleft = 3;
int formright = twelve - formleft;
int rightButton = 2;
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<link rel="stylesheet" href="css/bootstrap.min2.css" type="text/css">

<title>커뮤니티를 올려 보아요!</title>

<script type="text/javascript">

/* 게시판 입력 폼 유효성 검사 */
function checkForm() {
	/* 제목 길이 체크 */
	var title = document.insertform.title.value;
	if (title.length < 2) {
		alert('제목은 최소 2자리 이상이어야 합니다.');
		document.insertform.title.focus();
		return false;
		
	} else if (title.length > 20) {
		alert('제목은 최소 20자리 이하이어야 합니다.');
		document.insertform.title.focus();
		return false;
	}
	
	/* 내용 길이 체크 */
	var content = document.insertform.content.value;
	
	if (content.length < 5) {
		alert('내용은 최소 5자리 이상이어야 합니다.');
		document.insertform.content.focus();
		return false;
		
	} else if (content.length > 1333) {
		alert('내용은 최대 1333자리 이하이어야 합니다.');
		document.insertform.content.focus();
		return false;
	}
	
	/* 카테고리 선택 체크 */
	var category = document.insertform.category.value;
	
	if (category == "-") {
		alert('카테고리를 선택해주세요.');
		document.insertform.category.focus();
		return false;

	}
}

</script>

<style type="text/css">
	.checkout__input_2 input{
		height: 350px;
		width: 100%;
		border: 1px solid #e1e1e1;
		font-size: 14px;
		color: #666666;
		padding-left: 20px;
		margin-bottom: 20px;
	}
	.checkout__input_2 p span {
 		 color: #f08632;
	}
</style>

</head>
<body>
	<!-- 게시판 입력 폼 시작 -->

	<!-- Breadcrumb Begin -->
	<div class="breadcrumb-option">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="breadcrumb__text">
						<h2>
							Community Board
						</h2>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="breadcrumb__links">
						<a href="<%=FormNo%>main">
							Home
						</a>
						<span>
						 	Community
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcrumb End -->

	<!-- Checkout Section Begin -->
	<section class="checkout spad">
		<div class="container">
			<div class="checkout__form">
				<form name="insertform" action="<%=FormYes%>" method="post" enctype="multipart/form-data">
					<input type="hidden" name="command" value="coInsert"> 
					<input type="text" name="writer" readonly="readonly" value="${sessionScope.loginfo.user_id}">
					<input type="text" name="user_no" readonly="readonly" value="${sessionScope.loginfo.no}">
					<input type="text" name="comno" value="${bean.no}">
					
					<div class="row">
						<div class="col-lg-12 col-md-6">
							<h6 class="coupon__code">
								<span class="icon_tag_alt"> </span> 
								Community 게시판 글 작성
							</h6>
							<div class="row">
								<div class="col-lg-8">
									<div class="checkout__input">
										<p>
											제목
												<span>
													*
												</span>
										</p>
										<input type="text" name="title" id="title">
									</div>
								</div>
								<div class="col-lg-4">
									<div class="checkout__input">
										<p>
											카테고리
												<span>
													*
												</span>
										</p>
										<div>
											<select id="category" name="category" class="form">
												<option value="-" selected="selected">선택하세요
												<option value="free">자유게시판
												<option value="info">정보공유
												<option value="review">구매후기
												<option value="myveranda">베란다 뽐내기
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="checkout__input_2">
								<p>
									글 내용
										<span>
											*
										</span>
								</p>
								<textarea rows="auto" cols="125" name="content" id="content"></textarea>
							</div>
							
							<br><br>
							
								<p> 사진 </p>
								<input type="file" class="insertImg" name="image1" id="image1" value="${bean.image1}" accept="image/jpg, image/jpeg, image/png">
								
								<input type="file" class="insertImg" name="image2" id="image2" value="${bean.image2}" accept="image/jpg, image/jpeg, image/png">
								
								<br><br>
								
								<input type="file" class="insertImg" name="image3" id="image3" value="${bean.image3}" accept="image/jpg, image/jpeg, image/png">
								
								<input type="file" class="insertImg" name="image4" id="image4" value="${bean.image4}" accept="image/jpg, image/jpeg, image/png">
								
								<br><br>
								
								<input type="file" class="insertImg" name="image5" id="image5" value="${bean.image5}" accept="image/jpg, image/jpeg, image/png">
								
								<input type="file" class="insertImg" name="image6" id="image6" value="${bean.image6}" accept="image/jpg, image/jpeg, image/png">
								
								<br><br>
								
								<input type="file" class="insertImg" name="image7" id="image7" value="${bean.image7}" accept="image/jpg, image/jpeg, image/png">
								
								<input type="file" class="insertImg" name="image8" id="image8" value="${bean.image8}" accept="image/jpg, image/jpeg, image/png">
								
								<br><br>
								
								<input type="file" class="insertImg" name="image9" id="image9" value="${bean.image9}" accept="image/jpg, image/jpeg, image/png">
								
								<input type="file" class="insertImg" name="image10" id="image10" value="${bean.image10}" accept="image/jpg, image/jpeg, image/png">
							
							<br>
							
							<button type="submit" class="site-btn" onclick="return checkForm();">
								등록
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
	<!-- Checkout Section End -->

	<!-- 게시판 입력 폼 끝 -->
</body>
</html>

<jsp:include page="/common/footer.jsp"></jsp:include>
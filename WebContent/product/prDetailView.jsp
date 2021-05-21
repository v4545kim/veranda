<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="./../common/common.jsp"%>
<%
/* position for grid system */
int offset = 2;
int mywidth = twelve - 2 * offset;
int formleft = 3;
int formright = twelve - formleft;
int rightButton = 2;
%>

<html>
<head>


<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min2.css" type="text/css">
<script type="text/javascript">

   /* 게시판 입력 폼 유효성 검사 */
   function checkForm() {

      /* 내용 길이 체크 */
      var content = document.insertform.content.value;
      if (content.length < 2) {
         alert('내용은 최소 2자리 이상이어야 합니다.');
         document.insertform.content.focus();
         return false;
      } else if (content.length > 300) {
         alert('내용은 최대 300자리 이하이어야 합니다.');
         document.insertform.content.focus();
         return false;
      }

      /* 로그인 상태 체크 */
      var category = document.insertform.category.value;
      if (category == "-") {
         alert('카테고리를 선택해주세요.');
         document.insertform.category.focus();
         return false;

      }
   }
   
 <!----------------------------- 찜 기능----------------------------------------->
 
 </script>
</head>
<body>
	<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="panel panel-primary">
			<div class="card mb-3">
				<table class="table table-hover">
					<tr>
						<th scope="row">${bean.no}</th>
						<c:if test="${bean.state == 0}">
							<th>판매중</th>
						</c:if>
						<c:if test="${bean.state == 1}">
							<th>판매완료</th>
						</c:if>
						<th>${bean.title}</th>
						<c:if test="${bean.user_no == sessionScope.loginfo.no}">
							<th><a href="<%=FormNo%>myPage">${writer}</a></th>
						</c:if>
						<c:if test="${bean.user_no != sessionScope.loginfo.no}">
							<th><a href="<%=FormNo%>neighborPage&writer=${writer}">${writer}</a></th>
						</c:if>
						<th>${bean.date}</th>
						<c:if test="${bean.user_no == sessionScope.loginfo.no}">
							<td><a
								href="<%=FormNo%>prUpdate&no=${bean.no}&${requestScope.parameters}">
									수정 </a></td>
							<td><a href="<%=FormNo%>prDelete&no=${bean.no}"> 삭제 </a></td>
						</c:if>
					</tr>
				</table>
				<div class="card-body">
					<h5 class="card-title">${bean.content}</h5>
				</div>

				<div align="center">
					<img class="upImg" src="upload/${bean.image1}"> <img
						class="upImg" src="upload/${bean.image2}"><br>
					<br> <img class="upImg" src="upload/${bean.image3}"> <img
						class="upImg" src="upload/${bean.image4}"><br>
					<br> <img class="upImg" src="upload/${bean.image5}"> <img
						class="upImg" src="upload/${bean.image6}"><br>
					<br> <img class="upImg" src="upload/${bean.image7}"> <img
						class="upImg" src="upload/${bean.image8}"><br>
					<br> <img class="upImg" src="upload/${bean.image9}"> <img
						class="upImg" src="upload/${bean.image10}"><br>
					<br>

				</div>
				<!-- 페이지 이동없게 만들기 -->
				<iframe name="no_refresh_frame" style="display: none;"></iframe>
				<form name="zimform" action="<%=FormYes%>" method="post"
					target="no_refresh_frame">
					<input type="hidden" name="no" value="${bean.no}"> <input
						type="hidden" name="user_no" value="${sessionScope.loginfo.no}">
					<input type="hidden" name="command" value="prZim">
					<div class="heart">
						<button type="submit" class="btn btn-default "
							onclick="alert('찜했습니다!');">
							<img alt="찜" src="img/heart.png" width="40" height="40"
								align="right">
						</button>
						&nbsp;&nbsp;&nbsp;
					</div>
				</form>


				<!-- 댓글 입력------------------------------------------------------------------------------------------->


				<ul class="list-group list-group-flush">
					<li class="list-group-item"><c:if test="${whologin != 0}">
							<form name="insertform" action="<%=FormYes%>" method="post">
								<input type="hidden" name="no" value="${bean.no}"> <input
									type="hidden" name="command" value="pcoInsert"> <input
									type="hidden" name="writer" value="${sessionScope.loginfo.no}">
								작성자 : <input type="text" disabled="disabled"
									value="${sessionScope.loginfo.user_nickname}">
								<textarea name="content" rows="3" cols="120"
									style="resize: none;" placeholder="댓글을 입력하세요."></textarea>
								<button type="submit" onclick="return checkForm();">댓글
									등록</button>
							</form>
						</c:if></li>
					<c:forEach var="comment" items="${requestScope.colists}">
						<li class="list-group-item"><c:if
								test="${comment.user_no == sessionScope.loginfo.no}">
								<th>작성자 : <a href="<%=FormNo%>myPage">${comment.writer}</a></th>
							</c:if> <c:if test="${comment.user_no != sessionScope.loginfo.no}">
								<th>작성자 : <a
									href="<%=FormNo%>neighborPage&writer=${comment.writer}">${comment.writer}</a></th>
							</c:if> - 등록일자 ${comment.date} <c:if
								test="${comment.user_no == sessionScope.loginfo.no}">
								<td><a
									href="<%=FormNo%>pcoUpdate&comm_no=${comment.prod_no}&${requestScope.parameters}">
										수정 </a></td>
								<td><a
									href="<%=FormNo%>pcoDelete&comm_no=${comment.prod_no}&no=${bean.no}">
										삭제 </a></td>
							</c:if> <br> 내용 : ${comment.content}</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="col-sm-offset-5 col-sm-4" align="left">
		<button class="btn btn-primary" onclick="history.back();" >
		   목록보기
		</button>
     </div>
	</div>
</body>
</html>
<jsp:include page="/common/footer.jsp"></jsp:include>
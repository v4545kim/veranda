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
   .upImg{
   		height: 350px;
   		width: 350px;
   }
</style>
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
</script>
</head>
<body>
	<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="panel panel-primary">
			<div class="card mb-3">
				<table class="table table-hover">
					<tr>
						<th scope="row">${bean.no}</th>
						<th>${bean.category}</th>
						<th>${bean.title}</th>
						<c:if test="${bean.user_no == sessionScope.loginfo.no}">
							<th><a href="<%=FormNo%>myPage">${writer}</a></th>
						</c:if>
						<c:if test="${bean.user_no != sessionScope.loginfo.no}">
							<th><a href="<%=FormNo%>neighborPage&writer=${writer}&user_no=${bean.user_no}">${writer}</a></th>
						</c:if>
						<th>${bean.date}</th>
						<c:if test="${bean.user_no == sessionScope.loginfo.no}">
							<td>
								<a href="<%=FormNo%>qnaUpdate&no=${bean.no}&${requestScope.parameters}">
									수정
								</a>
							</td>
							<td>
								<a href="<%=FormNo%>qnaDelete&no=${bean.no}">
									삭제
								</a>
							</td>
						</c:if>
					</tr>
				</table>
				<div class="card-body">
					<h5 class="card-title">${bean.content}</h5>
				</div>
				
				
				<ul class="list-group list-group-flush">
					<li class="list-group-item">
						<c:if test="${whologin != 0}">
							<form name="insertform" action="<%=FormYes%>" method="post">
								<input type="hidden" name="no" value="${bean.no}">
								<input type="hidden" name="command" value="qcoInsert">
								<input type="hidden" name="writer" value="${sessionScope.loginfo.no}">
								작성자 : <input type="text" disabled="disabled" value="${sessionScope.loginfo.user_nickname}">
								<textarea name="content" rows="3" cols="120" style="resize: none;" placeholder="댓글을 입력하세요."></textarea>
								<button type="submit" onclick="return checkForm();">
									댓글 등록
								</button>
							</form>
						</c:if>
					</li>
					<c:forEach var="comment" items="${requestScope.colists}">
	    				<li class="list-group-item">
	    					<c:if test="${comment.user_no == sessionScope.loginfo.no}">
								<th>작성자 : <a href="<%=FormNo%>myPage">${comment.writer}</a></th>
							</c:if>
							<c:if test="${comment.user_no != sessionScope.loginfo.no}">
								<th>작성자 : <a href="<%=FormNo%>neighborPage&writer=${comment.writer}">${comment.writer}</a></th>
							</c:if>
	    					- 등록일자 ${comment.date}
	    					<c:if test="${comment.user_no == sessionScope.loginfo.no}">
								<td>
									<a href="<%=FormNo%>qcoUpdate&comm_no=${comment.qna_no}&${requestScope.parameters}">
										수정
									</a>
								</td>
								<td>
									<a href="<%=FormNo%>qcoDelete&comm_no=${comment.qna_no}&no=${bean.no}">
										삭제
									</a>
								</td>
							</c:if> 
	    					<br> 
	    					내용 : ${comment.content}
	    				</li>
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
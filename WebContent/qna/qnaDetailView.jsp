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
</head>
<body>
	<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="panel panel-primary">
			<div class="card mb-3">
				<table class="table table-hover">
					<tr>
						<th scope="row">${bean.no}</th>
						<td>${bean.category}</td>
						<td colspan="2">${bean.title}</td>
						<c:if test="${bean.user_no == sessionScope.loginfo.no}">
							<td><a href="<%=FormNo%>myPage">${writer}</a></td>
						</c:if>
						<c:if test="${bean.user_no != sessionScope.loginfo.no}">
							<td><a href="<%=FormNo%>neighborPage&writer=${writer}">${writer}</a></td>
						</c:if>
						<td>${bean.date}</td>
						<c:if test="${bean.user_no == sessionScope.loginfo.no}">
							<td>
								<a href="<%=FormNo%>qnaUpdate&no=${bean.no}&${requestScope.parameters}">
									수정
								</a>
							</td>
							<td>
								<a href="<%=FormNo%>qnaDelete&no=${bean.no}&${requestScope.parameters}">
									삭제
								</a>
							</td>
						</c:if>
					</tr>
				</table>
				<div class="card-body">
					<h5 class="card-title">내용 칸 : ${bean.content}</h5>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<jsp:include page="/common/footer.jsp"></jsp:include>
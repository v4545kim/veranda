<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<%
	/* position for grid system */	
	int offset = 2 ;
	int mywidth = twelve - 2 * offset ;
	int leftside = 4 ;
	int rightside = twelve - leftside ;
	

%> 
<!DOCTYPE html><html>
<head>
	<script>			
		$(document).ready(function(){
			$('[data-toggle="popover"]').popover();
		});
	</script>
	
</head>
<body>
	<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>글 상세 보기</h4>
			</div>
			<%-- <div class="panel-body">
				<div class="col-sm-<%=leftside%>">
					<table>
						<tr>
							<td>
		                     <img src="${applicationScope.uploadedPath}/${bean.image}"
		                     class="image-rounded" alt="${bean.name}"
		                     width="200" height="200">
                    		 </td>
						</tr>
					</table>
				</div> --%>
				<div class=>
					<table class="table table-bordered">
						<tr>
							<td>글번호</td>
							<td>${bean.no}</td> 
						
							<td>카테고리</td>
							<td>${bean.state}</td> 
						
							<td>제목</td>
							<td>${bean.title}</td> 
						
							<td>날짜</td>
							<td>${bean.date}</td>
						
							<td>작성자</td>
							<td>${bean.user_no}</td>					
						</tr>
						</table>
						<table>
						<tr>
							<td >글 내용</td>
							<td colspan="10"><textarea name="contents" rows="15" cols="75"></textarea>${bean.content}</td>
						</tr>		
					</table>
				</div>
				<hr>
				<div class="col-sm-offset-5 col-sm-4" >
					<button class="btn btn-primary" onclick="history.back();">
						목록보기
					</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
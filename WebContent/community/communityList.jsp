<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
<meta charset="UTF-8">

<link rel="stylesheet" href="css/bootstrap.min2.css" type="text/css">

<title>파프리카의 커뮤니티 광장</title>

	<script type="text/javascript">
	
		function search() {
			var mode = $('#mode').val();
			var keyword = $('#keyword').val();
			location.href='<%=FormNo%>coList' + '&mode=' + mode + '&keyword=' + keyword;
		}
	
		function writeForm() {
			location.href='<%=FormNo%>coInsert';
		}
		
		function detailView() {
			location.href='<%=FormNo%>coDetail';
		}
		
		
		
		$(document).ready(function() {
			
		});
	
	</script>

	<script type="text/javascript">
		/* 필드 검색 상태 보존 */
		$('#mode option').each(function(){
			if($(this).val() == '${pageInfo.mode}'){
				$(this).attr('selected', 'selected');
			}
		});
		
		$('#keyword').val('${pageInfo.keyword}');
	</script>

</head>
<body>
	<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Community Board</h4>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<td>
								<button class="btn btn-success">
									최신순
								</button>
							</td>
							
							<td>
								<button class="btn btn-success">
									댓글순
								</button>
							</td>
							
							<td>
								<button class="btn btn-success">
									조회순
								</button>
							</td>
						</tr>
					</thead>
					
					<thead>
						<tr>
							<th align="center">글번호</th>
							<th align="center">카테고리</th>
							<th colspan="2" align="center">글 제목</th>
							<th align="center">날짜</th>
							<th align="center">조회수</th>						
						</tr>
					</thead>
					<tbody>
						
						<c:forEach var="bean" items="${requestScope.lists}">
							<tr>
								<th scope="row">${bean.no}</th>
									<td>${bean.category}</td>
									<td colspan="2">
										<a href="<%=FormNo%>coDetailView&no=${bean.no}&${requestScope.parameters}">${bean.title}</a>
									</td>
									<td>${bean.date}</td>
									<td>${bean.readhit}</td>
							</tr>
						</c:forEach>
						
						<tr>
							<td align="center" colspan="4">
								<form action="#" class="form-inline" role="form" name="searchform" method="get"> 
									<div class="form-group">
										<select id="mode" name="mode" class="form-control">
											<option value="all" selected="selected">무엇을 찾을까요?
											<option value="subject">제목
											<option value="subCon">제목+내용
											<option value="writer">작성자
											<option value="free">자유게시판
											<option value="info">정보공유
											<option value="product">베란다뽐내기
										</select>
									</div>
									&nbsp;&nbsp;
									<div class="form-group">
										<input type="text" class="form-control" name="keyword" id="keyword"> 
									</div>
									&nbsp;&nbsp;
									<button class="btn btn-warning" type="button" onclick="search();">검색</button>
									&nbsp;&nbsp;
									${pageInfo.pagingStatus}
								</form>
							</td>
							<td>
								<button class="btn btn-warning" type="button" onclick="writeForm();">
									글쓰기
								</button>
							</td>
						</tr>	
					</tbody>
				</table>
				<div align="center">
					<footer>${pageInfo.pagingHtml}</footer>
				</div>
			</div>
		</div>
	</div>
	
	<br><br><br><br>

	<br>
</body>
</html>

<jsp:include page="/common/footer.jsp"></jsp:include>
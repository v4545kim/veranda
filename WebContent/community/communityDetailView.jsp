<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="./../common/common.jsp"%>

<%
	/* position for grid system */	
	int offset = 2 ;
	int mywidth = twelve - 2 * offset ;
	int formleft = 3 ;
	int formright = twelve - formleft ;
	//int rightButton = 2 ;
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
							<td>${bean.category}</td> 
						
							<td>제목</td>
							<td>${bean.title}</td> 
						
							<td>날짜</td>
							<td>${bean.date}</td>
						
							<td>작성자</td>
							<td>${bean.user_no}</td>					
						</tr>
						</table>
						
						<table border="1">
							<tr>
								<th align="center">글 내용</th>
								<td width="1300">
									<p align="center">${bean.content}</p>
								</td>
							</tr>
						</table>
						
						<br><br>
						
						<table border="1">
							<tr>
								<th align="center" rowspan="5">사진</th>
								<td width="50%" align="center">
									<img alt="사진1" src="${applicationScope.uploadedPath}/${bean.image1}" width="auto" height="auto" class="img-rounded">
								</td>
								
								<td width="50%" align="center">
									<img alt="사진2" src="${applicationScope.uploadedPath}/${bean.image2}" width="auto" height="auto" class="img-rounded">
								</td>
						   </tr>	
						   <tr>
								<td width="50%" align="center">
									<img alt="사진3" src="${applicationScope.uploadedPath}/${bean.image3}" width="auto" height="auto" class="img-rounded">
								</td>
								
								<td width="50%" align="center">
									<img alt="사진4" src="${applicationScope.uploadedPath}/${bean.image4}" width="auto" height="auto" class="img-rounded">
								</td>
							</tr>
							
							<tr>
								<td width="50%" align="center">
									<img alt="사진5" src="${applicationScope.uploadedPath}/${bean.image5}" width="auto" height="auto" class="img-rounded">
								</td>
								
								<td width="50%" align="center">
									<img alt="사진6" src="${applicationScope.uploadedPath}/${bean.image6}" width="auto" height="auto" class="img-rounded">
								</td>
							</tr>
							
							<tr>	
								<td width="50%" align="center">
									<img alt="사진7" src="${applicationScope.uploadedPath}/${bean.image7}" width="auto" height="auto" class="img-rounded">
								</td>
								
								<td width="50%" align="center">
									<img alt="사진8" src="${applicationScope.uploadedPath}/${bean.image8}" width="auto" height="auto" class="img-rounded">
								</td>
							</tr>
							
							<tr>	
								<td width="50%" align="center">
									<img alt="사진9" src="${applicationScope.uploadedPath}/${bean.image9}" width="auto" height="auto" class="img-rounded">
								</td>
								
								<td width="50%" align="center">
									<img alt="사진10" src="${applicationScope.uploadedPath}/${bean.image10}" width="auto" height="auto" class="img-rounded">
								</td>
							
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

<jsp:include page="/common/footer.jsp"></jsp:include>
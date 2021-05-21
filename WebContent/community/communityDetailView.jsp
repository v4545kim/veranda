<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                  <td colspan="2">${bean.title}</td>
                  <td>${bean.date}</td>
                  
                  	  <c:forEach var="bean" items="${requestScope.lists}">
                  
		                  <c:if test="${sessionScope.loginfo.no == bean.no}">
		                  
		                  <td>
		                     <a href="<%=FormNo%>coUpdate&no=${bean.no}&${requestScope.parameters}">
		                        수정
		                     </a>
		                  </td>
		                  <td>
		                     <a href="">
		                        삭제
		                     </a>
		                  </td>
                  
                  			</c:if>
                  	</c:forEach>
               </tr>
            </table>
            <div class="card-body">
               <h5 class="card-title">${bean.content}</h5>
            </div>
            <div align="center">
               <img class="upImg" src="upload/${bean.image1}">
               <img class="upImg" src="upload/${bean.image2}">
               <br>
               <img class="upImg" src="upload/${bean.image3}">
               <img class="upImg" src="upload/${bean.image4}">
               <br>
               <img class="upImg" src="upload/${bean.image5}">
               <img class="upImg" src="upload/${bean.image6}">
               <br>
               <img class="upImg" src="upload/${bean.image7}">
               <img class="upImg" src="upload/${bean.image8}">
               <br>
               <img class="upImg" src="upload/${bean.image9}">
               <img class="upImg" src="upload/${bean.image10}">
            </div>
         </div>
      </div>
   </div>
</body>
</html>

<jsp:include page="/common/footer.jsp"></jsp:include>
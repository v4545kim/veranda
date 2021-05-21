<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%@ page import = "java.util.ArrayList"%>

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

<title>Insert title here</title>
</head>
<body>

   
   <!-- 이웃 페이지 안에 팔로우 정보 -->
   <div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
      <div class="panel panel-primary">
         <div class="panel-heading">
            <h4>찜한 상품 목록</h4>
         </div>
         <table class="table table-hover">
            <thead>
               <tr>
                  <th scope="col">찜한 상품</th>
         
               </tr>
            </thead>
            <tbody>
         
               
               <c:forEach var="bean" items="${requestScope.productZim}">
                  <tr>
                     <th scope="row">${bean.user_no}</th>
                     <th scope="row">${bean.prod_no}</th>   
                  </tr>
               </c:forEach>
            
            </tbody>
         </table>
         <div align="center">
            <footer>${pageInfo.pagingHtml}</footer>
         </div>
      </div>
   </div>
   <br><br><br><br>
   
   <br>
   <!-- 게시판 리스트 끝 -->
</body>
</html>
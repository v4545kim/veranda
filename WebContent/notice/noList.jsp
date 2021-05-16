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
   <script>
      function search(){
         var mode = $('#mode').val() ;
         var keyword = $('#keyword').val() ;
         location.href='<%=FormNo%>noList' + '&mode=' + mode + '&keyword=' + keyword ;
      }
      function searchAll(){
         location.href='<%=FormNo%>noList';
      }
      function writeForm(){
         location.href='<%=FormNo%>noInsert';
      }
      
      $(document).ready(function(){
         
      });

      
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
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min2.css" type="text/css">
</head>
<body>
   <!-- 게시판 리스트 시작 -->
   <div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
      <div class="panel panel-primary">
         <div class="panel-heading">
            <h4>공지사항</h4>
         </div>
         <table class="table table-hover">
            <thead>
               <tr>
                  <th scope="col">글 번호</th>                  
                  <th scope="col" colspan="2">글 제목</th>
                  <th scope="col">작성일자</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach var="bean" items="${requestScope.lists}">   
                  <tr class="table-active">
                     <th scope="row">${bean.no}</th>
                     <td colspan="2">${bean.title}</td>
                     <td>${bean.date}</td>
                  </tr>
               </c:forEach>
            
               <tr>
                  <td align="center" colspan="4">
                     <form action="" class="form-inline" role="form" name="myform" method="get"> 
                        <div class="form-group">
                           <select id="mode" name="mode" class="form-control">
                              <option value="all" selected="selected">선택하세요.
                              <option >제목
                              <option >제목+내용
                        
                           </select>
                        </div>
                        &nbsp;&nbsp;
                        <div class="form-group">
                           <input type="text" class="form-control" name="keyword" id="keyword"> 
                        </div>
                        &nbsp;&nbsp;
                        <button class="btn btn-default" type="button" onclick="search();">검색</button>
                        &nbsp;&nbsp;
                        ${pageInfo.pagingStatus}
                     </form>
                  </td>
                  <td>
               <%--    <c:if test="${whologin == 2}"> 글쓰기 테스트위해 잠시 막아둠--%>
                              <button class="btn btn-default" type="button"
                                 onclick="writeForm();">글 등록</button>
                  <%--   </c:if>--%>
                  </td>
               </tr>
            </tbody>
         </table>
      </div>
   </div>
   <br><br><br><br>
   <script type="text/javascript">
      /* 필드 검색 상태 보존 */
      $('#mode option').each(function(){
         if($(this).val() == '${pageInfo.mode}'){
            $(this).attr('selected', 'selected');
         }
      });
      
      $('#keyword').val('${pageInfo.keyword}');
   </script>
   <br>

</body>
</html>
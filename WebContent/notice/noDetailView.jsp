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

<script type="text/javascript">

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
                  
                  <c:if test="${whologin == 2}">
                  <td>
                     <a href="<%=FormNo%>noUpdate&no=${bean.no}&${requestScope.parameters}">
                        수정
                     </a>
                  </td>
                  <td>
                     <a href="<%=FormNo%>noDelete&no=${bean.no}&${requestScope.parameters}">
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
      <div class="col-sm-offset-5 col-sm-4" align="left">
               <button class="btn btn-primary" onclick="history.back();" >
                  목록보기
               </button>
            </div>
   </div>
   
</body>
</html>
<jsp:include page="/common/footer.jsp"></jsp:include>
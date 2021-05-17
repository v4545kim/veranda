<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<%
   /* position for grid system */   
   int offset = 2 ;
   int mywidth = twelve - 2 * offset ;
   int formleft = 3 ;
   int formright = twelve - formleft ;
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
$(document).ready(function(){
         $('[data-toggle="tooltip"]').tooltip();   
      });
function insertForm(){
   /* alert('회원가입 페이지'); */
   location.href='<%=FormNo%>meInsert';
}

</script>
</head>
<body>
<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
      <div class="panel panel-primary">
         <div class="panel-heading">
            <h4>회원 로그인</h4>
         </div>
         <div class="panel-body">
            <form class="form-horizontal" action="<%=FormYes%>" method="post">
               
               <input type="hidden" name="command" value="meLogin">
               
                <div class="form-group">
                     <label class="control-label col-sm-<%=formleft%>" for="id">아이디</label>
                     <div class="col-sm-<%=formright%>">
                       <input type="text" class="form-control" id="id" placeholder="아이디를 입력해 주세요." 
                          name="id" data-toggle="tooltip" title="아이디는 5글자 이상 15글자 이하로 입력해주세요."
                          value="${user_id}">
                       <span class="form-control-static err" >${erruser_id}</span>
                     </div>
                </div>
                <div class="form-group">
                  <label class="control-label col-sm-<%=formleft%>" for="pwd">비밀 번호</label>
                     <div class="col-sm-<%=formright%>">          
                       <input type="password" class="form-control" id="pwd" 
                          placeholder="비밀 번호를 입력해 주세요." name="pwd"
                          value="${user_pwd}">
                          
                       <span class="form-control-static err">${erruser_pwd}</span>
                     </div>
                </div>                
                <div class="form-group">        
                     <div class="col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
                       <button type="submit" class="btn btn-warning btn-block" > 로그인 </button>
                       &nbsp;&nbsp;&nbsp;
            <br>
                       <p class="text-center">아이디가 없으신가요? 
                       <a href="#" onclick="insertForm();"> 회원가입 </a> </p>
                     </div>
                </div>
            </form>
         </div>
      </div>
   </div>
</body>
</html>
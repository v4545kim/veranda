package com.veranda.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.member.dao.MemberDao;
import com.veranda.member.vo.Member;


public class MemberLoginController extends SuperClass{
   
   private String user_id;
   private String user_pwd;
   
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doGet(request, response);
      
      String gotopage = "/members/meLogin.jsp" ;
      super.GotoPage(gotopage);
      
      
   }
   
   @Override
   public boolean validate(HttpServletRequest request) {
      boolean isCheck = true ;// true이면 유효성 검사에 문제가 없습니다.
      
      if(this.user_id.length() < 5 || this.user_id.length() > 15) {
         request.setAttribute(super.PREFIX + "user_id", "아이디는 5글자 이상 15글자 이하이어야 합니다."); 
         isCheck = false ;
      }
      
      if(this.user_pwd.length() < 10 || this.user_pwd.length() > 20) {
         request.setAttribute(super.PREFIX + "user_pwd", "비밀 번호는 10자리 이상 이상 20글자 이하이어야 합니다."); 
         isCheck = false ;
      }
            
      return isCheck ;
   } 
   
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doPost(request, response);
      
      
      this.user_id = request.getParameter("id") ;
      this.user_pwd = request.getParameter("pwd") ;
      
      System.out.println(user_id + "/" + user_pwd);
      
      String gotopage = "" ;
      
      if (this.validate(request) == true) {
    
         System.out.println("유효성 검사에 문제 없음");
         
         MemberDao dao = new MemberDao();
         Member bean = dao.SelectData(user_id, user_pwd) ;
     
         if (bean == null) { 
            System.out.println("로그인 실패");
            String message = "아이디나 비밀 번호가 잘못되었습니다." ;
            super.setErrorMessage(message);
            gotopage = "/members/meLogin.jsp" ;
            super.GotoPage(gotopage);             
         } else { 
            System.out.println("로그인 성공");
            // 로그인 정보를 세션에 바인딩
            
            super.session.setAttribute("loginfo", bean);
            
            gotopage = "/common/main.jsp" ;           
            super.GotoPage(gotopage);
         }
         
      } else { // 문제가 있음
         // 이전에 입력했던 정보를 다시 바인딩해줍니다.
         request.setAttribute("user_id", this.user_id);
         request.setAttribute("user_pwd", this.user_pwd);
         
         gotopage = "/members/meLogin.jsp" ;
         super.GotoPage(gotopage);  
      }
   }
}   
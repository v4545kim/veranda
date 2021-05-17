package com.veranda.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;

public class MemberLogoutController extends SuperClass{
   
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doGet(request, response);
      
      super.session.invalidate(); 
      
      String gotopage = "/members/meLogin.jsp" ;
      
      super.GotoPage(gotopage);
   }
   

}
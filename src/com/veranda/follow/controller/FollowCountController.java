package com.veranda.follow.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.follow.dao.FollowDao;

public class FollowCountController extends SuperClass{
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doGet(request, response);
      
      FollowDao dao = new FollowDao();
      
      int user_no = Integer.parseInt(request.getParameter("user_no"));
      
      int followCnt = dao.FollowerCount(user_no);
      
      System.out.println("팔로워 수 : " +  followCnt);
      
      request.setAttribute("followCnt", followCnt);
      
   }
   
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      super.doPost(request, response);
   }
}
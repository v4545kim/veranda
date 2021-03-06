package com.veranda.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.notice.dao.NoticeDao;

public class NoticeDeleteController extends SuperClass{
   
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doGet(request, response);
      
      int no = Integer.parseInt(request.getParameter("no")) ;
      
      
      NoticeDao dao = new NoticeDao();
      int cnt = -1 ;
      
      cnt = dao.DeleteData(no) ;
      
      new NoticeListController().doGet(request, response);
      
   }
   
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doPost(request, response);
      
   }

}
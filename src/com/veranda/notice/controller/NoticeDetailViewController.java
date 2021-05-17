package com.veranda.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.notice.dao.NoticeDao;
import com.veranda.notice.vo.Notice;


public class NoticeDetailViewController extends SuperClass{
   
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doGet(request, response);
      
      int no = Integer.parseInt(request.getParameter("no")) ;
      
      NoticeDao dao = new NoticeDao();
      Notice bean = dao.SelectDataByPk(no) ;
      
      request.setAttribute("bean", bean);
      
      String gotopage = "/notice/noDetailView.jsp" ;
      super.GotoPage(gotopage);
      
   }
   
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doPost(request, response);
      
   }

}
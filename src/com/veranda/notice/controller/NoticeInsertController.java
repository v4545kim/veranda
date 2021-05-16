package com.veranda.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.notice.dao.NoticeDao;
import com.veranda.notice.vo.Notice;

public class NoticeInsertController extends SuperClass{
   
   private Notice bean = null;
   
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doGet(request, response);
      
      String gotopage = "/notice/noInsert.jsp" ;
      super.GotoPage(gotopage);
      
   }
   
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doPost(request, response);
   
      bean = new Notice();
      
      bean.setContent(request.getParameter("notice_content"));
      bean.setDate(request.getParameter("notice_date"));
      bean.setNo(Integer.parseInt(request.getParameter("notice_no")));
      bean.setTitle(request.getParameter("notice_title"));
      bean.setUser_no(Integer.parseInt(request.getParameter("user_no")));
      
      System.out.println("bean information");
      System.out.println(bean.toString()); 
      
      if (this.validate(request) == true) {
         System.out.println("notice insert validation check success");
         NoticeDao dao = new NoticeDao();
         int cnt = - 1 ;
         cnt = dao.InsertData(bean) ;
         
         new NoticeListController().doGet(request, response); 
         
      } else {
         System.out.println("notice insert validation check failure");
         
         request.setAttribute("bean", bean);
         String gotopage = "/notice/noInsert.jsp" ;
         super.GotoPage(gotopage);
      }
      
      
      
   }
   
   @Override
   public boolean validate(HttpServletRequest request) {
      boolean isCheck = true ;      
      if (bean.getTitle().length() < 2 || bean.getTitle().length() > 20) {
         request.setAttribute(super.PREFIX + "title", "제목은 2자리 이상 20자리 이하이어야 합니다.");
         isCheck = false ;
      }
      if (bean.getContent().length() < 5 || bean.getContent().length() > 1300) {
         request.setAttribute(super.PREFIX + "content", "글 내용은 5자리 이상 1300자리 이하이어야 합니다.");
         isCheck = false ;
      }
      return isCheck ;
   }

}
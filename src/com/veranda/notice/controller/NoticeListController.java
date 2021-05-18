package com.veranda.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.common.utility.FlowParameters;
import com.veranda.common.utility.Paging;
import com.veranda.notice.dao.NoticeDao;
import com.veranda.notice.vo.Notice;

public class NoticeListController extends SuperClass{
   
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doGet(request, response);
      String notice_title = request.getParameter("notice_title");
      System.out.println("notice_title : "+notice_title);
      FlowParameters parameters
      = new FlowParameters (
               request.getParameter("pageNumber"),
               request.getParameter("mode"),
               request.getParameter("keyword"));
      
      System.out.println("parameter list");
      System.out.println(parameters.toString());
      
      String contextPath = request.getContextPath() ;
      String url = contextPath + "/veranda?command=noList" ;
      
      NoticeDao dao = new NoticeDao();
      System.out.println("total 사이즈 확인 전");
      // 행 갯수
      int totalCount = dao.SelectTotalCount(parameters.getMode(), parameters.getKeyword()) ; 
      System.out.println("total data size : " + totalCount);
      System.out.println("total 사이즈 확인 후");
      
      Paging pageInfo = new Paging(
                        parameters.getPageNumber(), 
                        totalCount, 
                        url, 
                        parameters.getMode(), 
                        parameters.getKeyword()) ;       
          
      List<Notice> lists = dao.SelectDataList(
               pageInfo.getBeginRow(), 
               pageInfo.getEndRow(), 
               parameters.getMode(), 
               parameters.getKeyword() ) ;
      
      System.out.println("notice list count : " + lists.size()); 
      
      request.setAttribute("lists", lists);
      request.setAttribute("pageInfo", pageInfo);
      
      // 자주 사용되는 파라미터를 속성으로 정의합니다. 
      request.setAttribute("parameters", parameters.toString());
      
      String gotopage = "/notice/noList.jsp" ;
      super.GotoPage(gotopage);
   }
         
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doPost(request, response);
      
   }

}
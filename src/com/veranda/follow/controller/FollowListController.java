package com.veranda.follow.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.common.utility.FlowParameters;
import com.veranda.common.utility.Paging;
import com.veranda.follow.dao.FollowDao;
import com.veranda.follow.vo.Follow;

public class FollowListController extends SuperClass{

    @Override
      public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         super.doGet(request, response);
          System.out.println("kjkj doGet");
         FlowParameters parameters
         = new FlowParameters(
               request.getParameter("pageNumber"), 
               request.getParameter("mode"), 
               request.getParameter("keyword"));
         
         System.out.println("parameter list : ");
         System.out.println(parameters.toString());
         
         String contextPath = request.getContextPath();
         String url = contextPath + "/veranda?command=foList";
         
         FollowDao dao = new FollowDao();
         
         int totalCount = dao.SelectTotalCount(parameters.getMode(), parameters.getKeyword());
         System.out.println("total data size : " + totalCount);
         
         Paging pageInfo = new Paging(
               parameters.getPageNumber(), 
               totalCount, 
               url,
               parameters.getMode(), 
               parameters.getKeyword());
            
            int follower_no = Integer.parseInt(request.getParameter("follower_no"));
            
            List<Follow> lists = null;
            
            FollowDao fdao = new FollowDao();
            lists = fdao.GetCount(follower_no);
            
            int cnt = lists.size();
             
       
         request.setAttribute("pageInfo", pageInfo);
         
         request.setAttribute("parameters", parameters.toString());
         
         request.setAttribute("count", cnt);
         
         String gotopage = "/follow/foList.jsp";
         super.GotoPage(gotopage);
      }
      
      @Override
      public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         super.doPost(request, response);
         
      }
}   
package com.veranda.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.follow.controller.FollowCountController;
import com.veranda.follow.controller.FolloweeCountController;
import com.veranda.member.dao.MemberDao2;
import com.veranda.member.vo.Member;

public class MemberNeighborPageController extends SuperClass {
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doGet(request, response);
      
      // 회원 정보 객체 생성
      Member bean = new Member();
      
      // 작성자 정보를 담음
      String Writer = request.getParameter("writer");
      
      MemberDao2 dao = new MemberDao2();
      
      // 작성자 정보를 이용하여 회원 정보를 꺼내옴
      bean = dao.SelectDataByNickname(Writer);
      
      // 회원 정보를 bean에 바인드 함
      request.setAttribute("bean", bean);
      
      request.setAttribute("follow", bean.getNo());
      request.setAttribute("followee", bean.getNo());
      
      FollowCountController follower = new FollowCountController();
      follower.doGet(request, response);
      
      FolloweeCountController followee = new FolloweeCountController();
      followee.doGet(request, response);

      
      String gotopage = "/members/neighborPage.jsp";
      super.GotoPage(gotopage);
   }
   
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
      super.doPost(request, response);
   }

}
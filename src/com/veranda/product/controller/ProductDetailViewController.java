package com.veranda.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;

import com.veranda.product.dao.ProductDao;
import com.veranda.product.vo.Product;
import com.veranda.productcomment.controller.ProductCommentListController;


public class ProductDetailViewController extends SuperClass {

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doGet(request, response);
      
      
      // 글 번호
      int no = Integer.parseInt(request.getParameter("no"));
      String writer = null;
      
      ProductDao dao = new ProductDao();
      Product bean = dao.SelectDataByPk(no);
      
      writer = dao.SelectWriter(no);
      // 게시글 클릭 시 댓글도 같이 나오게 한다.
      new ProductCommentListController().doGet(request, response);
      
      
      
      request.setAttribute("bean", bean);
      request.setAttribute("writer", writer);

      String gotopage = "/product/prDetailView.jsp";
      super.GotoPage(gotopage);
      
      
      

      // 로그인 한 사람의 객체 정보
//      Member loginfo = (Member) super.session.getAttribute("loginfo");
      
      
      
      
      // qna 게시판은 조회수가 없어서 작성하지 않았습니다. 다른 게시판을 하시는 분들은 개별적으로 작성해주세요.
      // 로그인 한 사람과 게시물 작성자가 다르거나, 작성자 정보가 없는 경우
//      if (loginfo.getNo() == (bean.getUser_no()) == false || bean.getUser_no() == 0) {
//         dao.UpdateReadhit(no); // 조회수 1 증가 시키기
//         bean.setReadhit(bean.getReadhit() + 1);
//      }

      
      

   }

   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doPost(request, response);

   }

}
package com.veranda.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.product.dao.ProductDao;
import com.veranda.product.vo.Product;



public class ProductInsertController extends SuperClass {
    private Product bean = null;

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doGet(request, response);
      String gotopage = "/product/prInsert.jsp";
      super.GotoPage(gotopage);
   }

   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doPost(request, response);

       bean = new Product();
      bean.setContent(request.getParameter("content"));
      bean.setTitle(request.getParameter("title"));
      bean.setState(Integer.parseInt(request.getParameter("state")));

      System.out.println("bean.information");
      System.out.println(toString());

      if (this.validate(request) == true) {
         System.out.println("products insert validation check success");
         ProductDao dao = new ProductDao();
         int cnt = -1;
         cnt = dao.InsertData(bean);

         new ProductListController().doGet(request, response);

      } else {
         System.out.println("products insert validation check failure");

         request.setAttribute("bean", bean);
         String gotopage = "/product/prInsert.jsp";
         super.GotoPage(gotopage);
      }
   }

      
        @Override public boolean validate(HttpServletRequest request) { boolean
        isCheck = true ; 
        if (bean.getTitle().length() < 3 || bean.getTitle().length() > 10) { request.setAttribute(super.PREFIX + "title", "제목은 3글자 이상 10자리 이하이어야 합니다."); isCheck = false ; }
        
      
        if (bean.getContent().length() < 5 || bean.getContent().length() > 30) {
        request.setAttribute(super.PREFIX + "content",
        "글내용은 5자리 이상 30자리 이하이어야 합니다."); isCheck = false ; } return isCheck ;
       
   }
}
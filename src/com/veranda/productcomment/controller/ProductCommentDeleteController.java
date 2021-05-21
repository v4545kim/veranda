package com.veranda.productcomment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.product.controller.ProductDetailViewController;
import com.veranda.productcomment.dao.ProductCommentDao;


public class ProductCommentDeleteController extends SuperClass{

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doGet(request, response);
      
      int comm_no = Integer.parseInt(request.getParameter("comm_no"));
      System.out.println(comm_no);

      
      ProductCommentDao dao = new ProductCommentDao();
      int cnt = -1;
      cnt = dao.DeleteData(comm_no);
      
      new ProductDetailViewController().doGet(request, response);
      
   }
   
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doPost(request, response);
      
   }
   
}
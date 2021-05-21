package com.veranda.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.product.dao.ProductZimDao;

public class ProductZimController extends SuperClass{
   
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doGet(request, response);

      ProductZimDao dao = new ProductZimDao();
      
      int no = Integer.parseInt(request.getParameter("no"));
      int user_no = Integer.parseInt(request.getParameter("user_no"));
      
      System.out.println(no);
      System.out.println(user_no);
      
      int cnt = -1;
      
      cnt = dao.insertzim(no, user_no);
      
      new ProductDetailViewController().doGet(request, response);      
   }

   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doPost(request, response);
      
      
      
      int no = Integer.parseInt(request.getParameter("no"));
      int user_no = Integer.parseInt(request.getParameter("user_no"));
      
      ProductZimDao dao = new ProductZimDao();
      dao.insertzim(no, user_no);
   }
}
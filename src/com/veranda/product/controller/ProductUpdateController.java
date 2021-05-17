package com.veranda.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.product.dao.ProductDao;
import com.veranda.product.vo.Product;

public class ProductUpdateController extends SuperClass{

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doGet(request, response);
      
      int no = Integer.parseInt(request.getParameter("no"));
      ProductDao dao = new ProductDao();
      
      Product bean = dao.SelectDataByPk(no);
      
      request.setAttribute("bean", bean);
      
      String gotopage = "/product/prUpdate.jsp" ;
      super.GotoPage(gotopage);
   }
   
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doPost(request, response);
      
   }
   
}
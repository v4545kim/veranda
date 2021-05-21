package com.veranda.productcomment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.productcomment.dao.ProductCommentDao;
import com.veranda.productcomment.vo.ProductComment;


public class ProductCommentListController extends SuperClass{

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doGet(request, response);
      
      // 湲  踰덊샇
      int no = Integer.parseInt(request.getParameter("no"));
      
      ProductCommentDao dao = new ProductCommentDao();
      
      // ?볤????묒꽦???묒꽦?? ?앸퀎踰덊샇, 湲  踰덊샇, ?볤? 踰덊샇, ?볤? ?댁슜, ?볤? ?깅줉 ?좎쭨瑜??대뒗 硫붿냼??      
      List<ProductComment> colists = dao.SelectData(no);
      
      request.setAttribute("colists", colists);
      

      
   }
   
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      super.doPost(request, response);
      
   }
   
}
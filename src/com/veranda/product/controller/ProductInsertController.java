package com.veranda.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
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
      
      MultipartRequest multi = (MultipartRequest)request.getAttribute("multi");

       bean = new Product();
       
       
      bean.setContent(multi.getParameter("content"));
      bean.setTitle(multi.getParameter("title"));
      
      
      
      bean.setImage1(multi.getFilesystemName("image1"));
      bean.setImage2(multi.getFilesystemName("image2"));
      bean.setImage3(multi.getFilesystemName("image3"));
      bean.setImage4(multi.getFilesystemName("image4"));
      bean.setImage5(multi.getFilesystemName("image5"));
      bean.setImage6(multi.getFilesystemName("image6"));
      bean.setImage7(multi.getFilesystemName("image7"));
      bean.setImage8(multi.getFilesystemName("image8"));
      bean.setImage9(multi.getFilesystemName("image9"));
      bean.setImage10(multi.getFilesystemName("image10"));
      
      
      if(multi.getParameter("prod_no") != null && multi.getParameter("prod_no").equals("") == false) {
         bean.setNo(Integer.parseInt(multi.getParameter("prod_no")));
      }

      if(multi.getParameter("prod_state") != null && multi.getParameter("prod_state").equals("") == false) {
         bean.setState(Integer.parseInt(multi.getParameter("prod_state")));
      }
         
      System.out.println("bean.information");
      System.out.println(toString());

      System.out.println("product InsertController toString은 " + bean.toString());
      
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

      
        @Override 
        public boolean validate(HttpServletRequest request) { 
              boolean isCheck = true ; 
            if (bean.getTitle().length() < 3 || bean.getTitle().length() > 10) { request.setAttribute(super.PREFIX + "title", "제목은 3글자 이상 10자리 이하이어야 합니다."); isCheck = false ; }
      
            if (bean.getContent().length() < 5 || bean.getContent().length() > 30) {
            request.setAttribute(super.PREFIX + "content",
            "글내용은 5자리 이상 30자리 이하이어야 합니다."); isCheck = false ; } 
                   
              
        
           if (bean.getImage1() == null || bean.getImage1().equals("")) {
            request.setAttribute(super.PREFIX, "image" );
            isCheck = false;
         }
         return isCheck;     
        }
}      
       
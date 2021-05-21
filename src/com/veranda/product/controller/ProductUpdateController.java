package com.veranda.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.veranda.common.controller.SuperClass;
import com.veranda.member.vo.Member;
import com.veranda.product.dao.ProductDao;
import com.veranda.product.vo.Product;

public class ProductUpdateController extends SuperClass{

	private Product bean = null;
	
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
      
      MultipartRequest multi = (MultipartRequest)request.getAttribute("multi");
      
      bean = new Product();
      
      
      bean.setTitle(multi.getParameter("title"));
      bean.setUser_no(Integer.parseInt(multi.getParameter("writer")));
      bean.setContent(multi.getParameter("content"));
      bean.setState(Integer.parseInt(multi.getParameter("state")));
      
      bean.setImage1(multi.getParameter("image1"));
      bean.setImage2(multi.getParameter("image2"));
      bean.setImage3(multi.getParameter("image3"));
      bean.setImage4(multi.getParameter("image4"));
      bean.setImage5(multi.getParameter("image5"));
      bean.setImage6(multi.getParameter("image6"));
      bean.setImage7(multi.getParameter("image7"));
      bean.setImage8(multi.getParameter("image8"));
      bean.setImage9(multi.getParameter("image9"));
      bean.setImage10(multi.getParameter("image10"));
      
      if(this.validate(request) == true) {
    	  System.out.println("Products update validation check success");
    	  ProductDao dao = new ProductDao();
    	  int cnt = -1;
    	  cnt = dao.UpdateData(bean);
    	  
    	  new ProductDetailViewController().doGet(request, response);
      } else {
    	  System.out.println("products update validation check failure");
    	  
    	  request.setAttribute("bean", bean);
    	  String gotopage = "/product/prUpdate.jsp";
    	  super.GotoPage(gotopage);
      }
   }
   
   @Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true;
		if (bean.getTitle().length() < 3 || bean.getTitle().length() > 10) {
			request.setAttribute(super.PREFIX + "title", "제목은 3글자 이상 10자리 이하이어야 합니다.");
			isCheck = false;
		}

		if (bean.getContent().length() < 5 || bean.getContent().length() > 30) {
			request.setAttribute(super.PREFIX + "content", "글내용은 5자리 이상 30자리 이하이어야 합니다.");
			isCheck = false;
		}
		return isCheck;

	}
   
}
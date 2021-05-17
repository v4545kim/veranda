package com.veranda.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.community.controller.CommunityMyListController;
import com.veranda.product.controller.ProductMyListController;
import com.veranda.qna.controller.QnAListController;
import com.veranda.qna.controller.QnAMyListController;

public class MemberPageController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		QnAMyListController qna = new QnAMyListController();
		qna.doGet(request, response);
		
		ProductMyListController pr = new ProductMyListController();
		pr.doGet(request, response);
		
		CommunityMyListController co = new CommunityMyListController();
		co.doGet(request, response);
		
		String gotopage = "/members/myPage.jsp";
		super.GotoPage(gotopage);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}
}

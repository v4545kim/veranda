package com.veranda.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.qna.dao.QnADao;
import com.veranda.qna.vo.QnA;

public class QnAUpdateController extends SuperClass{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		int no = Integer.parseInt(request.getParameter("no"));
		QnADao dao = new QnADao();
		
		QnA bean = dao.SelectDataByPk(no);
		
		request.setAttribute("bean", bean);
		
		String gotopage = "/qna/qnaUpdate.jsp" ;
		super.GotoPage(gotopage);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
	}
	
}

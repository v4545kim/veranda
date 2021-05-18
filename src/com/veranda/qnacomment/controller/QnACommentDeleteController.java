package com.veranda.qnacomment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.qna.controller.QnADetailViewController;
import com.veranda.qnacomment.dao.QnACommentDao;

public class QnACommentDeleteController extends SuperClass{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		int comm_no = Integer.parseInt(request.getParameter("comm_no"));
		System.out.println(comm_no);
//		int no = Integer.parseInt(request.getParameter("no"));
//		System.out.println(no);
		QnACommentDao dao = new QnACommentDao();
		int cnt = -1;
		cnt = dao.DeleteData(comm_no);
		
		new QnADetailViewController().doGet(request, response);
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
	}
	
}

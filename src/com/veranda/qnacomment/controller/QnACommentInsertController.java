package com.veranda.qnacomment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.qna.controller.QnADetailViewController;
import com.veranda.qnacomment.dao.QnACommentDao;
import com.veranda.qnacomment.vo.QnAComment;

public class QnACommentInsertController extends SuperClass{

	private QnAComment bean = null;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	
		bean = new QnAComment();
		
		bean.setUser_no(Integer.parseInt(request.getParameter("writer")));
		bean.setNo(Integer.parseInt(request.getParameter("no")));
		bean.setContent(request.getParameter("content"));
		
		System.out.println(bean.getUser_no());
		System.out.println(bean.getNo());
		System.out.println(bean.getContent());
		
		
		
		if(this.validate(request) == true) {
			System.out.println("qna_comments insert validation check success");
			
			QnACommentDao dao = new QnACommentDao();
			
			int cnt = -1;
			cnt = dao.InsertData(bean);
			
			new QnADetailViewController().doGet(request, response);
			
		} else {
			System.out.println("qna_comments insert validation check success");
			
			request.setAttribute("bean", bean);
			String gotopage = "/qna/qnaDetailView.jsp";
			super.GotoPage(gotopage);
		}
		
	}
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true;

		if (bean.getContent().length() < 2 || bean.getContent().length() > 300) {
			request.setAttribute(super.PREFIX + "content", "글내용은 2자리 이상 300자리 이하이어야 합니다.");
			isCheck = false;
		}
		return isCheck;

	}
}

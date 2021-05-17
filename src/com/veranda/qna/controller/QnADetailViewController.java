package com.veranda.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.qna.dao.QnADao;
import com.veranda.qna.vo.QnA;
import com.veranda.qnacomment.controller.QnACommentListController;

public class QnADetailViewController extends SuperClass {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		int no = Integer.parseInt(request.getParameter("no"));
		String writer = null;
		
		QnADao dao = new QnADao();
		QnA bean = dao.SelectDataByPk(no);
		
		writer = dao.SelectWriter(no);
		// 게시글 클릭 시 댓글도 같이 나오게 한다.
//		new QnACommentListController().doGet(request, response);
		
		
		
		request.setAttribute("bean", bean);
		request.setAttribute("writer", writer);

		String gotopage = "/qna/qnaDetailView.jsp";
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);

	}

}

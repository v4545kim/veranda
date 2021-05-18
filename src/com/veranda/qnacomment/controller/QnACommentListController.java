package com.veranda.qnacomment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.qnacomment.dao.QnACommentDao;
import com.veranda.qnacomment.vo.QnAComment;

public class QnACommentListController extends SuperClass{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		// 글 번호
		int no = Integer.parseInt(request.getParameter("no"));
		
		QnACommentDao dao = new QnACommentDao();
		
		// 댓글을 작성한 작성자, 식별번호, 글 번호, 댓글 번호, 댓글 내용, 댓글 등록 날짜를 담는 메소드
		List<QnAComment> colists = dao.SelectData(no);
		
		request.setAttribute("colists", colists);
		

		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
	}
	
}

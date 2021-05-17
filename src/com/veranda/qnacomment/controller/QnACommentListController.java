package com.veranda.qnacomment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.common.utility.FlowParameters;
import com.veranda.common.utility.Paging;
import com.veranda.qnacomment.dao.QnACommentDao;
import com.veranda.qnacomment.vo.QnAComment;

public class QnACommentListController extends SuperClass{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		FlowParameters parameters
		= new FlowParameters(
				request.getParameter("pageNumber"), 
				request.getParameter("mode"), 
				request.getParameter("keyword"));
		
		System.out.println("parameter list : ");
		System.out.println(parameters.toString());
		
		String contextPath = request.getContextPath();
		String url = contextPath + "/veranda?command=qnaList";
		
		QnACommentDao dao = new QnACommentDao();
		
		int totalCount = dao.SelectTotalCount(parameters.getMode(), parameters.getKeyword());
		System.out.println("total data size : " + totalCount);
		
		Paging pageInfo = new Paging(
				parameters.getPageNumber(), 
				totalCount, 
				url,
				parameters.getMode(), 
				parameters.getKeyword());
		
		List<QnAComment> lists = dao.SelectDataList(
				pageInfo.getBeginRow(), 
				pageInfo.getEndRow(), 
				parameters.getMode(), 
				parameters.getKeyword());
		System.out.println("qna list count : " + lists.size());
		
		request.setAttribute("colists", lists);
		request.setAttribute("pageInfo", pageInfo);
		
		request.setAttribute("parameters", parameters.toString());
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
	}
	
}

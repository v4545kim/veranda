package com.veranda.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.common.utility.FlowParameters;
import com.veranda.common.utility.Paging;
import com.veranda.qna.dao.QnADao;
import com.veranda.qna.vo.QnA;

public class QnAListController extends SuperClass{

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
		
		QnADao dao = new QnADao();
		
		int totalCount = dao.selectTotalCount(parameters.getMode(), parameters.getKeyword());
		System.out.println("total data size : " + totalCount);
		
		Paging pageInfo = new Paging(
				parameters.getPageNumber(), 
				totalCount, 
				url,
				parameters.getMode(), 
				parameters.getKeyword());
		
		List<QnA> lists = dao.SelectDataList(
				pageInfo.getBeginRow(), 
				pageInfo.getEndRow(), 
				parameters.getMode(), 
				parameters.getKeyword());
		System.out.println("qna list count : " + lists.size());
		
		request.setAttribute("lists", lists);
		request.setAttribute("pageInfo", pageInfo);
		
		request.setAttribute("parameters", parameters.toString());
		
		String gotopage = "/qna/qnaList.jsp";
		super.GotoPage(gotopage);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
	}
	
}

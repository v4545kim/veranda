package com.veranda.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.common.utility.Paging;
import com.veranda.member.vo.Member;
import com.veranda.qna.dao.QnADao;
import com.veranda.qna.vo.QnA;

public class QnAMyListController extends SuperClass{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		Member loginfo = (Member) super.session.getAttribute("loginfo");
		int no = loginfo.getNo();
		
		String pageNumber = "1";
		String mode = "user_no";
		String keyword = ""+no;
		
		String contextPath = request.getContextPath();
		String url = contextPath + "/veranda?command=qnaList";
		
		QnADao dao = new QnADao();
		
		int totalCount = dao.SelectTotalCount(mode, keyword);
		System.out.println("total data size : " + totalCount);
		
		
		
		Paging pageInfo = new Paging(
				pageNumber, 
				5,
				url,
				mode, 
				keyword);
		
		List<QnA> lists = dao.SelectDataList(
				1, 
				5, 
				mode, 
				keyword);
		System.out.println("qna list count : " + lists.size());
		
		request.setAttribute("qnalists", lists);
		request.setAttribute("pageInfo", pageInfo);
		
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
	}
	
}

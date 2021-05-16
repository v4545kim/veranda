package com.veranda.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.community.dao.CommunityDao;
import com.veranda.community.vo.Community;
import com.veranda.member.vo.Member;

public class CommunityDetailViewController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		int no = Integer.parseInt(request.getParameter("no"));   // 커뮤니티 게시판에서 글 제목을 클릭했을 때 글자 번호를 컨트롤러에 넘기게 되는데, 이것을 담기 위한 변수를 선언.
		
		CommunityDao dao = new CommunityDao();
		
		Community bean = dao.SelectDataByPk(no);
		
//		Member loginfo = (Member)super.session.getAttribute("loginfo");  // 로그인 한 사란의 객체 정보를 담을 변수 선언
		
//		if ( loginfo.getNo() != ( bean.getUser_no() ) || bean.getUser_no() == 0) {// 작성자 이 외에 사람이 게시글을 보았을 때, 조회수가 증가되기 위한 조건문
//			
//			int readhit = 1;
//			
//			dao.UpdateReadhit(no); // 조회수 증가를 위해 dao에 updatereadhit 메서드 호출
//			bean.setReadhit( bean.getReadhit() + readhit );
//		}
		
		request.setAttribute("bean", bean);
		
		String gotopage = "/community/communityDetailView.jsp";
		super.GotoPage(gotopage);
		
	} // doGet 끝
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);

	}
}

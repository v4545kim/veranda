package com.veranda.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.community.controller.CommunityMyListController;
import com.veranda.follow.controller.FollowCountController;
import com.veranda.follow.controller.FolloweeCountController;
import com.veranda.follow.dao.FollowDao;
import com.veranda.member.vo.Member;
import com.veranda.product.controller.ProductMyListController;
import com.veranda.product.controller.ProductMyZimListController;
import com.veranda.qna.controller.QnAMyListController;

public class MemberPageController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		// 현재 로그인 한 사람의 정보를 가져옴.
		Member loginfo = (Member) super.session.getAttribute("loginfo");
		
		// 현재 로그인 한 사람의 user_no를 loginfo에서 꺼내옴.
		int user_no = loginfo.getNo();
		
		// 팔로우, 팔로잉 카운트를 하기 위해 user_no를 넘겨줌.
		request.setAttribute("user_no", user_no);
		
		// 팔로우 수 카운트 하는 컨트롤러 호출
		FollowDao dao = new FollowDao();
		int followCnt = dao.FollowerCount(user_no);
		request.setAttribute("followCnt", followCnt);

		// 팔로잉 수 카운트 하는 컨트롤러 호출
		int followeeCnt = dao.FolloweeCount(user_no);
		request.setAttribute("followeeCnt", followeeCnt);

		// 내가 찜한 게시글 목록 호출
		ProductMyZimListController prZim = new ProductMyZimListController();
		prZim.doGet(request, response);
		
		// 내가 쓴 qna 게시글 목록 호출
		QnAMyListController qna = new QnAMyListController();
		qna.doGet(request, response);

		// 내가 쓴 상품 게시글 목록 호출
		ProductMyListController pr = new ProductMyListController();
		pr.doGet(request, response);

		// 내가 쓴 커뮤니티 게시글 목록 호출
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

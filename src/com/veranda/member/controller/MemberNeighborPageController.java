package com.veranda.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.community.controller.CommunityYourListController;
import com.veranda.follow.controller.FollowCountController;
import com.veranda.follow.controller.FolloweeCountController;
import com.veranda.follow.dao.FollowDao;
import com.veranda.member.dao.MemberDao2;
import com.veranda.member.vo.Member;
import com.veranda.product.controller.ProductYourListController;
import com.veranda.qna.controller.QnAYourListController;

public class MemberNeighborPageController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);

		// 회원 정보 객체 생성
		Member bean = new Member();

		// 작성자(이웃페이지 주인) 정보를 담음
		int user_no = Integer.parseInt(request.getParameter("user_no"));

		MemberDao2 dao = new MemberDao2();

		// 작성자 정보를 이용하여 회원 정보를 꺼내옴
		bean = dao.SelectDataByNo(user_no);

		// 회원 정보를 bean에 바인드 함
		request.setAttribute("bean", bean);

		// 팔로우 체크를 하기 위해 FollowDao를 생성
		FollowDao fdao = new FollowDao();
		
		// 현재 로그인 한 사람의 정보를 가져옴.
		Member loginfo = (Member) super.session.getAttribute("loginfo");
		
		int followee_no = loginfo.getNo();
		int follower_no = user_no;
		int cnt = -1;
		
		// 서로 팔로우 관계인지 확인하는 메소드
		cnt = fdao.FollowCheck(followee_no,follower_no);
		
		request.setAttribute("cnt", cnt);
		
		// 팔로우 수 카운트 하는 컨트롤러 호출
		FollowCountController follower = new FollowCountController();
		follower.doGet(request, response);

		// 팔로잉 수 카운트 하는 컨트롤러 호출
		FolloweeCountController followee = new FolloweeCountController();
		followee.doGet(request, response);

		// 이웃이 쓴 qna 게시글 목록 호출
		QnAYourListController qna = new QnAYourListController();
		qna.doGet(request, response);

		// 이웃이 쓴 상품 게시글 목록 호출
		ProductYourListController pr = new ProductYourListController();
		pr.doGet(request, response);

		// 이웃이 쓴 커뮤니티 게시글 목록 호출
		CommunityYourListController co = new CommunityYourListController();
		co.doGet(request, response);
		
		System.out.println(cnt);
		String gotopage = "/members/neighborPage.jsp";
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		super.doPost(request, response);
	}

}
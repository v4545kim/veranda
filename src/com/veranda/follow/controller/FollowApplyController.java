package com.veranda.follow.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.follow.dao.FollowDao;
import com.veranda.member.controller.MemberNeighborPageController;

public class FollowApplyController extends SuperClass{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		int follower = Integer.parseInt(request.getParameter("follower"));
		int followee = Integer.parseInt(request.getParameter("followee"));
		
		new FollowDao().ApplyFollow(follower, followee);
		
		System.out.println("팔로우 성공");
		
		new MemberNeighborPageController().doGet(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}
}

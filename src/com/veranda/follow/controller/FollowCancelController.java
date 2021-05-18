package com.veranda.follow.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.follow.dao.FollowDao;
import com.veranda.member.controller.MemberNeighborPageController;

public class FollowCancelController extends SuperClass{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		int follower = Integer.parseInt(request.getParameter("follower"));
		int followee = Integer.parseInt(request.getParameter("followee"));
		
		new FollowDao().CancelFollow(follower, followee);
		
		new MemberNeighborPageController().doGet(request, response);
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
	
}

package com.veranda.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.member.dao.MemberDao;
import com.veranda.member.vo.Member;

public class MemberUpdateController extends SuperClass{
	private Member bean = null;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String gotopage = "/members/memberUpdateForm.jsp";
		super.GotoPage(gotopage);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		bean = new Member();
		
		bean.setUser_nickname(request.getParameter("nickname"));
		bean.setUser_postcode(Integer.parseInt(request.getParameter("postcode")));
		bean.setUser_address(request.getParameter("address"));
		bean.setUser_address1(request.getParameter("address1"));
		bean.setUser_address_mark(request.getParameter("aaddress_mark"));
		bean.setUser_phone(request.getParameter("phone"));
		
		MemberDao dao = new MemberDao();
	}

}

package com.veranda.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.member.dao.MemberDao;
import com.veranda.member.vo.Member;

public class MemberNickcheckController extends SuperClass{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		System.out.println("MemberNickCheckController 가 시작되었습니다.");
	
		String nickname = request.getParameter("nickname");
		
		MemberDao dao = new MemberDao();
		
		Member bean = dao.SelectDataByPk(nickname);
		
		if ( bean == null ) { /* DB에 동일한 닉네임이 없다면 */
			request.setAttribute("message",  nickname + "<font color='blue')은(는) <b> 사용 가능 </b>합니다!</font>");
			request.setAttribute("nickisCheck", true);
			
		} 
		
		String gotopage = "/members/nickNameCheck.jsp";
		super.GotoPage(gotopage);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
	}

}

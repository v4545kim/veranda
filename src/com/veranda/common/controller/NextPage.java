package com.veranda.common.controller;

public class NextPage extends SuperClass{

	public void memberInsertdoPost() {
		String nextpage = "/member/meInsertForm.jsp";
		super.GotoPage(nextpage);
	}

	public NextPage memberInsertdoGet() {
		String gotopage = "/members/memberInsertForm.jsp";
		return super.GotoPage(gotopage);
		
	}
		
	}


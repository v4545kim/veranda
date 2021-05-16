package com.veranda.common.controller ;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.dao.SampleBean;
import com.veranda.common.dao.SampleDao;


public class TemplateController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		SampleBean bean = null ;
		SampleDao dao = new SampleDao() ;
		String data = dao.toString();
		
		String id = request.getParameter("id") ;
		int no = Integer.parseInt(request.getParameter("no")) ;
		
		List<SampleBean> lists = new ArrayList<SampleBean>() ;
		
		request.setAttribute("bean", bean);
		
		String gotopage = "/common/main.jsp" ;
		super.GotoPage(gotopage);
	}	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		if (this.validate(request) == true) {
			
		} else {

		}
	}
	
	@Override
	public boolean validate(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.validate(request);
	}
}
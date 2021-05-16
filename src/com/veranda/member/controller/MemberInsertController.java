package com.veranda.member.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.NextPage;
import com.veranda.common.controller.SuperClass;
import com.veranda.member.dao.MemberDao;
import com.veranda.member.vo.Member;

public class MemberInsertController extends SuperClass{
	Member bean = null;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		String gotopage = "/members/memberInsertForm.jsp";
		super.GotoPage(gotopage);
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		bean = new Member();
		
		bean.setUser_id(request.getParameter("user_id"));
		bean.setUser_pwd(request.getParameter("user_pwd"));
		bean.setUser_name(request.getParameter("user_name"));
		bean.setUser_nickname(request.getParameter("user_nickname"));
		bean.setUser_email(request.getParameter("user_email"));
		bean.setUser_phone(request.getParameter("user_phone"));
		bean.setUser_address(request.getParameter("user_address"));
		bean.setUser_birth(request.getParameter("user_birth"));
		bean.setUser_gender(request.getParameter("user_gender"));
		bean.setUser_remark(request.getParameter("user_remark"));
		bean.setUser_postcode(Integer.parseInt(request.getParameter("pastcode")));
		bean.setUser_address(request.getParameter("address"));
		bean.setUser_address1(request.getParameter("address1"));
		bean.setUser_address_mark(request.getParameter("address_mark"));
		
		
		MemberDao dao = new MemberDao();
		
		if ( this.validate(request) == true) { /* log용 txt 파일 만들기 */
			
		     String txt = "회원 가입 유효성 검사가 정상적으로 실행 되었습니다." ;
	         	
		        String fileName = "../../../../../../src/main/webapp/log" ;
		         
		        try{
		                         
		            // BufferedWriter 와 FileWriter를 조합하여 사용 (속도 향상)
		            BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
		             
		            // 파일안에 문자열 쓰기
		            fw.write(txt);
		            fw.flush();
		 
		            fw.close();  // 객체 닫기
		             
		             
		        }catch(Exception e){ /* 파일 읽는데 문제가 생기면 excetion 발생 */
		            e.printStackTrace();
		        } // try-catch 끝
		        
		        int cnt = -1;
				
					cnt = dao.InsertData(bean);
				
					new MemberLoginController().doPost(request, response);
			
		} else {
			
			String txt = "회원 가입 유효성 검사가 실패하였습니다." ;
         	
	        String fileName = "../../../../../../src/main/webapp/log" ;
	         
	        try{
	                         
	            // BufferedWriter 와 FileWriter를 조합하여 사용 (속도 향상)
	            BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
	             
	            // 파일안에 문자열 쓰기
	            fw.write(txt);
	            fw.flush();
	 
	            fw.close();  // 객체 닫기
	             
	             
	        }catch(Exception e){ /* 파일 읽는데 문제가 생기면 excetion 발생 */
	            e.printStackTrace();
	        } // try-catch 끝
	        
	        request.setAttribute("bean", bean);
	        
	        super.doPost(request, response);
	        
	       String gotopage = "/members/memberInsertForm.jsp";
			super.GotoPage(gotopage);
			
		}

	} // doPost 끝

} // class 끝


//String token = 
//
//if (access_token != null) { /* access token 받아왔는지 확인 */
//		try {
//			String apiurl = "https://openapi.naver.com/v1/nid/me";
//			
//			URL url = new URL(apiurl);
//			
//			HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
//			
//			con.setRequestMethod("GET");
//			con.setRequestProperty("Authorization", header);
//			
//			int responseCode = con.getResponseCode();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

package com.veranda.member.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.veranda.common.dao.SuperDao;
import com.veranda.member.vo.Member;

public class MemberDao2 extends SuperDao{
	
	public Member SelectDataByNickname(String nickname) {
		PreparedStatement pstmt = null ;
	      ResultSet rs = null ;            

	      String sql = " select * from members  " ; 
	      sql += " where user_nickname = ? " ; 

	      Member bean = null ;
	      
	      try {
	         if( this.conn == null ){ this.conn = this.getConnection() ; }         
	         pstmt = this.conn.prepareStatement(sql) ;         
	         
	         pstmt.setString(1, nickname);
	         
	         rs = pstmt.executeQuery() ;
	         
	         if ( rs.next() ) {
	            bean = new Member(); 
	            
	            bean.setNo(Integer.parseInt(rs.getString("user_no")));
				bean.setUser_address(rs.getString("user_address"));
				bean.setUser_birth(rs.getString("user_birth"));
				bean.setUser_email(rs.getString("user_email"));
				bean.setUser_gender(rs.getString("user_gender"));
				bean.setUser_id(rs.getString("user_id"));
				bean.setUser_name(rs.getString("user_name"));
				bean.setUser_nickname(rs.getString("user_nickname"));
				bean.setUser_phone(rs.getString("user_phone"));
				bean.setUser_pwd(rs.getString("user_pwd"));
				bean.setUser_remark(String.valueOf(rs.getString("user_remark")));

				bean.setUser_address1(String.valueOf(rs.getString("user_address1")));
				bean.setUser_address_mark(String.valueOf(rs.getString("user_address_mark")));
				bean.setUser_postcode(Integer.parseInt(rs.getString("user_postcode")));

	         }
	         
	      } catch (SQLException e) {         
	         e.printStackTrace();
	      } finally{
	         try {
	            if( rs != null){ rs.close(); } 
	            if( pstmt != null){ pstmt.close(); } 
	            this.closeConnection() ;
	         } catch (Exception e2) {
	            e2.printStackTrace(); 
	         }
	      }       
	      return bean  ;
	}


}

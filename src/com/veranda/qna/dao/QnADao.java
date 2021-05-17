package com.veranda.qna.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.veranda.common.dao.SuperDao;
import com.veranda.qna.vo.QnA;

public class QnADao extends SuperDao{
	public int InsertData(QnA bean) {
		return 0;
	}
	
	public int UpdateData(QnA bean) {
		return 0;
	}
	
	
	public int DeleteData( int no ){
		return 0;
	}
	
	
	public QnA SelectDataByPk( int no ){
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				
		
		String sql = " select * from qnas" ;
		sql += " where qna_no = ?" ;
		
		QnA bean = null ;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;
			
			pstmt.setInt( 1, no );
			
			rs = pstmt.executeQuery() ; 
			
			if ( rs.next() ) { 
				bean = new QnA(); 
				
				bean.setNo(rs.getInt("qna_no"));
				bean.setUser_no(rs.getInt("user_no"));
				
				bean.setTitle(rs.getString("qna_title"));
				bean.setContent(rs.getString("qna_content"));
				bean.setCategory(rs.getString("qna_category"));
				
				bean.setDate(String.valueOf(rs.getDate("qna_date")));				
				
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
	
	public List<QnA> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		String sql = "select ranking, qna_no, qna_title, qna_category, qna_date ";
		sql += " from (select qna_no, qna_title, qna_category, qna_date, ";
		sql += " rank() over(order by qna_no desc) as ranking ";
		sql += " from qnas";
		
		if(mode.equalsIgnoreCase("all") == false) {
			System.out.println("not all search mode");
			sql += "where " + mode + " like '%" + keyword + "%' ";
		}
		
		sql += " ) where ranking between ? and ? " ;

		List<QnA> lists = new ArrayList<QnA>();
		try {
			if(this.conn == null) {
				this.conn = this.getConnection();
			}
			
			pstmt = this.conn.prepareStatement(sql);
			
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnA bean = new QnA();
				
				bean.setNo(rs.getInt("qna_no"));
				bean.setTitle(rs.getString("qna_title"));
				bean.setCategory(rs.getString("qna_category"));
				bean.setDate(rs.getString("qna_date"));
				
				System.out.println(bean.getNo());
				System.out.println(bean.getTitle());
				System.out.println(bean.getCategory());
				System.out.println(bean.getDate());
				
				lists.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(pstmt != null) {
					pstmt.close();
				}
				
				this.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		System.out.println("QnA 게시판 리스트 전달 성공");
		return lists;
	}

	public int UpdateReadhit(int no) {
		return 0;
	}

	public int SelectTotalCount(String mode, String keyword) {
		
		PreparedStatement pstmt = null ;
		
		ResultSet rs = null ;	

		String sql = " select count(*) as cnt from qnas" ;
		if(mode.equalsIgnoreCase("all") == false) {
			System.out.println("not all search mode");
			sql += " where " + mode + " like '%" + keyword + "%' " ;
		}
		
		int cnt = 0 ;
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;
			rs = pstmt.executeQuery() ;
			
			if (rs.next()) {
				cnt = rs.getInt("cnt");
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
		return cnt  ; 
	}
}

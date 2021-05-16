package com.veranda.community.dao;

import com.veranda.common.dao.SuperDao;
import com.veranda.community.vo.Community;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommunityDao extends SuperDao{
	
	public int InsertData(Community bean) {
		return 0;
	}
	
	public int UpdateData(Community bean) {
		return 0;
	}
	
	
	public int DeleteData( int no ){
		return 0;
	}
	
	
	public Community SelectDataByPk( int no ){
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		String sql = " select * from communities where com_no = ? ";		// 커뮤니티 게시판에서 게시글 검색을 통한 DB 검색문 변수 선언
		
		Community bean = null;
		
		List<Community> lists = new ArrayList<Community>();
		
		System.out.println("CommunityDao의 selectDataByPK()가 try-chatch문을 시작합니다.");
		
		try {
			System.out.println("CommunityDao의 selectDataByPK()가 try-chatch문에 진입하였습니다.");
			
			if ( this.conn == null ) {
				this.conn = this.getConnection();
			} // if문 끝
			
			pstmt = this.conn.prepareStatement(sql);
			
			System.out.println("CommunityDao의 selectDataByPK()가 SQL문 치환을 시작 합니다.");
			pstmt.setInt(1, no);
			System.out.println("CommunityDao의 selectDataByPK()가 SQL문 치환을 끝냈습니다.");
			
			rs = pstmt.executeQuery();
			
			System.out.println("CommunityDao의 selectDataByPK()에서 rs에 값이 있는지 여부를 검사하는 if문에 진입합니다.");
			
			if (rs.next()) { /* 게시판에서 제목 클릭 시 해당 글에 해당하는 행 전체 정보를 읽기 위하여 lists에 값을 넣는다. */
				
				System.out.println("CommunityDao의 selectDataByPK()에서 rs에 값은 참입니다.");
				
				bean = new Community();
				
				bean.setCategory(rs.getString("com_category"));
				bean.setContent(rs.getString("com_content"));
				bean.setDate(rs.getString("com_date"));
				bean.setHate(rs.getInt("com_hate"));
				bean.setLike(rs.getInt("com_like"));
				bean.setNo(rs.getInt("com_no"));
				bean.setReadhit(rs.getInt("com_readhit"));
				bean.setTitle(rs.getString("com_title"));
				bean.setUser_no(rs.getInt("user_no"));
				
				bean.setImage1(rs.getString("com_image1"));
				bean.setImage2(rs.getString("com_image2"));
				bean.setImage3(rs.getString("com_image3"));
				bean.setImage4(rs.getString("com_image4"));
				bean.setImage5(rs.getString("com_image5"));
				bean.setImage6(rs.getString("com_image6"));
				bean.setImage7(rs.getString("com_image7"));
				bean.setImage8(rs.getString("com_image8"));
				bean.setImage9(rs.getString("com_image9"));
				bean.setImage10(rs.getString("com_image10"));
				
				lists.add(bean);
				
				System.out.println("CommunityDao의 selectDataByPK()에서 list에 DB 행 값이 정상적으로 담겼습니다.");
			} // if문 끝
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if ( rs != null ) {
					rs.close();
				}
				
				if (pstmt != null ) {
					pstmt.close();
				}
				
				this.closeConnection();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return bean;
	} // SelectDataByPk 끝
	
	public List<Community> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		String sql = " select ranking, com_no, user_no, com_title, com_category, com_date, com_readhit ";
					  sql += " from ( select com_no, user_no, com_title, com_category, com_date, com_readhit, ";
					  sql += " rank() over(order by com_no desc) as ranking ";
					  sql += " from communities ";
					  
		System.out.println("CommunityDao의 SelectDataList()의 sql변수에 담긴 값 : " + sql + " 입니다.");
					  
		if (mode.equalsIgnoreCase("all") == false) {
			System.out.println("전체 검색 모드가 아닙니다.");
			sql += " where " + mode + " like '%" + keyword + "%' ";
			
			System.out.println("CommunityDao의 SelectDataList()의 전체 검색 모드로 인한 sql변수에 담긴 값 : " + sql + " 입니다.");
		}
		
		sql += " ) ";
		sql += " where ranking between ? and ? ";
		
		System.out.println("CommunityDao의 SelectDataList()의 sql변수에 담긴 모든 값 : " + sql + " 입니다.");
		
		List<Community> lists = new ArrayList<Community>();
		
		try {
			System.out.println("CommunityDao의 SelectDataList()의 try-catch문이 시작 됩니다.");
			
			if ( conn == null ) {
				super.conn = super.getConnection(); 
			}
			
			pstmt = super.conn.prepareStatement(sql);
			
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			System.out.println("CommunityDao의 SelectDataList()의 while문에 진입합니다!");
			
			while (rs.next()) {
				Community bean = new Community();
				
				bean.setUser_no(rs.getInt("user_no"));
				bean.setNo(rs.getInt("com_no"));
				bean.setCategory(rs.getString("com_category"));
				bean.setDate(rs.getString("com_date"));
				bean.setReadhit(rs.getInt("com_readhit"));
				bean.setTitle(rs.getString("com_title"));
				
				lists.add(bean);
				
				System.out.println("CommunityDao의 SelectDataList()의 community vo에 DB 값이 저장 되었습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if (rs != null) {
					rs.close();
				}
				
				if (pstmt != null) {
					pstmt.close();
				}
				
				super.closeConnection();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return lists;
	}

	public int UpdateReadhit(int no) {
		return 0;
	}
	
	public int UpdateEmotion(int no) {
		return 0;
	}

	public int SelectTotalCount(String mode, String keyword) {
		
		System.out.println("CommunityDao의 SelectTotalCount()가 시작 되었습니다.");
		
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		String sql = " select count(*) as cnt from communities " ;
		
		if (mode.equalsIgnoreCase("all") == false) {
			System.out.println(" 전체 검색 모드가 아닙니다! ");
			sql += " where " + mode + " like '%" + keyword + "%' "  ;
		}
		
		int cnt = 0 ; 
		
		try {
			
			if( this.conn == null ) { 
				this.conn = this.getConnection() ; 
			}			
			
			pstmt = this.conn.prepareStatement(sql) ;			 
			rs = pstmt.executeQuery() ; 
			
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally{
			try {
				if( rs != null){ 
					rs.close(); 
				}
				
				if( pstmt != null){ 
					pstmt.close(); 
				}
				
				this.closeConnection() ;
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		} 		
		return cnt  ; 
	}
}


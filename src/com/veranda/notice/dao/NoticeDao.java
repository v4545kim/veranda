package com.veranda.notice.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.veranda.common.dao.SuperDao;
import com.veranda.notice.vo.Notice;

public class NoticeDao extends SuperDao{

   public int InsertData(Notice bean) {
      String sql = " insert into notices( notice_title, notice_content ) " ;
      sql += " values ( ?, ? ) " ;
      
      PreparedStatement pstmt = null ;
      int cnt = -1 ;
      try {
         if( conn == null ){ super.conn = super.getConnection() ; }
         conn.setAutoCommit( false );
         pstmt = super.conn.prepareStatement(sql) ;
         
         pstmt.setString(1, bean.getContent());
         pstmt.setString(2, bean.getTitle());

         cnt = pstmt.executeUpdate() ; 
         conn.commit(); 
      } catch (Exception e) {
         SQLException err = (SQLException)e ;         
         cnt = - err.getErrorCode() ;         
         e.printStackTrace();
         try {
            conn.rollback(); 
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      } finally{
         try {
            if( pstmt != null ){ pstmt.close(); }
            super.closeConnection(); 
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
      return cnt ;
   }
   
   public int UpdateData(Notice bean) {
      String sql = " update notices set content=?, Date=?, Title=?, User_no=? " ;
      sql += " where notice_no = ? " ;
      
      PreparedStatement pstmt = null ;
      int cnt = -1 ;
      try {
         if( conn == null ){ super.conn = super.getConnection() ; }
         conn.setAutoCommit( false );
         pstmt = super.conn.prepareStatement(sql) ;

         pstmt.setString(1, bean.getContent());
         pstmt.setString(2, bean.getDate());               
         pstmt.setString(3, bean.getTitle());
         pstmt.setInt(4, bean.getNo());
         pstmt.setInt(5, bean.getUser_no());                           
                  
         cnt = pstmt.executeUpdate() ; 
         conn.commit(); 
      } catch (Exception e) {
         SQLException err = (SQLException)e ;         
         cnt = - err.getErrorCode() ;         
         e.printStackTrace();
         try {
            conn.rollback(); 
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      } finally{
         try {
            if( pstmt != null ){ pstmt.close(); }
            super.closeConnection(); 
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
      return cnt ;
   }
   
   
   public int DeleteData( int no ){
      return 0;
   }
   
   
   public Notice SelectDataByPk( int no ){
      PreparedStatement pstmt = null ;
      ResultSet rs = null ;   
      
      String sql = " select * from notices " ;
      sql += " where notice_no = ? " ;
      
      Notice bean = null ;
      
      
      
      try {
         if( this.conn == null ){ this.conn = this.getConnection() ; }         
         pstmt = this.conn.prepareStatement(sql) ;         
         
         pstmt.setInt( 1, no );
         
         rs = pstmt.executeQuery() ; 
         
         if ( rs.next() ) { 
            
            bean = new Notice(); 
            
            bean.setNo(rs.getInt("notice_no"));
            bean.setUser_no(rs.getInt("user_no"));            
            bean.setTitle(rs.getString("notice_title"));
            bean.setContent(rs.getString("notice_content"));
            bean.setDate(String.valueOf(rs.getDate("notice_date")));            
      
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
   
   public List<Notice> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
      
      PreparedStatement pstmt = null ;
      ResultSet rs = null ;
      
      String sql = " select ranking, notice_no, user_no, notice_title, notice_content, notice_date " ;
      sql += " from ( select notice_no, user_no, notice_title, notice_content, notice_date, rank() over(order by notice_no desc) as ranking " ;
      sql += " from notices " ;
      
      if(mode.equalsIgnoreCase("all") ==false) { 
         System.out.println("not all search mode");
         sql += " where " + mode + " like '%" + keyword + "%' " ;   
      }
      
      sql += "  ) " ;
      sql += " where ranking between ? and ?  " ;
      
//      String sql = "select notice_no, user_no, notice_title, notice_content, notice_date from notices ";
      
      
      
      List<Notice> lists = new ArrayList<Notice>() ;
      try {
         if( this.conn == null ){ this.conn = this.getConnection() ; }         
         pstmt = this.conn.prepareStatement(sql) ;
         
         pstmt.setInt(1, beginRow);
         pstmt.setInt(2, endRow); 
         
         rs = pstmt.executeQuery() ; 
         while ( rs.next() ) {
            Notice bean = new Notice() ; 
            
            bean.setNo(rs.getInt("notice_no"));
            bean.setUser_no(rs.getInt("user_no"));
            bean.setTitle(rs.getString("notice_title"));
            bean.setContent(rs.getString("notice_content"));
            bean.setDate(rs.getString("notice_date"));
            
            lists.add(bean);
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
      return lists  ;
      
   }   

   public int UpdateReadhit(int no) {
      return 0;
   }

   public int SelectTotalCount(String mode, String keyword) {
      
      PreparedStatement pstmt = null ;
      ResultSet rs = null ;            

      String sql = " select count(*) as cnt from notices " ;
      
      if (mode.equalsIgnoreCase("all") == false) {
         System.out.println(" 전체 검색 모드가 아닙니다 ");
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
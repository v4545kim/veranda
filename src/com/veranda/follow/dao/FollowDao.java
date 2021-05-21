package com.veranda.follow.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.veranda.common.dao.SuperDao;
import com.veranda.follow.vo.Follow;


public class FollowDao extends SuperDao{
   
   
   public int InsertData(Follow bean) {
       String sql = " insert into follows(follower_no, followee_no, follow_state) ";
       sql += "values(?,?,?) " ;
         
         PreparedStatement pstmt = null ;
         int cnt = -1 ;
         try {
            if( conn == null ){ super.conn = super.getConnection() ; }
            conn.setAutoCommit( false );
            pstmt = super.conn.prepareStatement(sql) ;
            
            pstmt.setInt(1, bean.getFollower_no());
            pstmt.setInt(2, bean.getFollowee_no());
            pstmt.setInt(3, bean.getFollow_State());
         
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
   
   public int FollowCheck(int followee, int follower) {
      PreparedStatement pstmt = null ;
       
       ResultSet rs = null ;
       
       int cnt = -1;
       
       String sql =" select count(*) as cnt from follows  ";
       sql += " where followee_no = ? and follower_no = ?";
       
       
       try {
          if( conn == null ){ super.conn = super.getConnection() ; }
          pstmt = super.conn.prepareStatement(sql) ;
          
          pstmt.setInt(1, followee);
          pstmt.setInt(2, follower);
          
          rs = pstmt.executeQuery();
          
          if (rs.next()) {
          cnt = rs.getInt("cnt");
       }
          
       } catch (Exception e) {
          e.printStackTrace();
       } finally{
          try {
             if( rs != null ){ rs.close(); }
             if( pstmt != null ){ pstmt.close(); }
             super.closeConnection(); 
          } catch (Exception e2) {
             e2.printStackTrace(); 
          }
       }
       
       return cnt;
   }
   
   public List<Follow> GetCount(int follower_no) {
       PreparedStatement pstmt = null ;
         ResultSet rs = null ;
         
         String sql =" select followee_no, follower_no from follows where followee_no = ? "; 
         
         
         List<Follow> lists = new ArrayList<Follow>();
         
         try {
            if( conn == null ){ super.conn = super.getConnection() ; }
            pstmt = super.conn.prepareStatement(sql) ;
            
            pstmt.setInt(1, follower_no);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
               Follow bean = new Follow();
               
               bean.setFollowee_no(rs.getInt("follower_no"));
               bean.setFollowee_no(rs.getInt("followee_no"));
               bean.setFollow_State(rs.getInt("follow_state"));
               
               lists.add(bean);
            }
            
         } catch (Exception e) {
            e.printStackTrace();
         } finally{
            try {
               if( rs != null ){ rs.close(); }
               if( pstmt != null ){ pstmt.close(); }
               super.closeConnection(); 
            } catch (Exception e2) {
               e2.printStackTrace(); 
            }
         }
         
         return lists;
    
   
   }
   
   public int FollowerCount(int user_no) {
       PreparedStatement pstmt = null ;
       
         ResultSet rs = null ;
         
         int cnt = -1;
         
         String sql =" select count(follower_no) as cnt from follows where follower_no = ? "; 
         
         
         try {
            if( conn == null ){ super.conn = super.getConnection() ; }
            pstmt = super.conn.prepareStatement(sql) ;
            
            pstmt.setInt(1, user_no);
            
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
            cnt = rs.getInt("cnt");
         }
            
         } catch (Exception e) {
            e.printStackTrace();
         } finally{
            try {
               if( rs != null ){ rs.close(); }
               if( pstmt != null ){ pstmt.close(); }
               super.closeConnection(); 
            } catch (Exception e2) {
               e2.printStackTrace(); 
            }
         }
         
         return cnt;
   }
   public int FolloweeCount(int user_no) {
      PreparedStatement pstmt = null ;
       
        ResultSet rs = null ;
        
        int cnt = -1;
        
        String sql =" select count(followee_no) as cnt from follows where followee_no = ? "; 
        
        
        try {
           if( conn == null ){ super.conn = super.getConnection() ; }
           pstmt = super.conn.prepareStatement(sql) ;
           
           pstmt.setInt(1, user_no);
           
           rs = pstmt.executeQuery();
           
           if (rs.next()) {
            cnt = rs.getInt("cnt");
         }
           
        } catch (Exception e) {
           e.printStackTrace();
        } finally{
           try {
              if( rs != null ){ rs.close(); }
              if( pstmt != null ){ pstmt.close(); }
              super.closeConnection(); 
           } catch (Exception e2) {
              e2.printStackTrace(); 
           }
        }
        
        return cnt;
   }

   public void ApplyFollow(int follower, int followee) {
      String sql = " insert into follows(follower_no, followee_no, follow_state) ";
      sql += "values(?,?,1) ";
      
      PreparedStatement pstmt = null;
      int cnt = -1;
      try {
         if (conn == null) {
            super.conn = super.getConnection();
         }
         conn.setAutoCommit(false);
         pstmt = super.conn.prepareStatement(sql);

         pstmt.setInt(1, follower);
         pstmt.setInt(2, followee);

         cnt = pstmt.executeUpdate();
         conn.commit();
      } catch (Exception e) {
         SQLException err = (SQLException) e;
         cnt = -err.getErrorCode();
         e.printStackTrace();
         try {
            conn.rollback();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      } finally {
         try {
            if (pstmt != null) {
               pstmt.close();
            }
            super.closeConnection();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
   }
   public void CancelFollow(int follower, int followee) {
      String sql = " delete from follows ";
      sql += " where follower_no = ? and followee_no = ? ";
      
      PreparedStatement pstmt = null;
      int cnt = -1;
      try {
         if (conn == null) {
            super.conn = super.getConnection();
         }
         conn.setAutoCommit(false);
         pstmt = super.conn.prepareStatement(sql);

         pstmt.setInt(1, follower);
         pstmt.setInt(2, followee);

         cnt = pstmt.executeUpdate();
         conn.commit();
      } catch (Exception e) {
         SQLException err = (SQLException) e;
         cnt = -err.getErrorCode();
         e.printStackTrace();
         try {
            conn.rollback();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      } finally {
         try {
            if (pstmt != null) {
               pstmt.close();
            }
            super.closeConnection();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
      
   }
}


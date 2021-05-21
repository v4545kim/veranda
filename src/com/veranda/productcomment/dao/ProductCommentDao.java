package com.veranda.productcomment.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.veranda.common.dao.SuperDao;
import com.veranda.productcomment.vo.ProductComment;


public class ProductCommentDao extends SuperDao{
   
   public int InsertData(ProductComment bean) {
      String sql = " insert into product_comments(product_comm_no, prod_no, user_no, comm_content ) ";
      sql += " values(product_commseq.nextval, ?, ?, ?) ";

      PreparedStatement pstmt = null;
      int cnt = -1;
      try {
         if (conn == null) {
            super.conn = super.getConnection();
         }
         conn.setAutoCommit(false);
         pstmt = super.conn.prepareStatement(sql);

         pstmt.setInt(1, bean.getNo());
         pstmt.setInt(2, bean.getUser_no());
         pstmt.setString(3, bean.getContent());

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
      return cnt;
   }
   
   public int UpdateData(ProductComment bean) {
      return 0;
   }
   
   public int DeleteData( int no ){
      String sql = " delete from product_comments ";
      sql += " where product_comm_no = ? ";

      PreparedStatement pstmt = null;
      int cnt = -1;
      try {
         if (conn == null) {
            super.conn = super.getConnection();
         }
         conn.setAutoCommit(false); 
         pstmt = super.conn.prepareStatement(sql);

         pstmt.setInt(1, no);

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
      return cnt;
   }
   
   public List<ProductComment> SelectDataList(int beginRow, int endRow, String mode, String keyword, int no) {
      PreparedStatement pstmt = null;
      
      ResultSet rs = null;
      
      String sql = " select ranking, product_comm_no, prod_no, user_no, comm_date, comm_content ";
      sql += " from (select product_comm_no, prod_no, user_no, comm_date, comm_content, ";
      sql += " rank() over(order by product_comm_no desc) as ranking ";
      sql += " from product_comments";
      
      if(mode.equalsIgnoreCase("all") == false) {
         System.out.println("not all search mode");
         sql += "where " + mode + " like '%" + keyword + "%' ";
      }
      
      sql += " ) where ranking between ? and ? and prod_no = ?" ;

      List<ProductComment> lists = new ArrayList<ProductComment>();
      try {
         if(this.conn == null) {
            this.conn = this.getConnection();
         }
         
         pstmt = this.conn.prepareStatement(sql);
         
         pstmt.setInt(1, beginRow);
         pstmt.setInt(2, endRow);
         pstmt.setInt(3, no);
         
         rs = pstmt.executeQuery();
         while(rs.next()) {
            ProductComment bean = new ProductComment();
            
            bean.setProd_no(rs.getInt("product_comm_no"));
            bean.setNo(rs.getInt("prod_no"));
            bean.setUser_no(rs.getInt("user_no"));
            bean.setDate(rs.getString("comm_date"));
            bean.setContent(rs.getString("comm_content"));
            
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
      System.out.println("?곹뭹 寃뚯떆???볤? 由ъ뒪???꾨떖 ?깃났");
      return lists;
   }

   public int SelectTotalCount(String mode, String keyword) {
      // TODO Auto-generated method stub
      return 0;
   }

   public List<ProductComment> SelectData(int no) {
      PreparedStatement pstmt = null;
      
      ResultSet rs = null;
      
      String sql = " select user_nickname, product_comm_no, prod_no, m.user_no as user_no, comm_content, comm_date ";
      sql += " from members m inner join product_comments p  ";
      sql += " on m.user_no = p.user_no ";
      sql += " where prod_no = ? ";
      sql += " order by product_comm_no asc ";

      List<ProductComment> cowriter = new ArrayList<ProductComment>();
      
      try {
         if(this.conn == null) {
            this.conn = this.getConnection();
         }
         
         pstmt = this.conn.prepareStatement(sql);
         
         pstmt.setInt(1, no);
         
         rs = pstmt.executeQuery();
         while(rs.next()) {
            
            ProductComment bean = new ProductComment();
            
            bean.setWriter(rs.getString("user_nickname"));
            bean.setProd_no(rs.getInt("product_comm_no"));
            bean.setNo(rs.getInt("prod_no"));
            bean.setUser_no(rs.getInt("user_no"));
            bean.setContent(rs.getString("comm_content"));
            bean.setDate(rs.getString("comm_date"));
            
            
            cowriter.add(bean);
            
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
      System.out.println("상품 게시판 댓글  작성자 전달 성공");
      
      return cowriter;      
   }
   
   
}
package com.veranda.product.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.veranda.common.dao.SuperDao;
import com.veranda.product.vo.Product;

public class ProductDao extends SuperDao {
   
      public int InsertData( Product bean ){
            String sql = " insert into products(prod_no, prod_state, prod_title, prod_content, pord_image1, pord_image2, pord_image3, pord_image4, pord_image5, pord_image6, pord_image7, pord_image8, pord_image9, pord_image10 ) " ;
            sql += " values(productseq.nextval, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?) " ;
        
            
            PreparedStatement pstmt = null ;
            int cnt = -1 ;
            try {
               if( conn == null ){ super.conn = super.getConnection() ; }
               conn.setAutoCommit( false );
               pstmt = super.conn.prepareStatement(sql) ;
               
               //name, company, image, stock, price, category, contents, point,
               
            pstmt.setInt(1, bean.getState());
            pstmt.setString(2, bean.getTitle());
            pstmt.setString(3, bean.getContent());
            pstmt.setString(4, bean.getImage1());
            pstmt.setString(5, bean.getImage2());
            pstmt.setString(6, bean.getImage3());
            pstmt.setString(7, bean.getImage4());
            pstmt.setString(8, bean.getImage5());
            pstmt.setString(9, bean.getImage6());
            pstmt.setString(10, bean.getImage7());
            pstmt.setString(11, bean.getImage8());
            pstmt.setString(12, bean.getImage9());
            pstmt.setString(13, bean.getImage10());
            
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
       
      public int UpdateData( Product bean ){
       
            return 0 ;
         }
      public int DeleteData( int prod_no ){
            String sql = " delete from products " ;
            sql += " where prod_no = ? " ;
       
            PreparedStatement pstmt = null ;
            int cnt = -1 ;
            try {
               if( conn == null ){ super.conn = super.getConnection() ; }
               conn.setAutoCommit( false ); // 커밋이 자동으로 되는 것을 막기위해 
               pstmt = super.conn.prepareStatement(sql) ;
               
               pstmt.setInt(1, prod_no);
               
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
         
      public ProductDao() {
      
      }
      

      public List<Product> SelectDataList( int beginRow, int endRow, String mode, String keyword ) {
          
          PreparedStatement pstmt = null ;
          ResultSet rs = null ;
          
        /*  String sql = " select ranking, prod_no, prod_state, prod_title, prod_content, prod_date, prod_readhit" ;
         sql += " from ( select prod_no, prod_state, prod_title, prod_content, prod_date, prod_readhit, rank() over(order by prod_no desc) as ranking " ;
          sql += " from products  " ;
          */
          
          String sql = " select ranking, prod_no, prod_title, prod_date, prod_readhit, prod_content from ( select prod_no, prod_title, prod_date, prod_readhit, prod_content, rank() over(order by prod_no desc) as ranking " ;
          sql += " from products " ;
          
          
          if(mode.equalsIgnoreCase("all") ==false) { 
             System.out.println("not all search mode");
             sql += " where " + mode + " like '%" + keyword + "%' " ;   
          }
          
          sql += "  ) " ;
          sql += " where ranking between ? and ?  " ;   
          
          

          List<Product> lists = new ArrayList<Product>();
          
          try {
             if( conn == null ){ super.conn = super.getConnection() ; }
             pstmt = super.conn.prepareStatement(sql) ;
             
             pstmt.setInt(1, beginRow);
             pstmt.setInt(2, endRow);
             
             rs = pstmt.executeQuery() ;   
             
             while( rs.next() ){
                Product bean = new Product();
                
                bean.setNo(rs.getInt("prod_no"));
                bean.setTitle(rs.getString("prod_title"));
                bean.setContent(rs.getString("prod_content"));
                bean.setDate(rs.getString("prod_date"));
                bean.setReadhit(rs.getInt("prod_readhit"));
                
                
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
          
          return lists ;
       }


     public Product SelectDataByPk( int no ){
      PreparedStatement pstmt = null ;
      ResultSet rs = null ;            
      
      String sql = " select * from products" ;
      sql += " where prod_no = ?" ;
      
      Product bean = null ;
      try {
         if( this.conn == null ){ this.conn = this.getConnection() ; }         
         pstmt = this.conn.prepareStatement(sql) ;
         
         pstmt.setInt( 1, no );
         
         rs = pstmt.executeQuery() ; 
         
         if ( rs.next() ) { 
            bean = new Product(); 
            
            bean.setNo(rs.getInt("prod_no"));
            bean.setUser_no(rs.getInt("user_no"));
            
            bean.setTitle(rs.getString("prod_title"));
            bean.setContent(rs.getString("prod_content"));
            bean.setState(rs.getInt("prod_state"));
            
            bean.setDate(String.valueOf(rs.getDate("prod_date")));   
            bean.setImage1(rs.getString("pord_image1"));
            bean.setImage2(rs.getString("pord_image2"));
            bean.setImage3(rs.getString("pord_image3"));
            bean.setImage4(rs.getString("pord_image4"));
            bean.setImage5(rs.getString("pord_image5"));
            bean.setImage6(rs.getString("pord_image6"));
            bean.setImage7(rs.getString("pord_image7"));
            bean.setImage8(rs.getString("pord_image8"));
            bean.setImage9(rs.getString("pord_image9"));
            bean.setImage10(rs.getString("pord_image10"));
            
            
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
      public int SelectTotalCount( String mode, String keyword ) {
         PreparedStatement pstmt = null ;
         ResultSet rs = null ;
         
         String sql = " select count(*) as cnt from products " ;
         if(mode.equalsIgnoreCase("all") ==false) { 
            System.out.println("not all search mode");
            sql += " where " + mode + " like '%" + keyword + "%' " ;   
         }
         int cnt = 0 ; //?녿뒗 寃쎌슦??湲곕낯 媛?
         try {
            if( this.conn == null ){ this.conn = this.getConnection() ; }         
            pstmt = this.conn.prepareStatement(sql) ;          
            rs = pstmt.executeQuery() ; 
            
            if ( rs.next() ) { 
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
      
      
       
      public int UpdateStock(Integer pnum, Integer qty) {
         String sql = " " ;
         sql += "  " ;
         sql += "  " ;

         PreparedStatement pstmt = null ;
         int cnt = -99999 ;
         try {
            if( conn == null ){ super.conn = super.getConnection() ; }
            conn.setAutoCommit( false );
            pstmt = super.conn.prepareStatement(sql) ;
            pstmt.setInt(1, qty);
            pstmt.setInt(2, pnum );  
            
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

      public int Readhit(int no) {
            PreparedStatement pstmt = null ;
            
            String sql = " update products set readhit = readhit + 1 " ;
            sql += " where no = ? " ;
          
            int cnt = -1 ; 
            try {
               if( this.conn == null ){ this.conn = this.getConnection() ; }
               conn.setAutoCommit( false ); 
               pstmt = this.conn.prepareStatement( sql ) ;
               
               pstmt.setInt(1, no);
               
               cnt = pstmt.executeUpdate() ;
               conn.commit(); 
            } catch (Exception e) {
               e.printStackTrace();
               cnt = -1 ;
               try {
                  conn.rollback();
               } catch (SQLException e1) {
                  e1.printStackTrace();
               }
            } finally{
               try {
                  if( pstmt != null ){ pstmt.close(); }
                  this.closeConnection();
               } catch (Exception e2) {
                  e2.printStackTrace(); 
               }
            }
            return cnt ; 
         }
      
      
      public int productzim(String user_no, String prod_no) {
         
         String sql = " insert into productzim values(?,?) ";
         try {
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, user_no);
         pstmt.setString(2, prod_no);
         
         return pstmt.executeUpdate();
      
               
      } catch (Exception e) {
         e.printStackTrace();
      }
      return -1;
      }
    
   }
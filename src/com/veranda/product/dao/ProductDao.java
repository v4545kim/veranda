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
            String sql = " insert into products " ;
            sql += " ( " ;
            sql += " no, state, title, contents, image1, image2, image3, image4, image5, image6, image7, image8, image9, image10 " ;
            sql += " ) " ;
            sql += " values( " ;
            sql += " seqprod.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?  " ;
            sql += " ) " ;
            
            PreparedStatement pstmt = null ;
            int cnt = -1 ;
            try {
               if( conn == null ){ super.conn = super.getConnection() ; }
               conn.setAutoCommit( false );
               pstmt = super.conn.prepareStatement(sql) ;
               
               //name, company, image, stock, price, category, contents, point,
               pstmt.setInt(1, bean.getNo());
               pstmt.setInt(2, bean.getState());
               pstmt.setString(3, bean.getTitle());
               pstmt.setString(4, bean.getContent());
               pstmt.setString(5, bean.getImage1());
               pstmt.setString(6, bean.getImage2());
               pstmt.setString(7, bean.getImage3());
               pstmt.setString(8, bean.getImage4());
               pstmt.setString(9, bean.getImage5());
               pstmt.setString(10, bean.getImage6());
               pstmt.setString(11, bean.getImage7());
               pstmt.setString(12, bean.getImage8());
             pstmt.setString(13, bean.getImage9());
             pstmt.setString(14, bean.getImage10());
                     
            
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
            String sql = " " ;
            sql += "  " ;
            sql += "  " ;


            PreparedStatement pstmt = null ;
            int cnt = -99999 ;
            try {
               if( conn == null ){ super.conn = super.getConnection() ; }
               conn.setAutoCommit( false );
               pstmt = super.conn.prepareStatement(sql) ;
                  
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
      public int DeleteData( int num ){
            String sql = "" ;
            

            
            PreparedStatement pstmt = null ;
            int cnt = -99999 ;
            try {
               if( conn == null ){ super.conn = super.getConnection() ; }
               conn.setAutoCommit( false );
               
               // remark 而щ읆 ?섏젙
               sql = " update orderdetails set remark = ? " ;
               sql += " where pnum = ? " ;         
               pstmt = super.conn.prepareStatement(sql) ;
               
               Product bean = this.SelectDataByPk(num);
               //移섑솚 
              // String imsi = "?곹뭹 " + bean.getName()+ "??媛 ) ??젣 ?섏뿀?듬땲??";
               
             //  pstmt.setString(1, imsi);
               pstmt.setInt(2, num);
               
               cnt = pstmt.executeUpdate() ;
               conn.commit();
               
               if(pstmt != null) {pstmt.close();}
               conn.setAutoCommit(false);
               
               // ?대떦 ?곹뭹????젣
               sql = " delete from products " ;
               sql += " where num = ? " ;
                  
               pstmt = super.conn.prepareStatement(sql) ;
               //移섑솚 
               pstmt.setInt(1, num);
               
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
         // ?대떦 寃 ??議곌굔??留욌뒗 紐⑤뱺 ?곗씠?곕? 議고쉶?⑸땲??
         PreparedStatement pstmt = null ;
         ResultSet rs = null ;
         
//         String sql = " select ranking, no, state, title, content, date, readhit" ;
//         sql += " from ( select no, state, title, content, date, readhit, rank() over(order by no desc) as ranking " ;
//         sql += " from products  " ;
//         
//         if(mode.equalsIgnoreCase("all") ==false) { 
//            System.out.println("not all search mode");
//            sql += " where " + mode + " like '%" + keyword + "%' " ;   
//         }
//         
//         sql += "  ) " ;
//         sql += " where ranking between ? and ?  " ;   
         
         String sql =" select prod_no, prod_title, prod_date, prod_readhit, prod_content from products";

         List<Product> lists = new ArrayList<Product>();
         
         try {
            if( conn == null ){ super.conn = super.getConnection() ; }
            pstmt = super.conn.prepareStatement(sql) ;
            
//            pstmt.setInt(1, beginRow);
//            pstmt.setInt(2, endRow);
            
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

      public Product SelectDataByPk( int no  ){
            PreparedStatement pstmt = null ;
            ResultSet rs = null ;            

            String sql = " select * from products " ;
            sql += "  where no = ? " ;

            Product bean = null ;
            try {
               if( this.conn == null ){ this.conn = this.getConnection() ; }         
               pstmt = this.conn.prepareStatement(sql) ;         

               pstmt.setInt( 1, no ); 
               
               rs = pstmt.executeQuery() ; 
               
               if ( rs.next() ) {
                  bean = new Product() ;
                  
                  bean.setNo(rs.getInt("no"));
                  bean.setState(rs.getInt("state"));            
                  bean.setTitle(rs.getString("title"));
                  bean.setContent(rs.getString("content"));
                  bean.setDate(rs.getString("date"));
                  bean.setReadhit(rs.getInt("readhit"));
               }
               
            } catch (SQLException e) {         
               e.printStackTrace();
            } finally{
               try {
                  if( rs != null){ rs.close(); } 
                  if( pstmt != null){ pstmt.close(); } 
                  // this.closeConnection() ;
                  
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
   }
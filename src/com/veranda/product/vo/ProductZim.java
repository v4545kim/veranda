package com.veranda.product.vo;

public class ProductZim {

      private int user_no;
      private int prod_no;
      private String prod_title;
      
      
      public int getUser_no() {
         return user_no;
      }
      public void setUser_no(int user_no) {
         this.user_no = user_no;
      }
      public int getProd_no() {
         return prod_no;
      }
      public void setProd_no(int prod_no) {
         this.prod_no = prod_no;
      }
      public String getProd_title() {
         return prod_title;
      }
      public void setProd_title(String prod_title) {
         this.prod_title = prod_title;
      }
      
      @Override
      public String toString() {
         return "ProductZim [user_no=" + user_no + ", prod_no=" + prod_no + ", prod_title=" + prod_title + "]";
      }
   
}

      
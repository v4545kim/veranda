package com.veranda.product.vo;

public class Product {
   private int no; // 상품 번호
   private int user_no; // 회원 식별 번호
   private String title; // 상품 제목
   private String content; // 상품 내용
   private String date; // 상품 등록 날짜
   private int readhit; // 조회수
   private String image1; // 상품 사진 1
   private String image2; // 상품 사진 2
   private String image3; // 상품 사진 3
   private String image4; // 상품 사진 4
   private String image5; // 상품 사진 5
   private String image6; // 상품 사진 6
   private String image7; // 상품 사진 7
   private String image8; // 상품 사진 8
   private String image9; // 상품 사진 9
   private String image10; // 상품 사진 10
   private int state; // 상품 판매 상태(0 이면 거래 가능, 1이면 판매 완료)
   
   public Product() {
      // TODO Auto-generated constructor stub
   }

   public int getNo() {
      return no;
   }

   public void setNo(int no) {
      this.no = no;
   }

   public int getUser_no() {
      return user_no;
   }

   public void setUser_no(int user_no) {
      this.user_no = user_no;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public int getReadhit() {
      return readhit;
   }

   public void setReadhit(int readhit) {
      this.readhit = readhit;
   }

   public String getImage1() {
      return image1;
   }

   public void setImage1(String image1) {
      this.image1 = image1;
   }

   public String getImage2() {
      return image2;
   }

   public void setImage2(String image2) {
      this.image2 = image2;
   }

   public String getImage3() {
      return image3;
   }

   public void setImage3(String image3) {
      this.image3 = image3;
   }

   public String getImage4() {
      return image4;
   }

   public void setImage4(String image4) {
      this.image4 = image4;
   }

   public String getImage5() {
      return image5;
   }

   public void setImage5(String image5) {
      this.image5 = image5;
   }

   public String getImage6() {
      return image6;
   }

   public void setImage6(String image6) {
      this.image6 = image6;
   }

   public String getImage7() {
      return image7;
   }

   public void setImage7(String image7) {
      this.image7 = image7;
   }

   public String getImage8() {
      return image8;
   }

   public void setImage8(String image8) {
      this.image8 = image8;
   }

   public String getImage9() {
      return image9;
   }

   public void setImage9(String image9) {
      this.image9 = image9;
   }

   public String getImage10() {
      return image10;
   }

   public void setImage10(String image10) {
      this.image10 = image10;
   }

   public int getState() {
      return state;
   }

   public void setState(int state) {
      this.state = state;
   }

   @Override
   public String toString() {
      return "Product [no=" + no + ", user_no=" + user_no + ", title=" + title + ", content=" + content + ", date="
            + date + ", readhit=" + readhit + ", image1=" + image1 + ", image2=" + image2 + ", image3=" + image3
            + ", image4=" + image4 + ", image5=" + image5 + ", image6=" + image6 + ", image7=" + image7
            + ", image8=" + image8 + ", image9=" + image9 + ", image10=" + image10 + ", state=" + state + "]";
   }
   
   
   
   
}

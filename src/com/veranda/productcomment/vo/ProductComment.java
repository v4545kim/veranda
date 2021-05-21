package com.veranda.productcomment.vo;

public class ProductComment {
	private int no; // 상품 댓글 번호
	private int prod_no; // 상품 글 번호
	private int user_no; // 회원 식별 번호
	private String writer;
	private String content; // 댓글 내용
	private String date; // 댓글 등록 날짜
	
	public ProductComment() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getProd_no() {
		return prod_no;
	}

	public void setProd_no(int prod_no) {
		this.prod_no = prod_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
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
	
	
}

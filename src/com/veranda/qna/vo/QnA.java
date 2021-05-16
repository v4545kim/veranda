package com.veranda.qna.vo;

public class QnA {
	private int no; // Q&A 글 번호
	private int user_no; // 회원 식별 번호
	private String title; // 문의 제목
	private String content; // 문의 내용
	private String category; // Q&A 글 문의 유형
	private String date; // Q&A 글 등록 날짜
	
	public QnA() {
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}

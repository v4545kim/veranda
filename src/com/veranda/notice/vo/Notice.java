package com.veranda.notice.vo;

public class Notice {
	private int no; // 공지사항 글 번호
	private int user_no; // 회원 식별 번호
	private String title; // 공지사항 제목
	private String content; // 공지사항 내용
	private String date; // 공지사항 등록 날짜
	
	public Notice() {
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
	
	
}

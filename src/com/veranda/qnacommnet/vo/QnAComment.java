package com.veranda.qnacomment.vo;

public class QnAComment {
	private int no; // Q&A 댓글 번호
	private int qna_no; // Q&A 글 번호
	private int user_no; // 회원 식별 번호
	private String content; // 댓글 내용
	private String date; // 댓글 등록 날짜
	
	public QnAComment() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getQna_no() {
		return qna_no;
	}

	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
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

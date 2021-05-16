package com.veranda.communitycomment.vo;

public class CommunityComment {
	private int no; // 커뮤니티 댓글 번호
	private int com_no; // 커뮤니티 글 번호
	private int user_no; // 회원 식별 번호
	private String content; // 댓글 내용
	private String date; // 댓글 등록 날짜
	
	public CommunityComment() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCom_no() {
		return com_no;
	}

	public void setCom_no(int com_no) {
		this.com_no = com_no;
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

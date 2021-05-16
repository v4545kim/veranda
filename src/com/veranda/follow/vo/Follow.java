package com.veranda.follow.vo;

public class Follow {
	private int follower_no; // 팔로워
	private int followee_no; // 팔로이
	private int state; // 팔로우 상태(0이면 no follow, 1이면 follow)
	
	public Follow() {
		// TODO Auto-generated constructor stub
	}

	public int getFollower_no() {
		return follower_no;
	}

	public void setFollower_no(int follower_no) {
		this.follower_no = follower_no;
	}

	public int getFollowee_no() {
		return followee_no;
	}

	public void setFollowee_no(int followee_no) {
		this.followee_no = followee_no;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
}

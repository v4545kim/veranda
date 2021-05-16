package com.veranda.follow.dao;

import java.util.List;

import com.veranda.common.dao.SuperDao;
import com.veranda.follow.vo.Follow;

public class FollowDao extends SuperDao{
	public int InsertData(Follow bean) {
		return 0;
	}
	// 팔로우 취소는 다시 팔로우하는 경우를 생각해서 삭제가 아닌 업데이트를 해서 0으로 바꾼다.
	public int UpdateData(Follow bean) {
		return 0;
	}
	public List<Follow> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		return null;
	}
}

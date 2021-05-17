package com.veranda.member.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.veranda.common.dao.SuperDao;
import com.veranda.member.vo.Member;

public class MemberDao extends SuperDao {

	public int InsertData(Member bean) {
		return 0;
	}

	public int UpdateData(Member bean) {
		return 0;
	}

	public int DeleteData(String id) {
		return 0;
	}

	public List<Member> SelectDataList(int beginRow, int endRow) {
		return null;
	}

	public Member SelectDataByPk(String id) {
		return null;
	}

	public Member SelectData(String user_id, String user_pwd) {
		Member bean = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select * from members where user_id = ? and user_pwd = ? ";

		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pwd);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new Member();

				bean.setNo(Integer.parseInt(rs.getString("user_no")));
				bean.setUser_address(rs.getString("user_address"));
				bean.setUser_birth(rs.getString("user_birth"));
				bean.setUser_email(rs.getString("user_email"));
				bean.setUser_gender(rs.getString("user_gender"));
				bean.setUser_id(rs.getString("user_id"));
				bean.setUser_name(rs.getString("user_name"));
				bean.setUser_nickname(rs.getString("user_nickname"));
				bean.setUser_phone(rs.getString("user_phone"));
				bean.setUser_pwd(rs.getString("user_pwd"));
				bean.setUser_remark(String.valueOf(rs.getString("user_remark")));

				bean.setUser_address1(String.valueOf(rs.getString("user_address1")));
				bean.setUser_address_mark(String.valueOf(rs.getString("user_address_mark")));
				bean.setUser_postcode(Integer.parseInt(rs.getString("user_postcode")));

			}
		} catch (Exception e) {
			e.printStackTrace();
			bean = null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}
}
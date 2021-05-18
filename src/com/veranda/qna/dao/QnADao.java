package com.veranda.qna.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.veranda.common.dao.SuperDao;
import com.veranda.qna.vo.QnA;

public class QnADao extends SuperDao {
	public int InsertData(QnA bean) {
		String sql = " insert into qnas(user_no, qna_no, qna_title, qna_content, qna_category) ";
		sql += " values(?, qnaseq.nextval, ?, ?, ?) ";

		PreparedStatement pstmt = null;
		int cnt = -1;
		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			conn.setAutoCommit(false);
			pstmt = super.conn.prepareStatement(sql);

			pstmt.setInt(1, bean.getUser_no());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getContent());
			pstmt.setString(4, bean.getCategory());

			cnt = pstmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			SQLException err = (SQLException) e;
			cnt = -err.getErrorCode();
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
	}

	public int UpdateData(QnA bean) {
		String sql = " update qnas set qna_title=?, qna_content=?, qna_category=? ";
		sql += " where qna_no = ?";

		PreparedStatement pstmt = null;
		int cnt = -99999;
		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			conn.setAutoCommit(false);
			pstmt = super.conn.prepareStatement(sql);

			pstmt.setString(1, bean.getTitle());
			pstmt.setString(2, bean.getContent());
			pstmt.setString(3, bean.getCategory());
			pstmt.setInt(4, bean.getNo());

			cnt = pstmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			SQLException err = (SQLException) e;
			cnt = -err.getErrorCode();
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
	}

	public int DeleteData(int no) {
		String sql = " delete from qnas ";
		sql += " where qna_no = ? ";

		PreparedStatement pstmt = null;
		int cnt = -1;
		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			conn.setAutoCommit(false); // 커밋이 자동으로 되는 것을 막기위해
			pstmt = super.conn.prepareStatement(sql);

			pstmt.setInt(1, no);

			cnt = pstmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			SQLException err = (SQLException) e;
			cnt = -err.getErrorCode();
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
	}

	public QnA SelectDataByPk(int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select * from qnas";
		sql += " where qna_no = ?";

		QnA bean = null;
		try {
			if (this.conn == null) {
				this.conn = this.getConnection();
			}
			pstmt = this.conn.prepareStatement(sql);

			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new QnA();

				bean.setNo(rs.getInt("qna_no"));
				bean.setUser_no(rs.getInt("user_no"));

				bean.setTitle(rs.getString("qna_title"));
				bean.setContent(rs.getString("qna_content"));
				bean.setCategory(rs.getString("qna_category"));

				bean.setDate(String.valueOf(rs.getDate("qna_date")));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				this.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}

	public List<QnA> SelectDataList(int beginRow, int endRow, String mode, String keyword) {

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		String sql = "select ranking, user_no, qna_no, qna_title, qna_content, qna_category, qna_date ";
		sql += " from (select user_no, qna_no, qna_title, qna_content, qna_category, qna_date, ";
		sql += " rank() over(order by qna_no desc) as ranking ";
		sql += " from qnas ";

		if (mode.equalsIgnoreCase("all") == false) {
			System.out.println("not all search mode");
			sql += " where " + mode + " like '%" + keyword + "%' ";
		}

		sql += " ) where ranking between ? and ? ";

		List<QnA> lists = new ArrayList<QnA>();
		try {
			if (this.conn == null) {
				this.conn = this.getConnection();
			}

			pstmt = this.conn.prepareStatement(sql);

			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				QnA bean = new QnA();

				bean.setUser_no(rs.getInt("user_no"));
				bean.setNo(rs.getInt("qna_no"));
				bean.setTitle(rs.getString("qna_title"));
				bean.setContent(rs.getString("qna_content"));
				bean.setCategory(rs.getString("qna_category"));
				bean.setDate(rs.getString("qna_date"));

				lists.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				this.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		System.out.println("QnA 게시판 리스트 전달 성공");
		return lists;
	}

	public int SelectTotalCount(String mode, String keyword) {

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		String sql = " select count(*) as cnt from qnas";
		if (mode.equalsIgnoreCase("all") == false) {
			System.out.println("not all search mode");
			sql += " where " + mode + " like '%" + keyword + "%' ";
		}

		int cnt = 0;
		try {
			if (this.conn == null) {
				this.conn = this.getConnection();
			}
			pstmt = this.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				this.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
	}

	public String SelectWriter(int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select user_nickname ";
		sql += " from members m inner join qnas q ";
		sql += " on m.user_no = q.user_no ";
		sql += " where q.qna_no = ?";

		String writer = null;

		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);

			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {

				writer = rs.getString("user_nickname");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return writer;
	}

}

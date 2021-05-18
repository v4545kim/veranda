package com.veranda.qnacomment.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.veranda.common.dao.SuperDao;
import com.veranda.qnacomment.vo.QnAComment;

public class QnACommentDao extends SuperDao{

	public int InsertData(QnAComment bean) {
		String sql = " insert into qna_comments(qna_comm_no, qna_no, user_no, qna_content ) ";
		sql += " values(qna_commseq.nextval, ?, ?, ?) ";

		PreparedStatement pstmt = null;
		int cnt = -1;
		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			conn.setAutoCommit(false);
			pstmt = super.conn.prepareStatement(sql);

			pstmt.setInt(1, bean.getNo());
			pstmt.setInt(2, bean.getUser_no());
			pstmt.setString(3, bean.getContent());

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
	
	public int UpdateData(QnAComment bean) {
		return 0;
	}
	
	public int DeleteData( int no ){
		String sql = " delete from qna_comments ";
		sql += " where qna_comm_no = ? ";

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
	
	public List<QnAComment> SelectDataList(int beginRow, int endRow, String mode, String keyword, int no) {
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		String sql = " select ranking, qna_comm_no, qna_no, user_no, qna_date, qna_content ";
		sql += " from (select qna_comm_no, qna_no, user_no, qna_date, qna_content, ";
		sql += " rank() over(order by qna_comm_no desc) as ranking ";
		sql += " from qna_comments";
		
		if(mode.equalsIgnoreCase("all") == false) {
			System.out.println("not all search mode");
			sql += "where " + mode + " like '%" + keyword + "%' ";
		}
		
		sql += " ) where ranking between ? and ? and qna_no = ?" ;

		List<QnAComment> lists = new ArrayList<QnAComment>();
		try {
			if(this.conn == null) {
				this.conn = this.getConnection();
			}
			
			pstmt = this.conn.prepareStatement(sql);
			
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, no);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnAComment bean = new QnAComment();
				
				bean.setQna_no(rs.getInt("qna_comm_no"));
				bean.setNo(rs.getInt("qna_no"));
				bean.setUser_no(rs.getInt("user_no"));
				bean.setDate(rs.getString("qna_date"));
				bean.setContent(rs.getString("qna_content"));
				
				lists.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				this.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("QnA 게시판 댓글 리스트 전달 성공");
		return lists;
	}

	public int SelectTotalCount(String mode, String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<QnAComment> SelectData(int no) {
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		String sql = " select user_nickname, qna_comm_no, qna_no, m.user_no as user_no, qna_content, qna_date ";
		sql += " from members m inner join qna_comments q  ";
		sql += " on m.user_no = q.user_no ";
		sql += " where qna_no = ? ";
		sql += " order by qna_comm_no asc ";

		List<QnAComment> cowriter = new ArrayList<QnAComment>();
		
		try {
			if(this.conn == null) {
				this.conn = this.getConnection();
			}
			
			pstmt = this.conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				QnAComment bean = new QnAComment();
				
				bean.setWriter(rs.getString("user_nickname"));
				bean.setQna_no(rs.getInt("qna_comm_no"));
				bean.setNo(rs.getInt("qna_no"));
				bean.setUser_no(rs.getInt("user_no"));
				bean.setContent(rs.getString("qna_content"));
				bean.setDate(rs.getString("qna_date"));
				
				cowriter.add(bean);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				this.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("QnA 게시판 댓글 작성자 전달 성공");
		
		return cowriter;		
	}
	
	
}

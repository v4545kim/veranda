package com.veranda.qnacomment.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.veranda.common.dao.SuperDao;
import com.veranda.qna.vo.QnA;
import com.veranda.qnacomment.vo.QnAComment;

public class QnACommentDao extends SuperDao{

	public int InsertData(QnAComment bean) {
		return 0;
	}
	
	public int UpdateData(QnAComment bean) {
		return 0;
	}
	
	public int DeleteData( int no ){
		return 0;
	}
	
	public List<QnAComment> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		String sql = "select ranking, qna_no, qna_title, qna_category, qna_date ";
		sql += " from (select qna_no, qna_title, qna_category, qna_date, ";
		sql += " rank() over(order by qna_no desc) as ranking ";
		sql += " from qnas";
		
		if(mode.equalsIgnoreCase("all") == false) {
			System.out.println("not all search mode");
			sql += "where " + mode + " like '%" + keyword + "%' ";
		}
		
		sql += " ) where ranking between ? and ? " ;

		List<QnAComment> lists = new ArrayList<QnAComment>();
		try {
			if(this.conn == null) {
				this.conn = this.getConnection();
			}
			
			pstmt = this.conn.prepareStatement(sql);
			
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);
			
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
	
	
	
	
}

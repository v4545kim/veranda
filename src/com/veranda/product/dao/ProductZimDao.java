package com.veranda.product.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.veranda.common.dao.SuperDao;
import com.veranda.product.vo.ProductZim;

public class ProductZimDao extends SuperDao {

	public int InsertData(ProductZimDao bean) {
		String sql = " insert into product_zim(prod_no, user_no) ";
		sql += "values(?,?) ";

		PreparedStatement pstmt = null;
		int cnt = -1;
		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			conn.setAutoCommit(false);
			pstmt = super.conn.prepareStatement(sql);

			pstmt.setInt(1, bean.getProd_no());
			pstmt.setInt(2, bean.getUser_no());

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

	private int getUser_no() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getProd_no() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int SelectTotalCount(String mode, String keyword) {
		return 0;

	}

	public List<ProductZim> getList(int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ProductZim bean = null;

		String sql = " select p.prod_no as prod_no, p.prod_title as prod_title, m.user_no as user_no "
				+ " from (members m join products p on m.user_no=p.user_no) "
				+ " join product_zim pz on p.prod_no=pz.prod_no " + " where pz.user_no = ? ";

		List<ProductZim> ProductZims = new ArrayList<ProductZim>();

		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);

			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new ProductZim();
				bean.setProd_no(rs.getInt("prod_no"));
				bean.setProd_title(rs.getString("prod_title"));
				bean.setUser_no(rs.getInt("user_no"));

				ProductZims.add(bean);

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
		return ProductZims;
	}

	public int insertzim(int prod_no, int user_no) {
		String sql = " insert into product_zim(prod_no, user_no) ";
		sql += "values(?, ?) ";

		PreparedStatement pstmt = null;
		int cnt = -1;
		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			conn.setAutoCommit(false);
			pstmt = super.conn.prepareStatement(sql);

			pstmt.setInt(1, prod_no);
			pstmt.setInt(2, user_no);

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

	public int SelectTotalZimCount(String mode, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select count(*) as cnt from product_Zim ";
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

	public List<ProductZim> SelectZimDataList(int beginRow, int endRow, int user_no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " select ranking prod_no, prod_title, user_no ";
		sql += " from( select p.prod_no as prod_no, p.prod_title as prod_title, m.user_no as user_no,  ";
		sql += " rank() over(order by m.user_no asc) as ranking ";
		sql += " from (members m join products p on m.user_no=p.user_no) ";
		sql += " join product_zim pz on p.prod_no=pz.prod_no ";
		sql += " where pz.user_no = ?) ";
		sql += " where ranking between ? and ?";

		List<ProductZim> lists = new ArrayList<ProductZim>();

		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			pstmt = super.conn.prepareStatement(sql);

			pstmt.setInt(1, user_no);
			pstmt.setInt(2, beginRow);
			pstmt.setInt(3, endRow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductZim bean = new ProductZim();

				bean.setProd_no(rs.getInt("prod_no"));
				bean.setUser_no(rs.getInt("user_no"));
				bean.setProd_title(rs.getString("prod_title"));

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
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return lists;
	}
}
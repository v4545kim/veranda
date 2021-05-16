package com.veranda.common.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SuperDao {
	protected Connection conn = null;
 	private String driver = "oracle.jdbc.driver.OracleDriver";
 	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
 	private String id = "dreamadm";
 	private String password = "oracle";
	
	protected Connection getConnection() {		
		try {			 
			return DriverManager.getConnection(url, id, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}	
	public void closeConnection(){
		conn = null ;
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
	}	
	public SuperDao() {
		try {
			Class.forName(driver);
			this.conn = getConnection();
			if (conn != null) {
				System.out.println("DB 접속에 성공 하였습니다!");
			} else {
				System.out.println("DB 접속에 실패 하였습니다!");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("class를 찾을 수 없습니다!");
			e.printStackTrace();
		}	
	}
}

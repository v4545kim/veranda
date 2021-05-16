package com.veranda.common.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SuperDaoMaria {
	protected Connection conn = null;
 	private String driver = "org.mariadb.jdbc.Driver";
 	private String url = "jdbc:mariadb://58.232.163.150:31701/veranda";
 	private String id = "dreamadm";
 	private String password = "imsi00.!";
	
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
	public SuperDaoMaria() {
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

package com.member.lib.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector1 {
	private static final String URL = "jdbc:oracle:@localhost:1521:xe";
	private static final String ID = "c##test";
	private static final String PWD = "test";
	private static final String MEMBER_CLASS = "jdbc.oracle.Driver.OracleDriver";
	
	static {
		try {
			Class.forName(MEMBER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection pluu() {
		try {
			DriverManager.getConnection(URL,ID,PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		Connection con = pluu();
		
		try {
			Statement stm = con.createStatement();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}

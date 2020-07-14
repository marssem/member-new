package com.member.lib.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Connector {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe"; //상수 갑임을 알게하게 위해서 변수는 대문자.
	private static final String ID = "c##test";
	private static final String PWD = "test";
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	static {
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("로드잘됨!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public static Connection open() {
		try {
			return DriverManager.getConnection(URL,ID,PWD);//캐치에서 아무것도 리턴하지 않기 때문에 리턴에 널을 넣어준다.
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;//널이 나오면 리턴에 잘 안 된 것이다.
	}
	public static void main(String[] args) {
		Connection con = open();
			try {
				
			Statement stmt = con.createStatement();
			String sql = "select l_num, l_lentdate, m_num, b_num from lent ";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt("l_num"));
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
}

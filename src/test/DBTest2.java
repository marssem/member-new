package test;

import java.sql.*;

public class DBTest2{
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##test","test");
			String sql = "select num, name, etc from user_info";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt("num")+","+rs.getString("name")+","+rs.getString("etc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBTest3 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##test","test");
			String sql = "insert into user_info(num, name, etc)";
			sql += " values(?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,1);
			ps.setString(2, "이름");
			ps.setString(3, "내용");
			ps.executeUpdate();
			sql = "update user_info";
			sql += " set name=?,";
			sql += " etc=?";
			sql += " where num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "이거");
			ps.setString(2, "비고");
			ps.setInt(3, 1);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

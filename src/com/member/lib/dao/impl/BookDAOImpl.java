package com.member.lib.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.common.Connector;
import com.member.lib.dao.BookDAO;

public class BookDAOImpl implements BookDAO {

	public int insertBook(Map<String, Object> Book) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "insert into Book(b_num, b_title, b_author, b_credat, b_dmc)";
			sql += " values(seq_Book_b_num.nextval,?,?,sysdate,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, Book.get("b_title").toString());// get에 널을 넣을 시 이곳에 가져올 값이 없음으로 에러.
			ps.setString(2, Book.get("b_author").toString());//
			ps.setString(3, Book.get("b_dmc").toString());
			result = ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int updateBook(Map<String, Object> Book) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "update Book";
			sql += " set b_title=?,";
			sql += " b_author=?,";
			sql += " b_dmc=?";
			sql += " where b_num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, Book.get("b_title").toString());
			ps.setString(2, Book.get("b_author").toString());
			ps.setString(3, Book.get("b_dmc").toString());
			ps.setInt(4, (int)Book.get("b_num"));
			result = ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int deleteBook(int bNum) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "delete from Book where b_num=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bNum);
			result = ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<Map<String, Object>> selectBookList(Map<String, Object> Book) {// 여러 건들을 받는다.
		List<Map<String, Object>> bookList = new ArrayList<Map<String, Object>>();
		Connection con = null;
		con = Connector.open();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select b_num, b_title, b_author, b_credat, b_dmc from Book";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("b_num", rs.getInt("b_num"));
				map.put("b_title", rs.getString("b_title"));
				map.put("b_author", rs.getString("b_author"));
				map.put("b_credat", rs.getString("b_credat"));
				map.put("b_dmc", rs.getString("b_dmc"));
				bookList.add(map);
			}
			int result = 0;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bookList;

	}

	public Map<String, Object> selectBook(int bNum) {// 단건만 받는다.

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "select b_num, b_title, b_author, b_credat, b_dmc from Book where b_num=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bNum);
			rs = ps.executeQuery();
			if (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("b_num", rs.getInt("b_num"));
				map.put("b_title", rs.getString("b_title"));
				map.put("b_author", rs.getString("b_author"));
				map.put("b_credat", rs.getString("b_credat"));
				map.put("b_dmc", rs.getString("b_dmc"));
				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void main(String[] args) {
		BookDAO bdao = new BookDAOImpl();
		Map<String, Object> map = new HashMap<>();
		map.put("b_title", "자바의정석");
		map.put("b_author", "남궁성");
		map.put("b_dmc", "광고 오진다.");
		bdao.insertBook(map);
		 List<Map<String,Object>> bookList = bdao.selectBookList(map); 
	//	System.out.println(bdao.selectBook(bNum));
	/*	int result = bdao.deleteBook(22);
		System.out.println("삭제 갯수 : " +result); */
	//	map.put("b_num", 2);
	//	int result = bdao.updateBook(map);
	//	System.out.println("수정 갯수 :" + result);
	}
}

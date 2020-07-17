package com.member.lib.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.common.Connector;
import com.member.lib.dao.LentDAO;

public class LentDAOImpl implements LentDAO {

	 
	public int insertLent(Map<String, Object> Lent) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "insert into Lent(l_num, l_lentdate, m_num, b_num ) ";
			sql += "values(seq_Lent_l_num.nextval, sysdate, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, Lent.get("m_num").toString());
			ps.setString(2, Lent.get("b_num").toString());
			result = ps.executeUpdate();
			con.commit();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	 
	public int updateLent(Map<String, Object> Lent) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "update Lent ";
			sql += " set l_num=sysdate,";
			sql += " m_num=?,";
			sql += " b_num=?";
			sql += " where l_num=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, (int)(Lent.get("m_num")));
			ps.setInt(2, (int)(Lent.get("b_num")));
			ps.setInt(3, (int)(Lent.get("l_num")));
			result = ps.executeUpdate();
			con.commit();
		return 0;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	 
	public int deleteLent(int lNum) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "delete from Lent where l_num=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, lNum);
			result = ps.executeUpdate();
			con.rollback();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	 
	public List<Map<String, Object>> selectLentList(Map<String, Object> Lent) {
		List<Map<String, Object>> LentList = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = Connector.open();
			String sql = "select l_num, l_lentdate, l_recdate, m_num, b_num from lent ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("l_num", rs.getInt("l_num"));
				map.put("l_lentdate", rs.getString("l_lentdate"));
				map.put("l_recdate", rs.getString("l_recdate"));
				map.put("m_num", rs.getString("m_num"));
				map.put("b_num", rs.getString("b_num"));
				LentList.add(map);

			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(ps!=null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return LentList;
	}

	 
	public Map<String, Object> selectLent(int lNum) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = Connector.open();
		String sql = "select l_num, l_lentdate, l_recdate, m_num, b_num from lent where l_num=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, lNum);
		if(rs.next()) {
			Map<String, Object> map = new HashMap<>();
			map.put("l_num", rs.getInt("l_num"));
			map.put("l_lentdate", rs.getString("l_lentdate"));
			map.put("l_recdate", rs.getString("l_recdate"));
			map.put("m_num", rs.getString("m_num"));
			map.put("b_num", rs.getString("b_num"));
			return map;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null) rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(ps!=null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static void main(String[] args) {
		LentDAOImpl mdao = new LentDAOImpl();
		Map<String, Object> map = new HashMap<>();
//		map.put("m_name", "박숙제");
//		map.put("m_id", "나도숙제다");	
//		mdao.insertLent(map);
		
		//	List<Map<String, Object>> LentList = mdao.selectLentList(map);
			
			System.out.println(mdao.selectLent(2));
			
		//	int result = mdao.deleteLent(2);
		// 	System.out.println("삭제 갯 수 : "+result);
		
		//	map.put("l_num", 2);
		//	int result = mdao.updateLent(map);
		//	System.out.println("수정 갯수 :" + result);
	}
}

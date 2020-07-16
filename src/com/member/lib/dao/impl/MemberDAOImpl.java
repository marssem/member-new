package com.member.lib.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.common.Connector;
import com.member.lib.dao.MemberDAO;

public class MemberDAOImpl implements MemberDAO {

	 
	public int insertMember(Map<String, Object> Member) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "insert into Member(m_num, m_name, m_id, m_pwd, m_joindate ) ";
			sql += "values(seq_Member_m_num.nextval, ?, ?, ?, sysdate)";
			ps = con.prepareStatement(sql);
			ps.setString(1, Member.get("m_name").toString());
			ps.setString(2, Member.get("m_id").toString());
			ps.setString(3, Member.get("m_pwd").toString());
			result = ps.executeUpdate();
			con.commit();
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
		
		return result;
	}

	 
	public int updateMember(Map<String, Object> Member) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "update Member ";
			sql += " set m_name=?,";
			sql += " m_id=?,";
			sql += " m_pwd=?";
			sql += " where m_num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, Member.get("m_name").toString());
			ps.setString(2, Member.get("m_id").toString());
			ps.setString(3, Member.get("m_pwd").toString());
			ps.setInt(4, (int)(Member.get("m_num")));
			result = ps.executeUpdate();
		
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

	 
	public int deleteMember(int mNum) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "delete from Member where m_num=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, mNum);
			result = ps.executeUpdate();
			con.commit();
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

	 
	public List<Map<String, Object>> selectMemberList(Map<String, Object> Member) {
		List<Map<String, Object>> memberList = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = Connector.open();
			String sql = "select m_num, m_name, m_id, m_pwd, m_joindate from Member ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("m_num",rs.getInt("m_num"));
				map.put("m_name",rs.getString("m_name").toString());
				map.put("m_id",rs.getString("m_id").toString());
				map.put("m_pwd",rs.getString("m_pwd").toString());
				map.put("m_joindate",rs.getString("m_joindate").toString());
				memberList.add(map);

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
		return memberList;
	}

	 
	public Map<String, Object> selectMember(int mNum) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = Connector.open();
		String sql = "select m_num, m_name, m_id, m_pwd, m_joindate from Member where m_num=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, mNum);
		rs = ps.executeQuery();
		if(rs.next()) {
			Map<String, Object> map = new HashMap<>();
			map.put("m_num",rs.getInt("m_num"));
			map.put("m_name",rs.getString("m_name"));
			map.put("m_id",rs.getString("m_id"));
			map.put("m_pwd",rs.getString("m_pwd"));
			map.put("m_joindate",rs.getString("m_joindate"));
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
		MemberDAOImpl mdao = new MemberDAOImpl();
		Map<String, Object> map = new HashMap<>();
		map.put("m_name", "이름");
		map.put("m_id", "아이디");	
		map.put("m_pwd", "비밀");
//		mdao.insertMember(map);
		
		//	List<Map<String, Object>> memberList = mdao.selectMemberList(map);
			
		//	System.out.println(mdao.selectMemvber(2));
			
			int result = mdao.deleteMember(2);
			System.out.println("삭제 갯 수 : "+result);
		
		//	map.put("m_num", 2);
		//	int result = mdao.updateMember(map);
		//	System.out.println("수정 갯수 :" + result);
	}
}
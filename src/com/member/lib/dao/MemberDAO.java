package com.member.lib.dao;

import java.util.List;
import java.util.Map;

public interface MemberDAO {
	int insertMember(Map<String, Object> Member);
	int updateMember(Map<String, Object> Member);
	int deleteMember(int mNum);
	List<Map<String, Object>> selectMemberList(Map<String, Object> Member);
	Map<String, Object> selectMember(int mNum);
}

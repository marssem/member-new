package com.member.lib.service;

import java.util.List;
import java.util.Map;

public interface MemberService {
	Map<String, Object> insertMember(Map<String, Object> Member);
	Map<String, Object> updateMember(Map<String, Object> Member);
	Map<String, Object> deleteMember(int mNum);
	List<Map<String, Object>> selectMemberList(Map<String, Object> Member);
	Map<String, Object> selectMember(int mNum);
}

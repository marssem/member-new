package com.member.lib.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.LentDAO;
import com.member.lib.dao.impl.LentDAOImpl;
import com.member.lib.service.LentService;

public class LentServiceImpl implements LentService {

	 private LentDAO lentDAO = new LentDAOImpl();
	public Map<String, Object> insertLent(Map<String, Object> lent) {
		 Map<String, Object> rMap = new HashMap<>();
		 int result = lentDAO.insertLent(lent);
		 rMap.put("msg", result==1?"대여 입력완료":"대여 입력 실패");
		 return rMap;
	}
	public Map<String, Object> updateLent(Map<String, Object> lent) {
		 Map<String, Object> rMap= new HashMap<>();
		 int result = lentDAO.insertLent(lent);
		 rMap.put("msg",  result==1?"갱신완료":"갱신 실패");
		return rMap;
	}
	public Map<String, Object> deleteLent(int lNum) {
		 Map<String, Object> rMap = new HashMap<>();
		 int result = lentDAO.deleteLent(lNum);
		 rMap.put("msg", result==1?"삭제 완료":"삭제 실패");
		return rMap;
	}
	public List<Map<String, Object>> selectLentList(Map<String, Object> lent) {		 
		return lentDAO.selectLentList(lent);
	}
	public Map<String, Object> selectLent(int lNum) {
		return lentDAO.selectLent(lNum);
	}
	@Override
	public List<Map<String, Object>> selectNoLentBookList() {
		return lentDAO.selectNoLentBookList();
	}


}

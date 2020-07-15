package com.member.lib.dao;

import java.util.List;
import java.util.Map;

public interface BookDAO {
	
	int insertBook(Map<String,Object> Book);
	int updateBook(Map<String,Object> Book);
	int deleteBook(int bNum);
	List<Map<String,Object>> selectBookList(Map<String,Object> Book);
	Map<String,Object> selectBook(int bNum);
}

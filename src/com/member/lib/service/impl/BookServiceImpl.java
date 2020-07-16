package com.member.lib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.BookDAO;
import com.member.lib.dao.impl.BookDAOImpl;
import com.member.lib.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDAO bookDAO = new BookDAOImpl();
	public Map<String, Object> insertBook(Map<String, Object> Book) {
		Map<String, Object> rMap = new HashMap<>();
		int result = bookDAO.insertBook(Book);
		rMap.put("msg", (result==1)?"도서입력 성공~":"도서입력 실패");
		rMap.put("cnt", result);
		return rMap;
	}

	 
	public Map<String, Object> updateBook(Map<String, Object> Book) {
		int result = bookDAO.updateBook(Book);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", (result==1)?"도서갱신 성공~":"도서갱신 실패");
		rMap.put("cnt", result);
		return rMap;
	}

	 
	public Map<String, Object> deleteBook(int bNum) {
		 int result = bookDAO.deleteBook(bNum);
		 Map<String, Object> rMap = new HashMap<>();
		 rMap.put("msg", (result==1)?"도서 목록 삭제 성공~":"도서 목록 삭제 실패");
		rMap.put("cnt", result);
		return rMap;
	}

	 
	public List<Map<String, Object>> selectBookList(Map<String, Object> Book) {
		return bookDAO.selectBookList(Book);
	}

	 
	public Map<String, Object> selectBook(int bNum) {
		return bookDAO.selectBook(bNum);
	}
	public static void main(String[] args) {
		BookService bookService = new BookServiceImpl();
		Map<String, Object> map = new HashMap<>();
		map.put("b_title", "컴퓨터능력");
		map.put("b_author", "견품");
		map.put("b_dmc", "시험");
//		System.out.println(bookService.insertBook(map));
		
		map.put("b_num", 81);
//		System.out.println(bookService.updateBook(map));
		
//		System.out.println(bookService.deleteBook(81));
		
//		System.out.println(bookService.selectBookList(map));
		System.out.println(bookService.selectBook(22));
		
	}
}

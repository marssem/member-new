package com.member.lib.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.lib.service.LentService;
import com.member.lib.service.impl.LentServiceImpl;

public class LentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LentService lentService = new LentServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if("/lent/insert".equals(uri)) {
			request.setAttribute("bookList", lentService.selectNoLentBookList());
			RequestDispatcher rd = request.getRequestDispatcher("/views/lent/lent-insert");
			rd.forward(request, response);
		}else if("/lent/lent-list".equals(uri)) {
			List<Map<String,Object>> lentList = lentService.selectLentList(null);
			request.setAttribute("lentList", lentList);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/lent/lent-list");
			requestDispatcher.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if("/lent/insert".equals(uri)) {
			String bNum = request.getParameter("b_num");
			String mNum = request.getParameter("m_num");
			Map<String, Object> lent = new HashMap<>();
			lent.put("b_num", bNum);
			lent.put("m_num", mNum);
			System.out.println(lentService.insertLent(lent));
			System.out.println(bNum+", "+mNum);
		}
	}
}

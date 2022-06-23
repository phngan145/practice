package com.kits.ngan.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kits.ngan.entity.BlogUser;
import com.kits.ngan.service.BlogWebService;

@WebServlet("/user/list")
public class ListUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		List<BlogUser> listUser = new ArrayList<BlogUser>();
		
		BlogWebService blogWebService = new BlogWebService();
		
		listUser = blogWebService.getAllUser();
		
		req.setAttribute("listUser", listUser);
		req.getRequestDispatcher("/WEB-INF/views/user/list.jsp").forward(req, resp);
		
	}

}

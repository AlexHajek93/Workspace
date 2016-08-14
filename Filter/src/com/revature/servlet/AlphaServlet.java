package com.revature.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.bean.User;

public class AlphaServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		User dan = new User("dan","pickles","IT");
		User howard = new User("howard","johnson","HR");
		Map<String, User> map = new HashMap<String,User>();
		map.put("dan", dan);
		map.put("howard", howard);
		this.getServletContext().setAttribute("users", map);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getRequestURI()){
		case "/Filter/login.do":
			String user = req.getParameter("user");
			String pass = req.getParameter("pass");
			Map<String, User> userList = (Map<String,User>) this.getServletContext().getAttribute("user");
			if(userList != null && userList.get(user) != null){
				User toAuthenticate = userList.get(user);
				if(toAuthenticate.getPassword().equals(pass)){
					req.getSession().setAttribute("loggedIn", toAuthenticate);
					resp.sendRedirect("home.jsp");
				}
			}else if(userList == null){
				req.setAttribute("loginFial", "Server Failed...");
			}else{
				req.setAttribute("loginFail", "Login failed. try again");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
			break;
		case "/Filter/logout.do":
			req.getSession().invalidate();
			resp.sendRedirect("login.jsp");
			break;
		default: throw new IllegalArgumentException("Invalid URI");
		}
	}	
}

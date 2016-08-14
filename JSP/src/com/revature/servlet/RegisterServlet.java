//Check gitlab later

package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.UserBean;

public class RegisterServlet extends HttpServlet{
	
	
	
	@Override
	public void init() throws ServletException {
		//a whole lot more than <init-param>
		System.err.println("calling init() method");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Get form parameters and store in JavaBean
		String initparam = this.getServletContext().getInitParameter("hostname");
		String contextparam = this.getServletConfig().getInitParameter("databaseServer");
		System.out.println("Servlet running on " + initparam + " is connected to server: " +contextparam);
		UserBean bean = new UserBean(
				req.getParameter("fullname"),
				req.getParameter("email"),
				Integer.parseInt(req.getParameter("age")),
				req.getParameter("user"),
				req.getParameter("pass")
				);
		//save in HttpSession
		req.getSession().setAttribute("userdata", bean);
		req.setAttribute("requestScopedVariable", "Testing Request Scope");
		req.getRequestDispatcher("confirm.jsp").forward(req, resp);
		//OR
		//resp.sendRedirect("confirm.jsp");
	}
	
}

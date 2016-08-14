package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.UserBean;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// service Get requests
		this.doPost(req, resp);
//		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// service Post requests
		String username = req.getParameter("user");
		String password = req.getParameter("pass");
		boolean auth = this.login(username, password);
		if(auth){
			//goto home page
			//90's/00's version
			PrintWriter out = resp.getWriter();
			resp.setStatus(resp.SC_OK);
			UserBean bean = new UserBean(username,password);
			req.getSession().setAttribute("data", bean);
//			out.println("<html><body>Welcome to my site," + username +"</body></html>");
			boolean returningUser = false;
			Cookie[] cookiejar = req.getCookies();
			for (Cookie c :cookiejar){
				if(c.getName().equals("key"))
					returningUser = true;
			}
			if(returningUser){
				req.setAttribute("welcome", "Welcome back to my site, "+username);
			}
			else{
				Cookie cookie = new Cookie("key","cookie value");
				cookie.setMaxAge(60*60*24*365*1000);
				resp.addCookie(cookie);//Store cookie on PC
				req.setAttribute("welcome", "Welcome to my site, "+username);
			}
			req.getRequestDispatcher("home.jsp").forward(req, resp);//forwards data too
		}else{
			//send to login
			resp.sendRedirect("index.html");
		}
//		super.doPost(req, resp);
	}
	
	private boolean login(String user,String pass){
		if(user.equals("dan")&&pass.equals("pickles"))
			return true;
		return false;
	}
}

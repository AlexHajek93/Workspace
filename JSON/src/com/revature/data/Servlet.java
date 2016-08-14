package com.revature.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getRequestURI()){
		case "/JSON/ajax/get":{
			int id = Integer.parseInt(req.getParameter("query"));
			Trainee obj = new DAO().getById(id);
			String json = new JSONConverter().getTraineeJSON(obj);
			resp.getWriter().println(json);
			break;
		}
		case "/JSON/ajax/getall":{
			int id = Integer.parseInt(req.getParameter("query"));
			Trainee obj = new DAO().getById(id);
			String json = new JSONConverter().getTraineeJSON(obj);
			resp.getWriter().println(json);
			break;
		}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getRequestURI().equals("/JSON/ajax/post")){
			BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
			String json="";
			if(reader != null)
				json=reader.readLine();
			Trainee obj = new JSONConverter().getTraineeJSON(json);
			new DAO().insert(obj);
		}
	}
	
}

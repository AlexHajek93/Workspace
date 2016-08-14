package com.revature.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Skill;
import com.revature.beans.Trainee;

public class TraineeServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		Map<String, Skill> devSkills = new HashMap<String,Skill>();
		devSkills.put("j2ee",new Skill(1, "J2EE", (short)12, new String[]{"Patrick","Steve","Taylor","August"}));
		devSkills.put("net",new Skill(2, ".Net", (short)-12, new String[]{"Joe","Fred"}));
		devSkills.put("sdet",new Skill(3, "SDET", (short)7, new String[]{"Yuvi","Ryan","Patrick"}));
		devSkills.put("bpm",new Skill(4, "Appian", (short)5, new String[]{"James"}));
		devSkills.put("devops",new Skill(5, "DevOps", (short)9, new String[]{"Patrick","Joe","Fred","Yuvi"}));
		this.getServletContext().setAttribute("skills", devSkills);
		this.getServletContext().setAttribute("traineeList", new ArrayList<Trainee>());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String major = req.getParameter("major");
		Double salary = Double.parseDouble(req.getParameter("salary"));
		String skillType = req.getParameter("skill");
		Map<String,Skill> appScopeVar = (HashMap<String,Skill>) req.getServletContext().getAttribute("skills");
		Trainee obj = new Trainee(id,name,major,salary,appScopeVar.get(skillType));
		List<Trainee> list = (ArrayList<Trainee>) req.getServletContext().getAttribute("traineeList");
		list.add(obj); //'insert' trainee into app scope
		resp.sendRedirect("trainees.jsp");
	}
	
}

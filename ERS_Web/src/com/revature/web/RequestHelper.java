package com.revature.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.app.DataService;
import com.revature.beans.HelloBean;

public class RequestHelper {
	public String process(HttpServletRequest req, HttpServletResponse resp){
		switch(req.getRequestURI()){
		case "/ERS_Web/hello.do": 
			//1 . Input validate
			String message = req.getParameter("hello");
			if(validateHelloForm(req,message)==false)
				return "/ERS_Web/home.jsp";
			//2. Beanify
			HelloBean model = new HelloBean(message);
			//3. Call business logic
			new DataService().saveHelloBean(model);
			//4. Persist info
			req.getSession().setAttribute("hello", model);
			return "hello.jsp";
		case "/ERS_Web/goodbye.do": 
			
			return "goodbye.jsp";
		default: 
			
			throw new IllegalArgumentException("Not a valid URI");
		}
	}
	
	private boolean validateHelloForm(HttpServletRequest req, String field1){
		if(field1.length()>100){
			req.setAttribute("error",new IllegalArgumentException("Message too Long"));
			return false;
		}
		return true;
	}
}

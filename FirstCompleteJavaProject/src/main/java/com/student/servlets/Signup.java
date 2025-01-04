package com.student.servlets;

import java.io.IOException; 

import java.io.PrintWriter; 
import com.student.dao.StudentDAO; 
import com.student.dao.StudentDAOImp; 
import com.student.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
@WebServlet("/signup")

public class Signup extends HttpServlet {
	@Override 
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException { 
	
		//collect the data from user
	String name=req.getParameter("name"); 
	String phonenumber=req.getParameter("phone"); 
	String mailId=req.getParameter("mail"); 
	String branch=req.getParameter("branch"); 
	String loc=req.getParameter("loc"); 
	String password=req.getParameter("password"); 
	String confirmPassword=req.getParameter("confirm"); 
	
	//converting the necessary datatypes
	 long phone=Long.parseLong(phonenumber); 
	PrintWriter out=resp.getWriter(); 
	
	//JDBC Implementation
	 Student s=new Student();  
	StudentDAO sdao=new StudentDAOImp(); 
	if(password.equals(confirmPassword)) 
	{ 
		   s.setName(name); 
		   s.setPhone(phone); 
		   s.setMail(mailId); 
		   s.setBranch(branch); 
		   s.setLocation(loc); 
		   s.setPass(password); 
		   boolean result=sdao.insertStudent(s); 
		   if(result) 
		   { 
//		    s=sdao.getStudent(mailId, confirmPassword); 
//		    out.println("<h1>Data added successfully. Your Student ID is "+s.getId()+"</h1>");
			req.setAttribute("success", "Signup Successful");
			RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
			rd.forward(req, resp);
		   } 
		   else 
		   { 
//		    out.println("<h1>Failed to add the data</h1>"); 
			req.setAttribute("failure", "Failed to signup");
			RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
			rd.forward(req, resp);
		   } 
		  }  
		 } 
	}



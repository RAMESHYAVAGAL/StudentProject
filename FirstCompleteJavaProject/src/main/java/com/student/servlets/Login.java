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
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//collect the data from user
		 
		
		//creating the session object
		HttpSession session=req.getSession();
		
		
		
		String mailId=req.getParameter("mail"); 
		String password=req.getParameter("password"); 
     	PrintWriter out=resp.getWriter();
		
		
		//JDBC Implementation
		Student s=new Student();  
		StudentDAO sdao=new StudentDAOImp(); 
		s.setMail(mailId);
		s.setPass(password);
		s=sdao.getStudent(mailId, password);
		
		
			   if(s!=null&&mailId.equals(s.getMail()) && password.equals(s.getPass())){
//			   out.println("<h1>Welcome "+s.getName()+", You have successfully logged.</h1>"); 
//			   resp.sendRedirect("success.html");
//			   req.setAttribute("success", "Successfully login");
//			   RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
//				   req.setAttribute("student", s);
				   session.setAttribute("student", s);
				   RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
				   rd.forward(req, resp);
			   } 
			   else 
			   { 
//			    out.println("<h1>Failed to Login</h1>"); 
//				   resp.sendRedirect("failure.html");
				   req.setAttribute("failure", "Failed to Login");
				   RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
				   rd.forward(req, resp);
			   } 
			    
	}
}
	



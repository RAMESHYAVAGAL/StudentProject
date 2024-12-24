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

@WebServlet("/forgotPin")
public class Forgot extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
		        // Retrieving form parameters
		        String mailId = req.getParameter("mail"); 
		        String phonenumber = req.getParameter("phone"); 
		        String password = req.getParameter("password"); 
		        String confirmPassword = req.getParameter("confirm");
		        
		        long phone=Long.parseLong(phonenumber);
		        PrintWriter out = resp.getWriter();
		        
		        // JDBC Interaction
		        StudentDAO sdao = new StudentDAOImp();
		        // Retrieving the student from the database based on email
		        Student s1 = sdao.resetPin(mailId,phone);
		        
		        if(s1!=null && password.equals(confirmPassword)) {
		        	s1.setPass(password);
		        	boolean result=sdao.updateStudent(s1);
		        	if(result) {
//		        		out.println("<h1>Password Updated Successfully.</h1>");
		        		req.setAttribute("success", "Password Updated successfully");
		    			RequestDispatcher rd=req.getRequestDispatcher("Forgot.jsp");
		    			rd.forward(req, resp);
		        	}
		        	else{
//		        		out.println("<h1>Failed to Update the Password.</h1>");
		        		req.setAttribute("failure", "Failed to update password");
		    			RequestDispatcher rd=req.getRequestDispatcher("Forgot.jsp");
		    			rd.forward(req, resp);
		        	}
		        }

	}

}

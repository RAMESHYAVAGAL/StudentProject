package com.student.servlets;
import java.io.IOException; 
import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import jakarta.servlet.http.HttpSession; 
@WebServlet("/logout") 
public class Logout extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
			String logs=req.getParameter("Logout"); 
			HttpSession session=req.getSession(false); 
			while(logs.equals("Logout"))
			{ 
				session.invalidate(); 
				req.setAttribute("success","Logged out successfully"); 
				RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");  
				rd.forward(req, resp); 
				} 
				}

}

<%@page import="com.student.dao.StudentDAO"%> 
<%@page import="com.student.dao.StudentDAOImp"%> 
<%@page import="java.util.Iterator"%> 
<%@page import="java.util.ArrayList"%> 
<%@page import="com.student.dto.Student" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Users</title>
<style> 
.heading {      
color: #000080; 
}
.sub { 
color: #1e90ff; 
} 
.success 
{ 
color:green; 
} 
.failure 
{ 
color:red; 
} 
.buttons 
{ 
text-decoration: none; 
} 
</style> 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"> 
</head>



<body>
<%Student s=(Student)session.getAttribute("student");%> 
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark"> 
    <div class="container-fluid"> 
      <a class="navbar-brand text" href="#">Welcome Admin:<%=s.getName() %></a> 
      <button class="navbar-toggler" type="button" data-bstoggle="collapse" data-bs-target="#navbarNav" ariacontrols="navbarNav" aria-expanded="false" aria-label="Toggle navigation"> 
        <span class="navbar-toggler-icon"></span> 
      </button> 
      <div class="collapse navbar-collapse" id="navbarNav"> 
        <ul class="navbar-nav ms-auto"> 
          <li class="nav-item"> 
            <a class="btn btn-primary" href="Dashboard.jsp">Back</a> 
          </li> 
          <li class="nav-item"> 
          </li> 
        </ul>
        </div> 
    </div> 
  </nav> 
  <div class="container mt-4"> 
    <h1 class="text-center mb-4">Student Data</h1> 
</div> 
  <%String success=(String)request.getAttribute("success"); 
  if(success!=null){%> 
  <h3 class="success"><%=success%></h3>  
  <%}%> 
  <%String failure=(String)request.getAttribute("failure"); 
  if(failure!=null){%> 
  <h3 class="failure"><%=failure%></h3>  
  <%}%> 
<!-- User Section --> 
    <div class="row"> 
      <div class="col-md-12"> 
       <input type="search" value="Search here..!"> 
        <table class="table table-hover"> 
          <thead> 
            <tr> 
              <th>Id</th>
               <th>Name</th> 
              <th>Phone</th> 
              <th>Mail ID</th> 
              <th>Branch</th> 
          <th>Location</th> 
          <th>Remove</th> 
            </tr>  
          </thead> 
  <%StudentDAO sdao=new StudentDAOImp(); 
  ArrayList<Student> students=(ArrayList<Student>)sdao.getStudent(); 
  Iterator<Student> it=students.iterator();%> 
          <tbody> 
          <% while(it.hasNext()){ 
        	  Student s1=it.next();%> 
          <tr> 
          <td><%=s1.getId()%></td> 
          <td><%=s1.getName()%></td> 
          <td><%=s1.getPhone()%></td> 
          <td><%=s1.getMail()%></td> 
          <td><%=s1.getBranch()%></td> 
          <td><%=s1.getLocation()%></td> 
          <td><form action="deleteUser" method="post"> 
           <input type="hidden" name="id" value="<%=s1.getId()%>"> 
           <input class="btn btn-danger" type="submit" value="Delete"> 
          </form> 
          </td> 
          </tr> 
          <%}%> 
         </tbody> 
        </table> 
      </div> 
    </div> 
</body>
</html>
package com.student.dao;

import java.util.List;


import com.student.dto.Student;

public interface StudentDAO {
	public boolean insertStudent(Student s);
	 public boolean updateStudent(Student s);
	 public boolean deleteStudent(Student s);
	 public Student resetPin(String mail, long phone);
	 public Student getStudent(String mail, String pass);
	 public boolean updateAccount(Student s);
	 public List<Student> getStudent();
	

}

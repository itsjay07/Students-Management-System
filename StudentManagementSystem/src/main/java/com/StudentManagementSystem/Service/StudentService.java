package com.StudentManagementSystem.Service;

import java.util.List;

import com.StudentManagementSystem.Entity.Student;

public interface StudentService 
{
	public List<Student>getAllStudents();
	
	public Student saveStudent (Student student);
	
	public Student getById(int id);
	
	public void deleteById(int id);
}

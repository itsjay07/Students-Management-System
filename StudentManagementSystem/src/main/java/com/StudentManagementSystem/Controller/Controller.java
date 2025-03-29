package com.StudentManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.StudentManagementSystem.Entity.Student;
import com.StudentManagementSystem.Service.StudentService;


@org.springframework.stereotype.Controller
public class Controller 
{
	
	@Autowired
	private StudentService studentService;

	@GetMapping("/home")
	public String home()
	{
		return "home";
	}
	
//--------------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/students")
	public String getAllStudents(Model model)
	{
		model.addAttribute("students", studentService.getAllStudents());
		
		return "students";
	}
	
//--------------------------------------------------------------------------------------------------------------------
	
	@GetMapping("students/new")
	public String createStudentForm(Model model)
	{
		Student student = new Student();  //to hold student object
		model.addAttribute("students",student);
		
		return "create-student";
	}
	
//--------------------------------------------------------------------------------------------------------------------
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student)
	{	
		studentService.saveStudent(student);
		
		return "redirect:students"; //redirect to the list of student
	}
	
//--------------------------------------------------------------------------------------------------------------------
		
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model)
	{
		model.addAttribute("student",studentService.getById(id));
		
		return "edit_student";
	}
	
//--------------------------------------------------------------------------------------------------------------------
	
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable int id , @ModelAttribute("student") Student student)
	{
		Student existingStudent = studentService.getById(id);
		
		existingStudent.setFirstName(student.getFirstName());
		
		existingStudent.setLastName(student.getLastName());
		
		existingStudent.setEmail(student.getEmail());
		
		studentService.saveStudent(existingStudent);
		
		return "redirect:/students";
	}
	
//--------------------------------------------------------------------------------------------------------------------
		
	@GetMapping("/students/{id}")
	public String deleteById(@PathVariable int id)
	{
		studentService.deleteById(id);
		
		return "redirect:/students";
	}
	
//--------------------------------------------------------------------------------------------------------------------
		
}

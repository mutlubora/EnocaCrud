package com.enoca.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enoca.cruddemo.entity.Department;
import com.enoca.cruddemo.service.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentRestController {
	
	private DepartmentService departmentService;
	
	@Autowired
	public DepartmentRestController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@GetMapping("/departments")
	public List<Department> findAll() {
		return departmentService.findAll();
	}
	
	@GetMapping("/departments/{departmentId}")
	public Department getDeaprtment(@PathVariable int departmentId) {
		Department department = departmentService.findById(departmentId);
		if(department == null) {
			throw new RuntimeException("Department id not found - " + departmentId);
		}
		return department;
	}
	
	@PostMapping("/departments")
	public Department addDepartment(@RequestBody Department department) {
		department.setId(0);
		departmentService.save(department);
		return department;
	}
	
	@PutMapping("/departments")
	public Department updateDepartment(@RequestBody Department department) {
		departmentService.save(department);
		return department;
	}
	
	@DeleteMapping("/departments/{departmentId}")
	public String deleteDepartment(@PathVariable int departmentId) {
		Department department = departmentService.findById(departmentId);
		if(department == null) {  
			throw new RuntimeException("Department id not found - " + departmentId);
		}
		departmentService.deleteById(departmentId);
		return "Deleted department id - " + departmentId;
	}
	
	
	
}

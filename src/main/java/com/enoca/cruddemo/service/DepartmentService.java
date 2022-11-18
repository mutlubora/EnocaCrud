package com.enoca.cruddemo.service;

import java.util.List;

import com.enoca.cruddemo.entity.Department;

public interface DepartmentService {
	public List<Department> findAll();
	
	public Department findById(int id);
	
	public void save(Department employee);
	
	public void deleteById(int id);
}

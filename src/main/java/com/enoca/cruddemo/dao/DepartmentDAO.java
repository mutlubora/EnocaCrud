package com.enoca.cruddemo.dao;

import java.util.List;

import com.enoca.cruddemo.entity.Department;

public interface DepartmentDAO {
	
	public List<Department> findAll();
	
	public Department findById(int id);
	
	public void save(Department employee);
	
	public void deleteById(int id);
}

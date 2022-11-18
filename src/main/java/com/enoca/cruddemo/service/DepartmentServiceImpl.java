package com.enoca.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enoca.cruddemo.dao.DepartmentDAO;
import com.enoca.cruddemo.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentDAO departmentDAO;
	
	@Autowired
	public DepartmentServiceImpl(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}
	
	@Override
	@Transactional
	public List<Department> findAll() {
		return departmentDAO.findAll();
	}

	@Override
	@Transactional
	public Department findById(int id) {
		return departmentDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Department department) {
		departmentDAO.save(department);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		departmentDAO.deleteById(id);
	}

}

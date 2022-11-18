package com.enoca.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.enoca.cruddemo.entity.Department;

@Repository
public class DepartmentDAOJpaImpl implements DepartmentDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public DepartmentDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	@Override
	public List<Department> findAll() {
		TypedQuery<Department> query = 
				entityManager.createQuery("from Department", Department.class);
		List<Department> departments = query.getResultList();
		return departments;
	}

	@Override
	public Department findById(int id) {
		Department department = entityManager.find(Department.class, id);
		return department;
	}

	@Override
	public void save(Department department) {
		Department dbDepartment = entityManager.merge(department);
		department.setId(dbDepartment.getId());
	}

	@Override
	public void deleteById(int id) {
		Query query = entityManager.createQuery(
				"delete from Department where id=:departmentId");
		query.setParameter("departmentId", id);
		query.executeUpdate();
	}

}

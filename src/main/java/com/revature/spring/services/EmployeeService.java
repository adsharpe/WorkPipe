package com.revature.spring.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.EmployeeDAO;
import com.revature.hibernate.beans.Employee;

@Service
@Transactional(readOnly=true)
public class EmployeeService {
	@Autowired
	EmployeeDAO employeeDao;
	
	@Transactional(readOnly=false)
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}
	
	public Employee getEmployee(Employee employee) {
		return employeeDao.getEmployee(employee);
	}
	
	public Set<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

	@Transactional(readOnly=false)
	public void deleteEmployee(Employee employee) {
		employeeDao.deleteEmployee(employee);
	}

	@Transactional(readOnly=false)
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}
}

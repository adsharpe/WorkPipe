package com.revature.data;

import java.util.Set;

import com.revature.hibernate.beans.Employee;


public interface EmployeeDAO {
	
		public Employee addEmployee(Employee employee);
		
		public Employee getEmployee(Employee emp);
		
		public Set<Employee> getEmployees();
		
		public void deleteEmployee(Employee employee);
		
		public void updateEmployee(Employee employee);
}

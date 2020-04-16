package com.revature.hibernate.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Project_Employee")
public class ProjectEmployee {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ProjectEmployee")
	@SequenceGenerator(name="ProjectEmployee", sequenceName="ProjectEmployee_seq", allocationSize=1)
	private Integer id;
	
	//I think this is how we make a JoinTable with Hibernate
	@ManyToMany
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@ManyToMany
	@JoinColumn(name="project_id")
	private Project project;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Employee getEmployees() {
		return employee;
	}
	public void setEmployees(Employee employee) {
		this.employee = employee;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		return result;
	}
	public Project getProjects() {
		return project;
	}
	public void setProjects(Project project) {
		this.project = project;
	}
	public ProjectEmployee(Integer id, Employee employee, Project project) {
		super();
		this.id = id;
		this.employee = employee;
		this.project = project;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectEmployee other = (ProjectEmployee) obj;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", employee=" + employee + ", project=" + project + "]";
	}
	public ProjectEmployee() {
		super();
	}
	
}

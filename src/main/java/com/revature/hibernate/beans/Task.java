package com.revature.hibernate.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.revature.hibernate.beans.Text;
import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Project;
import com.revature.hibernate.beans.Status;

@Entity
@Table
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="task")
	@SequenceGenerator(name="task", sequenceName="task_seq", allocationSize=1)
	private Integer id;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="status_id")
	private Status status;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="employee_id")
	private Employee employee;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="description_id")
	private Text description;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="project_id")
	private Project project;
	// need to add the description_id variable
	// then getters and setters for it, change the constructors,
	// the toString method, and the hash code and equals()
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmpId(Employee employee) {
		this.employee = employee;
	}
	public Text getDescription() {
		return description;
	}
	public void setDescription(Text description) {
		this.description = description;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", status=" + status + ", employee=" + employee + ", description=" + description
				+ ", project=" + project + "]";
	}
	public Task() {
		super();
	}
	public Task(Integer id, Status status, Employee employee, Text description, Project project) {
		super();
		this.id = id;
		this.status = status;
		this.employee = employee;
		this.description = description;
		this.project = project;
	}
	
}

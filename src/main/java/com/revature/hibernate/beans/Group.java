package com.revature.hibernate.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Group {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Group")
	@SequenceGenerator(name="Group", sequenceName="Group_seq", allocationSize=1)
	private Integer id;
	
	//I think this is how we make a JoinTable with Hibernate
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="Group_Employee",
		joinColumns=@JoinColumn(name="group_id"),
		inverseJoinColumns=@JoinColumn(name="employee_id"))
	//changing bean
	private Set<Employee> employees;
	
	@OneToMany
	@JoinColumn(name="project_id")
	private Integer projId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProjId() {
		return projId;
	}
	public void setProjId(Integer projId) {
		this.projId = projId;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((projId == null) ? 0 : projId.hashCode());
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
		Group other = (Group) obj;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (projId == null) {
			if (other.projId != null)
				return false;
		} else if (!projId.equals(other.projId))
			return false;
		return true;
	}
	public Group(Integer id, Set<Employee> employees, Integer projId) {
		super();
		this.id = id;
		this.employees = employees;
		this.projId = projId;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", employees=" + employees + ", projId=" + projId + "]";
	}
	public Group() {
		super();
	}
	
}

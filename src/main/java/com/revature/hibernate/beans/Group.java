package com.revature.hibernate.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Group {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Group")
	@SequenceGenerator(name="Group", sequenceName="Group_seq", allocationSize=1)
	private Integer id;
	//not sure if this is a many to one relationship
	//depends on how we want employees in the projects
	//maybe this is a one (group) to many (projects)?
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="employee_id")
	private Integer empId;
	@JoinColumn(name="project_id")
	private Integer projId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public Integer getProjId() {
		return projId;
	}
	public void setProjId(Integer projId) {
		this.projId = projId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
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
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
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
	@Override
	public String toString() {
		return "Group [id=" + id + ", empId=" + empId + ", projId=" + projId + "]";
	}
	public Group(Integer id, Integer empId, Integer projId) {
		super();
		this.id = id;
		this.empId = empId;
		this.projId = projId;
	}
	public Group() {
		super();
	}
	
}

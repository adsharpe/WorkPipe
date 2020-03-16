package com.revature.hibernate.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Text;

@Entity
@Table(name="Project_Comment")
public class ProjectComment {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Project_Comment")
	@SequenceGenerator(name="Project_Comment", sequenceName="Project_Comment_seq", allocationSize=1)
	private Integer id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="project_id")
	private Project projects;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="employee_id")
	private Employee empId;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="text_id")
	private Text textId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Project getProjects() {
		return projects;
	}
	public void setProjects(Project projects) {
		this.projects = projects;
	}
	public Employee getEmpId() {
		return empId;
	}
	public void setEmpId(Employee empId) {
		this.empId = empId;
	}
	public Text getTextId() {
		return textId;
	}
	public void setTextId(Text textId) {
		this.textId = textId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((projects == null) ? 0 : projects.hashCode());
		result = prime * result + ((textId == null) ? 0 : textId.hashCode());
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
		ProjectComment other = (ProjectComment) obj;
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
		if (projects == null) {
			if (other.projects != null)
				return false;
		} else if (!projects.equals(other.projects))
			return false;
		if (textId == null) {
			if (other.textId != null)
				return false;
		} else if (!textId.equals(other.textId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ProjectComment [id=" + id + ", projects=" + projects + ", empId=" + empId + ", textId=" + textId + "]";
	}
	public ProjectComment() {
		super();
	}
	public ProjectComment(Integer id, Project projects, Employee empId, Text textId) {
		super();
		this.id = id;
		this.projects = projects;
		this.empId = empId;
		this.textId = textId;
	}
	
}

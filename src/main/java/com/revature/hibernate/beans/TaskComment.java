package com.revature.hibernate.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Text;

@Entity
@Table(name="Task_Comment")
public class TaskComment {
	@Id
	
	//did i use the right names and generators?
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Task_Comment")
	@SequenceGenerator(name="Task_Comment", sequenceName="Task_Comment_seq", allocationSize=1)
	private Integer id;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="task_id")
	private Set<Task> tasks;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="employee_id")
	private Employee empId;
	//one text per comment?
	//is this a one to one?
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="text_id")
	private Text textId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Set<Task> getTasks() {
		return tasks;
	}
	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
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
		result = prime * result + ((tasks == null) ? 0 : tasks.hashCode());
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
		TaskComment other = (TaskComment) obj;
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
		if (tasks == null) {
			if (other.tasks != null)
				return false;
		} else if (!tasks.equals(other.tasks))
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
		return "TaskComment [id=" + id + ", tasks=" + tasks + ", empId=" + empId + ", textId=" + textId + "]";
	}
	
	public TaskComment(Integer id, Set<Task> tasks, Employee empId, Text textId) {
		super();
		this.id = id;
		this.tasks = tasks;
		this.empId = empId;
		this.textId = textId;
	}
	public TaskComment() {
		super();
	}
	
}

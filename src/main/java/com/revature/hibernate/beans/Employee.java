package com.revature.hibernate.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.revature.hibernate.beans.Login;

@Entity
@Table(name="login")
@PrimaryKeyJoinColumn(name="id")
public class Employee extends Login{
	@Column(name="firstname")
	private String first;
	@Column(name="lastname")
	private String last;
	private String title;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="login_id")
	private Login logId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="supervisor_id")
	private Employee supervisor;
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Login getLogId() {
		return logId;
	}
	public void setLogId(Login logId) {
		this.logId = logId;
	}
	public Employee getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}
	public Employee(Integer id, String username, String pass, String first, String last, String title, Login logId, Employee supervisor) {
		super(id, username, pass);
		this.first = first;
		this.last = last;
		this.title = title;
		this.logId = logId;
		this.supervisor = supervisor;
	}
	public Employee(Integer id) {
		super(id);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((last == null) ? 0 : last.hashCode());
		result = prime * result + ((logId == null) ? 0 : logId.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (last == null) {
			if (other.last != null)
				return false;
		} else if (!last.equals(other.last))
			return false;
		if (logId == null) {
			if (other.logId != null)
				return false;
		} else if (!logId.equals(other.logId))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "employee [first=" + first + ", last=" + last + ", title=" + title + ", logId=" + logId + "]";
	}


}

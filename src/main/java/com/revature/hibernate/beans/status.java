package com.revature.hibernate.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class status {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="status")
	@SequenceGenerator(name="status", sequenceName="status_seq", allocationSize=1)
	private Integer id;
	@Column(name="status_level")
	private String statLevel;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatLevel() {
		return statLevel;
	}
	public void setStatLevel(String statLevel) {
		this.statLevel = statLevel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((statLevel == null) ? 0 : statLevel.hashCode());
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
		status other = (status) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (statLevel == null) {
			if (other.statLevel != null)
				return false;
		} else if (!statLevel.equals(other.statLevel))
			return false;
		return true;
	}
	public status() {
		super();
	}
	public status(Integer id, String statLevel) {
		super();
		this.id = id;
		this.statLevel = statLevel;
	}
	@Override
	public String toString() {
		return "status [id=" + id + ", statLevel=" + statLevel + "]";
	}
	
}

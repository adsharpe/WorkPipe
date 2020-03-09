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
public class text {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="text")
	@SequenceGenerator(name="text", sequenceName="text_seq", allocationSize=1)
	private Integer id;
	@Column(name="string")
	private String textstring;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTextstring() {
		return textstring;
	}
	public void setTextstring(String textstring) {
		this.textstring = textstring;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((textstring == null) ? 0 : textstring.hashCode());
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
		text other = (text) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (textstring == null) {
			if (other.textstring != null)
				return false;
		} else if (!textstring.equals(other.textstring))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "text [id=" + id + ", textstring=" + textstring + "]";
	}
	public text() {
		super();
	}
	public text(Integer id, String textstring) {
		super();
		this.id = id;
		this.textstring = textstring;
	}
	
}

package com.revature.hibernate.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "login")
@Inheritance(strategy=InheritanceType.JOINED)
public class Login {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="login")
	@SequenceGenerator(name="login", sequenceName="login_seq", allocationSize=1)
	private Integer id;
	private String username;
	private String password;
	
	//constructor from superclass
//	public Login(Integer id) {
//		super();
//		this.id = id;
//	}
//	//constructor from fields
//	public Login(Integer id, String username, String password) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.password = password;
//	}
	//getters and setters from fields
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPass(String password) {
		this.password = password;
	}
	//toString method
	@Override
	public String toString() {
		return "login [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	//haschcode from fields
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	//equals methods
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}

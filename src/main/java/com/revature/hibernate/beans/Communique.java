package com.revature.hibernate.beans;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Communique {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Communique")
	@SequenceGenerator(name="Communique", sequenceName="Communique_seq", allocationSize=1)
	private Integer id;
	
	//I think this needs to be Eager all the way through?
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="sender_id")
	private Integer senderId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="project_id")
	private Integer projId;
	private Timestamp timestamp;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="text_id")
	private Integer textId;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="communique_type")
	private Set<CommuniqueType> commTypes;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSenderId() {
		return senderId;
	}
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	public Integer getProjId() {
		return projId;
	}
	public void setProjId(Integer projId) {
		this.projId = projId;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public Integer getTextId() {
		return textId;
	}
	public void setTextId(Integer textId) {
		this.textId = textId;
	}
	
	public Set<CommuniqueType> getCommTypes() {
		return commTypes;
	}
	public void setCommTypes(Set<CommuniqueType> commTypes) {
		this.commTypes = commTypes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commTypes == null) ? 0 : commTypes.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((projId == null) ? 0 : projId.hashCode());
		result = prime * result + ((senderId == null) ? 0 : senderId.hashCode());
		result = prime * result + ((textId == null) ? 0 : textId.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
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
		Communique other = (Communique) obj;
		if (commTypes == null) {
			if (other.commTypes != null)
				return false;
		} else if (!commTypes.equals(other.commTypes))
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
		if (senderId == null) {
			if (other.senderId != null)
				return false;
		} else if (!senderId.equals(other.senderId))
			return false;
		if (textId == null) {
			if (other.textId != null)
				return false;
		} else if (!textId.equals(other.textId))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Communique [id=" + id + ", senderId=" + senderId + ", projId=" + projId + ", timestamp=" + timestamp
				+ ", textId=" + textId + ", commTypes=" + commTypes + "]";
	}
	public Communique(Integer id, Integer senderId, Integer projId, Timestamp timestamp, Integer textId,
			Set<CommuniqueType> commType) {
		super();
		this.id = id;
		this.senderId = senderId;
		this.projId = projId;
		this.timestamp = timestamp;
		this.textId = textId;
		this.commTypes = commType;
	}
	public Communique() {
		super();
	}
	
}

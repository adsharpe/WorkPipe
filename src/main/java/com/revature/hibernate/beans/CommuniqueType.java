package com.revature.hibernate.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Communique_Type")
public class CommuniqueType {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Communique_Type")
	@SequenceGenerator(name="Communique_Type", sequenceName="Communique_Type_seq", allocationSize=1)
	private Integer id;
	private String type;
}

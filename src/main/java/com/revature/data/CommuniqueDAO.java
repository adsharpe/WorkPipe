package com.revature.data;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.revature.hibernate.beans.Communique;
import com.revature.hibernate.beans.CommuniqueType;

public interface CommuniqueDAO {
	// create
	public Communique addCommuniqueType(Communique c);
	// read
	public Communique getCommunique(int i);
	public Set<Communique> getCommuniqueByCommuniqueType(CommuniqueType ct);
	// update
	public void updateCommunique(Communique c);
	// delete
	public void deleteCommunique(Communique c);
}

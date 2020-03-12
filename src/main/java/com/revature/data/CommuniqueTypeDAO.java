package com.revature.data;

import com.revature.hibernate.beans.CommuniqueType;
import com.revature.hibernate.beans.Project;
import com.revature.hibernate.beans.Task;

public interface CommuniqueTypeDAO {
	// create
	public CommuniqueType addCommuniqueType(CommuniqueType ct);
	// read
	public CommuniqueType getCommuniqueType(int i);
	// update
	public void updateCommuniqueType(CommuniqueType ct);
	// delete
	public void deleteCommuniqueType(CommuniqueType ct);
}

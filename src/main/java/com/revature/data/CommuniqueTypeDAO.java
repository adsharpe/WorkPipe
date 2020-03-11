package com.revature.data;

import com.revature.hibernate.beans.CommuniqueType;
import com.revature.hibernate.beans.Project;
import com.revature.hibernate.beans.Task;

public interface CommuniqueTypeDAO {
	// create
	public int addCommuniqueType(CommuniqueType ct);
	// read
	public CommuniqueType getCommuniqueType(int i);
	public CommuniqueType getCommuniqueTypeByTask(Task t);
	public CommuniqueType getCommuniqueTypeByProject(Project p);
	// update
	public void updateCommuniqueType(CommuniqueType ct);
	// delete
	public void deleteCommuniqueType(CommuniqueType ct);
}

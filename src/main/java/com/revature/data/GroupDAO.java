package com.revature.data;

import java.util.Set;

import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Group;
import com.revature.hibernate.beans.Project;

public interface GroupDAO {
	// create
	public int addGroup(Group g);
	// read
	public Group getGroup(int i);
	public Group getGroupByProject(Project p);
	public Set<Group> getGroupsByEmployee(Employee emp);
	// update
	public void updateGroup(Group g);
	// delete
	public void deleteGroup(Group g);
}

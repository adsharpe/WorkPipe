package com.revature.data;

import java.util.Set;

import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Project;
import com.revature.hibernate.beans.Task;
import com.revature.hibernate.beans.Text;

public interface TextDAO {
			// create
		public int addText(Text txt);
		// read
		public Text getText(int i);
		public Text getTextByEmployee(Employee emp);
		public Set<Text> getTexts();
		public Set<Text> getTextsByProject(Project p);
		public Set<Text> getTextsByTask(Task t);
		// update
		public void updateText(Text txt);
		// delete
		public void deleteText(Text txt);
}

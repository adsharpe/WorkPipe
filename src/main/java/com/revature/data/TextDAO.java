package com.revature.data;

import java.util.Set;

import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Project;
import com.revature.hibernate.beans.Task;
import com.revature.hibernate.beans.Text;

public interface TextDAO {
		// create
		public Text addText(Text text);
		
		// read
		public Text getText(int textId);
		public Set<Text> getTexts();
		
		// update
		public void updateText(Text text);
		
		// delete
		public void deleteText(Text text);
}

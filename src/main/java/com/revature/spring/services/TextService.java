package com.revature.spring.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.TextDAO;
import com.revature.hibernate.beans.Employee;
import com.revature.hibernate.beans.Project;
import com.revature.hibernate.beans.Task;
import com.revature.hibernate.beans.Text;

@Service
@Transactional(readOnly=true)
public class TextService {
	@Autowired
	TextDAO textDao;
	
	@Transactional(readOnly=false)
	public int addText(Text text) {
		return textDao.addText(text);
	}
	
	public Text getText(int taskId) {
		return textDao.getText(taskId);
	}
	
	public Text getTextByEmployee(Employee employee) {
		return textDao.getTextByEmployee(employee);
	}
	
	public Set<Text> getTexts() {
		return textDao.getTexts();
	}
	
	public Set<Text> getTextsByProject(Project project) {
		return textDao.getTextsByProject(project);
	}
	
	public Set<Text> getTextsByTask(Task task) {
		return textDao.getTextsByTask(task);
	}
	
	@Transactional(readOnly=false)
	public void updateText(Text text) {
		textDao.updateText(text);
	}
	
	@Transactional(readOnly=false)
	public void deleteText(Text text) {
		textDao.deleteText(text);
	}
}

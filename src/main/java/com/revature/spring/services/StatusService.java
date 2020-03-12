package com.revature.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.StatusDAO;
import com.revature.hibernate.beans.Status;
import com.revature.hibernate.beans.Task;

@Service
@Transactional(readOnly=true)
public class StatusService {
	@Autowired
	StatusDAO statusDao;
	
	@Transactional(readOnly=false)
	public int addStatus(Status status) {
		return statusDao.addStatus(status);
	}
	
	public Status getStatus(int statusId) {
		return statusDao.getStatus(statusId);
	}
	
	public Status getStatusById(Status status) {
		return statusDao.getStatusById(status);
	}

	@Transactional(readOnly=false)
	public void updateStatus(Status status) {
		statusDao.updateStatus(status);
	}

	@Transactional(readOnly=false)
	public void deleteStatus(Status status) {
		statusDao.deleteStatus(status);
	}
}

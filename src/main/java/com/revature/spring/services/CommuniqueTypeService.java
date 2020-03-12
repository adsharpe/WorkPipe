package com.revature.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.CommuniqueTypeDAO;
import com.revature.hibernate.beans.CommuniqueType;
import com.revature.hibernate.beans.Project;
import com.revature.hibernate.beans.Task;

@Service
@Transactional(readOnly=true)
public class CommuniqueTypeService {
	@Autowired
	CommuniqueTypeDAO communiqueTypeDao;
	
	@Transactional(readOnly=false)
	public CommuniqueType addCommuniqueType(CommuniqueType communiqueType) {
		return communiqueTypeDao.addCommuniqueType(communiqueType);
	}
	
	public CommuniqueType getCommuniqueType(int communiqueTypeId) {
		return communiqueTypeDao.getCommuniqueType(communiqueTypeId);
	}

	@Transactional(readOnly=false)
	public void updateCommuniqueType(CommuniqueType communiqueType) {
		communiqueTypeDao.updateCommuniqueType(communiqueType);
	}

	@Transactional(readOnly=false)
	public void deleteCommuniqueType(CommuniqueType communiqueType) {
		communiqueTypeDao.deleteCommuniqueType(communiqueType);
	}
}

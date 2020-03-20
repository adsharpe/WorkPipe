package com.revature.spring.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.CommuniqueDAO;
import com.revature.hibernate.beans.Communique;
import com.revature.hibernate.beans.CommuniqueType;

@Service
@Transactional(readOnly=true)
public class CommuniqueService {
	@Autowired
	CommuniqueDAO communiqueDao;
	
	@Transactional(readOnly=false)
	public Communique addCommunique(Communique communique) {
		return communiqueDao.addCommunique(communique);
	}
	
	public Communique getCommunique(int communiqueId) {
		return communiqueDao.getCommunique(communiqueId);
	}
	
	public Set<Communique> getCommuniqueByCommuniqueType(CommuniqueType communiqueType) {
		return communiqueDao.getCommuniqueByCommuniqueType(communiqueType);
	}

	@Transactional(readOnly=false)
	public void updateCommunique(Communique communique) {
		communiqueDao.updateCommunique(communique);
	}

	@Transactional(readOnly=false)
	public void deleteCommunique(Communique communique) {
		communiqueDao.deleteCommunique(communique);
	}
}

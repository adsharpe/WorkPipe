package com.revature.spring.services;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.hibernate.beans.Communique;

@Service
@Transactional(readOnly=true)
public class CommuniqueService {/*
	@Autowired
	CommuniqueDAO communiqueDao;*/
}

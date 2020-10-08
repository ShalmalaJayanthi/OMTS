package com.cg.omts.service;

import java.util.List;

import com.cg.omts.dao.AdminDaoImpl;
import com.cg.omts.dao.IAdminDao;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;

public class AdminServiceImpl implements IAdminService{

	IAdminDao adminDao = new AdminDaoImpl();
	@Override
	public List<Theatre> getTheatreDetails() throws OMTSException {
		// TODO Auto-generated method stub
		return adminDao.getTheatreDetails();
	}
	@Override
	public int addTheatre(Theatre theatre) throws OMTSException {
		// TODO Auto-generated method stub
		return adminDao.addTheatre(theatre);
	}
	@Override
	public int deleteTheatre(int theatreId) throws OMTSException {
		// TODO Auto-generated method stub
		return adminDao.deleteTheatre(theatreId);
	}

	
}

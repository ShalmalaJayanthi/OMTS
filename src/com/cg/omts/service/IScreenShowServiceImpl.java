package com.cg.omts.service;

import java.util.ArrayList;

import com.cg.omts.dao.IScreenShowDao;
import com.cg.omts.dao.ScreenShowDaoImpl;
import com.cg.omts.dto.Screen;
import com.cg.omts.exceptions.OMTSException;

public class IScreenShowServiceImpl implements IScreenShowService{
	IScreenShowDao screenShowDao = null;
	@Override
	public Boolean addScreen(Screen screen, Integer theatreId) throws OMTSException {
		screenShowDao = new ScreenShowDaoImpl();
		Boolean isAdded = screenShowDao.addScreen(screen, theatreId);
		return isAdded;
	}

	@Override
	public Boolean deleteScreen(Integer screenId) throws OMTSException {
		screenShowDao = new ScreenShowDaoImpl();
		Boolean isAdded = screenShowDao.deleteScreen(screenId);
		return isAdded;
	}

	@Override
	public ArrayList<Screen> getScreenDetailsToDelete() throws OMTSException {
		screenShowDao = new ScreenShowDaoImpl();
		ArrayList<Screen> screenList = screenShowDao.getScreenDetailsToDelete();
		return screenList;
	}
	
	@Override
	public boolean isScreenIdExists(int screenId) throws OMTSException {
		screenShowDao = new ScreenShowDaoImpl();
		boolean isExists = screenShowDao.isScreenIdExists(screenId);
		return isExists;
	}
	
	@Override
	public boolean addScreenSeatPrice(int screenId, int seatPrice) throws OMTSException {
		screenShowDao = new ScreenShowDaoImpl();
		boolean isAdded = screenShowDao.addScreenSeatPrice(screenId, seatPrice);
		return isAdded;
	}
}

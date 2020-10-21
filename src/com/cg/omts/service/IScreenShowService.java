package com.cg.omts.service;

import java.util.ArrayList;

import com.cg.omts.dto.Screen;
import com.cg.omts.exceptions.OMTSException;

public interface IScreenShowService {
	
	public boolean isScreenIdExists(int screenId) throws OMTSException;
	
	public  Boolean addScreen(Screen screen, Integer theatreId) throws OMTSException;
	
	public  Boolean deleteScreen(Integer screenId) throws OMTSException;
	
	public  ArrayList<Screen> getScreenDetailsToDelete() throws OMTSException;

	public boolean addScreenSeatPrice(int screenId, int seatPrice) throws OMTSException;


}

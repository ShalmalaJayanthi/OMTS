package com.cg.omts.service;

import java.util.List;

import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;

public interface IAdminService {
	public List<Theatre> getTheatreDetails() throws OMTSException;
	public  int addTheatre(Theatre theatre) throws OMTSException;
	public int deleteTheatre(int id) throws OMTSException;
	public List<Theatre> getTheatreByName(String theatreName) throws OMTSException;
}

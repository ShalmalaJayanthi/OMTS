package com.cg.omts.dao;

import java.util.List;
<<<<<<< HEAD
=======

import com.cg.omts.dto.Movie;
>>>>>>> branch 'master' of https://github.com/PLaxmiPrasanna/OnlineMovieTicketSystem
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;

public interface IAdminDao {
<<<<<<< HEAD
	
	public List<Theatre> getTheatreDetails() throws OMTSException;
	
	public  int addTheatre(Theatre theatre) throws OMTSException;
}
=======
	public List<Theatre> getTheatreDetails() throws OMTSException;
	public  int addTheatre(Theatre theatre) throws OMTSException;
	public int deleteTheatre(int theatreId) throws OMTSException;
}
>>>>>>> branch 'master' of https://github.com/PLaxmiPrasanna/OnlineMovieTicketSystem

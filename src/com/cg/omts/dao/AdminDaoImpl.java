package com.cg.omts.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.cg.omts.dto.Customer;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Seat;
import com.cg.omts.dto.Show;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.utility.DBConnection;
import com.cg.omts.utility.DBConnection;

public class AdminDaoImpl  implements IAdminDao, IQueryConstants {
	
	static Connection connection = null;
	static Statement statement = null;
	static PreparedStatement prepareStatement = null;
	static ResultSet resultSet = null;
	
	@Override
	public List<Theatre> getTheatreDetails() throws OMTSException {
		// TODO Auto-generated method stub
		List<Theatre> theatreList = new ArrayList<Theatre>();
		try {
			connection  = DBConnection.getConnection();
			statement = connection.createStatement();  
			resultSet = statement.executeQuery(IAdminQueryConstants.GET_THEATRE_DETAILS);  
			
			while(resultSet.next())   {
					Theatre theatre = new Theatre();
					theatre.setTheatreId(resultSet.getInt(1));
					theatre.setTheatreName(resultSet.getString(2));
					theatre.setTheatreCity(resultSet.getString(3));
					theatre.setManagerName(resultSet.getString(4));
					theatre.setManagerContact(resultSet.getString(5));
					theatreList.add(theatre); 
			}
		}catch(SQLException e){ 
			throw new OMTSException("problem while displaying Theatre Data from Database");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
			
		return theatreList;
		}
		
	@Override
	public int addTheatre(Theatre theatre) throws OMTSException {
		// TODO Auto-generated method stub
		int isInserted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IAdminQueryConstants.ADD_THEATRE);    
			prepareStatement.setInt(1,theatre.getTheatreId());  
			prepareStatement.setString(2,theatre.getTheatreName()); 
			prepareStatement.setString(3, theatre.getTheatreCity());
			prepareStatement.setString(4, theatre.getManagerName());
			prepareStatement.setString(5, theatre.getManagerContact());
			isInserted = prepareStatement.executeUpdate();  
			}catch(SQLException e){ 
				throw new OMTSException("problem inserting Theatre Details into Database");
			}finally {
				try {
					connection.close();
				}catch(SQLException e) {
					throw new OMTSException("problem while closing Database");
				}
			}
		return isInserted;
	}
	
	@Override
	public int deleteTheatre(int theatreId) throws OMTSException {
		int isDeleted = 0;
		try {
		// TODO Auto-generated method stub
		connection = DBConnection.getConnection();
		prepareStatement=connection.prepareStatement(IAdminQueryConstants.DELETE_THEATRE);    
		prepareStatement.setInt(1,theatreId);  
		isDeleted = prepareStatement.executeUpdate();  
		}catch(SQLException e){ 
			System.out.println(e);
			//throw new OMTSException("problem while deleting Theatre Details from Database");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
	return isDeleted;
	}

	@Override
	public List<Theatre> getTheatreByName(String theatreName) throws OMTSException {
		// TODO Auto-generated method stub
		List<Theatre> theatreList = new ArrayList<Theatre>();
		try {
			connection  = DBConnection.getConnection();
			prepareStatement =connection.prepareStatement(IAdminQueryConstants.GET_THEATRE_BY_NAME); 
			prepareStatement.setString(1, theatreName);
			resultSet = prepareStatement.executeQuery();  
				while(resultSet.next())   {
					Theatre theatre = new Theatre();
					theatre.setTheatreId(resultSet.getInt(1));
					theatre.setTheatreName(resultSet.getString(2));
					theatre.setTheatreCity(resultSet.getString(3));
					theatre.setManagerName(resultSet.getString(4));
					theatre.setManagerContact(resultSet.getString(5));
					theatreList.add(theatre); 
				}
			}catch(SQLException e){ 
				throw new OMTSException("problem while displaying Theatre Data from Database");
			}finally {
				try {
					connection.close();
				}catch(SQLException e) {
					throw new OMTSException("problem while closing Database");
				}
			}
				
		return theatreList;
	}
	

	@Override
	public List<Show> getShowDetails() throws OMTSException {
		// TODO Auto-generated method stub
		List<Show> showList = new ArrayList<Show>();
		try {
			connection  = DBConnection.getConnection();
			statement = connection.createStatement();  
			resultSet = statement.executeQuery(IAdminQueryConstants.GET_SHOW_DETAILS);  
			
			while(resultSet.next())   {
					Show show = new Show();
					show.setShowId(resultSet.getInt(1));
					show.setShowStartTime(resultSet.getTime(2));
					show.setShowEndTime(resultSet.getTime(3));
					show.setShowName(resultSet.getString(4));
					show.setMovieName(resultSet.getString(5));
					show.setScreenId(resultSet.getInt(6));
					show.setTheatreId(resultSet.getInt(7));
					show.setMovieId(resultSet.getInt(8));
					showList.add(show); 
			}
		}catch(SQLException e){ 
			throw new OMTSException("problem while displaying Show Data from Database");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
			
		return showList;
		
	}

	@Override
	public int addShow(Show show) throws OMTSException {
		int isInserted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IAdminQueryConstants.ADD_SHOW);    
			prepareStatement.setInt(1,show.getShowId()); 
			prepareStatement.setTime(2, show.getShowStartTime());
			prepareStatement.setTime(3, show.getShowEndTime());
			prepareStatement.setString(4, show.getShowName());
			prepareStatement.setString(5, show.getMovieName());
			prepareStatement.setInt(6,show.getScreenId());
			prepareStatement.setInt(7, show.getTheatreId());
			prepareStatement.setInt(8, show.getMovieId());
			isInserted = prepareStatement.executeUpdate();  
			}catch(SQLException e){ 
				throw new OMTSException("problem inserting Show Details into Database");
			}finally {
				try {
					connection.close();
				}catch(SQLException e) {
					throw new OMTSException("problem while closing Database");
				}
			}
		return isInserted;
	}

	@Override
	public int deleteShow(int showId) throws OMTSException {
		// TODO Auto-generated method stub
		int isDeleted = 0;
		try {
		connection = DBConnection.getConnection();
		prepareStatement=connection.prepareStatement(IAdminQueryConstants.DELETE_SHOW);    
		prepareStatement.setInt(1,showId);  
		isDeleted = prepareStatement.executeUpdate();  
		}catch(SQLException e){ 
			throw new OMTSException("problem while deleting Show Details from Database");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
	return isDeleted;
	}

	@Override
	public List<Show> getShowByName(String showName) throws OMTSException {
		// TODO Auto-generated method stub
		List<Show> showList = new ArrayList<Show>();
		try {
			connection  = DBConnection.getConnection();
			prepareStatement =connection.prepareStatement(IAdminQueryConstants.GET_SHOW_BY_NAME); 
			prepareStatement.setString(1, showName);
			resultSet = prepareStatement.executeQuery();  
				while(resultSet.next())   {
					Show show = new Show();
					show.setShowId(resultSet.getInt(1));
					show.setShowStartTime(resultSet.getTime(2));
					show.setShowEndTime(resultSet.getTime(3));
					show.setShowName(resultSet.getString(4));
					show.setMovieName(resultSet.getString(5));
					show.setScreenId(resultSet.getInt(6));
					show.setTheatreId(resultSet.getInt(7));
					show.setMovieId(resultSet.getInt(8));
					showList.add(show); 
				}
			}catch(SQLException e){ 
				throw new OMTSException("problem while displaying Show Data from Database");
			}finally {
				try {
					connection.close();
				}catch(SQLException e) {
					throw new OMTSException("problem while closing Database");
				}
			}
				
		return showList;

	}

	
	
	
	@Override
	public Boolean addMovie(Movie movie, Integer theatreId) throws OMTSException {
		connection = DBConnection.getConnection();
		int rows = 0;
		try {
			prepareStatement = connection.prepareStatement(ADD_MOVIE);
			prepareStatement.setInt(1, movie.getMovieId());
			prepareStatement.setString(2, movie.getMovieName());
			prepareStatement.setString(3, movie.getMovieGenre());
			prepareStatement.setString(4, movie.getMovieDirector());
			prepareStatement.setInt(5, movie.getMovieLength());
			prepareStatement.setString(6, movie.getLanguage());
			prepareStatement.setDate(7, movie.getMovieReleaseDate());
			//statement.setBlob(8, inputStream);
			prepareStatement.setInt(8, theatreId); 
			
			rows = prepareStatement.executeUpdate();
			if(rows > 0) 
				return true;
			
		} catch(SQLException e){
			throw new OMTSException("Failed to add movie details!! "+e);
			
		}
		finally{
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				throw new OMTSException("Failed to close the database connection" +e);
			}
		}
		return false;
	}

	@Override
	public int deleteMovie(Integer movieId) throws OMTSException {
		connection = DBConnection.getConnection();
		int rows = 0;
		try {
			prepareStatement = connection.prepareStatement(DELETE_MOVIE);
			prepareStatement.setInt(1, movieId);
			rows = prepareStatement.executeUpdate();
			return rows;
		} catch (SQLException e) {

			throw new OMTSException("Failed to delete the movie with Id: "+movieId);
			
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
					throw new OMTSException("Failed to close the database connection" +e);
			}
		}
	}
	
	@Override
	public ArrayList<Movie> getMovieDetailsToDelete() throws OMTSException{
		connection = DBConnection.getConnection();
		Movie movie = null;
		ArrayList<Movie> movieList = null;
		try {
			prepareStatement = connection.prepareStatement(DISPLAY_ALL_MOVIES_DELETE);
			prepareStatement.executeQuery();
			resultSet = prepareStatement.getResultSet();
			movieList = new ArrayList<Movie>();
			
			while(resultSet.next()) {
				movie = new Movie();
				movie.setMovieId(resultSet.getInt(1));
				movie.setMovieName(resultSet.getString(2));
				movie.setTheatreId(resultSet.getInt(3));
				movie.setTheatreName(resultSet.getString(4));
				movie.setTheatreCity(resultSet.getString(5));
				movieList.add(movie);
			}
			
			return movieList;
		} catch (SQLException e) {
			
			throw new OMTSException("Failed to get the movie details"+ e);
			
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				
				throw new OMTSException("Failed to close the database connection" +e);
				
			}
		}
		
	}
	
	@Override
	public ArrayList<Theatre> getTheatreDetails(String theatreCity) throws OMTSException{
		connection = DBConnection.getConnection();
		
		ArrayList<Theatre> theatreDetails = null;
		Theatre theatre = null;
		try {
			prepareStatement = connection.prepareStatement(GET_THEATRE_DETAILS);
			prepareStatement.setString(1, theatreCity);
			prepareStatement.executeQuery();
			resultSet = prepareStatement.getResultSet();
			
			theatreDetails = new ArrayList<Theatre>();
			
			while(resultSet.next()){
				theatre = new Theatre();
				theatre.setTheatreId(resultSet.getInt(1));
				theatre.setTheatreName(resultSet.getString(2));
				theatreDetails.add(theatre);
			}
			
			return theatreDetails;
			
		} catch (SQLException e) {
			
			throw new OMTSException("Failed to get the theatre details");
			
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				
				throw new OMTSException("Failed to close the database connection" +e);
			}			
			
		}
				
		
	}

	

	@Override
	public Boolean addScreen(Screen screen, Integer theatreId) throws OMTSException {
		connection = DBConnection.getConnection();
		int rows = 0;
		try {
			prepareStatement = connection.prepareStatement(ADD_SCREEN);
			prepareStatement.setInt(1, screen.getScreenId());
			prepareStatement.setInt(2, theatreId);
			prepareStatement.setString(3, screen.getScreenName());
			prepareStatement.setInt(4, screen.getRows());
			prepareStatement.setInt(5, screen.getColumns());
			rows = prepareStatement.executeUpdate();
			if(rows > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			
			throw new OMTSException("Failed to add the screen\n"+e);
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				
				throw new OMTSException("Failed to close the database connection"+ e);
			}
		}
		return false;
	}

	@Override
	public Boolean deleteScreen(Integer screenId) throws OMTSException {
		connection = DBConnection.getConnection();
		int rows = 0;
		try {
			prepareStatement = connection.prepareStatement(DELETE_SCREEN);
			prepareStatement.setInt(1, screenId);
			rows = prepareStatement.executeUpdate();
			if(rows > 0)
				return true;
		} catch (SQLException e) {
			
			throw new OMTSException("Failed to delete the screen with Id: "+screenId);
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				
				throw new OMTSException("Failed to get the screen details"+ e);
			}
		}
		return false;
	}

	@Override
	public ArrayList<Screen> getScreenDetailsToDelete() throws OMTSException{
		connection = DBConnection.getConnection();
		Screen screen = null;
		ArrayList<Screen> screenList = null;
		try {
			prepareStatement = connection.prepareStatement(DISPLAY_ALL_SCREEN_DELETE);
			prepareStatement.executeQuery();
			resultSet = prepareStatement.getResultSet();
			screenList = new ArrayList<Screen>();
			
			while(resultSet.next()) {
				screen = new Screen();
				screen.setScreenId(resultSet.getInt(1));
				screen.setScreenName(resultSet.getString(2));
				screen.setTheatreId(resultSet.getInt(3));
				screen.setTheatreName(resultSet.getString(4));
				screen.setTheatreCity(resultSet.getString(5));
				screenList.add(screen);
			}
			
			return screenList;
		} catch (SQLException e) {
			
			throw new OMTSException("Failed to get the screen details"+ e);
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				
				throw new OMTSException("Failed to close the database connection" +e);
			}
		}
	}
	@Override
	public String validateLogin(Customer customer) throws OMTSException {
		// TODO Auto-generated method stub
		boolean status=false;
		String roleCode="";
		try {
			connection=DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IQueryConstants.VALIDATE);
			prepareStatement.setInt(1, customer.getCustomerId());
			prepareStatement.setString(2, customer.getCustomerPassword());
			ResultSet rs = prepareStatement.executeQuery();
			if(rs.next())
			{
				roleCode=rs.getString(1);
			}
		}catch (SQLException e) {
			System.out.println("Failed to get the login"+ e);
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				System.out.println("Failed to close the database connection" +e);
			}
		}
		
		return roleCode;
	}

	@Override
	public int register(Customer customer) throws OMTSException {
		// TODO Auto-generated method stub
		int rows=0;
		int error=-1;
		try {
			connection=DBConnection.getConnection();
			PreparedStatement ps = connection.prepareStatement(IQueryConstants.REGISTER);
			ps.setInt(1,customer.getCustomerId());
			ps.setString(2,customer.getCustomerName());
			Date date=customer.getDateOfBirth();
		    ps.setDate(4, customer.getDateOfBirth());
		    ps.setString(3,customer.getCustomerPassword());
			ps.setInt(5,customer.getCustomerContact());
			ps.setString(6,customer.getRoleCode());
			rows=ps.executeUpdate();
		}catch (SQLException e) {
			System.out.println("Failed to get the login"+ e);
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				System.out.println("Failed to close the database connection" +e);
			}
		}
		
		return rows;
	}

	@Override
	public int getMovieLength(int movieId) throws OMTSException {
		// TODO Auto-generated method stub
				connection = DBConnection.getConnection();
				int movieLength = 0;
				try {
					prepareStatement = connection.prepareStatement(IAdminQueryConstants.GET_MOVIELENGTH);
					prepareStatement.setInt(1, movieId);
					ResultSet resultSet = prepareStatement.executeQuery();
					while(resultSet.next())   {
						movieLength = resultSet.getInt(1);
					//System.out.println(rs.getInt(1)+"  "+rs.getTime(2)+"  "+rs.getTime(3)+" "+rs.getString(4));  
					}
				} catch (SQLException e) {
					System.out.println("Failed to retrieve movie length from movie "+movieId);
				} finally {
					try {
						connection.close();
						prepareStatement.close();
					} catch (SQLException e) {
						System.out.println("Failed to close the database connection" +e);
					}
				}
				return movieLength;

	}
	@Override
	public List<Integer> getScreenFromMovieAndTheatre(int theatreId, int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		List<Integer> screenList = new ArrayList<Integer>();
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IAdminQueryConstants.GET_SCREEN_FROM_MOVIE_AND_THEATRE);
			prepareStatement.setInt(1, movieId);
			prepareStatement.setInt(2, theatreId);
			ResultSet resultSet = prepareStatement.executeQuery();
			int screenId = 0;
			while(resultSet.next())   {
				screenId = resultSet.getInt(1); 
				screenList.add(screenId);
			}
		}catch (SQLException e) {
			System.out.println("Failed to retrieve screen Id  from movie and theatre");
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				System.out.println("Failed to close the database connection" +e);
			}
		}
		return screenList;
	}

	@Override
	public String getMovieNameById(int movieId) throws OMTSException{
		// TODO Auto-generated method stub
		String movieName="";
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IAdminQueryConstants.GET_MOVIENAME_BY_FROM_MOVIE);
			prepareStatement.setInt(1, movieId);
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next())   {
				movieName = resultSet.getString(1);
			}
		}catch (SQLException e) {
			System.out.println("Failed to retrieve screen Id  from movie and theatre");
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				System.out.println("Failed to close the database connection" +e);
			}
		}
	
		return movieName;
	}
	@Override
	public String checkShowNameandScreenId(String showName, int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		String existShowName="";
		int existScreenId = 0;
		String exist = "";
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IAdminQueryConstants.CHECK_SHOWNAME_AND_SCREENID);
			prepareStatement.setString(1, showName);
			prepareStatement.setInt(2, screenId);
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next())   {
				existShowName = resultSet.getString(1);
				existScreenId = resultSet.getInt(2);
				exist = existShowName +"" + existScreenId;
			}
		}catch (SQLException e) {
			System.out.println("Failed to retrieve screenId and showname  from showdetails");
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				System.out.println("Failed to close the database connection" +e);
			}
		}
			return exist;
	}

	public static boolean checkTransaction() throws SQLException, OMTSException {
		connection = DBConnection.getConnection();
		prepareStatement = connection.prepareStatement(IQueryConstants.CHECK_TRANSACTION);
		resultSet = prepareStatement.executeQuery();
		if(resultSet.next())
			return true;
		return false;
	}
	
	public static int getMaxTransactionId() throws SQLException, OMTSException {
		connection = DBConnection.getConnection();
		prepareStatement = connection.prepareStatement(IQueryConstants.MAX_TRANSACTION_ID);
		resultSet = prepareStatement.executeQuery();
		int maxId=0;
		if(resultSet.next())
		 maxId = resultSet.getInt(1);
		return maxId;
	}
}

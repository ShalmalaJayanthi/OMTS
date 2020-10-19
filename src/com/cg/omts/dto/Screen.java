package com.cg.omts.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

public class Screen {
	
	
	
		private int screenId;
		private int theatreId;
		private String screenName;
		private Show[] showList;
		private Date movieEndDate;
		private int rows;
		private int columns;
		private String theatreName;
		private String theatreCity;
		private int seatPrice;
		
		public Screen() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Screen(int screenId, int theatreId, String screenName, Show[] showList, Date movieEndDate, int rows,
				int columns) {
			super();
			this.screenId = screenId;
			this.theatreId = theatreId;
			this.screenName = screenName;
			this.showList = showList;
			this.movieEndDate = movieEndDate;
			this.rows = rows;
			this.columns = columns;
		}
		public Screen(int screenId, String screenName, int screenRows, int screenColumns) {
			this.screenId = screenId;
			this.screenName = screenName;
			this.rows = screenRows;
			this.columns = screenColumns;
			
		}
		
		
		public int getSeatPrice() {
			return seatPrice;
		}
		public void setSeatPrice(int seatPrice) {
			this.seatPrice = seatPrice;
		}
		public Screen(int screenId, String screenName, int rows, int columns, int seatPrice) {
			super();
			this.screenId = screenId;
			this.screenName = screenName;
			this.rows = rows;
			this.columns = columns;
			this.seatPrice = seatPrice;
		}
		public Screen(int screenId, String screenName, Date movieEndDate, int screenRows,
				int screenColumns) {
			this.screenId = screenId;
			this.theatreId = theatreId;
			this.screenName = screenName;
			this.showList = showList;
			this.movieEndDate = movieEndDate;
			this.rows = rows;
			this.columns = columns;
			
		}
		public int getScreenId() {
			return screenId;
		}
		public void setScreenId(int screenId) {
			this.screenId = screenId;
		}
		public int getTheatreId() {
			return theatreId;
		}
		public void setTheatreId(int theatreId) {
			this.theatreId = theatreId;
		}
		public String getScreenName() {
			return screenName;
		}
		public void setScreenName(String screenName) {
			this.screenName = screenName;
		}
		public Show[] getShowList() {
			return showList;
		}
		public void setShowList(Show[] showList) {
			this.showList = showList;
		}
		public Date getMovieEndDate() {
			return movieEndDate;
		}
		public void setMovieEndDate(Date movieEndDate) {
			this.movieEndDate = movieEndDate;
		}
		public int getRows() {
			return rows;
		}
		public void setRows(int rows) {
			this.rows = rows;
		}
		public int getColumns() {
			return columns;
		}
		public void setColumns(int columns) {
			this.columns = columns;
		}
		
		
		public String getTheatreName() {
			return theatreName;
		}
		public void setTheatreName(String theatreName) {
			this.theatreName = theatreName;
		}
		public String getTheatreCity() {
			return theatreCity;
		}
		public void setTheatreCity(String theatreCity) {
			this.theatreCity = theatreCity;
		}
		@Override
		public String toString() {
			return "Screen [screenId=" + screenId + ", theatreId=" + theatreId + ", screenName=" + screenName
					+ ", showList=" + Arrays.toString(showList) + ", movieEndDate=" + movieEndDate + ", rows=" + rows
					+ ", columns=" + columns + "]";
		}
		
}

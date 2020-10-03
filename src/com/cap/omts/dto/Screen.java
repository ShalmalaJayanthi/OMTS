package com.cap.omts.dto;

import java.time.LocalDate;
import java.util.Arrays;

public class Screen {
		private int screenId;
		private int theatreId;
		private String screenName;
		private Show[] showList;
		private LocalDate movieEndDate;
		private int rows;
		private int columns;
		public Screen() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Screen(int screenId, int theatreId, String screenName, Show[] showList, LocalDate movieEndDate, int rows,
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
		public LocalDate getMovieEndDate() {
			return movieEndDate;
		}
		public void setMovieEndDate(LocalDate movieEndDate) {
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
		@Override
		public String toString() {
			return "Screen [screenId=" + screenId + ", theatreId=" + theatreId + ", screenName=" + screenName
					+ ", showList=" + Arrays.toString(showList) + ", movieEndDate=" + movieEndDate + ", rows=" + rows
					+ ", columns=" + columns + "]";
		}
		
}

package com.cap.omts.dto;

import java.sql.Time;
import java.util.Arrays;

public class Show {
		private int showId;
		private Time showStartTime;
		private Time showEndTime;
		private Seat[] seats;
		private String showName;
		private Movie movieName;
		private int screenId;
		private int theatreId;
		public Show() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Show(int showId, Time showStartTime, Time showEndTime, Seat[] seats, String showName, Movie movieName,
				int screenId, int theatreId) {
			super();
			this.showId = showId;
			this.showStartTime = showStartTime;
			this.showEndTime = showEndTime;
			this.seats = seats;
			this.showName = showName;
			this.movieName = movieName;
			this.screenId = screenId;
			this.theatreId = theatreId;
		}
		
		public int getShowId() {
			return showId;
		}
		public void setShowId(int showId) {
			this.showId = showId;
		}
		public Time getShowStartTime() {
			return showStartTime;
		}
		public void setShowStartTime(Time showStartTime) {
			this.showStartTime = showStartTime;
		}
		public Time getShowEndTime() {
			return showEndTime;
		}
		public void setShowEndTime(Time showEndTime) {
			this.showEndTime = showEndTime;
		}
		public Seat[] getSeats() {
			return seats;
		}
		public void setSeats(Seat[] seats) {
			this.seats = seats;
		}
		public String getShowName() {
			return showName;
		}
		public void setShowName(String showName) {
			this.showName = showName;
		}
		public Movie getMovieName() {
			return movieName;
		}
		public void setMovieName(Movie movieName) {
			this.movieName = movieName;
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
		
		@Override
		public String toString() {
			return "Show [showId=" + showId + ", showStartTime=" + showStartTime + ", showEndTime=" + showEndTime
					+ ", seats=" + Arrays.toString(seats) + ", showName=" + showName + ", movieName=" + movieName
					+ ", screenId=" + screenId + ", theatreId=" + theatreId + "]";
		}
}

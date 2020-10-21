package com.cg.omts.dto;

import java.sql.Time;
import java.util.Arrays;

public class Show {
		private int showId;
		private Time showStartTime;
		private Time showEndTime;
		private Seat[] seats;
		private String showName;
		private String movieName;
		private int screenId;
		private int theatreId;
		private int movieId;
		public Show() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Show(int showId, Time showStartTime, Time showEndTime, Seat[] seats, String showName, String movieName,
				int screenId, int theatreId, int movieId) {
			super();
			this.showId = showId;
			this.showStartTime = showStartTime;
			this.showEndTime = showEndTime;
			this.seats = seats;
			this.showName = showName;
			this.movieName = movieName;
			this.screenId = screenId;
			this.theatreId = theatreId;
			this.movieId = movieId;
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
		public String getMovieName() {
			return movieName;
		}
		public void setMovieName(String movieName) {
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
		public int getMovieId() {
			return movieId;
		}
		public void setMovieId(int movieId) {
			this.movieId = movieId;
		}
		@Override
		public String toString() {
			return "Show [showId=" + showId + ", showStartTime=" + showStartTime + ", showEndTime=" + showEndTime
					+ ", seats=" + Arrays.toString(seats) + ", showName=" + showName + ", movieName=" + movieName
					+ ", screenId=" + screenId + ", theatreId=" + theatreId + ", movieId=" + movieId + "]";
		}
		
}

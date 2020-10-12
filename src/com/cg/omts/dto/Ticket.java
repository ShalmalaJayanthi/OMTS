package com.cg.omts.dto;

import java.util.Arrays;


public class Ticket {
	
		public enum TicketStatus {
			INPROCESS, BOOKED, CANCELLED;
		}
		private int ticketId;
		private int noOfSeats;
		private TicketStatus ticketStatus;
		private int screenId;
		private int theatreId;
		private int showId;
		private int movieId;
		
		public Ticket() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Ticket(int ticketId, int noOfSeats, TicketStatus ticketStatus, int screenId, int theatreId, int showId,
				int movieId) {
			super();
			this.ticketId = ticketId;
			this.noOfSeats = noOfSeats;
			this.ticketStatus = ticketStatus;
			this.screenId = screenId;
			this.theatreId = theatreId;
			this.showId = showId;
			this.movieId = movieId;
		}

		public int getTicketId() {
			return ticketId;
		}

		public void setTicketId(int ticketId) {
			this.ticketId = ticketId;
		}

		public int getNoOfSeats() {
			return noOfSeats;
		}

		public void setNoOfSeats(int noOfSeats) {
			this.noOfSeats = noOfSeats;
		}

		public TicketStatus getTicketStatus() {
			return ticketStatus;
		}

		public void setTicketStatus(TicketStatus ticketStatus) {
			this.ticketStatus = ticketStatus;
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

		public int getShowId() {
			return showId;
		}

		public void setShowId(int showId) {
			this.showId = showId;
		}

		public int getMovieId() {
			return movieId;
		}

		public void setMovieId(int movieId) {
			this.movieId = movieId;
		}

		@Override
		public String toString() {
			return "Ticket [ticketId=" + ticketId + ", noOfSeats=" + noOfSeats + ", ticketStatus=" + ticketStatus
					+ ", screenId=" + screenId + ", theatreId=" + theatreId + ", showId=" + showId + ", movieId="
					+ movieId + "]";
		}	
		
}

package com.cg.omts.dto;

import java.util.Arrays;

public class Ticket {
		private int ticketId;
		private int noOfSeats;
		private String[] seatName;
		private Booking bookingRef;
		private boolean ticketStatus;
		private String screenName;
		
		public Ticket() {
			super();
			// TODO Auto-generated constructor stub
		}
		//constructor
		public Ticket(int ticketId, int noOfSeats, String[] seatName, Booking bookingRef, boolean ticketStatus,
				String screenName) {
			super();
			this.ticketId = ticketId;
			this.noOfSeats = noOfSeats;
			this.seatName = seatName;
			this.bookingRef = bookingRef;
			this.ticketStatus = ticketStatus;
			this.screenName = screenName;
		}
		//getters and setters
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
		public String[] getSeatName() {
			return seatName;
		}
		public void setSeatName(String[] seatName) {
			this.seatName = seatName;
		}
		public Booking getBookingRef() {
			return bookingRef;
		}
		public void setBookingRef(Booking bookingRef) {
			this.bookingRef = bookingRef;
		}
		public boolean isTicketStatus() {
			return ticketStatus;
		}
		public void setTicketStatus(boolean ticketStatus) {
			this.ticketStatus = ticketStatus;
		}
		public String getScreenName() {
			return screenName;
		}
		public void setScreenName(String screenName) {
			this.screenName = screenName;
		}
		//tostring method
		@Override
		public String toString() {
			return "Ticket [ticketId=" + ticketId + ", noOfSeats=" + noOfSeats + ", seatName="
					+ Arrays.toString(seatName) + ", bookingRef=" + bookingRef + ", ticketStatus=" + ticketStatus
					+ ", screenName=" + screenName + "]";
		}
		
		
}

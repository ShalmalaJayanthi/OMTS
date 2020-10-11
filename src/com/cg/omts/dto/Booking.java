package com.cg.omts.dto;

import java.sql.Date;
import java.util.Arrays;

public class Booking {
		private int bookingId;
		private Date bookingDate;
		private int ticketId;
		private int transactionId;
		
		public Booking() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Booking(int bookingId, Date bookingDate, int ticketId, int transactionId) {
			super();
			this.bookingId = bookingId;
			this.bookingDate = bookingDate;
			this.ticketId = ticketId;
			this.transactionId = transactionId;
		}
		public int getBookingId() {
			return bookingId;
		}
		public void setBookingId(int bookingId) {
			this.bookingId = bookingId;
		}
		public Date getBookingDate() {
			return bookingDate;
		}
		public void setBookingDate(Date bookingDate) {
			this.bookingDate = bookingDate;
		}
		public int getTicketId() {
			return ticketId;
		}
		public void setTicketId(int ticketId) {
			this.ticketId = ticketId;
		}
		public int getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(int transactionId) {
			this.transactionId = transactionId;
		}
		@Override
		public String toString() {
			return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", ticketId=" + ticketId
					+ ", transactionId=" + transactionId + "]";
		}
		
}

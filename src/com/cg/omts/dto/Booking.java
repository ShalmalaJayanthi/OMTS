package com.cg.omts.dto;

import java.sql.Date;
import java.util.Arrays;

public class Booking {
		private int bookingId;
		private Date bookingDate;
		
		public Booking() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Booking(int bookingId, Date bookingDate) {
			super();
			this.bookingId = bookingId;
			this.bookingDate = bookingDate;
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

		@Override
		public String toString() {
			return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + "]";
		}
		
}

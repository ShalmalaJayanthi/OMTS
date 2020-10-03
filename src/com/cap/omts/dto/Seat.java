package com.cap.omts.dto;
enum BookingState {
	Available, Blocked, Booked; 
}
public class Seat {
		private int seatId;
		private double seatPrice;
		private BookingState bookingState;
		
		public Seat() {
			super();
			// TODO Auto-generated constructor stub
		}
		//constructor
		public Seat(int seatId, double seatPrice, BookingState bookingState) {
			super();
			this.seatId = seatId;
			this.seatPrice = seatPrice;
			this.bookingState = bookingState;
		}
		//getters and setters
		public int getSeatId() {
			return seatId;
		}
		public void setSeatId(int seatId) {
			this.seatId = seatId;
		}
		public double getSeatPrice() {
			return seatPrice;
		}
		public void setSeatPrice(double seatPrice) {
			this.seatPrice = seatPrice;
		}
		public BookingState getBookingState() {
			return bookingState;
		}
		public void setBookingState(BookingState bookingState) {
			this.bookingState = bookingState;
		}
		//tostring
		@Override
		public String toString() {
			return "Seat [seatId=" + seatId + ", seatPrice=" + seatPrice + ", bookingState=" + bookingState + "]";
		}
		
}

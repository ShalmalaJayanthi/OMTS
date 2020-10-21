package com.cg.omts.dto;

public class Seat {
	public enum SeatStatus {
		AVAILABLE, BLOCKED, BOOKED; 
	}
		private int seatId;
		private double seatPrice;
		private SeatStatus seatBookingState;
		
		public Seat() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Seat(int seatId, double seatPrice, SeatStatus seatBookingState) {
			super();
			this.seatId = seatId;
			this.seatPrice = seatPrice;
			this.seatBookingState = seatBookingState;
		}

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

		public SeatStatus getBookingState() {
			return seatBookingState;
		}

		public void setBookingState(SeatStatus seatBookingState) {
			this.seatBookingState = seatBookingState;
		}

		@Override
		public String toString() {
			return "Seat [seatId=" + seatId + ", seatPrice=" + seatPrice + ", bookingState=" + seatBookingState + "]";
		}
		
		
}

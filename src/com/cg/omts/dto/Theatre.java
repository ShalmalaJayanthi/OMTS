package com.cg.omts.dto;

import java.util.Arrays;

public class Theatre {
		private int theatreId;
		private String theatreName;
		private String theatreCity;
		private Movie[] movies;
		private Screen[] listOfScreens;
		private String managerName;
		private String managerContact;
		public Theatre() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Theatre(int theatreId, String theatreName, String theatreCity, Movie[] movies, Screen[] listOfScreens,
				String managerName, String managerContact) {
			super();
			this.theatreId = theatreId;
			this.theatreName = theatreName;
			this.theatreCity = theatreCity;
			this.movies = movies;
			this.listOfScreens = listOfScreens;
			this.managerName = managerName;
			this.managerContact = managerContact;
		}
		
		public int getTheatreId() {
			return theatreId;
		}
		public void setTheatreId(int theatreId) {
			this.theatreId = theatreId;
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
		public Movie[] getMovies() {
			return movies;
		}
		public void setMovies(Movie[] movies) {
			this.movies = movies;
		}
		public Screen[] getListOfScreens() {
			return listOfScreens;
		}
		public void setListOfScreens(Screen[] listOfScreens) {
			this.listOfScreens = listOfScreens;
		}
		public String getManagerName() {
			return managerName;
		}
		public void setManagerName(String managerName) {
			this.managerName = managerName;
		}
		public String getManagerContact() {
			return managerContact;
		}
		public void setManagerContact(String managerContact) {
			this.managerContact = managerContact;
		}
		
		@Override
		public String toString() {
			return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreCity=" + theatreCity
					+ ", movies=" + Arrays.toString(movies) + ", listOfScreens=" + Arrays.toString(listOfScreens)
					+ ", managerName=" + managerName + ", managerContact=" + managerContact + "]";
		}
}

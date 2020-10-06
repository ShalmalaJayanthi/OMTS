package com.cg.omts.dto;

import java.sql.Date;

public class Movie {
		private int movieId;
		private String movieName;
		private String movieGenre;
		private String movieDirector;
		private int movieLength;
		private String language;
		private Date movieReleaseDate;
		
		public Movie() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Movie(int movieId, String movieName, String movieGenre, String movieDirector, int movieLength,
				String language, Date movieReleaseDate) {
			super();
			this.movieId = movieId;
			this.movieName = movieName;
			this.movieGenre = movieGenre;
			this.movieDirector = movieDirector;
			this.movieLength = movieLength;
			this.language = language;
			this.movieReleaseDate = movieReleaseDate;
		}

		public int getMovieId() {
			return movieId;
		}

		public void setMovieId(int movieId) {
			this.movieId = movieId;
		}

		public String getMovieName() {
			return movieName;
		}

		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}

		public String getMovieGenre() {
			return movieGenre;
		}

		public void setMovieGenre(String movieGenre) {
			this.movieGenre = movieGenre;
		}

		public String getMovieDirector() {
			return movieDirector;
		}

		public void setMovieDirector(String movieDirector) {
			this.movieDirector = movieDirector;
		}

		public int getMovieLength() {
			return movieLength;
		}

		public void setMovieLength(int movieLength) {
			this.movieLength = movieLength;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public Date getMovieReleaseDate() {
			return movieReleaseDate;
		}

		public void setMovieReleaseDate(Date mmovieReleaseDate) {
			movieReleaseDate = mmovieReleaseDate;
		}

		@Override
		public String toString() {
			return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieGenre=" + movieGenre
					+ ", movieDirector=" + movieDirector + ", movieLength=" + movieLength + ", language=" + language
					+ ", MovieReleaseDate=" + movieReleaseDate + "]";
		}
		
		
}

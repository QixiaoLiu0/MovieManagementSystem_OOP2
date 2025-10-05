package sait.mms.utils;

import sait.mms.problemdomain.Movie;

public class Validator {

  
  public static boolean validateMovie(Movie movie) {
  	if (movie == null) {
  		return false;
  	}
  	if (movie.getDuration() <= 0) {
        return false;
    }
  	if (movie.getYear() <= 0) {
        return false;
    }
      return true;
  }
  
  
}
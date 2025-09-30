package sait.mms.application;

import sait.mms.managers.MovieManagementSystem;

public class AppDriver {
	public static void main(String[] args) throws Exception {
		MovieManagementSystem mms = new MovieManagementSystem("res/movies.txt");
		mms.run();
	}
}

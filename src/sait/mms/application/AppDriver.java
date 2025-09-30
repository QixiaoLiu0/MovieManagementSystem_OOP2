package sait.mms.application;

import sait.mms.managers.MovieManagementSystem;

public class AppDriver {
	public static void main(String[] args) throws Exception {
		//TODO create a MovieManagementSystem instance and call its "run" method
		MovieManagementSystem mms = new MovieManagementSystem("res/movies.txt");
		mms.run();
	}
}

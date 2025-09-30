package sait.mms.managers;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sait.mms.problemdomain.Movie;

public class MovieManagementSystem {
	private List<Movie> movies;
	private Scanner scanner;
	private String filename;

	public MovieManagementSystem(String filename) throws Exception {
		movies = new ArrayList<>();
		scanner = new Scanner(System.in);

		this.filename = filename;
		
		// TODO  call loadMovieList(filename);
	}

	public void saveMovieList(String filename) throws Exception {
		//TODO save movies to file
		
	}

	public void displayMenu() {
		System.out.println("Movie Management system");
		System.out.println("1     Add New Movie and Save");
		System.out.println("2     Generate List of Movies Released in a Year");
		System.out.println("3     Generate List of Random Movies");
		System.out.println("4     Exit");
		System.out.print("Enter an option: ");
	}

	public void addMovie() throws Exception {
		// TODO: add new movies and save, don't forget validating user-input data through Validator class.

	}

	
	public void loadMovieList(String filename) throws Exception {
	// TODO: load movies from file
	}
	
	
	

	public void generateMovieListInYear() {
		// TODO: Generate movies in specific year.
	}

	public void generateRandomMovieList() {
		 // TODO: generate random movies
	}

	
	
	
	
	
	
	
	
	
	
	
	// run
	public void run() throws Exception {
		boolean running = true;
		while (running) {
			displayMenu();

			int opt = scanner.nextInt();
			switch (opt) {
				case 1:
					addMovie();
					break;
				case 2:
					generateMovieListInYear();
					break;
				case 3:
					generateRandomMovieList();
					break;
				case 4:
					running = false;
					break;
				default:
					System.out.println("Invalid option! ");
					System.out.println("Please enter again.");
					break;
			}
			System.out.println();
		}
	}

}

package sait.mms.managers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import sait.mms.problemdomain.Movie;
import sait.mms.utils.Validator;

public class MovieManagementSystem {
	private List<Movie> movies;
	private Scanner scanner;
	private String filename;

	public MovieManagementSystem(String filename) throws Exception {
		movies = new ArrayList<>();
		scanner = new Scanner(System.in);

		this.filename = filename;
		loadMovieList(filename);
	}

	public void saveMovieList(String filename) throws Exception {
		try (FileWriter writer = new FileWriter(filename)) {
	    for (int i = 0; i < movies.size(); i++) {
	        Movie m = movies.get(i);
	        writer.write(m.getDuration() + "," + m.getTitle() + "," + m.getYear() + "\n");
	    }
	} catch (IOException e) {
	    System.out.println("Error saving movies: " + e.getMessage());
	}
		
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
		boolean addFail = true;

		while (addFail) {
			System.out.print("Enter duration: ");
			int duration = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Enter title: ");
			String title = scanner.nextLine();

			System.out.print("Enter year: ");
			int year = scanner.nextInt();

			Movie movie = new Movie(duration, title, year);

			System.out.println("Saving movies... ");

			if (Validator.validateMovie(movie)) {
				movies.add(movie);
				saveMovieList(filename);
				System.out.println("Added movie to the data file.");
				addFail = false;
				break;
			} else {
				System.out.println("Invalid movie input! Try again.");
			}
		}

	}

	
	public void loadMovieList(String filename) throws Exception {
		File f = new File(filename);
		if (!f.exists()) {
			
			return;
		}

		
		Scanner fs = new Scanner(f);
		while (fs.hasNextLine()) {
			String line = fs.nextLine().trim();
			if (line.isEmpty()) continue;
			
			String[] parts = line.split(",");
			if(parts.length < 3) continue; // skip the error line

			// duration title year
			int duration = Integer.parseInt(parts[0].trim());
			String title = parts[1].trim();
			int year = Integer.parseInt(parts[2].trim());

			movies.add(new Movie(duration, title, year));
		}
		fs.close();
	}
	
	
	

	public void generateMovieListInYear() {
		System.out.println("Enter in year: ");
		int year = scanner.nextInt();

		int totalDuration = 0;
		System.out.println("Movie List");
		System.out.printf("%-10s %-6s %-50s%n", "Duration", "Year", "Title");

		for (int i = 0; i < movies.size(); i++) {
			Movie m = movies.get(i);
			if (m.getYear() == year) {
				System.out.printf("%-10d %-6d %-50s%n", m.getDuration(), m.getYear(), m.getTitle());;
				totalDuration += m.getDuration();
			}
		}
		System.out.println("Total duration: " + totalDuration + " minutes");
	}

	public void generateRandomMovieList() {
		if (movies.isEmpty()) {
			System.out.println("No movies available.");
			return;
		}

		System.out.print("Enter number of movies: ");
		int count = scanner.nextInt();

		// Avoid shuffling original table
		List<Movie> moviesCopy = new ArrayList<>(movies);
		Collections.shuffle(moviesCopy);

		// Avoid count > moviesCopy.size()
		int limit = Math.min(count, moviesCopy.size());
		int total = 0;

		System.out.println();
		System.out.println("Movie List");
		System.out.printf("%-10s %-6s %-50s%n", "Duration", "Year", "Title");;

		for (int i = 0; i < limit; i++) {
			Movie m = moviesCopy.get(i);
			System.out.printf("%-10d %-6d %-50s%n", m.getDuration(), m.getYear(), m.getTitle());
			total += m.getDuration();
		}

		System.out.println();
		System.out.println("Total duration: " + total + " minutes");
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

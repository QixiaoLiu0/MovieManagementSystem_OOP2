# Movie Management System (OOP2 - Group Assignment 1)
## Project Overview

1This project is the group assignment (Assignment 1) for the course SAIT - CPRG 211: Object-Oriented Programming 2.
The objective is to design and implement a menu-driven Movie Management System following the principles of object-oriented programming (OOP).

The system demonstrates the use of classes and objects, encapsulation, file I/O, collections (ArrayList), and input validation.

## Main features include:

- Load movie data from file

- Add new movies and save to file

- Generate list of movies released in a specific year

- Generate a random list of movies

- Menu-driven console interaction

## Team Members and Responsibilities

<b>Qixiao Liu</b>
- Implements MovieManagementSystem (core logic: load, save, add movies, generate lists). Responsible for project structure, GitHub repository setup, and collaboration management.

<b>Arshdeep Singh</b>
- Implements AppDriver (main entry point and program loop). Responsible for calling system functions and controlling overall program execution.

<b>Huajie Zeng</b>
- Implements Validator (input validation logic). Ensures correctness of user input and file data.

<b>Vishavjeet Singh</b>
- Implements Movie (data model: duration, title, year). Responsible for constructors, getters/setters, and the toString method.

## Features

- Add New Movie and Save

- User enters duration, title, and year.

- Validation is performed using Validator.

- The movie is stored in memory and appended to movies.txt.

- Generate List of Movies Released in a Year

- User inputs a year. Displays all movies released in that year and the total duration.

- Generate Random Movie List. User inputs a number N. Randomly selects N movies from the list and calculates the total duration.

- Exit Program: Terminates the program gracefully.

## Project Structure
```
src/
 └─ sait/mms/
    ├─ application/
    │   └─ AppDriver.java             # Program entry point (Arshdeep Singh)
    ├─ managers/
    │   └─ MovieManagementSystem.java # Core management logic (Qixiao Liu)
    ├─ problemdomain/
    │   └─ Movie.java                 # Data model (Vishavjeet Singh)
    └─ utils/
        └─ Validator.java              # Input validation (Huajie Zeng)

res/
 └─ movies.txt                         # Movie data file

```

## How to Run
### Running in Eclipse

1.  Clone the remote repository:



```
git clone https://github.com/QixiaoLiu0/MovieManagementSystem_OOP2.git
```

or


```
git clone git@github.com:QixiaoLiu0/MovieManagementSystem_OOP2.git
```



2.  Import into Eclipse:

- ```File``` → ```Import``` → ```Existing Projects into Workspace```

- Select the cloned repository folder

3.  Run ```AppDriver.java``` to start the program.

## Contribution Guidelines
### Branching Strategy

```main```: Stable branch containing only tested, working code.

```feature/<classname>```: Each member works on their own feature branch.

- Example: ```feature/movie```, ```feature/validator```

## Commit Message Convention

- Format:

```
[ClassName] Description
Example: [Movie] Implemented getters and setters
```


- Ensure the code compiles before committing.

## TODO

 - ⚪Complete implementation of assigned classes. 

 - ⚪Improve exception handling and user input validation.

 - ⚪Finalize and submit the project deliverables.

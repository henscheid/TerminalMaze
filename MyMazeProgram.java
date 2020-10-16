///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            MyMazeProgram
// Files:            MyMazeProgram.java, Config.java
// Semester:         CS302 Fall 2015
//
// Author:           Ian Henscheid	
// Email:            henscheid@wisc.edu
// CS Login:         henscheid
// Lecturer's Name:  Jim Williams
// Lab Section:      341

import java.util.Scanner;
import java.util.Random;

/**
 * MyMazeProgram class allows users to choose from a temperature converter,
 * simple robot maze and a random robot maze.  Each of the different options
 * can be selected at the main menu and the user will be sent back to the main
 * menu after completing whichever option they choose until they choose the
 * exit option.
 * 
 * @author Ian Henscheid
 */
public class MyMazeProgram {
	/**
	 * The method shares the same function as the class
	 */
	public static void main(String[] args){
		//Making the menu
		try (Scanner input = new Scanner(System.in)){
			// number chooses menu option
			int number = 0;
			System.out.println("Welcome to MyMazeProgram!");
			System.out.println(" ");
			// brings user back to main menu if exit option not chosen
			while (number != 4) {
				System.out.println("1. Temperature Converter");
				System.out.println("2. Simple Robot Maze");
				System.out.println("3. Random Robot Maze With Obstacles");
				System.out.println("4. Exit");
				System.out.print("Enter Choice: ");
				do {
					if (input.hasNextInt()) {
						number = input.nextInt();	
						// displays error message
						if (number < 1 || number > 4) {
							System.out.println
								("Sorry, I don't understand that");
							System.out.println(" ");
							System.out.println
								("1. Temperature Converter");
							System.out.println("2. Simple Robot Maze");
							System.out.println
								("3. Random Robot Maze With Obstacles");
							System.out.println("4. Exit");
							System.out.print("Enter Choice: ");
							input.nextLine();
						}
						input.nextLine();
					}
					// displays error message
					else { 
						System.out.println("Sorry, I don't understand that");
						System.out.println(" ");
						System.out.println("1. Temperature Converter");
						System.out.println("2. Simple Robot Maze");
						System.out.println
							("3. Random Robot Maze With Obstacles");
						System.out.println("4. Exit");
						System.out.print("Enter Choice: ");
						input.nextLine();
					}
				} while (number < 1 || number > 4);
				
				//Exit prompt
				if (number == 4)
					System.out.println("Live Long And Prosper!");
				//Temperature converter from fahrenheit to celcius
				if (number == 1) {
					System.out.print("Enter Fahrenheit temperature: ");
					/*fahrenheit is the input of the user and tells the compiler
					 * what double value it should convert to celcius
					 */
					double fahrenheit = 0;
					/* celcius is the output in degrees celcius after the 
					 * fahrenheit value has been converted
					 */
					double celcius;
						if (input.hasNextDouble()) {
							fahrenheit = input.nextDouble();
							celcius = (5.0/9) * (fahrenheit - 32);
							System.out.println(fahrenheit + "F=" + celcius + "C");
							System.out.println(" ");
							input.nextLine();
						}
						else {
							System.out.println("Can't convert " + input.nextLine()
									+ " to C" + "\n");
							input.nextLine();
						}
				}
				
				//Simple robot maze
				else if (number == 2) {	
					// robotRow declares the robots row location
					int robotRow = 0;
					// robotColumn declares the robots column location
					int robotColumn = 0;
					// exitRow declares the exit's row location
					int exitRow = 4;
					// exitRow declares the exit's row location
					int exitColumn = 4;
					// count keeps track of how many moves have been used
					int count = 0;
					while ((robotColumn*robotRow) != (exitColumn*exitRow)) {
						System.out.println("Help Robot (R) get to Exit (E)");
						for (int i = 0 ; i < 5 ; i++)
						{
							for (int j = 0 ; j < 5 ; j++) {
								if (j == exitRow && i == exitColumn) {
									System.out.print("E");
								}
								else if (j == robotRow && i == robotColumn) {
									System.out.print("R ");
								}
								else {
									System.out.print("o ");
								}
							}
							System.out.println(" ");				
						}
						System.out.println("1. up");
						System.out.println("2. down");
						System.out.println("3. left");
						System.out.println("4. right");
						System.out.print("Move? ");
						// move is used to choose an option which moves the 
						// robot
						int move = 0;
						if (input.hasNextInt()) {
							move = input.nextInt();
						}
						else {
							input.nextLine();
						}
						if (move == 1) {
							if (robotColumn != 0) {
								robotColumn--;
							}
						}
						else if (move == 2) {
							if (robotColumn != 4) {
							robotColumn++;
							}
						}
						else if (move == 3) {
							if (robotRow != 0) {
							robotRow--;
							}
						}
						else if (move == 4) {
							if (robotRow != 4) {
							robotRow++;
							}
						}
					count++;
					}
					System.out.println("Congratulations! Robot is Free!");
					System.out.println("It took " + count + " moves.");
					System.out.println(" ");
				}
				else if (number ==  3) {
					Random RNG = new Random(Config.SEED);
					int robotColumn = 0;
					int count = 0;
					System.out.println("How big is the maze? (" + Config.MIN + 
							"-" + Config.MAX +") ");
					// size is the user input for how big the maze is
					int size = 0;
					do {
						if (input.hasNextInt()) {
							size = input.nextInt();	
							if (size < Config.MIN || size > Config.MAX) {
								System.out.println
									("Must be between " + Config.MIN + " and " + 
											Config.MAX + ", inclusive.");
								System.out.println
									("How big is the maze? (" + Config.MIN + 
											"-" + Config.MAX +") ");
//								input.nextLine();
							}
						}
						else { 
							System.out.println("Must be between " + Config.MIN +
									" and " + Config.MAX + ", inclusive.");
							System.out.println("How big is the maze? (" + 
								Config.MIN + "-" + Config.MAX +") ");
//							input.nextLine();
						}
						input.nextLine();
					} while (size < Config.MIN || size > Config.MAX);
					int exitColumn = size - 1;
					System.out.println("Help Robot (R) get to Exit (E)");
					int exitRow = RNG.nextInt(size);
					int robotRow = RNG.nextInt(size);
					/* obstacleRow and obstacleColumn are used to place
					 * the random obstacle into the maze
					 */
					int obstacleRow = RNG.nextInt(size);
					int obstacleColumn = RNG.nextInt(size);
					
					while (robotColumn != exitColumn || robotRow != exitRow) {
						for (int i = 0 ; i < (size) ; i++)
						{
							for (int j = 0 ; j < (size) ; j++) {
								if (j == exitRow && i == (size-1)) {
									System.out.print("E ");
								}
								else if (j == robotRow && i == robotColumn) {
									System.out.print("R ");
								}
								else if 
									(j == obstacleRow && i == obstacleColumn) {
									System.out.print("X ");
								}
								else {
									System.out.print("o ");
								}
							}
							System.out.println(" ");				
						}
						System.out.println("1. up");
						System.out.println("2. down");
						System.out.println("3. left");
						System.out.println("4. right");
						System.out.print("Move? ");
						int move = 0;
						if (input.hasNextInt()) {
							move = input.nextInt();
							input.nextLine();
						}
						else {
							input.nextLine();
						}
						if (move == 1) {
							if (robotColumn == 0) {
								robotColumn = robotColumn + 0;
							}
							else if (robotColumn == obstacleColumn + 1 &&
									obstacleRow == robotRow) {
								robotColumn = robotColumn + 0;
							}
							else robotColumn--;
						}
						else if (move == 2) {
							if (robotColumn == size - 1) {
								robotColumn = robotColumn + 0;
							}
							else if (robotColumn == obstacleColumn - 1 &&
									obstacleRow == robotRow) {
								robotColumn = robotColumn + 0;
							}
							else robotColumn++;
						}
						if (move == 3) {
							if (robotRow == 0) {
								robotRow = robotRow + 0;
							}
							else if (robotRow == obstacleRow + 1 &&
									obstacleColumn == robotColumn) {
								robotRow = robotRow + 0;
							}
							else robotRow--;	
						}
						else if (move == 4) {
							if (robotRow == size - 1) {
								robotRow = robotRow + 0;
							}
							else if (robotRow == obstacleRow - 1 &&
									obstacleColumn == robotColumn) {
								robotRow = robotRow + 0;
							}
							else robotRow++;
						}
					count++;
					}
					System.out.println("Congratulations! Robot is Free!");
					System.out.println("It took " + count + " moves.");
					System.out.println(" ");
				}
			}	
		}			
	}
}		
		




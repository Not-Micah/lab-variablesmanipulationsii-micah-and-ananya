package edu.unl.raikes;

import java.util.Scanner;

/**
 * An incredibly useful Java Application for figuring out how much time people spend doing
 * things in the week. 
 * 
 * It accepts user input for the amount of time doing things during the week, and then 
 * presents a report of the percentage of how much each week is spend doing the various tasks. 
 * 
 * @author Karl Shaffer
 */
public class MindfulWeekCalculator {
	
	private static Scanner inputScanner; 
	
	private static final int NUM_HOURS_IN_WEEK = 168; 
	private static final int NUM_MEALS_IN_WEEK = 21;
	private static final int NUM_DAYS_IN_WEEK = 7;
	private static final int NUM_MINUTES_IN_HOUR = 60; 
	
	public static void main(String args[]) {
		
		// Declare variables. 		
		int hoursStudying;
		int hoursEating; 
		int hoursGettingReady; 
		int hoursWorking; 
		int hoursSleeping; 
		int hoursDigital;
		int hoursActive; 
		
		// Get user input. 
		
		System.out.println("Welcome to the Jeffrey S. Raikes School Mindful Week Calculator.\n\n");
		System.out.println("Please answer the following questions as best you can. "
				+ "Feel free to enter estimates or 0 if the question is not applicable.\n\n");
		
		System.out.print("Please enter the number of hours you spend per week in class, studying, or working on homework: ");
		hoursStudying = inputScanner.nextInt();
		System.out.println();
		
		System.out.print("Please enter the average amount of time you take to eat a meal in minutes: ");
		int numberOfMinutesForFood = inputScanner.nextInt(); 
		hoursEating = numberOfMinutesForFood * NUM_MEALS_IN_WEEK / NUM_MINUTES_IN_HOUR;
		System.out.println();

		System.out.print("Please enter the average amount of time you take to get ready in the morning in minutes: ");
		int numberOfMinutesGettingReady = inputScanner.nextInt(); 
		hoursGettingReady = numberOfMinutesGettingReady * NUM_DAYS_IN_WEEK; 
		System.out.println();
		
		System.out.print("Please enter the average amount of hours per week you work: ");
		hoursWorking = inputScanner.nextInt();
		System.out.println();
		
		System.out.print("Please enter the average amount of sleep you get per night in hours: ");
		hoursSleeping = inputScanner.nextInt() * NUM_DAYS_IN_WEEK; 
		System.out.println();

		System.out.print("Please enter the average amount of time you spend doing sedentary tasks (tv, video games, etc) per week in hours: ");
		hoursDigital = inputScanner.nextInt(); 
		System.out.println();

		System.out.print("Please enter the average amount of time you spend being active (sports, running, etc) in a week in hours: ");
		hoursActive = inputScanner.nextInt(); 
		System.out.println();

		// Calculate the report numbers. 
		int leftOverHours = NUM_HOURS_IN_WEEK 
				- hoursStudying 
				- hoursEating 
				- hoursGettingReady 
				- hoursWorking 
				- hoursSleeping 
				- hoursDigital 
				- hoursActive; 
		
		int percentStudying = hoursStudying / NUM_HOURS_IN_WEEK; 
		int percentEating = hoursEating / NUM_HOURS_IN_WEEK; 
		int percentGettingReady = hoursGettingReady / NUM_HOURS_IN_WEEK; 
		int percentWorking = hoursWorking / NUM_HOURS_IN_WEEK; 
		int percentSleeping = hoursSleeping / NUM_HOURS_IN_WEEK; 
		int percentSedentary = hoursDigital / NUM_HOURS_IN_WEEK; 
		int percentActive = hoursActive / NUM_HOURS_IN_WEEK; 
		int percentOther = leftOverHours / NUM_HOURS_IN_WEEK; 
		
		// Print Report. 
		System.out.println("\n\nYOUR MINDFULNESS REPORT:");
		System.out.println("Here is how you spend your week...\n\n");
		
		// Print different percentages. 
		System.out.println("STUDYING:                    " + percentStudying + "%");
		System.out.println("EATING:                      " + percentEating + "%");
		System.out.println("GETTING READY FOR THE DAY:   " + percentGettingReady + "%");
		System.out.println("WORKING:                     " + percentWorking + "%");
		System.out.println("SLEEPING:                    " + percentSleeping + "%");
		System.out.println("DOING SEDENTARY THINGS:      " + percentSedentary + "%");
		System.out.println("DOING ACTIVE THINGS:         " + percentActive + "%");
		System.out.println("OTHER:                       " + percentOther + "%");
		
		System.out.println("\n\n");
		
		System.out.println("There were " + leftOverHours + " hours unnaccounted for by our tool.");
	}
}

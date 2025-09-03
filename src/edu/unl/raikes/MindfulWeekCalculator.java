package edu.unl.raikes;

import java.util.Scanner;

/**
 * An incredibly useful Java Application for figuring out how much time people
 * spend doing things in the week.
 * 
 * It accepts user input for the amount of time doing things during the week,
 * and then presents a report of the percentage of how much each week is spend
 * doing the various tasks.
 * 
 * @author Karl Shaffer
 */
public class MindfulWeekCalculator {

	private static Scanner inputScanner = new Scanner(System.in);

	private static final int NUM_HOURS_IN_WEEK = 168;
	private static final int NUM_MEALS_IN_WEEK = 21;
	private static final int NUM_DAYS_IN_WEEK = 7;
	private static final int NUM_MINUTES_IN_HOUR = 60;

	public static void main(String args[]) {

		// Declare variables.
		double hoursStudying;
		double hoursEating;
		double hoursGettingReady;
		double hoursWorking;
		double hoursSleeping;
		double hoursDigital;
		double hoursActive;

		// Get user input.

		System.out.println("Welcome to the Jeffrey S. Raikes School Mindful Week Calculator.\n\n");
		System.out.println("Please answer the following questions as best you can. "
				+ "Feel free to enter estimates or 0 if the question is not applicable.\n\n");

		System.out.print(
				"Please enter the number of hours you spend per week in class, studying, or working on homework: ");
		hoursStudying = inputScanner.nextDouble();
		System.out.println();

		System.out.print("Please enter the average amount of time you take to eat a meal in minutes: ");
		int numberOfMinutesForFood = inputScanner.nextInt();
		hoursEating = (double) numberOfMinutesForFood * NUM_MEALS_IN_WEEK / NUM_MINUTES_IN_HOUR;
		System.out.println();

		System.out.print("Please enter the average amount of time you take to get ready in the morning in minutes: ");
		int numberOfMinutesGettingReady = inputScanner.nextInt();
		hoursGettingReady = (double) numberOfMinutesGettingReady / NUM_MINUTES_IN_HOUR * NUM_DAYS_IN_WEEK;
		System.out.println();

		System.out.print("Please enter the average amount of hours per week you work: ");
		hoursWorking = inputScanner.nextDouble();
		System.out.println();

		System.out.print("Please enter the average amount of sleep you get per night in hours: ");
		hoursSleeping = inputScanner.nextDouble() * NUM_DAYS_IN_WEEK;
		System.out.println();

		System.out.print(
				"Please enter the average amount of time you spend doing sedentary tasks (tv, video games, etc) per week in hours: ");
		hoursDigital = inputScanner.nextDouble();
		System.out.println();

		System.out.print(
				"Please enter the average amount of time you spend being active (sports, running, etc) in a week in hours: ");
		hoursActive = inputScanner.nextDouble();
		System.out.println();

		// Calculate the report numbers.
		double leftOverHours = NUM_HOURS_IN_WEEK - hoursStudying - hoursEating - hoursGettingReady - hoursWorking
				- hoursSleeping - hoursDigital - hoursActive;


		double percentStudying = (double) hoursStudying / NUM_HOURS_IN_WEEK*100;
		double percentEating = (double) hoursEating / NUM_HOURS_IN_WEEK*100;
		double percentGettingReady = (double) hoursGettingReady / NUM_HOURS_IN_WEEK*100;
		double percentWorking = (double) hoursWorking / NUM_HOURS_IN_WEEK*100;
		double percentSleeping = (double) hoursSleeping / NUM_HOURS_IN_WEEK*100;
		double percentSedentary = (double) hoursDigital / NUM_HOURS_IN_WEEK*100;
		double percentActive = (double) hoursActive / NUM_HOURS_IN_WEEK*100;
		double percentOther = (double) leftOverHours / NUM_HOURS_IN_WEEK*100;

		// Print Report.
		System.out.println("\n\nYOUR MINDFULNESS REPORT:");
		System.out.println("Here is how you spend your week...\n\n");

		// Print different percentages.
		System.out.println("STUDYING:                    " + (int) percentStudying + "%");
		System.out.println("EATING:                      " + (int) percentEating + "%");
		System.out.println("GETTING READY FOR THE DAY:   " + (int) percentGettingReady + "%");
		System.out.println("WORKING:                     " + (int) percentWorking + "%");
		System.out.println("SLEEPING:                    " + (int) percentSleeping + "%");
		System.out.println("DOING SEDENTARY THINGS:      " + (int) percentSedentary + "%");
		System.out.println("DOING ACTIVE THINGS:         " + (int) percentActive + "%");
		System.out.println("OTHER:                       " + (int) percentOther + "%");

		System.out.println("\n\n");

		System.out.println("There were " + (int) leftOverHours + " hours unaccounted for by our tool.");
	}
}

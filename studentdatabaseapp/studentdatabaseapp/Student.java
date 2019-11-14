package studentdatabaseapp;

import java.util.Scanner;

public class Student{
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses;
	private int tuitionBalance;
	private static int costOfCourse = 600;
	private static int id = 1001;
	
	
	//constructor prompt user to enter students name and year
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter student first name: ");
		this.firstName = in.nextLine();
		
		System.out.print("Enter student last name: ");
		this.lastName = in.nextLine();
		
		System.out.print("1 for Freshman\n2 for Sophmore\n3 for Junior\n4 for Senior ");
		this.gradeYear = in.nextInt();
	
		
		
		setStudentID();
		
	}
	
	
	// generate an id
	private void setStudentID() {
		// grade Level + ID
		id++;
		
		this.studentID = gradeYear + "" + id + " \n ";
		
	}
	
	
	
	// enroll in courses
	public void enroll() {
		// get inside a loop, users hits 0
		do {
			System.out.println("Enter course to enroll (0 to quit): ");
		
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			
			if(!course.equals("Q") ){
				courses = courses + "\n" + course;
				tuitionBalance = tuitionBalance + costOfCourse;
				
			}
			else {break;}
		} while (1 !=0);
		
		System.out.println("TUITION BALANCE: " + tuitionBalance);
		
	}
	
	// view balance and pay tuition
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}
	
	
	// pay tuition
	public void payTuition() {
		viewBalance();
		System.out.print("Enter your payment: ");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for your payment of $" + payment);
		
		
		viewBalance();
	}
	
	// Show status
	
public String showInfo( ) {
	return "Name: " + firstName + " " + lastName +
			"\nGrade Level: " + gradeYear +
			"\nStudent ID: " + studentID +
			"Courses Enrolled: " + courses +
			"\nBalance: " + tuitionBalance;
}
	
}
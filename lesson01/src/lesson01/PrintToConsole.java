package lesson01;

import java.util.ArrayList;

public class PrintToConsole {

	public String user_name ;  
	private  int student_id;  	
	private int student_ID ; 
	
	
	/**
	 * Determines the class average for cp213
	 *
	 * @param students  a list of student in cp213
	 * @return  grade point average of class is retruned. 
	 */
	public static double averageGradeForClass(final ArrayList<Student> students) {

		double total = 0;
		int count = 0;

		for (final Student a_student : students) {

			total += a_student.grade_point_average;

		}
		return total/students.size() ; 
	}    
	

	public static void main(String args[]) {
		System.out.println("I am using println method of out object");
		System.out.print("Out object has another method called Print");
		System.out.println("Run this code do see the difference between Print and Println methods");
		
		}
}

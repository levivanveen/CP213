package lesson01;

public class Student {


	static String university_name;
	
	private int student_number ;  
	protected char student_gender ;  
	public double grade_point_average;  
	             String student_name;  


	public double calculate_class_average(double[] grades) {
		double sum = 0, average = 0;
		for (int i = 0; i < grades.length; i++) {
			sum += grades[i];
		}
		average = sum / grades.length;
		return average;
	}

}

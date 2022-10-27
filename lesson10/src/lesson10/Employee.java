package lesson10;

public class Employee implements EmployeeInfo {

	private String name;
	private String department;
	private int PRINumber;

	public Employee() {
		super();
		name = "No name yet";
		department = " No department yet";
		PRINumber = 0;

	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public int getPRINumber() {
		return ++PRINumber;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" 
	             + department + ", PRINumber=" + PRINumber + "]";
	}

	public static void main (String args []) {
		EmployeeInfo e = new Employee () ; 
		
		System.out.println (e) ; 
	}
}

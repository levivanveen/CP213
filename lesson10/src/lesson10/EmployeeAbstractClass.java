package lesson10;

public abstract class EmployeeAbstractClass implements EmployeeInfo {

	private String name;
	private String department;
	private int PRINumber;

	public EmployeeAbstractClass() {
		super();
		name = "No name yet";
		department = " No departmen yet";
		PRINumber = 0;

	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public abstract int getPRINumber();

}

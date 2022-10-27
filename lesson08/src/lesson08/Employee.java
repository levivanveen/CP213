package lesson08;

public class Employee {
	

	private String name;
	private String department;
	private int PRINumber ;

	public Employee() {
		super();
		name = "No name yet";
		department = " No departmen yet";
		PRINumber = 0;

	}

	public Employee(String name, String department, int pRINumber) {
		super();
		this.name = name;
		this.department = department;
		this.PRINumber = pRINumber;
	}

	public Employee(Employee otherEmployee) {
		if (otherEmployee != null) {		
			this.name = otherEmployee.name ; 
			this.PRINumber = otherEmployee.PRINumber ; 
			this.department = otherEmployee.department ; 
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public  int getPRINumber() {
		return ++PRINumber ;
	}

	public void setPRINumber(int pRINumber) {
		PRINumber = pRINumber;
	}

	public void printDescription() {
		System.out.println(
				"Employee [name=" + name + ", " + "department=" + department + ", " + "PRINumber=" + PRINumber + "]");
	}

	public static void workingProject() {
		System.out.println(" Employee Project name");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (PRINumber != other.PRINumber)
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Employee clone() {
		return new Employee(this);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", PRINumber=" + PRINumber + "]";
	}
	
	public void badCopy (Employee[] emp ) {
		
		Employee[] copyArray = new Employee [emp.length] ; 
		for (int i =0 ; i< emp.length ; i++) {
			copyArray[i] = new Employee (emp[i]) ; 
		}
		
		for (int i =0 ; i< emp.length ; i++) {
			System.out.println (copyArray[i].toString()) ; 
		}
		
	}
	
	public void goodCopy (Employee [] emp ) {
		
		Employee[] copyArray = new Employee [emp.length] ; 
		for (int i =0 ; i< emp.length ; i++) {
			copyArray[i] = emp[i].clone() ; 
		//	copyArray[i] = new Employee (emp[i] ) ; 
		}
		
		for (int i =0 ; i< emp.length ; i++) {
			System.out.println (copyArray[i].toString()) ; 
		}
		
	}

}

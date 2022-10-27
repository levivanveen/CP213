package lesson08;

public class TeamLeader extends Employee {
	int numberOfEmployee;

	public TeamLeader(String name, String department, int pRINumber, int numberOfEmployee) {
		super(name, department, pRINumber);
		this.numberOfEmployee = numberOfEmployee;
	}
	
	public TeamLeader(TeamLeader otherTeamLeader) {
		super ((Employee)otherTeamLeader) ; 
		this.numberOfEmployee = numberOfEmployee;
	}

	public int getNumberOfEmployee() {
		return numberOfEmployee;
	}

	public void setNumberOfEmployee(int numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}

	@Override
	public void printDescription() {
		System.out.println("TeamLeader [numberOfEmployee=" + numberOfEmployee + ", name=" + getName() + ", "
				+ "department=" + getDepartment() + ", PRINumber=" + getPRINumber() + "]");
	}

	public static void workingProject() {
		System.out.println("Team Leader project Name");
	}

	public TeamLeader clone() {
		return new TeamLeader(this);
	}
}

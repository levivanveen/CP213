package lesson08;

public class Manager extends Employee {
	int numberOfTeams;

	public Manager(String name, String department, int pRINumber, int numberOfTeams) {
		super(name, department, pRINumber);
		this.numberOfTeams = numberOfTeams;
	}

	public Manager(Manager otherManager) {
		  super((Employee)otherManager) ; 
		if (null != otherManager) {
			otherManager.numberOfTeams = this.numberOfTeams ; 
		}
	}
	public int getNumberOfTeams() {
		return numberOfTeams;
	}

	public void setNumberOfTeams(int numberOfTeams) {
		this.numberOfTeams = numberOfTeams;
	}

	@Override
	public void printDescription() {
		System.out.println("Manager [numberOfTeams=" + numberOfTeams + ", name=" + getName() + ", department="
				+ getDepartment() + ", PRINumber=" + getPRINumber() + "]");
	}

	public static void workingProject() {
		System.out.println("Manager project Name");
	}

//	public Manager clone() {
//		return new Manager(this);
//	}

	public Manager clone() {
		return new Manager( getName(),  
				getDepartment(),  getPRINumber(), 
				numberOfTeams);
	}

	
	public String toString () {
		
		return (super.toString() + " " + numberOfTeams ) ; 
	}
}

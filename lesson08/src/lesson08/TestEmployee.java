package lesson08;

public class TestEmployee {
	public static void main(String args[]) {
		Employee employee1 = new Employee("AR yunis", "BI", 123456);
		Employee employee2 = new Manager("AR yunis", "BI", 123456, 5);
		Employee employee3 = new TeamLeader("AR yunis", "BI", 123456, 12);

		employee1.printDescription();
		employee2.printDescription();
		employee3.printDescription();
		
		
		Employee ar = new Employee("AR yunis", "BI", 123456);
		Manager manager = new Manager("AR yunis", "BI", 123456, 5);
		TeamLeader teamLeader = new TeamLeader("AR yunis", "BI", 123456, 12);
		System.out.println (ar) ; 
		ar = manager ; 
		manager.workingProject();  
		
		ar = teamLeader ; 
		ar.workingProject();  
		
	//	Employee anEmployee = new Employee("AR yunis", "BI", 123456);
		
	//	manager =  (Manager)anEmployee;//run-time error

	//	manager = anEmployee //will produce compiler error
		
		System.out.println (manager instanceof Employee) ; 
		System.out.println (manager instanceof Manager) ; 
		
		System.out.println (teamLeader instanceof Employee) ; 
		System.out.println (teamLeader instanceof TeamLeader) ; 
		
		
//		Employee [] managers = new Manager [5] ; 
//		int j = 1; 
//		int pri = 1234567;
//		
//		for ( int i =0; i<5 ; i++)
//			managers[i] = new Manager("AR yunis"+j++, "BI"+j, ++pri, i);
//		
//		Employee emp = new Employee("AR yunis", "BI", 123456);
//		
//		emp.badCopy(managers);
//		emp.goodCopy(managers);
	}
	
	
	
	
}

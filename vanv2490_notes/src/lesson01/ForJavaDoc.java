package lesson01;

/**
 * class ForJavaDoc is used to demonstrate how to use tags to generate javadoc.
 * 
 * @author Abdul-Rahman Mawlood
 *
 */
public class ForJavaDoc {

	
	private int number;
	private String name;
	private String manager;

	/**
	 * constructor method which takes three parameters
	 * 
	 * @param number uniquely  identify employee 
	 * @param name name of employee
	 * @param manager name of manager 
	 */
	public ForJavaDoc(int number, String name, String manager) {
		super();
		this.number = number;
		this.name = name;
		this.manager = manager;
	}

	/**
	 * get method for number
	 * 
	 * @return number return employee unique number 
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * set method for number
	 * 
	 * @param number int value to set employee number
	 * 
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	

	/**
	 * get method for name
	 * 
	 * @return return employee name 
	 */
	public String getName() {
		return name;
	}

	/**
	 * set method for name
	 * 
	 * @param name String name to set employee name 
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get method for manger
	 * 
	 * @return return manager name 
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * set method for manger
	 * 
	 * @param manager set manager name 
	 * 
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}

	/**
	 * toString method for the class
	 */
	@Override
	public String toString() {
		return "ForJavaDoc [number=" + number + ", name=" + name + ", manager=" + manager + "]";
	}

}

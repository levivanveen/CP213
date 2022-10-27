package lesson07;

public class TestClassName {

	public void print(Object o) {
		System.out.println(o instanceof TestClassName);

	}

	public void print2(Object o) {

		System.out.println(o.getClass().toString());
		System.out.println(o.getClass().toString().
				compareTo("class lesson07.TestClassName") == 0);
	}

	public static void main(String args[]) {

		TestClassName testClass = new TestClassName();
		testClass.print(testClass);
		testClass.print2(testClass);
	}
}

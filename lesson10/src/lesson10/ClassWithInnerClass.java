package lesson10;

public class ClassWithInnerClass {

	class Inner {

		public int innerX;
		private String innerY;

		public void innerTest() {
			doSomething();
			System.out.println(outerX);
		}

		private int outerX;
		private String outerY;

		private void doSomething() {
		}

		public void callOuterMethod(Inner inObject) {

			String s = inObject.innerY;
			outerTest();
			innerTest();
		}
	}

	private void outerTest() {
		// System.out.println(innerX); // Illegal
		// System.out.println(innerY); // illegal
		// innerTest () ; // illegal
		Inner in = new Inner();
		in.innerTest();
	}

}

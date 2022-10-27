package lesson10;

public class InnerOuterAndStatic {
	
	public class Inner {

		int x;
		private String innerY;

		public void testInner() {
			// int innerX = outerX; // illegal
			 createInner(); // illegal
			int iny = outerY;
		}
	}

//	public static void CreateInner() {
//		new Inner();
//	}

	private int outerY;
	int outerX;

	public void createInner() {
		String s = new Inner().innerY;
		new Inner();
	}

	public void createInner(Inner x ) {
		String s = x.innerY;
		new Inner();
	}

}

package lesson10;

public class InnerStatic {
	
	 public static class Inner {
		 
		static int x ; 		
		static void print () {} 
	}
	
	int outx = Inner.x ;
	
	public void print () {
		Inner.print();
	}
	

}

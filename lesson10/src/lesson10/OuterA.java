package lesson10;

public class OuterA {
	
	public void print () {
		System.out.println ("outer print"); 
		} 
	
	public class InnerB {
		
		public void print () {
			System.out.println ("inner print"); 
			}  	
		
		public void callOuterPrint () {
			this.print(); //or OuterA.this.callOuterPrint(); 
		}
		
		public void callOuterPrint2 () {
			print();  
		}
	}
}

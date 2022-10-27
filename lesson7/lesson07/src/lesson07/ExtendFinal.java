package lesson07;

public class ExtendFinal extends FinalClass {

	int c, d;

	public ExtendFinal(int a, int b, int c) {

		super(a, b);
		this.c = c;
	}

	public ExtendFinal(int a, int b, int c, int d) {
		// this(a,b,c) ;

		this(a, b, c);
		this.c = c;
		this.d = d;
	}

	public ExtendFinal() {
	}

//	public void test() {
//	}
	
	@Override
	public  void test2() {
		super.test2(); 
	}
	
	public static void main (String args []) {
		ExtendFinal ef = new ExtendFinal () ; 
		//ef.super.test2 () ;  // you cannot do that. 
		ef.test2() ; 
	}
}

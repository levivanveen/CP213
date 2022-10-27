package lesson10;

public class VInterfaceImplementation implements VInterface {

	public void sayHello() {
		System.out.println(VInterface.hello);

	}

	public static void main(String args[]) {

		new VInterfaceImplementation().sayHello();
		
		//VInterface.hello ="bonjure";
	}

}

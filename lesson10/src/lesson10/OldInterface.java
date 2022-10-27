package lesson10;

public interface OldInterface {

	public void print();

	default public int add(int x, int y) {
		return (x + y);
	}
	
	public class DateTimeUtils {
	    public native String getSystemTime();
	    // ...
	}
}

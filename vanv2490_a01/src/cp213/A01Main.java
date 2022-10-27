package cp213;

/**
 * Sample tests for the Assignment 1 class methods. Not comprehensive - add your
 * own testing.
 *
 * @author Levi Van Veen
 * @version 2021-09-11
 */
public class A01Main {
    // Constants
    private static final String LINE = "-".repeat(40);
    private static final String TEST_LINE = "=".repeat(80);

    public static final String CIPHERTEXT = "AVIBROWNZCEFGHJKLMPQSTUXYD"; // for testing substitute method

    public static void main(String[] args) {
	System.out.println("Assignment 1 Methods Tests");
	System.out.println();
	System.out.println("Tests are of the form:");
	System.out.println("  Test Operation {expected value}: actual value");
	System.out.println();

	testIsLeapYear();
	testIsPalindrome();
	testIsValid();
	testPigLatin();
	testClosest();
	testSumPartialHarmonic();
	testAllDigits();
	testValidSn();
	testIsPrime();
	testShift();
	testSubstitute();
    }

    /**
     * Test isLeapYear.
     */
    private static void testIsLeapYear() {
	System.out.println(TEST_LINE);
	System.out.println("Testing isLeapYear");
	System.out.println(LINE);

	int year = 1900;
	boolean result = LeapYear.isLeapYear(year);
	System.out.println("" + year + " {false}: " + result);
	year = 1996;
	result = LeapYear.isLeapYear(year);
	System.out.println("" + year + " {true}: " + result);
	year = 1999;
	result = LeapYear.isLeapYear(year);
	System.out.println("" + year + " {false}: " + result);
	year = 2000;
	result = LeapYear.isLeapYear(year);
	System.out.println("" + year + " {true}: " + result);
	System.out.println();
    }

    /**
     * Test isPalindrome.
     */
    private static void testIsPalindrome() {
	System.out.println(TEST_LINE);
	System.out.println("Testing isPalindrome");
	System.out.println(LINE);

	String string = "a";
	boolean result = Strings.isPalindrome(string);
	System.out.println("" + string + " {true}: " + result);
	string = "racecar";
	result = Strings.isPalindrome(string);
	System.out.println("" + string + " {true}: " + result);
	string = "A man, a plan, a canal, Panama!";
	result = Strings.isPalindrome(string);
	System.out.println("" + string + " {true}: " + result);
	string = "David";
	result = Strings.isPalindrome(string);
	System.out.println("" + string + " {false}: " + result);
	System.out.println();
    }

    /**
     * Test isValid.
     */
    private static void testIsValid() {
	System.out.println(TEST_LINE);
	System.out.println("Testing isValid");
	System.out.println(LINE);

	String string = "a";
	boolean result = Strings.isValid(string);
	System.out.println("" + string + " {true}: " + result);
	string = "_a";
	result = Strings.isValid(string);
	System.out.println("" + string + " {true}: " + result);
	string = "1a";
	result = Strings.isValid(string);
	System.out.println("" + string + " {false}: " + result);
	System.out.println();
    }

    /**
     * Test pigLatin.
     */
    private static void testPigLatin() {
	System.out.println(TEST_LINE);
	System.out.println("Testing pigLatin");
	System.out.println(LINE);

	String string = "David";
	String result = Strings.pigLatin(string);
	System.out.println("" + string + " {Avidday}: " + result);
	string = "arrow";
	result = Strings.pigLatin(string);
	System.out.println("" + string + " {arrowway}: " + result);
	string = "yard";
	result = Strings.pigLatin(string);
	System.out.println("" + string + " {ardyay}: " + result);
	System.out.println();
    }

    /**
     * Test closest.
     */
    private static void testClosest() {
	System.out.println(TEST_LINE);
	System.out.println("Testing closest");
	System.out.println(LINE);

	double target = 0;
	double v1 = -5;
	double v2 = 5;
	double result = Numbers.closest(target, v1, v2);
	System.out.println("" + target+", " + v1 +", " + v2 + " {-5.0}: " + result);
	target = 0;
	v1 = -10;
	v2 = 5;
	result = Numbers.closest(target, v1, v2);
	System.out.println("" + target+", " + v1 +", " + v2 + " {5.0}: " + result);
	System.out.println();
    }

    /**
     * Test isPrime.
     */
    private static void testIsPrime() {
	System.out.println(TEST_LINE);
	System.out.println("Testing isPrime");
	System.out.println(LINE);

	int n = 7;
	boolean result = Numbers.isPrime(n);
	System.out.println("" + n + " {true}: " + result);
	n = 5;
	result = Numbers.isPrime(n);
	System.out.println("" + n + " {true}: " + result);
	n = 9;
	result =Numbers.isPrime(n);
	System.out.println("" + n + " {false}: " + result);
	System.out.println();
    }


    /**
     * Test sumPartialHarmonic.
     */
    private static void testSumPartialHarmonic() {
	System.out.println(TEST_LINE);
	System.out.println("Testing sumPartialHarmonic");
	System.out.println(LINE);

	int n = 0;
	double result = Numbers.sumPartialHarmonic(n);
	System.out.println("" + n+ " {0.0}: " + result);
	n = 1;
	result = Numbers.sumPartialHarmonic(n);
	System.out.println("" + n+ " {1.0}: " + result);
	n = 8;
	result = Numbers.sumPartialHarmonic(n);
	System.out.println("" + n+ " {2.7178571428571425}: " + result);
	System.out.println();
    }

    /**
     * Test allDigits.
     */
    private static void testAllDigits() {
	System.out.println(TEST_LINE);
	System.out.println("Testing allDigits");
	System.out.println(LINE);

	String string = "a";
	boolean result = SerialNumber.allDigits(string);
	System.out.println("" + string + " {false}: " + result);
	string = "123";
	result = SerialNumber.allDigits(string);
	System.out.println("" + string + " {true}: " + result);
	string = "12.3";
	result = SerialNumber.allDigits(string);
	System.out.println("" + string + " {false}: " + result);
	System.out.println();
    }

    /**
     * Test validSn.
     */
    private static void testValidSn() {
	System.out.println(TEST_LINE);
	System.out.println("Testing validSn");
	System.out.println(LINE);

	String string = "SN/1234-567";
	boolean result = SerialNumber.validSn(string);
	System.out.println("" + string + " {true}: " + result);
	string = "SN/1234567";
	result = SerialNumber.validSn(string);
	System.out.println("" + string + " {false}: " + result);
	string = "SN/123-4567";
	result = SerialNumber.validSn(string);
	System.out.println("" + string + " {false}: " + result);
	System.out.println();
    }

    /**
     * Test shift.
     */
    private static void testShift() {
	System.out.println(TEST_LINE);
	System.out.println("Testing shift");
	System.out.println(LINE);

	String string = "ABC";
	String result = Cipher.shift(string, 0);
	System.out.println("" + string + " {ABC}: " + result);
	string = "ABC";
	result = Cipher.shift(string, 3);
	System.out.println("" + string + " {DEF}: " + result);
	string = "ABC";
	result = Cipher.shift(string, 30);
	System.out.println("" + string + " {EFG}: " + result);
	System.out.println();
    }
    /**
     * Test substitute.
     */
    private static void testSubstitute() {
	System.out.println(TEST_LINE);
	System.out.println("Testing substitute");
	System.out.println(LINE);

	String string = "ABC";
	String result = Cipher.substitute(string, CIPHERTEXT);
	System.out.println("" + string + " {AVI}: " + result);
	string = "XYZ";
	result = Cipher.substitute(string, CIPHERTEXT);
	System.out.println("" + string + " {XYD}: " + result);
	System.out.println();
    }

}
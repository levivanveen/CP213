 package cp213;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Levi Van Veen 200852490
 * @version 2021-09-11
 */
public class SerialNumber {

    /**
     * Determines if a string contains all digits.
     *
     * @param str The string to test.
     * @return true if str is all digits, false otherwise.
     */
    public static boolean allDigits(final String str) {
    	boolean numbers = true, loop = true;
    	int i = 0, j = 0;
    	String digits = "0123456789";
    	
    	while (i < str.length() && numbers == true) {
    		while (j < 10 && loop == true) {
    			if (str.charAt(i) == digits.charAt(j)) {
    				loop = false;
    			}
    			else {
    				j++;
    			}
    		}
    		if (loop == false) {
    			i ++;
    			loop = true;
    		}
    		else {
    			numbers = false;
    		}	
    	}
	return numbers;
    }

    /**
     * Determines if a string is a good serial number. Good serial numbers are of
     * the form 'SN/nnnn-nnn', where 'n' is a digit.
     *
     * @param sn The serial number to test.
     * @return true if the serial number is valid in form, false otherwise.
     */
    public static boolean validSn(final String sn) {
    	boolean valid = true, result1, result2;
    	String part1, part2;
    	
    	if (sn.length() == 11) {
    		if ((sn.charAt(0) == 'S') && (sn.charAt(1) == 'N') && (sn.charAt(2) == '/') && (sn.charAt(7) == '-')) {
    			part1 = sn.substring(3, 6);
    			part2 = sn.substring(8, 10);
    			result1 = allDigits(part1);
    			result2 = allDigits(part2);
    			if (!result1 && !result2) {
    				valid = false;
    			}
        	}
        	else {
        		valid = false;
        	}
    	}
    	else {
    		valid = false;
    	}
    		
	return valid;
    }

    /**
     * Evaluates serial numbers from a file. Writes valid serial numbers to
     * good_sns, and invalid serial numbers to bad_sns.
     *
     * @param fileIn  a file already open for reading
     * @param goodSns a file already open for writing
     * @param badSns  a file already open for writing
     */
    public static void validSnFile(final Scanner fileIn, final PrintStream goodSns, final PrintStream badSns) {
    	String line;
    	boolean result;
    	
    	while (fileIn.hasNextLine()) {
    		line = fileIn.nextLine();
    		result = validSn(line);
    		if (result) {
    			goodSns.println(line);
    		}
    		else {
    			badSns.println(line);
    		}
    	}
	return;
    }

}

package cp213;

/**
 * @author Your name and id here
 * @version 2021-09-11
 */
public class Strings {
    // Constants
    public static final String VOWELS = "aeiouAEIOU";
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String DIGITS = "0123456789";
    /**
     * Determines if string is a "palindrome": a word, verse, or sentence (such as "Able
     * was I ere I saw Elba") that reads the same backward or forward. Ignores case,
     * spaces, digits, and punctuation in the string parameter s.
     *
     * @param string a string
     * @return true if string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(final String string) {
    	String word = "";
    	int i = 0, length, middle;
    	boolean palindrome = true;
    	
    	while (i < string.length() && palindrome) {
    		if (ALPHABET.indexOf(string.charAt(i)) == -1) {
    			i++;
    		}
    		else {
    			word = word + string.charAt(i);
    			i++;
    		}
    	}
    	
    	i = 0;
    	word = word.toLowerCase();
    	length = word.length();
    	middle = length / 2;
    	
    	while (i <= middle && palindrome) {
    		if (word.charAt(i) != word.charAt(length - 1 - i)) {
    			palindrome = false;
    		}
    		else {
    			i++;
    		}
    	}
    
	return palindrome;
    }

    /**
     * Determines if name is a valid Java variable name. Variables names must start
     * with a letter or an underscore, but cannot be an underscore alone. The rest
     * of the variable name may consist of letters, numbers and underscores.
     *
     * @param name a string to test as a Java variable name
     * @return true if name is a valid Java variable name, false otherwise
     */
    public static boolean isValid(final String name) {
    	boolean valid = true;
    	int i = 1;
    	
    	if ((name.charAt(0) == '_' && name.length() == 1) ||
    			(ALPHABET.indexOf(name.charAt(0)) == -1 && name.charAt(0) != '_')) {
    		valid = false;
    	}
    	
    	while (i < name.length() && valid) {
    		if ((ALPHABET.indexOf(name.charAt(i)) == -1) && (DIGITS.indexOf(name.charAt(i)) == -1)
    				&& (name.charAt(i) != '_')) {
    			valid = false;
    		}
    		else {
    			i ++;
    		}
    	}
	return valid;
    }

    /**
     * Converts a word to Pig Latin. The conversion is:
     * <ul>
     * <li>if a word begins with a vowel, add "way" to the end of the word.</li>
     * <li>if the word begins with consonants, move the leading consonants to the
     * end of the word and add "ay" to the end of that. "y" is treated as a
     * consonant if it is the first character in the word, and as a vowel for
     * anywhere else in the word.</li>
     * </ul>
     * Preserve the case of the word - i.e. if the first character of word is
     * upper-case, then the new first character should also be upper case.
     *
     * @param word The string to convert to Pig Latin
     * @return the Pig Latin version of word
     */
    public static String pigLatin(String word) {
    	String pig = "", firstLetter = "", LOWERCASE = "abcdefghijklmnopqrstuvwxyz", newFirst = "";
    	
    	if (VOWELS.indexOf(word.charAt(0)) != -1) {
    		pig = word + "way";
    	}
    	else {
    		firstLetter = Character.toString(word.charAt(0));
    		if (LOWERCASE.indexOf(firstLetter.charAt(0)) == -1) {
    			firstLetter = firstLetter.toLowerCase();
    			newFirst = Character.toString(word.charAt(1));
    			newFirst = newFirst.toUpperCase();
    			pig = newFirst + word.substring(2, word.length()) + firstLetter + "ay";
    		}
    		else {
    			pig = word.substring(1, word.length()) + firstLetter + "ay";
    		}
    	}
	return pig;
    }
}

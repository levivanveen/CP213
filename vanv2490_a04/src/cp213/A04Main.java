package cp213;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Main method and table generation methods for Assignment 4.
 *
 * @author your name here
 * @author David Brown
 * @version 2021-11-01
 */
public class A04Main {
    private static final String LINE = "-".repeat(40);
    private static final String TEST_LINE = "=".repeat(80);
    private static final Integer[] testItems = { 1, 2, 3 };

    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String FILENAME = "decline.txt";
    //public static final String FILENAME = "miserables.txt";
    public static final NumberFormat NF = NumberFormat.getInstance();
    public static final String POPULAR = "ETAOINSHRDLUCMPFYWGBVKJXZQ";
    public static final String SEPARATOR = "------------------------------";

    public static final String SPLIT = "MFTCJPWADHKNRUYBEIGLOQSVXZ";
    public static final String[] STRING_DATA = new String[] { ALPHABET, SPLIT, POPULAR };

    /**
     * Print a formatted table of character counts and percentages in the format:
     *
     * <pre>
     * Character Table for Comparisons File
     *
     * Char    Count Percent
     *    A  206,946    8.17
     *    B   37,498    1.48
     *    ...
     * </pre>
     *
     * Note: your data may not match this as it is file dependent.
     *
     * @param tree The BST to generate the table from.
     */
    private static void characterTable(final BST<Character> tree) {

        final ArrayList<CountedItem<Character>> array = tree.inOrder();
        int totalCount = 0;

        for (final CountedItem<Character> item : array) {
            totalCount += item.getCount();
        }
        System.out.println("Char    Count Percent");

        for (final CountedItem<Character> item : array) {
            final int count = item.getCount();
            final double percent = (double) item.getCount() / totalCount * 100;
            System.out.format("%4s %,8d %7.2f%n", item.getItem(), count, percent);
        }
        return;
    }

    /**
     * Fill a tree by inserting all letters from a string into the tree. Letters
     * must be converted to upper-case. Non-letters are ignored. The order that
     * letters are inserted into the tree determine its shape.
     *
     * @param tree   The BST/AVL/PopularityTree to fill.
     * @param string The string to read into the tree.
     */
    private static void fillTree(final BST<Character> tree, final String string) {

        for (final char letter : string.toCharArray()) {
            final CountedItem<Character> data = new CountedItem<Character>(Character.toUpperCase(letter));
            tree.insert(data);
        }
        return;
    }

    /**
     * Determine the number of comparisons to retrieve the contents of a file from a
     * tree. Attempt to retrieve every letter in the file from tree. All letters
     * must be converted to upper case.
     *
     * @param tree The BST to process.
     * @param file The file to process.
     * @return The number of comparisons necessary to find every letter in file in
     *         tree.
     */
    private static int retrieve(final BST<Character> tree, final Scanner fileScan) {

        while (fileScan.hasNextLine()) {
            final String line = fileScan.nextLine();

            for (final Character c : line.toCharArray()) {

                if (Character.isLetter(c)) {
                    final CountedItem<Character> key = new CountedItem<Character>(Character.toUpperCase(c));
                    tree.retrieve(key);
                }
            }
        }
        return tree.getComparisons();
    }

    /**
     * Test AVL.
     */
    private static void testAVL() {
	System.out.println(TEST_LINE);
	System.out.println("Testing AVL");
	final AVL<Integer> source = new AVL<>();
	System.out.println("  isEmpty {true}: " + source.isEmpty());
	System.out.println(LINE);
	System.out.println("Insert items: " + Arrays.toString(testItems));

	for (Integer i : testItems) {
	    CountedItem<Integer> item = new CountedItem<>(i);
	    source.insert(item);
	}
	System.out.println("  isEmpty {false}: " + source.isEmpty());
	System.out.println("  Contents {[{2: 1}, {1: 1}, {3: 1}]}: " + source.levelOrder().toString());
	System.out.println("  Height {2}: " + source.getHeight());
	System.out.println(LINE);
	System.out.println();
    }

    /**
     * Test BST.
     */
    private static void testBST() {
	System.out.println(TEST_LINE);
	System.out.println("Testing BST");
	final BST<Integer> source = new BST<>();
	System.out.println("  isEmpty {true}: " + source.isEmpty());
	System.out.println(LINE);
	System.out.println("Insert items: " + Arrays.toString(testItems));

	for (Integer i : testItems) {
	    CountedItem<Integer> item = new CountedItem<>(i);
	    source.insert(item);
	}
	System.out.println("  isEmpty {false}: " + source.isEmpty());
	System.out.println("  Contents {[{1: 1}, {2: 1}, {3: 1}]}: " + source.levelOrder().toString());
	System.out.println("  Height {3}: " + source.getHeight());
	System.out.println(LINE);
	System.out.println();
    }

    /**
     * Test PopularityTree.
     */
    private static void testPopularityTree() {
	System.out.println(TEST_LINE);
	System.out.println("Testing PopularityTree");
	final PopularityTree<Integer> source = new PopularityTree<>();
	System.out.println("  isEmpty {true}: " + source.isEmpty());
	System.out.println(LINE);
	System.out.println("Insert items: " + Arrays.toString(testItems));

	for (Integer i : testItems) {
	    CountedItem<Integer> item = new CountedItem<>(i);
	    source.insert(item);
	}
	System.out.println("  isEmpty {false}: " + source.isEmpty());
	System.out.println("  Contents {[{1: 0}, {2: 0}, {3: 0}]}: " + source.levelOrder().toString());
	System.out.println("  Height {3}: " + source.getHeight());
	System.out.println(LINE);
	System.out.println();
	System.out.println("Retrieve items: ");
	CountedItem<Integer> key = new CountedItem<>(3);
	System.out.println("  retrieve {3: 1}: " + source.retrieve(key));
	System.out.println("  Contents {[{3: 1}, {1: 0}, {2: 0}]}: " + source.levelOrder().toString());
	System.out.println("  Height {3}: " + source.getHeight());
	System.out.println(LINE);
	System.out.println();
    }

    /**
     * Program for Assignment 4.
     *
     * @param args unused
     * @throws IOException If error on files.
     */
    public static void main(final String[] args) throws IOException {
	System.out.println("BST Data Structures Tests");
	System.out.println();
	System.out.println("Tests are of the form:");
	System.out.println("  Test Operation {expected item}: actual item");
	System.out.println("  Contents: [contents from front to rear]");
	System.out.println();

	testBST();
	testAVL();
	testPopularityTree();
	System.out.println(TEST_LINE);

	System.out.println("Testing file: " + FILENAME);
	System.out.println();
	final File comparisonsFile = new File(FILENAME);

	for (final String string : STRING_DATA) {
	    int minComparisons = Integer.MAX_VALUE;
	    String treeType = null;
	    String minTree = null;
	    System.out.println("Data String: " + string);
	    System.out.println();
	    final ArrayList<BST<Character>> trees = new ArrayList<>();
	    trees.add(new BST<Character>());
	    trees.add(new PopularityTree<Character>());
	    trees.add(new AVL<Character>());

	    for (final BST<Character> tree : trees) {
		treeType = tree.getClass().getSimpleName();
		System.out.println("  Tree Type: " + treeType);
		A04Main.fillTree(tree, string);
		final Scanner fileScan = new Scanner(comparisonsFile);
		final int comparisons = A04Main.retrieve(tree, fileScan);
		fileScan.close();
		System.out.println("  Height: " + tree.getHeight());
		System.out.println("  Comparisons: " + NF.format(comparisons));

		if (comparisons < minComparisons) {
		    minComparisons = comparisons;
		    minTree = treeType;
		}
		System.out.println();
	    }
	    System.out.println("Tree with minimum comparisons: " + minTree);
	    System.out.println(SEPARATOR);
	}
	final PopularityTree<Character> bst = new PopularityTree<>();
	A04Main.fillTree(bst, ALPHABET);
	final Scanner fileScan = new Scanner(comparisonsFile);
	A04Main.retrieve(bst, fileScan);
	fileScan.close();
	System.out.println("Character Table for Comparisons File");
	System.out.println();
	A04Main.characterTable(bst);
    }
}

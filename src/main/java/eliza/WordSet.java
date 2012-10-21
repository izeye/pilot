package eliza;

import java.util.HashSet;

/**
 * Eliza word list.
 */
public class WordSet extends HashSet<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Print a word list on one line.
	 */
	public void print(int indent) {
		for (String word : this) {
			System.out.print(word + "  ");
		}
		System.out.println();
	}

}

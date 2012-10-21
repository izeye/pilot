package eliza;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Eliza synonym list. Collection of all the synonym elements.
 */
public class SynList extends ArrayList<WordSet> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Prnt the synonym lists.
	 */
	public void print(int indent) {
		for (WordSet wordSet : this) {
			for (int j = 0; j < indent; j++)
				System.out.print(" ");
			System.out.print("synon: ");
			wordSet.print(indent);
		}
	}

	/**
	 * Find a synonym word list given the any word in it.
	 */
	public WordSet find(String s) {
		for (WordSet wordSet : this) {
			if (wordSet.contains(s)) {
				return wordSet;
			}
		}
		return null;
	}

	/**
	 * Decomposition match, If decomp has no synonyms, do a regular match.
	 * Otherwise, try all synonyms.
	 */
	boolean matchDecomp(String str, String pat, String lines[]) {
		if (!EString.match(pat, "*@* *", lines)) {
			// no synonyms in decomp pattern
			return EString.match(str, pat, lines);
		}
		// Decomp pattern has synonym -- isolate the synonym
		String first = lines[0];
		String synWord = lines[1];
		String theRest = " " + lines[2];
		// Look up the synonym
		WordSet syn = find(synWord);
		if (syn == null) {
			System.out.println("Could not fnd syn list for " + synWord);
			return false;
		}
		// Try each synonym individually
		Iterator<String> synIterator = syn.iterator();
		while (synIterator.hasNext()) {
			String nextSynonym = synIterator.next();
			// Make a modified pattern
			pat = first + nextSynonym + theRest;
			if (EString.match(str, pat, lines)) {
				int n = EString.count(first, '*');
				// Make room for the synonym in the match list.
				for (int j = lines.length - 2; j >= n; j--)
					lines[j + 1] = lines[j];
				// The synonym goes in the match list.
				lines[n] = nextSynonym;
				return true;
			}
		}
		return false;
	}

}

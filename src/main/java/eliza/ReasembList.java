package eliza;

import java.util.ArrayList;

/**
 * Eliza reassembly list.
 */
public class ReasembList extends ArrayList<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Print the reassembly list.
	 */
	public void print(int indent) {
		for (String reasemb : this) {
			for (int j = 0; j < indent; j++)
				System.out.print(" ");
			System.out.println("reasemb: " + reasemb);
		}
	}

}

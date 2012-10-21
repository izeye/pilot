package eliza;

import java.util.ArrayList;

public class DecompList extends ArrayList<Decomp> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void print(int indent) {
		for (Decomp decomp : this) {
			decomp.print(indent);
		}
	}

}

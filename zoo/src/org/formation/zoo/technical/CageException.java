package org.formation.zoo.technical;

public class CageException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CageException() {
		this("Cage is full!");
	}

	public CageException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CageException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CageException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public CageException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}
}

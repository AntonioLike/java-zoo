package org.formation.zoo.technical;

public class YuckException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public YuckException() {
		this("Yuck!");
	}

	public YuckException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public YuckException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public YuckException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public YuckException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}
}

package org.formation.zoo.tools;

public enum Broom {;
	public static void sweep() {
		try {
			System.gc();
			Thread.sleep(100);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}

package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.formation.zoo.controller.Manager;
import org.formation.zoo.view.TypesOfEatable;
import org.formation.zoo.view.Zoo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ZooTests {
	static Zoo zoo;
	private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private static final PrintStream originalOut = System.out;
	
	@AfterAll
	static void restoreStreams() {
		System.setOut(originalOut);
	}
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		zoo = new Zoo();
		System.setOut(new PrintStream(outContent));
	}

	@Test
	void testDisplay() {
		
	}

	@Test
	void testFeed() {
		
	}

	@Test
	void testDevour() throws Throwable {
		boolean wasCageEmpty;
		for (int i = 0; i<zoo.getAmountAnimals();i++)
			for(int j = 0; j<zoo.getAmountAnimals();j++) {
				wasCageEmpty=Manager.getInstance().isCageEmpty(j);
				//System.out.println(String.join(" ", zoo.getSpecies(i), "eats", zoo.getSpecies(j)));
				
				zoo.devour(i, j,TypesOfEatable.ANIMAL);
				if(zoo.getSpecies(i)=="Lion" && zoo.getSpecies(j)!="") {
					assertEquals("Oof!", outContent.toString().substring(0, 4));
					assertEquals(false, wasCageEmpty);
					assertEquals(true, Manager.getInstance().isCageEmpty(j));
				}
				else {
					assertEquals("yuck!", outContent.toString().substring(0, 5));
				}
				
			}
		
		boolean wasAlive;
		for (int i = 0; i<zoo.getAmountAnimals();i++)
			for(int j = 0; j<zoo.getAmountVisitors();j++) {
				wasAlive = Manager.getInstance().isVisitorAlive(j);
				zoo.devour(i, j, TypesOfEatable.VISITOR);
				if(zoo.getSpecies(i)=="Lion") {
					assertEquals("Oof!", outContent.toString().substring(0, 4));
					assertEquals(true,wasAlive);
					assertEquals(false,Manager.getInstance().isVisitorAlive(j));
				}
				else {
					assertEquals("yuck!", outContent.toString().substring(0, 5));
				}
			}
	}
}

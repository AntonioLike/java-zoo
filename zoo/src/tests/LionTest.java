package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.formation.zoo.model.Gazelle;
import org.formation.zoo.model.Lion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LionTest {
	private static Lion lion;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		lion = new Lion("Lion", 12, 100);
		assertEquals("Lion", lion.getName());
		assertEquals(12, lion.getAge());
	}

	@Test
	void testEat() {
		double weight = lion.getWeight();
		lion.eat();
		assertEquals(weight+1.9, lion.getWeight());
	}

	@Test
	void testSleep() {
		
	}

	@Test
	void testEatGazelle() {
		Gazelle gazelle = new Gazelle("Gazelle",2,60,5);
		double gazelleWeight = gazelle.getWeight()/3;
		double weight = lion.getWeight();
		lion.eat(gazelle);
		assertEquals(weight+gazelleWeight, lion.getWeight());
		gazelle = null;
		System.gc();
	}

	@Test
	void testRun() {
		
	}

	@Test
	void testSound() {
		
	}
}
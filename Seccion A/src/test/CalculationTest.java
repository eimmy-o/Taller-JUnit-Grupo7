package test;

import main.Calculation; 
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculationTest {

	@Test
	public static void testFindMax() {
		assertEquals(4 , Calculation.findMax(new int[] {1,3,4,2})) ;
		assertEquals(-1 , Calculation.findMax(new int[] {-12,-1,-3,-4,-2})) ;
	}

}

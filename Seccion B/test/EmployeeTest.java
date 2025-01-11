package test;


import static org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
	private Employee worker;
	private Employee supervisor;
	private Employee manager; 
	
	@Test
	void test() {
		assertTrue(true);faasasd
	}
	
	@BeforeEach
	void setUp() {
		System.out.println("Configurando variables para cada test");
		worker = new Employee(500, "USD", 0, EmployeeType.Worker);
	}

}

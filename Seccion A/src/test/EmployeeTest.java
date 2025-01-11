package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;

import main.Employee;
import main.EmployeeType;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

class EmployeeTest {
	private static int month;
	private static Employee worker;
	private static Employee supervisor;
	private static Employee manager;
	
	@BeforeAll
	static void setUp() {
		Date date = new Date();
        LocalDate localDate;
        localDate = date.toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        month = localDate.getMonthValue();
		
		worker = new Employee(1000, "USD", 0, EmployeeType.Worker);
		supervisor = new Employee(1500, "USD", 15, EmployeeType.Supervisor);
		manager = new Employee(3000, "EUR", 30, EmployeeType.Manager);
		System.out.println("Inicializando variables");
	}

	@Test
	@DisplayName("Test Worker con un salario negativo")
	void testSalarioNegativo() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Employee(-1000, "USD", 0, EmployeeType.Worker);
		});
	}
	
	@Test
	void testWorkerTipoMes() {
        float valorEsperado = month%2==0?1000f:1064.333f;
        
		assertEquals(valorEsperado, worker.cs(), 0.0001f);
	}
	
	@Test
	void testAgnoBonusSupervisor() {
		float bonusEsperado = 1693;
		assertEquals(bonusEsperado, supervisor.CalculateYearBonus());
		assertTrue(supervisor.CalculateYearBonus() > 0);
	}
	
	@Test
	void testSalarioManager() {
		float calculoMesPar = (3000 * 0.95F) + (30 * 0.7F);
		float valorEsperado = month%2==0?calculoMesPar:2935.333F;
		assertEquals(valorEsperado, manager.cs(), 0.001F);
	}
	
	@Test
	void  testBonusManager() {
		assertEquals(3236, manager.CalculateYearBonus());
		assertTrue(manager.CalculateYearBonus() > 0);
	}
	
	
	
}

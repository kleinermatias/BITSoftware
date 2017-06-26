package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.Asientos;

public class AsientosTest {
	private Asientos a=new Asientos("12:00",4,5); //creamos asientos 4*5 todos como libres/disponibles 
	
	@Before
	public void setUp() {
		a.booking(3, 2); //Seteamos algunos asientos como usados
		a.booking(1, 1);
	}
	
	@Test
	public void testBooking() {
		assertEquals(a.isAvailable(3,2),false); //probamos tambien que efectivamente la plaza este ocupada
		assertFalse(a.isAvailable(3,2)==true); //la prueba pasa si es falso que la plaza 3,2 esta libre	
	}
	
	@Test
	public void testAsientos() {
		assertEquals("12:00",a.getShowTime()); //Probamos constructor. El mismo setea a un grupo de asientos, un horario de inicio de funcion
		assertFalse("13:00"==a.getShowTime());	// La prueba pasa si el horario de inicio es el seteado y si no es uno diferente a 12:00
	}

	@Test
	public void testIsAvailable() {
		assertEquals(a.isAvailable(3, 2),false); // Se prueba el metodo IsAvailable, pasa si esta ocupado el asiento.
		assertFalse(a.isAvailable(1, 2)==false); // Se prueba el metodo IsAvailabl, pasa cuando recibe asientos disponibles.
	}


	@Test
	public void testUnbooking() {
		assertEquals(a.isAvailable(3, 2),false); //probamos que esta ocupado el asiento
		a.unbooking(3, 2); // liberamos el asiento
		assertEquals(a.isAvailable(3, 2),true); //comprobamos que el asiento se libero
		assertFalse(a.isAvailable(1, 1)==true); //como el asiento esta ocupado, el test pasa. 
	}

	@Test
	public void testGetShowTime() {
		assertEquals(a.getShowTime(),"12:00"); // comprobamos si hay funcion a esa hora.
		assertFalse(a.getShowTime()!="12:00"); // si llega 12:00 hs pasa el test, al ser test negativo. 
	}

	@Test
	public void testUnbookingAll() { 				//funciona igual que el testUNbooking
		assertEquals(a.isAvailable(1, 1),false);
		assertEquals(a.isAvailable(3, 2),false);
		a.unbookingAll();
		assertEquals(a.isAvailable(1, 1),true);
		assertEquals(a.isAvailable(3, 2),true);
	}

}

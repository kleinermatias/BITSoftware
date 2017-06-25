package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import src.Asientos;
import src.Salas;

public class SalasTest {
	private Salas s;
	private Salas j;
	
	
	@Before
	public void setUp() {
		s=new Salas("Sala Z", 100.00, 7, 8, "10D");
		s.addShowTime("14:00");
	}
	
	@Test
	public void testSalas() {
		j=new Salas("Sala C", 120.00, 3, 4, "1D");
		assertEquals(j.getName(),"Sala C");
		assertFalse(j.getName()=="Sala D");
		assertEquals(j.getColumn(),4);
		assertFalse(j.getColumn()==6);
		assertEquals(j.getRow(),3);
		assertFalse(j.getRow()==10);
		assertEquals(j.getLevel(),"1D");
		assertFalse(j.getLevel()=="5D");
		
	}

	@Test
	public void testAddShowTime() {
		s.addShowTime("12:00");
		assertEquals(s.getSeats().containsKey("12:00"),true);
		assertFalse(s.getSeats().containsKey("13:00")==true);
	}

	@Test
	public void testGetPrice() {
		final double delta = 1e-15;
		assertEquals(s.getPrice(), 100.00, delta);
		assertFalse(s.getPrice()==1.35);
	}

	@Test
	public void testGetLevel() {
		assertEquals(s.getLevel(), "10D");
		assertFalse(s.getLevel()=="12D");
	}

	@Test
	public void testGetName() {
		assertEquals(s.getName(), "Sala Z");
		assertFalse(s.getName()=="Cualquier otro");
	}

	@Test
	public void testGetRow() {
		assertEquals(s.getRow(), 7);
		assertFalse(s.getRow()==8);
	}

	@Test
	public void testGetColumn() {
		assertEquals(s.getColumn(), 8);
		assertFalse(s.getColumn()==10);
	}

	@Test
	public void testGetSeats() {
		assertEquals(s.getSeats().containsKey("14:00"),true);
	}

}

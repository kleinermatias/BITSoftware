package test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import src.Asientos;
import src.Peliculas;
import src.Salas;

public class PeliculasTest {
	private Peliculas m;
	
	@Before
	public void setUp() {
	this.m= new Peliculas("titulo", "descripcion", "duracion");

	}
	
	@Test
	public void testMovie() {
		assertEquals("titulo",m.getTitle());
		assertEquals("descripcion",m.getDescription());
		assertEquals("duracion",m.getLength());
	}


	@Test
	public void testAddTheater() {
		m.addTheater("Sala A", 100.00, 4, 4, "3d");
		assertEquals(m.getTheater().get("Sala A").getName(),"Sala A");
		assertEquals(m.getTheater().get("Sala A").getColumn(),4);
		assertEquals(m.getTheater().get("Sala A").getRow(),4);
		assertEquals(m.getTheater().get("Sala A").getLevel(),"3d");
	}
	
	@Test
	public void testsetTitle() {
		m.setTitle("Hola");
		assertEquals(m.getTitle(),"Hola");
		assertFalse(m.getTitle()=="Chau");
		
	}
	
	@Test
	public void testsetDescription() {
		m.setDescription("Juan el scrumMaster");
		assertEquals(m.getDescription(),"Juan el scrumMaster");
		assertFalse(m.getDescription()=="Otra cosa");
	}

	@Test
	public void testgetTitle() {
		assertFalse(m.getTitle()=="Otra cosa");
		assertEquals(m.getTitle(),"titulo");
	}
}
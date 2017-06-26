package test;

import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;

import src.Peliculas;
import src.PeliculasModel;
import src.Salas;
import src.Ticket;



public class PeliculasModelTest {
	private PeliculasModel modelo=PeliculasModel.getInstance();
	String[] des = {"element1-ok","element2-99","element3-5,5","dsfsdf","adsdd","asas"};

	
	@Before
	public void setUp() {
	modelo.readData();
	}
	
	@Test
	public void testReadData() {
		assertEquals(modelo.getAllTheaters().get("Sala A").getLevel(),"normal");				// se quiere probar el tipo de cine disponible, supera el test si se instancia un cine tipo normal.
		assertFalse(modelo.getAllTheaters().get("Sala A").getLevel()=="Cualquier otra cosa");	// solo pasa si recibe un tipo normal. 
	}


	@Test
	public void testGetAllMovies() {
		assertEquals(modelo.getAllMovies().get("Wonder Woman").getTitle(),"Wonder Woman");
		assertFalse(modelo.getAllMovies().get("Wonder Woman").getTitle()=="Cualquier otro");
	}

	@Test
	public void testGetAllTheaters() {
		assertEquals(modelo.getAllTheaters().containsKey("Sala A"),true);
		assertFalse(modelo.getAllTheaters().containsKey("Sala A")==false);
	}
	
	@Test
	public void testGetCount() {
		
		assertEquals(modelo.getCount(),1);
		assertFalse(modelo.getCount()==5);
	}

}

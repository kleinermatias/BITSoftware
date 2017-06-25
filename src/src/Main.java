package src;

public class Main {
	public static void main(String[] args) {

		Ticket mm = new Ticket();
		PeliculasView ui = new PeliculasView();
		PeliculasController mvc = new PeliculasController(ui, mm);
		mvc.run();


	}
}

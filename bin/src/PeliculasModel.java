package src;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.*;


public class PeliculasModel {
	private static PeliculasModel instance = null;
	private Map<String, Peliculas> movies = new HashMap<String, Peliculas>();
	private Map<String, Salas> theaters = new HashMap<String, Salas>();
	private CsvReader products;
	private CsvWriter csvOutput;
	private final String OUTPUTFILE = "numero_ticket";
	private int count = 1;

	   protected PeliculasModel() {
		   }
	   
	   
	public void readData() {
		if (!new File("Salas.csv").exists() || !new File("Peliculas.csv").exists())
			throw new RuntimeException();
		try {
			products = new CsvReader("Salas.csv");
			products.readHeaders();
			while (products.readRecord()) {
				String sala = products.get("Sala");
				int fila = Integer.parseInt(products.get("Fila"));
				int columna = Integer.parseInt(products.get("Columna"));
				double precio = Double.parseDouble(products.get("Precio"));
				String tipo = products.get("Tipo");
				theaters.put(sala, new Salas(sala, precio, fila, columna, tipo));
			}
			products = new CsvReader("Peliculas.csv");
			products.readHeaders();
			while (products.readRecord()) {
				String theater = products.get("Sala");
				String movie = products.get("Pelicula");
				String description = products.get("Descripcion");
				String length = products.get("Duracion");
				String Show_Time = products.get("Hora de Inicio");
				String[] splitTime = Show_Time.split(" ");
				for (String s : splitTime)
					addMovie(movie, description, length, theater, s);
			}
			products.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void writeFile(Ticket ticket) {
		String fileName = OUTPUTFILE + count + ".txt";
		try {
			csvOutput = new CsvWriter(new FileWriter(fileName), '\n');
			csvOutput.write("Pelicula : " + ticket.getCurrentMovie().getTitle());
			csvOutput.endRecord();
			csvOutput.write("-----------------------------");
			csvOutput.endRecord();
			for (String des : ticket.getDescription()) {
				String[] splitDetail = des.split("-");
				csvOutput.write("Sala : " + splitDetail[0]);
				csvOutput.endRecord();
				csvOutput.write("Hora de Inicio : " + splitDetail[1]);
				csvOutput.endRecord();
				csvOutput.write("Lugar (fila,columna) : " + splitDetail[2]);
				csvOutput.endRecord();
				csvOutput.write("Precio : " + splitDetail[3]);
				csvOutput.endRecord();
				csvOutput.write("-----------------------------");
				csvOutput.endRecord();
			}
			csvOutput.write("Precio total : " + ticket.getTotalPrice() + " Pesos Arg.");
			csvOutput.endRecord();
			csvOutput.write("Total de asientos : " + ticket.getAmount());
			csvOutput.close();
			Desktop desktop = Desktop.getDesktop();
			desktop.open(new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		count++;
	}


	private void addMovie(String name, String des, String length, String theater, String showTime) {
		if (!movies.containsKey(name))
			movies.put(name, new Peliculas(name, des, length));
		if (theaters.containsKey(theater)) {
			Salas temp = theaters.get(theater);
			movies.get(name).addTheater(temp.getName(), temp.getPrice(), temp.getRow(), temp.getColumn(),
					temp.getLevel());
			movies.get(name).addShowtime(theater, showTime);
		}
	}


	public Map<String, Peliculas> getAllMovies() {
		return this.movies;
	}


	public Map<String, Salas> getAllTheaters() {
		return this.theaters;
	}
	
	public int getCount(){
		return this.count;
	}

	public static PeliculasModel getInstance() {
	    if(instance == null) {
	       instance = new PeliculasModel();
	    }
	    else{
            System.out.println("No se puede crear el objeto porque ya existe un objeto de la clase Modelo");
	    }
	    return instance;
	 }
	}



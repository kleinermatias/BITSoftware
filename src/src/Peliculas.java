package src;

import java.util.HashMap;
import java.util.Map;

public class Peliculas {

	private String title;
	private String description;
	private String length;
	private Map<String, Salas> theaterMap = new HashMap<String, Salas>();

	public Peliculas(String title, String des, String length) {
		this.title = title;
		this.description = des;
		this.length = length;
	}

	public void addShowtime(String nameTheater, String showTime) {
		if (theaterMap.containsKey(nameTheater))
			this.theaterMap.get(nameTheater).addShowTime(showTime);
	}


	public void addTheater(String nameTheater, double price, int row, int column, String level) {
		if (!theaterMap.containsKey(nameTheater))
			this.theaterMap.put(nameTheater, new Salas(nameTheater, price, row, column, level));
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getTitle() {
		return this.title;
	}


	public String getDescription() {
		return this.description;
	}


	public String getLength() {
		return length;
	}


	public void setLength(String length) {
		this.length = length;
	}


	public Map<String, Salas> getTheater() {
		return this.theaterMap;
	}

}

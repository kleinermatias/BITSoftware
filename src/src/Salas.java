package src;

import java.util.HashMap;
import java.util.Map;



public class Salas {

	private Map<String, Asientos> seatMap = new HashMap<String, Asientos>();
	private String name;
	private int row;
	private int column;
	private double price;
	private String level;


	public Salas(String name, double price, int row, int column, String level) {
		this.name = name;
		this.row = row;
		this.column = column;
		this.price = price;
		this.level = level;
	}


	public void addShowTime(String showTime) {
		if (!seatMap.containsKey(showTime))
			seatMap.put(showTime, new Asientos(showTime, row, column));
	}


	public double getPrice() {
		return this.price;
	}


	public String getLevel() {
		return this.level;
	}


	public String getName() {
		return name;
	}


	public int getRow() {
		return row;
	}


	public int getColumn() {
		return column;
	}


	public Map<String, Asientos> getSeats() {
		return this.seatMap;
	}

}

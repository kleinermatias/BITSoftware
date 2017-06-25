package src;

import java.util.ArrayList;
import java.util.List;


public class Ticket {

	private Salas currentTheater;
	private Salas tempTheater;
	private Asientos currentSeat;
	private Peliculas tempMovie;
	private Peliculas realObjectMovie;
	private int count; 
	private List<String> description = new ArrayList<>();
	

	public void setMovie(Peliculas movie) {
		this.resetAll();
		realObjectMovie = movie;
		tempMovie = createCopyMovie(movie);
	}


	public void confirm() {
		for (String s : this.tempMovie.getTheater().keySet())
			for (String x : this.tempMovie.getTheater().get(s).getSeats().keySet()) {
				int row = this.tempMovie.getTheater().get(s).getRow();
				int column = this.tempMovie.getTheater().get(s).getColumn();
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < column; j++) {
						if (!this.tempMovie.getTheater().get(s).getSeats().get(x).isAvailable(i, j))
							this.realObjectMovie.getTheater().get(s).getSeats().get(x).booking(i, j);
					}
				}
			}
		this.resetAll();
	}


	public String[] getDescription() {
		String[] allDescription = new String[this.description.size()];
		return this.description.toArray(allDescription);
	}


	public boolean isChecked(int row, int column) {
		if (currentSeat.isAvailable(row, column))
			return false;
		return true;
	}
	
	public Peliculas getTempMovie() {
		return this.tempMovie;
	}
	public Peliculas getRealObjectMovie() {
		return this.realObjectMovie;
	}
	public Salas getTempTheater() {
		return this.tempTheater;
	}


	public void unbooking(int row, int column) {
		this.currentSeat.unbooking(row, column);
		description.remove(currentTheater.getName() + "-" + currentSeat.getShowTime() + "-" + (row + 1) + ","
				+ (column + 1) + "-" + currentTheater.getPrice());
		count--;
	}

	public void booking(int row, int column) {
		this.currentSeat.booking(row, column);
		description.add(currentTheater.getName() + "-" + currentSeat.getShowTime() + "-" + (row + 1) + ","
				+ (column + 1) + "-" + currentTheater.getPrice());
		count++;
	}


	public double getTotalPrice() {
		return this.currentTheater.getPrice() * this.getAmount();
	}


	public Peliculas getCurrentMovie() {
		return this.tempMovie;
	}


	public Salas getCurrentTheater() {
		return this.currentTheater;
	}


	public void setCurrentShowtime(String showtime) {
		this.currentSeat = tempTheater.getSeats().get(showtime);
	}


	public Asientos getCurrentShowtime() {
		return this.currentSeat;
	}

	public void setCurrentTheater(String theater) {
		this.currentTheater = this.realObjectMovie.getTheater().get(theater);
		this.tempTheater = this.tempMovie.getTheater().get(theater);
	}


	public int getAmount() {
		return this.count;
	}


	public double getPrice() {
		return this.currentTheater.getPrice();
	}

	public void resetAll() {
		if (this.tempMovie != null) {
			for (String s : this.tempMovie.getTheater().keySet()) {
				for (String x : this.tempMovie.getTheater().get(s).getSeats().keySet())
					this.tempMovie.getTheater().get(s).getSeats().get(x).unbookingAll();
			}
			count = 0;
			this.description = new ArrayList<>();
		}
	}

	public void reset() {
		int number_deleted = this.currentSeat.unbookingAll();
		this.count -= number_deleted;
		for (int i = 0; i < this.description.size(); i++)
			if (description.get(i).contains(this.currentTheater.getName()))
				description.remove(i);
	}


	public Peliculas createCopyMovie(Peliculas movie) {
		Peliculas copy = new Peliculas(movie.getTitle(), movie.getDescription(), movie.getLength());

		for (String s : movie.getTheater().keySet()) {
			String copyName = s;
			double copyPrice = movie.getTheater().get(s).getPrice();
			int copyRow = movie.getTheater().get(s).getRow();
			int copyColumn = movie.getTheater().get(s).getColumn();
			String copyLevel = movie.getTheater().get(s).getLevel();
			copy.addTheater(copyName, copyPrice, copyRow, copyColumn, copyLevel);
		}

		for (String s : movie.getTheater().keySet())
			for (String x : movie.getTheater().get(s).getSeats().keySet()) {
				String copyShowtime = movie.getTheater().get(s).getSeats().get(x).getShowTime();
				copy.addShowtime(s, copyShowtime);

				int row = movie.getTheater().get(s).getRow();
				int column = movie.getTheater().get(s).getColumn();
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < column; j++) {
						if (movie.getTheater().get(s).getSeats().get(x).isAvailable(i, j))
							copy.getTheater().get(s).getSeats().get(x).unbooking(i, j);
						else
							copy.getTheater().get(s).getSeats().get(x).booking(i, j);
					}
				}
			}
		return copy;
	}

}
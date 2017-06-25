package src;


public class Asientos {

	private int[][] seats; // 1 es ocupado, 0 disponible.
	private String showTime;

	public Asientos(String showTime, int row, int column) {
		this.showTime = showTime;
		seats = new int[row][column];
	}


	public boolean isAvailable(int row, int column) {
		if (seats[row][column] != 0)
			return false;
		return true;
	}


	public void booking(int row, int column) {
		if (isAvailable(row, column))
			seats[row][column] = 1;
	}


	public void unbooking(int row, int column) {
		if (!isAvailable(row, column))
			seats[row][column] = 0;
	}


	public String getShowTime() {
		return this.showTime;
	}


	public int unbookingAll() {
		int count = 0;
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[0].length; j++) {
				if (this.seats[i][j] == 1) {
					this.seats[i][j] = 0;
					count++;
				}
			}
		}
		return count;
	}

}
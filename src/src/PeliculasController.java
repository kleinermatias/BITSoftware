package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;


public class PeliculasController {

	private Ticket ticket;
	private PeliculasModel manager = new PeliculasModel();
	private PeliculasView ui;
	private Map<String, Peliculas> movies;
	private DefaultListModel<String> movieList = new DefaultListModel<>();


	public PeliculasController(PeliculasView ui, Ticket ticket) {
		this.ticket = ticket;
		this.ui = ui;
		try {
			this.manager.readData();
			this.movies = manager.getAllMovies();
			addMovieList(movies);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(ui, "Error al leer fichero .csv");
			System.exit(0);
		}
	}


	public void run() {
		control();
		this.ui.run();
	}


	public void control() {
		linkTheaterComboBox();
		linkChooseMovieButton();
		linkShowTimeComboBox();
		linkBuyButton();
		linkClearButton();
	}


	private void linkChooseMovieButton() {
		ui.getChooseMovieButton().addActionListener(e -> chooseMovieButtonActionPerformed(e));
	}


	private void linkTheaterComboBox() {
		ui.getTheaterComboBox().addActionListener(e -> setShowTime());
	}


	private void linkShowTimeComboBox() {
		ui.getShowTimeComboBox().addActionListener(e -> showTimeComboBoxActionPerformed(e));
	}


	private void linkBuyButton() {
		ui.getBuyButton().addActionListener(e -> buyButtonActionPerformed(e));
	}


	private void linkClearButton() {
		ui.getClearButton().addActionListener(e -> clearButtonActionPerformed(e));
	}


	private void clearButtonActionPerformed(ActionEvent evt) {
		if (ticket.getCurrentMovie() != null) {
			ticket.reset();
			ui.getRowAndColumnPanel().removeAll();
			creatButtonWithEnterRowAndCol(ticket.getCurrentTheater().getRow(), ticket.getCurrentTheater().getColumn());
			ui.getSeatTextField().setText("");
			ui.getPriceTextField().setText("");
		}
	}


	private void buyButtonActionPerformed(ActionEvent evt) {
		if (ticket.getCurrentMovie() == null)
			JOptionPane.showMessageDialog(ui, "Seleccione pelicula y sus asientos");
		else {
			JPanel panel = new JPanel(new BorderLayout());
			
			JPanel totalInfo = new JPanel();
			JLabel movieNameLabel = new JLabel("Nombre de la pelicula");
			JLabel totalSeatLabel = new JLabel("Asientos totales seleccionados:");
			JLabel totalPriceLabel = new JLabel("Precio total:");
			JTextField movieNameTextField = new JTextField(ticket.getCurrentMovie().getTitle() + "");
			JTextField totalSeatTextField = new JTextField(ticket.getAmount() + "");
			JTextField totalPriceTextField = new JTextField(ticket.getTotalPrice() + "");

			movieNameTextField.setEditable(false);
			totalSeatTextField.setEditable(false);
			totalPriceTextField.setEditable(false);

			Icon buyIcon = new ImageIcon("/image/money.png");
			
			String[] bookingInfo = ticket.getDescription();
			int row = bookingInfo.length;
			Object[][] data = new Object[row + 1][4];
			String[] columnNames = { "Sala", "Hora de inicio", "Asiento", "Precio" };
			/** Add head */
			data[0][0] = "Sala";
			data[0][1] = "Hora de inicio";
			data[0][2] = "Asiento";
			data[0][3] = "Precio";
			/** add Data */
			for (int i = 0; i < row; i++) {
				for (int k = 0; k < 4; k++) {
					String[] tempData = bookingInfo[i].split("-");
					data[i + 1][k] = tempData[k];
				}
			}
			JTable table = new JTable(data, columnNames);
			table.setEnabled(false);

			totalInfo.add(movieNameLabel);
			totalInfo.add(movieNameTextField);
			totalInfo.add(totalSeatLabel);
			totalInfo.add(totalSeatTextField);
			totalInfo.add(totalPriceLabel);
			totalInfo.add(totalPriceTextField);

			panel.add(table, BorderLayout.NORTH);
			panel.add(totalInfo, BorderLayout.SOUTH);

			if (ticket.getCurrentMovie() != null) {
				int seats = ticket.getAmount();
				if (seats > 0) {
					int n = JOptionPane.showConfirmDialog(ui, panel, "Confirma la reserva?", JOptionPane.YES_OPTION,
							JOptionPane.QUESTION_MESSAGE, buyIcon);
					if (n == 0) {
						manager.writeFile(ticket);
						ticket.confirm();
						reset();
					}
				}
			}
		}
	}


	private void reset() {
		ui.getRowAndColumnPanel().removeAll();
		int row = ticket.getCurrentTheater().getRow();
		int column = ticket.getCurrentTheater().getColumn();
		creatButtonWithEnterRowAndCol(row, column);
		ui.getSeatTextField().setText(ticket.getAmount() + "");
		ui.getPriceTextField().setText(ticket.getTotalPrice() + "");
	}


	private void chooseMovieButtonActionPerformed(ActionEvent evt) {
		if (ui.getMovieJList().getSelectedValue() == null)
			JOptionPane.showMessageDialog(ui, "Please select movie");
		else {
			if (ticket.getCurrentMovie() == null)
				setChoosedMovie();
			else if (!ui.getMovieJList().getSelectedValue().equals(ticket.getCurrentMovie().getTitle())) {
				int i = JOptionPane.showConfirmDialog(null, "¿Quiere cambiar de pelicula?", "",
						JOptionPane.YES_NO_OPTION);
				if (i == 0)
					setChoosedMovie();
			} else
				setChoosedMovie();
		}
	}


	private void showTimeComboBoxActionPerformed(ActionEvent evt) {
		if (ui.getShowTimeComboBox().getSelectedItem() != null) {
			ui.getRowAndColumnPanel().removeAll();
			ticket.setCurrentShowtime(ui.getShowTimeComboBox().getSelectedItem().toString());
			creatButtonWithEnterRowAndCol(ticket.getCurrentTheater().getRow(), ticket.getCurrentTheater().getColumn());
		}
	}


	private void setChoosedMovie() {
		ticket.setMovie(movies.get(ui.getMovieJList().getSelectedValue()));
		for (String s : movies.keySet()) {
			if (s.equalsIgnoreCase(ui.getMovieJList().getSelectedValue())) {
				ui.getMovieTextField().setText(ticket.getCurrentMovie().getTitle());
				ui.getLengthTextField().setText(ticket.getCurrentMovie().getLength());
				ui.getDescriptionTextArea().setText(ticket.getCurrentMovie().getDescription());
				ui.getTheaterComboBox().removeAllItems();
				Map<String, Salas> test = ticket.getCurrentMovie().getTheater();
				for (String theater : test.keySet())
					ui.getTheaterComboBox().addItem(theater);
			}
		}
	}


	private void setShowTime() {
		if (ui.getTheaterComboBox().getSelectedItem() != null) {
			String theater = ui.getTheaterComboBox().getSelectedItem().toString();
			ticket.setCurrentTheater(theater);
			if (ticket.getCurrentTheater().getLevel().equalsIgnoreCase("4D"))
				ui.getIconTheaterLabel().setIcon(new ImageIcon(this.getClass().getResource("/image/4D.png")));
			else if (ticket.getCurrentTheater().getLevel().equalsIgnoreCase("3D"))
				ui.getIconTheaterLabel().setIcon(new ImageIcon(this.getClass().getResource("/image/3D.png")));
			else
				ui.getIconTheaterLabel().setIcon(null);
			ui.getPricePerSeatTextField().setText(ticket.getPrice() + "");
			ui.getShowTimeComboBox().removeAllItems();
			for (String showTime : ticket.getCurrentTheater().getSeats().keySet())
				ui.getShowTimeComboBox().addItem(showTime);
			ui.getRowAndColumnPanel().removeAll();
			ui.revalidate();
			ui.repaint();
			creatButtonWithEnterRowAndCol(ticket.getCurrentTheater().getRow(), ticket.getCurrentTheater().getColumn());
		}
	}


	private boolean isTimePassedShowtime(String selectedDate) {
		String currentDate = ui.getCurrentTimeLabel().getText().substring(0, 5).replace('.', ':');
		LocalTime time = LocalTime.parse(currentDate);
		LocalTime other = LocalTime.parse(selectedDate.replace('.', ':'));
		if (time.isAfter(other))
			return true;
		return false;
	}

	private void creatButtonWithEnterRowAndCol(int row, int col) {
		JToggleButton[][] buttons = new JToggleButton[row][col];
		JPanel pane = new JPanel();
		pane.setBackground(Color.BLACK);
		pane.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		GridLayout gl = new GridLayout(row, col);
		gl.setHgap(7);
		gl.setVgap(15);
		pane.setLayout(gl);
		
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j] = new JToggleButton();
				buttons[i][j].setActionCommand(i + " " + j);
				buttons[i][j].setPreferredSize(new Dimension(30, 30));
				buttons[i][j].setToolTipText("Row: " + (i + 1) + " ,Column: " + (j + 1));
				String selectedShowTime = ui.getShowTimeComboBox().getSelectedItem().toString();
				if (isTimePassedShowtime(selectedShowTime)) {
					buttons[i][j].setIcon(new ImageIcon(this.getClass().getResource("/image/seatAvailable.jpg")));
					buttons[i][j].setEnabled(false);
				} else if (!checkIsAvailable(i, j)) {
					buttons[i][j].setIcon(new ImageIcon(this.getClass().getResource("/image/seatFull.jpg")));
				} else if (ticket.isChecked(i, j)) {
					buttons[i][j].setIcon(new ImageIcon(this.getClass().getResource("/image/seatSelected.png")));
					buttons[i][j].addActionListener(buttonActions);
				} else {
					buttons[i][j].setIcon(new ImageIcon(this.getClass().getResource("/image/seatAvailable.jpg")));
					buttons[i][j].addActionListener(buttonActions);
				}
				pane.add(buttons[i][j]);
			}
		}
		ui.getRowAndColumnPanel().add(pane);
		ui.validate();
	}


	private boolean checkIsAvailable(int row, int column) {
		return ticket.getCurrentTheater().getSeats().get(ui.getShowTimeComboBox().getSelectedItem()).isAvailable(row,
				column);
	}

	
	private ActionListener buttonActions = (ActionEvent ae) -> {
		JToggleButton button = (JToggleButton) ae.getSource();
		if (button.isSelected()) {
			button.setIcon(new ImageIcon(this.getClass().getResource("/image/seatSelected.png")));
			int[] temp = arrStringToInt(button.getActionCommand());
			ticket.booking(temp[0], temp[1]);
		} else {
			button.setIcon(new ImageIcon(this.getClass().getResource("/image/seatAvailable.jpg")));
			int[] temp = arrStringToInt(button.getActionCommand());
			ticket.unbooking(temp[0], temp[1]);
		}
		ui.getSeatTextField().setText(ticket.getAmount() + "");
		ui.getPriceTextField().setText(ticket.getTotalPrice() + "");
	};


	private int[] arrStringToInt(String string) {
		String[] tempString = string.split(" ");
		int[] tempInt = new int[2];
		tempInt[0] = Integer.parseInt(tempString[0]);
		tempInt[1] = Integer.parseInt(tempString[1]);
		return tempInt;
	}

	private void addMovieList(Map<String, Peliculas> inputMovies) {
		for (String s : inputMovies.keySet())
			movieList.addElement(inputMovies.get(s).getTitle());
		ui.getMovieJList().setModel(movieList);
	}
}

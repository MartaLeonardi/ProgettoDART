package PortaleAmministratore;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;

import GestioneTurni.VisualizzaServiziControl;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VisualizzaServizi extends JPanel {
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	String dataI = "";
	String[] array1 = new String[3];
	String[] array2 = new String[3];
	String[] array3 = new String[3];
	String[] array4 = new String[3];
	Date newData = new Date();
	String d = simpleDateFormat.format(newData);
	String t00;
	String t10;
	String t20;

	static String pattern = "yyyy-MM-dd";
	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

	/**
	 * Create the panel.
	 */
	public VisualizzaServizi() {
		setBounds(100, 100, 1200, 800);
		setLayout(new BorderLayout(0, 0));

		VisualizzaServiziControl visSerControl = new VisualizzaServiziControl();

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel logoImg = new JLabel("");
		logoImg.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgLogo = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		panel.setLayout(new BorderLayout(0, 0));
		logoImg.setIcon(new ImageIcon(imgLogo));
		panel.add(logoImg);
		panel.add(logoImg);
		logoImg.setAlignmentX(Component.CENTER_ALIGNMENT);
		logoImg.setFont(new Font("Arial", Font.PLAIN, 30));

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		panel.add(separator, BorderLayout.SOUTH);

		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_5.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		add(panel_5, BorderLayout.SOUTH);

		JButton indietroButtom = new JButton("Indietro");
		indietroButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PortaleAmministratore.back();
			}
		});
		indietroButtom.setHorizontalTextPosition(SwingConstants.LEFT);
		indietroButtom.setHorizontalAlignment(SwingConstants.LEFT);
		indietroButtom.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_5.add(indietroButtom);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));

		JCalendar calendar = new JCalendar();
		calendar.setTodayButtonVisible(true);
		panel_1.add(calendar, BorderLayout.NORTH);

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		JPanel panel_7 = new JPanel();
		JPanel panel_8 = new JPanel();
		JPanel panel_9 = new JPanel();

		JButton selezionaDataButtom = new JButton("Selezione Data");
		selezionaDataButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date dataInseritaInizio = calendar.getDate();
				d = simpleDateFormat.format(dataInseritaInizio);

				array1 = visSerControl.getStato(d, "Servizio 1");
				array2 = visSerControl.getStato(d, "Servizio 2");
				array3 = visSerControl.getStato(d, "Servizio 3");
				array4 = visSerControl.getStato(d, "Servizio 4");

				JTable table = new JTable();
				panel_6.add(table.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers
																			// delle
				// colonne
				panel_6.add(table, BorderLayout.CENTER);
				table.setModel(new DefaultTableModel(new Object[][] { { array1[0], array1[1], array1[2] }, },
						new String[] { "00:00:-08:00", "08:00-16:00", "16:00-00:00" }) {
					Class[] columnTypes = new Class[] { String.class, String.class, String.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				table.getColumnModel().getColumn(0).setResizable(false);
				table.getColumnModel().getColumn(1).setResizable(false);
				table.getColumnModel().getColumn(2).setResizable(false);
				table.getTableHeader().setReorderingAllowed(false); // Disattiva la possibilita di riordinare le colonne

				table_1 = new JTable();
				panel_7.add(table_1.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers
																			// delle
				// colonne
				panel_7.add(table_1, BorderLayout.CENTER);

				table_1.setModel(new DefaultTableModel(new Object[][] { { array2[0], array2[1], array2[2] }, },
						new String[] { "00:00-08:00", "08:00-16:00", "16:00-00:00" }) {
					Class[] columnTypes = new Class[] { String.class, String.class, String.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				table_1.getColumnModel().getColumn(0).setResizable(false);
				table_1.getColumnModel().getColumn(1).setResizable(false);
				table_1.getColumnModel().getColumn(2).setResizable(false);
				table_1.getTableHeader().setReorderingAllowed(false); // Disattiva la possibilita di riordinare le
																		// colonne
				// trascinando

				table_2.setModel(new DefaultTableModel(new Object[][] { { array3[0], array3[1], array3[2] }, },
						new String[] { "00:00-08:00", "08:00-16:00", "16:00-00:00" }) {
					Class[] columnTypes = new Class[] { String.class, String.class, String.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}

					boolean[] columnEditables = new boolean[] { false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				table_2.getColumnModel().getColumn(0).setResizable(false);
				table_2.getColumnModel().getColumn(1).setResizable(false);
				table_2.getColumnModel().getColumn(2).setResizable(false);
				table_2.getTableHeader().setReorderingAllowed(false); // Disattiva la possibilita di riordinare le
																		// colonne
				// trascinando

				table_3 = new JTable();
				panel_9.add(table_3.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers
																			// delle
				// colonne
				panel_9.add(table_3, BorderLayout.CENTER);

				table_3.setModel(new DefaultTableModel(new Object[][] { { array4[0], array4[1], array4[2] }, },
						new String[] { "00:00-08:00", "08:00-16:00", "16:00-00:00" }) {
					Class[] columnTypes = new Class[] { String.class, String.class, String.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				table_3.getColumnModel().getColumn(0).setResizable(false);
				table_3.getColumnModel().getColumn(1).setResizable(false);
				table_3.getColumnModel().getColumn(2).setResizable(false);
				table_3.getTableHeader().setReorderingAllowed(false); // Disattiva la possibilita di riordinare le
																		// colonne
				// trascinando

			}
		});
		selezionaDataButtom.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_2.add(selezionaDataButtom, BorderLayout.NORTH);

		JPanel panel_2_1 = new JPanel();
		add(panel_2_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2_1 = new GridBagLayout();
		gbl_panel_2_1.columnWidths = new int[] { 251, 0, 380, 0 };
		gbl_panel_2_1.rowHeights = new int[] { 71, 0, 70, 0, 71, 0, 58, 0 };
		gbl_panel_2_1.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2_1.setLayout(gbl_panel_2_1);

		JLabel servizioUnoLabel = new JLabel("Servizio uno");
		servizioUnoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_servizioUnoLabel = new GridBagConstraints();
		gbc_servizioUnoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_servizioUnoLabel.gridx = 0;
		gbc_servizioUnoLabel.gridy = 0;
		panel_2_1.add(servizioUnoLabel, gbc_servizioUnoLabel);

		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.gridx = 2;
		gbc_panel_6.gridy = 0;
		panel_2_1.add(panel_6, gbc_panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		JTable table = new JTable();
		panel_6.add(table.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers delle
		// colonne
		panel_6.add(table, BorderLayout.CENTER);
		table.setModel(new DefaultTableModel(new Object[][] { { array1[0], array1[1], array1[2] }, },
				new String[] { "00:00:-08:00", "08:00-16:00", "16:00-00:00" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getTableHeader().setReorderingAllowed(false); // Disattiva la possibilita di riordinare le colonne
		// trascinando

		JLabel servizioDueLabel = new JLabel("Servizio due");
		servizioDueLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_servizioDueLabel = new GridBagConstraints();
		gbc_servizioDueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_servizioDueLabel.gridx = 0;
		gbc_servizioDueLabel.gridy = 2;
		panel_2_1.add(servizioDueLabel, gbc_servizioDueLabel);

		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.gridx = 2;
		gbc_panel_7.gridy = 2;
		panel_2_1.add(panel_7, gbc_panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		table_1 = new JTable();
		panel_7.add(table_1.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers delle
		// colonne
		panel_7.add(table_1, BorderLayout.CENTER);

		table_1.setModel(new DefaultTableModel(new Object[][] { { array2[0], array2[1], array2[2] }, },
				new String[] { "00:00-08:00", "08:00-16:00", "16:00-00:00" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.getColumnModel().getColumn(2).setResizable(false);
		table_1.getTableHeader().setReorderingAllowed(false); // Disattiva la possibilita di riordinare le colonne
		// trascinando

		JLabel servizioTreLabel = new JLabel("Servizio tre");
		servizioTreLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_servizioTreLabel = new GridBagConstraints();
		gbc_servizioTreLabel.insets = new Insets(0, 0, 5, 5);
		gbc_servizioTreLabel.gridx = 0;
		gbc_servizioTreLabel.gridy = 4;
		panel_2_1.add(servizioTreLabel, gbc_servizioTreLabel);

		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.gridx = 2;
		gbc_panel_8.gridy = 4;
		panel_2_1.add(panel_8, gbc_panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		table_2 = new JTable();
		panel_8.add(table_2.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers delle
		// colonne
		panel_8.add(table_2, BorderLayout.CENTER);

		table_2.setModel(new DefaultTableModel(new Object[][] { { array3[0], array3[1], array3[2] }, },
				new String[] { "00:00-08:00", "08:00-16:00", "16:00-00:00" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_2.getColumnModel().getColumn(0).setResizable(false);
		table_2.getColumnModel().getColumn(1).setResizable(false);
		table_2.getColumnModel().getColumn(2).setResizable(false);
		table_2.getTableHeader().setReorderingAllowed(false); // Disattiva la possibilita di riordinare le colonne
		// trascinando

		JLabel servizioQuattro = new JLabel("Servizio quattro");
		servizioQuattro.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_servizioQuattro = new GridBagConstraints();
		gbc_servizioQuattro.insets = new Insets(0, 0, 0, 5);
		gbc_servizioQuattro.gridx = 0;
		gbc_servizioQuattro.gridy = 6;
		panel_2_1.add(servizioQuattro, gbc_servizioQuattro);

		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_9.gridx = 2;
		gbc_panel_9.gridy = 6;
		panel_2_1.add(panel_9, gbc_panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		table_3 = new JTable();
		panel_9.add(table_3.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers delle
		// colonne
		panel_9.add(table_3, BorderLayout.CENTER);

		table_3.setModel(new DefaultTableModel(new Object[][] { { array4[0], array4[1], array4[2] }, },
				new String[] { "00:00-08:00", "08:00-16:00", "16:00-00:00" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_3.getColumnModel().getColumn(0).setResizable(false);
		table_3.getColumnModel().getColumn(1).setResizable(false);
		table_3.getColumnModel().getColumn(2).setResizable(false);
		table_3.getTableHeader().setReorderingAllowed(false); // Disattiva la possibilita di riordinare le colonne
		// trascinando
	}

}

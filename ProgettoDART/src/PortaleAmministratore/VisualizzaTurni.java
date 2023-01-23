package PortaleAmministratore;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;

import GestioneTurni.VisualizzaTurniControl;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.ComponentOrientation;
import javax.swing.JTable;

public class VisualizzaTurni extends JPanel {
	private JTable table;
	private JTable table3;
	private JTable table4;
	private JTable table2;
	private JTable table1;
	String[] array1 = new String[6];
	String[] array2 = new String[6];
	String[] array3 = new String[6];
	String[] array4 = new String[6];
	String[] array5 = new String[6];
	String[] array6 = new String[6];
	String[] array7 = new String[6];
	String[] array8 = new String[6];
	String[] array9 = new String[6];
	String[] array10 = new String[6];
	String[] array11 = new String[6];
	String[] array12 = new String[6];

	static String pattern = "yyyy-MM-dd";
	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

	/**
	 * Create the panel.
	 */
	public VisualizzaTurni() {
		setBounds(100, 100, 1280, 800);
		setLayout(new BorderLayout(0, 0));

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

		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_7, BorderLayout.SOUTH);

		JButton indietroButtom = new JButton("Indietro");
		indietroButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PortaleAmministratore.back();
			}
		});
		indietroButtom.setHorizontalTextPosition(SwingConstants.LEFT);
		indietroButtom.setHorizontalAlignment(SwingConstants.LEFT);
		indietroButtom.setFont(new Font("Arial", Font.PLAIN, 25));
		panel_7.add(indietroButtom);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));

		JCalendar calendar = new JCalendar();
		calendar.getDayChooser().getDayPanel().setBorder(null);
		calendar.setTodayButtonVisible(true);
		panel_1.add(calendar, BorderLayout.NORTH);

		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setVerifyInputWhenFocusTarget(false);
		panel_1_1.setRequestFocusEnabled(false);
		panel_1_1.setOpaque(false);
		panel_1_1.setFocusable(false);
		panel_1_1.setFocusTraversalKeysEnabled(false);
		panel_1_1.setEnabled(false);
		panel_1_1.setBorder(null);
		add(panel_1_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1_1 = new GridBagLayout();
		gbl_panel_1_1.columnWidths = new int[] { 191, 740, 108, 0 };
		gbl_panel_1_1.rowHeights = new int[] { 5, 48, 87, 61, 92, 0, 0 };
		gbl_panel_1_1.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1_1.setLayout(gbl_panel_1_1);

		JLabel servizioUnoLabel = new JLabel("Servizio uno");
		servizioUnoLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		servizioUnoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		servizioUnoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		servizioUnoLabel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		servizioUnoLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		GridBagConstraints gbc_servizioUnoLabel = new GridBagConstraints();
		gbc_servizioUnoLabel.fill = GridBagConstraints.BOTH;
		gbc_servizioUnoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_servizioUnoLabel.gridx = 0;
		gbc_servizioUnoLabel.gridy = 1;
		panel_1_1.add(servizioUnoLabel, gbc_servizioUnoLabel);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		panel_1_1.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		JButton selezionaDataButtom = new JButton("Seleziona Data");
		panel_6.add(selezionaDataButtom, BorderLayout.NORTH);
		selezionaDataButtom.setFont(new Font("Arial", Font.PLAIN, 15));
		panel_2.setLayout(new BorderLayout(0, 0));
		JPanel panel_3 = new JPanel();
		JPanel panel_4 = new JPanel();
		JPanel panel_5 = new JPanel();

		selezionaDataButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date dataInseritaInizio = calendar.getDate();
				String dataI = simpleDateFormat.format(dataInseritaInizio);
				// ProvaInserimentoInizio.setText(dataI); //PROVA DATA di inizio OTTENUTA
				// ATTRAVERSO AGGIORNAMENTO DI LABEL
				VisualizzaTurniControl visTurni = new VisualizzaTurniControl();
				array1 = visTurni.getTurni(dataI, 0, "Servizio 1");
				array2 = visTurni.getTurni(dataI, 1, "Servizio 1");
				array3 = visTurni.getTurni(dataI, 2, "Servizio 1");
				array4 = visTurni.getTurni(dataI, 0, "Servizio 2");
				array5 = visTurni.getTurni(dataI, 1, "Servizio 2");
				array6 = visTurni.getTurni(dataI, 2, "Servizio 2");
				array7 = visTurni.getTurni(dataI, 0, "Servizio 3");
				array8 = visTurni.getTurni(dataI, 1, "Servizio 3");
				array9 = visTurni.getTurni(dataI, 2, "Servizio 3");
				array10 = visTurni.getTurni(dataI, 0, "Servizio 4");
				array11 = visTurni.getTurni(dataI, 1, "Servizio 4");
				array12 = visTurni.getTurni(dataI, 2, "Servizio 4");

				// Servizio 1

				table1 = new JTable();
				table1.setEnabled(false);
				table1.setRowHeight(25);
				table1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				panel_2.add(table1.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers
																			// delle
				// colonne
				panel_2.add(table1, BorderLayout.CENTER);
				table1.setModel(new DefaultTableModel(
						new Object[][] { { array1[0], array2[0], array3[0] }, { array1[1], array2[1], array3[1] },
								{ array1[2], array2[2], array3[2] }, { array1[3], array2[3], array3[3] },
								{ array1[4], array2[4], array3[4] }, },
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
				table1.getColumnModel().getColumn(0).setResizable(false);
				table1.getColumnModel().getColumn(1).setResizable(false);
				table1.getColumnModel().getColumn(2).setResizable(false);
				table1.getTableHeader().setReorderingAllowed(false); // Disattiva la possibilita di riordinare le
																		// colonne

				// Servizio 2

				table2 = new JTable();
				table2.setEnabled(false);
				table2.setRowHeight(25);
				table2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				panel_3.add(table2.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers
																			// delle
				// colonne
				panel_3.add(table2);
				table2.setModel(new DefaultTableModel(
						new Object[][] { { array4[0], array5[0], array6[0] }, { array4[1], array5[1], array6[1] },
								{ array4[2], array5[2], array6[2] }, { array4[3], array5[3], array6[3] },
								{ array4[4], array5[4], array6[4] }, },
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
				table2.getColumnModel().getColumn(0).setResizable(false);
				table2.getColumnModel().getColumn(1).setResizable(false);
				table2.getColumnModel().getColumn(2).setResizable(false);
				table2.getTableHeader().setReorderingAllowed(false); // Disattiva la possibilita di riordinare le
																		// colonne

				// Servizio 3

				table3 = new JTable();
				table3.setEnabled(false);
				table3.setRowHeight(25);
				table3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				panel_4.add(table3.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers
																			// delle
				// colonne
				panel_4.add(table3);
				table3.setModel(new DefaultTableModel(
						new Object[][] { { array7[0], array8[0], array9[0] }, { array7[1], array8[1], array9[1] },
								{ array7[2], array8[2], array9[2] }, { array7[3], array8[3], array9[3] },
								{ array7[4], array8[4], array9[4] }, },
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
				table3.getColumnModel().getColumn(0).setResizable(false);
				table3.getColumnModel().getColumn(1).setResizable(false);
				table3.getColumnModel().getColumn(2).setResizable(false);
				table3.getTableHeader().setReorderingAllowed(false); // Disattiva la possibilita di riordinare le
																		// colonne

				// Servizio 4

				table4 = new JTable();
				table4.setEnabled(false);
				table4.setRowHeight(25);
				table4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				panel_5.add(table4.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers
																			// delle
				// colonne
				panel_5.add(table4);
				table4.setModel(new DefaultTableModel(
						new Object[][] { { array10[0], array11[0], array12[0] }, { array10[1], array11[1], array12[1] },
								{ array10[2], array11[2], array12[2] }, { array10[3], array11[3], array12[3] },
								{ array10[4], array11[4], array12[4] }, },
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
				table4.getColumnModel().getColumn(0).setResizable(false);
				table4.getColumnModel().getColumn(1).setResizable(false);
				table4.getColumnModel().getColumn(2).setResizable(false);
				table4.getTableHeader().setReorderingAllowed(false); // Disattiva la possibilita di riordinare le
																		// colonne

			}
		});
		// trascinando

		table1 = new JTable();
		table1.setEnabled(false);
		table1.setRowHeight(25);
		table1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_2.add(table1.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers delle
		// colonne
		panel_2.add(table1, BorderLayout.CENTER);
		table1.setModel(
				new DefaultTableModel(
						new Object[][] { { null, "", null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, },
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
		table1.getColumnModel().getColumn(0).setResizable(false);
		table1.getColumnModel().getColumn(1).setResizable(false);
		table1.getColumnModel().getColumn(2).setResizable(false);
		table1.getTableHeader().setReorderingAllowed(false); // Disattiva la possibilita di riordinare le colonne

		JLabel servizioDueLabel = new JLabel("Servizio due");
		servizioDueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		servizioDueLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		servizioDueLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_servizioDueLabel = new GridBagConstraints();
		gbc_servizioDueLabel.fill = GridBagConstraints.BOTH;
		gbc_servizioDueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_servizioDueLabel.gridx = 0;
		gbc_servizioDueLabel.gridy = 2;
		panel_1_1.add(servizioDueLabel, gbc_servizioDueLabel);

		panel_3.setLayout(new BorderLayout(0, 0));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 2;
		table2 = new JTable();
		table2.setEnabled(false);
		table2.setRowHeight(25);
		table2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_3.add(table2.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers delle
		// colonne
		panel_3.add(table2);
		table2.setModel(
				new DefaultTableModel(
						new Object[][] { { null, "", null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, },
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
		table2.getColumnModel().getColumn(0).setResizable(false);
		table2.getColumnModel().getColumn(1).setResizable(false);
		table2.getColumnModel().getColumn(2).setResizable(false);
		table2.getTableHeader().setReorderingAllowed(false); // Disattiva la possibilita di riordinare le colonne

		panel_1_1.add(panel_3, gbc_panel_3);

		JLabel servizioTreLabel = new JLabel("Servizio tre");
		servizioTreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		servizioTreLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		servizioTreLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_servizioTreLabel = new GridBagConstraints();
		gbc_servizioTreLabel.fill = GridBagConstraints.BOTH;
		gbc_servizioTreLabel.insets = new Insets(0, 0, 5, 5);
		gbc_servizioTreLabel.gridx = 0;
		gbc_servizioTreLabel.gridy = 3;
		panel_1_1.add(servizioTreLabel, gbc_servizioTreLabel);

		panel_4.setLayout(new BorderLayout(0, 0));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 3;
		panel_1_1.add(panel_4, gbc_panel_4);
		table3 = new JTable();
		table3.setEnabled(false);
		table3.setRowHeight(25);
		table3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_4.add(table3.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers delle
		// colonne
		panel_4.add(table3);
		table3.setModel(
				new DefaultTableModel(
						new Object[][] { { null, "", null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, },
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
		table3.getColumnModel().getColumn(0).setResizable(false);
		table3.getColumnModel().getColumn(1).setResizable(false);
		table3.getColumnModel().getColumn(2).setResizable(false);
		table3.getTableHeader().setReorderingAllowed(false); // Disattiva la possibilita di riordinare le colonne

		JLabel servizioQuattroLabel = new JLabel("Servizio quattro");
		servizioQuattroLabel.setHorizontalAlignment(SwingConstants.CENTER);
		servizioQuattroLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		servizioQuattroLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_servizioQuattroLabel = new GridBagConstraints();
		gbc_servizioQuattroLabel.fill = GridBagConstraints.BOTH;
		gbc_servizioQuattroLabel.insets = new Insets(0, 0, 5, 5);
		gbc_servizioQuattroLabel.gridx = 0;
		gbc_servizioQuattroLabel.gridy = 4;
		panel_1_1.add(servizioQuattroLabel, gbc_servizioQuattroLabel);

		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 1;
		gbc_panel_5.gridy = 4;
		panel_1_1.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		table4 = new JTable();
		table4.setEnabled(false);
		table4.setRowHeight(25);
		table4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_5.add(table4.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers delle
		// colonne
		panel_5.add(table4);
		table4.setModel(
				new DefaultTableModel(
						new Object[][] { { null, "", null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, },
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
		table4.getColumnModel().getColumn(0).setResizable(false);
		table4.getColumnModel().getColumn(1).setResizable(false);
		table4.getColumnModel().getColumn(2).setResizable(false);
		table4.getTableHeader().setReorderingAllowed(false); // Disattiva la possibilita di riordinare le colonne

	}

}

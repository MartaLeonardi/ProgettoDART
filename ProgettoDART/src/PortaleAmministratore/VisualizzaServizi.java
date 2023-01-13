package PortaleAmministratore;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import java.awt.Insets;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class VisualizzaServizi extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzaServizi frame = new VisualizzaServizi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VisualizzaServizi() {
		setTitle("D.A.R.T - Visualizza servizi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

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

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);

		JCalendar calendar = new JCalendar();
		calendar.setTodayButtonVisible(true);
		panel_3.add(calendar);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);

		JButton selezionaDataButtom = new JButton("Selezione Data");
		selezionaDataButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date dataInseritaInizio = calendar.getDate();
				DateFormat cambioFormatoDataI = DateFormat.getDateInstance(DateFormat.SHORT);
				String dataI = cambioFormatoDataI.format(dataInseritaInizio);
				// ProvaInserimentoInizio.setText(dataI); //PROVA DATA di inizio OTTENUTA
				// ATTRAVERSO AGGIORNAMENTO DI LABEL
			}
		});
		selezionaDataButtom.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_4.add(selezionaDataButtom);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 251, 0, 380, 0 };
		gbl_panel_2.rowHeights = new int[] { 71, 0, 70, 0, 71, 0, 58, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel servizioUnoLabel = new JLabel("Servizio uno");
		servizioUnoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_servizioUnoLabel = new GridBagConstraints();
		gbc_servizioUnoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_servizioUnoLabel.gridx = 0;
		gbc_servizioUnoLabel.gridy = 0;
		panel_2.add(servizioUnoLabel, gbc_servizioUnoLabel);

		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_6.gridx = 2;
		gbc_panel_6.gridy = 0;
		panel_2.add(panel_6, gbc_panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));

		table = new JTable();
		panel_6.add(table.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers delle
		// colonne
		panel_6.add(table, BorderLayout.CENTER);
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "00:00:-08:00", "08:00-16:00", "16:00-00:00" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
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
		panel_2.add(servizioDueLabel, gbc_servizioDueLabel);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(new BorderLayout(0, 0));
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_7.gridx = 2;
		gbc_panel_7.gridy = 2;
		panel_2.add(panel_7, gbc_panel_7);

		table_1 = new JTable();
		panel_7.add(table_1.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers delle
		// colonne
		panel_7.add(table_1, BorderLayout.CENTER);
		table_1.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
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
		panel_2.add(servizioTreLabel, gbc_servizioTreLabel);

		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_8.gridx = 2;
		gbc_panel_8.gridy = 4;
		panel_2.add(panel_8, gbc_panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));

		table_2 = new JTable();
		panel_8.add(table_2.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers delle
		// colonne
		panel_8.add(table_2, BorderLayout.CENTER);
		table_2.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
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
		panel_2.add(servizioQuattro, gbc_servizioQuattro);

		JPanel panel_9 = new JPanel();
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_9.gridx = 2;
		gbc_panel_9.gridy = 6;
		panel_2.add(panel_9, gbc_panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));

		table_3 = new JTable();
		panel_9.add(table_3.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers delle
		// colonne
		panel_9.add(table_3, BorderLayout.CENTER);
		table_3.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
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

		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_5.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.add(panel_5, BorderLayout.SOUTH);

		JButton indietroButtom = new JButton("Indietro");
		indietroButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PortaleAmministratore portaleAmm = new PortaleAmministratore();
				portaleAmm.setVisible(true);
				dispose();

			}
		});
		indietroButtom.setHorizontalAlignment(SwingConstants.LEFT);
		indietroButtom.setHorizontalTextPosition(SwingConstants.LEFT);
		indietroButtom.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_5.add(indietroButtom);
	}

}

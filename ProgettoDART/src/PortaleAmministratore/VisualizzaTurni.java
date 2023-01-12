package PortaleAmministratore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import java.awt.FlowLayout;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JYearChooser;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.JSeparator;

public class VisualizzaTurni extends JFrame {

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
					VisualizzaTurni frame = new VisualizzaTurni();
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
	public VisualizzaTurni() {
		setTitle("D.A.R.T - Visualizza turni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel logoImg = new JLabel("");
		Image imgLogo = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		logoImg.setIcon(new ImageIcon(imgLogo));
		panel.add(logoImg);
		panel.add(logoImg);
		logoImg.setAlignmentX(Component.CENTER_ALIGNMENT);
		logoImg.setFont(new Font("Arial", Font.PLAIN, 30));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setRequestFocusEnabled(false);
		panel_1.setVerifyInputWhenFocusTarget(false);
		panel_1.setOpaque(false);
		panel_1.setFocusable(false);
		panel_1.setFocusTraversalKeysEnabled(false);
		panel_1.setEnabled(false);
		contentPane.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 191, 740, 108, 0 };
		gbl_panel_1.rowHeights = new int[] { 98, 84, 0, 77, 0, 84, 0, 0, 0, 18, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 0;
		panel_1.add(separator, gbc_separator);

		JLabel servizioUnoLabel = new JLabel("Servizio uno");
		servizioUnoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		servizioUnoLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		servizioUnoLabel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		servizioUnoLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		servizioUnoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_servizioUnoLabel = new GridBagConstraints();
		gbc_servizioUnoLabel.fill = GridBagConstraints.BOTH;
		gbc_servizioUnoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_servizioUnoLabel.gridx = 0;
		gbc_servizioUnoLabel.gridy = 1;
		panel_1.add(servizioUnoLabel, gbc_servizioUnoLabel);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		panel_1.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		table = new JTable();
		panel_2.add(table.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers delle
		// colonne
		panel_2.add(table, BorderLayout.CENTER);
		table.setModel(
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
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);

		JLabel servizioDueLabel = new JLabel("Servizio due");
		servizioDueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		servizioDueLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		servizioDueLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_servizioDueLabel = new GridBagConstraints();
		gbc_servizioDueLabel.fill = GridBagConstraints.BOTH;
		gbc_servizioDueLabel.insets = new Insets(0, 0, 5, 5);
		gbc_servizioDueLabel.gridx = 0;
		gbc_servizioDueLabel.gridy = 2;
		panel_1.add(servizioDueLabel, gbc_servizioDueLabel);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.anchor = GridBagConstraints.NORTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 2;
		panel_1.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		table_1 = new JTable();
		panel_3.add(table_1.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers delle
		// colonne
		panel_3.add(table_1, BorderLayout.CENTER);
		table_1.setModel(new DefaultTableModel(
				new Object[][] { { "test", "test2", null }, { null, null, null }, { null, null, null },
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

		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.getColumnModel().getColumn(2).setResizable(false);

		table_1.getTableHeader().setReorderingAllowed(false); // Disattiva la possibilita di riordinare le colonne
		// trascinando

		JLabel servizioTreLabel = new JLabel("Servizio tre");
		servizioTreLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		servizioTreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		servizioTreLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_servizioTreLabel = new GridBagConstraints();
		gbc_servizioTreLabel.fill = GridBagConstraints.BOTH;
		gbc_servizioTreLabel.insets = new Insets(0, 0, 5, 5);
		gbc_servizioTreLabel.gridx = 0;
		gbc_servizioTreLabel.gridy = 3;
		panel_1.add(servizioTreLabel, gbc_servizioTreLabel);

		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 3;
		panel_1.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		table_2 = new JTable();
		table_2.setModel(
				new DefaultTableModel(
						new Object[][] { { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, },
						new String[] { "00:00-08:00", "08:00-16:00", "16:00-00:00" }) {
					Class[] columnTypes = new Class[] { String.class, String.class, String.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
		table_2.getColumnModel().getColumn(0).setResizable(false);
		table_2.getColumnModel().getColumn(1).setResizable(false);
		table_2.getColumnModel().getColumn(2).setResizable(false);
		table_2.getTableHeader().setReorderingAllowed(false); // Disattiva la possibilita di riordinare le colonne
		// trascinando
		panel_4.add(table_2);
		panel_4.add(table_2.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers delle
		// colonne
		panel_4.add(table_2, BorderLayout.CENTER);

		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6, BorderLayout.EAST);
		panel_6.setLayout(new BorderLayout(0, 0));

		JCalendar calendar = new JCalendar();
		calendar.setTodayButtonVisible(true);
		calendar.getDayChooser().getDayPanel().setBorder(null);
		panel_6.add(calendar, BorderLayout.NORTH);

		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8, BorderLayout.CENTER);

		JButton selezionaDataButtom = new JButton("Seleziona Data");
		panel_8.add(selezionaDataButtom);
		selezionaDataButtom.setFont(new Font("Arial", Font.PLAIN, 15));
		selezionaDataButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date dataInseritaInizio = calendar.getDate();
				DateFormat cambioFormatoDataI = DateFormat.getDateInstance(DateFormat.SHORT);
				String dataI = cambioFormatoDataI.format(dataInseritaInizio);
				// ProvaInserimentoInizio.setText(dataI); //PROVA DATA di inizio OTTENUTA
				// ATTRAVERSO AGGIORNAMENTO DI LABEL
			}
		});

		JLabel servizioQuattroLabel = new JLabel("Servizio quattro");
		servizioQuattroLabel.setHorizontalAlignment(SwingConstants.CENTER);
		servizioQuattroLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		servizioQuattroLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_servizioQuattroLabel = new GridBagConstraints();
		gbc_servizioQuattroLabel.fill = GridBagConstraints.BOTH;
		gbc_servizioQuattroLabel.insets = new Insets(0, 0, 5, 5);
		gbc_servizioQuattroLabel.gridx = 0;
		gbc_servizioQuattroLabel.gridy = 4;
		panel_1.add(servizioQuattroLabel, gbc_servizioQuattroLabel);

		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 1;
		gbc_panel_5.gridy = 4;
		panel_1.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		table_3 = new JTable();
		table_3.setModel(
				new DefaultTableModel(
						new Object[][] { { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, },
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
		panel_5.add(table_3, BorderLayout.CENTER);
		panel_5.add(table_3.getTableHeader(), BorderLayout.NORTH); // Creazione della tabella, con gli headers delle
		// colonne
		panel_5.add(table_3, BorderLayout.CENTER);

		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_7, BorderLayout.SOUTH);

		JButton indietroButtom = new JButton("Indietro");
		panel_7.add(indietroButtom);
		indietroButtom.setHorizontalTextPosition(SwingConstants.LEFT);
		indietroButtom.setHorizontalAlignment(SwingConstants.LEFT);
		indietroButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PortaleAmministratore portaleAmm = new PortaleAmministratore();
				portaleAmm.setVisible(true);
				dispose();
			}
		});
		indietroButtom.setFont(new Font("Arial", Font.PLAIN, 25));

	}

}

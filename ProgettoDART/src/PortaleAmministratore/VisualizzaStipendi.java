package PortaleAmministratore;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import GestioneStipendi.StipendiControl;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VisualizzaStipendi extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public VisualizzaStipendi() {
		setBounds(100, 100, 1200, 800);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new BorderLayout(0, 0));

		StipendiControl stipControl = new StipendiControl();

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

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_2, BorderLayout.SOUTH);

		JButton indietroButtom = new JButton("Indietro");
		indietroButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PortaleAmministratore.back();
			}
		});
		indietroButtom.setHorizontalAlignment(SwingConstants.LEFT);
		indietroButtom.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_2.add(indietroButtom);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 159, 861, 106, 0 };
		gbl_panel_1.rowHeights = new int[] { 564, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		panel_1.add(scrollPane, gbc_scrollPane);

		table = stipControl.createTable();
		table.setEnabled(false);
		table.setRowHeight(25);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getTableHeader().setReorderingAllowed(false); // Disattiva la possibilita di riordinare le colonne
		// trascinando
		scrollPane.setViewportView(table);

		/*
		 * table.setModel(new DefaultTableModel( new Object[][] { { null, null, null,
		 * null }, { null, null, null, null }, { null, null, null, null }, { null, null,
		 * null, null }, { null, null, null, null }, { null, null, null, null }, { null,
		 * null, null, null }, { null, null, null, null }, { null, null, null, null }, {
		 * null, null, null, null }, { null, null, null, null }, { null, null, null,
		 * null }, { null, null, null, null }, { null, null, null, null }, { null, null,
		 * null, null }, { null, null, null, null }, { null, null, null, null }, { null,
		 * null, null, null }, { null, null, null, null }, { null, null, null, null }, {
		 * null, null, null, null }, { null, null, null, null }, { null, null, null,
		 * null }, { null, null, null, null }, { null, null, null, null }, { null, null,
		 * null, null }, { null, null, null, null }, { null, null, null, null }, { null,
		 * null, null, null }, { null, null, null, null }, { null, null, null, null }, {
		 * null, null, null, null }, { null, null, null, null }, { null, null, null,
		 * null }, { null, null, null, null }, { null, null, null, null }, { null, null,
		 * null, null }, { null, null, null, null }, { null, null, null, null }, { null,
		 * null, null, null }, { null, null, null, null }, { null, null, null, null }, {
		 * null, null, null, null }, { null, null, null, null }, { null, null, null,
		 * null }, { null, null, null, null }, { null, null, null, null }, { null, null,
		 * null, null }, { null, null, null, null }, { null, null, null, null }, { null,
		 * null, null, null }, { null, null, null, null }, { null, null, null, null }, {
		 * null, null, null, null }, { null, null, null, null }, { null, null, null,
		 * null }, { null, null, null, null }, { null, null, null, null }, { null, null,
		 * null, null }, { null, null, null, null }, }, new String[] { "Matricola",
		 * "Periodo di retribuzione (inizio)", "Periodo di retribuzione (fine)",
		 * "Importo" }) { Class[] columnTypes = new Class[] { String.class,
		 * String.class, String.class, String.class };
		 * 
		 * public Class getColumnClass(int columnIndex) { return
		 * columnTypes[columnIndex]; } });
		 */
	}

	private void setExtendedState(int maximizedBoth) {
		// TODO Auto-generated method stub

	}

}

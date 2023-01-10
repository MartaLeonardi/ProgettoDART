package PortaleAmministratore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class PopUpSchedaImpiegato extends JFrame {

	private JPanel contentPane;
	private JTable schedaImpTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopUpSchedaImpiegato frame = new PopUpSchedaImpiegato();
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
	public PopUpSchedaImpiegato() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane schedaImpScrollPane = new JScrollPane();
		schedaImpScrollPane.setBackground(new Color(240, 240, 240));
		schedaImpScrollPane.setBorder(null);
		schedaImpScrollPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		schedaImpScrollPane.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(schedaImpScrollPane);

		schedaImpTable = new JTable();
		schedaImpScrollPane.setViewportView(schedaImpTable);
		schedaImpTable.setName("Test");
		schedaImpTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, },
				new String[] { "Matricola", "Nome", "Cognome", "Telefono", "Num. avvisi", "Num. ritardi", "Ecc..." }) {
			Class[] columnTypes = new Class[] { String.class, String.class, Object.class, Integer.class, Integer.class,
					Integer.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		schedaImpTable.getColumnModel().getColumn(0).setMinWidth(20);
		schedaImpTable.setFont(new Font("Arial", Font.PLAIN, 20));
		schedaImpTable.setBorder(new LineBorder(new Color(0, 0, 0)));

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		schedaImpScrollPane.setColumnHeaderView(separator);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel schedaImpiegatoLabel = new JLabel("Scheda Impiegato");
		panel_1.add(schedaImpiegatoLabel, BorderLayout.WEST);
		schedaImpiegatoLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		schedaImpiegatoLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JButton indietroButtom = new JButton("Indietro");
		indietroButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizzaSchedaImpiegato visSchedaImp = new VisualizzaSchedaImpiegato();
				visSchedaImp.setVisible(true);
				dispose();
			}
		});
		indietroButtom.setFont(new Font("Arial", Font.PLAIN, 15));
		panel_1.add(indietroButtom, BorderLayout.EAST);
	}

}

package PortaleAmministratore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.Box;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualizzaSchedaImpiegato extends JFrame {

	private JPanel contentPane;
	private JTextField matricolaTextField;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzaSchedaImpiegato frame = new VisualizzaSchedaImpiegato();
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
	public VisualizzaSchedaImpiegato() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel schedaLavorativaImpiegatoLabel = new JLabel("Scheda lavorativa impiegato");
		panel.add(schedaLavorativaImpiegatoLabel, BorderLayout.WEST);
		schedaLavorativaImpiegatoLabel.setFont(new Font("Arial", Font.PLAIN, 26));

		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PortaleAmministratore portaleAmm = new PortaleAmministratore();
				portaleAmm.setVisible(true);
				dispose();
			}
		});
		panel.add(btnNewButton, BorderLayout.EAST);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		panel.add(separator, BorderLayout.SOUTH);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel = new JLabel("Inserisci dati impiegato:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		JLabel matricolaLabel = new JLabel("Matricola:");
		matricolaLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_matricolaLabel = new GridBagConstraints();
		gbc_matricolaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaLabel.anchor = GridBagConstraints.EAST;
		gbc_matricolaLabel.gridx = 0;
		gbc_matricolaLabel.gridy = 3;
		panel_1.add(matricolaLabel, gbc_matricolaLabel);

		matricolaTextField = new JTextField();
		GridBagConstraints gbc_matricolaTextField = new GridBagConstraints();
		gbc_matricolaTextField.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_matricolaTextField.gridx = 1;
		gbc_matricolaTextField.gridy = 3;
		panel_1.add(matricolaTextField, gbc_matricolaTextField);
		matricolaTextField.setColumns(15);

		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
		gbc_nomeLabel.anchor = GridBagConstraints.EAST;
		gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeLabel.gridx = 0;
		gbc_nomeLabel.gridy = 4;
		panel_1.add(nomeLabel, gbc_nomeLabel);

		textField = new JTextField();
		textField.setColumns(15);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 4;
		panel_1.add(textField, gbc_textField);

		JLabel cognomeLabel = new JLabel("Cognome:");
		cognomeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_cognomeLabel = new GridBagConstraints();
		gbc_cognomeLabel.anchor = GridBagConstraints.EAST;
		gbc_cognomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeLabel.gridx = 0;
		gbc_cognomeLabel.gridy = 5;
		panel_1.add(cognomeLabel, gbc_cognomeLabel);

		textField_1 = new JTextField();
		textField_1.setColumns(15);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 5;
		panel_1.add(textField_1, gbc_textField_1);

		JButton mostraButtom = new JButton("Mostra");
		mostraButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PopUpSchedaImpiegato popUpSchedaImp = new PopUpSchedaImpiegato();
				popUpSchedaImp.setVisible(true);
				dispose();
			}
		});
		mostraButtom.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_mostraButtom = new GridBagConstraints();
		gbc_mostraButtom.insets = new Insets(0, 0, 0, 5);
		gbc_mostraButtom.gridx = 5;
		gbc_mostraButtom.gridy = 7;
		panel_1.add(mostraButtom, gbc_mostraButtom);
	}

}

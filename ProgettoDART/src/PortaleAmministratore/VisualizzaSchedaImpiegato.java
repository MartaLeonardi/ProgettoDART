package PortaleAmministratore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.ImageIcon;

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
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.NORTH);

		JLabel logoImg = new JLabel("");
		logoImg.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgLogo = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		panel_5.setLayout(new BorderLayout(0, 0));
		logoImg.setIcon(new ImageIcon(imgLogo));
		panel_5.add(logoImg);
		panel_5.add(logoImg);
		logoImg.setAlignmentX(Component.CENTER_ALIGNMENT);
		logoImg.setFont(new Font("Arial", Font.PLAIN, 30));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 959, 0, 174, 61, 1080, 0 };
		gbl_panel_4.rowHeights = new int[] { 111, 0, 0, 0, 0, 24, 311, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		JLabel schedaLavorativaImpiegatoLabel = new JLabel("Scheda lavorativa impiegato");
		schedaLavorativaImpiegatoLabel.setFont(new Font("Impact", Font.PLAIN, 30));
		schedaLavorativaImpiegatoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(schedaLavorativaImpiegatoLabel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Inserisci dati impiegato:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_4.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		JLabel matricolaLabel = new JLabel("Matricola:");
		GridBagConstraints gbc_matricolaLabel = new GridBagConstraints();
		gbc_matricolaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaLabel.gridx = 1;
		gbc_matricolaLabel.gridy = 2;
		panel_4.add(matricolaLabel, gbc_matricolaLabel);
		matricolaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		matricolaTextField = new JTextField();
		matricolaTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_matricolaTextField = new GridBagConstraints();
		gbc_matricolaTextField.fill = GridBagConstraints.BOTH;
		gbc_matricolaTextField.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaTextField.gridx = 2;
		gbc_matricolaTextField.gridy = 2;
		panel_4.add(matricolaTextField, gbc_matricolaTextField);
		matricolaTextField.setColumns(15);

		JLabel nomeLabel = new JLabel("Nome:");
		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
		gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeLabel.gridx = 1;
		gbc_nomeLabel.gridy = 3;
		panel_4.add(nomeLabel, gbc_nomeLabel);
		nomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 3;
		panel_4.add(textField, gbc_textField);
		textField.setColumns(15);

		JLabel cognomeLabel = new JLabel("Cognome:");
		GridBagConstraints gbc_cognomeLabel = new GridBagConstraints();
		gbc_cognomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeLabel.gridx = 1;
		gbc_cognomeLabel.gridy = 4;
		panel_4.add(cognomeLabel, gbc_cognomeLabel);
		cognomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 4;
		panel_4.add(textField_1, gbc_textField_1);
		textField_1.setColumns(15);

		JButton mostraButtom = new JButton("Mostra");
		GridBagConstraints gbc_mostraButtom = new GridBagConstraints();
		gbc_mostraButtom.insets = new Insets(0, 0, 5, 5);
		gbc_mostraButtom.gridx = 3;
		gbc_mostraButtom.gridy = 5;
		panel_4.add(mostraButtom, gbc_mostraButtom);
		mostraButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PopUpSchedaImpiegato popUpSchedaImp = new PopUpSchedaImpiegato();
				popUpSchedaImp.setVisible(true);
				dispose();
			}
		});
		mostraButtom.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		panel_5.add(separator_1, BorderLayout.SOUTH);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_2, BorderLayout.SOUTH);

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);

		JButton btnNewButton = new JButton("Indietro");
		panel_3.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PortaleAmministratore portaleAmm = new PortaleAmministratore();
				portaleAmm.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
	}

}

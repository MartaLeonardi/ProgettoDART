package PortaleAmministratore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import RilevazionePresenza.RivPre_IN;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class LicenziaImpiegato extends JFrame {

	private JPanel contentPane;
	public JTextField matricolaTextField;
	private JTextField nomeTextField;
	private JTextField cognomeTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LicenziaImpiegato frame = new LicenziaImpiegato();
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
	public LicenziaImpiegato() {
		setTitle("Licenzia Impiegato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 349, 260, 168, 180, 0, 119, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 74, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel = new JLabel("Inserisci dati impiegato:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		JLabel matricolaLabel = new JLabel("Matricola:");
		GridBagConstraints gbc_matricolaLabel = new GridBagConstraints();
		gbc_matricolaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaLabel.gridx = 1;
		gbc_matricolaLabel.gridy = 3;
		panel_1.add(matricolaLabel, gbc_matricolaLabel);
		matricolaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		matricolaTextField = new JTextField();
		GridBagConstraints gbc_matricolaTextField = new GridBagConstraints();
		gbc_matricolaTextField.fill = GridBagConstraints.BOTH;
		gbc_matricolaTextField.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaTextField.gridx = 2;
		gbc_matricolaTextField.gridy = 3;
		panel_1.add(matricolaTextField, gbc_matricolaTextField);
		getMatricolaTextField().setFont(new Font("Times New Roman", Font.PLAIN, 20));
		getMatricolaTextField().setColumns(15);

		JLabel nomeLabel = new JLabel("Nome:");
		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
		gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeLabel.gridx = 1;
		gbc_nomeLabel.gridy = 4;
		panel_1.add(nomeLabel, gbc_nomeLabel);
		nomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		nomeTextField = new JTextField();
		GridBagConstraints gbc_nomeTextField = new GridBagConstraints();
		gbc_nomeTextField.fill = GridBagConstraints.BOTH;
		gbc_nomeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_nomeTextField.gridx = 2;
		gbc_nomeTextField.gridy = 4;
		panel_1.add(nomeTextField, gbc_nomeTextField);
		nomeTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nomeTextField.setColumns(15);

		JLabel cognomeLabel = new JLabel("Cognome:");
		GridBagConstraints gbc_cognomeLabel = new GridBagConstraints();
		gbc_cognomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeLabel.gridx = 1;
		gbc_cognomeLabel.gridy = 5;
		panel_1.add(cognomeLabel, gbc_cognomeLabel);
		cognomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		cognomeTextField = new JTextField();
		GridBagConstraints gbc_cognomeTextField = new GridBagConstraints();
		gbc_cognomeTextField.fill = GridBagConstraints.BOTH;
		gbc_cognomeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeTextField.gridx = 2;
		gbc_cognomeTextField.gridy = 5;
		panel_1.add(cognomeTextField, gbc_cognomeTextField);
		cognomeTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cognomeTextField.setColumns(15);

		JButton LicenziaButtom = new JButton("Licenzia");
		GridBagConstraints gbc_LicenziaButtom = new GridBagConstraints();
		gbc_LicenziaButtom.insets = new Insets(0, 0, 5, 5);
		gbc_LicenziaButtom.gridx = 3;
		gbc_LicenziaButtom.gridy = 6;
		panel_1.add(LicenziaButtom, gbc_LicenziaButtom);
		LicenziaButtom.setFont(new Font("Arial", Font.PLAIN, 18));

		LicenziaButtom.addActionListener(new ActionListener() { // Quando viene premuto il bottone Licenzia, si apre un
																// popUp di conferma
			public void actionPerformed(ActionEvent e) {
				PopUpLicenziaImpiegato popUpLicenzia = new PopUpLicenziaImpiegato();
				String matricola = matricolaTextField.getText();
				String nome = nomeTextField.getText();
				String congome = cognomeTextField.getText();
				popUpLicenzia.setVisible(true);
			}
		});

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		JLabel logoImg = new JLabel("");
		logoImg.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgLogo = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		logoImg.setIcon(new ImageIcon(imgLogo));
		panel_2.add(logoImg);
		panel_2.add(logoImg);
		logoImg.setAlignmentX(Component.CENTER_ALIGNMENT);
		logoImg.setFont(new Font("Arial", Font.PLAIN, 30));

		JSeparator separator = new JSeparator();
		panel_2.add(separator, BorderLayout.SOUTH);
		separator.setForeground(new Color(0, 0, 0));

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_3, BorderLayout.SOUTH);

		JButton indietrobuttom = new JButton("Indietro");
		panel_3.add(indietrobuttom);
		indietrobuttom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PortaleAmministratore portaleAmm = new PortaleAmministratore();
				portaleAmm.setVisible(true);
				dispose();
			}
		});
		indietrobuttom.setFont(new Font("Arial", Font.PLAIN, 18));

		JLabel licenziaImpiegatoLabel = new JLabel("Licenzia Impiegato");
		licenziaImpiegatoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		licenziaImpiegatoLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		panel.add(licenziaImpiegatoLabel, BorderLayout.NORTH);
		licenziaImpiegatoLabel.setFont(new Font("Impact", Font.PLAIN, 30));

	}

	public JTextField getMatricolaTextField() {
		return matricolaTextField;
	}

}

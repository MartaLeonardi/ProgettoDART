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
import javax.swing.JTextField;
import javax.swing.JButton;

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
		setBounds(100, 100, 1020, 980);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel licenziaImpiegatoLabel = new JLabel("Licenzia Impiegato");
		licenziaImpiegatoLabel.setFont(new Font("Impact", Font.PLAIN, 30));
		GridBagConstraints gbc_licenziaImpiegatoLabel = new GridBagConstraints();
		gbc_licenziaImpiegatoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_licenziaImpiegatoLabel.gridx = 1;
		gbc_licenziaImpiegatoLabel.gridy = 1;
		contentPane.add(licenziaImpiegatoLabel, gbc_licenziaImpiegatoLabel);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 2;
		contentPane.add(separator, gbc_separator);

		JLabel lblNewLabel = new JLabel("Inserisci dati impiegato:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JLabel matricolaLabel = new JLabel("Matricola:");
		matricolaLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_matricolaLabel = new GridBagConstraints();
		gbc_matricolaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaLabel.anchor = GridBagConstraints.WEST;
		gbc_matricolaLabel.gridx = 2;
		gbc_matricolaLabel.gridy = 4;
		contentPane.add(matricolaLabel, gbc_matricolaLabel);

		matricolaTextField = new JTextField();
		getMatricolaTextField().setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_matricolaTextField = new GridBagConstraints();
		gbc_matricolaTextField.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_matricolaTextField.gridx = 3;
		gbc_matricolaTextField.gridy = 4;
		contentPane.add(getMatricolaTextField(), gbc_matricolaTextField);
		getMatricolaTextField().setColumns(15);

		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
		gbc_nomeLabel.anchor = GridBagConstraints.WEST;
		gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeLabel.gridx = 2;
		gbc_nomeLabel.gridy = 5;
		contentPane.add(nomeLabel, gbc_nomeLabel);

		nomeTextField = new JTextField();
		nomeTextField.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_nomeTextField = new GridBagConstraints();
		gbc_nomeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_nomeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeTextField.gridx = 3;
		gbc_nomeTextField.gridy = 5;
		contentPane.add(nomeTextField, gbc_nomeTextField);
		nomeTextField.setColumns(15);

		JLabel cognomeLabel = new JLabel("Cognome:");
		cognomeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_cognomeLabel = new GridBagConstraints();
		gbc_cognomeLabel.anchor = GridBagConstraints.WEST;
		gbc_cognomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeLabel.gridx = 2;
		gbc_cognomeLabel.gridy = 6;
		contentPane.add(cognomeLabel, gbc_cognomeLabel);

		cognomeTextField = new JTextField();
		cognomeTextField.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_cognomeTextField = new GridBagConstraints();
		gbc_cognomeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_cognomeTextField.gridx = 3;
		gbc_cognomeTextField.gridy = 6;
		contentPane.add(cognomeTextField, gbc_cognomeTextField);
		cognomeTextField.setColumns(15);

		JButton LicenziaButtom = new JButton("Licenzia");
		LicenziaButtom.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_LicenziaButtom = new GridBagConstraints();
		gbc_LicenziaButtom.gridx = 4;
		gbc_LicenziaButtom.gridy = 7;
		contentPane.add(LicenziaButtom, gbc_LicenziaButtom);

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

	}

	public JTextField getMatricolaTextField() {
		return matricolaTextField;
	}

}

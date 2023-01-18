package PortaleAmministratore;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import GestionePersonale.AddEmpControl;

public class AssumiImpiegato extends JPanel {

	private JTextField nomeTextField;
	private JTextField cognomeTextField;
	private JTextField matricolaTextField;
	private JTextField emailTextField;
	private JTextField telefonoTextField;
	private JTextField stipendioTextField;
	private JTextField matricolaField;
	private JTextField nomeField;
	private JTextField cognomeField;
	private JTextField emailField;
	private JTextField telefonoField;
	private JTextField stipendioField;

	/**
	 * Create the panel.
	 */
	public AssumiImpiegato() {
		setBounds(100, 100, 1280, 800);
		setLayout(new BorderLayout(0, 0));

		String ruolo[] = { "Ruolo 1", "Ruolo 2", "Ruolo 3", "Ruolo 4" };

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

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
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_1, BorderLayout.SOUTH);

		JButton indietroButtom = new JButton("Indietro");
		panel_1.add(indietroButtom);
		indietroButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PortaleAmministratore.back();
			}
		});
		indietroButtom.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_1.add(indietroButtom);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		JLabel assumiImpiegatoLabel = new JLabel("Assumi Impiegato");
		assumiImpiegatoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		assumiImpiegatoLabel.setVerticalAlignment(SwingConstants.TOP);
		panel_2.add(assumiImpiegatoLabel, BorderLayout.NORTH);
		assumiImpiegatoLabel.setFont(new Font("Impact", Font.PLAIN, 30));

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.CENTER);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 1016, 123, 135, 57, 1080, 0 };
		gbl_panel_3.rowHeights = new int[] { 65, 0, 0, 0, 0, 0, 0, 0, 0, 0, 50, 50, 50, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JLabel lblNewLabel_1 = new JLabel("Inserisci dati impiegato");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panel_3.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel matricolaLabel = new JLabel("Matricola:");
		matricolaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_matricolaLabel = new GridBagConstraints();
		gbc_matricolaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaLabel.gridx = 1;
		gbc_matricolaLabel.gridy = 2;
		panel_3.add(matricolaLabel, gbc_matricolaLabel);

		matricolaField = new JTextField();
		matricolaField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		matricolaField.setColumns(14);
		GridBagConstraints gbc_matricolaField = new GridBagConstraints();
		gbc_matricolaField.fill = GridBagConstraints.BOTH;
		gbc_matricolaField.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaField.gridx = 2;
		gbc_matricolaField.gridy = 2;
		panel_3.add(matricolaField, gbc_matricolaField);

		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
		gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeLabel.gridx = 1;
		gbc_nomeLabel.gridy = 3;
		panel_3.add(nomeLabel, gbc_nomeLabel);

		nomeField = new JTextField();
		nomeField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nomeField.setColumns(14);
		GridBagConstraints gbc_nomeField = new GridBagConstraints();
		gbc_nomeField.fill = GridBagConstraints.BOTH;
		gbc_nomeField.insets = new Insets(0, 0, 5, 5);
		gbc_nomeField.gridx = 2;
		gbc_nomeField.gridy = 3;
		panel_3.add(nomeField, gbc_nomeField);

		JLabel cognomeLabel = new JLabel("Cognome:");
		cognomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_cognomeLabel = new GridBagConstraints();
		gbc_cognomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeLabel.gridx = 1;
		gbc_cognomeLabel.gridy = 4;
		panel_3.add(cognomeLabel, gbc_cognomeLabel);

		cognomeField = new JTextField();
		cognomeField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cognomeField.setColumns(14);
		GridBagConstraints gbc_cognomeField = new GridBagConstraints();
		gbc_cognomeField.fill = GridBagConstraints.BOTH;
		gbc_cognomeField.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeField.gridx = 2;
		gbc_cognomeField.gridy = 4;
		panel_3.add(cognomeField, gbc_cognomeField);

		JLabel emilaLabel = new JLabel("E-mail:");
		emilaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_emilaLabel = new GridBagConstraints();
		gbc_emilaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emilaLabel.gridx = 1;
		gbc_emilaLabel.gridy = 5;
		panel_3.add(emilaLabel, gbc_emilaLabel);

		emailField = new JTextField();
		emailField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		emailField.setColumns(14);
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.fill = GridBagConstraints.BOTH;
		gbc_emailField.insets = new Insets(0, 0, 5, 5);
		gbc_emailField.gridx = 2;
		gbc_emailField.gridy = 5;
		panel_3.add(emailField, gbc_emailField);

		JLabel telefonoLabel = new JLabel("Telefono:");
		telefonoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_telefonoLabel = new GridBagConstraints();
		gbc_telefonoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_telefonoLabel.gridx = 1;
		gbc_telefonoLabel.gridy = 6;
		panel_3.add(telefonoLabel, gbc_telefonoLabel);

		telefonoField = new JTextField();
		telefonoField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		telefonoField.setColumns(14);
		GridBagConstraints gbc_telefonoField = new GridBagConstraints();
		gbc_telefonoField.fill = GridBagConstraints.BOTH;
		gbc_telefonoField.insets = new Insets(0, 0, 5, 5);
		gbc_telefonoField.gridx = 2;
		gbc_telefonoField.gridy = 6;
		panel_3.add(telefonoField, gbc_telefonoField);

		JLabel ruoloLabel = new JLabel("Ruolo:");
		ruoloLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_ruoloLabel = new GridBagConstraints();
		gbc_ruoloLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ruoloLabel.gridx = 1;
		gbc_ruoloLabel.gridy = 7;
		panel_3.add(ruoloLabel, gbc_ruoloLabel);

		JComboBox ruoloComboBox = new JComboBox(ruolo);
		ruoloComboBox.setToolTipText("");
		ruoloComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_ruoloComboBox = new GridBagConstraints();
		gbc_ruoloComboBox.fill = GridBagConstraints.BOTH;
		gbc_ruoloComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_ruoloComboBox.gridx = 2;
		gbc_ruoloComboBox.gridy = 7;
		panel_3.add(ruoloComboBox, gbc_ruoloComboBox);

		JLabel stipendioLabel = new JLabel("Stipendio:");
		stipendioLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_stipendioLabel = new GridBagConstraints();
		gbc_stipendioLabel.insets = new Insets(0, 0, 5, 5);
		gbc_stipendioLabel.gridx = 1;
		gbc_stipendioLabel.gridy = 8;
		panel_3.add(stipendioLabel, gbc_stipendioLabel);

		stipendioField = new JTextField();
		stipendioField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		stipendioField.setColumns(14);
		GridBagConstraints gbc_stipendioField = new GridBagConstraints();
		gbc_stipendioField.fill = GridBagConstraints.BOTH;
		gbc_stipendioField.insets = new Insets(0, 0, 5, 5);
		gbc_stipendioField.gridx = 2;
		gbc_stipendioField.gridy = 8;
		panel_3.add(stipendioField, gbc_stipendioField);

		JButton assumiButtom = new JButton("Assumi");
		assumiButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String matricola = matricolaField.getText();
				String nome = nomeField.getText();
				String cognome = cognomeField.getText();
				String email = emailField.getText();
				String telefono = telefonoField.getText();
				String ruolo = (String) ruoloComboBox.getItemAt(ruoloComboBox.getSelectedIndex());
				String stipendio = stipendioField.getText();

				AddEmpControl addEmp = new AddEmpControl(nome, cognome, matricola, email, telefono, ruolo, stipendio);

			}
		});
		assumiButtom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_assumiButtom = new GridBagConstraints();
		gbc_assumiButtom.insets = new Insets(0, 0, 5, 5);
		gbc_assumiButtom.gridx = 3;
		gbc_assumiButtom.gridy = 9;
		panel_3.add(assumiButtom, gbc_assumiButtom);

	}

}

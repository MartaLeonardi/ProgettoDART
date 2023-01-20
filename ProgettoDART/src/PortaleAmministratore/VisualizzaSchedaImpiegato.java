package PortaleAmministratore;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GestionePersonale.SchedaControl;
import PopUp.PopUpSchedaImpiegato;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class VisualizzaSchedaImpiegato extends JPanel {
	private JTextField matricolaTextField;
	private JTextField nomeTextField;
	private JTextField cognomeTextField;

	/**
	 * Create the panel.
	 */
	public VisualizzaSchedaImpiegato() {
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
		separator.setForeground(new Color(160, 160, 160));
		panel.add(separator, BorderLayout.SOUTH);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_2, BorderLayout.SOUTH);

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);

		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PortaleAmministratore.back();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		panel_3.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel schedaLavorativaImpiegatoLabel = new JLabel("Scheda lavorativa impiegato");
		schedaLavorativaImpiegatoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		schedaLavorativaImpiegatoLabel.setFont(new Font("Impact", Font.PLAIN, 30));
		panel_1.add(schedaLavorativaImpiegatoLabel, BorderLayout.NORTH);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 959, 0, 174, 61, 1080, 0 };
		gbl_panel_4.rowHeights = new int[] { 111, 0, 0, 0, 0, 24, 311, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		JLabel lblNewLabel = new JLabel("Inserisci dati impiegato:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_4.add(lblNewLabel, gbc_lblNewLabel);

		JLabel matricolaLabel = new JLabel("Matricola:");
		matricolaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_matricolaLabel = new GridBagConstraints();
		gbc_matricolaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaLabel.gridx = 1;
		gbc_matricolaLabel.gridy = 2;
		panel_4.add(matricolaLabel, gbc_matricolaLabel);

		matricolaTextField = new JTextField();
		matricolaTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		matricolaTextField.setColumns(15);
		GridBagConstraints gbc_matricolaTextField = new GridBagConstraints();
		gbc_matricolaTextField.fill = GridBagConstraints.BOTH;
		gbc_matricolaTextField.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaTextField.gridx = 2;
		gbc_matricolaTextField.gridy = 2;
		panel_4.add(matricolaTextField, gbc_matricolaTextField);

		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
		gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeLabel.gridx = 1;
		gbc_nomeLabel.gridy = 3;
		panel_4.add(nomeLabel, gbc_nomeLabel);

		nomeTextField = new JTextField();
		nomeTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nomeTextField.setColumns(15);
		GridBagConstraints gbc_nomeTextField = new GridBagConstraints();
		gbc_nomeTextField.fill = GridBagConstraints.BOTH;
		gbc_nomeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_nomeTextField.gridx = 2;
		gbc_nomeTextField.gridy = 3;
		panel_4.add(nomeTextField, gbc_nomeTextField);

		JLabel cognomeLabel = new JLabel("Cognome:");
		cognomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_cognomeLabel = new GridBagConstraints();
		gbc_cognomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeLabel.gridx = 1;
		gbc_cognomeLabel.gridy = 4;
		panel_4.add(cognomeLabel, gbc_cognomeLabel);

		cognomeTextField = new JTextField();
		cognomeTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cognomeTextField.setColumns(15);
		GridBagConstraints gbc_cognomeTextField = new GridBagConstraints();
		gbc_cognomeTextField.fill = GridBagConstraints.BOTH;
		gbc_cognomeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeTextField.gridx = 2;
		gbc_cognomeTextField.gridy = 4;
		panel_4.add(cognomeTextField, gbc_cognomeTextField);

		JButton mostraButtom = new JButton("Mostra");
		mostraButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String matricola = matricolaTextField.getText();
				String nome = nomeTextField.getText();
				String cognome = cognomeTextField.getText();
				SchedaControl scontrol = new SchedaControl(matricola, nome, cognome);
				// PopUpSchedaImpiegato popUpScheda = new PopUpSchedaImpiegato(matricola, nome,
				// cognome);
				// popUpScheda.setVisible(true);
			}
		});
		mostraButtom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_mostraButtom = new GridBagConstraints();
		gbc_mostraButtom.insets = new Insets(0, 0, 5, 5);
		gbc_mostraButtom.gridx = 3;
		gbc_mostraButtom.gridy = 5;
		panel_4.add(mostraButtom, gbc_mostraButtom);

	}

}

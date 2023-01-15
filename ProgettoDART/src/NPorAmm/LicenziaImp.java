package NPorAmm;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import PortaleAmministratore.PopUpLicenziaImpiegato;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LicenziaImp extends JPanel {
	private JTextField matricolaTextField;
	private JTextField nomeTextField;
	private JTextField cognomeTextField;

	/**
	 * Create the panel.
	 */
	public LicenziaImp() {
		setBounds(100, 100, 1280, 800);
		setLayout(new BorderLayout(0, 0));

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
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel licenziaImpiegatoLabel = new JLabel("Licenzia Impiegato");
		licenziaImpiegatoLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		licenziaImpiegatoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		licenziaImpiegatoLabel.setFont(new Font("Impact", Font.PLAIN, 30));
		panel_1.add(licenziaImpiegatoLabel, BorderLayout.NORTH);

		JPanel panel_1_1 = new JPanel();
		panel_1.add(panel_1_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1_1 = new GridBagLayout();
		gbl_panel_1_1.columnWidths = new int[] { 1037, 260, 168, 98, 1080, 0 };
		gbl_panel_1_1.rowHeights = new int[] { 74, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		panel_1_1.setLayout(gbl_panel_1_1);

		JLabel lblNewLabel = new JLabel("Inserisci dati impiegato:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_1_1.add(lblNewLabel, gbc_lblNewLabel);

		JLabel matricolaLabel = new JLabel("Matricola:");
		matricolaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_matricolaLabel = new GridBagConstraints();
		gbc_matricolaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaLabel.gridx = 1;
		gbc_matricolaLabel.gridy = 3;
		panel_1_1.add(matricolaLabel, gbc_matricolaLabel);

		matricolaTextField = new JTextField();
		matricolaTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		matricolaTextField.setColumns(15);
		GridBagConstraints gbc_matricolaTextField = new GridBagConstraints();
		gbc_matricolaTextField.fill = GridBagConstraints.BOTH;
		gbc_matricolaTextField.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaTextField.gridx = 2;
		gbc_matricolaTextField.gridy = 3;
		panel_1_1.add(matricolaTextField, gbc_matricolaTextField);

		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
		gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeLabel.gridx = 1;
		gbc_nomeLabel.gridy = 4;
		panel_1_1.add(nomeLabel, gbc_nomeLabel);

		nomeTextField = new JTextField();
		nomeTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nomeTextField.setColumns(15);
		GridBagConstraints gbc_nomeTextField = new GridBagConstraints();
		gbc_nomeTextField.fill = GridBagConstraints.BOTH;
		gbc_nomeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_nomeTextField.gridx = 2;
		gbc_nomeTextField.gridy = 4;
		panel_1_1.add(nomeTextField, gbc_nomeTextField);

		JLabel cognomeLabel = new JLabel("Cognome:");
		cognomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_cognomeLabel = new GridBagConstraints();
		gbc_cognomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeLabel.gridx = 1;
		gbc_cognomeLabel.gridy = 5;
		panel_1_1.add(cognomeLabel, gbc_cognomeLabel);

		cognomeTextField = new JTextField();
		cognomeTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cognomeTextField.setColumns(15);
		GridBagConstraints gbc_cognomeTextField = new GridBagConstraints();
		gbc_cognomeTextField.fill = GridBagConstraints.BOTH;
		gbc_cognomeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeTextField.gridx = 2;
		gbc_cognomeTextField.gridy = 5;
		panel_1_1.add(cognomeTextField, gbc_cognomeTextField);

		JButton LicenziaButtom = new JButton("Licenzia");
		LicenziaButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PopUpLicenziaImpiegato popUpLicenzia = new PopUpLicenziaImpiegato();
				String matricola = matricolaTextField.getText();
				String nome = nomeTextField.getText();
				String congome = cognomeTextField.getText();
				popUpLicenzia.setVisible(true);
			}
		});
		LicenziaButtom.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_LicenziaButtom = new GridBagConstraints();
		gbc_LicenziaButtom.insets = new Insets(0, 0, 5, 5);
		gbc_LicenziaButtom.gridx = 3;
		gbc_LicenziaButtom.gridy = 6;
		panel_1_1.add(LicenziaButtom, gbc_LicenziaButtom);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_3, BorderLayout.SOUTH);

		JButton indietrobuttom = new JButton("Indietro");
		indietrobuttom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PAmm.back();
			}
		});
		indietrobuttom.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_3.add(indietrobuttom);

	}

}

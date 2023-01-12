package PortaleAmministratore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class AssumiImpiegato extends JFrame {

	private JPanel contentPane;
	private JTextField nomeTextField;
	private JTextField cognomeTextField;
	private JTextField matricolaTextField;
	private JTextField emailTextField;
	private JTextField telefonoTextField;
	private JTextField stipendioTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssumiImpiegato assumiImpiegato = new AssumiImpiegato();
					assumiImpiegato.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AssumiImpiegato() {
		setTitle("D.A.R.T - Assumi impiegato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setEnabled(false);

		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		String ruolo[] = { "Ruolo 1", "Ruolo 2", "Ruolo 3", "Ruolo 4" };

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);

		JLabel logoImg = new JLabel("");
		logoImg.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgLogo = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		panel_2.setLayout(new BorderLayout(0, 0));
		logoImg.setIcon(new ImageIcon(imgLogo));
		panel_2.add(logoImg);
		panel_2.add(logoImg);
		logoImg.setAlignmentX(Component.CENTER_ALIGNMENT);
		logoImg.setFont(new Font("Arial", Font.PLAIN, 30));

		JSeparator separator_1 = new JSeparator();
		panel_2.add(separator_1, BorderLayout.SOUTH);
		separator_1.setForeground(new Color(0, 0, 0));

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));

		JLabel assumiImpiegatoLabel = new JLabel("Assumi Impiegato");
		assumiImpiegatoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		assumiImpiegatoLabel.setVerticalAlignment(SwingConstants.TOP);
		panel_3.add(assumiImpiegatoLabel, BorderLayout.NORTH);
		assumiImpiegatoLabel.setFont(new Font("Impact", Font.PLAIN, 30));

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JButton indietroButtom = new JButton("Indietro");
		panel_1.add(indietroButtom);
		indietroButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PortaleAmministratore portaleAmm = new PortaleAmministratore();
				portaleAmm.setVisible(true);
				dispose();
			}
		});
		indietroButtom.setFont(new Font("Arial", Font.PLAIN, 18));

		JPanel panel = new JPanel();
		panel_3.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 524, 123, 135, 57, 535, 0 };
		gbl_panel.rowHeights = new int[] { 65, 0, 0, 0, 0, 0, 0, 0, 0, 0, 50, 50, 50 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0 };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel_1 = new JLabel("Inserisci dati impiegato");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		JLabel matricolaLabel = new JLabel("Matricola:");
		GridBagConstraints gbc_matricolaLabel = new GridBagConstraints();
		gbc_matricolaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaLabel.gridx = 1;
		gbc_matricolaLabel.gridy = 2;
		panel.add(matricolaLabel, gbc_matricolaLabel);
		matricolaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		matricolaTextField = new JTextField();
		matricolaTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_matricolaTextField = new GridBagConstraints();
		gbc_matricolaTextField.fill = GridBagConstraints.BOTH;
		gbc_matricolaTextField.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaTextField.gridx = 2;
		gbc_matricolaTextField.gridy = 2;
		panel.add(matricolaTextField, gbc_matricolaTextField);
		matricolaTextField.setColumns(14);

		JLabel nomeLabel = new JLabel("Nome:");
		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
		gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeLabel.gridx = 1;
		gbc_nomeLabel.gridy = 3;
		panel.add(nomeLabel, gbc_nomeLabel);
		nomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		nomeTextField = new JTextField();
		nomeTextField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_nomeTextField = new GridBagConstraints();
		gbc_nomeTextField.fill = GridBagConstraints.BOTH;
		gbc_nomeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_nomeTextField.gridx = 2;
		gbc_nomeTextField.gridy = 3;
		panel.add(nomeTextField, gbc_nomeTextField);
		nomeTextField.setColumns(14);

		JLabel cognomeLabel = new JLabel("Cognome:");
		GridBagConstraints gbc_cognomeLabel = new GridBagConstraints();
		gbc_cognomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeLabel.gridx = 1;
		gbc_cognomeLabel.gridy = 4;
		panel.add(cognomeLabel, gbc_cognomeLabel);
		cognomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		cognomeTextField = new JTextField();
		cognomeTextField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		GridBagConstraints gbc_cognomeTextField = new GridBagConstraints();
		gbc_cognomeTextField.fill = GridBagConstraints.BOTH;
		gbc_cognomeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeTextField.gridx = 2;
		gbc_cognomeTextField.gridy = 4;
		panel.add(cognomeTextField, gbc_cognomeTextField);
		cognomeTextField.setColumns(14);

		JLabel emilaLabel = new JLabel("E-mail:");
		GridBagConstraints gbc_emilaLabel = new GridBagConstraints();
		gbc_emilaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emilaLabel.gridx = 1;
		gbc_emilaLabel.gridy = 5;
		panel.add(emilaLabel, gbc_emilaLabel);
		emilaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_emailTextField = new GridBagConstraints();
		gbc_emailTextField.fill = GridBagConstraints.BOTH;
		gbc_emailTextField.insets = new Insets(0, 0, 5, 5);
		gbc_emailTextField.gridx = 2;
		gbc_emailTextField.gridy = 5;
		panel.add(emailTextField, gbc_emailTextField);
		emailTextField.setColumns(14);

		JLabel telefonoLabel = new JLabel("Telefono:");
		GridBagConstraints gbc_telefonoLabel = new GridBagConstraints();
		gbc_telefonoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_telefonoLabel.gridx = 1;
		gbc_telefonoLabel.gridy = 6;
		panel.add(telefonoLabel, gbc_telefonoLabel);
		telefonoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		telefonoTextField = new JTextField();
		telefonoTextField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_telefonoTextField = new GridBagConstraints();
		gbc_telefonoTextField.fill = GridBagConstraints.BOTH;
		gbc_telefonoTextField.insets = new Insets(0, 0, 5, 5);
		gbc_telefonoTextField.gridx = 2;
		gbc_telefonoTextField.gridy = 6;
		panel.add(telefonoTextField, gbc_telefonoTextField);
		telefonoTextField.setColumns(14);

		JLabel ruoloLabel = new JLabel("Ruolo:");
		GridBagConstraints gbc_ruoloLabel = new GridBagConstraints();
		gbc_ruoloLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ruoloLabel.gridx = 1;
		gbc_ruoloLabel.gridy = 7;
		panel.add(ruoloLabel, gbc_ruoloLabel);
		ruoloLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		JComboBox ruoloComboBox = new JComboBox(ruolo);
		ruoloComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_ruoloComboBox = new GridBagConstraints();
		gbc_ruoloComboBox.fill = GridBagConstraints.BOTH;
		gbc_ruoloComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_ruoloComboBox.gridx = 2;
		gbc_ruoloComboBox.gridy = 7;
		panel.add(ruoloComboBox, gbc_ruoloComboBox);
		ruoloComboBox.setToolTipText("");

		JLabel stipendioLabel = new JLabel("Stipendio:");
		GridBagConstraints gbc_stipendioLabel = new GridBagConstraints();
		gbc_stipendioLabel.insets = new Insets(0, 0, 5, 5);
		gbc_stipendioLabel.gridx = 1;
		gbc_stipendioLabel.gridy = 8;
		panel.add(stipendioLabel, gbc_stipendioLabel);
		stipendioLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		stipendioTextField = new JTextField();
		stipendioTextField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_stipendioTextField = new GridBagConstraints();
		gbc_stipendioTextField.fill = GridBagConstraints.BOTH;
		gbc_stipendioTextField.insets = new Insets(0, 0, 5, 5);
		gbc_stipendioTextField.gridx = 2;
		gbc_stipendioTextField.gridy = 8;
		panel.add(stipendioTextField, gbc_stipendioTextField);
		stipendioTextField.setColumns(14);

		JButton assumiButtom = new JButton("Assumi");
		assumiButtom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_assumiButtom = new GridBagConstraints();
		gbc_assumiButtom.insets = new Insets(0, 0, 5, 5);
		gbc_assumiButtom.gridx = 3;
		gbc_assumiButtom.gridy = 9;
		panel.add(assumiButtom, gbc_assumiButtom);

		assumiButtom.addActionListener((ActionListener) new ActionListener() { // Premendo il bottone ASSUMI, si salvano
																				// nelle rispettive variabili i dati
																				// inseriti nei campi
			public void actionPerformed(ActionEvent e) {
				String nome = nomeTextField.getText();
				String congome = cognomeTextField.getText();
				String email = emailTextField.getText();
				String matricola = matricolaTextField.getText();
				String telefono = telefonoTextField.getText();
				String stipendio = stipendioTextField.getText();
				String ruolo = (String) ruoloComboBox.getItemAt(ruoloComboBox.getSelectedIndex()); // Si forza il cast a
																									// String perche'
																									// l'item
																									// selezionato
																									// sarebbe un Object

			}

		});

	}

}

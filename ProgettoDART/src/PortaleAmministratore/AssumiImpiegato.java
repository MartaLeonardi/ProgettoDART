package PortaleAmministratore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
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

public class AssumiImpiegato extends JFrame {

	private JPanel contentPane;
	private JTextField nomeTextField;
	private JTextField cognomeTextField;
	private JTextField matricolaTextField;
	private JTextField residenzaTextField;
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
		setTitle("Assumi Impiegato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setEnabled(false);

		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 205, 0, 500, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel assumiImpiegatoLabel = new JLabel("Assumi Impiegato");
		assumiImpiegatoLabel.setFont(new Font("Impact", Font.PLAIN, 30));
		GridBagConstraints gbc_assumiImpiegatoLabel = new GridBagConstraints();
		gbc_assumiImpiegatoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_assumiImpiegatoLabel.gridx = 1;
		gbc_assumiImpiegatoLabel.gridy = 1;
		contentPane.add(assumiImpiegatoLabel, gbc_assumiImpiegatoLabel);

		JButton indietroButtom = new JButton("Indietro");
		indietroButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PortaleAmministratore portaleAmm = new PortaleAmministratore();
				portaleAmm.setVisible(true);
				dispose();
			}
		});
		indietroButtom.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_indietroButtom = new GridBagConstraints();
		gbc_indietroButtom.insets = new Insets(0, 0, 5, 5);
		gbc_indietroButtom.gridx = 6;
		gbc_indietroButtom.gridy = 1;
		contentPane.add(indietroButtom, gbc_indietroButtom);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 2;
		contentPane.add(separator, gbc_separator);

		JLabel lblNewLabel_1 = new JLabel("Inserisci dati impiegato");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
		gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeLabel.anchor = GridBagConstraints.WEST;
		gbc_nomeLabel.gridx = 2;
		gbc_nomeLabel.gridy = 6;
		contentPane.add(nomeLabel, gbc_nomeLabel);

		nomeTextField = new JTextField();
		GridBagConstraints gbc_nomeTextField = new GridBagConstraints();
		gbc_nomeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_nomeTextField.anchor = GridBagConstraints.WEST;
		gbc_nomeTextField.fill = GridBagConstraints.VERTICAL;
		gbc_nomeTextField.gridx = 3;
		gbc_nomeTextField.gridy = 6;
		contentPane.add(nomeTextField, gbc_nomeTextField);
		nomeTextField.setColumns(14);

		JLabel cognomeLabel = new JLabel("Cognome:");
		cognomeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_cognomeLabel = new GridBagConstraints();
		gbc_cognomeLabel.anchor = GridBagConstraints.WEST;
		gbc_cognomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeLabel.gridx = 2;
		gbc_cognomeLabel.gridy = 7;
		contentPane.add(cognomeLabel, gbc_cognomeLabel);

		cognomeTextField = new JTextField();
		cognomeTextField.setColumns(14);
		GridBagConstraints gbc_cognomeTextField = new GridBagConstraints();
		gbc_cognomeTextField.anchor = GridBagConstraints.WEST;
		gbc_cognomeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeTextField.gridx = 3;
		gbc_cognomeTextField.gridy = 7;
		contentPane.add(cognomeTextField, gbc_cognomeTextField);

		JLabel matricolaLabel = new JLabel("Matricola:");
		matricolaLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_matricolaLabel = new GridBagConstraints();
		gbc_matricolaLabel.anchor = GridBagConstraints.WEST;
		gbc_matricolaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaLabel.gridx = 2;
		gbc_matricolaLabel.gridy = 8;
		contentPane.add(matricolaLabel, gbc_matricolaLabel);

		matricolaTextField = new JTextField();
		matricolaTextField.setColumns(14);
		GridBagConstraints gbc_matricolaTextField = new GridBagConstraints();
		gbc_matricolaTextField.anchor = GridBagConstraints.WEST;
		gbc_matricolaTextField.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaTextField.gridx = 3;
		gbc_matricolaTextField.gridy = 8;
		contentPane.add(matricolaTextField, gbc_matricolaTextField);

		JLabel residenzaLabel = new JLabel("Residenza:");
		residenzaLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_residenzaLabel = new GridBagConstraints();
		gbc_residenzaLabel.anchor = GridBagConstraints.EAST;
		gbc_residenzaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_residenzaLabel.gridx = 2;
		gbc_residenzaLabel.gridy = 9;
		contentPane.add(residenzaLabel, gbc_residenzaLabel);

		residenzaTextField = new JTextField();
		residenzaTextField.setColumns(14);
		GridBagConstraints gbc_residenzaTextField = new GridBagConstraints();
		gbc_residenzaTextField.anchor = GridBagConstraints.WEST;
		gbc_residenzaTextField.insets = new Insets(0, 0, 5, 5);
		gbc_residenzaTextField.gridx = 3;
		gbc_residenzaTextField.gridy = 9;
		contentPane.add(residenzaTextField, gbc_residenzaTextField);

		JLabel emilaLabel = new JLabel("E-mail:");
		emilaLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_emilaLabel = new GridBagConstraints();
		gbc_emilaLabel.anchor = GridBagConstraints.WEST;
		gbc_emilaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emilaLabel.gridx = 2;
		gbc_emilaLabel.gridy = 10;
		contentPane.add(emilaLabel, gbc_emilaLabel);

		emailTextField = new JTextField();
		emailTextField.setColumns(14);
		GridBagConstraints gbc_emailTextField = new GridBagConstraints();
		gbc_emailTextField.anchor = GridBagConstraints.WEST;
		gbc_emailTextField.insets = new Insets(0, 0, 5, 5);
		gbc_emailTextField.gridx = 3;
		gbc_emailTextField.gridy = 10;
		contentPane.add(emailTextField, gbc_emailTextField);

		JLabel telefonoLabel = new JLabel("Telefono:");
		telefonoLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_telefonoLabel = new GridBagConstraints();
		gbc_telefonoLabel.anchor = GridBagConstraints.WEST;
		gbc_telefonoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_telefonoLabel.gridx = 2;
		gbc_telefonoLabel.gridy = 11;
		contentPane.add(telefonoLabel, gbc_telefonoLabel);

		telefonoTextField = new JTextField();
		telefonoTextField.setColumns(14);
		GridBagConstraints gbc_telefonoTextField = new GridBagConstraints();
		gbc_telefonoTextField.anchor = GridBagConstraints.WEST;
		gbc_telefonoTextField.insets = new Insets(0, 0, 5, 5);
		gbc_telefonoTextField.gridx = 3;
		gbc_telefonoTextField.gridy = 11;
		contentPane.add(telefonoTextField, gbc_telefonoTextField);

		JLabel ruoloLabel = new JLabel("Ruolo:");
		ruoloLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_ruoloLabel = new GridBagConstraints();
		gbc_ruoloLabel.anchor = GridBagConstraints.WEST;
		gbc_ruoloLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ruoloLabel.gridx = 2;
		gbc_ruoloLabel.gridy = 12;
		contentPane.add(ruoloLabel, gbc_ruoloLabel);

		String ruolo[] = { "Ruolo 1", "Ruolo 2", "Ruolo 3", "Ruolo 4" };
		JComboBox ruoloComboBox = new JComboBox(ruolo);
		ruoloComboBox.setToolTipText("");
		GridBagConstraints gbc_ruoloComboBox = new GridBagConstraints();
		gbc_ruoloComboBox.anchor = GridBagConstraints.WEST;
		gbc_ruoloComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_ruoloComboBox.gridx = 3;
		gbc_ruoloComboBox.gridy = 12;
		contentPane.add(ruoloComboBox, gbc_ruoloComboBox);

		JLabel stipendioLabel = new JLabel("Stipendio:");
		stipendioLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_stipendioLabel = new GridBagConstraints();
		gbc_stipendioLabel.anchor = GridBagConstraints.WEST;
		gbc_stipendioLabel.insets = new Insets(0, 0, 5, 5);
		gbc_stipendioLabel.gridx = 2;
		gbc_stipendioLabel.gridy = 13;
		contentPane.add(stipendioLabel, gbc_stipendioLabel);

		stipendioTextField = new JTextField();
		stipendioTextField.setColumns(14);
		GridBagConstraints gbc_stipendioTextField = new GridBagConstraints();
		gbc_stipendioTextField.anchor = GridBagConstraints.WEST;
		gbc_stipendioTextField.insets = new Insets(0, 0, 5, 5);
		gbc_stipendioTextField.gridx = 3;
		gbc_stipendioTextField.gridy = 13;
		contentPane.add(stipendioTextField, gbc_stipendioTextField);

		JButton assumiButtom = new JButton("Assumi");
		GridBagConstraints gbc_assumiButtom = new GridBagConstraints();
		gbc_assumiButtom.anchor = GridBagConstraints.WEST;
		gbc_assumiButtom.insets = new Insets(0, 0, 0, 5);
		gbc_assumiButtom.gridx = 2;
		gbc_assumiButtom.gridy = 15;
		contentPane.add(assumiButtom, gbc_assumiButtom);

		assumiButtom.addActionListener((ActionListener) new ActionListener() { // Premendo il bottone ASSUMI, si salvano
																				// nelle rispettive variabili i dati
																				// inseriti nei campi
			public void actionPerformed(ActionEvent e) {
				String nome = nomeTextField.getText();
				String congome = cognomeTextField.getText();
				String residenza = residenzaTextField.getText();
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

package RilevazionePresenza;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import RilevazionePresenze.RilevazionePresenzaControl;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class RilevazionePresenza_OUT extends JPanel {
	private JTextField nomeTextField;
	private JTextField cognomeTextField;
	private JTextField matricolaTextField;

	/**
	 * Create the panel.
	 */
	public RilevazionePresenza_OUT() {
		setBounds(100, 100, 1000, 700);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		RilevazionePresenzaControl rivPreControl = new RilevazionePresenzaControl();

		JLabel lblNewLabel = new JLabel("USCITA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 164, 177, 53, 241, 86, 234, 0 };
		gbl_panel.rowHeights = new int[] { 143, 42, 50, 42, 67, 42, 51, 70, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel_1 = new JLabel("NOME");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		nomeTextField = new JTextField();
		nomeTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nomeTextField.setColumns(10);
		GridBagConstraints gbc_nomeTextField = new GridBagConstraints();
		gbc_nomeTextField.fill = GridBagConstraints.BOTH;
		gbc_nomeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_nomeTextField.gridx = 3;
		gbc_nomeTextField.gridy = 1;
		panel.add(nomeTextField, gbc_nomeTextField);

		JLabel lblNewLabel_1_1 = new JLabel("COGNOME");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 3;
		panel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);

		cognomeTextField = new JTextField();
		cognomeTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cognomeTextField.setColumns(10);
		GridBagConstraints gbc_cognomeTextField = new GridBagConstraints();
		gbc_cognomeTextField.fill = GridBagConstraints.BOTH;
		gbc_cognomeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeTextField.gridx = 3;
		gbc_cognomeTextField.gridy = 3;
		panel.add(cognomeTextField, gbc_cognomeTextField);

		JLabel lblNewLabel_1_2 = new JLabel("MATRICOLA");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 1;
		gbc_lblNewLabel_1_2.gridy = 5;
		panel.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);

		matricolaTextField = new JTextField();
		matricolaTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		matricolaTextField.setColumns(10);
		GridBagConstraints gbc_matricolaTextField = new GridBagConstraints();
		gbc_matricolaTextField.fill = GridBagConstraints.BOTH;
		gbc_matricolaTextField.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaTextField.gridx = 3;
		gbc_matricolaTextField.gridy = 5;
		panel.add(matricolaTextField, gbc_matricolaTextField);

		JButton btnRileva = new JButton("RILEVA");
		btnRileva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String matricola = matricolaTextField.getText();
				String nome = nomeTextField.getText();
				String cognome = cognomeTextField.getText();

				System.out.println("test");
				if (rivPreControl.checkDati(matricola, nome, cognome)) {
					rivPreControl.checkPresenzaOut(matricola);

				}

				matricolaTextField.setText("");
				nomeTextField.setText("");
				cognomeTextField.setText("");

			}
		});
		btnRileva.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_btnRileva = new GridBagConstraints();
		gbc_btnRileva.insets = new Insets(0, 0, 5, 5);
		gbc_btnRileva.fill = GridBagConstraints.VERTICAL;
		gbc_btnRileva.gridx = 4;
		gbc_btnRileva.gridy = 6;
		panel.add(btnRileva, gbc_btnRileva);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_1, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("INDIETRO");
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// -------------------------------------------------------------------- EVENTO
				// BOTTONE INDIETRO -> torna al frame RivPre
				RilevazionePresenza_HOME.back();
				// --------------------------------------------------------------------
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	}
}

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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

public class RilevazionePresenza_IN extends JPanel {
	private JTextField nomeField;
	private JTextField cognomeField;
	private JTextField matricolaField;

	/**
	 * Create the panel.
	 */
	public RilevazionePresenza_IN() {
		setBounds(100, 100, 1200, 800);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		RilevazionePresenzaControl rivPreControl = new RilevazionePresenzaControl();

		JLabel lblNewLabel = new JLabel("ENTRATA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 307, 63, 225, 98, 175, 0 };
		gbl_panel.rowHeights = new int[] { 151, 42, 50, 42, 67, 42, 57, 244, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
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

		nomeField = new JTextField();
		nomeField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_nomeField = new GridBagConstraints();
		gbc_nomeField.fill = GridBagConstraints.BOTH;
		gbc_nomeField.insets = new Insets(0, 0, 5, 5);
		gbc_nomeField.gridx = 2;
		gbc_nomeField.gridy = 1;
		panel.add(nomeField, gbc_nomeField);
		nomeField.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("COGNOME");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 3;
		panel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);

		cognomeField = new JTextField();
		cognomeField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cognomeField.setColumns(10);
		GridBagConstraints gbc_cognomeField = new GridBagConstraints();
		gbc_cognomeField.fill = GridBagConstraints.BOTH;
		gbc_cognomeField.insets = new Insets(0, 0, 5, 5);
		gbc_cognomeField.gridx = 2;
		gbc_cognomeField.gridy = 3;
		panel.add(cognomeField, gbc_cognomeField);

		JLabel lblNewLabel_1_2 = new JLabel("MATRICOLA");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 1;
		gbc_lblNewLabel_1_2.gridy = 5;
		panel.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);

		matricolaField = new JTextField();
		matricolaField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		matricolaField.setColumns(10);
		GridBagConstraints gbc_matricolaField = new GridBagConstraints();
		gbc_matricolaField.fill = GridBagConstraints.BOTH;
		gbc_matricolaField.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaField.gridx = 2;
		gbc_matricolaField.gridy = 5;
		panel.add(matricolaField, gbc_matricolaField);

		JButton btnRileva = new JButton("RILEVA");
		btnRileva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String matricola = matricolaField.getText();
				String nome = nomeField.getText();
				String cognome = cognomeField.getText();

				System.out.println("test");
				if (rivPreControl.checkDati(matricola, nome, cognome)) {
					if (rivPreControl.checkPresenzaIn(matricola)) {
						rivPreControl.updateEntrata(matricola);
					}
				}

				matricolaField.setText("");
				nomeField.setText("");
				cognomeField.setText("");

			}
		});
		btnRileva.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_btnRileva = new GridBagConstraints();
		gbc_btnRileva.insets = new Insets(0, 0, 5, 5);
		gbc_btnRileva.fill = GridBagConstraints.VERTICAL;
		gbc_btnRileva.gridx = 3;
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

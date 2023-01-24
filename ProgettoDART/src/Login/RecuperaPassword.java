package Login;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GestioneAccesso.RecuperaPasswordControl;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecuperaPassword extends JPanel {
	private JTextField matricolaTextField;

	/**
	 * Create the panel.
	 */
	public RecuperaPassword() {
		setBounds(100, 100, 1280, 800);
		setLayout(new BorderLayout(0, 0));
		Image imgLogo = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel logoImg = new JLabel("");
		panel.add(logoImg);
		logoImg.setHorizontalAlignment(SwingConstants.CENTER);
		logoImg.setIcon(new ImageIcon(imgLogo));
		logoImg.setAlignmentX(Component.CENTER_ALIGNMENT);
		logoImg.setFont(new Font("Arial", Font.PLAIN, 30));

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		panel.add(separator, BorderLayout.SOUTH);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Recupera password");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 30));
		panel_1.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 288, 0, 184, 0, 244, 0 };
		gbl_panel_2.rowHeights = new int[] { 214, 0, 0, 0, 334, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblNewLabel_1 = new JLabel("Matricola:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);

		matricolaTextField = new JTextField();
		matricolaTextField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_matricolaTextField = new GridBagConstraints();
		gbc_matricolaTextField.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_matricolaTextField.gridx = 2;
		gbc_matricolaTextField.gridy = 1;
		panel_2.add(matricolaTextField, gbc_matricolaTextField);
		matricolaTextField.setColumns(10);

		JButton reucuperaButtom = new JButton("Recupera");
		reucuperaButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String matricola = matricolaTextField.getText();
				RecuperaPasswordControl rcontrol = new RecuperaPasswordControl(matricola);
			}
		});

		JLabel lblNewLabel_2 = new JLabel("      ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 2;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		reucuperaButtom.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_reucuperaButtom = new GridBagConstraints();
		gbc_reucuperaButtom.anchor = GridBagConstraints.SOUTH;
		gbc_reucuperaButtom.insets = new Insets(0, 0, 5, 5);
		gbc_reucuperaButtom.gridx = 3;
		gbc_reucuperaButtom.gridy = 3;
		panel_2.add(reucuperaButtom, gbc_reucuperaButtom);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_3, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.back();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_3.add(btnNewButton);

	}

}

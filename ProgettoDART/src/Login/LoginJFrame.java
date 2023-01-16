package Login;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static JPasswordField passwordField;
	private static String matricola;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginJFrame frame = new LoginJFrame();
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
	public LoginJFrame() {
		setTitle("D.A.R.T - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel logoImg = new JLabel("");
		logoImg.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgLogo = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		logoImg.setIcon(new ImageIcon(imgLogo));
		panel.add(logoImg);
		panel.add(logoImg);
		logoImg.setAlignmentX(Component.CENTER_ALIGNMENT);
		logoImg.setFont(new Font("Arial", Font.PLAIN, 30));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		panel_1.add(separator, BorderLayout.NORTH);

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		JLabel loginLabel = new JLabel("LOGIN");
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		panel_2.add(loginLabel, BorderLayout.NORTH);
		loginLabel.setFont(new Font("Impact", Font.PLAIN, 35));

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 50, 50, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0, 0, 0, 30, 30, 30 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		panel_4.setLayout(gbl_panel_4);

		JLabel matricolaLabel = new JLabel("Matricola:");
		matricolaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_matricolaLabel = new GridBagConstraints();
		gbc_matricolaLabel.anchor = GridBagConstraints.NORTH;
		gbc_matricolaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaLabel.fill = GridBagConstraints.BOTH;
		gbc_matricolaLabel.gridx = 1;
		gbc_matricolaLabel.gridy = 0;
		panel_4.add(matricolaLabel, gbc_matricolaLabel);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		panel_4.add(textField, gbc_textField);
		textField.setColumns(15);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.fill = GridBagConstraints.BOTH;
		gbc_passwordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLabel.gridx = 1;
		gbc_passwordLabel.gridy = 1;
		panel_4.add(passwordLabel, gbc_passwordLabel);

		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 1;
		panel_4.add(passwordField, gbc_passwordField);

		JButton loginButtom = new JButton("Login");
		loginButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				matricola = textField.getText();
				char[] password = passwordField.getPassword();

				LoginControl loginControl = new LoginControl();
				if (loginControl.check(matricola)) {
					loginControl.choosePortal(matricola);
					dispose();
				}
			}
		});
		loginButtom.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_loginButtom = new GridBagConstraints();
		gbc_loginButtom.insets = new Insets(0, 0, 5, 0);
		gbc_loginButtom.gridx = 3;
		gbc_loginButtom.gridy = 2;
		panel_4.add(loginButtom, gbc_loginButtom);

	}

	public static String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = this.textField.getText();
	}

	// METODO AGGIUNTO DA MARTA
	public static char[] getPassword() {
		return passwordField.getPassword();
	}

}

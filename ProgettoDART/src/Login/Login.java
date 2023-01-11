package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.ComponentOrientation;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class Login {

	private JFrame frmLogin;
	private JTextField matricolaTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.getContentPane().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frmLogin.getContentPane().setFont(new Font("Impact", Font.PLAIN, 30));
		frmLogin.setBounds(100, 100, 1280, 800);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(new BorderLayout(200, 10));
		
		//setExtendedState(JFrame.MAXIMIZED_BOTH); // TUTTO SCHERMO

		
		JLabel LogoImg = new JLabel("");
		LogoImg.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgLogo = new ImageIcon (this.getClass().getResource("/logo.png")).getImage();
		frmLogin.getContentPane().add(LogoImg, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		frmLogin.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0, 30, 0, 30, 30, 30};
		gbl_panel.rowHeights = new int[] {30, 30, 30, 30, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel matricolaLabel = new JLabel("Matricola:");
		matricolaLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_matricolaLabel = new GridBagConstraints();
		gbc_matricolaLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_matricolaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaLabel.gridx = 0;
		gbc_matricolaLabel.gridy = 1;
		panel.add(matricolaLabel, gbc_matricolaLabel);
		
		matricolaTextField = new JTextField();
		GridBagConstraints gbc_matricolaTextField = new GridBagConstraints();
		gbc_matricolaTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_matricolaTextField.insets = new Insets(0, 0, 5, 5);
		gbc_matricolaTextField.gridx = 1;
		gbc_matricolaTextField.gridy = 1;
		panel.add(matricolaTextField, gbc_matricolaTextField);
		matricolaTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.anchor = GridBagConstraints.WEST;
		gbc_passwordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLabel.gridx = 0;
		gbc_passwordLabel.gridy = 3;
		panel.add(passwordLabel, gbc_passwordLabel);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 3;
		panel.add(passwordField, gbc_passwordField);
		
		JButton loginButton = new JButton("Login");
		GridBagConstraints gbc_loginButton = new GridBagConstraints();
		gbc_loginButton.insets = new Insets(0, 0, 5, 5);
		gbc_loginButton.gridx = 4;
		gbc_loginButton.gridy = 4;
		panel.add(loginButton, gbc_loginButton);
					
		
		JLabel lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 5;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 6;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		frmLogin.getContentPane().add(lblNewLabel_2, BorderLayout.WEST);
		
		JLabel lblNewLabel_3 = new JLabel("");
		frmLogin.getContentPane().add(lblNewLabel_3, BorderLayout.EAST);
		
		JLabel lblNewLabel_4 = new JLabel("");
		frmLogin.getContentPane().add(lblNewLabel_4, BorderLayout.SOUTH);
		
		
		loginButton.addActionListener((ActionListener) new ActionListener() {			//Premendo il bottode di LOGIN, il testo dei campi viene salvato nelle variabili matricola e password
			public void actionPerformed(ActionEvent e) {
			String matricola = matricolaTextField.getText();
			char[] password = passwordField.getPassword();
			
			lblNewLabel.setText(matricola);
			lblNewLabel_1.setText(String(password));
			}

			private String String(char[] password) {
				// TODO Auto-generated method stub
				return null;
			}

			public void actionPerformed1(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}

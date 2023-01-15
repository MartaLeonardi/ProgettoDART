package ModificaAccount;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PopUp.PopUp;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class modificaAccount extends JFrame {

	private JPanel contentPane;
	private JTextField mailVecchia;
	private JTextField mailNuova;
	private JTextField mailConferma;
	private JPasswordField passwordVecchia;
	private JPasswordField passwordNuova;
	private JPasswordField passwordConferma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modificaAccount frame = new modificaAccount();
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
	public modificaAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1280, 800);
		contentPane = new JPanel();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel LogoImg = new JLabel("");
		Image imgLogo = new ImageIcon (this.getClass().getResource("/logo.png")).getImage();
		LogoImg.setIcon(new ImageIcon(imgLogo));
		panel.add(LogoImg);
		
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton IndietroButton = new JButton("INDIETRO");
		IndietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CONTROLLO PER I PORTALI DA FARE
			}
		});
		IndietroButton.setHorizontalAlignment(SwingConstants.LEFT);
		IndietroButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_1.add(IndietroButton);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.WEST);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] {77, 200, 350, 100, 150, 350, 50};
		gbl_panel_2.rowHeights = new int[] {30, 68, 40, 63, 40, 58, 40, 53, 40, 30, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel = new JLabel("Cambio e-mail");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblCambioPassword = new JLabel("Cambio password");
		lblCambioPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblCambioPassword.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_lblCambioPassword = new GridBagConstraints();
		gbc_lblCambioPassword.anchor = GridBagConstraints.WEST;
		gbc_lblCambioPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblCambioPassword.gridx = 5;
		gbc_lblCambioPassword.gridy = 1;
		panel_2.add(lblCambioPassword, gbc_lblCambioPassword);
		
		JLabel lblNewLabel_1 = new JLabel("Attuale e-mail");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		mailVecchia = new JTextField();
		mailVecchia.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_mailVecchia = new GridBagConstraints();
		gbc_mailVecchia.fill = GridBagConstraints.HORIZONTAL;
		gbc_mailVecchia.insets = new Insets(0, 0, 5, 5);
		gbc_mailVecchia.gridx = 2;
		gbc_mailVecchia.gridy = 3;
		panel_2.add(mailVecchia, gbc_mailVecchia);
		mailVecchia.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Attuale password");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 4;
		gbc_lblNewLabel_1_2.gridy = 3;
		panel_2.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);
		
		passwordVecchia = new JPasswordField();
		passwordVecchia.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_passwordVecchia = new GridBagConstraints();
		gbc_passwordVecchia.insets = new Insets(0, 0, 5, 5);
		gbc_passwordVecchia.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordVecchia.gridx = 5;
		gbc_passwordVecchia.gridy = 3;
		panel_2.add(passwordVecchia, gbc_passwordVecchia);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nuova e-mail");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 5;
		panel_2.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		mailNuova = new JTextField();
		mailNuova.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_mailNuova = new GridBagConstraints();
		gbc_mailNuova.insets = new Insets(0, 0, 5, 5);
		gbc_mailNuova.fill = GridBagConstraints.HORIZONTAL;
		gbc_mailNuova.gridx = 2;
		gbc_mailNuova.gridy = 5;
		panel_2.add(mailNuova, gbc_mailNuova);
		mailNuova.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nuova password");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 4;
		gbc_lblNewLabel_1_1_1.gridy = 5;
		panel_2.add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);
		
		passwordNuova = new JPasswordField();
		passwordNuova.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_passwordNuova = new GridBagConstraints();
		gbc_passwordNuova.insets = new Insets(0, 0, 5, 5);
		gbc_passwordNuova.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordNuova.gridx = 5;
		gbc_passwordNuova.gridy = 5;
		panel_2.add(passwordNuova, gbc_passwordNuova);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Conferma e-mail");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_2.gridx = 1;
		gbc_lblNewLabel_1_1_2.gridy = 7;
		panel_2.add(lblNewLabel_1_1_2, gbc_lblNewLabel_1_1_2);
		
		mailConferma = new JTextField();
		mailConferma.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mailConferma.setColumns(10);
		GridBagConstraints gbc_mailConferma = new GridBagConstraints();
		gbc_mailConferma.fill = GridBagConstraints.HORIZONTAL;
		gbc_mailConferma.insets = new Insets(0, 0, 5, 5);
		gbc_mailConferma.gridx = 2;
		gbc_mailConferma.gridy = 7;
		panel_2.add(mailConferma, gbc_mailConferma);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Conferma password");
		lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_3.gridx = 4;
		gbc_lblNewLabel_1_1_3.gridy = 7;
		panel_2.add(lblNewLabel_1_1_3, gbc_lblNewLabel_1_1_3);
		
		passwordConferma = new JPasswordField();
		passwordConferma.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_passwordConferma = new GridBagConstraints();
		gbc_passwordConferma.insets = new Insets(0, 0, 5, 5);
		gbc_passwordConferma.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordConferma.gridx = 5;
		gbc_passwordConferma.gridy = 7;
		panel_2.add(passwordConferma, gbc_passwordConferma);
		
		JButton btnNewButton = new JButton("Cambia e-mail");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mailV, mailN, mailC;			//mailV -> mail vecchia,	mailN -> mail nuova,	mailC -> mail conferma
				
				mailV=mailVecchia.getText();
				mailN=mailNuova.getText();
				mailC=mailConferma.getText();
				
				
				if(mailN.equals(mailC)) {

					//invio di dati alla control
					
				}
				else {
					String msg = "I campi nuova e-mail e conferma e-mail non coincidono!";
					System.out.println(msg);
					PopUp popUp = new PopUp(msg);
					popUp.setVisible(true);
				}
					
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 9;
		panel_2.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnCambiaPassword = new JButton("Cambia password");
		btnCambiaPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				char[] pswV, pswN, pswC;			//pswV -> password vecchia,		pswN -> password nuova,		cpswC -> password conferma
				
				pswV=passwordVecchia.getPassword();
				pswN=passwordNuova.getPassword();
				pswC=passwordConferma.getPassword();

				if(pswN.length==pswC.length) {
					
					boolean flag=true;
					
					for(int i=0; i<pswN.length; i++) {
						char N=pswN[i];
						char C=pswC[i];
						
						if(N==C) {
							flag = true;
							System.out.println(i+ " coincide\n");
						}else {
							System.out.println(i+ " NON coincide\n");
							i=pswN.length;
							flag = false;
						}
					}
					
					if(flag==false) {
						String msg ="Nuova password e conferma password non coincidono!";
						System.out.println(msg);
						PopUp popUp = new PopUp(msg);
						popUp.setVisible(true);
					}else
					{
																				//invio dei dati alla control DA FARE
						String msg ="Nuova password e conferma password coincidono!";
						System.out.println(msg);
					}
				}
				else {
					
					String msg ="Nuova password e conferma password non coincidono!";
					System.out.println(msg);
					PopUp popUp = new PopUp(msg);
					popUp.setVisible(true);
					
					
				}
			}
		});
		btnCambiaPassword.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_btnCambiaPassword = new GridBagConstraints();
		gbc_btnCambiaPassword.insets = new Insets(0, 0, 0, 5);
		gbc_btnCambiaPassword.gridx = 5;
		gbc_btnCambiaPassword.gridy = 9;
		panel_2.add(btnCambiaPassword, gbc_btnCambiaPassword);
	}

}

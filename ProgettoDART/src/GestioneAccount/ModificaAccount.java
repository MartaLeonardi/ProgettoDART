package GestioneAccount;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Login.Login;
import Login.Utente;
import PopUp.OKPopUp;
import PopUp.OkCancelPopUp;
import PortaleAmministratore.PortaleAmministratore;
import PortaleImpiegato.PortaleImpiegato;
import javax.swing.JRadioButton;

public class ModificaAccount extends JPanel {

	private JTextField credenzialeAttuale;
	private JTextField credenzialeNuova;
	private JTextField credenzialeConferma;

	/**
	 * Create the panel.
	 */
	public ModificaAccount() {

		setBounds(100, 100, 1280, 800);
		setBorder(new EmptyBorder(5, 5, 5, 5));

		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		JLabel LogoImg = new JLabel("");
		LogoImg.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgLogo = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		LogoImg.setIcon(new ImageIcon(imgLogo));
		panel.add(LogoImg);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_1, BorderLayout.SOUTH);

		JButton IndietroButton = new JButton("INDIETRO");
		IndietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// CONTROLLO PER I PORTALI DA FARE
				Utente utente = Utente.getInstance();
				String matricola = utente.getMatricola();
				
				if (matricola.substring(0, 1).equals("0")) {
					PortaleImpiegato.back();
				} else if (matricola.substring(0, 1).equals("1")) {
					PortaleAmministratore.back();			
				}
			}
		});
		IndietroButton.setHorizontalAlignment(SwingConstants.LEFT);
		IndietroButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_1.add(IndietroButton);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 316, 113, 318, 146, 353 };
		gbl_panel_2.rowHeights = new int[] { 30, 68, 49, 40, 63, 40, 58, 40, 53, 40, 30, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0 };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);
		
				JLabel lblNewLabel = new JLabel("Cambio credenziali");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblNewLabel.gridx = 2;
				gbc_lblNewLabel.gridy = 1;
				panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 2;
		panel_2.add(panel_3, gbc_panel_3);
		
		JRadioButton EmailRadioButton = new JRadioButton("E-mail");
		EmailRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_3.add(EmailRadioButton);
		
		JRadioButton PasswordRadioButton = new JRadioButton("Password");
		PasswordRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_3.add(PasswordRadioButton);

		ButtonGroup bg = new ButtonGroup();
		bg.add(EmailRadioButton);
		bg.add(PasswordRadioButton);
		
		
		JLabel lblNewLabel_1 = new JLabel("Credenziale attuale");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);

		credenzialeAttuale = new JTextField();
		credenzialeAttuale.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_credenzialeAttuale = new GridBagConstraints();
		gbc_credenzialeAttuale.fill = GridBagConstraints.HORIZONTAL;
		gbc_credenzialeAttuale.insets = new Insets(0, 0, 5, 5);
		gbc_credenzialeAttuale.gridx = 2;
		gbc_credenzialeAttuale.gridy = 4;
		panel_2.add(credenzialeAttuale, gbc_credenzialeAttuale);
		credenzialeAttuale.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Credenziale nuova");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 6;
		panel_2.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);

		credenzialeNuova = new JTextField();
		credenzialeNuova.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_credenzialeNuova = new GridBagConstraints();
		gbc_credenzialeNuova.insets = new Insets(0, 0, 5, 5);
		gbc_credenzialeNuova.fill = GridBagConstraints.HORIZONTAL;
		gbc_credenzialeNuova.gridx = 2;
		gbc_credenzialeNuova.gridy = 6;
		panel_2.add(credenzialeNuova, gbc_credenzialeNuova);
		credenzialeNuova.setColumns(10);

		JLabel lblNewLabel_1_1_2 = new JLabel("Conferma credenziale");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_2.gridx = 1;
		gbc_lblNewLabel_1_1_2.gridy = 8;
		panel_2.add(lblNewLabel_1_1_2, gbc_lblNewLabel_1_1_2);

		credenzialeConferma = new JTextField();
		credenzialeConferma.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		credenzialeConferma.setColumns(10);
		GridBagConstraints gbc_credenzialeConferma = new GridBagConstraints();
		gbc_credenzialeConferma.fill = GridBagConstraints.HORIZONTAL;
		gbc_credenzialeConferma.insets = new Insets(0, 0, 5, 5);
		gbc_credenzialeConferma.gridx = 2;
		gbc_credenzialeConferma.gridy = 8;
		panel_2.add(credenzialeConferma, gbc_credenzialeConferma);

		JButton btnNewButton = new JButton("Cambia");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(EmailRadioButton.isSelected()) {
					OkCancelPopUp popUp = new OkCancelPopUp("Sicuro di voler cambiare e-mail?");
					popUp.setVisible(true);
					
					
					System.out.println(popUp.getFlag());

					if(popUp.getFlag()==true) {
						System.out.println("Cliccato ok pop up");
						
						boolean checkCredenzialeAttuale=modificaAccountControl.checkMail(credenzialeAttuale.getText());
						boolean checkCredenzialeNuova=modificaAccountControl.checkMail(credenzialeNuova.getText());
						boolean checkCredenzialeConferma=modificaAccountControl.checkMail(credenzialeConferma.getText());
						
						if(checkCredenzialeAttuale==true && checkCredenzialeNuova==true
								&& checkCredenzialeConferma==true) {
							System.out.println("I tre campi inseriti corrispono al pattern e-mail");
							
							//controllo con email presente nel database attraverso control
							//se controlli tutti soddisfatti allora bisogna istanziare un oggetto OKPopUp con avvenuta operazione
							
							
						}
						else {
							OKPopUp okpop = new OKPopUp("ERRORE:Controlla di aver inserito correttamente le e-mail");
							okpop.setVisible(true);
						}
						
					}
					else {
						System.out.println("Cliccato cancel pop up");
					}

					
				}
				
				else if(PasswordRadioButton.isSelected()) {
					OkCancelPopUp popUp = new OkCancelPopUp("Sicuro di voler cambiare password?");
					popUp.setVisible(true);
				}
				
				else {
					OKPopUp okpopUp = new OKPopUp("Selezionare cosa modificare (e-mail o password)");
					okpopUp.setVisible(true);
					
					System.out.println("\nOkPopUp:" +okpopUp.getFlag());
				}

			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 10;
		panel_2.add(btnNewButton, gbc_btnNewButton);
	}


	
	

}

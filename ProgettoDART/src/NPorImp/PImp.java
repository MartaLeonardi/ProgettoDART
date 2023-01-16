package NPorImp;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import NPorAmm.AssumiImp;
import NPorAmm.LicenziaImp;
import NPorAmm.PermessoImp;
import NPorAmm.VisServizi;
import NPorAmm.VisStipendi;
import NPorAmm.VisTurni;
import NPorAmm.VisualizzaSchedaImp;
import PortaleAmministratore.AssumiImpiegato;
import PortaleAmministratore.LicenziaImpiegato;
import PortaleAmministratore.LogoutControl;
import PortaleAmministratore.PermessoImpiegato;
import PortaleAmministratore.PopUpConfermaLogout;
import PortaleAmministratore.VisualizzaSchedaImpiegato;
import PortaleAmministratore.VisualizzaServizi;
import PortaleAmministratore.VisualizzaStipendi;
import PortaleAmministratore.VisualizzaTurni;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JSeparator;

public class PImp extends JFrame {

	public static CardLayout crd;
	private static JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PImp frame = new PImp();
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
	public PImp() {
		crd = new CardLayout();
		setTitle("Portale impiegato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(crd);
		crd.first(contentPane);

		FirmaIng firmaIng = new FirmaIng();
		VisStipendio visStipendio = new VisStipendio();
		VisOrario visOrario = new VisOrario();
		RichiediPerm richiediPerm = new RichiediPerm();
		RichiediSciop richiediSciopero = new RichiediSciop();
		RichiediFer richiediFerie = new RichiediFer();
		ModAccount modAccount = new ModAccount();

		JPanel panel = new JPanel();
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 1394, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JPanel PortaleAmm = new JPanel();
		PortaleAmm.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagConstraints gbc_PortaleAmm = new GridBagConstraints();
		gbc_PortaleAmm.fill = GridBagConstraints.BOTH;
		gbc_PortaleAmm.gridx = 0;
		gbc_PortaleAmm.gridy = 0;
		panel.add(PortaleAmm, gbc_PortaleAmm);
		GridBagLayout gbl_PortaleAmm = new GridBagLayout();
		gbl_PortaleAmm.columnWidths = new int[] { 220, 1039, 0 };
		gbl_PortaleAmm.rowHeights = new int[] { 0, 0 };
		gbl_PortaleAmm.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_PortaleAmm.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		PortaleAmm.setLayout(gbl_PortaleAmm);

		JPanel MenuUtente = new JPanel();
		MenuUtente.setBackground(new Color(175, 238, 238));
		GridBagConstraints gbc_MenuUtente = new GridBagConstraints();
		gbc_MenuUtente.fill = GridBagConstraints.BOTH;
		gbc_MenuUtente.insets = new Insets(0, 0, 0, 5);
		gbc_MenuUtente.gridx = 0;
		gbc_MenuUtente.gridy = 0;
		PortaleAmm.add(MenuUtente, gbc_MenuUtente);
		MenuUtente.setLayout(new BorderLayout(0, 0));

		JButton logoutButton = new JButton("LOGOUT");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogoutControl logoutControl = new LogoutControl();
				dispose();
			}
		});
		logoutButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		logoutButton.setBackground(new Color(173, 216, 230));
		MenuUtente.add(logoutButton, BorderLayout.SOUTH);

		JPanel AnagraficaUtenteMenu = new JPanel();
		AnagraficaUtenteMenu.setBackground(new Color(175, 238, 238));
		MenuUtente.add(AnagraficaUtenteMenu, BorderLayout.NORTH);
		GridBagLayout gbl_AnagraficaUtenteMenu = new GridBagLayout();
		gbl_AnagraficaUtenteMenu.columnWidths = new int[] { 155, 136, 0 };
		gbl_AnagraficaUtenteMenu.rowHeights = new int[] { 108, 0 };
		gbl_AnagraficaUtenteMenu.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_AnagraficaUtenteMenu.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		AnagraficaUtenteMenu.setLayout(gbl_AnagraficaUtenteMenu);

		JLabel UserImg = new JLabel("");
		Image imgUser = new ImageIcon(this.getClass().getResource("/utenteRid100.png")).getImage();
		UserImg.setIcon(new ImageIcon(imgUser));
		GridBagConstraints gbc_UserImg = new GridBagConstraints();
		gbc_UserImg.fill = GridBagConstraints.VERTICAL;
		gbc_UserImg.insets = new Insets(0, 0, 0, 5);
		gbc_UserImg.gridx = 0;
		gbc_UserImg.gridy = 0;
		AnagraficaUtenteMenu.add(UserImg, gbc_UserImg);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(175, 238, 238));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 0;
		AnagraficaUtenteMenu.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 46, 0 };
		gbl_panel_3.rowHeights = new int[] { 14, 0, 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
		gbc_nomeLabel.insets = new Insets(0, 0, 5, 0);
		gbc_nomeLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_nomeLabel.gridx = 0;
		gbc_nomeLabel.gridy = 0;
		panel_3.add(nomeLabel, gbc_nomeLabel);

		JLabel cognomeLabel = new JLabel("Cognome");
		cognomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_cognomeLabel = new GridBagConstraints();
		gbc_cognomeLabel.insets = new Insets(0, 0, 5, 0);
		gbc_cognomeLabel.gridx = 0;
		gbc_cognomeLabel.gridy = 1;
		panel_3.add(cognomeLabel, gbc_cognomeLabel);

		JLabel matricolaLabel = new JLabel("Matricola");
		matricolaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_matricolaLabel = new GridBagConstraints();
		gbc_matricolaLabel.gridx = 0;
		gbc_matricolaLabel.gridy = 2;
		panel_3.add(matricolaLabel, gbc_matricolaLabel);

		JPanel FunzioniUtenteMenu = new JPanel();
		FunzioniUtenteMenu.setBackground(new Color(175, 238, 238));
		MenuUtente.add(FunzioniUtenteMenu, BorderLayout.CENTER);
		FunzioniUtenteMenu.setLayout(new GridLayout(13, 1, 10, 5));

		JSeparator separator = new JSeparator();
		FunzioniUtenteMenu.add(separator);

		JButton FirmaIngressoButton = new JButton("Firma ingresso");
		FirmaIngressoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.show(contentPane, "FirmaIngresso");
			}
		});
		FirmaIngressoButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		FunzioniUtenteMenu.add(FirmaIngressoButton);

		JButton VisualizzaStipendioButton = new JButton("Visualizza stipendio");
		VisualizzaStipendioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.show(contentPane, "VisualizzaStipendio");
			}
		});
		VisualizzaStipendioButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		FunzioniUtenteMenu.add(VisualizzaStipendioButton);

		JButton VisualizzaOrarioButton = new JButton("Visualizza orario");
		VisualizzaOrarioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.show(contentPane, "VisualizzaOrario");
			}
		});
		VisualizzaOrarioButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		FunzioniUtenteMenu.add(VisualizzaOrarioButton);

		JButton RichiediPermessoButton = new JButton("Richiedi permesso");
		RichiediPermessoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.show(contentPane, "RichiediPermesso");
			}
		});
		RichiediPermessoButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		FunzioniUtenteMenu.add(RichiediPermessoButton);

		JButton RichiediScioperoButton = new JButton("Richiedi sciopero");
		RichiediScioperoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.show(contentPane, "RichiediSciopero");
			}
		});
		RichiediScioperoButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		FunzioniUtenteMenu.add(RichiediScioperoButton);

		JButton RichiediFerieButton = new JButton("Richiedi ferie");
		RichiediFerieButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.show(contentPane, "RichiediFerie");
			}
		});
		RichiediFerieButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		FunzioniUtenteMenu.add(RichiediFerieButton);

		JButton ModificaAccountButton = new JButton("Modifica account");
		ModificaAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.show(contentPane, "ModificaAccount");
			}
		});
		ModificaAccountButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		FunzioniUtenteMenu.add(ModificaAccountButton);

		JPanel Pannello = new JPanel();
		Pannello.setBorder(new EmptyBorder(0, 0, 0, 0));
		GridBagConstraints gbc_Pannello = new GridBagConstraints();
		gbc_Pannello.fill = GridBagConstraints.BOTH;
		gbc_Pannello.gridx = 1;
		gbc_Pannello.gridy = 0;
		PortaleAmm.add(Pannello, gbc_Pannello);
		Pannello.setLayout(new BorderLayout(0, 0));

		JLabel LogoImg = new JLabel("");
		LogoImg.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgLogo = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		LogoImg.setIcon(new ImageIcon(imgLogo));
		Pannello.add(LogoImg, BorderLayout.NORTH);

		contentPane.add(panel, "PortaleImpiegato");
		contentPane.add(firmaIng, "FirmaIngresso");
		contentPane.add(visStipendio, "VisualizzaStipendio");
		contentPane.add(visOrario, "VisualizzaOrario");
		contentPane.add(richiediPerm, "RichiediPermesso");
		contentPane.add(richiediSciopero, "RichiediSciopero");
		contentPane.add(richiediFerie, "RichiediFerie");
		contentPane.add(modAccount, "ModificaAccount");
		// crd.show(contentPane, "PortaleAmministrazione");

	}

	public static void back() {
		crd.show(contentPane, "PortaleImpiegato");
	}

}

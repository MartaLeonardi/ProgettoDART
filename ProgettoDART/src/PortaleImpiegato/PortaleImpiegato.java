package PortaleImpiegato;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JSeparator;
<<<<<<< HEAD
=======
import java.awt.Component;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Login.LoginJFrame;
import RilevazionePresenza.RivPre_IN;

import javax.swing.SwingConstants;
>>>>>>> branch 'master' of https://github.com/MartaLeonardi/ProgettoDART.git
import java.awt.GridLayout;

public class PortaleImpiegato extends JFrame {

	private JPanel PortaleImp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PortaleImpiegato PortaleImpiegato = new PortaleImpiegato();
					PortaleImpiegato.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PortaleImpiegato() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		PortaleImp = new JPanel();
		PortaleImp.setBorder(new EmptyBorder(5, 5, 5, 5));

		setExtendedState(JFrame.MAXIMIZED_BOTH); // TUTTO SCHERMO

		setContentPane(PortaleImp);
		GridBagLayout gbl_contentPane = new GridBagLayout();

		gbl_contentPane.columnWidths = new int[] { 204, 1039, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		PortaleImp.setLayout(gbl_contentPane);

		gbl_contentPane.columnWidths = new int[] { 204, 1039, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		PortaleImp.setLayout(gbl_contentPane);

		JPanel MenuUtente = new JPanel();
		MenuUtente.setBackground(new Color(175, 238, 238));
		GridBagConstraints gbc_MenuUtente = new GridBagConstraints();
		gbc_MenuUtente.insets = new Insets(0, 0, 0, 5);
		gbc_MenuUtente.fill = GridBagConstraints.BOTH;
		gbc_MenuUtente.gridx = 0;
		gbc_MenuUtente.gridy = 0;
		PortaleImp.add(MenuUtente, gbc_MenuUtente);
		MenuUtente.setLayout(new BorderLayout(0, 0));

		JButton logoutButton = new JButton("LOGOUT");
		logoutButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		logoutButton.setBackground(new Color(173, 216, 230));
		logoutButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				LoginJFrame login = new LoginJFrame();
				login.setVisible(true);
				dispose();
			}
		});
		MenuUtente.add(logoutButton, BorderLayout.SOUTH);

		JPanel AnagraficaUtenteMenu = new JPanel();
		AnagraficaUtenteMenu.setBackground(new Color(175, 238, 238));
		MenuUtente.add(AnagraficaUtenteMenu, BorderLayout.NORTH);
		GridBagLayout gbl_AnagraficaUtenteMenu = new GridBagLayout();
		gbl_AnagraficaUtenteMenu.columnWidths = new int[] { 10, 102 };
		gbl_AnagraficaUtenteMenu.rowHeights = new int[] { 130 };
		gbl_AnagraficaUtenteMenu.columnWeights = new double[] { 1.0, 1.0 };
		gbl_AnagraficaUtenteMenu.rowWeights = new double[] { 1.0 };
		AnagraficaUtenteMenu.setLayout(gbl_AnagraficaUtenteMenu);

		JLabel UserImg = new JLabel("");
		Image imgUser = new ImageIcon(this.getClass().getResource("/utenteRid100.png")).getImage();
		UserImg.setIcon(new ImageIcon(imgUser));

		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		AnagraficaUtenteMenu.add(UserImg, gbc_lblNewLabel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(175, 238, 238));
		panel_3.setLayout(null);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 0;
		AnagraficaUtenteMenu.add(panel_3, gbc_panel_3);

		JLabel nomeValue = new JLabel("Nome:");
		nomeValue.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		nomeValue.setBounds(0, 10, 66, 30);
		panel_3.add(nomeValue);

		JLabel cognomeValue = new JLabel("Cognome:");
		cognomeValue.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		cognomeValue.setBounds(0, 50, 102, 30);
		panel_3.add(cognomeValue);

		JLabel matricolaValue = new JLabel("Matricola:");
		matricolaValue.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		matricolaValue.setBounds(0, 90, 105, 30);
		panel_3.add(matricolaValue);

		JPanel FunzioniUtenteMenu = new JPanel();
		FunzioniUtenteMenu.setBackground(new Color(175, 238, 238));
		MenuUtente.add(FunzioniUtenteMenu, BorderLayout.CENTER);
		FunzioniUtenteMenu.setLayout(new GridLayout(13, 1, 10, 5));

		JSeparator separator = new JSeparator();
		FunzioniUtenteMenu.add(separator);

		JButton FirmaIngressoButton = new JButton("Firma ingresso");

		// -------------------------------------------------------------------------------------------------EVENTO
		// FIRMA INGRESSO > FirmaIngresso.java
		FirmaIngressoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FirmaIngresso FirmaIngresso = new FirmaIngresso();
				FirmaIngresso.setVisible(true);

			}
		});

		FirmaIngressoButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		FunzioniUtenteMenu.add(FirmaIngressoButton);

		JButton VisualizzaStipendioButton = new JButton("Visualizza stipendio");
		// -------------------------------------------------------------------------------------------------EVENTO
		// VISUALIZZA STIPENDIO> VisualizzaStipendio.java
		VisualizzaStipendioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VisualizzaStipendio visualizzaStipendio = new VisualizzaStipendio();
				visualizzaStipendio.setVisible(true);

			}
		});
		VisualizzaStipendioButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		FunzioniUtenteMenu.add(VisualizzaStipendioButton);

		JButton VisualizzaOrarioButton = new JButton("Visualizza orario");
		// -------------------------------------------------------------------------------------------------EVENTO
		// VISUALIZZA ORARIO > VisualizzaOrario.java
		VisualizzaOrarioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VisualizzaOrario visualizzaOrario = new VisualizzaOrario();
				visualizzaOrario.setVisible(true);

			}
		});
		VisualizzaOrarioButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		FunzioniUtenteMenu.add(VisualizzaOrarioButton);

		JButton RichiediPermessoButton = new JButton("Richiedi permesso");
		// -------------------------------------------------------------------------------------------------EVENTO
		// RICHIEDI PERMESSO > RichiediPermesso.java
		RichiediPermessoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RichiediPermesso richiediPermesso = new RichiediPermesso();
				richiediPermesso.setVisible(true);

			}
		});
		RichiediPermessoButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		FunzioniUtenteMenu.add(RichiediPermessoButton);

		JButton RichiediScioperoButton = new JButton("Richiedi sciopero");
		// -------------------------------------------------------------------------------------------------EVENTO
		// RICHIEDI SCIOPERO > RichiediSciopero.java
		RichiediScioperoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RichiediSciopero richiediSciopero = new RichiediSciopero();
				richiediSciopero.setVisible(true);

			}
		});
		RichiediScioperoButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		FunzioniUtenteMenu.add(RichiediScioperoButton);

		JButton RichiediFerieButton = new JButton("Richiedi ferie");
		// -------------------------------------------------------------------------------------------------EVENTO
		// RICHIEDI FERIE > RichiediFerie.java
		RichiediFerieButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RichiediFerie richiediFerie = new RichiediFerie();
				richiediFerie.setVisible(true);

			}
		});
		RichiediFerieButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		FunzioniUtenteMenu.add(RichiediFerieButton);

		JButton ModificaAccountButton = new JButton("Modifica account");
		ModificaAccountButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		FunzioniUtenteMenu.add(ModificaAccountButton);

		JPanel Pannello = new JPanel();
		Pannello.setBorder(new EmptyBorder(0, 0, 0, 0));
		GridBagConstraints gbc_Pannello = new GridBagConstraints();
		gbc_Pannello.fill = GridBagConstraints.BOTH;
		gbc_Pannello.gridx = 1;
		gbc_Pannello.gridy = 0;
		PortaleImp.add(Pannello, gbc_Pannello);
		Pannello.setLayout(new BorderLayout(0, 0));

		JPanel IntestazioneLogoCampana = new JPanel();
		Pannello.add(IntestazioneLogoCampana, BorderLayout.NORTH);
		GridBagLayout gbl_IntestazioneLogoCampana = new GridBagLayout();
		gbl_IntestazioneLogoCampana.columnWidths = new int[] { 0, 10 };
		gbl_IntestazioneLogoCampana.rowHeights = new int[] { 0 };
		gbl_IntestazioneLogoCampana.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_IntestazioneLogoCampana.rowWeights = new double[] { 0.0 };
		IntestazioneLogoCampana.setLayout(gbl_IntestazioneLogoCampana);

		JLabel LogoImg = new JLabel("");
		Image imgLogo = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		LogoImg.setIcon(new ImageIcon(imgLogo));

		GridBagConstraints gbc_LogoImg = new GridBagConstraints();
		gbc_LogoImg.insets = new Insets(0, 0, 0, 5);
		gbc_LogoImg.gridx = 0;
		gbc_LogoImg.gridy = 0;
		IntestazioneLogoCampana.add(LogoImg, gbc_LogoImg);

		JButton CampanellaButton = new JButton(" ");
		CampanellaButton.setBackground(new Color(240, 240, 240));
		CampanellaButton.setBorder(null);
		CampanellaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CampanellaButton.setForeground(new Color(0, 0, 0));
		Image imgCampanella = new ImageIcon(this.getClass().getResource("/campanellaRid50.png")).getImage();
		CampanellaButton.setIcon(new ImageIcon(imgCampanella));

		GridBagConstraints gbc_CampanellaButton = new GridBagConstraints();
		gbc_CampanellaButton.anchor = GridBagConstraints.NORTHEAST;
		gbc_CampanellaButton.gridx = 1;
		gbc_CampanellaButton.gridy = 0;
		IntestazioneLogoCampana.add(CampanellaButton, gbc_CampanellaButton);
	}
}
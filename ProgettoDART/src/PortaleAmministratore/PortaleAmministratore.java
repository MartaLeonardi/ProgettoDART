package PortaleAmministratore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.Utente;

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

public class PortaleAmministratore extends JFrame {

	public static CardLayout crd;
	private static JPanel contentPane;
	private static PortaleAmministratore instance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PortaleAmministratore frame = PortaleAmministratore.getInstance();
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
	public PortaleAmministratore() {
		
		Utente utente = Utente.getInstance();
		String nome = utente.getNome();
		String cognome = utente.getCognome();
		String matricola = utente.getMatricola();
		
		crd = new CardLayout();
		setTitle("Portale amministratore");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(crd);
		crd.first(contentPane);

		AssumiImpiegato assumiImp = new AssumiImpiegato();
		LicenziaImpiegato licenziaImp = new LicenziaImpiegato();
		VisualizzaSchedaImpiegato visualizzaSchedaImp = new VisualizzaSchedaImpiegato();
		VisualizzaTurni visTurni = new VisualizzaTurni();
		VisualizzaServizi visServizi = new VisualizzaServizi();
		PermessoImpiegato permessoImp = new PermessoImpiegato();
		VisualizzaStipendi visStipendi = new VisualizzaStipendi();

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


		JLabel nomeLabel = new JLabel(nome);
		nomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
		gbc_nomeLabel.insets = new Insets(0, 0, 5, 0);
		gbc_nomeLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_nomeLabel.gridx = 0;
		gbc_nomeLabel.gridy = 0;
		panel_3.add(nomeLabel, gbc_nomeLabel);

		JLabel cognomeLabel = new JLabel(cognome);
		cognomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_cognomeLabel = new GridBagConstraints();
		gbc_cognomeLabel.insets = new Insets(0, 0, 5, 0);
		gbc_cognomeLabel.gridx = 0;
		gbc_cognomeLabel.gridy = 1;
		panel_3.add(cognomeLabel, gbc_cognomeLabel);

		JLabel matricolaLabel = new JLabel(matricola);
		matricolaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_matricolaLabel = new GridBagConstraints();
		gbc_matricolaLabel.gridx = 0;
		gbc_matricolaLabel.gridy = 2;
		panel_3.add(matricolaLabel, gbc_matricolaLabel);

		JPanel FunzioneUtenteMenu = new JPanel();
		FunzioneUtenteMenu.setBackground(new Color(175, 238, 238));
		MenuUtente.add(FunzioneUtenteMenu, BorderLayout.CENTER);
		GridBagLayout gbl_FunzioneUtenteMenu = new GridBagLayout();
		gbl_FunzioneUtenteMenu.columnWidths = new int[] { 300, 0 };
		gbl_FunzioneUtenteMenu.rowHeights = new int[] { 37, 0, 0, 0, 0, 40, 39, 0, 306 };
		gbl_FunzioneUtenteMenu.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_FunzioneUtenteMenu.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		FunzioneUtenteMenu.setLayout(gbl_FunzioneUtenteMenu);

		JButton AssumiImpiegatoButton = new JButton("Assumi Impiegato");
		AssumiImpiegatoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.show(contentPane, "AssumiImpiegato");
			}
		});
		AssumiImpiegatoButton.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_AssumiImpiegatoButton = new GridBagConstraints();
		gbc_AssumiImpiegatoButton.insets = new Insets(0, 0, 5, 0);
		gbc_AssumiImpiegatoButton.ipady = 10;
		gbc_AssumiImpiegatoButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_AssumiImpiegatoButton.gridx = 0;
		gbc_AssumiImpiegatoButton.gridy = 1;
		FunzioneUtenteMenu.add(AssumiImpiegatoButton, gbc_AssumiImpiegatoButton);

		JButton licenziaImpiegato = new JButton("Licenzia Impiegato");
		licenziaImpiegato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.show(contentPane, "LicenziaImpiegato");
			}
		});
		licenziaImpiegato.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_licenziaImpiegato = new GridBagConstraints();
		gbc_licenziaImpiegato.insets = new Insets(0, 0, 5, 0);
		gbc_licenziaImpiegato.ipady = 10;
		gbc_licenziaImpiegato.fill = GridBagConstraints.BOTH;
		gbc_licenziaImpiegato.gridx = 0;
		gbc_licenziaImpiegato.gridy = 2;
		FunzioneUtenteMenu.add(licenziaImpiegato, gbc_licenziaImpiegato);
		gbc_AssumiImpiegatoButton.insets = new Insets(0, 0, 5, 0);
		gbc_AssumiImpiegatoButton.ipady = 10;

		JButton visSchedaImpiegato = new JButton("Visualizza Scheda Imp.");
		visSchedaImpiegato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.show(contentPane, "VisualizzaSchedaImpiegato");
			}
		});
		visSchedaImpiegato.setBounds(new Rectangle(0, 0, 0, 4));
		visSchedaImpiegato.setPreferredSize(new Dimension(121, 23));
		visSchedaImpiegato.setMinimumSize(new Dimension(121, 23));
		visSchedaImpiegato.setMaximumSize(new Dimension(121, 23));
		visSchedaImpiegato.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_visSchedaImpiegato = new GridBagConstraints();
		gbc_visSchedaImpiegato.ipady = 15;
		gbc_visSchedaImpiegato.insets = new Insets(0, 0, 5, 0);
		gbc_visSchedaImpiegato.fill = GridBagConstraints.BOTH;
		gbc_visSchedaImpiegato.gridx = 0;
		gbc_visSchedaImpiegato.gridy = 3;
		FunzioneUtenteMenu.add(visSchedaImpiegato, gbc_visSchedaImpiegato);

		JButton visTurniButtom = new JButton("Visualizza Turni");
		visTurniButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.show(contentPane, "VisualizzaTurni");
			}
		});
		visTurniButtom.setPreferredSize(new Dimension(121, 23));
		visTurniButtom.setMinimumSize(new Dimension(121, 23));
		visTurniButtom.setMaximumSize(new Dimension(121, 23));
		visTurniButtom.setFont(new Font("Arial", Font.PLAIN, 15));
		visTurniButtom.setBounds(new Rectangle(0, 0, 0, 4));
		GridBagConstraints gbc_visTurniButtom = new GridBagConstraints();
		gbc_visTurniButtom.insets = new Insets(0, 0, 5, 0);
		gbc_visTurniButtom.fill = GridBagConstraints.HORIZONTAL;
		gbc_visTurniButtom.ipady = 15;
		gbc_visTurniButtom.gridx = 0;
		gbc_visTurniButtom.gridy = 4;
		FunzioneUtenteMenu.add(visTurniButtom, gbc_visTurniButtom);

		JButton visualizzaServizi = new JButton("Visualizza Servizi");
		visualizzaServizi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.show(contentPane, "VisualizzaServizi");
			}
		});
		visualizzaServizi.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_visualizzaServizi = new GridBagConstraints();
		gbc_visualizzaServizi.insets = new Insets(0, 0, 5, 0);
		gbc_visualizzaServizi.ipady = 10;
		gbc_visualizzaServizi.fill = GridBagConstraints.BOTH;
		gbc_visualizzaServizi.gridx = 0;
		gbc_visualizzaServizi.gridy = 5;
		FunzioneUtenteMenu.add(visualizzaServizi, gbc_visualizzaServizi);

		JButton permessoImpiegato = new JButton("Permesso Impiegato");
		permessoImpiegato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.show(contentPane, "PermessoImpiegato");
			}
		});
		permessoImpiegato.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_permessoImpiegato = new GridBagConstraints();
		gbc_permessoImpiegato.insets = new Insets(0, 0, 5, 0);
		gbc_permessoImpiegato.ipady = 10;
		gbc_permessoImpiegato.fill = GridBagConstraints.BOTH;
		gbc_permessoImpiegato.gridx = 0;
		gbc_permessoImpiegato.gridy = 6;
		FunzioneUtenteMenu.add(permessoImpiegato, gbc_permessoImpiegato);

		JButton visuallizaStipendi = new JButton("Visualizza Stipendi");
		visuallizaStipendi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.show(contentPane, "VisualizzaStipendi");
			}
		});
		visuallizaStipendi.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_visuallizaStipendi = new GridBagConstraints();
		gbc_visuallizaStipendi.insets = new Insets(0, 0, 5, 0);
		gbc_visuallizaStipendi.ipady = 10;
		gbc_visuallizaStipendi.fill = GridBagConstraints.BOTH;
		gbc_visuallizaStipendi.gridx = 0;
		gbc_visuallizaStipendi.gridy = 7;
		FunzioneUtenteMenu.add(visuallizaStipendi, gbc_visuallizaStipendi);

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

		contentPane.add(panel, "PortaleAmministrazione");
		contentPane.add(assumiImp, "AssumiImpiegato");
		contentPane.add(licenziaImp, "LicenziaImpiegato");
		contentPane.add(visualizzaSchedaImp, "VisualizzaSchedaImpiegato");
		contentPane.add(visTurni, "VisualizzaTurni");
		contentPane.add(visServizi, "VisualizzaServizi");
		contentPane.add(permessoImp, "PermessoImpiegato");
		contentPane.add(visStipendi, "VisualizzaStipendi");
		// crd.show(contentPane, "PortaleAmministrazione");

	}

	public static void back() {
		crd.show(contentPane, "PortaleAmministrazione");
	}

	public static PortaleAmministratore getInstance() {
		if (instance == null) {
			instance = new PortaleAmministratore();
		}
		return instance;
	}
}

package PortaleAmministratore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.JSeparator;
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
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Rectangle;

public class PortaleAmministratore extends JFrame {

	private JPanel PortaleAmm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PortaleAmministratore portaleAmministratore = new PortaleAmministratore();
					portaleAmministratore.setVisible(true);
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
		setTitle("Portale amministratore");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		PortaleAmm = new JPanel();
		PortaleAmm.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PortaleAmm);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 204, 1039, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		PortaleAmm.setLayout(gbl_contentPane);
		JPanel MenuUtente = new JPanel();
		MenuUtente.setBackground(new Color(175, 238, 238));
		GridBagConstraints gbc_MenuUtente = new GridBagConstraints();
		gbc_MenuUtente.insets = new Insets(0, 0, 0, 5);
		gbc_MenuUtente.fill = GridBagConstraints.BOTH;
		gbc_MenuUtente.gridx = 0;
		gbc_MenuUtente.gridy = 0;
		PortaleAmm.add(MenuUtente, gbc_MenuUtente);
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
		GridBagLayout gbl_FunzioniUtenteMenu = new GridBagLayout();
		gbl_FunzioniUtenteMenu.columnWidths = new int[] { 208, 0 };
		gbl_FunzioniUtenteMenu.rowHeights = new int[] { 40, 0, 0, 0, 0, 0, 0 };
		gbl_FunzioniUtenteMenu.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_FunzioniUtenteMenu.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		FunzioniUtenteMenu.setLayout(gbl_FunzioniUtenteMenu);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.anchor = GridBagConstraints.NORTH;
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 0;
		FunzioniUtenteMenu.add(separator, gbc_separator);

		JButton AssumiImpiegatoButton = new JButton("Assumi Impiegato");
		AssumiImpiegatoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AssumiImpiegato assumiImpiegato = new AssumiImpiegato();
				assumiImpiegato.setVisible(true);
				dispose();
			}
		});
		AssumiImpiegatoButton.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_AssumiImpiegatoButton = new GridBagConstraints();
		gbc_AssumiImpiegatoButton.insets = new Insets(0, 0, 5, 0);
		gbc_AssumiImpiegatoButton.ipady = 10;
		gbc_AssumiImpiegatoButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_AssumiImpiegatoButton.gridx = 0;
		gbc_AssumiImpiegatoButton.gridy = 1;
		FunzioniUtenteMenu.add(AssumiImpiegatoButton, gbc_AssumiImpiegatoButton);

		JButton licenziaImpiegato = new JButton("Licenzia Impiegato");
		licenziaImpiegato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LicenziaImpiegato licenziaImpiegato = new LicenziaImpiegato();
				licenziaImpiegato.setVisible(true);
				dispose();
			}
		});
		licenziaImpiegato.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_licenziaImpiegato = new GridBagConstraints();
		gbc_licenziaImpiegato.insets = new Insets(0, 0, 5, 0);
		gbc_licenziaImpiegato.ipady = 10;
		gbc_licenziaImpiegato.fill = GridBagConstraints.BOTH;
		gbc_licenziaImpiegato.gridx = 0;
		gbc_licenziaImpiegato.gridy = 2;
		FunzioniUtenteMenu.add(licenziaImpiegato, gbc_licenziaImpiegato);

		JButton visSchedaImpiegato = new JButton("Visualizza Scheda Imp.");
		visSchedaImpiegato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizzaSchedaImpiegato visSchedaImp = new VisualizzaSchedaImpiegato();
				visSchedaImp.setVisible(true);
				dispose();
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
		gbc_AssumiImpiegatoButton.insets = new Insets(0, 0, 5, 0);
		gbc_AssumiImpiegatoButton.ipady = 10;
		gbc_visSchedaImpiegato.fill = GridBagConstraints.BOTH;
		gbc_visSchedaImpiegato.gridx = 0;
		gbc_visSchedaImpiegato.gridy = 3;
		FunzioniUtenteMenu.add(visSchedaImpiegato, gbc_visSchedaImpiegato);

		JButton visTurniButtom = new JButton("Visualizza Turni");
		visTurniButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizzaTurni visTurni = new VisualizzaTurni();
				visTurni.setVisible(true);
				dispose();
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
		FunzioniUtenteMenu.add(visTurniButtom, gbc_visTurniButtom);

		JButton visualizzaServizi = new JButton("Visualizza Servizi");
		visualizzaServizi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizzaServizi visSer = new VisualizzaServizi();
				visSer.setVisible(true);
				dispose();
			}
		});
		visualizzaServizi.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_visualizzaServizi = new GridBagConstraints();
		gbc_visualizzaServizi.ipady = 10;
		gbc_visualizzaServizi.fill = GridBagConstraints.BOTH;
		gbc_visualizzaServizi.gridx = 0;
		gbc_visualizzaServizi.gridy = 5;
		FunzioniUtenteMenu.add(visualizzaServizi, gbc_visualizzaServizi);

		JPanel Pannello = new JPanel();
		Pannello.setBorder(new EmptyBorder(0, 0, 0, 0));
		GridBagConstraints gbc_Pannello = new GridBagConstraints();
		gbc_Pannello.fill = GridBagConstraints.BOTH;
		gbc_Pannello.gridx = 1;
		gbc_Pannello.gridy = 0;
		PortaleAmm.add(Pannello, gbc_Pannello);
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

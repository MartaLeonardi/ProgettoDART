package PortaleAmministratore;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import PortaleImpiegato.PortaleImpiegato;
import javax.swing.JTextField;

public class PermessoImpiegato extends JFrame {

	private JPanel contentPane;
	private JTextField campoMatricola;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PermessoImpiegato frame = new PermessoImpiegato();
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
	public PermessoImpiegato() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setExtendedState(JFrame.MAXIMIZED_BOTH);	
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel LogoImg = new JLabel("");
		Image imgLogo = new ImageIcon (this.getClass().getResource("/logo.png")).getImage();
		LogoImg.setIcon(new ImageIcon(imgLogo));
		panel.add(LogoImg);
		panel.add(LogoImg);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton IndietroButton = new JButton("INDIETRO");
		//-------------------------------------------------------------------------------------------------EVENTO INDIETRO > PortaleImpiegato.java
		IndietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PortaleAmministratore portaleAmministratore = new PortaleAmministratore();
				portaleAmministratore.setVisible(true);

			}
		});
		IndietroButton.setHorizontalAlignment(SwingConstants.LEFT);
		IndietroButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_1.add(IndietroButton);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblRichiestaPermesso = new JLabel("RICHIESTA  PERMESSO");
		lblRichiestaPermesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblRichiestaPermesso.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel_2.add(lblRichiestaPermesso, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3_1 = new JPanel();
		panel_4.add(panel_3_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_3_1 = new GridBagLayout();
		gbl_panel_3_1.columnWidths = new int[]{0, 468, 248, 525, 0};
		gbl_panel_3_1.rowHeights = new int[] {30, 0, 0};
		gbl_panel_3_1.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel_3_1.setLayout(gbl_panel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("Matricola impiegato:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 1;
		panel_3_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		campoMatricola = new JTextField();
		campoMatricola.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_campoMatricola = new GridBagConstraints();
		gbc_campoMatricola.insets = new Insets(0, 0, 5, 5);
		gbc_campoMatricola.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoMatricola.gridx = 2;
		gbc_campoMatricola.gridy = 1;
		panel_3_1.add(campoMatricola, gbc_campoMatricola);
		campoMatricola.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Motivazione:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 1;
		gbc_lblNewLabel_1_2.gridy = 4;
		panel_3_1.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);
		
		JComboBox motivazioni = new JComboBox();
		String[] listaMotivazioni= new String[] {"Malattia", "Congedo parentale"};
		motivazioni.setModel(new DefaultComboBoxModel(listaMotivazioni));
		motivazioni.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 4;
		panel_3_1.add(motivazioni, gbc_comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Scegli il giorno di inizio permesso:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 6;
		panel_3_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JDateChooser dataInizio = new JDateChooser();
		dataInizio.setDateFormatString("dd-MM-yyyy");
		GridBagConstraints gbc_dataInizio = new GridBagConstraints();
		gbc_dataInizio.fill = GridBagConstraints.BOTH;
		gbc_dataInizio.insets = new Insets(0, 0, 5, 5);
		gbc_dataInizio.gridx = 2;
		gbc_dataInizio.gridy = 6;
		panel_3_1.add(dataInizio, gbc_dataInizio);
		
		JLabel ProvaInserimentoInizio = new JLabel(" ");
		ProvaInserimentoInizio.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_ProvaInserimentoInizio = new GridBagConstraints();
		gbc_ProvaInserimentoInizio.insets = new Insets(0, 0, 5, 5);
		gbc_ProvaInserimentoInizio.gridx = 2;
		gbc_ProvaInserimentoInizio.gridy = 7;
		panel_3_1.add(ProvaInserimentoInizio, gbc_ProvaInserimentoInizio);
		
		JLabel lblNewLabel_1_1 = new JLabel("Scegli il giorno di fine permesso:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 8;
		panel_3_1.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		JDateChooser dataFine = new JDateChooser();
		dataFine.setDateFormatString("dd-MM-yyyy");
		GridBagConstraints gbc_dataFine = new GridBagConstraints();
		gbc_dataFine.fill = GridBagConstraints.BOTH;
		gbc_dataFine.insets = new Insets(0, 0, 5, 5);
		gbc_dataFine.gridx = 2;
		gbc_dataFine.gridy = 8;
		panel_3_1.add(dataFine, gbc_dataFine);
		
		JLabel ProvaInserimentoFine = new JLabel(" ");
		ProvaInserimentoFine.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_ProvaInserimentoFine = new GridBagConstraints();
		gbc_ProvaInserimentoFine.insets = new Insets(0, 0, 5, 5);
		gbc_ProvaInserimentoFine.gridx = 2;
		gbc_ProvaInserimentoFine.gridy = 9;
		panel_3_1.add(ProvaInserimentoFine, gbc_ProvaInserimentoFine);
		
		JCheckBox giornateComplete = new JCheckBox("Giornate complete");
		
		giornateComplete.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_giornateComplete = new GridBagConstraints();
		gbc_giornateComplete.anchor = GridBagConstraints.NORTH;
		gbc_giornateComplete.insets = new Insets(0, 0, 0, 5);
		gbc_giornateComplete.gridx = 1;
		gbc_giornateComplete.gridy = 10;
		panel_3_1.add(giornateComplete, gbc_giornateComplete);
		
		JPanel panel_3 = new JPanel();
		panel_4.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));
		
		JLabel lblNewLabel_3 = new JLabel("Ora inizio:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_3.add(lblNewLabel_3);
		
		String[] ora = new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
		String[] minuti = new String[] {"00", "15", "30", "45"};
		
		JComboBox oraInizio = new JComboBox();
		oraInizio.setModel(new DefaultComboBoxModel(ora));
		oraInizio.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_3.add(oraInizio);
		
		JLabel lblNewLabel_3_1 = new JLabel(":    Minuti inizio:");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_3.add(lblNewLabel_3_1);
		
		JComboBox minutoInizio = new JComboBox();
		minutoInizio.setModel(new DefaultComboBoxModel(minuti));
		minutoInizio.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_3.add(minutoInizio);
		
		JLabel lblNewLabel_3_2 = new JLabel("-    Ora fine:");
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_3.add(lblNewLabel_3_2);
		
		JComboBox oraFine = new JComboBox();
		oraFine.setModel(new DefaultComboBoxModel(ora));
		oraFine.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_3.add(oraFine);
		
		JLabel lblNewLabel_3_1_1 = new JLabel(":    Minuti fine:");
		lblNewLabel_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_3.add(lblNewLabel_3_1_1);
		
		JComboBox minutoFine = new JComboBox();
		minutoFine.setModel(new DefaultComboBoxModel(minuti));
		minutoFine.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_3.add(minutoFine);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.SOUTH);
		
		
		giornateComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean checkBoxGiornate = giornateComplete.isSelected();			// contenuto checkbox
				
				if(checkBoxGiornate== true)									//disattivazione delle combobox per la checkbox
				{
					oraInizio.setEnabled(false);
					minutoInizio.setEnabled(false);
					oraFine.setEnabled(false);
					minutoFine.setEnabled(false);
					
				}else														//attivazione delle combobox per la checkbox
				{
					
					oraInizio.setEnabled(true);
					minutoInizio.setEnabled(true);
					oraFine.setEnabled(true);
					minutoFine.setEnabled(true);
					
				}
			}
		});

		
		
		
		
		
		JButton btnNewButton = new JButton("RICHIEDI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String matricola= campoMatricola.getText();
																					//	Contenuto combobox
				int index=motivazioni.getSelectedIndex();
				String motivazioneSelezionata = listaMotivazioni[index];
																					//	Contenuto chooseDate inizio e fine
				Date dataInseritaInizio = dataInizio.getDate();
				DateFormat cambioFormatoDataI = DateFormat.getDateInstance(DateFormat.SHORT);
				String dataI = cambioFormatoDataI.format(dataInseritaInizio);
				
				Date dataInseritaFine = dataFine.getDate();
				DateFormat cambioFormatoDataF = DateFormat.getDateInstance(DateFormat.SHORT);
				String dataF = cambioFormatoDataF.format(dataInseritaFine);	
				
				Boolean checkBoxGiornate = giornateComplete.isSelected();			// contenuto checkbox
				
				String oraI, oraF, minutoI, minutoF;
				
				if(checkBoxGiornate== true)									//disattivazione combobox --> valori predefiniti
				{
					oraI = "00";
					oraF = "23";
					minutoI = "00";
					minutoF = "59";
				}else														//attivazione delle combobox per la checkbox
				{
					oraI = ora[oraInizio.getSelectedIndex()];
					oraF = ora[oraFine.getSelectedIndex()];
					minutoI = minuti[minutoInizio.getSelectedIndex()];
					minutoF = minuti[minutoFine.getSelectedIndex()];
				}
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		panel_5.add(btnNewButton);
	}

	
}
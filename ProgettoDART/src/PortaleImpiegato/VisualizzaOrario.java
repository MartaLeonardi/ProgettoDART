package PortaleImpiegato;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JDayChooser;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JTextPane;

public class VisualizzaOrario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzaOrario frame = new VisualizzaOrario();
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
	public VisualizzaOrario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setExtendedState(JFrame.MAXIMIZED_BOTH);	
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel LogoImg = new JLabel("");
		LogoImg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		LogoImg.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgLogo = new ImageIcon (this.getClass().getResource("/logo.png")).getImage();
		LogoImg.setIcon(new ImageIcon(imgLogo));
		panel.add(LogoImg, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton IndietroButton = new JButton("INDIETRO");
		IndietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PortaleImpiegato portaleImpiegato = new PortaleImpiegato();
				portaleImpiegato.setVisible(true);

			}
		});
		IndietroButton.setHorizontalAlignment(SwingConstants.LEFT);
		IndietroButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_1.add(IndietroButton);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.EAST);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] {500, 0};
		gbl_panel_3.rowHeights = new int[] {40, 47, 430, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton selezioneButton = new JButton("Seleziona");

		selezioneButton.setHorizontalAlignment(SwingConstants.LEFT);
		selezioneButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.PAGE_START;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_3.add(selezioneButton, gbc_btnNewButton);
		
		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 1;
		panel_3.add(panel_8, gbc_panel_8);
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Data selezionata:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_8.add(lblNewLabel);
		
		JLabel DataSelezionata = new JLabel(" ");
		DataSelezionata.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_8.add(DataSelezionata);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 2;
		panel_3.add(panel_4, gbc_panel_4);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setBounds(5, 5, 5, 24);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_1);
		
		JTextPane textPane = new JTextPane();

		
		textPane.setEditable(false);
		textPane.setBounds(15, 7, 475, 433);
		panel_4.add(textPane);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("");
		
		JLabel label_1 = new JLabel("");
		
		JLabel label_2 = new JLabel("");
		
		JLabel label_3 = new JLabel("");
		
		JLabel label_4 = new JLabel("");
		
		JLabel label_5 = new JLabel("");
		
		JLabel label_6 = new JLabel("");
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.NORTH);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[] {335, 162, 220};
		gbl_panel_6.rowHeights = new int[] {30};
		gbl_panel_6.columnWeights = new double[]{1.0, 1.0, 0.0};
		gbl_panel_6.rowWeights = new double[]{1.0};
		panel_6.setLayout(gbl_panel_6);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.getComboBox().setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_monthChooser = new GridBagConstraints();
		gbc_monthChooser.anchor = GridBagConstraints.EAST;
		gbc_monthChooser.insets = new Insets(0, 0, 0, 5);
		gbc_monthChooser.fill = GridBagConstraints.VERTICAL;
		gbc_monthChooser.gridx = 0;
		gbc_monthChooser.gridy = 0;
		panel_6.add(monthChooser, gbc_monthChooser);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.getSpinner().setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_yearChooser = new GridBagConstraints();
		gbc_yearChooser.insets = new Insets(0, 0, 0, 5);
		gbc_yearChooser.fill = GridBagConstraints.BOTH;
		gbc_yearChooser.gridx = 1;
		gbc_yearChooser.gridy = 0;
		panel_6.add(yearChooser, gbc_yearChooser);
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7, BorderLayout.CENTER);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[] {90, 693, 90, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0};
		gbl_panel_7.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		JDayChooser dayChooser = new JDayChooser();
		GridBagConstraints gbc_dayChooser = new GridBagConstraints();
		gbc_dayChooser.insets = new Insets(0, 0, 0, 5);
		gbc_dayChooser.fill = GridBagConstraints.BOTH;
		gbc_dayChooser.gridx = 1;
		gbc_dayChooser.gridy = 0;
		panel_7.add(dayChooser, gbc_dayChooser);
		
		//------------------------------------------------------------------------EVENTO BOTTONE SELEZIONA
		selezioneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Integer giorno = dayChooser.getDay();
				Integer mese = monthChooser.getMonth()+1;
				Integer anno = yearChooser.getYear();
				
				String dataInserita;
				if(mese<=9)
				{
					if(giorno<9)
					{
						dataInserita = "0"+ giorno.toString()+"/0"+mese.toString() + "/" + anno.toString();
					}else {
					dataInserita = giorno.toString()+"/0"+mese.toString() + "/" + anno.toString();
					}
				}else
				{
					if(giorno<9)
					{
						dataInserita = "0"+ giorno.toString()+"/"+ mese.toString() + "/" + anno.toString();
					}else {
					dataInserita = giorno.toString()+"/"+mese.toString() + "/" + anno.toString();
					}
				}
				
				textPane.setText("INFO TURNO\n------------------------------------------\nData:       "+ dataInserita );
				DataSelezionata.setText(dataInserita);
				

			}
		});
	}
}

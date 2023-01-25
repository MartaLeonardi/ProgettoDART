package PortaleImpiegato;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import GestionePermessi.RichiediFerieControl;

public class RichiediFerie extends JPanel {

	/**
	 * Create the panel.
	 */
	public RichiediFerie() {
		setBounds(100, 100, 1280, 800);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		JLabel LogoImg = new JLabel("");
		Image imgLogo = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		LogoImg.setIcon(new ImageIcon(imgLogo));
		panel.add(LogoImg);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_1, BorderLayout.SOUTH);

		JButton IndietroButton = new JButton("INDIETRO");
		// -------------------------------------------------------------------------------------------------EVENTO
		// INDIETRO > PortaleImpiegato.java
		IndietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PortaleImpiegato.back();

			}
		});
		IndietroButton.setHorizontalAlignment(SwingConstants.LEFT);
		IndietroButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_1.add(IndietroButton);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		JLabel lblRichiestaFerie = new JLabel("RICHIESTA FERIE");
		lblRichiestaFerie.setHorizontalAlignment(SwingConstants.CENTER);
		lblRichiestaFerie.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel_2.add(lblRichiestaFerie, BorderLayout.NORTH);

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.CENTER);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 543, 678, 525, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, -16, 62, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JLabel lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 1;
		panel_3.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel ProvaInserimentoInizio = new JLabel(" ");
		ProvaInserimentoInizio.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_ProvaInserimentoInizio = new GridBagConstraints();
		gbc_ProvaInserimentoInizio.insets = new Insets(0, 0, 5, 5);
		gbc_ProvaInserimentoInizio.gridx = 2;
		gbc_ProvaInserimentoInizio.gridy = 3;
		panel_3.add(ProvaInserimentoInizio, gbc_ProvaInserimentoInizio);
				
						JLabel lblNewLabel_1 = new JLabel("Scegli il giorno di inizio ferie:");
						lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
						lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
						GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
						gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
						gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel_1.gridx = 1;
						gbc_lblNewLabel_1.gridy = 4;
						panel_3.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
				JDateChooser dataInizio = new JDateChooser();
				dataInizio.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 15));
				dataInizio.setDateFormatString("dd-MM-yyyy");
				GridBagConstraints gbc_dataInizio = new GridBagConstraints();
				gbc_dataInizio.fill = GridBagConstraints.BOTH;
				gbc_dataInizio.insets = new Insets(0, 0, 5, 5);
				gbc_dataInizio.gridx = 2;
				gbc_dataInizio.gridy = 4;
				panel_3.add(dataInizio, gbc_dataInizio);

		JLabel ProvaInserimentoFine = new JLabel(" ");
		ProvaInserimentoFine.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_ProvaInserimentoFine = new GridBagConstraints();
		gbc_ProvaInserimentoFine.insets = new Insets(0, 0, 5, 5);
		gbc_ProvaInserimentoFine.gridx = 2;
		gbc_ProvaInserimentoFine.gridy = 6;
		panel_3.add(ProvaInserimentoFine, gbc_ProvaInserimentoFine);

		JButton btnNewButton = new JButton("Richiedi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Date dataInseritaInizio = dataInizio.getDate();

				try {
					RichiediFerieControl.check(dataInseritaInizio);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 7;
		panel_3.add(btnNewButton, gbc_btnNewButton);
	}

}

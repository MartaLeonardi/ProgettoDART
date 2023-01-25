package RilevazionePresenza;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class RilevazionePresenza_HOME extends JFrame {

	private static JPanel contentPane;
	private static CardLayout crd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RilevazionePresenza_HOME frame = new RilevazionePresenza_HOME();
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
	public RilevazionePresenza_HOME() {
		crd = new CardLayout();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(crd);
		crd.first(contentPane);

		RilevazionePresenza_IN rilPresenzaIn = new RilevazionePresenza_IN();
		RilevazionePresenza_OUT rilPrensenzaOut = new RilevazionePresenza_OUT();

		JPanel panel = new JPanel();
		contentPane.add(panel, "RilevazionePresenzaHome");
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Rilevazione presenza");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		panel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 88, 463, 50, 474, 103, 0 };
		gbl_panel_1.rowHeights = new int[] { 482, 119, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JButton btnNewButton = new JButton("ENTRATA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// -------------------------------------------------------------------- EVENTO
				// BOTTONE ENTRATA -> porta al frame RivPre_IN
				crd.show(contentPane, "RilevazionePresenzaIN");
				// --------------------------------------------------------------------
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		btnNewButton.setBounds(10, 102, 470, 516);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		panel_1.add(btnNewButton, gbc_btnNewButton);

		JButton btnUscita = new JButton("USCITA");
		btnUscita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// -------------------------------------------------------------------- EVENTO
				// BOTTONE USCITA -> porta al frame RivPre_OUT
				crd.show(contentPane, "RilevazionePresenzaOUT");
				// --------------------------------------------------------------------
			}
		});
		btnUscita.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		btnUscita.setBounds(506, 102, 470, 516);
		GridBagConstraints gbc_btnUscita = new GridBagConstraints();
		gbc_btnUscita.insets = new Insets(0, 0, 5, 5);
		gbc_btnUscita.fill = GridBagConstraints.BOTH;
		gbc_btnUscita.gridx = 3;
		gbc_btnUscita.gridy = 0;
		panel_1.add(btnUscita, gbc_btnUscita);

		contentPane.add(panel, "RilevazionePresenzaHome");
		contentPane.add(rilPresenzaIn, "RilevazionePresenzaIN");
		contentPane.add(rilPrensenzaOut, "RilevazionePresenzaOUT");
	}

	public static void back() {
		crd.show(contentPane, "RilevazionePresenzaHome");
	}

}

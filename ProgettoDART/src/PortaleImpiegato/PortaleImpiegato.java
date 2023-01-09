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

public class PortaleImpiegato extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PortaleImpiegato frame = new PortaleImpiegato();
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
	public PortaleImpiegato() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1158, 751);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{254, 932, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("LOGOUT");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBackground(new Color(173, 216, 230));
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(175, 238, 238));
		panel.add(panel_2, BorderLayout.NORTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] {10, 102};
		gbl_panel_2.rowHeights = new int[] {130};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0};
		gbl_panel_2.rowWeights = new double[]{1.0};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel UserImg = new JLabel("");
		Image imgUser = new ImageIcon (this.getClass().getResource("/utenteRid100.png")).getImage();
		UserImg.setIcon(new ImageIcon(imgUser));
		
		
		
		
		
		
		
		
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_2.add(UserImg, gbc_lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(175, 238, 238));
		panel_3.setLayout(null);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 0;
		panel_2.add(panel_3, gbc_panel_3);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(0, 10, 66, 30);
		panel_3.add(lblNewLabel);
		
		JLabel lblCognome = new JLabel("Cognome:");
		lblCognome.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblCognome.setBounds(0, 50, 102, 30);
		panel_3.add(lblCognome);
		
		JLabel lblMatricola = new JLabel("Matricola:");
		lblMatricola.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblMatricola.setBounds(0, 90, 105, 30);
		panel_3.add(lblMatricola);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(175, 238, 238));
		panel.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JSeparator separator = new JSeparator();
		panel_4.add(separator, BorderLayout.NORTH);
	
		
		
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
	}
}

package PortaleImpiegato;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualizzaStipendio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzaStipendio frame = new VisualizzaStipendio();
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
	public VisualizzaStipendio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setExtendedState(JFrame.MAXIMIZED_BOTH);	
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel LogoImg = new JLabel("");
		LogoImg.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgLogo = new ImageIcon (this.getClass().getResource("/logo.png")).getImage();
		LogoImg.setIcon(new ImageIcon(imgLogo));
		contentPane.add(LogoImg, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
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
	}

}

package PortaleAmministratore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.LoginJFrame;
import NPorAmm.PAmm;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PopUpConfermaLogout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopUpConfermaLogout frame = new PopUpConfermaLogout();
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
	public PopUpConfermaLogout() {
		setTitle("D.A.R.T - PooUpConfermaLogout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel logoutLabel = new JLabel("Sicuro di voler uscire?");
		logoutLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel.add(logoutLabel);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JButton confermaButton = new JButton("Conferma");
		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginJFrame login = new LoginJFrame();
				login.setVisible(true);
				dispose();
			}
		});
		confermaButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_1.add(confermaButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PAmm portaleAmm = new PAmm();
				portaleAmm.setVisible(true);
				dispose();
			}
		});
		cancelButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_1.add(cancelButton);
	}

}

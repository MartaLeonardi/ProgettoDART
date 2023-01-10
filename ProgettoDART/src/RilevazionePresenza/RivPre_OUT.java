package RilevazionePresenza;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class RivPre_OUT extends JFrame {

	private JPanel FormOUT;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RivPre_OUT frame = new RivPre_OUT();
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
	public RivPre_OUT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		FormOUT = new JPanel();
		FormOUT.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(FormOUT);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USCITA");
		lblNewLabel.setBounds(0, 10, 986, 47);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 89, 966, 546);
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("NOME");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(45, 87, 177, 42);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("COGNOME");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(45, 179, 177, 42);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("MATRICOLA");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1_2.setBounds(45, 288, 177, 42);
		panel.add(lblNewLabel_1_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(275, 90, 478, 39);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(275, 182, 478, 39);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(275, 291, 478, 39);
		panel.add(textField_2);
		
		JButton btnNewButton = new JButton("INDIETRO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//--------------------------------------------------------------------		EVENTO BOTTONE INDIETRO -> torna al frame RivPre
				dispose();
				RivPre_HOME window = new RivPre_HOME();
				window.FirstFrame.setVisible(true);
				//--------------------------------------------------------------------
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(45, 469, 220, 70);
		panel.add(btnNewButton);
		
		JButton btnRileva = new JButton("RILEVA");
		btnRileva.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnRileva.setBounds(694, 469, 220, 70);
		panel.add(btnRileva);
	}

}

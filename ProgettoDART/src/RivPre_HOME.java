import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class RivPre_HOME {

	private JFrame frame;

	JFrame FirstFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RivPre_HOME window = new RivPre_HOME();
					window.FirstFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RivPre_HOME() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		FirstFrame = new JFrame();
		FirstFrame.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		FirstFrame.setTitle("Rilevazione Presenze");
		FirstFrame.setBounds(100, 100, 1000, 700);						//DIMENSIONI FINESTRA
		FirstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FirstFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rilevazione presenza");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 26, 966, 45);
		FirstFrame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ENTRATA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//--------------------------------------------------------------------		EVENTO BOTTONE ENTRATA -> porta al frame RivPre_IN
				FirstFrame.dispose();
				RivPre_IN RivPre_in = new RivPre_IN();
				RivPre_in.setVisible(true);
				//--------------------------------------------------------------------
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		btnNewButton.setBounds(10, 102, 470, 516);
		FirstFrame.getContentPane().add(btnNewButton);
		
		JButton btnUscita = new JButton("USCITA");
		btnUscita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//--------------------------------------------------------------------		EVENTO BOTTONE USCITA -> porta al frame RivPre_OUT
				FirstFrame.dispose();
				RivPre_OUT RivPre_out = new RivPre_OUT();
				RivPre_out.setVisible(true);
				//--------------------------------------------------------------------
			}
		});
		btnUscita.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		btnUscita.setBounds(506, 102, 470, 516);
		FirstFrame.getContentPane().add(btnUscita);
	}

}

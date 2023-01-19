package Login;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import BoundaryDBMS.DBMS;
import PopUp.OKPopUp;
import PortaleAmministratore.PortaleAmministratore;
import PortaleImpiegato.PortaleImpiegato;

public class LoginControl {
	
	public LoginControl(String matricola, String password) {			
		

		if(matricola.equals("") || password.length()==0) {
			System.out.println("Matricola e password vuoti");
			OKPopUp popup1 = new OKPopUp("Compilare entrambi i campi !");
			popup1.setVisible(true);
		}
		else {
			if(matricola.length()==5 && password.length()>1) {
				
					if(checkDatiDB(matricola, password)) {
					
						choosePortal(matricola);
						System.out.println("Accesso effettuato correttamente!");
						try {
							Utente utente = new Utente(matricola, password);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else {
						OKPopUp popup = new OKPopUp("Matricola e/o password non presente nel database !");
						popup.setVisible(true);
					}
					
			}
			else {
				OKPopUp popup = new OKPopUp("Formato matricola o password non valido");
				popup.setVisible(true);
			}
			
		}
		
}

/*
	public static boolean check(String matricola) {
		try {
		if(Integer.parseInt(matricola) > 0) {
			return true;
		}
		}
		catch(Exception e) {
			return false;
		}
		return false;
	}
*/	
	
	public static void choosePortal(String matricola) {
		if (matricola.equals(null)) {
			System.out.println("x");
		} else if (matricola.substring(0, 1).equals("0")) {
			PortaleImpiegato portaleImp = new PortaleImpiegato();
			portaleImp.setVisible(true);
			Login frame = Login.getInstance();
			frame.dispose();
		} else if (matricola.substring(0, 1).equals("1")) {
			PortaleAmministratore portaleAmm = new PortaleAmministratore();
			portaleAmm.setVisible(true);
			Login frame = Login.getInstance();
			frame.dispose();			
		}
	}
	
	//metodo che effettua una ricerca nel database per la matricola e la password inserita: restituisce vero se trovata, falso se non trovata
	public static boolean checkDatiDB (String matricola, String password) {
		
		DBMS database = new DBMS();
		
		String sql = "SELECT ref_t_matricola,password  FROM Autenticazione WHERE ref_t_matricola = '" + matricola + "' AND "
						+ " password ='" + password +"'" ;
	
		try {
			ResultSet rs=database.query(sql);
			rs.first();
			do {
				String row =rs.getString("ref_t_matricola") + "\n" + rs.getString("password");
				System.out.println("Credenziali trovate:\n" + row);
				database.closeConnection();
				return true;
			}while(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Fine controllo");
		database.closeConnection();
		System.out.println("Credenziali NON trovate");
		return false;
		
	}

	
}

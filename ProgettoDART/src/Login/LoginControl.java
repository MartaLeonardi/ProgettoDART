package Login;

import java.io.*;

import PortaleAmministratore.PortaleAmministratore;
import PortaleImpiegato.PortaleImpiegato;

public class LoginControl {
	
	private String matricola;
	private char[] password = null;


	public LoginControl(String matricola, char[] password) throws FileNotFoundException, IOException{
			this.matricola = matricola;
			this.password = null;
			
			if(check(this.matricola)) {
				
				//interrogazione al DBMS per controllare se i dati esistono
				
					//Se l'interrogazione da esito positivo
						//Interrogazione DBMS per prendere tutti i dati
						//Creazione oggetto (entity) utente con i dati ottenuti dal DBMS
				
				
				Utente utente = new Utente(this.matricola, this.password);
				
				choosePortal(this.matricola);
			}
			else {
				LoginJFrame login = new LoginJFrame();
				login.setVisible(true);
			}
	}
	
	
	
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
	
	
	public static void choosePortal(String matricola) {
		if (matricola.equals(null)) {
			System.out.println("x");
		} else if (matricola.substring(0, 1).equals("0")) {
			PortaleImpiegato portaleImp = new PortaleImpiegato();
			portaleImp.setVisible(true);
		} else if (matricola.substring(0, 1).equals("1")) {
			PortaleAmministratore portaleAmm = new PortaleAmministratore();
			portaleAmm.setVisible(true);
			
		}
	}
}

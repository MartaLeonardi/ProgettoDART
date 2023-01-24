package GestioneAccount;
import PopUp.OKPopUp;
import PopUp.OkCancelPopUp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import BoundaryDBMS.DBMS;
import Login.Utente;

public class modificaAccountControl {
	
	/*
	 * Controllo della stringa mail inserita
	 * pattern mail = Stringa dove sono concessi numeri e lettere(minuscole e maiuscole) + @ + dominio
	 * il dominio è composto da: stringa lettere e numeri + . + stringa sole lettere
	 * 
	 * il metodo restituisce un valore booleano true se la mail soddisfa tutti i requisiti del pattern
	 * false se non li soddisfa
	 */

	public boolean modificaPass(String oldPass, String newPass, String newPassConfirm) {
		if(!(newPass.equals(newPassConfirm))) {
			OKPopUp popUp = new OKPopUp("Nuova password e password di conferma sono diverse!");
			popUp.setVisible(true);
			return false;
		}
		if((oldPass.equals(newPass))) {
			OKPopUp popUp = new OKPopUp("La nuova e l'attuale password coincidono!");
			popUp.setVisible(true);
			return false;
		}
		Utente utente = Utente.getInstance();
		String matricola = utente.getMatricola();
		
		DBMS db = new DBMS();
		
		String sql = "select password from Autenticazione where ref_t_matricola = '"+matricola+"' and password = '"+oldPass+"'";
		
		ResultSet rs = db.query(sql);
		try {
			if(rs.next()) {
				db.updatePassword(matricola, newPass);			
				db.closeConnection();	
				return true;
			}
			else {
				OKPopUp popUp = new OKPopUp("La password attuale inserita non esiste!");
				popUp.setVisible(true);
				db.closeConnection();	
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	
	public boolean modificaEmail(String oldEmail, String newEmail, String newEmailConfirm) {
		
		if(!(newEmail.equals(newEmailConfirm))) {
			OKPopUp popUp = new OKPopUp("Nuova email ed email di conferma sono diverse!");
			popUp.setVisible(true);
			return false;
		}
		if((oldEmail.equals(newEmail))) {
			OKPopUp popUp = new OKPopUp("La nuova e l'attuale email coincidono!");
			popUp.setVisible(true);
			return false;
		}
		
		Utente utente = Utente.getInstance();
		String matricola = utente.getMatricola();
		
		DBMS db = new DBMS();
		
		String sql = "select email from Utente where u_matricola = '"+matricola+"' and email = '"+oldEmail+"'";
		
		ResultSet rs = db.query(sql);
		try {
			if(rs.next()) {
				db.updateEmail(matricola, newEmail);
				utente.setMail(newEmail);
				db.closeConnection();	
				return true;
			}
			else {
				OKPopUp popUp = new OKPopUp("L'email attuale inserita non esiste!");
				popUp.setVisible(true);
				db.closeConnection();	
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		db.closeConnection();	
		return false;
	}
	
	
	
	
	public static boolean checkMail (String email) {
		
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher(email);

		boolean matchFound = m.matches();

		StringTokenizer st = new StringTokenizer(email, ".");
		String lastToken = null;
		while (st.hasMoreTokens()) {
			lastToken = st.nextToken();
			}

		if (matchFound && lastToken.length() >= 2 && email.length() - 1 != lastToken.length()) {
			return true;
		}
		else
		{
			return false;
		}
}
	
	
}

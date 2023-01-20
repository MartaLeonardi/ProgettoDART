package GestionePersonale;

import java.sql.ResultSet;
import java.sql.SQLException;

import BoundaryDBMS.DBMS;
import PopUp.OKPopUp;

public class DelEmpControl {
	private String matricola;
	private String nome;
	private String cognome;
	
	
	public void eliminaImpiegato(String matricola, String nome, String cognome) {	
		if(checkMatricolaNomeCognome(matricola, nome, cognome)) {
			System.out.println("good");
			DBMS db = new DBMS();
			db.licenziaImpiegato(matricola);
			db.closeConnection();
			OKPopUp popUp = new OKPopUp("Impiegato licenziato");
			popUp.setVisible(true);
		}
		else {
			OKPopUp popUp = new OKPopUp("Impiegato non trovato");
			popUp.setVisible(true);
		}
	}
	
	public boolean checkMatricolaNomeCognome(String matricola, String nome, String cognome) {
			if(matricola.equals("") || nome.equals("") || cognome.equals("")) {
				return false;
			}
		
			if(!(Integer.parseInt(matricola) > 0)) {
				return false;
			}
			if(matricola.length() > 5 || matricola.length() < 5) {
				return false;
			}
			
			if (!(matricola.substring(0, 1).equals("0"))) {
				return false;
			}
			
			DBMS db = new DBMS();
			String sql = "select u_matricola from Utente where u_matricola = '" + matricola + "' && nome = '" + nome + "' && cognome = '" + cognome + "'";
			
			ResultSet rs = db.query(sql);
			try {
				if(rs.next()){
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		
		return false;
	}
	
	
}

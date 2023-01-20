package GestionePersonale;

import java.sql.ResultSet;
import java.sql.SQLException;

import BoundaryDBMS.DBMS;
import PopUp.OKPopUp;
import PopUp.PopUpSchedaImpiegato;

public class SchedaControl {
	
	public SchedaControl(String matricola, String nome, String cognome) {
		if(checkDB(matricola, nome, cognome)) {
			
			String nomeD = "";
			String cognomeD = "";
			String email = "";
			String ruolo = "";
			
			DBMS db = new DBMS();
			
			String sql = "select nome, cognome, email from Utente where u_matricola = '"+ matricola +"'";
			
			ResultSet rs = db.query(sql);
			try {
				while(rs.next()) {
				email = rs.getString(3);
				nomeD = rs.getString(1);
				cognomeD = rs.getString(2);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String sql2 = "select ruolo from Impiegato where i_matricola = '"+ matricola +"'";
			ResultSet rs2 = db.query(sql2);
			try {
				while(rs2.next()) {
				ruolo = rs2.getString(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.closeConnection();
			
			PopUpSchedaImpiegato visScheda = new PopUpSchedaImpiegato(matricola, nomeD, cognomeD, email, ruolo);
			visScheda.setVisible(true);
		}
		else {
			OKPopUp popUp = new OKPopUp("Impiegato non trovato");
			popUp.setVisible(true);
		}
	}
	
	public boolean checkDB(String matricola, String nome, String cognome) {
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

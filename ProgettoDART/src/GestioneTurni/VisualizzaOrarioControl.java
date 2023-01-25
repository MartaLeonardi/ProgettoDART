package GestioneTurni;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import BoundaryDBMS.DBMS;
import Login.Utente;

public class VisualizzaOrarioControl {
	
	public String getInfoOrario(LocalDate data) {
		String result = "";
		DBMS db = new DBMS();
		Utente utente = Utente.getInstance();
		String matricola = utente.getMatricola();
		
		String sql = "select inizio_turno, fine_turno, servizio from Turno where ref_i_matricola = '"+matricola+"' and giornata_lavoro = '"+Date.valueOf(data)+"'";
		ResultSet rs = db.query(sql);
		
		try {
			if(rs.next()) {
				result = "Inizio turno: "+rs.getString(1)+"\nFine turno: "+rs.getString(2) + "\nServizio: "+rs.getString(3)+"";
			}
			else {
				result = "Oggi non lavori!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		db.closeConnection();
		return result;
	}

}

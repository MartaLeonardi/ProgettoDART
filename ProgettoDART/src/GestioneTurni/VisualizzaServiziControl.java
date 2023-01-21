package GestioneTurni;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import BoundaryDBMS.DBMS;

public class VisualizzaServiziControl {
		
	public String[] getStato(String date, String servizio) {
		
		DBMS db = new DBMS();
		Boolean stato = false;
		String [] array = new String [3];
		int i = 0;
		String sql = "select presenza from Stato where giornata_lavoro = '"+ Date.valueOf(date) +"' and ref_servizio = '"+ servizio +"'";
		
		ResultSet rs = db.query(sql);
		try {
			rs.first();
			do {
				if(rs.getBoolean(1)) {
					array[i] = "Aperto";
					i++;
				}
				else {
					array[i] = "Chiuso";
					i++;
				}
			}while(rs.next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		db.closeConnection();
		return array;
		
	}
	
	public String getString(String[] array, int i) {
		return array[i];
	}
}

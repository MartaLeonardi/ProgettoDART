package GestioneTurni;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import BoundaryDBMS.DBMS;

public class VisualizzaServiziControl {
		
	public String[] getStato(String date, String servizio) {
		String[] serviceState = new String[3];
		
		
		DBMS db = new DBMS();
		
		System.out.println(date + servizio);
		
		String sql = "select count(*) from Turno where giornata_lavoro = '" + Date.valueOf(date) + "' AND servizio = '" + servizio + "' AND fascia_oraria = '0'";
		
		ResultSet rs = db.query(sql);
		
		try {
			if(rs.next()) {
				if(!(rs.getString(1).equals("1"))) {
					serviceState[0] = "Aperto";
				}
				else {
					serviceState[0] = "Chiuso";
				}				
			}
			else {
				serviceState[0] = "Chiuso";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql2 = "select count(*) from Turno where giornata_lavoro = '" + Date.valueOf(date) + "' AND servizio = '" + servizio + "' AND fascia_oraria = '1'";
		
		ResultSet rs2 = db.query(sql);
		
		try {
			if(rs2.next()) {
				if(!(rs2.getString(1).equals("1"))) {
					serviceState[1] = "Aperto";
				}
				else {
					serviceState[1] = "Chiuso";
				}			
			}
			else {
				serviceState[1] = "Chiuso";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql3 = "select count(*) from Turno where giornata_lavoro = '" + Date.valueOf(date) + "' AND servizio = '" + servizio + "' AND fascia_oraria = '2'";
		
		ResultSet rs3 = db.query(sql);
		
		try {
			if(rs3.next()) {
				if(!(rs3.getString(1).equals("1"))) {
					serviceState[2] = "Aperto";
				}
				else {
					serviceState[2] = "Chiuso";
				}			
			}
			else {
				serviceState[2] = "Chiuso";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		db.closeConnection();
		return serviceState;
	}
}

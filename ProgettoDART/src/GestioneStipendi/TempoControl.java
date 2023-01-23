package GestioneStipendi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import BoundaryDBMS.DBMS;

public class TempoControl {
		
	public void calcoloStipendio() throws SQLException {
		
		ArrayList<Impiegati> impiegati = new ArrayList<>();
		
		DBMS db = new DBMS();
		
		String sql = "Select i_matricola, ruolo, oreLavorate, oreStraordinarie, oreFestive FROM Impiegato";
		
		ResultSet rs = db.query(sql);
		
		
		while(rs.next()) {
			Impiegati i = new Impiegati(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
			impiegati.add(i);
		}
		
		for (Impiegati i : impiegati) {
		      System.out.println(i);
		    }
		
		
		ArrayList<Stipendi> stipendi = new ArrayList<>();
		
		for(Impiegati i : impiegati) {
			String m = i.getMatricola();
			int oreL = i.getOreLavorate();
			int oreS = i.getOreStraordinarie();
			int oreF = i.getOreFestive();
			
			int stipendio = 0;
			if(i.getRuolo().equals("Ruolo 1")) {
				stipendio = 250 + (oreL*12) + oreS*(12+4) + oreF*(12+3);
			}
			if(i.getRuolo().equals("Ruolo 2")) {
				stipendio = 200 + (oreL*10) + oreS*(10+4) + oreF*(10+3);
			}
			if(i.getRuolo().equals("Ruolo 3")) {
				stipendio = 150 + (oreL*9) + oreS*(9+4) + oreF*(9+3);
			}
			if(i.getRuolo().equals("Ruolo 4")) {
				stipendio = 100 + (oreL*8) + oreS*(8+4) + oreF*(8+3);
			}
			
			Date date = new Date();
						 
		    String pattern = "yyyy-MM-dd";
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		    String d = simpleDateFormat.format(date); 
		    
			stipendi.add(new Stipendi(m, d, stipendio));			
		}
		
		for (Stipendi i : stipendi) {
		      System.out.println(i);
		    }
		
		for(Stipendi i : stipendi) {			
			db.insertStipendi(i.getMatricola(), i.getData(), i.getValore());		
		}
		
		for(Impiegati i : impiegati) {
			db.updateOreStipendi(i.getMatricola());
		}
		
		LocalDate dInizio = LocalDate.now();
		dInizio = dInizio.minusDays(1);
		
		db.removeTurni(dInizio.toString());
	
		db.closeConnection();
		
		//StipendioBase + OreLavorate*PagaOraria + oreStraordinarie*(PagaOraria+4) + oreFestive*(PagaOraria+3)
		
	}
	
	
	public void calcoloStatoServizi(LocalDate dataInizio, LocalDate dataFine) {
		
		LocalDate dInizio = dataInizio;
		LocalDate dFine = dataFine;
		
		DBMS db = new DBMS();
		
		
		LocalDate d;
		for(d = dInizio;  d.isBefore(dFine.plusDays(1));  d = d.plusDays(1)) {
			for(int i = 0; i < 3; i++) {
			String sql = "select count(*) from Turno where giornata_lavoro = '" + d + "' and servizio = 'Servizio 1' and fascia_oraria = '"+ i +"'";
			
			System.out.println("test");
			System.out.println(d);
			
			ResultSet rs = db.query(sql);
			
			try {
				if(rs.next()) {
					if(rs.getInt(1) >= 1) {
						db.setStato(d, "Servizio 1", i, true);
					}
					else {
						db.setStato(d, "Servizio 1", i, false);
					}
				}
				else {
					db.setStato(d, "Servizio 1", i, false);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			}
		}
		
		
		
		for( d = dInizio;  d.isBefore(dataFine.plusDays(1)); d = d.plusDays(1)) {
			for(int i = 0; i < 3; i++) {
			String sql = "select count(*) from Turno where giornata_lavoro = '" + d + "' and servizio = 'Servizio 2' and fascia_oraria = '"+ i +"'";
			
			ResultSet rs = db.query(sql);
			
			try {
				if(rs.next()) {
					if(rs.getInt(1) >= 1) {
						db.setStato(d, "Servizio 2", i, true);
					}
					else {
						db.setStato(d, "Servizio 2", i, false);
					}
				}
				else {
					db.setStato(d, "Servizio 2", i, false);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			}
		}
		
		
		
		for( d = dInizio;  d.isBefore(dataFine.plusDays(1)); d = d.plusDays(1)) {
			for(int i = 0; i < 3; i++) {
			String sql = "select count(*) from Turno where giornata_lavoro = '" + d + "' and servizio = 'Servizio 3' and fascia_oraria = '"+ i +"'";
			
			ResultSet rs = db.query(sql);
			
			try {
				if(rs.next()) {
					if(rs.getInt(1) >= 1) {
						db.setStato(d, "Servizio 3", i, true);
					}
					else {
						db.setStato(d, "Servizio 3", i, false);
					}
				}
				else {
					db.setStato(d, "Servizio 3", i, false);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			}
		}
		
		
		for( d = dInizio;  d.isBefore(dataFine.plusDays(1));  d = d.plusDays(1)) {
			for(int i = 0; i < 3; i++) {
			String sql = "select count(*) from Turno where giornata_lavoro = '" + d + "' and servizio = 'Servizio 4' and fascia_oraria = '"+ i +"'";
			
			ResultSet rs = db.query(sql);
			
			System.out.println("testtttt");
			try {
				if(rs.next()) {
					if(rs.getInt(1) >= 1) {
						db.setStato(d, "Servizio 4", i, true);
					}
					else {
						db.setStato(d, "Servizio 4", i, false);
					}
				}
				else {
					db.setStato(d, "Servizio 4", i, false);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			}
		}
		db.closeConnection();
	}
	
	
}

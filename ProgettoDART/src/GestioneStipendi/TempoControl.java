package GestioneStipendi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
		
		db.closeConnection();
		
		//StipendioBase + OreLavorate*PagaOraria + oreStraordinarie*(PagaOraria+4) + oreFestive*(PagaOraria+3)
		
	}
	
}

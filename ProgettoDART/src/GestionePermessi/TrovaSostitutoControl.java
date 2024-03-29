package GestionePermessi;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import BoundaryDBMS.DBMS;

public class TrovaSostitutoControl {

	public boolean cercaSostituto(int fascia, LocalDate d, String servizio) {
		String[] oraInizio = {"00:00:00", "08:00:00", "16:00:00"};
		String[] oraFine = {"08:00:00", "16:00:00", "24:00:00"};
		DBMS dbms = new DBMS();
		ArrayList<String> matricole;
		ArrayList<String> matricoleDaDeletare = null;
		matricole = dbms.retriveImpiegato();
		//Controllo dei permessi
		matricoleDaDeletare = dbms.retriveImpiegatoFromRichiestaForGiorno(d);
		for(int i = 0; i < matricoleDaDeletare.size(); i++) {
			for(int y = 0; y < matricole.size(); y++) {
				if(matricole.get(y).equals(matricoleDaDeletare.get(i))) {
					matricole.remove(y);
					break;
				}
			}
		}
		//Controllo dei turni
		// Ore 16-24
		if(fascia==0) {
			matricoleDaDeletare = dbms.retriveImpiegatoForTurno(d);
			//Oggi
			for(int i = 0; i < matricoleDaDeletare.size(); i++) {
				for(int y = 0; y < matricole.size(); y++) {
					if(matricole.get(y).equals(matricoleDaDeletare.get(i))) {
						matricole.remove(y);
						break;
					}
				}
			}
			//Domani
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.plusDays(1), fascia);
			for(int i = 0; i < matricoleDaDeletare.size(); i++) {
				for(int y = 0; y < matricole.size(); y++) {
					if(matricole.get(y).equals(matricoleDaDeletare.get(i))) {
						matricole.remove(y);
						break;
					}
				}
			}
			//Ieri
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.minusDays(1), fascia+1);
			for(int i = 0; i < matricoleDaDeletare.size(); i++) {
				for(int y = 0; y < matricole.size(); y++) {
					if(matricole.get(y).equals(matricoleDaDeletare.get(i))) {
						matricole.remove(y);
						break;
					}
				}
			}
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.minusDays(1), fascia+2);
			for(int i = 0; i < matricoleDaDeletare.size(); i++) {
				for(int y = 0; y < matricole.size(); y++) {
					if(matricole.get(y).equals(matricoleDaDeletare.get(i))) {
						matricole.remove(y);
						break;
					}
				}
			}
		}
		// Ore 8-16
		if(fascia==1) {
			matricoleDaDeletare = dbms.retriveImpiegatoForTurno(d);
			//Oggi
			for(int i = 0; i < matricoleDaDeletare.size(); i++) {
				for(int y = 0; y < matricole.size(); y++) {
					if(matricole.get(y).equals(matricoleDaDeletare.get(i))) {
						matricole.remove(y);
						break;
					}
				}
			}
			//Domani
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.plusDays(1), fascia);
			for(int i = 0; i < matricoleDaDeletare.size(); i++) {
				for(int y = 0; y < matricole.size(); y++) {
					if(matricole.get(y).equals(matricoleDaDeletare.get(i))) {
						matricole.remove(y);
						break;
					}
				}
			}
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.plusDays(1), fascia-1);
			for(int i = 0; i < matricoleDaDeletare.size(); i++) {
				for(int y = 0; y < matricole.size(); y++) {
					if(matricole.get(y).equals(matricoleDaDeletare.get(i))) {
						matricole.remove(y);
						break;
					}
				}
			}
			//Ieri
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.minusDays(1), fascia+1);
			for(int i = 0; i < matricoleDaDeletare.size(); i++) {
				for(int y = 0; y < matricole.size(); y++) {
					if(matricole.get(y).equals(matricoleDaDeletare.get(i))) {
						matricole.remove(y);
						break;
					}
				}
			}
		}		
		// Ore 16-24
		if(fascia==2) {
			matricoleDaDeletare = dbms.retriveImpiegatoForTurno(d);
			//Oggi
			for(int i = 0; i < matricoleDaDeletare.size(); i++) {
				for(int y = 0; y < matricole.size(); y++) {
					if(matricole.get(y).equals(matricoleDaDeletare.get(i))) {
						matricole.remove(y);
						break;
					}
				}
			}
			//Domani
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.plusDays(1), fascia);
			for(int i = 0; i < matricoleDaDeletare.size(); i++) {
				for(int y = 0; y < matricole.size(); y++) {
					if(matricole.get(y).equals(matricoleDaDeletare.get(i))) {
						matricole.remove(y);
						break;
					}
				}
			}
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.plusDays(1), fascia-1);
			for(int i = 0; i < matricoleDaDeletare.size(); i++) {
				for(int y = 0; y < matricole.size(); y++) {
					if(matricole.get(y).equals(matricoleDaDeletare.get(i))) {
						matricole.remove(y);
						break;
					}
				}
			}
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.plusDays(1), fascia-2);
			for(int i = 0; i < matricoleDaDeletare.size(); i++) {
				for(int y = 0; y < matricole.size(); y++) {
					if(matricole.get(y).equals(matricoleDaDeletare.get(i))) {
						matricole.remove(y);
						break;
					}
				}
			}
			//Ieri
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.minusDays(1), fascia);
			for(int i = 0; i < matricoleDaDeletare.size(); i++) {
				for(int y = 0; y < matricole.size(); y++) {
					if(matricole.get(y).equals(matricoleDaDeletare.get(i))) {
						matricole.remove(y);
						break;
					}
				}
			}
		}
		System.out.println(matricole);
		Iterator<String> mtr = matricole.iterator();
		if(mtr.hasNext()) {
			String a = mtr.next();
			System.out.println("Matricola inserita: "+a);
			dbms.insertTurno(a, d.toString(), oraInizio[fascia], oraFine[fascia], fascia, servizio);
			System.out.println("Impiegato sostituito");
			dbms.closeConnection();
			return true;
		} else {
			System.out.println("Impiegato idoneo non trovato");
			dbms.closeConnection();
			return false;
		}
	}
	
	public static void cercaSostitutoPerOreStraordinarie(int fascia, LocalDate d, String servizio, String oraInizio, String oraFine, int mod) throws SQLException {
		String[] turnoInizio = {"00:00:00", "08:00:00", "16:00:00"};
		String[] turnoFine = {"08:00:00", "16:00:00", "00:00:00"};
		DBMS dbms = new DBMS();
		String sql=null;
		ResultSet result;
		ArrayList<String> matricole = new ArrayList<String>();
		System.out.println("Fine turno arriva: "+oraFine);
		System.out.println("Inizio turno arriva : "+oraInizio);
		System.out.println("Verififca Modalita: "+mod);
		//Controllo dei turni
		if(mod==1) {
			if(fascia==0) {
				sql = "SELECT ref_i_matricola FROM Turno WHERE servizio = '"+servizio+"' AND giornata_lavoro = '"+d.minusDays(1).toString()+"' AND fascia_oraria = "+2;
				result = dbms.query(sql);
				while(result.next()) {
					matricole.add(result.getString("ref_i_matricola"));
				}
				if(!matricole.isEmpty()) {
					dbms.insertTurno(matricole.get(0), d.toString(), turnoInizio[0], oraFine+":00:00", fascia, servizio);
					dbms.updateTurnoPresenzaEntrata(d, matricole.get(0));	
				}			
			}
			if(fascia==1) {
				sql = "SELECT ref_i_matricola FROM Turno WHERE servizio = '"+servizio+"' AND giornata_lavoro = '"+d.toString()+"' AND fascia_oraria = "+0;
				result = dbms.query(sql);
				while(result.next()) {
					matricole.add(result.getString("ref_i_matricola"));
				}
				if(!matricole.isEmpty())
					dbms.updateTurnoFine(d, matricole.get(0), oraFine);
			}
			if(fascia==2) {
				sql = "SELECT ref_i_matricola FROM Turno WHERE servizio = '"+servizio+"' AND giornata_lavoro = '"+d.toString()+"' AND fascia_oraria = "+1;
				result = dbms.query(sql);
				while(result.next()) {
					matricole.add(result.getString("ref_i_matricola"));
				}
				if(!matricole.isEmpty())
					dbms.updateTurnoFine(d, matricole.get(0), oraFine);
			}
			System.out.println("Sostituito");
		}
		if(mod==0) {
			if(fascia==0) {
				sql = "SELECT ref_i_matricola FROM Turno WHERE servizio = '"+servizio+"' AND giornata_lavoro = '"+d.toString()+"' AND fascia_oraria = "+1;
				result = dbms.query(sql);
				while(result.next()) {
					matricole.add(result.getString("ref_i_matricola"));
				}
				if(!matricole.isEmpty())
					dbms.updateTurnoInizio(d, matricole.get(0), oraInizio);		
			}
			if(fascia==1) {
				sql = "SELECT ref_i_matricola FROM Turno WHERE servizio = '"+servizio+"' AND giornata_lavoro = '"+d.toString()+"' AND fascia_oraria = "+2;
				result = dbms.query(sql);
				while(result.next()) {
					matricole.add(result.getString("ref_i_matricola"));
				}
				if(!matricole.isEmpty())
					dbms.updateTurnoInizio(d, matricole.get(0), oraInizio);
			}
			if(fascia==2) {
				sql = "SELECT ref_i_matricola FROM Turno WHERE servizio = '"+servizio+"' AND giornata_lavoro = '"+d.plusDays(1).toString()+"' AND fascia_oraria = "+0;
				result = dbms.query(sql);
				while(result.next()) {
					matricole.add(result.getString("ref_i_matricola"));
				}
				if(!matricole.isEmpty()) {
					dbms.insertTurno(matricole.get(0), d.toString(), oraInizio+":00:00", turnoFine[2], fascia, servizio);
					dbms.updateTurnoPresenzaEntrata(d.plusDays(1), matricole.get(0));	
				}
			}
			System.out.println("Sostituito");
		}
		dbms.closeConnection();
	}
}

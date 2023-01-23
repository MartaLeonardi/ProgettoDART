package GestionePermessi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import BoundaryDBMS.DBMS;

public class TrovaSostitutoControl {

	public void cercaSostituto(int fascia, LocalDate d, String servizio) {
		String[] oraInizio = {"00:00:00", "08:00:00", "16:00:00"};
		String[] oraFine = {"08:00:00", "16:00:00", "24:00:00"};
		DBMS dbms = new DBMS();
		ArrayList<String> matricole;
		ArrayList<String> matricoleDaDeletare = null;
		matricole = dbms.retriveImpiegato();
		//Controllo dei permessi
		matricoleDaDeletare = dbms.retriveImpiegatoFromRichiestaForGiorno(d);
		for(int i = 0; i < matricole.size(); i++) {
			for(int y = 0; y < matricoleDaDeletare.size(); y++) {
				if(matricole.get(i).equals(matricoleDaDeletare.get(y))) {
					matricole.remove(i);
				}
			}
		}
		//Controllo dei turni
		// Ore 16-24
		if(fascia==0) {
			matricoleDaDeletare = dbms.retriveImpiegatoForTurno(d);
			//Oggi
			for(int i = 0; i < matricole.size(); i++) {
				for(int y = 0; y < matricoleDaDeletare.size(); y++) {
					if(matricole.get(i).equals(matricoleDaDeletare.get(y))) {
						matricole.remove(i);
					}
				}
			}
			//Domani
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.plusDays(1), fascia);
			for(int i = 0; i < matricole.size(); i++) {
				for(int y = 0; y < matricoleDaDeletare.size(); y++) {
					if(matricole.get(i).equals(matricoleDaDeletare.get(y))) {
						matricole.remove(i);
					}
				}
			}
			//Ieri
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.minusDays(1), fascia);
			for(int i = 0; i < matricole.size(); i++) {
				for(int y = 0; y < matricoleDaDeletare.size(); y++) {
					if(matricole.get(i).equals(matricoleDaDeletare.get(y))) {
						matricole.remove(i);
					}
				}
			}
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.minusDays(1), fascia+1);
			for(int i = 0; i < matricole.size(); i++) {
				for(int y = 0; y < matricoleDaDeletare.size(); y++) {
					if(matricole.get(i).equals(matricoleDaDeletare.get(y))) {
						matricole.remove(i);
					}
				}
			}
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.minusDays(1), fascia+2);
			for(int i = 0; i < matricole.size(); i++) {
				for(int y = 0; y < matricoleDaDeletare.size(); y++) {
					if(matricole.get(i).equals(matricoleDaDeletare.get(y))) {
						matricole.remove(i);
					}
				}
			}
		}
		// Ore 8-16
		if(fascia==1) {
			matricoleDaDeletare = dbms.retriveImpiegatoForTurno(d);
			//Oggi
			for(int i = 0; i < matricole.size(); i++) {
				for(int y = 0; y < matricoleDaDeletare.size(); y++) {
					if(matricole.get(i).equals(matricoleDaDeletare.get(y))) {
						matricole.remove(i);
					}
				}
			}
			//Domani
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.plusDays(1), fascia);
			for(int i = 0; i < matricole.size(); i++) {
				for(int y = 0; y < matricoleDaDeletare.size(); y++) {
					if(matricole.get(i).equals(matricoleDaDeletare.get(y))) {
						matricole.remove(i);
					}
				}
			}
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.plusDays(1), fascia-1);
			for(int i = 0; i < matricole.size(); i++) {
				for(int y = 0; y < matricoleDaDeletare.size(); y++) {
					if(matricole.get(i).equals(matricoleDaDeletare.get(y))) {
						matricole.remove(i);
					}
				}
			}
			//Ieri
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.minusDays(1), fascia);
			for(int i = 0; i < matricole.size(); i++) {
				for(int y = 0; y < matricoleDaDeletare.size(); y++) {
					if(matricole.get(i).equals(matricoleDaDeletare.get(y))) {
						matricole.remove(i);
					}
				}
			}
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.minusDays(1), fascia+1);
			for(int i = 0; i < matricole.size(); i++) {
				for(int y = 0; y < matricoleDaDeletare.size(); y++) {
					if(matricole.get(i).equals(matricoleDaDeletare.get(y))) {
						matricole.remove(i);
					}
				}
			}
		}		
		// Ore 16-24
		if(fascia==2) {
			matricoleDaDeletare = dbms.retriveImpiegatoForTurno(d);
			//Oggi
			for(int i = 0; i < matricole.size(); i++) {
				for(int y = 0; y < matricoleDaDeletare.size(); y++) {
					if(matricole.get(i).equals(matricoleDaDeletare.get(y))) {
						matricole.remove(i);
					}
				}
			}
			//Domani
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.plusDays(1), fascia);
			for(int i = 0; i < matricole.size(); i++) {
				for(int y = 0; y < matricoleDaDeletare.size(); y++) {
					if(matricole.get(i).equals(matricoleDaDeletare.get(y))) {
						matricole.remove(i);
					}
				}
			}
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.plusDays(1), fascia-1);
			for(int i = 0; i < matricole.size(); i++) {
				for(int y = 0; y < matricoleDaDeletare.size(); y++) {
					if(matricole.get(i).equals(matricoleDaDeletare.get(y))) {
						matricole.remove(i);
					}
				}
			}
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.plusDays(1), fascia-2);
			for(int i = 0; i < matricole.size(); i++) {
				for(int y = 0; y < matricoleDaDeletare.size(); y++) {
					if(matricole.get(i).equals(matricoleDaDeletare.get(y))) {
						matricole.remove(i);
					}
				}
			}
			//Ieri
			matricoleDaDeletare = dbms.retriveImpiegatoForTurnoForFascia(d.minusDays(1), fascia);
			for(int i = 0; i < matricole.size(); i++) {
				for(int y = 0; y < matricoleDaDeletare.size(); y++) {
					if(matricole.get(i).equals(matricoleDaDeletare.get(y))) {
						matricole.remove(i);
					}
				}
			}
		}
		Iterator<String> mtr = matricole.iterator();
		if(mtr.hasNext()) {
			dbms.insertTurno(mtr.next(), d.toString(), oraInizio[fascia], oraFine[fascia], fascia, servizio);
			System.out.println("Impiegato sostituito");
		} else System.out.println("Impiegato idoneo non trovato");
		dbms.closeConnection();
	}
	
}

package GestioneStipendi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

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
	
	public void calcoloCalendario(LocalDate startDate, LocalDate endDate) throws SQLException {
		//Local variables and objects
		DBMS dbms = new DBMS();
		ArrayList<Impiegati> impiegatiRuolo; //ArrayList utilizzato per copiare il retrive degli impiegati da iterare
		Iterator<Impiegati> tempImp; //Iteratore temporaneo a cui assegnare gli oggetti impiegato da esaminare
		Impiegati imp; //Oggetto utilizzato come riferimento temporaneo all'impiegato da assegnare
		String oraInizio = null; //Stringa per indicare l'ora di inizio turno
		String oraFine = null; //Stringa per indicare l'ora di fine turno
		Impiegati[] emps = new Impiegati[6]; //Array utilizzato per scorrere i turni
		//Controlli sul tempo
		if(!(startDate.getDayOfMonth()==25)) {
			System.out.println("Niente query! Non e' il giorno giusto");
			return;
		}
		for(int test=1; test<=10;test=test+3) {
			System.out.println(test);
			if(startDate.getMonthValue()==test) {
				break;
			}
			if(test==10) {
				System.out.println("Niente query! Non e' il mese giusto");
				return;
			}
		}
		for(int i = 1; i<=4; i++) {
			String ruolo = "Ruolo " + i; //Utilizzato per recuperare gli impiegati di un certo ruolo
			String servizio = "Servizio " + i; //Utilizzato per assegnare il servizio di lavoro
			impiegatiRuolo = dbms.retriveImpiegatoByRole(ruolo); //Recupero degli impiegati di ruolo 
			tempImp = impiegatiRuolo.iterator(); //Restituzione dell'oggetto iteratore Impiegato
			for(LocalDate d = startDate.plusDays(1); d.isBefore(endDate); d = d.plusDays(1)) {
				for(int nFascia = 0; nFascia < 3; nFascia++) {
					int nImpiegati = 0; //Contatore che effettua il conteggio di impiegati attualmente assegnati alla fascia oraria
					if(nFascia == 0) {oraInizio = "00:00:00"; oraFine = "08:00:00";}
					if(nFascia == 1) {oraInizio = "08:00:00"; oraFine = "16:00:00";}
					if(nFascia == 2) {oraInizio = "16:00:00"; oraFine = "24:00:00";}
					while(nImpiegati<2) {
						int countTry = 0; //Contatore che effettua il conteggio di tentativi per l'assegnazione dei turni
						while(countTry<10) {
							if(!(tempImp.hasNext())) {
								tempImp = impiegatiRuolo.iterator();
							}
							//Controlla se nell'oggetto Iterator ci sono ancora record
							if(tempImp.hasNext()) {
								imp = tempImp.next(); //Assegno l'impiegato da inserire a un oggetto per le verifiche dei criteri di assegnazione
								if(emps[nFascia]==null || emps[nFascia+3]==null) {
									emps[nFascia] = imp;
									dbms.insertTurno(imp.getMatricola(), d.toString(), oraInizio, oraFine, nFascia, servizio);
									nImpiegati++;
									break;
								}
								//Controlla se l'impiegato in analisi ha gia' lavorato per la stessa fascia oraria il giorno prima
								else if(imp.getMatricola()!=emps[nFascia].getMatricola() && imp.getMatricola()!=emps[nFascia+3].getMatricola()) {
									//Cotrollo ulteriore per chi verra' assegnato al turno di mattina
									if(nFascia == 0) {
										//Cotrolla se l-impiegato ha lavorato di notte il giorno prima
										if(imp.getMatricola()!=emps[3].getMatricola() && imp.getMatricola()!=emps[6].getMatricola()) {
											//Assegnazione del turno di lavoro
											emps[nFascia+nImpiegati*3] = imp;
											dbms.insertTurno(imp.getMatricola(), d.toString(), oraInizio, oraFine, nFascia, servizio);
											nImpiegati++;
											break;
										}
									}
									//Assegnazione del turno di lavoro
									else {
										emps[nFascia+nImpiegati*3] = imp;
										dbms.insertTurno(imp.getMatricola(), d.toString(), oraInizio, oraFine, nFascia, servizio);
										nImpiegati++;
										break;
									}
								}
							}
							countTry++;
						}
					}
				}
			}
		}
		dbms.closeConnection();
		calcoloStatoServizi(startDate, startDate.plusMonths(3));
	}
}
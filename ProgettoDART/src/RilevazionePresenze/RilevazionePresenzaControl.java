package RilevazionePresenze;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import BoundaryDBMS.DBMS;
import PopUp.OKPopUp;

public class RilevazionePresenzaControl {
	LocalDateTime iT;
	LocalDateTime fT;
	Time inizio_turno;
	Time fine_turno;
	int fascia;
	
	public boolean checkDati(String matricola, String nome, String cognome) {
		
		if(matricola.equals("") || nome.equals("") || cognome.equals("")) {
			OKPopUp popUp = new OKPopUp("Compilare tutti i campi!");
			popUp.setVisible(true);			
			return false;
		}
		if(!(matricola.substring(0, 1).equals("0"))) {
			OKPopUp popUp = new OKPopUp("Inserire matricola impiegato");
			popUp.setVisible(true);	
			return false;
		}
		
		DBMS db = new DBMS();
		
		String sql = "select u_matricola from Utente where u_matricola = '"+matricola+"' and nome = '"+nome+"' and cognome = '"+cognome+"' ";
		
		ResultSet rs = db.query(sql);
		
		try {
			if(rs.next()) {
				db.closeConnection();				
				return true;
			}
			else {
				OKPopUp popUp = new OKPopUp("Dati inseriti errati!");
				popUp.setVisible(true);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			db.closeConnection();
			return false;
		}
		
		
		db.closeConnection();
		return false;
	}
	
	public boolean checkPresenzaIn(String matricola) {
		
		DBMS datab = new DBMS();
		LocalDate d = LocalDate.now();
		
		System.out.println(d);
		
		String sql = "select inizio_turno, fine_turno, fascia_oraria, entrata from Turno where ref_i_matricola = '"+matricola+"' and giornata_lavoro = '"+d+"' ";	
		ResultSet rs = datab.query(sql);
		
		try {
			if(rs.next()) {
				
				if(rs.getBoolean(4)) {
					OKPopUp popUp = new OKPopUp("Presenza gia' rilevata!");
					popUp.setVisible(true);
					datab.closeConnection();
					return false;
				}
				
		        LocalTime t1;
				inizio_turno = rs.getTime(1);
				fine_turno = rs.getTime(2);
				fascia = rs.getInt(3);
				
				t1 = LocalTime.parse(inizio_turno.toString());
				//LocalTime actualTime =  LocalTime.now();  //PRENDE IL TEMPO ATTUALE
				LocalTime actualTime = LocalTime.now(); //TEMPO DI TESTING
				if((actualTime.isAfter(t1) || actualTime.equals(t1)) && (actualTime.isBefore(t1.plusMinutes(14)) || actualTime.equals(t1.plusMinutes(14)))) {
					System.out.println("VERO");
					
					datab.closeConnection();
					return true;
				}
				else {
					
					datab.insertRitardo(matricola, d.toString());
					
					
					OKPopUp popUp = new OKPopUp("Sei in ritardo! Rileva alla postazione");
					popUp.setVisible(true);
					//InserireRitardoDBMS	
				}
				
				System.out.println(t1);
				
				datab.closeConnection();
				return false;				
			}
			else {
				OKPopUp popUP = new OKPopUp("Oggi non sei in turno!");
				popUP.setVisible(true);
				datab.closeConnection();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		datab.closeConnection();		
		return false;
	}
	
	public void updateEntrata(String matricola) {
		LocalDate now = LocalDate.now();
		
		DBMS db = new DBMS();
		db.updateEntrata(matricola, now.toString());
		db.closeConnection();
		
		OKPopUp popUp = new OKPopUp("Presenza rilevata correttamente");
		popUp.setVisible(true);

	}
	
	public boolean checkPresenzaOut(String matricola) {
		DBMS datab = new DBMS();
		LocalDate d = LocalDate.now();
		
		System.out.println(d);
		
		String sql = "select inizio_turno, fine_turno, fascia_oraria, uscita, entrata from Turno where ref_i_matricola = '"+matricola+"' and giornata_lavoro = '"+d+"' ";	
		ResultSet rs = datab.query(sql);
		
		try {
			if(rs.next()) {
				if(!(rs.getBoolean(5))) {
					OKPopUp popUp = new OKPopUp("Presenza in ingresso non rilevata!");
					popUp.setVisible(true);
					
					datab.closeConnection();
					return false;
				}
				if(rs.getBoolean(4)) {
					OKPopUp popUp = new OKPopUp("Uscita gia' rilevata!");
					popUp.setVisible(true);
					
					datab.closeConnection();
					return false;
				}
				
		        LocalTime t1;
				inizio_turno = rs.getTime(1);
				fine_turno = rs.getTime(2);
				fascia = rs.getInt(3);
				
				t1 = LocalTime.parse(fine_turno.toString());
				LocalTime actualTime =  LocalTime.now();  //PRENDE IL TEMPO ATTUALE
				//LocalTime actualTime = LocalTime.of(8, 01); //TEMPO SETTATO PER TESTING
				if((actualTime.isAfter(t1) || actualTime.equals(t1)) && (actualTime.isBefore(t1.plusMinutes(14)) || actualTime.equals(t1.plusMinutes(14)))) {
					System.out.println("VERO");
					
					updateUscita(matricola);
					conteggioOre(matricola);
					
					datab.closeConnection();
					return true;
				}			
				else {
				OKPopUp popUp = new OKPopUp("Non puoi ancora rilevare l'uscita! Torna a lavoro...");
					popUp.setVisible(true);
					
				}
				
				
				System.out.println(t1);
				
				datab.closeConnection();
				return false;				
			}
			String sql2 = "select inizio_turno, fine_turno, fascia_oraria, uscita, entrata from Turno where ref_i_matricola = '"+matricola+"' and giornata_lavoro = '"+d.minusDays(1)+"' and fascia_oraria = 2 ";	
			ResultSet rs2 = datab.query(sql2);
			try {
				if(rs2.next()) {
					if(!(rs2.getBoolean(5))) {
						OKPopUp popUp = new OKPopUp("Presenza in ingresso non rilevata!");
						popUp.setVisible(true);
						
						datab.closeConnection();
						return false;
					}
					if(rs2.getBoolean(4)) {
						OKPopUp popUp = new OKPopUp("Uscita gia' rilevata!");
						popUp.setVisible(true);
						
						datab.closeConnection();
						return false;
					}
					
			        LocalTime t1;
					inizio_turno = rs2.getTime(1);
					fine_turno = rs2.getTime(2);
					fascia = rs2.getInt(3);
					
					t1 = LocalTime.parse(fine_turno.toString());
					LocalTime actualTime =  LocalTime.now();  //PRENDE IL TEMPO ATTUALE
					//LocalTime actualTime = LocalTime.of(8, 01); //TEMPO SETTATO PER TESTING
					if((actualTime.isAfter(t1) || actualTime.equals(t1)) && (actualTime.isBefore(t1.plusMinutes(14)) || actualTime.equals(t1.plusMinutes(14)))) {
						System.out.println("VERO");
						
						updateUscita2(matricola);
						conteggioOre2(matricola);
						
						datab.closeConnection();
						return true;
					}			
					else {
					OKPopUp popUp = new OKPopUp("Non puoi ancora rilevare l'uscita! Torna a lavoro...");
						popUp.setVisible(true);
						
					}
					
					
					System.out.println(t1);
					
					datab.closeConnection();
					return false;				
				}		
				else {
				OKPopUp popUP = new OKPopUp("Oggi non sei in turno!");
				popUP.setVisible(true);
				datab.closeConnection();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		datab.closeConnection();		
		return false;
	}
	
	public void updateUscita(String matricola) {
		LocalDate now = LocalDate.now();
		
		//Richiamo metodo conteggio ore
		
		DBMS db = new DBMS();
		db.updateUscita(matricola, now.toString());
		db.closeConnection();
		
		OKPopUp popUp = new OKPopUp("Uscita rilevata correttamente");
		popUp.setVisible(true);
		
	}
	public void updateUscita2(String matricola) {
		LocalDate now = LocalDate.now();
		
		now = now.minusDays(1);
		//Richiamo metodo conteggio ore
		
		DBMS db = new DBMS();
		db.updateUscita(matricola, now.toString());
		db.closeConnection();
		
		OKPopUp popUp = new OKPopUp("Uscita rilevata correttamente");
		popUp.setVisible(true);
		
	}
	
	public void conteggioOre(String matricola) {
		DBMS db = new DBMS();
		
		Time startTurno = null;
		Time endTurno= null;
		
		LocalDate date = LocalDate.now();
		String sql = "select inizio_turno, fine_turno from Turno where ref_i_matricola = '"+matricola+"' and giornata_lavoro = '"+date+"' ";
		
		ResultSet rs = db.query(sql);
		
		try {
			if(rs.next()) {
				startTurno = rs.getTime(1);
				endTurno = rs.getTime(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LocalTime t1;
		LocalTime t2;
		
		t1 = LocalTime.parse(startTurno.toString());
		t2 = LocalTime.parse(endTurno.toString());		
		
		System.out.println(t1 + " " + t2 + "Test date");
		
		String sql2 = "select oreLavorate, oreStraordinarie, oreFestive from Impiegato where i_matricola = '"+matricola+"' ";
		
		ResultSet rs2 = db.query(sql2);
		
		int oreLavorate = 0;
		int oreStraordinare = 0;
		int oreFestive = 0;
		
		try {
			if(rs2.next()) {
				oreLavorate = rs2.getInt(1);
				oreStraordinare = rs2.getInt(2);
				oreFestive = rs2.getInt(3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int differenzaOre = (int) t1.until(t2, ChronoUnit.HOURS); //CALCOLO LA DIFFENREZA IN ORE TRA INIZIO E FINE TURNO
		
		System.out.println("DifferenzaOre: " + differenzaOre);
		
		if(differenzaOre > 8) {
			oreStraordinare = oreStraordinare + differenzaOre - 8;
		}
		
		if(checkFestivo(date)) {
			oreFestive = oreFestive + differenzaOre;
		}
		else {
			oreLavorate = oreLavorate + differenzaOre;
		}
		
		
		//METODO UPDATE ORE
		db.updateOre(oreLavorate, oreStraordinare, oreFestive, matricola);
		
		db.closeConnection();
	}
	
	public void conteggioOre2(String matricola) {
		DBMS db = new DBMS();
		
		Time startTurno = null;
		Time endTurno= null;
		
		LocalDate date = LocalDate.now();
		String sql = "select inizio_turno, fine_turno from Turno where ref_i_matricola = '"+matricola+"' and giornata_lavoro = '"+date.minusDays(1)+"' ";
		
		ResultSet rs = db.query(sql);
		
		try {
			if(rs.next()) {
				startTurno = rs.getTime(1);
				endTurno = rs.getTime(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LocalTime t1;
		LocalTime t2;
		
		t1 = LocalTime.parse(startTurno.toString());
		t2 = LocalTime.parse(endTurno.toString());		
		
		System.out.println(t1 + " " + t2 + "Test date");
		
		String sql2 = "select oreLavorate, oreStraordinarie, oreFestive from Impiegato where i_matricola = '"+matricola+"' ";
		
		ResultSet rs2 = db.query(sql2);
		
		int oreLavorate = 0;
		int oreStraordinare = 0;
		int oreFestive = 0;
		
		try {
			if(rs2.next()) {
				oreLavorate = rs2.getInt(1);
				oreStraordinare = rs2.getInt(2);
				oreFestive = rs2.getInt(3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int differenzaOre = 0;
		if(t1.toString().equals("16:00") && t2.toString().equals("00:00")) {
			differenzaOre = 8;
		}
		else {
		differenzaOre = (int) t1.until(t2, ChronoUnit.HOURS); //CALCOLO LA DIFFERENZA IN ORE TRA INIZIO E FINE TURNO
		}
		System.out.println("DifferenzaOre: " + differenzaOre);
		
		if(differenzaOre > 8) {
			oreStraordinare = oreStraordinare + differenzaOre - 8;
		}
		
		if(checkFestivo(date)) {
			oreFestive = oreFestive + differenzaOre;
		}
		else {
			oreLavorate = oreLavorate + differenzaOre;
		}
		
		
		//METODO UPDATE ORE
		db.updateOre(oreLavorate, oreStraordinare, oreFestive, matricola);
		
		db.closeConnection();
	}
	
	
	public boolean checkFestivo(LocalDate d) {
		String dateString = d.getDayOfWeek().toString();
		System.out.println(dateString);
		
		if(("SATURDAY".equalsIgnoreCase(dateString)) || ("SUNDAY".equalsIgnoreCase(dateString))) {
			return true;
		}
		if(d.isEqual(LocalDate.of(2023,1,1))) {
			return true;
		}
		if(d.isEqual(LocalDate.of(2023,1,6))) {
			return true;
		}
		if(d.isEqual(LocalDate.of(2023,8,15))) {
			return true;
		}
		if(d.isEqual(LocalDate.of(2023,5,1))) {
			return true;
		}
		if(d.isEqual(LocalDate.of(2023,4,25))) {
			return true;
		}
		if(d.isEqual(LocalDate.of(2023,6,2))) {
			return true;
		}
		if(d.isEqual(LocalDate.of(2023,11,1))) {
			return true;
		}
		if(d.isEqual(LocalDate.of(2023,12,25))) {
			return true;
		}
		if(d.isEqual(LocalDate.of(2023,12,26))) {
			return true;
		}
		if(d.isEqual(LocalDate.of(2023,12,8))) {
			return true;
		}		
		
		return false;
	}

}

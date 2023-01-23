package RilevazionePresenze;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
					
					return false;
				}
				
		        LocalTime t1;
				inizio_turno = rs.getTime(1);
				fine_turno = rs.getTime(2);
				fascia = rs.getInt(3);
				
				t1 = LocalTime.parse(inizio_turno.toString());
				LocalTime actualTime =  LocalTime.now();  //PRENDE IL TEMPO ATTUALE
				//LocalTime actualTime = LocalTime.of(00, 11);
				if((actualTime.isAfter(t1) || actualTime.equals(t1)) && (actualTime.isBefore(t1.plusMinutes(15)) || actualTime.equals(t1.plusMinutes(15)))) {
					System.out.println("VERO");
					
					datab.closeConnection();
					return true;
				}
				else {
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
	
	public void updatePresenza(String matricola) {
		LocalDate now = LocalDate.now();
		
		DBMS db = new DBMS();
		db.updatePresenza(matricola, now.toString());
		db.closeConnection();
		
		OKPopUp popUp = new OKPopUp("Presenza rilevata correttamente");
		popUp.setVisible(true);
		
	}
	

}

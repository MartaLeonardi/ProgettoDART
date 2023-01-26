package RilevazionePresenze;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import BoundaryDBMS.DBMS;
import PopUp.OKPopUp;

public class FirmaIngressoControl {
	Time inizio_turno;
	Time fine_turno;
	int fascia;
	
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
				LocalTime actualTime =  LocalTime.now();  //PRENDE IL TEMPO ATTUALE
				//LocalTime actualTime = LocalTime.of(8, 11); //TEMPO DI TESTING
				if((actualTime.isAfter(t1.plusMinutes(10)))) {
					System.out.println("VERO");
					datab.insertRitardo(matricola, d.toString()); //IN AUTOMATICO PRENDE IL RITARDO
					datab.closeConnection();
					return true;
				}
				else {					
					OKPopUp popUp = new OKPopUp("Firma al dispositivo all'ingresso!");
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
	

}

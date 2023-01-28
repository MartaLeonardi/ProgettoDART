package RilevazionePresenze;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import BoundaryDBMS.DBMS;

public class UscitaAutomaticaControl {
	
	//update Turno set uscita = true where giornata_lavoro = ?(giornata odierna)  and entrata = ?(vero) and
	// 		 fine_turno <= ?(tempo attuale) and ?(fine_turno + 15) > ?(tempo attuale)
	
	
	public void uscitaAuto() {
		LocalDate dataOdierna = LocalDate.now();
		LocalDate dataIeri = dataOdierna.minusDays(1);
		LocalTime tempoAttuale = LocalTime.now();
		//LocalDate dataOdierna = LocalDate.now();
		//LocalTime tempoAttuale = LocalTime.of(16,10,00);
		System.out.println(tempoAttuale);
		LocalTime tempo = LocalTime.of(tempoAttuale.getHour(), tempoAttuale.getMinute(), 00);
		System.out.println(tempo);
		System.out.println(dataOdierna);
		DBMS db = new DBMS();
		
		LocalTime tempoSomma = LocalTime.of(0, 20, 0);
		System.out.println(tempoSomma);
		String sql = "";
		int t = 0;
		if(!(tempoAttuale.getHour() == 0)) {
		sql = ("select ref_i_matricola from Turno where giornata_lavoro = '"+Date.valueOf(dataOdierna.toString())+"'  and "
				+ "	fine_turno <= '"+Time.valueOf(tempo.toString()+":00")+"' and fine_turno + '"+Time.valueOf(tempoSomma.toString()+":00")+"' > '"+Time.valueOf(tempo.toString()+":00")+"' and entrata = true and uscita is null");
			t = 1;
		}
		else {
			sql = ("select ref_i_matricola from Turno where giornata_lavoro = '"+Date.valueOf(dataIeri.toString())+"'  and "
					+ "	fine_turno = '00:00:00' and entrata = true and uscita is null");
		t=2;
			}
		System.out.println("test1");
		
		ResultSet rs = db.query(sql);
		
		System.out.println("test2");
		ArrayList<String> matricola = new ArrayList<>();
		System.out.println(matricola);
		try {
				rs.first();
				do {
					System.out.println("test3");
					matricola.add(rs.getString(1));
					System.out.println(matricola);
				}while(rs.next());
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//INVIO EMAIL PER MATRICOLA CHE NON HANNO FIRMATO L'USCITA
		
		if(t==1) {
			db.updateUscitaAuto(dataOdierna, tempo);
		}
		else {
			db.updateUscitaAuto(dataIeri, tempo);
		}
		
		
		db.closeConnection();
	}

}

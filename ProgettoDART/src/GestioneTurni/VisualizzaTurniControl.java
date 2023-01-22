package GestioneTurni;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import BoundaryDBMS.DBMS;

public class VisualizzaTurniControl {
	
	
	public String[] getTurni(String giorni, int fascia, String servizio) {
		String[] array = new String[6];
		int i = 0;
		DBMS db = new DBMS();
		
		System.out.println("test1");
		
		String sql = "select nome, cognome from Utente where u_matricola IN ( "
					+ "select ref_i_matricola from Turno where giornata_lavoro = '"+ Date.valueOf(giorni) +"' and servizio = '"+ servizio +"' and fascia_oraria = "+ fascia +")";
		
		ResultSet rs = db.query(sql);
		
		
		try {
			rs.first();
			do{
				System.out.println("tessttetetet");
				array[i] = rs.getString(1) + " " +rs.getString(2);
				System.out.println(array[i]);
				System.out.println(i);
				i++;
			}while(rs.next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		db.closeConnection();
		return array;
	}
	

}

package GestionePermessi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import BoundaryDBMS.DBMS;
import Login.Utente;
import PopUp.OKPopUp;

public class RichiediScioperoControl {
	
	
	static Date date = new Date();
	
	 
    static String pattern = "yyyy-MM-dd";
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    static String d = simpleDateFormat.format(date); 
   
    static Date dataLimite = new Date(date.getTime() + (10000 * 60 * 60 * 24));
    
	
	static String matricola;
	
	
	public static String getDataEmp() {
		Utente utente = Utente.getInstance();
		matricola=utente.getMatricola();
		return matricola;
	}

	
	public static void checkDati(Date dataInserita) throws SQLException {
		
		String matricola = getDataEmp();
		
		String dataI = simpleDateFormat.format(dataInserita);
		
		int numeroGiorni=contaScioperi(matricola);
		
		if(numeroGiorni >= 5) {
	    	OKPopUp pop = new OKPopUp("Non puoi richiedere altri giorni di sciopero!");
			pop.setVisible(true);
			
		}
		
			if(date.before(dataInserita)) {
			
			if(dataInserita.after(dataLimite)) {
				
			    Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"), Locale.ITALY);
			    c.setTime(dataInserita);
			    int giorno=c.get(Calendar.DAY_OF_MONTH);
			    int mese=c.get(Calendar.MONTH)+1;
			    int anno=c.get(Calendar.YEAR);
			    
			    System.out.println("DATA SELEZIONATA: GIORNO:" +giorno + "\nMESE:" + mese + "\nANNO:" +anno);
			    
			    Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"), Locale.ITALY);
			    c.setTime(date);
			    int mese1=c.get(Calendar.MONTH)+4;
			    
			    
			    System.out.println("MESE MASSIMO :" + mese1);
			    
			    if(mese==mese1) {
			    	OKPopUp pop = new OKPopUp("Non puoi prendere scioperi nel trimestre successivo!");
					pop.setVisible(true);
			    }
			    
			    else if(mese==8) {
			    	OKPopUp pop = new OKPopUp("Non puoi prendere scioperi ad agosto!");
					pop.setVisible(true);
			    }
			    
			    else if(mese==12 && giorno>=23 || mese==1 && giorno<=7) {
			    	OKPopUp pop = new OKPopUp("Non puoi prendere scioperi dal 23/12 al 07/01!");
					pop.setVisible(true);
			    }
			    
			    else if(checkTurnazione(matricola,dataI)){
			    	
					String servizio= getServizio(matricola,dataI);
					String fasciaOraria = getFasciaOraria(matricola,dataI);
					
					int numDipServ = countDipServizi(dataI,servizio,fasciaOraria);
					
					if(numDipServ>=1) {
						
						System.out.println("Sciopero accordato");
				    	OKPopUp pop = new OKPopUp("Sciopero accordato");
						pop.setVisible(true);
						
						
						//insert
						DBMS database=new DBMS();
						database.insertRichiesta(matricola, "Sciopero", dataI, dataI, 0, 0, true);
						database.closeConnection();
						
						//delete turno
						//DBMS db=new DBMS();
						//db.deleteTuplaImp(matricola,dataI,servizio,fasciaOraria);
						//db.closeConnection();
						
					}else {
						System.out.println("Richiesta rigettata: mancanza personale");
				    	OKPopUp pop = new OKPopUp("Richiesta rigettata: mancanza personale");
						pop.setVisible(true);
					}
					
					
			    }
			    else {
			    	OKPopUp pop = new OKPopUp("Nessuna turnazione prevista per la data indicata!");
					pop.setVisible(true);
			    	
			    }
			    
			    
			}else {
				OKPopUp pop = new OKPopUp("Errore: Preavviso minimo di 10 giorni!");
				pop.setVisible(true);
			}
			
			
			
		}else {
			OKPopUp pop = new OKPopUp("Data inizio precedente o uguale a oggi");
			pop.setVisible(true);
		}
		
		
	}
	
	
	public static String getFasciaOraria(String matricola, String giornata) throws SQLException {
		DBMS database = new DBMS();
		String sql = "SELECT fascia_oraria FROM Turno WHERE ref_i_matricola='"+matricola+"' AND giornata_lavoro = '"+giornata+"'";
				
		ResultSet rs=database.query(sql);
		
		String result="";
		
		while(rs.next()) {
			result=rs.getString(1);
		}
		
		database.closeConnection();
			System.out.println("NOME SERVIZIO:" + result);
		return result;
	}
	
	public static String getServizio(String matricola, String giornata) throws SQLException {
		
		DBMS database = new DBMS();
		String sql = "SELECT servizio FROM Turno WHERE ref_i_matricola='"+matricola+"' AND giornata_lavoro = '"+giornata+"'";
				
		ResultSet rs=database.query(sql);
		
		String result="";
		
		while(rs.next()) {
			result=rs.getString(1);
		}
		
		database.closeConnection();
			System.out.println("NOME SERVIZIO:" + result);
		return result;
		
	}
	
	
	private static int countDipServizi(String dataI, String servizio, String fasciaOraria) throws SQLException {

		DBMS database = new DBMS();
		String sql = "SELECT COUNT(*)  FROM Turno  WHERE giornata_lavoro = '"+dataI+"'AND servizio='"+servizio+"' AND fascia_oraria='"+fasciaOraria+"'";
				
		ResultSet rs=database.query(sql);
		
		int result=0;
		
		while(rs.next()) {
			result=rs.getInt(1);
		}
		
		database.closeConnection();
			System.out.println(result-1);
		return result-1;
		
	}


	private static boolean checkTurnazione(String matricola, String giornata) throws SQLException {
		
		DBMS database = new DBMS();
		ResultSet rs=database.query("SELECT COUNT(*)\r\n"
				+ "FROM Turno\r\n"
				+ "WHERE ref_i_matricola='"+matricola+"' AND giornata_lavoro = '"+giornata+"'");
		
		int result=0;
		
		while(rs.next()) {
			result=rs.getInt(1);
		}
		database.closeConnection();

		if(result==0) {

			System.out.println("TURNO NON PRESENTE");
			return false;
		}else {

			System.out.println("TURNO PRESENTE");
			return true;
		}
	}

	public static int contaScioperi(String matricola) throws SQLException {
		DBMS database = new DBMS();
		String sql = "SELECT COUNT(*) FROM Richiesta R WHERE R.ref_matricola='"+matricola+"' AND R.tipo='Sciopero'";
				
		ResultSet rs=database.query(sql);
		
		int result=0;
		
		while(rs.next()) {
			result=rs.getInt(1);
		}
		
		database.closeConnection();
			System.out.println(result);
		return result;
		
	}
	
	
}

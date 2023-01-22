package GestionePermessi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import BoundaryDBMS.DBMS;
import PopUp.OKPopUp;

public class RichiediPermessoImpiegatoControl {

	static Date date = new Date();
	
	 
    static String pattern = "yyyy-MM-dd";
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    static String d = simpleDateFormat.format(date); 
    
    
	public static boolean checkMatricola(String matricola) {

		if (!(matricola.substring(0, 1).equals("0"))) {
			return false;
		}
		
		DBMS db = new DBMS();
		
		String sql = "select u_matricola from Utente where u_matricola = '" + matricola + "'";
		
		ResultSet rs = db.query(sql);
		try {
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	
	}
	
	public static void checkDati(String matricola, String motivazione, Date dataInizio, Date dataFine,
			String oraI, String oraF, boolean check) {
		String m=matricola;
		
		if(date.before(dataInizio)) {	//controllo data inizio maggiore alla data odierna
				
			if(dataInizio.before(dataFine) || dataInizio.equals(dataFine)) {	//controllo data inizio minore data fine
					
					
				String dInizio = simpleDateFormat.format(dataInizio);
				String dFine = simpleDateFormat.format(dataFine);
				
				System.out.println("Date selezionate accettabili, uguale o piu' grande della finale");
				
				int oraInizio = Integer.parseInt(oraI);
				int oraFine = Integer.parseInt(oraF);
				if(dInizio.equals(dFine)) {				//se date uguali
					
					if(oraInizio>=oraFine) {			//controllo su ora di inizio che sia minore di quella di fine
						if(oraInizio>oraFine) {
							System.out.println("Ora inizio successiva ad ora fine della data selezionata!");
							OKPopUp pop = new OKPopUp("Ora inizio successiva ad ora fine della data selezionata!");
							pop.setVisible(true);
						}else {
							System.out.println("Ora inizio uguale ad ora fine della data selezionata!");
							OKPopUp pop = new OKPopUp("Ora inizio uguale ad ora fine della data selezionata!");
							pop.setVisible(true);
						}
	
					}else {		//ora inizio minore
						System.out.println("Dati inseriti hanno superato i controlli:\nMatricola:" + matricola + "\nMotivazione:"+ motivazione + "\nData inizio:" + dInizio
								+"\nData fine:"+ dFine+ "\nOra inizio:" + oraI + "\nOra fine:" + oraF);
						OKPopUp pop = new OKPopUp("Operazione avvenuta con successo!");
						pop.setVisible(true);
						//RICHIAMO AL METODO PER INSTANZIARE
						
						
						DBMS database=new DBMS();
						database.insertRichiesta(matricola, motivazione, dInizio, dFine, oraInizio, oraFine, check);
						
						
						String[] data = dInizio.split("-");
						
						int[] dataInt = new int[3]; 
						dataInt[0] = Integer.parseInt(data[0]);
						dataInt[1] = Integer.parseInt(data[1]);
						dataInt[2] = Integer.parseInt(data[2]);
						
						
						String[] dataF = dFine.split("-");
						int[] dataIntF = new int[3]; 
						dataIntF[0] = Integer.parseInt(dataF[0]);
						dataIntF[1] = Integer.parseInt(dataF[1]);
						dataIntF[2] = Integer.parseInt(dataF[2]);
						
						LocalDate daInizio = LocalDate.of(dataInt[0], dataInt[1], dataInt[2]);
						LocalDate daFine = LocalDate.of(dataIntF[0], dataIntF[1], dataIntF[2]);					
						
						
						
						for(LocalDate d = daInizio;  d.isBefore(daFine.plusDays(1));  d = d.plusDays(1)) {
							
							
							
							try {
								String fascia = getFasciaOraria(matricola,d.toString());
								String servizio = getServizio(matricola, d.toString());
								
								
								
								
								
								database.deleteTuplaImp(matricola, d.toString(), servizio, fascia);						
								
								String sql = "select count(*) from Turno where giornata_lavoro = '" + d + "' and servizio = '"+servizio+"' and fascia_oraria = '"+ fascia +"'";
								String res = "";
								ResultSet rs = database.query(sql);
								if(rs.next()) {
									res = rs.getString(1);
								}
								
								
								if(res.equals("0")) {
									
									database.updateStato(d.toString(), servizio, fascia);
									
								}
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
						database.closeConnection();
						
					
					}
					
					
				}else {	//se date diverse non serve effettuare controllo delle ore
					
					System.out.println("Dati inseriti hanno superato i controlli:\nMatricola:" + matricola + "\nMotivazione:"+ motivazione + "\nData inizio:" + dInizio
							+"\nData fine:"+ dFine+ "\nOra inizio:" + oraI + "\nOra fine:" + oraF);
					OKPopUp pop = new OKPopUp("Operazione avvenuta con successo!");
					pop.setVisible(true);
					//RICHIAMO AL METODO PER INSTANZIARE
					
					
					DBMS database=new DBMS();
					database.insertRichiesta(matricola, motivazione, dInizio, dFine, oraInizio, oraFine, check);
					
					
					String[] data = dInizio.split("-");
					
					int[] dataInt = new int[3]; 
					dataInt[0] = Integer.parseInt(data[0]);
					dataInt[1] = Integer.parseInt(data[1]);
					dataInt[2] = Integer.parseInt(data[2]);
					
					
					String[] dataF = dFine.split("-");
					int[] dataIntF = new int[3]; 
					dataIntF[0] = Integer.parseInt(dataF[0]);
					dataIntF[1] = Integer.parseInt(dataF[1]);
					dataIntF[2] = Integer.parseInt(dataF[2]);
					
					LocalDate daInizio = LocalDate.of(dataInt[0], dataInt[1], dataInt[2]);
					LocalDate daFine = LocalDate.of(dataIntF[0], dataIntF[1], dataIntF[2]);					
					
					
					
					for(LocalDate d = daInizio;  d.isBefore(daFine.plusDays(1));  d = d.plusDays(1)) {
						
						
						
						try {
							String fascia = getFasciaOraria(matricola,d.toString());
							String servizio = getServizio(matricola, d.toString());
							
							
							
							
							
							database.deleteTuplaImp(matricola, d.toString(), servizio, fascia);						
							
							String sql = "select count(*) from Turno where giornata_lavoro = '" + d + "' and servizio = '"+servizio+"' and fascia_oraria = '"+ fascia +"'";
							String res = "";
							ResultSet rs = database.query(sql);
							if(rs.next()) {
								res = rs.getString(1);
							}
							
							
							if(res.equals("0")) {
								
								database.updateStato(d.toString(), servizio, fascia);
								
							}
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					database.closeConnection();
	
				}
		
			}
			if(dataInizio.after(dataFine)) {
				OKPopUp pop = new OKPopUp("Data di inizio successiva alla data di fine!!");
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
	
	
}

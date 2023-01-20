package GestionePermessi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
			String oraI, String oraF) {
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
						System.out.println("Dati inseriti hanno superato i controlli:\nMatricola:" + m + "\nMotivazione:"+ motivazione + "\nData inizio:" + dInizio
											+"\nData fine:"+ dFine+ "\nOra inizio:" + oraI + "\nOra fine:" + oraF);
						//RICHIAMO AL METODO PER INSTANZIARE
					
					}
					
					
				}else {	//se date diverse non serve effettuare controllo delle ore
					
					System.out.println("Dati inseriti hanno superato i controlli:\nMatricola:" + m + "\nMotivazione:"+ motivazione + "\nData inizio:" + dInizio
							+"\nData fine:"+ dFine+ "\nOra inizio:" + oraI + "\nOra fine:" + oraF);
					//RICHIAMO AL METODO PER INSTANZIARE
	
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
	
	
}

package GestionePermessi;

import java.text.SimpleDateFormat;
import java.util.Date;

import BoundaryDBMS.DBMS;
import Login.Utente;
import PopUp.OKPopUp;

public class RichiediPermessoControl {

	static Date date = new Date();
	 
    static String pattern = "yyyy-MM-dd";
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    static String d = simpleDateFormat.format(date); 

	public static void checkDati(String motivazione, Date dataInizio, Date dataFine,
			String oraI, String oraF, boolean check) {
		
		Utente u=Utente.getInstance();
		String matricola=u.getMatricola();
		
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
	
	
	
}

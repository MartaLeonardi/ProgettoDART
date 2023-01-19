package GestionePermessi;

import java.util.Date;

import PopUp.OKPopUp;

public class RichiediPermessoControl {

	
	public void checkDatiInseriti() {
		
	}

	public static void checkDati(String motivazione, Date dataInizio, Date dataFine,
			String oraI, String oraF, String minutoI, String minutoF) {
		//if() {
		if(dataInizio.before(dataFine) || dataInizio.equals(dataFine)) {
			
			System.out.println("Data selezionata accettabile, uguale o più grandela finale");
		}
		if(dataInizio.after(dataFine)) {
			OKPopUp pop = new OKPopUp("Data di inizio successiva alla data di fine!!");
			pop.setVisible(true);
		}
		
		
		
		//}
		
	}
	
	
}
/*String pattern = "yyyy-MM-dd";
SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
String dataInizio = simpleDateFormat.format(dataInseritaInizio);
System.out.println("Data inizio: "+ dataInizio);	*/
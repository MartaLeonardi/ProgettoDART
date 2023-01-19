package GestionePermessi;

import Login.Utente;

public class RichiediScioperoControl {
	
	String matricola;
	
	public void getDataEmp() {
		Utente utente = Utente.getInstance();
		matricola=utente.getMatricola();
	}
	
	public void getDatiForCheck() {
		
	}
	
	public void check() {
		
	}

	public void updateReq() {
		
	}
	
}

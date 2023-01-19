package PortaleAmministratore;

import Login.Utente;
import PopUp.PopUpConfermaLogout;


public class LogoutControl {
	
	public LogoutControl(){
		
		PopUpConfermaLogout popUpConferma = new PopUpConfermaLogout();
		popUpConferma.setVisible(true);
				
		Utente utente = Utente.getInstance();
		utente.eliminaEntity();
		utente.clearInstance();
		
		}
		
	}
	
	


package PortaleAmministratore;

import java.io.*;

import Login.Utente;
import PortaleAmministratore.PortaleAmministratore;
import PortaleImpiegato.PortaleImpiegato;


public class LogoutControl {
	
	public LogoutControl(){
		
		PopUpConfermaLogout popUpConferma = new PopUpConfermaLogout();
		popUpConferma.setVisible(true);
				
		Utente utente = new Utente();
		utente.eliminaEntity();
		
		
		
		}
		
	}
	
	


package GestionePersonale;

import BoundaryDBMS.DBMS;

public class AddEmpControl {
	
	private String matricola;
	private String nome;
	private String cognome;
	private String email;
	private String telefono;
	private String ruolo;
	private String stipendio;

	public AddEmpControl(String nome, String cognome, String matricola, String email, String telefono, String ruolo, String stipendio) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.telefono = telefono;
		this.ruolo = ruolo;
		this.stipendio = stipendio;
		
		
		
		
	}
	
	public boolean checkMatricola() {
		try {
			if(Integer.parseInt(matricola) > 0) {
				DBMS database = new DBMS();
				
			}
			}
			catch(Exception e) {
				return false;
			}
			return false;
		}
	
	
}




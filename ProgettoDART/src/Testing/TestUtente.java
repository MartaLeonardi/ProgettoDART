package Testing;

import java.io.IOException;

import Login.Utente;

public class TestUtente {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//test 1 funzionante
		/*
		String nome="Mario";
		String cognome="Rossi";
		String matricola="0000000";
		String password="psw";
		String mail="ciao@ciao.it";
		String ruolo="ruolo 1";

		*/
		
		//test 2 non funzionante per email
		
		String nome="Mario";
		String cognome="Rossi";
		String matricola="0000000";
		String password="psw";
		String mail="cIao33333@d.io";
		String ruolo="ruolo 1";

		
		
		try {
			Utente u = new Utente(nome,cognome,matricola,password,mail,ruolo);
			System.out.println(u.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

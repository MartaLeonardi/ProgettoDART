package GestionePersonale;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import BoundaryDBMS.DBMS;
import PopUp.OKPopUp;
import PortaleAmministratore.AssumiImpiegato;

public class AddEmpControl {
	
	private String matricola;
	private String nome;
	private String cognome;
	private String email;
	private String telefono;
	private String ruolo;

	public AddEmpControl(String nome, String cognome, String matricola, String email, String telefono, String ruolo) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.telefono = telefono;
		this.ruolo = ruolo;
		
		if(checkDati(nome, cognome, matricola, email, telefono)) {
			DBMS database = new DBMS();
			
			database.insertUtente(matricola, email, nome, cognome);
			database.insertImpiegato(matricola, ruolo);
			database.insertAutenticazione(matricola);
			database.closeConnection();
			OKPopUp popUp = new OKPopUp("Inserimento avvenuto con successo");
			popUp.setVisible(true);
			
			
		}
		
			
			
		
		
		
		
	}
	
	public boolean checkMatricola(String matricola) {
		try {
			if(Integer.parseInt(matricola) > 0) {
				
				if(matricola.length() > 5 || matricola.length() < 5) {
					return false;
				}
				
				if (!(matricola.substring(0, 1).equals("0"))) {
					return false;
				}

				
				DBMS database = new DBMS();
				
				String sql = "SELECT u_matricola  FROM Utente WHERE u_matricola = '" + matricola + "'";
				
				try {
					ResultSet rs=database.query(sql);
					System.out.println("zero");
					if(rs.next() == false) {
						return true;
					}
					rs.first();
					do {
						String row =rs.getString("u_matricola");
						System.out.println(row);
						database.closeConnection();
						if(row.equals("")) {
							return true;
						}
						else {
							return false;
						}
					}while(rs.next());
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
				
				
			}
			}
			catch(Exception e) {
				return false;
			}
			return false;
		}
	
	
	public boolean checkNomeCognome(String nome, String cognome) {
		if(nome.length() > 20 || cognome.length() > 30) {
			return false;
		}
		
		if(!isAlpha(nome) || !isAlpha(cognome)) {
			return false;
		}
		
		return true;
		
	}
	
	public boolean isAlpha(String name) {
	    return name.matches("[a-zA-Z]+");
	}
	
	public boolean checkMail (String email) {
		
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher(email);

		boolean matchFound = m.matches();

		StringTokenizer st = new StringTokenizer(email, ".");
		String lastToken = null;
		while (st.hasMoreTokens()) {
			lastToken = st.nextToken();
			}

		if (matchFound && lastToken.length() >= 2 && email.length() - 1 != lastToken.length()) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean checkMailDB(String email) {
		try {							
				DBMS database = new DBMS();
				
				String sql = "SELECT email  FROM Utente WHERE email = '" + email + "'";
								
					ResultSet rs=database.query(sql);
					System.out.println("zero");
					if(rs.next() == false) {
						return true;
					}
					else {
						return false;
					}					
			}
			catch(Exception e) {
				return false;
			}		
	}
	
	public boolean checkTelefono(String telefono) {
		System.out.println(telefono);
		try {
			if(!(Long.parseLong(telefono) > 0)) {
				System.out.println(Integer.parseInt(telefono));
				System.out.println("lettere");
				return false;
			}
			}
			catch(Exception e) {
				return false;
			}
	
		if(telefono.length() > 10 || telefono.length() < 10) {
			System.out.println("maggiore");
			return false;
		}
		return true;
	}
	
	public boolean checkDati(String nome, String cognome, String matricola, String email, String telefono) {
		if(checkMatricola(matricola)) {
			System.out.println("Avanti");
			
			if(checkNomeCognome(nome, cognome)) {
				System.out.println("Avanti2");
				nome.toLowerCase();
				cognome.toLowerCase();
				
				if(checkMail(email) == true && checkMailDB(email)) {
					System.out.println("Avanti3");
					
					if(checkTelefono(telefono)) {
						System.out.println("Avanti4");
							return true;
						
					}
					else {
						OKPopUp popUp = new OKPopUp("telefono non valido");
						popUp.setVisible(true);
						AssumiImpiegato addEmp = AssumiImpiegato.getInstance();
						addEmp.telefonoField.setText("");
					}
					
					
				}
				else {
					OKPopUp popUp = new OKPopUp("email non valida");
					popUp.setVisible(true);
					AssumiImpiegato addEmp = AssumiImpiegato.getInstance();
					addEmp.emailField.setText("");
				}
				
				
			}
			else {
				OKPopUp popUp = new OKPopUp("Nome o congome non validi");
				popUp.setVisible(true);
				AssumiImpiegato addEmp = AssumiImpiegato.getInstance();
				addEmp.nomeField.setText("");
				addEmp.cognomeField.setText("");
			}
			
			
		}
		else {
			OKPopUp popUp = new OKPopUp("Matricola non valida");
			popUp.setVisible(true);
			AssumiImpiegato addEmp = AssumiImpiegato.getInstance();
			addEmp.matricolaField.setText("");
		}
		
		return false;
	}
	
		
}

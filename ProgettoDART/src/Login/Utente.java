package Login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import BoundaryDBMS.DBMS;

public class Utente {
		
	File f = new File("UserEntity.txt");
	String matricola, nome, cognome, ruolo, mail;
	String password;
	
	
	public Utente() {};					//Metodo costruttore senza parametri
	
										//Metodo costruttore iniziale al momento del login
	public Utente(String matricola, String password) throws FileNotFoundException, IOException {
		this.matricola=matricola;
		this.password=password;
		
		if(f.exists()) 
		{
			System.out.println("Il file esiste");
		}
		else if(f.createNewFile())
		{
			System.out.println("Il file e' stato creato");
			toString1();
		}
		
	}
	
	
										//Metodo costruttore con tutti i dati necessari (ENTITY)
	public Utente(String nome, String cognome, String matricola, String password,String mail, String ruolo) throws FileNotFoundException, IOException {
		
		//if(checkMail(mail)==true)
		//{
		this.matricola=matricola;
		this.password=password;
		this.nome=nome;
		this.cognome=cognome;
		this.mail=mail;
		this.ruolo=ruolo;
		
		if(f.exists()) 
		{
			System.out.println("Il file esiste");
			toString();
		}
		else if(f.createNewFile())
		{
			System.out.println("Il file e' stato creato");
			toString1();
		}
		
		/*}
		else {
			System.out.println("Formato e-mail non valido, Utente non aggiunto");
		}
		*/
	}
									//Mette a stringa tutti i dati del metodo costruttore per aggiornare il file UserEntity.txt
	public String toString() {

		 String s ="\nNome:"+ this.nome + "\nCognome:" + this.cognome +"\nMatricola:" + this.matricola + "\nPassword:" + this.password +
				   "\nEmail:" + this.mail + "\nRuolo:" + this.ruolo ;
			try {
				aggiornaDati(s);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 return s;
		
	}
								//Genera una stringa contenente i dati di login, e aggiorna i dati all'interno del file UserEntity.txt
	public String toString1() {
		 String s ="\nMatricola:" + this.matricola + "\nPassword:" + this.password;
		 try {
			aggiornaDati(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 return s;
	}
	
								//Tramite passaggio di stringa(ottenuta da toString() o toString1()) sovrascrive il file UserEntity.txt
	public void aggiornaDati(String stringa) throws FileNotFoundException {
		
		PrintWriter scrivi = new PrintWriter(f);
		scrivi.println("Entity User:\n" + stringa);
		scrivi.close();
		
	}
								//Metodo utile al momento del Logout ->Elimina il file UserEntity.txt
	public void eliminaEntity() {
		if(f.exists()) {
			f.delete();
		}
	}
								//Restituisce la matricola
	public String getMatricola() {
		return matricola;
	}
								//Restituisce la password
	public String getPassword() {
		return password;
	}
	
			/*
				* Attraverso la matricola inserita da login, viene effettuata la query di ricerca all'interno del database
				* si effettuano gli opportuni controlli di integrità e si instanzia l'utente coi dati ottenuti dalla query
			*/
	public void getDatiDataBase (String matricola) {
		
		//query db per prendere i dati (nome,cognome,ruolo,mail,ferie,permessi,stipendi) MANCANTE

		
		
		if(checkMail(mail)==true)
		{
		try {
			Utente u= new Utente(nome, cognome, matricola, password, mail, ruolo);
			String f=u.toString();
			System.out.println(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
	}
	
					//Setta la mail
	public void setMail(String mail) {
		this.mail=mail;
	}
	
	
					//Metodi Get per tutti gli attributi (Nome, Cognome, Mail, Ruolo, Ferie, Permessi, Stipendio)
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}

	public String getMail() {
		return mail;
	}
	
	public String getRuolo() {
		return ruolo;
	}

	
			/*
			 * Controllo della stringa mail inserita
			 * pattern mail = Stringa dove sono concessi numeri e lettere(minuscole e maiuscole) + @ + dominio
			 * il dominio è composto da: stringa lettere e numeri + . + stringa sole lettere
			 * 
			 * il metodo restituisce un valore booleano true se la mail soddisfa tutti i requisiti del pattern
			 * false se non li soddisfa
			 */
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
	
	
	public static boolean checkDatiDB (String matricola, String password) {
		
		DBMS database = new DBMS();
		
		String sql = "SELECT U.nome, U.cognome , U.u_matricola, U.email, I.ruolo\r\n"
				+ "FROM Utente U, Impiegato I\r\n"
				+ "WHERE A.ref_t_matricola=U.u_matricola AND I.i_matricola=U.u_matricola AND U.u_matricola = '" + matricola + "' " ;
	
		try {
			ResultSet rs=database.query(sql);
			rs.first();
			do {
				String row =rs.getString("nome") + "" + rs.getString("cognome") + ""+ matricola + ""+ password
							+ ""+ rs.getString("email") + ""+ rs.getString("ruolo");
				
				try {
					Utente utente = new Utente(rs.getString("nome"),rs.getString("cognome"),matricola, password,
										rs.getString("email"),rs.getString("ruolo"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//System.out.println(row);
				database.closeConnection();
				return true;
			}while(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Fine controllo");
		database.closeConnection();
		return false;
		
	}
	
	
	
}
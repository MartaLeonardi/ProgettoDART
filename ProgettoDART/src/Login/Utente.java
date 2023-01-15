package Login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utente {
		
	File f = new File("UserEntity.txt");
	String matricola, nome, cognome, ruolo, mail;
	char[] password;
	int ferie,permessi;				//numero ferie e numero permessi
	double stipendio;
	
	
	public Utente() {};
	
	public Utente(String matricola, char[] password) throws FileNotFoundException, IOException {
		this.matricola=matricola;
		this.password=password;
		
		if(f.exists()) 
		{
			System.out.println("Il file esiste");
		}
		else if(f.createNewFile())
		{
			System.out.println("Il file e' stato creato");
			toString();
		}
		
	}
	
	public Utente(String nome, String cognome, String matricola, char[] password,String mail, String ruolo,
					int ferie, int permessi, double stipendio) throws FileNotFoundException, IOException {
		this.matricola=matricola;
		this.password=password;
		this.nome=nome;
		this.cognome=cognome;
		this.mail=mail;
		this.ruolo=ruolo;
		this.ferie=ferie;
		this.permessi=permessi;
		this.stipendio=stipendio;
		
		if(f.exists()) 
		{
			System.out.println("Il file esiste");
			toString1();
		}
		else if(f.createNewFile())
		{
			System.out.println("Il file e' stato creato");
			toString();
		}
		
	}
	
	private String toString1() {

		 String s ="\nNome:"+ this.nome + "\nCognome:" + this.cognome +"\nMatricola:" + this.matricola + "\nPassword:" + this.password +
				   "\nEmail:" + this.mail + "\nRuolo:" + this.ruolo + "\nNumero ferie:" + this.ferie + "\nNumero permessi:" + this.permessi + 
				   "\nStipendio:" + this.stipendio;
		 try {
			aggiornaDati(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 return s;
		
	}

	public String toString() {
		 String s ="\nMatricola:" + this.matricola + "\nPassword:" + this.password;
		 try {
			aggiornaDati(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 return s;
	}
	
	public void aggiornaDati(String stringa) throws FileNotFoundException {
		
		PrintWriter scrivi = new PrintWriter(f);
		scrivi.println("Entity User:\n" + stringa);
		scrivi.close();
		
	}
	
	public void eliminaEntity() {
		if(f.exists()) {
			f.delete();
		}
	}
	
	public String getMatricola() {
		return matricola;
	}
	
	public char[] getPassword() {
		return password;
	}
	
	public void getDatiDataBase (String matricola) {
		
		//query db per prendere i dati (nome,cognome,ruolo,mail,ferie,permessi,stipendi)
		
		//nella mail parte il controllo del metodo (checkMail) contenuto in questa stessa classe
		
		/*String nome="Mario";
		String cognome="Rossi";
		String matricola=this.matricola;
		char[] password=getPassword();
		String mail="ciao@ciao.it";
		String ruolo="ruolo 1";
		int ferie=0, permessi=0;
		Double stipendio=0.00;
		*/												//DATI CON CUI TESTARE L'ACCESSO,SOLO DOPO AVER RISOLTO IL PROBLEMA LoginJFrame e LoginControl
		
		
		if(checkMail(mail)==true)
		{
		try {
			Utente u= new Utente(nome, cognome, matricola, password, mail, ruolo, ferie, permessi, stipendio);
			String f=u.toString1();
			System.out.println(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
	}
	
	public void setMail(String mail) {
		this.mail=mail;
	}
	
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
	
	public int getFerie() {
		return ferie;
	}
	
	public int getPermessi() {
		return permessi;
	}
	
	public double getStipendio() {
		return stipendio;
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
}
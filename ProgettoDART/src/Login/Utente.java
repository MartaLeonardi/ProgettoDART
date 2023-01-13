package Login;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Utente {
		
	File f = new File("UserEntity.txt");
	String matricola;
	char[] password;
	
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
	
	
}


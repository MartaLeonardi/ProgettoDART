package GestioneStipendi;

public class Impiegati {
	

	private String matricola;
	@Override
	public String toString() {
		return "Impiegati [matricola=" + matricola + ", ruolo=" + ruolo + ", oreLavorate=" + oreLavorate
				+ ", oreStraordinarie=" + oreStraordinarie + ", oreFestive=" + oreFestive + "]";
	}

	private String ruolo;
	private int oreLavorate;
	private int oreStraordinarie;
	private int oreFestive;
	
	public Impiegati(String matricola, String ruolo, int oreLavorate, int oreStraordinarie, int oreFestive) {
		this.matricola = matricola;
		this.ruolo = ruolo;
		this.oreLavorate = oreLavorate;
		this.oreStraordinarie = oreStraordinarie;
		this.oreFestive = oreFestive;
	}
	
	public Impiegati(String matricola, String ruolo) {
		this.matricola = matricola;
		this.ruolo = ruolo;
	}
	
	
	public int getOreLavorate() {
		return oreLavorate;
	}

	public void setOreLavorate(int oreLavorate) {
		this.oreLavorate = oreLavorate;
	}

	public int getOreStraordinarie() {
		return oreStraordinarie;
	}

	public void setOreStraordinarie(int oreStraordinarie) {
		this.oreStraordinarie = oreStraordinarie;
	}

	public int getOreFestive() {
		return oreFestive;
	}

	public void setOreFestive(int oreFestive) {
		this.oreFestive = oreFestive;
	}

	public String getRuolo() {
		return ruolo;
	}
	
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	

}

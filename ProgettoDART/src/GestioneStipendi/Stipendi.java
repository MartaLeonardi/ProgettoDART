package GestioneStipendi;

public class Stipendi {
	
	private String matricola;
	private String data;
	private int valore;
	
	public Stipendi(String matricola, String data, int valore) {
		this.matricola = matricola;
		this.data = data;
		this.valore = valore;
	}
	
	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getValore() {
		return valore;
	}

	public void setValore(int valore) {
		this.valore = valore;
	}
	
	@Override
	public String toString() {
		return "Stipendi [matricola=" + matricola + ", data=" + data + ", valore=" + valore + "]";
	}

}

package GestionePermessi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import BoundaryDBMS.DBMS;
import Login.Utente;
import PopUp.OKPopUp;
import PopUp.OkCancelPopUp;

public class RichiediFerieControl {

	static Date date = new Date();
	static LocalDate dateNow = LocalDate.now();
	 
    static String pattern = "yyyy-MM-dd";
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    static String d = simpleDateFormat.format(date); 
    
    static Date dataPreavviso = new Date(date.getTime() + (10000 * 60 * 60 * 24));
    
    static LocalDate dataLimite;
    
    
    static String matricola;
    
    public static String getMatricolaEmp() {
		Utente utente = Utente.getInstance();
		matricola=utente.getMatricola();
		return matricola;
	}
    
    public static void setDataLimite(LocalDate dateNow) {
    	
			System.out.println("DATA OGGI:" +dateNow);
				    
					
					int giorno=dateNow.getDayOfMonth();
					int mese=dateNow.getMonthValue();
					int anno=dateNow.getYear();
					
					
					LocalDate dataOggi = LocalDate.of(anno, mese, giorno);
					System.out.println("DATA INIZIO LOCALDATE:" +dataOggi);
					
					if(mese==1 || mese==2 || mese==3) {
						dataLimite=LocalDate.of(anno, 04, 25);
						System.out.println("DATA LIMITE SETTATA A: "+dataLimite);
					}
					else if(mese==4 || mese==5 || mese==6) {
						dataLimite=LocalDate.of(anno, 07, 25);
						System.out.println("DATA LIMITE SETTATA A: "+dataLimite);
					}
					else if(mese==7 || mese==8 || mese==9) {
						dataLimite=LocalDate.of(anno, 10, 25);
						System.out.println("DATA LIMITE SETTATA A: "+dataLimite);
					}
					else if(mese==10 || mese==11 || mese==12) {
						dataLimite=LocalDate.of(anno+1, 01, 25);
						System.out.println("DATA LIMITE SETTATA A: "+dataLimite);
					}

    	
    }

	public static void check(Date dataI) throws SQLException {
		
		setDataLimite(dateNow);
	
		String matricola=getMatricolaEmp();
		int numeroFerie=contaFerie(matricola);
		if(numeroFerie == 1 ) {
	    	OKPopUp pop = new OKPopUp("Hai gia' richiesto ferie questo trimestre!");
			pop.setVisible(true);
			
		}
		
		else if(date.before(dataI))
		{
			if(dataI.after(dataPreavviso)) {
				System.out.println("DATA SELEZIONATA:" +dataI);
				String di = simpleDateFormat.format(dataI);
				System.out.println("DATA SELEZIONATA CONVERTITA:" +di);
				
				String[] datai = di.split("-");
				
				int[] dataInt = new int[3]; 
				dataInt[0] = Integer.parseInt(datai[0]);
				dataInt[1] = Integer.parseInt(datai[1]);
				dataInt[2] = Integer.parseInt(datai[2]);
				
				LocalDate dataInizio = LocalDate.of(dataInt[0], dataInt[1], dataInt[2]);
				System.out.println("DATA INIZIO LOCALDATE:" +dataInizio);
				
				LocalDate dataFine = dataInizio.plusDays(6);
				System.out.println("DATA FINE LOCALDATE:" +dataFine);
				
				String dataI1=dataInizio.getDayOfMonth()+"-"+dataInizio.getMonthValue()+"-"+dataInizio.getYear();
				String dataF1=dataFine.getDayOfMonth()+"-"+dataFine.getMonthValue()+"-"+dataFine.getYear();
				
				
				OkCancelPopUp pop = new OkCancelPopUp("Conferma ferie da: "+ dataI1+"   a:  " + dataF1);
				pop.setVisible(true);
				
				if(pop.getFlag()==true) {
					System.out.println("CONFERMATO");
					
					int meseInizio=dataInizio.getMonthValue();
					int meseFine=dataFine.getMonthValue();
					int meseLimite=dataLimite.getMonthValue();
					
					if(meseInizio<=meseLimite && meseFine<meseLimite) {
						
						System.out.println("MESE INIZIO:" + meseInizio);
						System.out.println("MESE FINE:" + meseFine);
						System.out.println("MESE LIMITE:" + meseLimite);
						
						//numero di giorni che lavora
						String[] giornate= giorniLavoro(matricola, dataInizio.toString(), dataFine.toString());
						
						//for che itera l'array giornate
						boolean b=true;
						
						for(int i=0; i<giornate.length; i++) {
							
							String ser=getServizio(matricola, giornate[i]);
							String fasOraria=getFasciaOraria(matricola,giornate[i]);
							
							if(countDipServizi(matricola, ser, fasOraria)==1) {
								b=false;
							}
							
						}
						
						if(b==true) {
							
							//insert
							DBMS database=new DBMS();
							database.insertRichiesta(matricola, "Ferie", dataInizio.toString(), dataFine.toString(), 0, 0, true);
							database.closeConnection();
							
							//delete turno
							DBMS db=new DBMS();
							db.deleteTuplaImp(matricola,dataInizio.toString(),dataFine.toString());
							db.closeConnection();
							
							OKPopUp pop1=new OKPopUp("Richiesta accordata!");
							pop1.setVisible(true);
							
							
						}else {
							OKPopUp pop1=new OKPopUp("Richiesta rigettata: mancanza personale per uno o più giorni indicati");
							pop1.setVisible(true);
						}
						
					}
					else {
						OKPopUp pop1 = new OKPopUp("Puoi richiedere ferie solo per il trimestre corrente!");
						pop1.setVisible(true);
					}
					
				}else {
					System.out.println("NON CONFERMATO");
					OKPopUp pop1 = new OKPopUp("Operazione annullata!");
					pop1.setVisible(true);
				}
				
				
			}
			else {
				OKPopUp pop = new OKPopUp("Errore: Preavviso minimo di 10 giorni!");
				pop.setVisible(true);
			}
			
		}
		else {
			OKPopUp pop = new OKPopUp("Non puoi prendere ferie per giorni passati!");
			pop.setVisible(true);
		}
		
		
		
	}

	//conta se l'impiegato ha preso ferie nel trimestre corrente
	private static int contaFerie(String matricola) throws SQLException {
		DBMS database = new DBMS();
		String sql = "SELECT COUNT(*) FROM Richiesta R WHERE R.ref_matricola='"+matricola+"' AND R.tipo='Ferie'";
				
		ResultSet rs=database.query(sql);
		
		int result=0;
		
		while(rs.next()) {
			result=rs.getInt(1);
		}
		
		database.closeConnection();
			System.out.println(result);
		return result;
		
	}
	
	//ricava la fascia oraria della giornata per la matricola selezionata
	public static String getFasciaOraria(String matricola, String giornata) throws SQLException {
		DBMS database = new DBMS();
		String sql = "SELECT fascia_oraria FROM Turno WHERE ref_i_matricola='"+matricola+"' AND giornata_lavoro = '"+giornata+"'";
				
		ResultSet rs=database.query(sql);
		
		String result="";
		
		while(rs.next()) {
			result=rs.getString(1);
		}
		
		database.closeConnection();
			System.out.println("NOME FASCIA:" + result);
		return result;
	}
	
	//ricava il servizio della giornata per la matricola selezionata
	public static String getServizio(String matricola, String giornata) throws SQLException {
		
		DBMS database = new DBMS();
		String sql = "SELECT servizio FROM Turno WHERE ref_i_matricola='"+matricola+"' AND giornata_lavoro = '"+giornata+"'";
				
		ResultSet rs=database.query(sql);
		
		String result="";
		
		while(rs.next()) {
			result=rs.getString(1);
		}
		
		database.closeConnection();
			System.out.println("NOME SERVIZIO:" + result);
		return result;
		
	}

	//controllo sul numero dei dipendenti per il servizio e la fascia oraria indicata
	private static int countDipServizi(String dataI, String servizio, String fasciaOraria) throws SQLException {

		DBMS database = new DBMS();
		String sql = "SELECT COUNT(*)  FROM Turno  WHERE giornata_lavoro = '"+dataI+"'AND servizio='"+servizio+"' AND fascia_oraria='"+fasciaOraria+"'";
				
		ResultSet rs=database.query(sql);
		
		int result=0;
		
		while(rs.next()) {
			result=rs.getInt(1);
		}
		
		database.closeConnection();
			System.out.println(result-1);
		return result-1;
		
	}

	//ritorna tutti i giorni in cui l'impiegato lavora da dataI a dataF
	public static String[] giorniLavoro(String matricola,String dataI,String dataF) throws SQLException {
		
		DBMS database = new DBMS();
		
		String sql = "SELECT COUNT(*)  FROM Turno  WHERE giornata_lavoro >= '"+dataI+"'AND giornata_lavoro <= '"+dataF+"' AND ref_i_matricola='"+matricola+"'";
		
		ResultSet rs1=database.query(sql);
		
		int count=rs1.getInt(1);
		
		
		String sql2 = "SELECT giornata_lavoro  FROM Turno  WHERE giornata_lavoro >= '"+dataI+"'AND giornata_lavoro <= '"+dataF+"' AND ref_i_matricola='"+matricola+"'";
				
		ResultSet rs=database.query(sql2);
		
		String[] result = new String[count];
		
		int i =0;
		
		while(rs.next()) {

			rs.first();
			do {
				
				result[i]=(rs.getDate(1)).toString();
				i++;
				
			}while(rs.next());
			
		}
		
		database.closeConnection();
			System.out.println(result);
		return result;
		
	}
	
	
	
	
}

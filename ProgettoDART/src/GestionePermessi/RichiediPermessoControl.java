package GestionePermessi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import BoundaryDBMS.DBMS;
import Login.Utente;
import PopUp.OKPopUp;

public class RichiediPermessoControl {

	static Date date = new Date();
	
	 
    static String pattern = "yyyy-MM-dd";
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    static String d = simpleDateFormat.format(date); 

	public static void checkDati(String motivazione, Date dataInizio, Date dataFine,
			String oraI, String oraF, boolean check) throws SQLException {
		
		TrovaSostitutoControl sosControl = new TrovaSostitutoControl();
		Utente u=Utente.getInstance();
		String matricola=u.getMatricola();
		
		if(date.before(dataInizio)) {	//controllo data inizio maggiore alla data odierna
				
			if(dataInizio.before(dataFine) || dataInizio.equals(dataFine)) {	//controllo data inizio minore data fine
				
				int mod=2; //Indica se e' un permesso di entrata posticipata o uscita anticipata
					
				String dInizio = simpleDateFormat.format(dataInizio);
				String dFine = simpleDateFormat.format(dataFine);
				
				System.out.println("Date selezionate accettabili, uguale o piu' grande della finale");
				
				int oraInizio = Integer.parseInt(oraI);
				int oraFine = Integer.parseInt(oraF);
				if(dInizio.equals(dFine)) {				//se date uguali
					
					if(check) {
						System.out.println("Verifica presenza turnazione");
						if(checkTurno(matricola, dFine)) {
							System.out.println("L'impiegato risulta in turnazione alla data indicata");
							
							System.out.println("Dati inseriti hanno superato i controlli:\nMatricola:" + matricola + "\nMotivazione:"+ motivazione + "\nData inizio:" + dInizio
									+"\nData fine:"+ dFine+ "\nOra inizio:" + oraI + "\nOra fine:" + oraF);
							OKPopUp pop = new OKPopUp("Operazione avvenuta con successo!");
							pop.setVisible(true);
							
							//INSERIMENTO DELLA RICHIESTA NEL DATABASE
							DBMS database=new DBMS();
							database.insertRichiesta(matricola, motivazione, dInizio, dFine, oraInizio, oraFine, check);
							
							//RICAVO FASCIA E SERVIZIO RIMASTI SCOPERTI
							String fascia = getFasciaOraria(matricola,dInizio);
							String servizio = getServizio(matricola, dInizio);
							
							//ELIMINAZIONE DELLA TUPLA DEL TURNO DELL'IMPIEGATO
							database.deleteTuplaImp(matricola, dInizio, servizio, fascia);
						
							//TROVA SOSTITUTO
							//IN CASO CONTROLLA E AGGIORNA LO STATO DEL SERVIZIO
							try {
								if(sosControl.cercaSostituto(Integer.parseInt(fascia), LocalDate.parse(dInizio), servizio)) {
									System.out.println("Sostituto trovato");
								}
								else {
									checkStatoServizi(dInizio, servizio,fascia);
								}
							} catch (NumberFormatException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	
							
						}else {		//NO TURNO RILEVATO DAL CONTROLLO
							System.out.println("L'impiegato non risulta in alcuna turnazione nella data indicata");
							OKPopUp pop = new OKPopUp("Nessuna turnazione per la data selezionata");
							pop.setVisible(true);
						}
						
					}else {		//se non si seleziona la checkbox di giornate complete
						
						if(oraInizio>=oraFine) {			//controllo su ora di inizio che sia minore di quella di fine
							if(oraInizio>oraFine) {
								System.out.println("Ora inizio successiva ad ora fine della data selezionata!");
								OKPopUp pop = new OKPopUp("Ora inizio successiva ad ora fine della data selezionata!");
								pop.setVisible(true);
							}else {
								System.out.println("Ora inizio uguale ad ora fine della data selezionata!");
								OKPopUp pop = new OKPopUp("Ora inizio uguale ad ora fine della data selezionata!");
								pop.setVisible(true);
							}
		
						}else {		//ora inizio minore di quella di fine della giornata selezionata(Data inizio e fine coincidono)
							
							if(checkTurno(matricola, dFine)) {
								
							//RICAVO LA FASCIA DEL TURNO PER VERIFICARE SE CONCEDERE PERMESSO SOLO SE PRESENTE UNA TURNAZIONE IN QUELLE ORE
							String fascia = getFasciaOraria(matricola,dInizio);
							String servizio = getServizio(matricola, dInizio);
							int nuovaOraInizio=0, nuovaOraFine=0;
							
							if(fascia.equals("0")) {
								nuovaOraInizio=0; nuovaOraFine=8;
								if(oraInizio==0 && oraFine<=8 || oraInizio>=0 && oraFine==8) {
									
									if(oraInizio==0 && oraFine<=8) {
										
										nuovaOraInizio=oraFine;
										mod=1;
									}else {
										nuovaOraFine=oraInizio;
										mod=0;
									}
									
								}
								else {
									System.out.println("Permesso concesso solo nella fascia di turnazione");
									OKPopUp pop = new OKPopUp("Permesso concesso solo nella fascia di turnazione");
									pop.setVisible(true);
								}
								
							}
							 if (fascia.equals("1")) {
								nuovaOraInizio=8; nuovaOraFine=16;
								if(oraInizio==8 && oraFine<=16 || oraInizio>=8 && oraFine==16) {
									
									if(oraInizio==8 && oraFine<=16) {
										
										nuovaOraInizio=oraFine;
										mod=1;			
									}else {
										nuovaOraFine=oraInizio;
										mod=0;
									}
								}
								else {
									System.out.println("Permesso concesso solo nella fascia di turnazione");
									OKPopUp pop = new OKPopUp("Permesso concesso solo nella fascia di turnazione");
									pop.setVisible(true);
								}
							}
							if(fascia.equals("2")) {
								nuovaOraInizio=16; nuovaOraFine=24;
								if(oraInizio==16 && oraFine<=24 || oraInizio>=16 && oraFine==24) {
									
									if(oraInizio==16 && oraFine<=24) {
										
										nuovaOraInizio=oraFine;
										nuovaOraFine=00;
										mod=1;
									}else {
										nuovaOraFine=oraInizio;
										mod=0;
									}
								}
								else {
									System.out.println("Permesso concesso solo nella fascia di turnazione");
									OKPopUp pop = new OKPopUp("Permesso concesso solo nella fascia di turnazione");
									pop.setVisible(true);
								}
							}
							
							String OraI=Integer.toString(nuovaOraInizio) + ":00:00";
							String OraF=Integer.toString(nuovaOraFine)+ ":00:00";
							
							System.out.println("Nuova ora di inizio del turno: "+OraI);
							System.out.println("Nuova ora di fine del turno  : "+OraF);
							
							DBMS dbms = new DBMS();
							dbms.updateOre(matricola, dFine, OraI, OraF);
							dbms.closeConnection();
							
							//INSERIMENTO SOSTITUTO
							TrovaSostitutoControl.cercaSostitutoPerOreStraordinarie(Integer.parseInt(fascia), LocalDate.parse(dInizio), servizio, oraI, oraF, mod);
							
							//INSERIMENTO DELLA RICHIESTA NEL DATABASE
							DBMS database=new DBMS();
							database.insertRichiesta(matricola, motivazione, dInizio, dFine, oraInizio, oraFine, check);
							
							OKPopUp pop = new OKPopUp("Operazione avvenuta con successo");
							pop.setVisible(true);
							
						}else {				//NO TURNO RILEVATO DAL CONTROLLO
							System.out.println("L'impiegato non risulta in alcuna turnazione nella data indicata");
							OKPopUp pop = new OKPopUp("Nessuna turnazione per la data selezionata");
							pop.setVisible(true);
						}
							
						}
						
					}
					
					
					
				}else {	//date diverse
					
					LocalDate dataI= LocalDate.parse(dInizio);
					LocalDate dataF= LocalDate.parse(dFine);
					
					boolean b=true;
					
					for(LocalDate d=dataI; d.isBefore(dataF.plusDays(1)); d.plusDays(1)) {
						
						if(!(checkTurno(matricola,d.toString()))) {
							b=false;
						}
						
					}
					
					if(b==true) {
						
						for(LocalDate d=dataI; d.isBefore(dataF.plusDays(1)); d.plusDays(1)) {
							
							if(check) {
								System.out.println("Verifica presenza turnazione");
								if(checkTurno(matricola, d.toString())) {
									System.out.println("L'impiegato risulta in turnazione alla data indicata");
									
									System.out.println("Dati inseriti hanno superato i controlli:\nMatricola:" + matricola + "\nMotivazione:"+ motivazione + "\nData inizio:" + dInizio
											+"\nData fine:"+ dFine+ "\nOra inizio:" + oraI + "\nOra fine:" + oraF);
									OKPopUp pop = new OKPopUp("Operazione avvenuta con successo!");
									pop.setVisible(true);
									
									DBMS database=new DBMS();
									if(d.equals(dataF)) {
									//INSERIMENTO DELLA RICHIESTA NEL DATABASE
									database.insertRichiesta(matricola, motivazione, dInizio, dFine, oraInizio, oraFine, check);
									}
									
									//RICAVO FASCIA E SERVIZIO RIMASTI SCOPERTI
									String fascia = getFasciaOraria(matricola,d.toString());
									String servizio = getServizio(matricola, d.toString());
									
									//ELIMINAZIONE DELLA TUPLA DEL TURNO DELL'IMPIEGATO
									database.deleteTuplaImp(matricola, d.toString(), servizio, fascia);
								
									//TROVA SOSTITUTO
									
									
									//CONTROLLA E AGGIORNA LO STATO DEI SERVIZI
									try {
										if(sosControl.cercaSostituto(Integer.parseInt(fascia), d, servizio)) {
											
										}
										else {
											checkStatoServizi(d.toString(), servizio,fascia);
										}
									} catch (NumberFormatException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

									
								}else {		//NO TURNO RILEVATO DAL CONTROLLO
									System.out.println("L'impiegato non risulta in alcuna turnazione nella data indicata");
									OKPopUp pop = new OKPopUp("Nessuna turnazione per la data selezionata");
									pop.setVisible(true);
								}
								
							}else {		//se non si seleziona la checkbox di giornate complete
								
								if(oraInizio>=oraFine) {			//controllo su ora di inizio che sia minore di quella di fine
									if(oraInizio>oraFine) {
										System.out.println("Ora inizio successiva ad ora fine della data selezionata!");
										OKPopUp pop = new OKPopUp("Ora inizio successiva ad ora fine della data selezionata!");
										pop.setVisible(true);
									}else {
										System.out.println("Ora inizio uguale ad ora fine della data selezionata!");
										OKPopUp pop = new OKPopUp("Ora inizio uguale ad ora fine della data selezionata!");
										pop.setVisible(true);
									}
				
								}else {		//ora inizio minore di quella di fine della giornata selezionata(Data inizio e fine coincidono)
									
									if(checkTurno(matricola, d.toString())) {
										
									//RICAVO LA FASCIA DEL TURNO PER VERIFICARE SE CONCEDERE PERMESSO SOLO SE PRESENTE UNA TURNAZIONE IN QUELLE ORE
									String fascia = getFasciaOraria(matricola,d.toString());
									int nuovaOraInizio=0, nuovaOraFine=0;
									
									if(fascia.equals(0)) {
										nuovaOraInizio=0; nuovaOraFine=8;
										if(oraInizio==0 && oraFine<=8 || oraInizio>=0 && oraFine==8) {
											
											if(oraInizio==0 && oraFine<=8) {
												
												nuovaOraInizio=oraFine;
												
											}else {
												nuovaOraFine=oraInizio;
											}
											
										}
										else {
											System.out.println("Permesso concesso solo nella fascia di turnazione");
											OKPopUp pop = new OKPopUp("Permesso concesso solo nella fascia di turnazione");
											pop.setVisible(true);
										}
										
									}
									else if (fascia.equals(1)) {
										nuovaOraInizio=8; nuovaOraFine=16;
										if(oraInizio==8 && oraFine<=16 || oraInizio>=8 && oraFine==16) {
											
											if(oraInizio==8 && oraFine<=16) {
												
												nuovaOraInizio=oraFine;
												
											}else {
												nuovaOraFine=oraInizio;
											}
										}
										else {
											System.out.println("Permesso concesso solo nella fascia di turnazione");
											OKPopUp pop = new OKPopUp("Permesso concesso solo nella fascia di turnazione");
											pop.setVisible(true);
										}
									}
									else if(fascia.equals(2)) {
										nuovaOraInizio=16; nuovaOraFine=24;
										if(oraInizio==16 && oraFine<=24 || oraInizio>=16 && oraFine==24) {
											
											if(oraInizio==16 && oraFine<=24) {
												
												nuovaOraInizio=oraFine;
												nuovaOraFine=00;
												
											}else {
												nuovaOraFine=oraInizio;
											}
										}
										else {
											System.out.println("Permesso concesso solo nella fascia di turnazione");
											OKPopUp pop = new OKPopUp("Permesso concesso solo nella fascia di turnazione");
											pop.setVisible(true);
										}
									}
									
									String OraI=Integer.toString(nuovaOraInizio) + ":00:00";
									String OraF=Integer.toString(nuovaOraFine)+ ":00:00";
									
									DBMS dbms = new DBMS();
									dbms.updateOre(matricola, d.toString(), OraI, OraF);
									dbms.closeConnection();
									
									//trova sostituto per range di ore--> ore straordinare da impiegato prima o dopo
									
									//INSERIMENTO DELLA RICHIESTA NEL DATABASE
									if(d.equals(dataF)) {
									DBMS database=new DBMS();
									database.insertRichiesta(matricola, motivazione, dInizio, dFine, oraInizio, oraFine, check);
									OKPopUp pop = new OKPopUp("Operazione avvenuta con successo");
									pop.setVisible(true);
									}
									
								}else {				//NO TURNO RILEVATO DAL CONTROLLO
									System.out.println("L'impiegato non risulta in alcuna turnazione nella data indicata");
									OKPopUp pop = new OKPopUp("Nessuna turnazione per la data selezionata");
									pop.setVisible(true);
								}
									
								}
								
							}
							
						}
						
					}
					else {
						OKPopUp pop = new OKPopUp("Turno non presente per alcune giornate selezionate");
						pop.setVisible(true);
					}
	
				}
		
			}
			if(dataInizio.after(dataFine)) {		//data inizio dopo data fine
				OKPopUp pop = new OKPopUp("Data di inizio successiva alla data di fine!!");
				pop.setVisible(true);
			}
		
		}else {		//data inizio precedente o uguale a oggi
			OKPopUp pop = new OKPopUp("Data inizio precedente o uguale a oggi");
			pop.setVisible(true);
		}
		
	}

	
	//torna true quando turno presente, false se assente
	private static boolean checkTurno(String matricola, String dFine) throws SQLException {
		DBMS database = new DBMS();
		String sql = "SELECT COUNT(*) FROM Turno WHERE giornata_lavoro ='"+dFine+"' AND ref_i_matricola='"+matricola+"'";
				
		ResultSet rs=database.query(sql);
		
		boolean result=false;
		
		while(rs.next()) {
			int t=rs.getInt(1);
			if(t==1) {
				result=true;
			}
		}
		
		database.closeConnection();
			System.out.println("TURNO PRESENTE=1, TURNO ASSENTE=0, TURNO:" + result);
		return result;
		
	}

	//recupera la fascia oraria del turno dell'impiegato
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
	
	//recupera il servizio del turno dell'impiegato
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
	
	//check stato dei servizi
	public static void checkStatoServizi(String data, String servizio, String fascia) throws SQLException {
		
		DBMS dbms = new DBMS();
		
		String sql = "select count(*) from Turno where giornata_lavoro = '" + data + "' and servizio = '"+servizio+"' and fascia_oraria = '"+ fascia +"'";
		int res = 0;
		ResultSet rs = dbms.query(sql);
		if(rs.next()) {
			res = rs.getInt(1);
		}
		System.out.println(res);
		if(res == 0) {
			System.out.println("si");
			dbms.updateStato(data, servizio, fascia);
		}
		
		dbms.closeConnection();
		
	}
	
	
	
}
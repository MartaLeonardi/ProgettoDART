package GestioneStipendi;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BoundaryDBMS.DBMS;

public class StipendiControl {
	
	public JTable createTable() {
		JTable table = new JTable();
		DefaultTableModel dtm = new DefaultTableModel(0, 0);
		
		String header[] = new String[] {
				"Matricola", "Data pagamento", "Importo"};
		
		dtm.setColumnIdentifiers(header);
		table.setModel(dtm);
		
		DBMS db = new DBMS();
		
		//String sql = "select count(*) from Impiegato";
		
		//ResultSet rs = db.query(sql);
		//String numImpiegati = "";
		//try {
			//if(rs.next()) {
				//numImpiegati = rs.getString(1);
			//}
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		
		String sql2 = "select * from Stipendio order by dataPagamento";
		
		ResultSet rs2 = db.query(sql2);
		
		
		
		//System.out.println(numImpiegati);
		
		
		try {
			while(rs2.next()) {
				
				try {
					dtm.addRow(new Object[] { rs2.getString(1), rs2.getDate(2), rs2.getInt(3)});
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return table;
	}

}

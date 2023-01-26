package GestioneStipendi;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BoundaryDBMS.DBMS;

public class StipendioControl {
	
	public JTable createTable(String matricola) throws SQLException {
		
		JTable table = new JTable();
		DefaultTableModel dtm = new DefaultTableModel(0, 0);
		
		String header[] = new String[] {
				"Matricola", "Data pagamento", "Importo"
				};
		
		dtm.setColumnIdentifiers(header);
		table.setModel(dtm);
		
		DBMS db = new DBMS();
		
		/*String sql = "select count(*) from Stipendio where ref_S_matricola = '"+ matricola +"'";
		
		ResultSet rs = db.query(sql);
		String numStipendi = "";
		try {
			if(rs.next()) {
				numStipendi = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		String sql2 = "select * from Stipendio where ref_S_matricola = '"+ matricola +"'";
		
		ResultSet rs2 = db.query(sql2);
		
		
		
		while(rs2.next()) {
			
			try {
				dtm.addRow(new Object[] { rs2.getString(1), rs2.getDate(2), rs2.getInt(3)});
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return table;
	}
}

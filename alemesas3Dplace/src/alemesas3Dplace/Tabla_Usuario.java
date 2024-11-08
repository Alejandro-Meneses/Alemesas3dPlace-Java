package alemesas3Dplace;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Color;

public class Tabla_Usuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private Connection cn;
	private DefaultTableModel tableModel;

	/**
	 * Create the panel.
	 */
	public Tabla_Usuario(Connection cn) {
		this.cn=cn;
		setLayout(new BorderLayout());
		
		 JPanel gb = new JPanel();
		    gb.setBackground(new Color(0, 129, 186));
		    add(gb, BorderLayout.CENTER);
		    gb.setLayout(new BorderLayout());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 5, 777, 437);
		scrollPane.setFont(new Font("Roboto Black", Font.BOLD, 13));
		scrollPane.setBorder(null);
		gb.add(scrollPane);
		
		tableModel = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	                "ID", "Usuario", "Contraseña", "Correo_Electronico", "País", "Ciudad", "Dirección", "Fecha_Creacion"
	            }
	        );
	        table = new JTable(tableModel);
	        table.setFont(new Font("Roboto Black", Font.BOLD, 15));
	        
	        JTableHeader header = table.getTableHeader();
	        header.setBackground(new Color(70, 130, 180)); // Cambia el color de fondo del encabezado
	        header.setForeground(Color.WHITE); // Cambia el color del texto del encabezado
	        header.setFont(new Font("Roboto Black", Font.BOLD, 16)); // Cambia la fuente del encabezado

	        TableCellRenderer rendererFromHeader = header.getDefaultRenderer();
	        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) rendererFromHeader;
	        renderer.setHorizontalAlignment(JLabel.CENTER);
	        scrollPane.setViewportView(table);
	    }

	    /**
	     * Load data from database into the table.
	     */
	    public void loadData(Connection cn) {
	        try {
	            Statement statement = cn.createStatement();
	            String sql = "SELECT * FROM usuarios";
	            ResultSet rs = statement.executeQuery(sql);

	            while (rs.next()) {
	                Object[] row = new Object[8];
	                row[0] = rs.getInt("ID");
	                row[1] = rs.getString("Usuario");
	                row[2] = rs.getString("Contraseña");
	                row[3] = rs.getString("Correo_electronico");
	                row[4] = rs.getString("Pais");
	                row[5] = rs.getString("Ciudad");
	                row[6] = rs.getString("Direccion");
	                row[7] = rs.getDate("Fecha_Creacion");
	                tableModel.addRow(row);
	            }
	            rs.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

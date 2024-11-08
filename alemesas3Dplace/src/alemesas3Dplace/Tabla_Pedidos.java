package alemesas3Dplace;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tabla_Pedidos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private Connection cn;
	private DefaultTableModel tableModel;
	private boolean orden;

	/**
	 * Create the panel.
	 */
	public Tabla_Pedidos(Connection cn) {
		this.cn=cn;
		setLayout(new BorderLayout());
		
		 JPanel gb = new JPanel();
		    gb.setBackground(new Color(0, 129, 186));
		    add(gb, BorderLayout.CENTER);
		gb.setLayout(null);
		
		JPanel Panel_Mod_Pedido = new JPanel();
		Panel_Mod_Pedido.setBackground(new Color(1, 22, 49));
		Panel_Mod_Pedido.setBounds(34, 378, 231, 45);
		gb.add(Panel_Mod_Pedido);
		
		JLabel lblVerMasDetalles = new JLabel("Ver Mas detalles");
		lblVerMasDetalles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!orden) {
		            Cargartablad();
		        } else {
		            Cargartabla(cn);
		        }
		        orden = !orden;
		    }
			
		});
		lblVerMasDetalles.setHorizontalTextPosition(SwingConstants.CENTER);
		lblVerMasDetalles.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerMasDetalles.setForeground(Color.WHITE);
		lblVerMasDetalles.setFont(new Font("Roboto Black", Font.BOLD, 25));
		Panel_Mod_Pedido.add(lblVerMasDetalles);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 797, 351);
		scrollPane.setFont(new Font("Roboto Black", Font.BOLD, 13));
		scrollPane.setBorder(null);
		gb.add(scrollPane);
		
		tableModel = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	                "ID_pedido", "Nombre_pedido", "Fecha_Envio", "Estado", "Precio", "Dirección_del_pedido", "Metodo_Pago", "id_Cliente", "Cantidad", "Notas"
	            }
	        );
	        table = new JTable(tableModel);
	        table.setFont(new Font("Roboto Black", Font.BOLD, 15));
	        
	        JTableHeader header = table.getTableHeader();
	        header.setBackground(new Color(70, 130, 180)); 
	        header.setForeground(Color.WHITE); 
	        header.setFont(new Font("Roboto Black", Font.BOLD, 16)); 

	        TableCellRenderer rendererFromHeader = header.getDefaultRenderer();
	        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) rendererFromHeader;
	        renderer.setHorizontalAlignment(JLabel.CENTER);
	        scrollPane.setViewportView(table);
	        
	        JLabel lblNewLabel = new JLabel("New label");
	        lblNewLabel.setIcon(new ImageIcon(Tabla_Pedidos.class.getResource("/imagenes/imagen_2024-05-24_024020329.png")));
	        lblNewLabel.setBounds(0, 0, 797, 520);
	        gb.add(lblNewLabel);
	    }

	
	    public void Cargartabla(Connection cn) {
	    	boolean autenticar=main.admin(Inicio_sesion.getUsuario(),Inicio_sesion.getContraseña());
	    	if (autenticar) {
	        try {

	        	 tableModel.setRowCount(0); 
	 	        tableModel.setColumnIdentifiers(new String[] {
	                "ID_pedido", "Nombre_pedido", "Fecha_Envio", "Estado", "Precio", "Dirección_del_pedido", "Metodo_Pago", "id_Cliente", "Cantidad", "Notas"
	            });

	            Statement statement = cn.createStatement();
	            String sql = "SELECT * FROM pedidos";
	            ResultSet rs = statement.executeQuery(sql);

	            while (rs.next()) {
	                Object[] row = new Object[10];
	                row[0] = rs.getInt("ID_pedido");
	                row[1] = rs.getString("Nombre_Pedido");
	                row[2] = rs.getDate("Fecha_envio");
	                row[3] = rs.getString("Estado");
	                row[4] = rs.getInt("Precio");
	                row[5] = rs.getString("Direccion_del_pedido");
	                row[6] = rs.getString("Metodo_pago");
	                row[7] = rs.getInt("id_cliente");
	                row[8] = rs.getInt("Cantidad");
	                row[9] = rs.getString("Notas");
	                tableModel.addRow(row);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }}else {
	        	 try {

		        	 tableModel.setRowCount(0); 
		 	        tableModel.setColumnIdentifiers(new String[] {
		                "ID_pedido", "Nombre_pedido", "Fecha_Envio", "Estado", "Precio", "Dirección_del_pedido", "Metodo_Pago", "id_Cliente", "Cantidad", "Notas"
		            });
		 	       String Usuario=Inicio_sesion.getUsuario();
		            String sql = "SELECT * FROM pedidos WHERE id_cliente = (SELECT id FROM usuarios WHERE Usuario = ?);";
		            PreparedStatement statement = cn.prepareStatement(sql);
					statement.setString(1, Usuario);

		            ResultSet rs = statement.executeQuery();

		            while (rs.next()) {
		                Object[] row = new Object[10];
		                row[0] = rs.getInt("ID_pedido");
		                row[1] = rs.getString("Nombre_Pedido");
		                row[2] = rs.getDate("Fecha_envio");
		                row[3] = rs.getString("Estado");
		                row[4] = rs.getInt("Precio");
		                row[5] = rs.getString("Direccion_del_pedido");
		                row[6] = rs.getString("Metodo_pago");
		                row[7] = rs.getInt("id_cliente");
		                row[8] = rs.getInt("Cantidad");
		                row[9] = rs.getString("Notas");
		                tableModel.addRow(row);
		            }
		            rs.close();
		            statement.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
	        }
	    }
	    public void Cargartablau(Connection cn) {
	        try {
	        	String Usuario=Inicio_sesion.getUsuario();
	            String sql = "SELECT * FROM pedidos WHERE id_cliente = (SELECT id FROM usuarios WHERE Usuario = ?);";
	            PreparedStatement statement = cn.prepareStatement(sql);
				statement.setString(1, Usuario);

	            ResultSet rs = statement.executeQuery();

	            while (rs.next()) {
	                Object[] row = new Object[10];
	                row[0] = rs.getInt("ID_pedido");
	                row[1] = rs.getString("Nombre_Pedido");
	                row[2] = rs.getDate("Fecha_envio");
	                row[3] = rs.getString("Estado");
	                row[4] = rs.getInt("Precio");
	                row[5] = rs.getString("Direccion_del_pedido");
	                row[6] = rs.getString("Metodo_pago");
	                row[7] = rs.getInt("id_cliente");
	                row[8] = rs.getInt("Cantidad");
	                row[9] = rs.getString("Notas");
	                tableModel.addRow(row);
	            }
	            rs.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public void Cargartablad() {
	    	boolean autenticar=main.admin(Inicio_sesion.getUsuario(),Inicio_sesion.getContraseña());
	    	if (autenticar) {
	    	tableModel.setRowCount(0); 
	        tableModel.setColumnIdentifiers(new String[]{"ID_pedido", "Color", "Material", "Pintado", "Terminado"});
	        
	        try {
	            String sql = "SELECT * FROM detalle_pedido";
	            Statement statement = cn.createStatement();
	            ResultSet rs = statement.executeQuery(sql);

	            while (rs.next()) {
	                Object[] row = new Object[5];
	                row[0] = rs.getInt("ID_pedido");
	                row[1] = rs.getString("Color");
	                row[2] = rs.getString("Material");
	                row[3] = rs.getString("Pintado");
	                row[4] = rs.getString("Terminado");
	                tableModel.addRow(row);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        }else {tableModel.setRowCount(0); 
	        tableModel.setColumnIdentifiers(new String[]{"ID_pedido", "Color", "Material", "Pintado", "Terminado"});
	        
	        try {
	        	String sql = "SELECT detalle_pedido.* FROM detalle_pedido INNER JOIN pedidos ON detalle_pedido.id_pedido = pedidos.id_pedido INNER JOIN usuarios ON pedidos.id_cliente = usuarios.id WHERE usuarios.usuario = ?";
	            PreparedStatement statement = cn.prepareStatement(sql);
	            statement.setString(1, Inicio_sesion.getUsuario());
	            ResultSet rs = statement.executeQuery();

	            while (rs.next()) {
	                Object[] row = new Object[5];
	                row[0] = rs.getInt("ID_pedido");
	                row[1] = rs.getString("Color");
	                row[2] = rs.getString("Material");
	                row[3] = rs.getString("Pintado");
	                row[4] = rs.getString("Terminado");
	                tableModel.addRow(row);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        	
	        }
	    }
	}

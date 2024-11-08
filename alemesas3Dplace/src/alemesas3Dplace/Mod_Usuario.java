package alemesas3Dplace;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;

public class Mod_Usuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private int id;
	private Connection cn;
	private String Usuario;
	private String Contraseña;
	private String Fecha_Creacion;
	private int Correo_Electronico;
	private String Direccion;
	private String Pais;
	private String Ciudad;

	public static int solicitarNumeroDeUsuario() {
		while (true) {
			String input = JOptionPane.showInputDialog(null, "Ingrese el número de Usuario:");

			try {
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Entrada no válida. Por favor, ingrese un número entero.");
			}
		}
	}

	// Constructor de la clase
	public Mod_Usuario(Connection cn, int id) {
		this.cn = cn;
		this.id = id;
		initialize();
	}

	// Método para inicializar el panel
	private void initialize() {
		setBackground(new Color(128, 128, 192));
		setLayout(null);

		JPanel bg = new JPanel();
		bg.setLayout(null);
		bg.setBackground(new Color(134, 150, 207));
		bg.setBounds(0, 0, 797, 507);
		add(bg);

		JPanel panel_1_1_4 = new JPanel();
		panel_1_1_4.setLayout(null);
		panel_1_1_4.setOpaque(false);
		panel_1_1_4.setBounds(293, 168, 195, 85);
		bg.add(panel_1_1_4);

		JLabel lblNewLabel_2_4 = new JLabel("Ciudad:");
		lblNewLabel_2_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_4.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblNewLabel_2_4.setBounds(10, 10, 76, 21);
		panel_1_1_4.add(lblNewLabel_2_4);

		JFormattedTextField Ciudad_1 = new JFormattedTextField();
		Ciudad_1.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		Ciudad_1.setBounds(10, 30, 161, 28);
		panel_1_1_4.add(Ciudad_1);

		JSeparator separator_1_4 = new JSeparator();
		separator_1_4.setBounds(10, 68, 161, 2);
		panel_1_1_4.add(separator_1_4);

		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setOpaque(false);
		panel_1_1_1_1.setBounds(293, 73, 195, 85);
		bg.add(panel_1_1_1_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Contraseña:");
		lblNewLabel_2_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_1.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblNewLabel_2_1_1.setBounds(10, 10, 122, 21);
		panel_1_1_1_1.add(lblNewLabel_2_1_1);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 68, 161, 2);
		panel_1_1_1_1.add(separator_1_1_1);

		
		JPasswordField Contraseña_1 = new JPasswordField();
		Contraseña_1.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		Contraseña_1.setBounds(10, 30, 161, 28);
		panel_1_1_1_1.add(Contraseña_1);

		JPanel panel_1_1_5 = new JPanel();
		panel_1_1_5.setLayout(null);
		panel_1_1_5.setOpaque(false);
		panel_1_1_5.setBounds(515, 73, 234, 85);
		bg.add(panel_1_1_5);

		JLabel lblNewLabel_2_5 = new JLabel("Dirección:");
		lblNewLabel_2_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_5.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblNewLabel_2_5.setBounds(10, 10, 182, 21);
		panel_1_1_5.add(lblNewLabel_2_5);

		JFormattedTextField Direccion_1 = new JFormattedTextField();
		Direccion_1.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		Direccion_1.setBounds(10, 30, 182, 28);
		panel_1_1_5.add(Direccion_1);

		JSeparator separator_1_5 = new JSeparator();
		separator_1_5.setBounds(10, 68, 182, 2);
		panel_1_1_5.add(separator_1_5);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setOpaque(false);
		panel_1_1.setBounds(74, 168, 195, 85);
		bg.add(panel_1_1);

		JLabel lblNewLabel_2 = new JLabel("Pais:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(10, 10, 76, 21);
		panel_1_1.add(lblNewLabel_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 68, 161, 2);
		panel_1_1.add(separator_1);

		
		JFormattedTextField Pais_1 = new JFormattedTextField();
		Pais_1.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		Pais_1.setBounds(10, 30, 161, 28);
		panel_1_1.add(Pais_1);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		panel_1.setBounds(74, 73, 195, 85);
		bg.add(panel_1);

		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 10, 144, 21);
		panel_1.add(lblNewLabel);

		JFormattedTextField Usuario = new JFormattedTextField();
		Usuario.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		Usuario.setBounds(10, 30, 161, 28);
		panel_1.add(Usuario);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 68, 161, 2);
		panel_1.add(separator);

		JLabel lblNewLabel_1 = new JLabel("Editar Usuario con id" + id + ":");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Roboto Black", Font.BOLD, 36));
		lblNewLabel_1.setBounds(72, 10, 652, 41);
		bg.add(lblNewLabel_1);

		JPanel panel_1_1_5_1 = new JPanel();
		panel_1_1_5_1.setLayout(null);
		panel_1_1_5_1.setOpaque(false);
		panel_1_1_5_1.setBounds(71, 265, 234, 85);
		bg.add(panel_1_1_5_1);

		JLabel lblNewLabel_2_5_1 = new JLabel("Fecha_Creacion:");
		lblNewLabel_2_5_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_5_1.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblNewLabel_2_5_1.setBounds(10, 10, 137, 21);
		panel_1_1_5_1.add(lblNewLabel_2_5_1);

		JSeparator separator_1_5_1 = new JSeparator();
		separator_1_5_1.setBounds(10, 68, 161, 2);
		panel_1_1_5_1.add(separator_1_5_1);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(10, 31, 161, 29);
		panel_1_1_5_1.add(dateChooser);
		
		JPanel panel_1_1_4_1 = new JPanel();
		panel_1_1_4_1.setLayout(null);
		panel_1_1_4_1.setOpaque(false);
		panel_1_1_4_1.setBounds(515, 168, 234, 85);
		bg.add(panel_1_1_4_1);
		
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Correo Electronico:");
		lblNewLabel_2_4_1.setForeground(Color.WHITE);
		lblNewLabel_2_4_1.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblNewLabel_2_4_1.setBounds(10, 10, 161, 21);
		panel_1_1_4_1.add(lblNewLabel_2_4_1);
		
		JFormattedTextField Correo = new JFormattedTextField();
		Correo.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		Correo.setBounds(10, 30, 179, 28);
		panel_1_1_4_1.add(Correo);
		
		JSeparator separator_1_4_1 = new JSeparator();
		separator_1_4_1.setBounds(10, 68, 179, 2);
		panel_1_1_4_1.add(separator_1_4_1);

		JPanel Panel_Mod_Pedido_1 = new JPanel();
		Panel_Mod_Pedido_1.setBackground(new Color(1, 22, 49));
		Panel_Mod_Pedido_1.setBounds(518, 360, 231, 45);
		bg.add(Panel_Mod_Pedido_1);
		Panel_Mod_Pedido_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Panel_Mod_Pedido_1.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				Panel_Mod_Pedido_1.setBackground(new Color(1, 22, 49));
			}

			public void mouseEntered(MouseEvent e) {
				Panel_Mod_Pedido_1.setBackground(new Color(41, 94, 150));
			}

			public void mouseClicked(MouseEvent e) {
				try {
					String sql = "Delete from usuarios where id= ?";
					PreparedStatement st = cn.prepareStatement(sql);
					st.setInt(1, id);
					int funciona = st.executeUpdate();
					if (funciona > 0) {
						JOptionPane.showMessageDialog(null, "El Usuario ha sido borrado");
					} else {
						JOptionPane.showMessageDialog(null, "El Usuario no se ha podido borrar", "Error",
								JOptionPane.ERROR_MESSAGE);

					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		JLabel lblBorrarPedido = new JLabel("Borrar Usuario");
		lblBorrarPedido.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBorrarPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrarPedido.setForeground(Color.WHITE);
		lblBorrarPedido.setFont(new Font("Roboto Black", Font.BOLD, 25));
		Panel_Mod_Pedido_1.add(lblBorrarPedido);

		JPanel Panel_Mod_Pedido = new JPanel();
		Panel_Mod_Pedido.setBackground(new Color(1, 22, 49));
		Panel_Mod_Pedido.setBounds(74, 360, 231, 45);
		bg.add(Panel_Mod_Pedido);
		Panel_Mod_Pedido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Panel_Mod_Pedido.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				Panel_Mod_Pedido.setBackground(new Color(1, 22, 49));
			}

			public void mouseEntered(MouseEvent e) {
				Panel_Mod_Pedido.setBackground(new Color(41, 94, 150));
			}

			public void mouseClicked(MouseEvent e) {
				int musuario = 0;
				try {

					if (Usuario.getText() != null && !Usuario.getText().isEmpty()) {
						String sqlUsuario = "UPDATE usuarios SET Usuario = ? WHERE ID = ?";
						PreparedStatement stUsuario = cn.prepareStatement(sqlUsuario);
						stUsuario.setString(1, Usuario.getText());
						stUsuario.setInt(2, id);
						musuario = musuario + stUsuario.executeUpdate();
					}

					if (String.valueOf(Contraseña_1.getPassword()) != null && !String.valueOf(Contraseña_1.getPassword()).isEmpty()) {
						String sqlContraseña = "UPDATE usuarios SET Contraseña = ? WHERE id = ?";
						PreparedStatement stContraseña = cn.prepareStatement(sqlContraseña);
						stContraseña.setString(1,String.valueOf(Contraseña_1.getPassword()));
						stContraseña.setInt(2, id);
						musuario = musuario + stContraseña.executeUpdate();
					}

					if (Ciudad_1.getText() != null && !Ciudad_1.getText().isEmpty()) {
						String sqlCiudad = "UPDATE usuarios SET Ciudad = ? WHERE id = ?";
						PreparedStatement stCiudad = cn.prepareStatement(sqlCiudad);
						stCiudad.setString(1, Ciudad_1.getText());
						stCiudad.setInt(2, id);
						musuario = musuario + stCiudad.executeUpdate();
					}
					if (Pais_1.getText() != null && !Pais_1.getText().isEmpty()) {
						String sqlPais = "UPDATE usuarios SET Pais = ? WHERE id = ?";
						PreparedStatement stPais = cn.prepareStatement(sqlPais);
						stPais.setString(1, Pais_1.getText());
						stPais.setInt(2, id);
						musuario = musuario + stPais.executeUpdate();
					}

					if (Direccion_1.getText() != null && !Direccion_1.getText().isEmpty()) {
						String sqlDireccionUsuario = "UPDATE usuarios SET Direccion= ? WHERE Id = ?";
						PreparedStatement stDireccionUsuario = cn.prepareStatement(sqlDireccionUsuario);
						stDireccionUsuario.setString(1, Direccion_1.getText());
						stDireccionUsuario.setInt(2, id);
						musuario = musuario + stDireccionUsuario.executeUpdate();
					}
					if (Correo.getText() != null && !Correo.getText().isEmpty()) {
						String sqlCorreo = "UPDATE Usuarios SET Correo_Electronico= ? WHERE Id = ?";
						PreparedStatement stCorreo = cn.prepareStatement(sqlCorreo);
						stCorreo.setString(1, Correo.getText());
						stCorreo.setInt(2, id);
						musuario = musuario + stCorreo.executeUpdate();
					}

					if (dateChooser.getDate() != null) {
						String sqlFecha = "UPDATE usuarios SET Fecha_Creacion = ? WHERE id = ?";
						PreparedStatement stFecha = cn.prepareStatement(sqlFecha);
						stFecha.setDate(1, new java.sql.Date(dateChooser.getDate().getTime()));
						stFecha.setInt(2, id);
						musuario = musuario + stFecha.executeUpdate();
					}
					if (musuario > 0) {
						JOptionPane.showMessageDialog(null, "El Usuario ha sido actualizado");
					} else {
						JOptionPane.showMessageDialog(null, "El Usuario no ha sido actualizado", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					}


				catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		JLabel lblModificar = new JLabel("Modificar");
		lblModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setForeground(Color.WHITE);
		lblModificar.setFont(new Font("Roboto Black", Font.BOLD, 25));
		Panel_Mod_Pedido.add(lblModificar);
		
		
		

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Mod_Usuario.class.getResource("/imagenes/imagen_2024-05-24_024020329.png")));
		lblNewLabel_6.setBounds(0, 0, 797, 507);
		bg.add(lblNewLabel_6);
	}

	public static void main(String[] args) {
		try {
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/alemesas3dplace", "root", "");
//           
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

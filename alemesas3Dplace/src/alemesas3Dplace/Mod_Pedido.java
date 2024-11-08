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

public class Mod_Pedido extends JPanel {

	private static final long serialVersionUID = 1L;
	private int id_pedido;
	private Connection cn;
	private String Nombre_Pedido;
	private String Fecha_Envio;
	private String Estado;
	private int Precio;
	private int funciona;

	public static int solicitarNumeroDePedido() {
		while (true) {
			String input = JOptionPane.showInputDialog(null, "Ingrese el número de pedido:");

			try {
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Entrada no válida. Por favor, ingrese un número entero.");
			}
		}
	}

	public Mod_Pedido(Connection cn, int id_pedido) {
		this.cn = cn;
		this.id_pedido = id_pedido;
		initialize();
	}

	private void initialize() {
		setBackground(new Color(128, 128, 192));
		setLayout(null);

		JPanel bg = new JPanel();
		bg.setLayout(null);
		bg.setBackground(new Color(134, 150, 207));
		bg.setBounds(0, 0, 797, 507);
		add(bg);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setOpaque(false);
		panel_1_2.setBounds(293, 263, 254, 114);
		bg.add(panel_1_2);

		JLabel lblNewLabel_3 = new JLabel("Notas:");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(10, 10, 76, 21);
		panel_1_2.add(lblNewLabel_3);

		JFormattedTextField Notas = new JFormattedTextField();
		Notas.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		Notas.setBounds(10, 30, 221, 64);
		panel_1_2.add(Notas);

		JPanel panel_1_1_4 = new JPanel();
		panel_1_1_4.setLayout(null);
		panel_1_1_4.setOpaque(false);
		panel_1_1_4.setBounds(293, 168, 195, 85);
		bg.add(panel_1_1_4);

		JLabel lblNewLabel_2_4 = new JLabel("Cantidad:");
		lblNewLabel_2_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_4.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblNewLabel_2_4.setBounds(10, 10, 76, 21);
		panel_1_1_4.add(lblNewLabel_2_4);

		JFormattedTextField Cantidad = new JFormattedTextField();
		Cantidad.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		Cantidad.setBounds(10, 30, 161, 28);
		panel_1_1_4.add(Cantidad);

		JSeparator separator_1_4 = new JSeparator();
		separator_1_4.setBounds(10, 68, 161, 2);
		panel_1_1_4.add(separator_1_4);

		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setOpaque(false);
		panel_1_1_1_1.setBounds(293, 73, 195, 85);
		bg.add(panel_1_1_1_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Metodo_Pago:");
		lblNewLabel_2_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_1.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblNewLabel_2_1_1.setBounds(10, 10, 122, 21);
		panel_1_1_1_1.add(lblNewLabel_2_1_1);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 68, 161, 2);
		panel_1_1_1_1.add(separator_1_1_1);

		String[] metodop = { "", "Paypal", "Tarjeta de Credito", "Transferencia Bancaria", "A mano" };
		JComboBox<String> metodo_pago = new JComboBox<>(metodop);
		metodo_pago.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		metodo_pago.setBounds(10, 30, 175, 28);
		panel_1_1_1_1.add(metodo_pago);

		JPanel panel_1_1_5 = new JPanel();
		panel_1_1_5.setLayout(null);
		panel_1_1_5.setOpaque(false);
		panel_1_1_5.setBounds(515, 73, 234, 85);
		bg.add(panel_1_1_5);

		JLabel lblNewLabel_2_5 = new JLabel("Dirección_del_Pedido:");
		lblNewLabel_2_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_5.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblNewLabel_2_5.setBounds(10, 10, 182, 21);
		panel_1_1_5.add(lblNewLabel_2_5);

		JFormattedTextField Direccion_del_pedido = new JFormattedTextField();
		Direccion_del_pedido.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		Direccion_del_pedido.setBounds(10, 30, 161, 28);
		panel_1_1_5.add(Direccion_del_pedido);

		JSeparator separator_1_5 = new JSeparator();
		separator_1_5.setBounds(10, 68, 161, 2);
		panel_1_1_5.add(separator_1_5);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setOpaque(false);
		panel_1_1_1.setBounds(74, 263, 195, 85);
		bg.add(panel_1_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("Precio:");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(10, 10, 76, 21);
		panel_1_1_1.add(lblNewLabel_2_1);

		JFormattedTextField Precio_1 = new JFormattedTextField();
		Precio_1.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		Precio_1.setBounds(10, 30, 161, 28);
		panel_1_1_1.add(Precio_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 68, 161, 2);
		panel_1_1_1.add(separator_1_1);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setOpaque(false);
		panel_1_1.setBounds(74, 168, 195, 85);
		bg.add(panel_1_1);

		JLabel lblNewLabel_2 = new JLabel("Estado:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(10, 10, 76, 21);
		panel_1_1.add(lblNewLabel_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 68, 161, 2);
		panel_1_1.add(separator_1);

		String[] Estadop = { "", "Preparando", "En Camino", "Entregado", "Problema" };
		JComboBox<String> Estado_1 = new JComboBox<>(Estadop);
		Estado_1.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		Estado_1.setBounds(10, 27, 161, 31);
		panel_1_1.add(Estado_1);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		panel_1.setBounds(74, 73, 195, 85);
		bg.add(panel_1);

		JLabel lblNewLabel = new JLabel("Nombre_Pedido:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 10, 144, 21);
		panel_1.add(lblNewLabel);

		JFormattedTextField Nombre_Pedido_1 = new JFormattedTextField();
		Nombre_Pedido_1.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		Nombre_Pedido_1.setBounds(10, 30, 161, 28);
		panel_1.add(Nombre_Pedido_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 68, 161, 2);
		panel_1.add(separator);

		JLabel lblNewLabel_1 = new JLabel("Editar pedido con id " + id_pedido + ":");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Roboto Black", Font.BOLD, 36));
		lblNewLabel_1.setBounds(72, 10, 652, 41);
		bg.add(lblNewLabel_1);

		JPanel panel_1_1_5_1 = new JPanel();
		panel_1_1_5_1.setLayout(null);
		panel_1_1_5_1.setOpaque(false);
		panel_1_1_5_1.setBounds(515, 164, 234, 85);
		bg.add(panel_1_1_5_1);

		JLabel lblNewLabel_2_5_1 = new JLabel("Fecha_Envio:");
		lblNewLabel_2_5_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_5_1.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblNewLabel_2_5_1.setBounds(10, 10, 118, 21);
		panel_1_1_5_1.add(lblNewLabel_2_5_1);

		JSeparator separator_1_5_1 = new JSeparator();
		separator_1_5_1.setBounds(10, 68, 161, 2);
		panel_1_1_5_1.add(separator_1_5_1);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(10, 31, 161, 29);
		panel_1_1_5_1.add(dateChooser);

		JPanel Panel_Mod_Pedido_1 = new JPanel();
		Panel_Mod_Pedido_1.setBackground(new Color(1, 22, 49));
		Panel_Mod_Pedido_1.setBounds(518, 409, 231, 45);
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
					String sql = "Delete from pedidos where id_pedido= ?; ";
					PreparedStatement st = cn.prepareStatement(sql);
					st.setInt(1, id_pedido);
					String sql2 = "Delete from detalle_pedido where id_pedido = ?;";
					PreparedStatement st2 = cn.prepareStatement(sql2);
					st2.setInt(1, id_pedido);
					funciona =  st2.executeUpdate();
					funciona = funciona + st.executeUpdate();
					if (funciona > 1) {
						JOptionPane.showMessageDialog(null, "El pedido y sus detalles han sido borrados");
					} else {
						JOptionPane.showMessageDialog(null, "El pedido no se ha podido borrar", "Error",
								JOptionPane.ERROR_MESSAGE);

					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		JLabel lblBorrarPedido = new JLabel("Borrar Pedido");
		lblBorrarPedido.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBorrarPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrarPedido.setForeground(Color.WHITE);
		lblBorrarPedido.setFont(new Font("Roboto Black", Font.BOLD, 25));
		Panel_Mod_Pedido_1.add(lblBorrarPedido);

		JPanel Panel_Mod_Pedido = new JPanel();
		Panel_Mod_Pedido.setBackground(new Color(1, 22, 49));
		Panel_Mod_Pedido.setBounds(74, 409, 231, 45);
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
				int mpedido = 0;
				try {

					if (Nombre_Pedido_1.getText() != null && !Nombre_Pedido_1.getText().isEmpty()) {
						String sqlNombrePedido = "UPDATE pedidos SET Nombre_Pedido = ? WHERE Id_pedido = ?";
						PreparedStatement stNombrePedido = cn.prepareStatement(sqlNombrePedido);
						stNombrePedido.setString(1, Nombre_Pedido_1.getText());
						stNombrePedido.setInt(2, id_pedido);
						mpedido = mpedido + stNombrePedido.executeUpdate();
					}

					if ((String) Estado_1.getSelectedItem() != ("")) {
						String sqlEstado = "UPDATE pedidos SET Estado = ? WHERE Id_pedido = ?";
						PreparedStatement stEstado = cn.prepareStatement(sqlEstado);
						stEstado.setString(1, (String) Estado_1.getSelectedItem());
						stEstado.setInt(2, id_pedido);
						mpedido = mpedido + stEstado.executeUpdate();
					}

					if ((String) metodo_pago.getSelectedItem() != ("")) {
						String sqlMetodoPago = "UPDATE pedidos SET Metodo_Pago = ? WHERE Id_pedido = ?";
						PreparedStatement stMetodoPago = cn.prepareStatement(sqlMetodoPago);
						stMetodoPago.setString(1, (String) metodo_pago.getSelectedItem());
						stMetodoPago.setInt(2, id_pedido);
						mpedido = mpedido + stMetodoPago.executeUpdate();
					}

					if (Direccion_del_pedido.getText() != null && !Direccion_del_pedido.getText().isEmpty()) {
						String sqlDireccionPedido = "UPDATE pedidos SET Direccion_del_pedido = ? WHERE Id_pedido = ?";
						PreparedStatement stDireccionPedido = cn.prepareStatement(sqlDireccionPedido);
						stDireccionPedido.setString(1, Direccion_del_pedido.getText());
						stDireccionPedido.setInt(2, id_pedido);
						mpedido = mpedido + stDireccionPedido.executeUpdate();
					}

					if (dateChooser.getDate() != null) {
						String sqlFechaEnvio = "UPDATE pedidos SET Fecha_envio = ? WHERE Id_pedido = ?";
						PreparedStatement stFechaEnvio = cn.prepareStatement(sqlFechaEnvio);
						stFechaEnvio.setDate(1, new java.sql.Date(dateChooser.getDate().getTime()));
						stFechaEnvio.setInt(2, id_pedido);
						mpedido = mpedido + stFechaEnvio.executeUpdate();
					}

					if (Precio_1.getText() != null && !Precio_1.getText().isEmpty()) {
						try {
							int precio = Integer.parseInt(Precio_1.getText());
							if (precio < 0) {
								JOptionPane.showMessageDialog(null, "El precio no puede ser negativo.", "Error",
										JOptionPane.ERROR_MESSAGE);
							} else {
								String sqlPrecio = "UPDATE pedidos SET Precio = ? WHERE Id_pedido = ?";
								PreparedStatement stPrecio = cn.prepareStatement(sqlPrecio);
								stPrecio.setInt(1, precio);
								stPrecio.setInt(2, id_pedido);
								mpedido = mpedido + stPrecio.executeUpdate();
							}
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido para el precio.",
									"Error", JOptionPane.ERROR_MESSAGE);

						}

						if (Cantidad.getText() != null && !Cantidad.getText().isEmpty()) {
							try {
								int cantidad = Integer.parseInt(Cantidad.getText());
								if (cantidad < 0) {
									JOptionPane.showMessageDialog(null, "La cantidad no puede ser negativa.", "Error",JOptionPane.ERROR_MESSAGE);
								} else {
									String sqlCantidad = "UPDATE pedidos SET Cantidad = ? WHERE Id_pedido = ?";
									PreparedStatement stCantidad = cn.prepareStatement(sqlCantidad);
									stCantidad.setInt(1, cantidad);
									stCantidad.setInt(2, id_pedido);
									mpedido = mpedido + stCantidad.executeUpdate();
								}
							} catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog(null,
										"Ingrese un valor numérico válido para la cantidad.", "Error",
										JOptionPane.ERROR_MESSAGE);
							}
						}

						if (Notas.getText() != null && !Notas.getText().isEmpty()) {
							String sqlNotas = "UPDATE pedidos SET Notas = ? WHERE Id_pedido = ?";
							PreparedStatement stNotas = cn.prepareStatement(sqlNotas);
							stNotas.setString(1, Notas.getText());
							stNotas.setInt(2, id_pedido);
							mpedido = mpedido + stNotas.executeUpdate();
						}
						if (mpedido > 0) {
							JOptionPane.showMessageDialog(null, "El pedido ha sido actualizado");
						} else {
							JOptionPane.showMessageDialog(null, "El pedido no ha sido actualizado", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
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
		lblNewLabel_6.setIcon(new ImageIcon(Mod_Pedido.class.getResource("/imagenes/imagen_2024-05-24_024020329.png")));
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

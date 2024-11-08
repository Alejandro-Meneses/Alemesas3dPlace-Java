package alemesas3Dplace;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;

public class HacerPedido extends JPanel {

	private static final long serialVersionUID = 1L;
	private int id_pedido;
	private Connection cn;
	private String Nombre_Pedido;
	private String Fecha_Envio;
	private String Estado;
	private int Precio;
	private File Archivo3d;
	private String notas;

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

	// Constructor de la clase
	public HacerPedido(Connection cn, int id_pedido) {
		this.cn = cn;
		this.id_pedido = id_pedido;
		initialize();
	}

	private void GuardarArchivo(File file) throws IOException {
		String Direccion = "src/archivos3d";
		File targetDirectory = new File(Direccion);

		if (!targetDirectory.exists()) {
			targetDirectory.mkdirs();
		}

		Path targetPath = new File(targetDirectory, file.getName()).toPath();

		Files.copy(file.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);

	}

	private void initialize() {
		setBackground(new Color(128, 128, 192));
		setLayout(null);

		JPanel bg = new JPanel();
		bg.setLayout(null);
		bg.setBackground(new Color(134, 150, 207));
		bg.setBounds(0, 0, 797, 507);
		add(bg);

		JPanel panel_1_1_4_2_1 = new JPanel();
		panel_1_1_4_2_1.setLayout(null);
		panel_1_1_4_2_1.setOpaque(false);
		panel_1_1_4_2_1.setBounds(293, 263, 195, 85);
		bg.add(panel_1_1_4_2_1);

		JLabel lblNewLabel_2_4_2_1 = new JLabel("Material:");
		lblNewLabel_2_4_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_4_2_1.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblNewLabel_2_4_2_1.setBounds(10, 10, 76, 21);
		panel_1_1_4_2_1.add(lblNewLabel_2_4_2_1);

		JSeparator separator_1_4_2_1 = new JSeparator();
		separator_1_4_2_1.setBounds(10, 68, 161, 2);
		panel_1_1_4_2_1.add(separator_1_4_2_1);
		String[] materiales = { "", "Resina", "PLA" };

		JComboBox<String> Material = new JComboBox<String>(materiales);
		Material.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		Material.setBounds(10, 30, 175, 28);
		panel_1_1_4_2_1.add(Material);

		JPanel panel_1_1_4_2 = new JPanel();
		panel_1_1_4_2.setLayout(null);
		panel_1_1_4_2.setOpaque(false);
		panel_1_1_4_2.setBounds(74, 263, 195, 85);
		bg.add(panel_1_1_4_2);

		JLabel lblNewLabel_2_4_2 = new JLabel("Color:");
		lblNewLabel_2_4_2.setForeground(Color.WHITE);
		lblNewLabel_2_4_2.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblNewLabel_2_4_2.setBounds(10, 10, 76, 21);
		panel_1_1_4_2.add(lblNewLabel_2_4_2);

		JFormattedTextField Colorr = new JFormattedTextField();
		Colorr.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		Colorr.setBounds(10, 30, 161, 28);
		panel_1_1_4_2.add(Colorr);

		JSeparator separator_1_4_2 = new JSeparator();
		separator_1_4_2.setBounds(10, 68, 161, 2);
		panel_1_1_4_2.add(separator_1_4_2);

		JPanel panel_1_1_1_2 = new JPanel();
		panel_1_1_1_2.setBounds(515, 168, 195, 85);
		bg.add(panel_1_1_1_2);
		panel_1_1_1_2.setLayout(null);
		panel_1_1_1_2.setOpaque(false);

		JLabel lblNewLabel_2_1_2 = new JLabel("Subir Archivo * :");
		lblNewLabel_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_2.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblNewLabel_2_1_2.setBounds(10, 10, 146, 21);
		panel_1_1_1_2.add(lblNewLabel_2_1_2);

		JSeparator separator_1_1_2 = new JSeparator();
		separator_1_1_2.setBounds(10, 68, 161, 2);
		panel_1_1_1_2.add(separator_1_1_2);

		JButton Archivo = new JButton("Selecciona");
		Archivo.setBounds(10, 29, 161, 33);
		Archivo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					Archivo3d = fileChooser.getSelectedFile();

				}
			}
		});
		panel_1_1_1_2.add(Archivo);

		JPanel panel_1_1_4_1 = new JPanel();
		panel_1_1_4_1.setLayout(null);
		panel_1_1_4_1.setOpaque(false);
		panel_1_1_4_1.setBounds(293, 168, 195, 85);
		bg.add(panel_1_1_4_1);

		JLabel lblNewLabel_2_4_1 = new JLabel("Altura en cm:");
		lblNewLabel_2_4_1.setForeground(Color.WHITE);
		lblNewLabel_2_4_1.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblNewLabel_2_4_1.setBounds(10, 10, 115, 21);
		panel_1_1_4_1.add(lblNewLabel_2_4_1);

		JFormattedTextField Altura = new JFormattedTextField();
		Altura.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		Altura.setBounds(10, 30, 161, 28);
		panel_1_1_4_1.add(Altura);

		JSeparator separator_1_4_1 = new JSeparator();
		separator_1_4_1.setBounds(10, 68, 161, 2);
		panel_1_1_4_1.add(separator_1_4_1);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setOpaque(false);
		panel_1_2.setBounds(495, 263, 254, 114);
		bg.add(panel_1_2);

		JLabel lblNewLabel_3 = new JLabel("Notas *:");
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
		panel_1_1_4.setBounds(74, 168, 195, 85);
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

		String[] Estadop = { "", "Preparando", "En Camino", "Entregado", "Problema" };

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

		JLabel lblNewLabel_1 = new JLabel("Que Pedido quieres hacer?");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Roboto Black", Font.BOLD, 36));
		lblNewLabel_1.setBounds(72, 10, 652, 41);
		bg.add(lblNewLabel_1);

		JPanel Panel_Mod_Pedido = new JPanel();
		Panel_Mod_Pedido.setBackground(new Color(1, 22, 49));
		Panel_Mod_Pedido.setBounds(518, 416, 231, 45);
		bg.add(Panel_Mod_Pedido);
		Panel_Mod_Pedido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Panel_Mod_Pedido.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				Panel_Mod_Pedido.setBackground(new Color(1, 22, 49));
			}

			public void mouseEntered(MouseEvent e) {
				Panel_Mod_Pedido.setBackground(new Color(41, 94, 150));
			}

			public void comprobacioni() {
				int cantidad = Integer.parseInt(Cantidad.getText());
				if (Nombre_Pedido_1.getText() != null && !Nombre_Pedido_1.getText().isEmpty()
						&& (String) metodo_pago.getSelectedItem() != ("") && Direccion_del_pedido.getText() != null
						&& !Direccion_del_pedido.getText().isEmpty() && Cantidad.getText() != null
						&& !Cantidad.getText().isEmpty() && cantidad > 0
						&& (String) Material.getSelectedItem() != ("")) {
				}
				if (cantidad < 0) {
					JOptionPane.showMessageDialog(null, "La cantidad no puede ser negativa.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						String sql = "Insert Into Pedidos(Nombre_Pedido,Precio,Fecha_envio,Estado,Fecha_Llegada,Notas,Direccion_del_pedido,Metodo_pago,cantidad,id_cliente) VALUES (?,?,DATE_ADD(CURDATE(), INTERVAL 7 DAY),'Preparando',DATE_ADD(CURDATE(), INTERVAL 14 DAY),?,?,?,?,(SELECT id from usuarios where usuario=?))";
						double precio = 0;
						double altura = Integer.parseInt(Altura.getText());
						int cantidaad = Integer.parseInt(Cantidad.getText());
						if ((String) Material.getSelectedItem()==("Resina")) {
							precio = ((altura / 5) * 5) * cantidaad ;
						} else if ((String) Material.getSelectedItem()==("PLA")) {
							precio = ((altura / 5) * 3) * cantidaad;
						}
						if (Notas.getText() == null && Notas.getText().isEmpty()) {
							notas = "";
						} else {
							notas = Notas.getText();
						}
						PreparedStatement stPedido = cn.prepareStatement(sql);
						stPedido.setString(1, Nombre_Pedido_1.getText());
						stPedido.setDouble(2, Math.ceil(precio));
						stPedido.setString(3, notas);
						stPedido.setString(4, Direccion_del_pedido.getText());
						stPedido.setString(5, (String) metodo_pago.getSelectedItem());
						stPedido.setInt(6, cantidaad);
						stPedido.setString(7, Inicio_sesion.getUsuario());
						int ejecutado = stPedido.executeUpdate();
						if (ejecutado > 0) {
							 int response = JOptionPane.showConfirmDialog(null,"El coste sera "+ Math.ceil(precio)+ "€","Confirmar Pedido", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

						        if (response == JOptionPane.YES_OPTION) {
						        	JOptionPane.showMessageDialog(null,
						        			"El pedido Pasara por revision le enviaremos un correo con la informacion de si ha sido aceptado");
						        	String sql2 = "Insert Into detalle_pedido(id_pedido,Color,Material,Pintado,Terminado) VALUES((Select MAX(id_pedido) from pedidos),?,?,'No','Sin empezar')";
						        	PreparedStatement stPedidod = cn.prepareStatement(sql2);
						        	stPedidod.setString(1, Colorr.getText());
						        	stPedidod.setString(2, (String) Material.getSelectedItem());
						        	stPedidod.executeUpdate();
						        	GuardarArchivo(Archivo3d);
						        }
						}
					} catch (IOException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "El pedido no se ha podido mandar por un error ");
					} catch (SQLException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "El pedido no se ha podido mandar por un error");
					}

				}
			}

			public void mouseClicked(MouseEvent e) {
				comprobacioni();

			}
		}

		);

		JLabel lblModificar = new JLabel("Calcular Precio");
		lblModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setForeground(Color.WHITE);
		lblModificar.setFont(new Font("Roboto Black", Font.BOLD, 25));
		Panel_Mod_Pedido.add(lblModificar);

		JLabel lblNewLabel_3_1 = new JLabel("* Opcional");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(74, 429, 195, 32);
		bg.add(lblNewLabel_3_1);

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

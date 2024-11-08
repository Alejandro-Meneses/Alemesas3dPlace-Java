package alemesas3Dplace;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.KeyboardFocusManager;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Toolkit;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Component;
import java.awt.Point;
import java.awt.ComponentOrientation;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField Contraseña;
	private String usuario;
	private String contraseña;
	private String correo;
	private String pais;
	private String ciudad;
	private String direccion;
	private Connection cn;
	private static boolean registra=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/alemesas3dplace", "root",
							"");
					Registro frame = new Registro(cn);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void comprobacionr() {
		try {
			if (usuario.length() <= 25) {
//			System.out.println("La contraseña necesaria para el inicio de sesion");
//			String contraseñar = sc.next();
//			System.out.println("Pais donde reside");
//			String pais = sc.next();
//			System.out.println("Ciudad donde reside");
//			String ciudad = sc.next();
//			System.out.println("Una direccion de entrega para los pedidos");
//			String direccion = sc.next();
				String sql = "SELECT * FROM usuarios WHERE Usuario = ? OR Correo_electronico = ?";
				PreparedStatement statement = this.cn.prepareStatement(sql);
				statement.setString(1, usuario);
				statement.setString(2, contraseña);
				ResultSet rs = statement.executeQuery();

				if (rs.next()) {
					JOptionPane.showInternalMessageDialog(null, "Ya existe este usuario o correo, deberia cambiarlo",
							"Error", JOptionPane.OK_CANCEL_OPTION);
					registra = false;
				} else {
					String sql2 = "INSERT INTO usuarios(Usuario,Contraseña,Correo_electronico,Direccion,Pais,Ciudad,Fecha_creacion) VALUES(?,?,?,?,?,?,Current_date)";

					PreparedStatement insertstatement = this.cn.prepareStatement(sql2);
					insertstatement.setString(1, usuario);
					insertstatement.setString(2, contraseña);
					insertstatement.setString(3, correo);
					insertstatement.setString(4, direccion);
					insertstatement.setString(5, pais);
					insertstatement.setString(6, ciudad);

					int filasInsertadas = insertstatement.executeUpdate();
					registra = true;
				}
			} else {
				JOptionPane.showInternalMessageDialog(null, "El usuario tiene mas de 25 caracteres", "Error",
						JOptionPane.OK_CANCEL_OPTION);
				JOptionPane.showInternalMessageDialog(null, "Vuelve a intentarlo", "Error",
						JOptionPane.OK_CANCEL_OPTION);
				registra = false;
			}

		} catch (SQLException e2) {
			System.out.println("No se ha podido conectar con la base de datos");
			System.out.println("O ha habido algun fallo en la consulta");
		}
	}

	/**
	 * Create the frame.
	 * 
	 * @param cn2
	 */
	public Registro(Connection cn) {
		this.cn = cn;
		setTitle("Inicio Sesión- Alemesas3Dplace");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Registro.class.getResource("/imagenes/Logo Alemesas3D.png")));
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				requestFocus(); // Establece el foco en el JFrame
			}
		});

		JPanel bg = new JPanel();
		bg.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		bg.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		bg.setBackground(new Color(238, 255, 255));
		bg.setBounds(0, -40, 800, 540);
		contentPane.add(bg);
		bg.setLayout(null);

		JLabel NOMBRE = new JLabel("Alemesas3DPlace");
		NOMBRE.setForeground(new Color(192, 192, 192));
		NOMBRE.setFont(new Font("Vladimir Script", Font.PLAIN, 29));
		NOMBRE.setBounds(19, 281, 206, 66);
		bg.add(NOMBRE);

		JLabel LOGO = new JLabel("");
		LOGO.setHorizontalAlignment(SwingConstants.CENTER);
		LOGO.setIcon(new ImageIcon(Registro.class.getResource("/imagenes/Logo Alemesas3D.png")));
		LOGO.setBounds(-12, 114, 251, 93);
		bg.add(LOGO);

		JLabel Inicio = new JLabel("REGISTRO");
		Inicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		Inicio.setFont(new Font("Roboto", Font.BOLD, 24));
		Inicio.setBounds(262, 45, 175, 74);
		bg.add(Inicio);

		JLabel Fondo = new JLabel("New label");
		Fondo.setIcon(new ImageIcon(Registro.class.getResource("/imagenes/Fondo Estrellado Inicio.png")));
		Fondo.setBounds(-2, 23, 241, 517);
		bg.add(Fondo);

		JLabel Titulo_usuario = new JLabel("USUARIO");
		Titulo_usuario.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo_usuario.setFont(new Font("Roboto", Font.BOLD, 19));
		Titulo_usuario.setBounds(249, 114, 110, 43);
		bg.add(Titulo_usuario);

		JFormattedTextField Usuario = new JFormattedTextField();
		Usuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Usuario.getText().equals("Nombre de Usuario")) {
					Usuario.setText("");
					Usuario.setForeground(Color.black);
				}
				if (Usuario.getText().isEmpty()) {
					Usuario.setText("");
					Usuario.setForeground(Color.black);
				}

			}

		});

		Usuario.setBorder(null);
		Usuario.setBackground(new Color(238, 255, 255));
		Usuario.setForeground(new Color(192, 192, 192));
		Usuario.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		Usuario.setText("Nombre de Usuario");
		Usuario.setBounds(262, 154, 181, 22);
		bg.add(Usuario);

		JSeparator separator = new JSeparator();
		separator.setBounds(new Rectangle(0, 0, 4, 4));
		separator.setPreferredSize(new Dimension(0, 5));
		separator.setSize(new Dimension(5, 0));
		separator.setBounds(262, 185, 159, 22);
		bg.add(separator);

		JLabel Titulo_Contraseña = new JLabel("CONTRASEÑA");
		Titulo_Contraseña.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo_Contraseña.setFont(new Font("Roboto", Font.BOLD, 19));
		Titulo_Contraseña.setBounds(249, 220, 147, 43);
		bg.add(Titulo_Contraseña);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(262, 285, 159, 22);
		bg.add(separator_1);

		Contraseña = new JPasswordField();
		Contraseña.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Contraseña.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				if (String.valueOf(Contraseña.getPassword()).equals("Aqui tu con")) {
					Contraseña.setText("");
					Contraseña.setForeground(Color.black);
				}

			}
		});
		Contraseña.setBorder(null);
		Contraseña.setForeground(new Color(192, 192, 192));
		Contraseña.setCaretColor(new Color(192, 192, 192));
		Contraseña.setBackground(new Color(238, 255, 255));
		Contraseña.setText("Aqui tu con");
		Contraseña.setBounds(262, 255, 217, 28);
		bg.add(Contraseña);

		JPanel panelcierre = new JPanel();
		panelcierre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelcierre.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				panelcierre.setBackground(new Color(215, 255, 255));

			}

			public void mouseExited(MouseEvent e) {
				panelcierre.setBackground(new Color(243, 255, 255));
			}

			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		panelcierre.setBackground(new Color(243, 255, 255));
		panelcierre.setBounds(727, 45, 63, 57);
		bg.add(panelcierre);

		JLabel Cierre = new JLabel("X");
		Cierre.setFont(new Font("Roboto Black", Font.PLAIN, 39));
		Cierre.setBackground(new Color(238, 255, 255));
		panelcierre.add(Cierre);
		Cierre.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				panelcierre.setBackground(new Color(215, 255, 255));

			}

			public void mouseExited(MouseEvent e) {
				panelcierre.setBackground(new Color(243, 255, 255));
			}

			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		Cierre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(new Color(0, 181, 181));
		panel.setBounds(596, 458, 175, 51);
		bg.add(panel);

		JLabel Correo = new JLabel("CORREO ELECTRONICO");
		Correo.setHorizontalAlignment(SwingConstants.CENTER);
		Correo.setFont(new Font("Roboto", Font.BOLD, 19));
		Correo.setBounds(467, 114, 230, 43);
		bg.add(Correo);

		JFormattedTextField Correo_1 = new JFormattedTextField();
		Correo_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (Correo_1.getText().equals("Correo Electronico")) {
					Correo_1.setText("");
					Correo_1.setForeground(Color.black);

				}
			}
		});
		Correo_1.setText("Correo Electronico");
		Correo_1.setForeground(Color.LIGHT_GRAY);
		Correo_1.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		Correo_1.setBorder(null);
		Correo_1.setBackground(new Color(238, 255, 255));
		Correo_1.setBounds(480, 154, 181, 22);
		bg.add(Correo_1);

		JSeparator Seperador_Correo = new JSeparator();
		Seperador_Correo.setSize(new Dimension(5, 0));
		Seperador_Correo.setPreferredSize(new Dimension(0, 5));
		Seperador_Correo.setBounds(new Rectangle(0, 0, 4, 4));
		Seperador_Correo.setBounds(480, 185, 217, 22);
		bg.add(Seperador_Correo);

		JLabel Pais = new JLabel("PAÍS");
		Pais.setHorizontalAlignment(SwingConstants.CENTER);
		Pais.setFont(new Font("Roboto", Font.BOLD, 19));
		Pais.setBounds(455, 220, 84, 43);
		bg.add(Pais);

		JFormattedTextField Pais_1 = new JFormattedTextField();
		Pais_1.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (Pais_1.getText().equals("País")) {
					Pais_1.setText("");
					Pais_1.setForeground(Color.black);

				}

			}
		});
		Pais_1.setText("País");
		Pais_1.setForeground(Color.LIGHT_GRAY);
		Pais_1.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		Pais_1.setBorder(null);
		Pais_1.setBackground(new Color(238, 255, 255));
		Pais_1.setBounds(480, 259, 181, 22);
		bg.add(Pais_1);

		JSeparator Separador_Pais = new JSeparator();
		Separador_Pais.setSize(new Dimension(5, 0));
		Separador_Pais.setPreferredSize(new Dimension(0, 5));
		Separador_Pais.setBounds(new Rectangle(0, 0, 4, 4));
		Separador_Pais.setBounds(480, 285, 159, 22);
		bg.add(Separador_Pais);

		JLabel Ciudad = new JLabel("CIUDAD");
		Ciudad.setHorizontalAlignment(SwingConstants.CENTER);
		Ciudad.setFont(new Font("Roboto", Font.BOLD, 19));
		Ciudad.setBounds(249, 306, 97, 43);
		bg.add(Ciudad);

		JFormattedTextField Ciudad_1 = new JFormattedTextField();
		Ciudad_1.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (Ciudad_1.getText().equals("Ciudad")) {
					Ciudad_1.setText("");
					Ciudad_1.setForeground(Color.black);

				}
			}
		});
		Ciudad_1.setText("Ciudad");
		Ciudad_1.setForeground(Color.LIGHT_GRAY);
		Ciudad_1.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		Ciudad_1.setBorder(null);
		Ciudad_1.setBackground(new Color(238, 255, 255));
		Ciudad_1.setBounds(262, 346, 181, 22);
		bg.add(Ciudad_1);

		JSeparator Separador_Ciudad = new JSeparator();
		Separador_Ciudad.setSize(new Dimension(5, 0));
		Separador_Ciudad.setPreferredSize(new Dimension(0, 5));
		Separador_Ciudad.setBounds(new Rectangle(0, 0, 4, 4));
		Separador_Ciudad.setBounds(262, 377, 159, 22);
		bg.add(Separador_Ciudad);

		JLabel Dirección = new JLabel("Dirección");
		Dirección.setHorizontalAlignment(SwingConstants.CENTER);
		Dirección.setFont(new Font("Roboto", Font.BOLD, 19));
		Dirección.setBounds(467, 306, 110, 43);
		bg.add(Dirección);

		JFormattedTextField Direccion_1 = new JFormattedTextField();
		Direccion_1.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (Direccion_1.getText().equals("Dirección")) {
					Direccion_1.setText("");
					Direccion_1.setForeground(Color.black);

				}

			}
		});
		Direccion_1.setText("Dirección");
		Direccion_1.setForeground(Color.LIGHT_GRAY);
		Direccion_1.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		Direccion_1.setBorder(null);
		Direccion_1.setBackground(new Color(238, 255, 255));
		Direccion_1.setBounds(480, 346, 181, 22);
		bg.add(Direccion_1);

		JSeparator Separador_Dirección = new JSeparator();
		Separador_Dirección.setSize(new Dimension(5, 0));
		Separador_Dirección.setPreferredSize(new Dimension(0, 5));
		Separador_Dirección.setBounds(new Rectangle(0, 0, 4, 4));
		Separador_Dirección.setBounds(480, 377, 159, 22);
		bg.add(Separador_Dirección);
		JLabel lblNewLabel = new JLabel("REGISTRO");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setForeground(Color.black);
				panel.setBackground(new Color(215, 255, 255));
			}

			public void mouseExited(MouseEvent e) {
				lblNewLabel.setForeground(Color.white);
				panel.setBackground(new Color(0, 181, 181));
			}

			public void mouseClicked(MouseEvent e) {
				if (!registra) {
					usuario = Usuario.getText();
					contraseña = String.valueOf(Contraseña.getPassword());
					correo = Correo_1.getText();
					ciudad = Ciudad_1.getText();
					pais = Pais_1.getText();
					direccion = Direccion_1.getText();
					comprobacionr();
				} else {
					Inicio_sesion iniciosesion = new Inicio_sesion(cn);
					iniciosesion.setVisible(true);
					
					dispose();
				}
			}
		});
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 19));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		panel.add(lblNewLabel, gbc);
		
		JPanel Atras = new JPanel();
		Atras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Atras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Inicio_sesion iniciosesion = new Inicio_sesion(cn);
				iniciosesion.setVisible(true);
				
				dispose();
			}
			public void mouseEntered(MouseEvent e) {
				Atras.setBackground(new Color(215, 255, 255));

			}

			public void mouseExited(MouseEvent e) {
				Atras.setBackground(new Color(243, 255, 255));
			}
		});
		Atras.setBackground(new Color(243, 255, 255));
		Atras.setBounds(654, 45, 63, 57);
		bg.add(Atras);
		
		JLabel Atras_1 = new JLabel("");
		Atras_1.setIcon(new ImageIcon(Registro.class.getResource("/imagenes/Flecha Atras.png")));
		Atras_1.setFont(new Font("Arial", Font.PLAIN, 39));
		Atras_1.setBackground(new Color(238, 255, 255));
		Atras.add(Atras_1);

	}

	public String getUsuario() {
		return usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public static boolean isRegistra( ) {
		return registra;
	}

	public void setRegistra(boolean registra) {
		this.registra = registra;
	}
}

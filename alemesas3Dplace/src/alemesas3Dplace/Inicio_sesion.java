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

public class Inicio_sesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField Contraseña;
	private static String usuario;
	private static String contraseña;
	private Connection cn;
	private static boolean inicio;
	private static boolean VENTANA = false;

	public void setContraseña(JPasswordField contraseña) {
		Contraseña = contraseña;
	}

	public static void setUsuario(String usuario) {
		Inicio_sesion.usuario = usuario;
	}

	public static void setContraseña(String contraseña) {
		Inicio_sesion.contraseña = contraseña;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Establecer conexión a la base de datos
					Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/alemesas3dplace", "root",
							"");
					Inicio_sesion frame = new Inicio_sesion(cn);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		});
	}

	public void comprobacion() {
		try {
			String sql = "SELECT * FROM usuarios WHERE Usuario = ? AND Contraseña = ?";
			PreparedStatement statement = this.cn.prepareStatement(sql);
			statement.setString(1, usuario);
			statement.setString(2, contraseña);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				JOptionPane.showInternalMessageDialog(null, "Inicio de sesion correcto");
				inicio = true;
				dispose();
			} else {
				JOptionPane.showInternalMessageDialog(null, "Inicio de sesion incorrecto", "Error",
						JOptionPane.OK_CANCEL_OPTION);
				JOptionPane.showInternalMessageDialog(null, "Vuelve a intentarlo", "Error",
						JOptionPane.OK_CANCEL_OPTION);
				inicio = false;
			}
		} catch (SQLException e2) {
			System.out.println("No se ha podido conectar con la base de datos");
			System.out.println("O ha habido algun fallo en la consulta");
		}

	}

	
	public Inicio_sesion(Connection cn) {
		setUndecorated(true);
		this.cn = cn;
		setTitle("Inicio Sesión- Alemesas3Dplace");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Inicio_sesion.class.getResource("/imagenes/Logo Alemesas3d.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 499);
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
		bg.setBounds(0, -15, 721, 529);
		contentPane.add(bg);
		bg.setLayout(null);

		JLabel NOMBRE = new JLabel("Alemesas3DPlace");
		NOMBRE.setForeground(new Color(192, 192, 192));
		NOMBRE.setFont(new Font("Vladimir Script", Font.PLAIN, 29));
		NOMBRE.setBounds(19, 281, 192, 57);
		bg.add(NOMBRE);

		JLabel LOGO = new JLabel("");
		LOGO.setHorizontalAlignment(SwingConstants.CENTER);
		LOGO.setIcon(new ImageIcon(Inicio_sesion.class.getResource("/imagenes/Logo Alemesas3D.png")));
		LOGO.setBounds(-12, 114, 251, 93);
		bg.add(LOGO);

		JLabel Inicio = new JLabel("INICIO SESIÓN");
		Inicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		Inicio.setFont(new Font("Roboto", Font.BOLD, 24));
		Inicio.setBounds(279, 114, 175, 74);
		bg.add(Inicio);

		JLabel Fondo = new JLabel("New label");
		Fondo.setIcon(new ImageIcon(Inicio_sesion.class.getResource("/imagenes/Fondo Estrellado Inicio.png")));
		Fondo.setBounds(-2, 10, 241, 509);
		bg.add(Fondo);

		JLabel Titulo_usuario = new JLabel("USUARIO");
		Titulo_usuario.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo_usuario.setFont(new Font("Roboto", Font.BOLD, 19));
		Titulo_usuario.setBounds(221, 176, 203, 74);
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
				if (String.valueOf(Contraseña.getPassword()).isEmpty()) {
					Contraseña.setText("Aqui tu con");
					Contraseña.setForeground(Color.gray);
				}
			}

		});

		Usuario.setBorder(null);
		Usuario.setBackground(new Color(238, 255, 255));
		Usuario.setForeground(new Color(192, 192, 192));
		Usuario.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		Usuario.setText("Nombre de Usuario");
		Usuario.setBounds(279, 243, 217, 34);
		bg.add(Usuario);

		JSeparator separator = new JSeparator();
		separator.setBounds(new Rectangle(0, 0, 4, 4));
		separator.setPreferredSize(new Dimension(0, 5));
		separator.setSize(new Dimension(5, 0));
		separator.setBounds(279, 281, 217, 22);
		bg.add(separator);

		JLabel Titulo_Contraseña = new JLabel("CONTRASEÑA");
		Titulo_Contraseña.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo_Contraseña.setFont(new Font("Roboto", Font.BOLD, 19));
		Titulo_Contraseña.setBounds(235, 282, 203, 74);
		bg.add(Titulo_Contraseña);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(279, 380, 217, 22);
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
				if (Usuario.getText().isEmpty()) {
					Usuario.setText("Nombre de Usuario");
					Usuario.setForeground(Color.gray);
				}

			}
		});
		Contraseña.setBorder(null);
		Contraseña.setForeground(new Color(192, 192, 192));
		Contraseña.setCaretColor(new Color(192, 192, 192));
		Contraseña.setBackground(new Color(238, 255, 255));
		Contraseña.setText("Aqui tu con");
		Contraseña.setBounds(279, 338, 217, 34);
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
		panelcierre.setBounds(648, 27, 63, 57);
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
		panel.setBounds(279, 412, 175, 51);
		bg.add(panel);

		JLabel lblNewLabel = new JLabel("INICIAR SESION");
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
				usuario = Usuario.getText();
				contraseña = String.valueOf(Contraseña.getPassword());
				comprobacion();

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

		JPanel panelr = new JPanel(new GridBagLayout());
		panelr.setBackground(new Color(0, 181, 181));
		panelr.setBounds(511, 412, 175, 51);
		bg.add(panelr);

		JLabel Registro = new JLabel("REGISTRO");
		Registro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Registro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Registro.setForeground(Color.black);
				panelr.setBackground(new Color(215, 255, 255));
			}

			public void mouseExited(MouseEvent e) {
				Registro.setForeground(Color.white);
				panelr.setBackground(new Color(0, 181, 181));
			}

			public void mouseClicked(MouseEvent e) {
				Registro registro = new Registro(cn);
				registro.setVisible(true);
				VENTANA = true;
				dispose();

			}
		});
		Registro.setForeground(new Color(255, 255, 255));
		Registro.setFont(new Font("Roboto", Font.BOLD, 23));
		Registro.setHorizontalTextPosition(SwingConstants.CENTER);
		Registro.setHorizontalAlignment(SwingConstants.CENTER);
		panelr.add(Registro);

		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		gbc2.fill = GridBagConstraints.BOTH;
		gbc2.weightx = 1.0;
		gbc2.weighty = 1.0;

		panelr.add(Registro, gbc2);

		JLabel lblNewLabel_1 = new JLabel("O");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Roboto Black", Font.BOLD, 21));
		lblNewLabel_1.setBounds(464, 421, 32, 34);
		bg.add(lblNewLabel_1);

	}

	public static String getUsuario() {
		return usuario;
	}

	public static String getContraseña() {
		return contraseña;
	}

	public static boolean isInicio() {
		return inicio;
	}

	public void setInicio(boolean inicio) {
		this.inicio = inicio;
	}

	public static boolean isVENTANA() {
		return VENTANA;
	}

	public static void setVENTANA(boolean vENTANA) {
		VENTANA = vENTANA;
	}
}

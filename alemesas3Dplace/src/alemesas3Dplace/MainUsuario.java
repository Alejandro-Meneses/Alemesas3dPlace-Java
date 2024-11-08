package alemesas3Dplace;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JButton;

public class MainUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Connection cn;
	private JPanel content;
	private int id_pedido;
	private int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/alemesas3dplace", "root",
							"");
					MainUsuario Usuario = new MainUsuario(cn);
					Usuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainUsuario (Connection cn) {
		this.cn = cn;
		setTitle("Inicio - Alemesas3Dplace");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Inicio_sesion.class.getResource("/imagenes/Logo Alemesas3D.png")));
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1048, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		addWindowListener(new WindowAdapter() {
			@Override

			public void windowOpened(WindowEvent e) {

			}
		});
		contentPane.setLayout(null);

		JPanel bg = new JPanel();
		bg.setName("");
		bg.setForeground(new Color(255, 255, 255));
		bg.setBounds(-38, -40, 1086, 637);
		bg.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		bg.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		bg.setBackground(new Color(238, 255, 255));
		contentPane.add(bg);
		bg.setLayout(null);

		content = new JPanel();
		content.setBounds(289, 117, 797, 520);
		content.setBorder(null);
		content.setBackground(new Color(173, 189, 225));
		content.setLayout(new BorderLayout());
		bg.add(content);

		Inicio2 I1 = new Inicio2();
		content.removeAll();
		content.add(I1, BorderLayout.CENTER);
		content.revalidate();
		content.repaint();

		JPanel panel = new JPanel();
		panel.setBounds(38, 41, 251, 596);
		panel.setBackground(new Color(1, 22, 49));
		bg.add(panel);
		panel.setLayout(null);

		JLabel Perfil = new JLabel("");
		Perfil.setIcon(new ImageIcon(MainFrame.class.getResource("/imagenes/Imagen Usuario.png")));
		Perfil.setBounds(42, 38, 155, 158);
		panel.add(Perfil);

		JLabel NUsuario = new JLabel(Inicio_sesion.getUsuario());
		NUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
		NUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		NUsuario.setForeground(new Color(255, 255, 255));
		NUsuario.setFont(new Font("Roboto Black", Font.PLAIN, 29));
		NUsuario.setBounds(42, 206, 155, 24);
		panel.add(NUsuario);

		JPanel Panel_Inicio = new JPanel();
		Panel_Inicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Panel_Inicio.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				Panel_Inicio.setBackground(new Color(1, 22, 49));
			}

			public void mouseEntered(MouseEvent e) {
				Panel_Inicio.setBackground(new Color(41, 94, 150));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Inicio2 I1 = new Inicio2();
				content.removeAll();
				content.add(I1, BorderLayout.CENTER);
				content.revalidate();
				content.repaint();
			}
		});
		Panel_Inicio.setBackground(new Color(1, 22, 49));
		Panel_Inicio.setBounds(10, 250, 231, 45);
		panel.add(Panel_Inicio);

		JLabel lblNewLabel = new JLabel("Inicio");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Roboto Black", Font.BOLD, 25));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;

		Panel_Inicio.add(lblNewLabel, gbc);

		JPanel Panel_Tabla_Pedidos = new JPanel();
		Panel_Tabla_Pedidos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Panel_Tabla_Pedidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				Panel_Tabla_Pedidos.setBackground(new Color(1, 22, 49));
			}

			public void mouseEntered(MouseEvent e) {
				Panel_Tabla_Pedidos.setBackground(new Color(41, 94, 150));
			}

			public void mouseClicked(MouseEvent e) {
				Tabla_Pedidos t1 = new Tabla_Pedidos(cn);
				content.removeAll();
				content.add(t1, BorderLayout.CENTER);
				content.revalidate();
				content.repaint();
				t1.Cargartablau(cn);
			}
		});
		Panel_Tabla_Pedidos.setBackground(new Color(1, 22, 49));
		Panel_Tabla_Pedidos.setBounds(10, 307, 231, 45);
		panel.add(Panel_Tabla_Pedidos);

		JLabel lblTablaPedidos = new JLabel("Mis Pedidos");
		lblTablaPedidos.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTablaPedidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblTablaPedidos.setForeground(Color.WHITE);
		lblTablaPedidos.setFont(new Font("Roboto Black", Font.BOLD, 25));
		Panel_Tabla_Pedidos.add(lblTablaPedidos);

		JPanel Panel_Mod_Pedido = new JPanel();
		Panel_Mod_Pedido.setBackground(new Color(1, 22, 49));
		Panel_Mod_Pedido.setBounds(10, 363, 231, 45);
		panel.add(Panel_Mod_Pedido);
		Panel_Mod_Pedido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Panel_Mod_Pedido.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				Panel_Mod_Pedido.setBackground(new Color(1, 22, 49));
			}

			public void mouseEntered(MouseEvent e) {
				Panel_Mod_Pedido.setBackground(new Color(41, 94, 150));
			}

			public void mouseClicked(MouseEvent e) {

						HacerPedido HP2 = new HacerPedido(cn, id_pedido);
						content.removeAll();
						content.add(HP2, BorderLayout.CENTER);
						content.revalidate();
						content.repaint();
				
			}
		});

		JLabel lblModificarPedido = new JLabel("Hacer Pedido");
		lblModificarPedido.setHorizontalTextPosition(SwingConstants.CENTER);
		lblModificarPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarPedido.setForeground(Color.WHITE);
		lblModificarPedido.setFont(new Font("Roboto Black", Font.BOLD, 25));
		Panel_Mod_Pedido.add(lblModificarPedido);
		
		JPanel Panel_Tabla_Pedidos_1 = new JPanel();
		Panel_Tabla_Pedidos_1.setBackground(new Color(1, 22, 49));
		Panel_Tabla_Pedidos_1.setBounds(10, 418, 231, 45);
		panel.add(Panel_Tabla_Pedidos_1);
		
		JLabel lblListaPrecios = new JLabel("Lista Precios");
		lblListaPrecios.setHorizontalTextPosition(SwingConstants.CENTER);
		lblListaPrecios.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaPrecios.setForeground(Color.WHITE);
		lblListaPrecios.setFont(new Font("Roboto Black", Font.BOLD, 25));
		Panel_Tabla_Pedidos_1.add(lblListaPrecios);
		Panel_Tabla_Pedidos_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Panel_Tabla_Pedidos_1.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				Panel_Tabla_Pedidos_1.setBackground(new Color(1, 22, 49));
			}
			
			public void mouseEntered(MouseEvent e) {
				Panel_Tabla_Pedidos_1.setBackground(new Color(41, 94, 150));
			}
			
			public void mouseClicked(MouseEvent e) {
				
				Tabla_Precio TP2 = new Tabla_Precio();
				content.removeAll();
				content.add(TP2, BorderLayout.CENTER);
				content.revalidate();
				content.repaint();
				
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(289, 41, 797, 77);
		bg.add(panel_1);
		panel_1.setLayout(null);


		JLabel NOMBRE = new JLabel("Alemesas3DPlace");
		NOMBRE.setForeground(Color.LIGHT_GRAY);
		NOMBRE.setFont(new Font("Vladimir Script", Font.PLAIN, 29));
		NOMBRE.setBounds(299, 10, 192, 57);
		panel_1.add(NOMBRE);
		JPanel panelcierre = new JPanel();
		panelcierre.setBounds(724, 10, 63, 57);
		panel_1.add(panelcierre);
		panelcierre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelcierre.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				panelcierre.setBackground(new Color(185, 25, 29)); // Color rojo
				panelcierre.setOpaque(true);
				panelcierre.repaint();

			}

			public void mouseExited(MouseEvent e) {
				panelcierre.setOpaque(false); // Volver a ser transparente
				panelcierre.repaint();
			}

			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		panelcierre.setBackground(new Color(255, 255, 255, 0));

		JLabel Cierre = new JLabel("X");
		Cierre.setForeground(new Color(255, 255, 255));
		Cierre.setFont(new Font("Roboto Black", Font.PLAIN, 39));
		Cierre.setBackground(new Color(238, 255, 255));
		panelcierre.add(Cierre);
		Cierre.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				panelcierre.setBackground(new Color(185, 25, 29)); // Color rojo
				panelcierre.setOpaque(true);
				panelcierre.repaint();
			}

			public void mouseExited(MouseEvent e) {
				panelcierre.setOpaque(false); // Volver a ser transparente
				panelcierre.repaint();

			}

			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		Cierre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MainFrame.class.getResource("/imagenes/Fondo Estrellado Arriba.jpg")));
		lblNewLabel_1.setBounds(0, 0, 797, 87);
		panel_1.add(lblNewLabel_1);

	}
}
package alemesas3Dplace;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Inicio2 extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Inicio2() {
		setBackground(new Color(128, 128, 192));
		setLayout(null);
		
		JPanel bg = new JPanel();
		bg.setBackground(new Color(134,150,207,255));
		bg.setBounds(0, 0, 797, 507);
		add(bg);
		bg.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(134,150,207,255));
		panel.setBounds(76, 92, 222, 307);
		panel.setOpaque(false); 
		panel.repaint();
		bg.add(panel);
		panel.setLayout(null);
		
		JTextArea Texto = new JTextArea("\"Hacemos realidad tus sueños más creativos, transformándolos en obras de arte 3D y personalizadas con nuestra impresión 3D y pintura mágica\"");
		Texto.setForeground(new Color(255, 255, 255));
        Texto.setBounds(0, 0, 222, 307);
        Texto.setFont(new Font("Ink Free", Font.BOLD, 24));
        Texto.setLineWrap(true); 
        Texto.setWrapStyleWord(true); 
        Texto.setOpaque(false); 
        Texto.setEditable(false); 
        Texto.setFocusable(false); 
        panel.add(Texto);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(423, 81, 164, 197);
        bg.add(panel_1);
        panel_1.setOpaque(false); 
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(17, 0, 130, 114);
        panel_1.add(lblNewLabel);
        lblNewLabel.setIcon(new ImageIcon(Inicio2.class.getResource("/Imagenesprueba/Karambit__3_-removebg-preview.png")));
        
        JTextArea Texto1 = new JTextArea("\"Karambit con color precioso\"");
        Texto1.setBounds(5, 124, 154, 51);
        panel_1.add(Texto1);
		Texto1.setForeground(new Color(255, 255, 255));
        Texto1.setFont(new Font("Roboto Black", Font.BOLD, 19));
        Texto1.setLineWrap(true); 
        Texto1.setWrapStyleWord(true); 
        Texto1.setOpaque(false); 
        Texto1.setEditable(false); 
        Texto1.setFocusable(false);
        
        JLabel lblNewLabel_5 = new JLabel("\r\n");
        lblNewLabel_5.setIcon(new ImageIcon(Inicio2.class.getResource("/Imagenesprueba/Estrellas_5_-removebg-preview.png")));
        lblNewLabel_5.setBounds(13, 174, 137, 23);
        panel_1.add(lblNewLabel_5);
        
        JLabel lblNewLabel_1 = new JLabel("Opiniones :");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Roboto Black", Font.BOLD, 36));
        lblNewLabel_1.setBounds(417, 29, 357, 41);
        bg.add(lblNewLabel_1);
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setLayout(null);
        panel_1_1.setOpaque(false);
        panel_1_1.setBounds(610, 81, 164, 197);
        bg.add(panel_1_1);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Inicio2.class.getResource("/Imagenesprueba/Peepo__1_-removebg-preview.png")));
        lblNewLabel_2.setBounds(37, 0, 90, 114);
        panel_1_1.add(lblNewLabel_2);
        
        JTextArea Texto1_1 = new JTextArea("\"PeepoCoozy Muy bonito\"");
        Texto1_1.setWrapStyleWord(true);
        Texto1_1.setOpaque(false);
        Texto1_1.setLineWrap(true);
        Texto1_1.setForeground(Color.WHITE);
        Texto1_1.setFont(new Font("Roboto Black", Font.BOLD, 19));
        Texto1_1.setFocusable(false);
        Texto1_1.setEditable(false);
        Texto1_1.setBounds(13, 125, 137, 51);
        panel_1_1.add(Texto1_1);
        
        JLabel lblNewLabel_5_1 = new JLabel("\r\n");
        lblNewLabel_5_1.setIcon(new ImageIcon(Inicio2.class.getResource("/Imagenesprueba/Estrellas_5_-removebg-preview.png")));
        lblNewLabel_5_1.setBounds(13, 174, 137, 23);
        panel_1_1.add(lblNewLabel_5_1);
        
        JPanel panel_1_2 = new JPanel();
        panel_1_2.setLayout(null);
        panel_1_2.setOpaque(false);
        panel_1_2.setBounds(423, 288, 164, 209);
        bg.add(panel_1_2);
        
        JLabel lblNewLabel_5_2 = new JLabel("\r\n");
        lblNewLabel_5_2.setIcon(new ImageIcon(Inicio2.class.getResource("/Imagenesprueba/Estrellas_5_-removebg-preview.png")));
        lblNewLabel_5_2.setBounds(13, 186, 137, 23);
        panel_1_2.add(lblNewLabel_5_2);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setBounds(17, 8, 130, 106);
        lblNewLabel_3.setIcon(new ImageIcon(Inicio2.class.getResource("/Imagenesprueba/Capy_Amor-removebg-preview.png")));
        panel_1_2.add(lblNewLabel_3);

        JTextArea Texto1_2 = new JTextArea("\"Capybaras Perfectos para parejas\"");
        Texto1_2.setWrapStyleWord(true);
        Texto1_2.setOpaque(false);
        Texto1_2.setLineWrap(true);
        Texto1_2.setForeground(Color.WHITE);
        Texto1_2.setFont(new Font("Roboto Black", Font.BOLD, 19));
        Texto1_2.setFocusable(false);
        Texto1_2.setEditable(false);
        Texto1_2.setBounds(10, 114, 144, 71);
        panel_1_2.add(Texto1_2);
        

        JPanel panel_1_3 = new JPanel();
        panel_1_3.setLayout(null);
        panel_1_3.setOpaque(false);
        panel_1_3.setBounds(610, 288, 164, 209);
        bg.add(panel_1_3);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon(Inicio2.class.getResource("/Imagenesprueba/Mudkip-removebg-preview.png")));
        lblNewLabel_4.setBounds(17, 0, 130, 114);
        panel_1_3.add(lblNewLabel_4);
        
        JTextArea Texto1_3 = new JTextArea("\"Precioso,ojala tambien en shiny :D\"");
        Texto1_3.setWrapStyleWord(true);
        Texto1_3.setOpaque(false);
        Texto1_3.setLineWrap(true);
        Texto1_3.setForeground(Color.WHITE);
        Texto1_3.setFont(new Font("Roboto Black", Font.BOLD, 19));
        Texto1_3.setFocusable(false);
        Texto1_3.setEditable(false);
        Texto1_3.setBounds(10, 113, 144, 71);
        panel_1_3.add(Texto1_3);
        
        JLabel lblNewLabel_5_2_1 = new JLabel("\r\n");
        lblNewLabel_5_2_1.setIcon(new ImageIcon(Inicio2.class.getResource("/Imagenesprueba/Estrellas_5_-removebg-preview.png")));
        lblNewLabel_5_2_1.setBounds(13, 186, 137, 23);
        panel_1_3.add(lblNewLabel_5_2_1);
        
        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon(Inicio2.class.getResource("/imagenes/imagen_2024-05-24_024020329.png")));
        lblNewLabel_6.setBounds(0, 0, 797, 507);
        bg.add(lblNewLabel_6);
        
        
        
        
		
		

	}
}

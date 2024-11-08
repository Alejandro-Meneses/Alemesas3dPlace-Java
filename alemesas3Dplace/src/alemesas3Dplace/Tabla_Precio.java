package alemesas3Dplace;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Tabla_Precio extends JPanel {
    public Tabla_Precio() {
    	setBackground(new Color(128, 128, 192));
		setLayout(null);

		JPanel bg = new JPanel();
		bg.setLayout(null);
		bg.setBackground(new Color(134, 150, 207));
		bg.setBounds(0, 0, 797, 507);
		add(bg);
		JTextArea policyText = new JTextArea();
		policyText.setText("Política de Devolución:\n" +
		        "1. Si el producto llega con desperfectos, por favor contactanos en un plazo de 7 días para gestionar la devolución.\n" +
		        "2. Los productos personalizados no tienen derecho a devolución, salvo que presenten desperfectos.\n" +
		        "3. Los gastos de envío de la devolución correrán a cargo del comprador, excepto en casos de productos defectuosos.");
		policyText.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		policyText.setEditable(false);
		JScrollPane policyScrollPane = new JScrollPane(policyText);
		policyScrollPane.setBounds(10, 410, 777, 87);
		bg.add(policyScrollPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Tabla_Precio.class.getResource("/imagenes/Tabla (1).png")));
		lblNewLabel.setBounds(196, 10, 400, 380);
		bg.add(lblNewLabel);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Tabla_Precio.class.getResource("/imagenes/imagen_2024-05-24_024020329.png")));
		lblNewLabel_6.setBounds(0, 0, 797, 507);
		bg.add(lblNewLabel_6);

     
        // Crear panel de política de devoluciones
        JPanel policyPanel = new JPanel();
        policyPanel.setLayout(new BorderLayout());
        policyPanel.setBorder(BorderFactory.createTitledBorder("Derecho de Devolución y Desperfectos"));
        
	}}

   

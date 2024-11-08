package alemesas3Dplace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class main {
	public static boolean admin(String usuario, String contrasena) {
		String[][] Admins = { { "Alemesa", "1234" }, { "Vargues", "4321" }, { "Sanhehi", "pipopi" } };

		for (int i = 0; i < Admins.length; i++) {
			if (Admins[i][0].equals(usuario) && Admins[i][1].equals(contrasena)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean inicio = false, autenticado = false;
		String usuarior = null, respuesta = null, usuario = null, contraseña = null;
		int opcion, opcionu;

		try {
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/alemesas3dplace", "root", "");
			System.out.println("Conexion completada");
			do {

				if (!Inicio_sesion.isVENTANA()) {
					Inicio_sesion inicioSesion = new Inicio_sesion(cn);
					inicioSesion.setVisible(true);

					while (inicioSesion.isVisible()) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

			} while (!Inicio_sesion.isInicio());
			usuario = Inicio_sesion.getUsuario();
			contraseña = Inicio_sesion.getContraseña();
			autenticado = admin(usuario, contraseña);
			if (autenticado) {
				MainFrame MainAdmin = new MainFrame(cn);
				MainAdmin.setVisible(true);

			}else {
				MainUsuario Mainusuario = new MainUsuario(cn);
				Mainusuario.setVisible(true);
			}
		} catch (SQLException e) {
			System.out.println("No se ha podido conectar con la base de datos");
			System.out.println("O ha habido algun fallo en la consulta");
		}
	}

}

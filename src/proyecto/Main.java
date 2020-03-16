package proyecto;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;

public class Main {

	public static Connection conn;
	public static Frame marco;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto","root","RoOtP1.0");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		marco=new Frame(1);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    Font[] fonts = e.getAllFonts(); // Get the fonts
	    for (Font f : fonts) {
	    	System.out.println();
	    }*/
	}

}

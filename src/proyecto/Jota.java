package proyecto;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;

public class Jota {

	private String sql;
	private InputStream image;
	//Cambie sImage e imagen a private
	private String sImage;
	private Image imagen;
	private String correo;
	private String contra;
	private String user;
	private String name;
	private String lastname;
	private int id;
	private byte grado;
	private char seccion;
	private int aula;
	private Student suser;

	public void insertImage() throws FileNotFoundException {
		sImage="C:\\Users\\wagne\\OneDrive\\Desktop\\Nasa.jpg";
		try {
			image=new FileInputStream(new File(sImage));
			PreparedStatement st=Main.conn.prepareStatement("INSERT INTO example VALUES(?,?)");
			int id=(int)(Math.random()*1000000000);
			st.setInt(1, id);
			st.setBlob(2, image);
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Hubo problemas con el path de la imagen");
		}
	}

	public Image getImage(String which) {
		try {
			String sql;
			if(which.equals("space")) {
				sql="SELECT imagen FROM example WHERE ID=962068342";
			}else {
				sql="SELECT imagen FROM example WHERE ID=863859763";
			}
			Statement st=Main.conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				image=rs.getBlob("imagen").getBinaryStream();
				try {
					imagen=ImageIO.read(image);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Problema en la conversion de la imagen");
				}

			}
			rs.close();
			st.close();
			return imagen;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void saveCorreo(String correo) {
		this.correo=correo;
	}

	public void saveContra(String contra) {
		this.contra=contra;
	}

	public void saveUser(String user){
		this.user=user;
	}

	public void saveName(String name){
		this.name=name;
	}

	public void saveLastName(String lastname){
		this.lastname=lastname;
	}

	public void createUser() {
		try {
			String sql="INSERT INTO suser VALUES(?,?,?,?,?,?)";
			PreparedStatement pst=Main.conn.prepareStatement(sql);
			int id=(int)(Math.random()*1000000000);
			System.out.println(correo);
			pst.setString(1, correo);
			pst.setString(2, contra);
			pst.setString(3, user);
			pst.setString(4, name);
			pst.setString(5, lastname);
			pst.setInt(6, (int)(Math.random()*1000000000));
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Algo paso con el PreparedStatement");
		}
	}

	public boolean login(String mail){
		try{
			int id=0;
			String sql="SELECT id_alumno FROM suser WHERE correo=?";
			PreparedStatement pst=Main.conn.prepareStatement(sql);
			pst.setString(1, mail);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				id=rs.getInt(1);
			}
			pst.close();
			if(id>1) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e){
			e.printStackTrace();
			System.out.println("Error con el SQL");
			return false;
		}
	}

	public Student getAccountInfo(String mail){
		try{
			String sql="SELECT * FROM suser WHERE correo=?";
			PreparedStatement stmt=Main.conn.prepareStatement(sql);
			stmt.setString(1, mail);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				id=rs.getInt(6);
				correo=rs.getString(1);
				contra=rs.getString(2);
				user=rs.getString(3);
				name=rs.getString(4);
				lastname=rs.getString(5);
				grado=rs.getByte(7);
				seccion=rs.getString(8).charAt(0);
				aula=rs.getInt(9);
			}
			suser=new Student(id, correo, contra, user, name, lastname, grado, seccion, aula);
			rs.close();
			stmt.close();
			return suser;
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("Problema con el SQL");
			return null;
		}
	}

}

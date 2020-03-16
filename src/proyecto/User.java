package proyecto;

public class User {

	private int id_usuario;
	private String correo;
	private String contra;
	private String usuario;
	private String nombre;
	private String apellido;

	public User(int id_alumno, String correo, String contra, String usuario, String nombre, String apellido) {
		this.id_usuario=id_usuario;
		this.correo=correo;
		this.contra=contra;
		this.usuario=usuario;
		this.nombre=nombre;
		this.apellido=apellido;
	}

	public int getIdUsuario() {
		return id_usuario;
	}

	public String getCorreo() {
		return correo;
	}

	public String getContra() {
		return contra;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

}

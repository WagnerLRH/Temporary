package proyecto;

public class Teacher extends User{

	String materia;
	
	public Teacher(int id_usuario, String correo, String contra, String usuario, String nombre, String apellido, String materia) {
		super(id_usuario, correo, contra, usuario, nombre, apellido);
		this.materia=materia;
	}
	
	public String getMateria() {
		return materia;
	}
	
}

package proyecto;

public class Student extends User{

	private byte grado;
	private char seccion;
	private int aula;
	
	//I have the feeling that if I remove this following the creation of objects of this class should 
	// still be possible but if I encounter problems will uncomment this.
	public Student(int id_alumno, String correo, String contra, String usuario, String nombre, String apellido
				   ,byte grado, char seccion, int aula) {
		super(id_alumno, correo, contra, usuario, nombre, apellido);
		this.grado=grado;
		this.seccion=seccion;
		this.aula=aula;
	}
	
}

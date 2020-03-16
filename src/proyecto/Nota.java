package proyecto;

public class Nota {

	private int id_nota;
	private byte zona;
	private byte examen;
	private int id_usuario;
	private int id_alumno;

	public Nota(int id_nota, byte zona, byte examen, int id_usuario, int id_alumno) {
		this.id_nota=id_nota;
		this.zona=zona;
		this.examen=examen;
		this.id_usuario=id_usuario;
		this.id_alumno=id_alumno;
	}

	public int getIdNota() {
		return id_nota;
	}

	public byte getZona() {
		return zona;
	}

	public byte getExamen() {
		return examen;
	}

	public int getIdUsuario() {
		return id_usuario;
	}

	public int getIdAlumno() {
		return id_alumno;
	}

}

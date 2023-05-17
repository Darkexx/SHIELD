package JavaBeans;
import java.io.Serializable;

public class JB_Integrantes implements Serializable{
	private int id_h;
	private String nombre;

	public JB_Integrantes() {
		
	}
	
	public JB_Integrantes(
			
			int id_h,
			String nombre
			
			) {
			
		this.id_h=id_h;
		this.nombre=nombre;
			
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Getter y Setter para ID_H
	public int getIdH() {
	    return id_h;
	}
	
	public void setIdH(int idH) {
	    this.id_h = idH;
	}

	// Getter y Setter Nombre
	public String getNombre() {
	    return nombre;
	}

	public void setNombre(String nombre) {
	    this.nombre = nombre;
	}
}
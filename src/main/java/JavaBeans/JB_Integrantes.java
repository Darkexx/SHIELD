package JavaBeans;
import java.io.Serializable;

public class JB_Integrantes implements Serializable{
	private int id_h;
	private String nombre;
	//--Variables para consultas--//
	private String nombre2;//Variable utilizada para consulta Heroe-Integrante

	public JB_Integrantes() {
		
	}
	
	public JB_Integrantes( int id_h) {
			
		this.id_h=id_h;
			
	}
	
	public JB_Integrantes(String nombre) {
			
		this.nombre=nombre;
			
	}
	
	public JB_Integrantes(
			
			int id_h,
			String nombre
			
			) {
			
		this.id_h=id_h;
		this.nombre=nombre;
			
	}
	
public JB_Integrantes(
			
			String nombre,
			String nombre2
			
			) {
			
		this.nombre=nombre;
		this.nombre2=nombre2;
			
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
	
	//Getter y Setter Nombre2 (utilizada solo para consulta Heores-Integrantes)
	public String getNombre2() {
	return nombre2;
	}

	public void setNombre2(String nombre2) {
	this.nombre2 = nombre2;
	}
}
package JavaBeans;
import java.io.Serializable;

public class JB_Heroes implements Serializable{
	private int id_h;
	private String nombre;
	private int id_l;
	private String id_sub;

	public JB_Heroes() {
		
	}
	
	public JB_Heroes(int id_h) {
			
		this.id_h=id_h;
			
	}
	
	public JB_Heroes(String nombre) {
			
		this.nombre=nombre;
			
	}
	
public JB_Heroes(
			String nombre,
			int id_l,
			String id_sub,
			int id_h
			
			) {
			
		this.nombre=nombre;
		this.id_l=id_l;
		this.id_sub=id_sub;
		this.id_h=id_h;
			
	}
	
	public JB_Heroes(
			
			int id_h,
			String nombre,
			int id_l,
			String id_sub
			
			) {
			
		this.id_h=id_h;
		this.nombre=nombre;
		this.id_l=id_l;
		this.id_sub=id_sub;
			
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Getter y Setter ID_H
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

	// Getter y Setter ID_L
	public int getIdL() {
	    return id_l;
	}
	
	public void setIdL(int idL) {
	    this.id_l = idL;
	}

	// Getter y Setter ID_Sub
	public String getIdSub() {
	    return id_sub;
	}

	public void setIdSub(String idSub) {
	    this.id_sub = idSub;
	}
}
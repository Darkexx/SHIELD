package JavaBeans;
import java.io.Serializable;

public class JB_Subdivision implements Serializable{
	private String id_sub;
	private String nombre;

	public JB_Subdivision() {
		
	}
	
	public JB_Subdivision(
			
			int id_sub,
			String nombre
			
			) {
			
		this.id_sub=id_sub;
		this.nombre=nombre;
			
	}

	// Getter y Setter ID_Sub
	public String getIdSub() {
	    return id_sub;
	}
	
	public void setIdSub(String idSub) {
	    this.id_sub = idSub;
	}

	// Getter y Setter Nombre
	public String getNombre() {
	    return nombre;
	}

	public void setNombre(String nombre) {
	    this.nombre = nombre;
	}
}
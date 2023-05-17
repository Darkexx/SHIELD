package JavaBeans;
import java.io.Serializable;

public class JB_STARK implements Serializable{
	private String id_ceo;
	private String nombre;

	public JB_STARK() {
		
	}
	
	public JB_STARK(
			
			String id_ceo,
			String nombre
			
			) {
			
		this.id_ceo=id_ceo;
		this.nombre=nombre;
			
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Getter y Setter ID_CEO
	public String getIdCeo() {
	    return id_ceo;
	}
	
	public void setIdCeo(String idCeo) {
	    this.id_ceo = idCeo;
	}

	// Getter y Setter Nombre
	public String getNombre() {
	    return nombre;
	}

	public void setNombre(String nombre) {
	    this.nombre = nombre;
	}

	
	
}
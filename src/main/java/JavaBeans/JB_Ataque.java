package JavaBeans;
import java.io.Serializable;

public class JB_Ataque implements Serializable{
	private String id_at;
	private String nombre;
	private int muertes;
	private int heridos;
	private String pais;

	public JB_Ataque() {
		
	}
	
public JB_Ataque(
			
			String id_at
			
			) {
			
		this.id_at=id_at;
			
	}
	
	
	public JB_Ataque(
			
			String id_at,
			String nombre,
			int muertes,
			int heridos,
			String pais
			
			) {
			
		this.id_at=id_at;
		this.nombre=nombre;
		this.muertes=muertes;
		this.heridos=heridos;
		this.pais=pais;
			
	}
	
	public JB_Ataque(
			
			String nombre,
			int muertes,
			int heridos,
			String pais,
			String id_at
			
			) {
			
		this.nombre=nombre;
		this.muertes=muertes;
		this.heridos=heridos;
		this.pais=pais;
		this.id_at=id_at;	
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Getter y Setter ID_At
	public String getIdAt() {
	    return id_at;
	}
	
	public void setIdAt(String idAt) {
	    this.id_at = idAt;
	}

	// Getter y Setter Nombre
	public String getNombre() {
	    return nombre;
	}
	
	public void setNombre(String nombre) {
	    this.nombre = nombre;
	}

	// Getter y Setter Muertes
	public int getMuertes() {
	    return muertes;
	}
	
	public void setMuertes(int muertes) {
	    this.muertes = muertes;
	}

	// Getter y Setter Heridos
	public int getHeridos() {
	    return heridos;
	}

	public void setHeridos(int heridos) {
	    this.heridos = heridos;
	}

	// Getter y Setter Pais
	public String getPais() {
	    return pais;
	}
	
	public void setPais(String pais) {
	    this.pais = pais;
	}

	
	
}
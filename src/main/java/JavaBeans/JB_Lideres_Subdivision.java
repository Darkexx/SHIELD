package JavaBeans;
import java.io.Serializable;

public class JB_Lideres_Subdivision implements Serializable{
	private String id_ls;
	private String nombre;
	private String rango;
	private String id_sub;

	public JB_Lideres_Subdivision() {
		
	}
	
	public JB_Lideres_Subdivision(
			
			String id_ls,
			String nombre,
			String rango,
			String id_sub
			
			) {
			
		this.id_ls=id_ls;
		this.nombre=nombre;
		this.rango=rango;
		this.id_sub=id_sub;
			
	}
	
	////////////////////////////////////////////////////////////////////////////
	
	
	public JB_Lideres_Subdivision(
			
			String id_ls
			
			) {
			
		this.id_ls=id_ls;
			
	}
	
	
	/////////////////////////////////////////////////////////////////////////////
	
	
	// Getter y Setter ID_ls
	public String getIdLs() {
	    return id_ls;
	}
	
	public void setIdLs(String idLs) {
	    this.id_ls = idLs;
	}

	// Getter y Setter nombre
	public String getNombre() {
	    return nombre;
	}

	public void setNombre(String nombre) {
	    this.nombre = nombre;
	}

	// Getter y Setter Rango
	public String getRango() {
	    return rango;
	}

	public void setRango(String rango) {
	    this.rango = rango;
	}

	// Getter y Setter ID_Sub
	public String getIdSub() {
	    return id_sub;
	}
	
	public void setIdSub(String idSub) {
	    this.id_sub = idSub;
	}
	
}
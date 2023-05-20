package JavaBeans;
import java.io.Serializable;

public class JB_Agentes implements Serializable{
	private int id_agent;
	private String nombre;
	private String especializacion;
	private String puesto;

	public JB_Agentes() {
		
	}
	
public JB_Agentes(
			
			int id_agent
			
			) {
			
		this.id_agent=id_agent;
			
	}
	
	public JB_Agentes(
			
			int id_agent,
			String nombre,
			String especializacion,
			String puesto
			
			) {
			
		this.id_agent=id_agent;
		this.nombre=nombre;
		this.especializacion=especializacion;
		this.puesto=puesto;
			
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Getter y Setter Id_agent
	public int getIdAgent() {
	    return id_agent;
	}
	
	public void setIdAgent(int idAgent) {
	    this.id_agent = idAgent;
	}

	//Getter y Setter Nombre
	public String getNombre() {
	    return nombre;
	}

	public void setNombre(String nombre) {
	    this.nombre = nombre;
	}

	//Getter y Setter especializacion
	public String getEspecializacion() {
	    return especializacion;
	}

	public void setEspecializacion(String especializacion) {
	    this.especializacion = especializacion;
	}

	//Getter y Setter Puesto
	public String getPuesto() {
	    return puesto;
	}

	public void setPuesto(String puesto) {
	    this.puesto = puesto;
	}

}

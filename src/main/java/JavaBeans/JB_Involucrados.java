package JavaBeans;
import java.io.Serializable;

public class JB_Involucrados implements Serializable{
	private String id_at;
	private int id_h;
	private int id_agent;
	private String fecha;
	/////////Variables para consulta/////////// 
	private String ataque;
	private String heroe;
	private String agente;
	
	
	public JB_Involucrados() {
		
	}
	
	public JB_Involucrados(
			
			String id_at,
			int id_h,
			int id_agent,
			String fecha
			
			) {
			
		this.id_at=id_at;
		this.id_h=id_h;
		this.id_agent=id_agent;
		this.fecha=fecha;
			
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public JB_Involucrados(
			
			String ataque,
			String heroe,
			String agente,
			String fecha
			
			) {
			
		this.ataque=ataque;
		this.heroe=heroe;
		this.agente=agente;
		this.fecha=fecha;
			
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Getter y Setter ID_At
	public String getIdAt() {
	    return id_at;
	}
	
	public void setIdAt(String idAt) {
	    this.id_at = idAt;
	}

	// Getter y Setter ID_H
	public int getIdH() {
	    return id_h;
	}

	public void setIdH(int idH) {
	    this.id_h = idH;
	}

	// Getter y Setter ID_Agent
	public int getIdAgent() {
	    return id_agent;
	}

	public void setIdAgent(int idAgent) {
	    this.id_agent = idAgent;
	}

	// Getter y Setter Fecha
	public String getFecha() {
	    return fecha;
	}

	public void setFecha(String fecha) {
	    this.fecha = fecha;
	}
	
	///////////////////////////////////////////////////////
	
	public String getAtaque() {
		return ataque;
	}
	
	public void setAtaque(String ataque) {
		this.ataque = ataque;
	}

	public String getHeroe() {
		return heroe;
	}

	public void setHeroe(String heroe) {
		this.heroe = heroe;
	}

	public String getAgente() {
		return agente;
	}

	public void setAgente(String agente) {
		this.agente = agente;
	}
	
}
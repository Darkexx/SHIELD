package JavaBeans;
import java.io.Serializable;

public class JB_reuniones implements Serializable{
	private int id_l;
	private String tema;
	private String hora;
	///////////variables para consulta//////////////////
	private String lider;/////////////mostrar nombre de lider
	private String tema2;
	
	public JB_reuniones() {
		
	}
	
	public JB_reuniones(
			
			int id_l,
			String tema,
			String hora
			
			) {
			
		this.id_l=id_l;
		this.tema=tema;
		this.hora=hora;
			
	}
	
	//////////////////////////////////////////////////////////
	
	public JB_reuniones(
			
			int id_l,
			String tema,
			String tema2,
			String hora
			
			) {
			
		this.id_l=id_l;
		this.tema=tema;
		this.hora=hora;
			
	}
	
	public JB_reuniones(
			
			String tema
			
			) {
			
		this.tema=tema;
			
	}
	
	public JB_reuniones(
			
			String lider,
			String tema,
			String hora
			
			) {
			
		this.lider=lider;
		this.tema=tema;
		this.hora=hora;
			
	}
	
	///////////////////////////////////////////////////////////
	
	// Getter y Setter ID_L
	public int getIdL() {
	    return id_l;
	}
	
	public void setIdL(int idL) {
	    this.id_l = idL;
	}

	// Getter y Setter Tema
	public String getTema() {
	    return tema;
	}

	public void setTema(String tema) {
	    this.tema = tema;
	}

	// Getter y Setter Hora
	public String getHora() {
	    return hora;
	}

	public void setHora(String hora) {
	    this.hora = hora;
	}

	////////////////////////////////////////////////
	public String getLider() {
		return lider;
	}

	public void setLider(String lider) {
		this.lider = lider;
	}

	public String getTema2() {
		return tema2;
	}

	public void setTema2(String tema2) {
		this.tema2 = tema2;
	}
	
	
	
}
package JavaBeans;
import java.io.Serializable;

public class JB_reuniones implements Serializable{
	private int id_l;
	private String tema;
	private String hora;

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
	
}
package JavaBeans;
import java.io.Serializable;

public class JB_Lider implements Serializable{
	private int id_l;
	private String nombre;
	private String equipo_arm;

	public JB_Lider() {
		
	}
	
	
	public JB_Lider(int id_l) {
		
		this.id_l=id_l;
	
	}
	
	
	public JB_Lider(
			
			int id_l,
			String nombre,
			String equipor_arm
			
			) {
			
		this.id_l=id_l;
		this.nombre=nombre;
		this.equipo_arm=equipor_arm;
			
	}
	
	//////////////////////////////////////Constructor para actualizar registros////////////////////////////////////////////////////////////////////////////////////
	
	public JB_Lider(
			
			String nombre,
			String equipor_arm,
			int id_l
			
			) {
		this.nombre=nombre;
		this.equipo_arm=equipor_arm;
		this.id_l=id_l;
			
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Getter y Setter ID_L
	public int getIdL() {
	    return id_l;
	}

	public void setIdL(int idL) {
	    this.id_l = idL;
	}

	// Getter y Setter Nombre
	public String getNombre() {
	    return nombre;
	}

	public void setNombre(String nombre) {
	    this.nombre = nombre;
	}

	// Getter y Setter Equipo_arm
	public String getEquipoArm() {
	    return equipo_arm;
	}

	public void setEquipoArm(String equipoArm) {
	    this.equipo_arm = equipoArm;
	}
	
}
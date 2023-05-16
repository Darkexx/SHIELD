package JavaBeans;
import java.io.Serializable;

public class JB_Agentes implements Serializable{
	private String id_at;
	private String nom_tipo;
	private String reg_afect;
	private String mutant_afect;
	private String grupo_at;
	private String alien;
	private String bienes;

	public JB_Agentes() {
		
	}
	
	public JB_Agentes(
			
			String id_at,
			String nom_tipo,
			String reg_afect,
			String mutant_afect,
			String grupo_at,
			String alien,
			String bienes
			
			) {
			
		this.id_at=id_at;
		this.nom_tipo=nom_tipo;
		this.reg_afect=reg_afect;
		this.mutant_afect=mutant_afect;
		this.grupo_at=grupo_at;
		this.alien=alien;
		this.bienes=bienes;
			
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Getter y Setter ID_At
	public String getIdAt() {
	    return id_at;
	}
	
	public void setIdAt(String idAt) {
	    this.id_at = idAt;
	}

	// Getter y Setter nom_tipo
	public String getNomTipo() {
	    return nom_tipo;
	}

	public void setNomTipo(String nomTipo) {
	    this.nom_tipo = nomTipo;
	}

	// Getter y Setter Reg_afect
	public String getRegAfect() {
	    return reg_afect;
	}

	public void setRegAfect(String regAfect) {
	    this.reg_afect = regAfect;
	}

	// Getter y Setter mutant_afect
	public String getMutantAfect() {
	    return mutant_afect;
	}

	public void setMutantAfect(String mutantAfect) {
	    this.mutant_afect = mutantAfect;
	}

	// Getter y Setter Grupo_at
	public String getGrupoAt() {
	    return grupo_at;
	}

	public void setGrupoAt(String grupoAt) {
	    this.grupo_at = grupoAt;
	}

	// Getter y Setter Alien
	public String getAlien() {
	    return alien;
	}

	public void setAlien(String alien) {
	    this.alien = alien;
	}

	// Getter y Setter bienes
	public String getBienes() {
	    return bienes;
	}
	
	public void setBienes(String bienes) {
	    this.bienes = bienes;
	}
	
}
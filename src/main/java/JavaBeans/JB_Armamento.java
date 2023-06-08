package JavaBeans;
import java.io.Serializable;

public class JB_Armamento implements Serializable{
	private String id_ceo;
	private String tipo;
	private int cantidad;
	private int id_h;
	//////Variables para consulta//////
	private String ceo;
	private String grupo;

	public JB_Armamento() {
		
	}
	
	public JB_Armamento(
			
			String id_ceo
			
			) {
			
		this.id_ceo=id_ceo;
			
	}
	
	
	public JB_Armamento(
			
			String id_ceo,
			String tipo,
			int cantidad,
			int id_h
			
			) {
			
		this.id_ceo=id_ceo;
		this.tipo=tipo;
		this.cantidad=cantidad;
		this.id_h=id_h;
			
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public JB_Armamento(
			
			String ceo,
			String tipo,
			int cantidad,
			String grupo
			
			) {
			
		this.ceo=ceo;
		this.tipo=tipo;
		this.cantidad=cantidad;
		this.grupo=grupo;
			
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Getter y Setter ID_ceo
	public String getIdCeo() {
	    return id_ceo;
	}
	
	public void setIdCeo(String idCeo) {
	    this.id_ceo = idCeo;
	}

	// Getter y Setter Tipo
	public String getTipo() {
	    return tipo;
	}

	public void setTipo(String tipo) {
	    this.tipo = tipo;
	}

	// Getter y Setter Cantidad
	public int getCantidad() {
	    return cantidad;
	}
	
	public void setCantidad(int cantidad) {
	    this.cantidad = cantidad;
	}

	// Getter y Setter id_h
	public int getIdH() {
	    return id_h;
	}

	public void setIdH(int idH) {
	    this.id_h = idH;
	}
	
	//////////////////////////////////////////////
	
	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
}
package JavaBeans;
import java.io.Serializable;

public class JB_Armamento implements Serializable{
	private String id_ceo;
	private String tipo;
	private String cantidad;
	private String id_h;

	public JB_Armamento() {
		
	}
	
	public JB_Armamento(
			
			String id_ceo,
			String tipo,
			String cantidad,
			String id_h
			
			) {
			
		this.id_ceo=id_ceo;
		this.tipo=tipo;
		this.cantidad=cantidad;
		this.id_h=id_h;
			
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
	public String getCantidad() {
	    return cantidad;
	}
	
	public void setCantidad(String cantidad) {
	    this.cantidad = cantidad;
	}

	// Getter y Setter id_h
	public String getIdH() {
	    return id_h;
	}

	public void setIdH(String idH) {
	    this.id_h = idH;
	}

}
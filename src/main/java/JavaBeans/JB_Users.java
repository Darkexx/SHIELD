package JavaBeans;

import java.io.Serializable;

public class JB_Users implements Serializable{
	
	private String id_us;
	private String nom_us;
	private String pass;
	private String roll;
	
	public JB_Users() {
		
	}
	
	public JB_Users(
			
			String id_us,
			String nom_us,
			String pass,
			String roll
			
			) {
			
		this.id_us=id_us;
		this.nom_us=nom_us;
		this.pass=pass;
		this.roll=roll;
			
	}

	
	//Setter y Getters
	
	public JB_Users(String id, String password, String roll) {
		this.id_us=id;
		this.pass=password;
		this.roll=roll;
	}

	public String getId_us() {
		return id_us;
	}

	public void setId_us(String id_us) {
		this.id_us = id_us;
	}

	public String getNom_us() {
		return nom_us;
	}

	public void setNom_us(String nom_us) {
		this.nom_us = nom_us;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}
	
}

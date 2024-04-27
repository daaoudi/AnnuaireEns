package model;

public class Departement {

	private int id_departement;
	private String nom_departement;
	
	public int getIdDepartement() {
		return id_departement;
	}
	
	public void setIdDepartement(int id) {
		this.id_departement=id;
	}
	
	public String getNomDepartement() {
		return nom_departement;
	}
	
	public void setNomDepartement(String nom) {
		this.nom_departement=nom;
	}
	
	@Override 
	public String toString() {
		return "departement : [id_departement : " + id_departement +" nom_departement : "+ nom_departement +
				"  ]";
	}

}

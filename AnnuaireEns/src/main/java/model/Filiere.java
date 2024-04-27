package model;

public class Filiere {
	private int id_filiere;
	private String nom_filiere;
	private int id_departement;
	 private Departement departement;
	 
	 public Departement getDepartement() { 
	        return departement;
	    }

	    public void setDepartement(Departement departement) { 
	        this.departement = departement;
	    }

	
	public int getIdFiliere() {
		return id_filiere;
	}
	
	public void setIdFiliere(int id) {
		this.id_filiere=id;
	}
	
	public String getNomFiliere() {
		return nom_filiere;
	}
	
	public void setNomFiliere(String nom) {
		this.nom_filiere=nom;
	}
	
	public int getIdDepartement() {
		return id_departement;
	}
	
	public void setIdDepartement(int id) {
		this.id_departement=id;
	}
	
	@Override
    public String toString() {
        return "filiere : [id_filiere " + id_filiere + " nom_filiere : " 
               + nom_filiere + " id_departement : " + id_departement 
               + " departement : " + departement.toString() + " ] ";
    }



}

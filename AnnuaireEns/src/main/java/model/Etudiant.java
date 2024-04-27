package model;

public class Etudiant {
	
	private int id_etudiant;
	private int CNE;
	private  String nom;
	private  String prenom;
	private  String telephone;
	private int id_filiere;
	private Filiere filiere;
	
	public Filiere getFiliere() {
		return filiere;
	}
	
	public void setFiliere(Filiere fil) {
		this.filiere=fil;
	}
	
	public int getIdEtudiant() {
		return id_etudiant;
	}
	
	public void setIdEtudiant(int id) {
		this.id_etudiant=id;
	}
	
	public int getCNE() {
		return CNE;
	}
	
	public void setCNE(int cne) {
		this.CNE=cne;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom=prenom;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String tel) {
		this.telephone=tel;
	}
	
	public int getIdFiliere() {
		return id_filiere;
	}
	
	public void setIdFiliere(int id) {
		this.id_filiere=id;
	}
	
	@Override 
	public String toString() {
		return "etudiant : [id_etudiant : " + id_etudiant +" CNE : "+ CNE  +" nom : "+ nom +
				" prenom : "+ prenom + " telephone : " + telephone +" id_filiere "+ id_filiere +" Filiere :"+ filiere.toString()+ " ]";
	}


}

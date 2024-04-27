package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DbConnect;
import model.Etudiant;
import model.Filiere;
public class EtudiantController {
	
	Connection conn;

	public EtudiantController() throws ClassNotFoundException,SQLException {
		// TODO Auto-generated constructor stub
		conn=DbConnect.getConnection();
	}
	
	public void ajouterEtudiant(Etudiant etud) {
		
		try {
			PreparedStatement pst =conn.prepareStatement("insert into etudiant (CNE,nom,prenom,telephone,id_filiere)  values(?,?,?,?,?)");
			
					pst.setInt(1, etud.getCNE());
					pst.setString(2, etud.getNom());
					pst.setString(3, etud.getPrenom());
					pst.setString(4, etud.getTelephone());
					pst.setInt(5, etud.getIdFiliere());
					
					pst.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Etudiant> afficheEtudiants(){
		List<Etudiant> etu=new ArrayList<Etudiant>();
		
		try {
			Statement st= conn.createStatement();
			ResultSet rs = st.executeQuery("select e.id_etudiant, e.CNE, e.nom, e.prenom, e.telephone, e.id_filiere, f.nom_filiere "
                    + "from etudiant e "
                    + "JOIN filiere f ON e.id_filiere = f.id_filiere");

			
			while(rs.next()) {
				Etudiant et = new Etudiant();
				
				et.setIdEtudiant(rs.getInt("id_etudiant"));
				et.setCNE(rs.getInt("CNE"));
				et.setNom(rs.getString("nom"));
				et.setPrenom(rs.getString("prenom"));
				et.setTelephone(rs.getString("telephone"));
				et.setIdFiliere(rs.getInt("id_filiere"));
				
				Filiere filiere=new Filiere();
				filiere.setNomFiliere(rs.getString("nom_filiere"));
				et.setFiliere(filiere);
				
				
				etu.add(et);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return etu;
	}
	
	public List<Etudiant> rechercherEtudiantsParNom(String nom) {
        List<Etudiant> etudiants = new ArrayList<>();

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM etudiant WHERE nom LIKE ?");
            pst.setString(1, "%" + nom + "%");  
            ResultSet rs = pst.executeQuery();
            
            
            
            while (rs.next()) {
                Etudiant et = new Etudiant();

                et.setIdEtudiant(rs.getInt("id_etudiant"));
                et.setCNE(rs.getInt("CNE"));
                et.setNom(rs.getString("nom"));
                et.setPrenom(rs.getString("prenom"));
                et.setTelephone(rs.getString("telephone"));
                et.setIdFiliere(rs.getInt("id_filiere"));

                etudiants.add(et);
            }
          
           

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return etudiants;
    }


}

package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DbConnect;
import model.Departement;
import model.Filiere;

public class FiliereController {

Connection conn;
	
	public FiliereController() throws ClassNotFoundException ,SQLException{
		conn=DbConnect.getConnection();
	}
	
	public void ajouterFiliere(Filiere filiere) {
		
		try {
			
			PreparedStatement ps=conn.prepareStatement("insert into filiere (nom_filiere,id_departement) values(?,?)");
			ps.setString(1, filiere.getNomFiliere());
			ps.setInt(2, filiere.getIdDepartement());
			ps.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Filiere> afficheFilieres(){
		List<Filiere> fil = new ArrayList<Filiere>();
		
		try {
			Statement st=conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT f.id_filiere, f.id_departement, f.nom_filiere, d.nom_departement , d.id_departement " +
                    "FROM filiere f " +
                    "JOIN departement d ON f.id_departement = d.id_departement");

			
			while(rs.next()) {
				Filiere fi = new Filiere();
				
				fi.setIdFiliere(rs.getInt("id_filiere"));
				fi.setIdDepartement(rs.getInt("id_departement"));
				fi.setNomFiliere(rs.getString("nom_filiere"));
				
				 Departement dept = new Departement();
		            dept.setNomDepartement(rs.getString("nom_departement"));
		            dept.setIdDepartement(rs.getInt("id_departement"));
		            fi.setDepartement(dept);
				
				fil.add(fi);
				
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return fil;
	}


}

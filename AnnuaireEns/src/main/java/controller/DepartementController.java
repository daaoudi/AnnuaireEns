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
public class DepartementController {
	
Connection conn;
	
	public DepartementController() throws ClassNotFoundException ,SQLException{
		
		conn=DbConnect.getConnection();
	}
	
	public void ajouterDepartement(Departement departement) {
		try {
			PreparedStatement pst = conn.prepareStatement("insert into departement(nom_departement) values (?)");
			
			pst.setString(1,departement.getNomDepartement());
			pst.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Departement> afficheDepartements(){
		
		List<Departement> dep=new ArrayList<Departement>();
		
		try {
			Statement stm=conn.createStatement();
			ResultSet rs= stm.executeQuery("select * from departement");
			while(rs.next()) {
				Departement de=new Departement();
				de.setIdDepartement(rs.getInt("id_departement"));
				de.setNomDepartement(rs.getString("nom_departement"));
				
				dep.add(de);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return dep;
		
	}


}

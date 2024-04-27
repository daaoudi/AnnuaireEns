package web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Etudiant;
import model.Filiere;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import controller.EtudiantController;
import controller.FiliereController;

/**
 * Servlet implementation class EtudiantServlet
 */
public class EtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EtudiantController etdCont;
	private FiliereController filCont;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public EtudiantServlet()throws ClassNotFoundException,SQLException {
        super();
        // TODO Auto-generated constructor stub
        etdCont=new EtudiantController();
        filCont=new FiliereController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	
        List<Filiere> filieres = filCont.afficheFilieres();

        
        request.setAttribute("filieres", filieres);

        RequestDispatcher view = request.getRequestDispatcher("etudiant_form.jsp");
        view.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		Etudiant etud =new Etudiant();
		
		etud.setCNE(Integer.parseInt(request.getParameter("CNE")));
		etud.setNom(request.getParameter("nom"));
		etud.setPrenom(request.getParameter("prenom"));
		etud.setTelephone(request.getParameter("telephone"));
		etud.setIdFiliere(Integer.parseInt(request.getParameter("id_filiere")));
		
		String id_etudiant=request.getParameter("id_etudiant");
		
		if(id_etudiant==null || id_etudiant.isEmpty()) {
			etdCont.ajouterEtudiant(etud);
			 request.setAttribute("success", "nouveau etudiant ajouter avec succés !");
		}
		request.setAttribute("etudiants", etdCont.afficheEtudiants());
		RequestDispatcher list= request.getRequestDispatcher("view_etudiants.jsp");
		
		list.forward(request, response);
	}


}

package web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Etudiant;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import controller.EtudiantController;


/**
 * Servlet implementation class SearchEtudiant
 */
public class SearchEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EtudiantController etudCont;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 public SearchEtudiant() throws ClassNotFoundException,SQLException {
	        super();
	        // TODO Auto-generated constructor stub
	        etudCont=new EtudiantController();
	    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			response.getWriter().append("Served at: ").append(request.getContextPath());
			
			
			RequestDispatcher view=request.getRequestDispatcher("search_etudiant.jsp");
			view.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//doGet(request, response);
			
			String nom = request.getParameter("nom");
	        List<Etudiant> etudiants = etudCont.rechercherEtudiantsParNom(nom);

	        if (etudiants.isEmpty()) {
	            request.setAttribute("error", "Aucun étudiant trouvé avec le nom spécifié.");
	        } else {
	            request.setAttribute("etudiants", etudiants);
	        }

	        RequestDispatcher view = request.getRequestDispatcher("view_search.jsp");
	        view.forward(request, response);
		}

}

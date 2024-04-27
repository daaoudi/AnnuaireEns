package web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Departement;
import model.Filiere;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import controller.DepartementController;
import controller.FiliereController;


/**
 * Servlet implementation class FiliereServlet
 */
public class FiliereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FiliereController filCont;
	private DepartementController depCont;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 public FiliereServlet() throws ClassNotFoundException, SQLException {
	        super();
	        // TODO Auto-generated constructor stub
	        filCont=new FiliereController();
	        depCont=new DepartementController();
	    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			response.getWriter().append("Served at: ").append(request.getContextPath());
			
			List<Departement> departements = depCont.afficheDepartements();
			request.setAttribute("departements", departements);
			
			RequestDispatcher view=request.getRequestDispatcher("filiere_form.jsp");
			view.forward(request, response);
			
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//doGet(request, response);
			
			Filiere fil = new Filiere();
			
			fil.setNomFiliere(request.getParameter("nom_filiere"));
			fil.setIdDepartement(Integer.parseInt(request.getParameter("id_departement")));
			
			String id_filiere=request.getParameter("id_filiere");
			
			if(id_filiere==null || id_filiere.isEmpty()) {
				filCont.ajouterFiliere(fil);
				 request.setAttribute("success", "nouveau filiere ajouter avec succés !");
			}
			
			RequestDispatcher list = request.getRequestDispatcher("view_filieres.jsp");
			request.setAttribute("filieres", filCont.afficheFilieres());
			list.forward(request, response);
		}

}

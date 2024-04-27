package web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Departement;

import java.io.IOException;
import java.sql.SQLException;

import controller.DepartementController;

/**
 * Servlet implementation class DepartementServlet
 */

public class DepartementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartementController depCont;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public DepartementServlet() throws ClassNotFoundException, SQLException {
        super();
        // TODO Auto-generated constructor stub
        depCont=new DepartementController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher view=request.getRequestDispatcher("departement_form.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		Departement dept=new Departement();
		
		dept.setNomDepartement(request.getParameter("nom_departement"));
		String id_departement = request.getParameter("id_departement");
		
		if(id_departement==null || id_departement.isEmpty()) {
			depCont.ajouterDepartement(dept);
			 request.setAttribute("success", "nouveau departement ajouter avec succés !");
		}
		
		request.setAttribute("departements", depCont.afficheDepartements());
		RequestDispatcher list =request.getRequestDispatcher("view_departements.jsp");
		
		list.forward(request, response);
	}


}

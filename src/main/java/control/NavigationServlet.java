package control;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.persistence.exceptions.DatabaseException;

import model.Animal;


/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("doThisToItem");
		AnimalHelper ah = new AnimalHelper();
		String path = "/viewAllAnimalsServlet";
		
		if (act.equals("Delete")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Animal animalToDelete = ah.searchForAnimalByAnimalId(tempId);
			ah.deleteAnimal(animalToDelete);
			} catch (NumberFormatException e) {
				System.out.println("No option selected.");
			}
		}
		else if (act.equals("Edit")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Animal animalToEdit = ah.searchForAnimalByAnimalId(tempId);
			request.setAttribute("animalToEdit", animalToEdit);
			path = "/edit-animal.jsp";
			} catch (NumberFormatException e) {
				System.out.println("No option selected.");
			}
		}
		else if (act.equals("Return")) {
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}

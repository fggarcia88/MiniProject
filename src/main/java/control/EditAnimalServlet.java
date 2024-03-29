package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animal;


/**
 * Servlet implementation class EditAnimalServlet
 */
@WebServlet("/editAnimalServlet")
public class EditAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAnimalServlet() {
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
		AnimalHelper ah = new AnimalHelper();
		
		String animalName = request.getParameter("animalName");
		String type = request.getParameter("type");
		String breed = request.getParameter("breed");
		String color = request.getParameter("color");
		String ownerName = request.getParameter("ownerName");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Animal animalToUpdate = ah.searchForAnimalByAnimalId(tempId);
		
		animalToUpdate.setAnimalName(animalName);
		animalToUpdate.setAnimalType(type);
		animalToUpdate.setAnimalBreed(breed);
		animalToUpdate.setAnimalColor(color);
		animalToUpdate.setaddedBy(ownerName);
		
		ah.updateAnimal(animalToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllAnimalsServlet").forward(request, response);
	}

}

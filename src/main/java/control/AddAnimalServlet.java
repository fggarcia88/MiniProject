package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animal;


/**
 * Servlet implementation class AddAnimalServlet
 */
@WebServlet("/addAnimalServlet")
public class AddAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAnimalServlet() {
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
		String animalName = request.getParameter("animalName");
		String type = request.getParameter("type");
		String breed = request.getParameter("breed");
		String color = request.getParameter("color");
		String ownerName = request.getParameter("ownerName");	
		
		Animal a = new Animal(type, breed, animalName, color, ownerName);
		AnimalHelper ah = new AnimalHelper();
		
		ah.insertAnimal(a);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}

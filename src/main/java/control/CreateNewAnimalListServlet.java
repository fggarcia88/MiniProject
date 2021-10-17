package control;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animal;
import model.AnimalListDetails;
import model.AnimalOwner;

/**
 * Servlet implementation class CreateNewAnimalListServlet
 */
@WebServlet("/createNewAnimalListServlet")
public class CreateNewAnimalListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewAnimalListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	AnimalHelper ah = new AnimalHelper();
    	String listName = request.getParameter("listName");
    	System.out.println("List Name: "+ listName);
    	String month = request.getParameter("month");
    	String day = request.getParameter("day");
    	String year = request.getParameter("year");
    	String animalOwnerFirstName = request.getParameter("ownerFirstName");
    	String animalOwnerLastName = request.getParameter("ownerLastName");
    	LocalDate ld;
    	try {
    		ld = LocalDate.of(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));
		} catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
    	
    	String[] selectedItems = request.getParameterValues("allItemsToAdd");
    	List<Animal> selectedAnimalsInList = new ArrayList<Animal>();
    	//make sure something was selected – otherwise we get a null pointer exception
    	if (selectedItems != null && selectedItems.length > 0) {
    		for (int i = 0; i<selectedItems.length; i++) {
    			System.out.println(selectedItems[i]);
    			Animal a = ah.searchForAnimalByAnimalId(Integer.parseInt(selectedItems[i]));
    			selectedAnimalsInList.add(a);
			}
		}
    	AnimalOwner owner = new AnimalOwner(animalOwnerFirstName, animalOwnerLastName);
    	AnimalListDetails ald = new AnimalListDetails(listName, ld, owner);
    	ald.setListOfAnimals(selectedAnimalsInList);
    	AnimalListDetailsHelper aldh = new AnimalListDetailsHelper();
    	aldh.insertNewDetails(ald);
    	System.out.println("Success!");
    	System.out.println(ald.toString());
    	getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

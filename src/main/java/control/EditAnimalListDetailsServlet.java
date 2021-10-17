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
 * Servlet implementation class EditAnimalListDetailsServlet
 */
@WebServlet("/editAnimalListDetailsServlet")
public class EditAnimalListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAnimalListDetailsServlet() {
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
		AnimalListDetailsHelper aldh =	new	AnimalListDetailsHelper();
		AnimalHelper ah = new AnimalHelper();
		AnimalOwnerHelper sh = new AnimalOwnerHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		AnimalListDetails listToUpdate = aldh.searchForListDetailsById(tempId);
		String newListName = request.getParameter("listName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String ownerFirstName = request.getParameter("ownerFirstName");
		String ownerLastName = request.getParameter("ownerLastName");
		AnimalOwner newOwner = sh.findOwner(ownerFirstName, ownerLastName);
		LocalDate ld;
		try	{
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch	(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		try	{
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<Animal> selectedItemsInList = new ArrayList<Animal>();
			for	(int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Animal a = ah.searchForAnimalByAnimalId(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(a);
			}
			listToUpdate.setListOfAnimals(selectedItemsInList);
		} catch (NullPointerException ex) {
			List<Animal> selectedItemsInList = new ArrayList<Animal>();
			listToUpdate.setListOfAnimals(selectedItemsInList);
		}
		listToUpdate.setListName(newListName);
		listToUpdate.setListDate(ld);
		listToUpdate.setOwner(newOwner);
		aldh.updateList(listToUpdate);
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}

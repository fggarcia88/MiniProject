package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AnimalListDetails;


/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
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
		String act = request.getParameter("doThisToList");
		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		} else if (act.equals("Delete")) {
			try	{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				AnimalListDetails listToDelete = aldh.searchForListDetailsById(tempId);
				aldh.deleteList(listToDelete);
				} catch (NumberFormatException e) {
					System.out.println("Forgot to click a button");
				} finally {
					getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
				}
		} else if (act.equals("Edit")) {			
			try	{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				AnimalListDetails listToEdit = aldh.searchForListDetailsById(tempId);
				request.setAttribute("listToEdit", listToEdit);
				request.setAttribute("month", listToEdit.getListDate().getMonthValue());
				request.setAttribute("date", listToEdit.getListDate().getDayOfMonth());
				request.setAttribute("year", listToEdit.getListDate().getYear());
				AnimalHelper ahForItems = new AnimalHelper();
				request.setAttribute("allAnimals", ahForItems.showAllAnimals());
				if (ahForItems.showAllAnimals().isEmpty()){
					request.setAttribute("allAnimals", " ");
				}
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
		}
	}
}

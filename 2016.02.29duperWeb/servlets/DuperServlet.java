package bg.ittalents.duper.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bg.ittalents.duper.dao.OrderDAO;
import bg.ittalents.duper.dao.OrderDAOException;
import bg.ittalents.duper.model.Order;

/**
 * Servlet implementation class DuperServlet
 */
@WebServlet("/DuperServlet")
public class DuperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public DuperServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		OrderDAO dao = new OrderDAO();
		List<Order> orders;
		response.setContentType("text/html");
		try {
			orders = dao.getAllOrders();
			
			writer.print("<h1 style=\"background-color:green; color:blue; text-align:center;\"> Taxi Orders </h1>");

			for (Order order : orders) {
				writer.println("<h2 style=\"color:red\"> Order ID : " + order.getId() + " </h2>");
				writer.println("<p>  From :" + order.getFrom() + " </p>");
				writer.println("<p> To :" + order.getTo() + " </p>");
				writer.println("<p> Time :" + order.getTimeOfOrdering() + " </p>");
				writer.println("<p> Taxi model :" + order.getTaxi().getModel() + " </p>");
				writer.println("<p> Driver name :" + order.getTaxi().getDriver().getName()+ " </p>");
				writer.println("<br/><hr/><br/>");
			}
		} catch (OrderDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package bg.ittalents.duper.model;

import java.util.List;

import bg.ittalents.duper.dao.OrderDAO;
import bg.ittalents.duper.dao.OrderDAOException;

public class Demo {

	public static void main(String[] args) throws OrderDAOException {
		OrderDAO dao = new OrderDAO();
		  List<Order> orders = dao.getAllOrders();
		  
		  for (Order order : orders) {
			  System.out.println("Order ID : " + order.getId());
			  System.out.println("From :" + order.getFrom());
			  System.out.println("To :" + order.getTo());
			  System.out.println("Time :" + order.getTimeOfOrdering());
			  System.out.println("Taxi model :" + order.getTaxi().getModel());
			  System.out.println("Driver name :" + order.getTaxi().getDriver().getName());
			  System.out.println("---------------------");
		  }
	}

}

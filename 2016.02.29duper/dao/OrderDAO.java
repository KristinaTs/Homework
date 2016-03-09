package bg.ittalents.duper.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import bg.ittalents.duper.model.Order;

public class OrderDAO extends AbstractDAO {

	private static final String ADD_NEW_ORDER_SQL = "INSERT INTO Orders VALUES (null, ?, ?, ?, ?);";

	public int addOrder(Order order) throws OrderDAOException {
		try {
			PreparedStatement ps = getCon().prepareStatement(ADD_NEW_ORDER_SQL,
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, order.getFrom());
			ps.setString(2, order.getTo());
			Timestamp timestamp = Timestamp.valueOf(order.getTimeOfOrdering());
			java.sql.Date date = new java.sql.Date(timestamp.getTime());
			ps.setDate(3, date);
			ps.setInt(4, order.getTaxi().getId());
			ps.executeUpdate();

			ResultSet res = ps.getGeneratedKeys();
			res.next();
			return res.getInt(1);

		} catch (SQLException e) {
			throw new OrderDAOException("The order cannot be inserted right now. I'm so sorry about that.", e);
		}
	}

	public List<Order> getAllOrders() throws OrderDAOException {
		List<Order> allOrders = new ArrayList<Order>();

		try {
			Statement statement = getCon().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders;");
			
			ITaxiDAO dao = new TaxiDAO();
			
			while (resultSet.next()) {
				Date date = resultSet.getDate(4);
				Timestamp t = new Timestamp(date.getTime());
				
				allOrders.add(new Order(resultSet.getInt(1), 
						resultSet.getString(2), 
						resultSet.getString(3), 
						t.toLocalDateTime(),
						dao.getTaxiById(resultSet.getInt(5))));
			}
			return allOrders;
			
		} catch (Exception e) {
			throw new OrderDAOException(
					"Cannot get all orders right now, sorry, try again later. Have a nice weekend.");
		}
	}

}

package bg.ittalents.duper.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bg.ittalents.duper.exceptions.DriverDAOException;
import bg.ittalents.duper.model.Taxi;

public class TaxiDAO extends AbstractDAO implements ITaxiDAO {
	
	private static final String ADD_NEW_TAXI_SQL = "INSERT INTO taxies VALUES(null, ?, ?)";
	private static final String FIND_TAXI_BY_ID_SQL = "SELECT * FROM Taxies WHERE id = ?";

	/* (non-Javadoc)
	 * @see bg.ittalents.duper.dao.ITaxiDAO#addTaxi(bg.ittalents.duper.model.Taxi)
	 */
	public int addTaxi(Taxi taxi) throws TaxiDAOException {
		if (taxi == null)
			throw new TaxiDAOException("Kyv e toq null obekt ve na maika ti ....");
		
		try {
			PreparedStatement ps = getCon().prepareStatement(ADD_NEW_TAXI_SQL, 
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, taxi.getModel());
			ps.setInt(2, taxi.getDriver().getId());
			ps.executeUpdate();
			
			ResultSet res = ps.getGeneratedKeys();
			res.next();
			return res.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new TaxiDAOException("Taxi cannot be added right now. Have a nice day! Bye!", e);
		}
	}
	
	/* (non-Javadoc)
	 * @see bg.ittalents.duper.dao.ITaxiDAO#getTaxiById(int)
	 */
	public Taxi getTaxiById(int taxiId) throws DriverDAOException {
		Taxi wantedTaxi = null;

		try {
			PreparedStatement ps = getCon().prepareStatement(FIND_TAXI_BY_ID_SQL);
			ps.setInt(1, taxiId);
			ResultSet result = ps.executeQuery();
			result.next();

			String model = result.getString(2);
			int driverId = result.getInt(3);

			wantedTaxi = new Taxi(taxiId, model, new DriverDAO().getDriverById(driverId));
			return wantedTaxi;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DriverDAOException("The driver with id " + taxiId + " cannot be found . Thank you.", e);
		}
	}

}

package bg.ittalents.duper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bg.ittalents.duper.exceptions.DriverDAOException;
import bg.ittalents.duper.model.Driver;

public class DriverDAO extends AbstractDAO implements IDriverDAO {

	private static final String UPDATE_DRIVER_SQL = "UPDATE Drivers SET name = ?, tariff = ? WHERE id = ?;";
	private static final String FIND_DRIVER_BY_ID_SQL = "SELECT * FROM Drivers WHERE id = ?";
	private static final String INSERT_NEW_DRIVER_SQL = "INSERT INTO Drivers VALUES (null, ?, ?);";

	/**
	 * Adds new Driver in the database.
	 * 
	 * @param driver
	 *            - driver POJO to be added.
	 * @throws DriverDAOException
	 *             when driver is null or cannot be added.
	 */
	public int addDriver(Driver driver) throws DriverDAOException {
		if (driver != null) {

			try {
				PreparedStatement ps = getCon().prepareStatement(INSERT_NEW_DRIVER_SQL,
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, driver.getName());
				ps.setFloat(2, driver.getTariff());
				ps.executeUpdate();

				ResultSet result = ps.getGeneratedKeys();
				result.next();
				return result.getInt(1);

			} catch (SQLException e) {
				e.printStackTrace();
				throw new DriverDAOException("The driver cannot be added right now. Thank you.", e);
			}
		} else {
			throw new DriverDAOException("Drivera ti e null be kaltak");
		}
	}

	public void updateDriver(Driver driver) throws DriverDAOException {
		if (driver != null) {
			try {
				PreparedStatement ps = getCon().prepareStatement(UPDATE_DRIVER_SQL);

				ps.setString(1, driver.getName());
				ps.setFloat(2, driver.getTariff());
				ps.setInt(3, driver.getId());

				ps.executeUpdate();
			} catch (SQLException e) {
				throw new DriverDAOException("The driver cannot be updated right now. Thank you.", e);
			}
		}
		else {
			throw new DriverDAOException("Drivera ti e null be kaltak");
		}
	}

	public void removeDriver(int driverId) throws DriverDAOException {
		PreparedStatement ps;
		try {
			ps = getCon().prepareStatement("DELETE FROM Drivers WHERE id = ?");
			ps.setInt(1, driverId);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new DriverDAOException("The driver cannot be deleted right now. Thank you.", e);
		}
	}

	public Driver getDriverById(int driverId) throws DriverDAOException {
		Driver wantedDriver = null;

		try {
			PreparedStatement ps = getCon().prepareStatement(FIND_DRIVER_BY_ID_SQL);
			ps.setInt(1, driverId);
			ResultSet result = ps.executeQuery();
			result.next();

			String name = result.getString(2);
			float tariff = result.getFloat(3);

			wantedDriver = new Driver(driverId, name, tariff);
			return wantedDriver;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DriverDAOException("The driver with id " + driverId + " cannot be found . Thank you.", e);
		}
	}
}

package bg.ittalents.duper.dao;

import bg.ittalents.duper.exceptions.DriverDAOException;
import bg.ittalents.duper.model.Driver;

public interface IDriverDAO {

	int addDriver(Driver driver) throws DriverDAOException;

	void updateDriver(Driver driver) throws DriverDAOException;

	public void removeDriver(int driverId) throws DriverDAOException ;

	Driver getDriverById(int driverId) throws DriverDAOException;

}
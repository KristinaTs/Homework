package bg.ittalents.duper.dao;

import bg.ittalents.duper.exceptions.DriverDAOException;
import bg.ittalents.duper.model.Taxi;

public interface ITaxiDAO {

	int addTaxi(Taxi taxi) throws TaxiDAOException;

	Taxi getTaxiById(int taxiId) throws DriverDAOException;

}
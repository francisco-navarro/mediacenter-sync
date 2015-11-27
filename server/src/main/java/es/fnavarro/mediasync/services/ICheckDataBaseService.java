package es.fnavarro.mediasync.services;

import javax.sql.DataSource;

public interface ICheckDataBaseService {

	void checkIfExists(DataSource datasource);

}

package es.fnavarro.mediasync.services;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("checkDataBaseService")
public class CheckDataBaseService {
	
	@Autowired
	public void checkIfExists(DataSource datasource){
		System.out.println(datasource);
	}

}

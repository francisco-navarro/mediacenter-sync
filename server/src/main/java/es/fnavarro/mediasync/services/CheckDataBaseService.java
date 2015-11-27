package es.fnavarro.mediasync.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("checkDataBaseService")
public class CheckDataBaseService extends BaseService{

	private static final String TABLES[]  = { "CONFIG", "FILES" };

	private static final String SQL_PATH = "sql/";

	private DatabaseMetaData metaData; 
	private Connection connection;

	@Autowired
	public void checkIfExists(DataSource datasource){
		
		try{
			connection = datasource.getConnection();
			metaData = connection.getMetaData();			
			for(String table : TABLES ){
				checkOrCreateTable(table);
			}

		}catch(Exception e){
			logger.error("Exception checking database", e);
			
		}finally {
			closeConnection();
		}
	}

	private void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {				
			e.printStackTrace();
		}
	}

	private void checkOrCreateTable(String tablePattern) throws Exception {

		ResultSet tables = metaData.getTables(null, null, tablePattern , null);

		if (tables.next()) {
			logger.debug("Table "+tablePattern+" exists "); 

		} else{
			createTable(tablePattern);
		}
	}

	private void createTable(String table) throws Exception{
		logger.debug("Creating table " + table);
		PreparedStatement statement = null;
		try{
			statement = connection.prepareStatement(getSqlResource(table));			
			statement.executeUpdate();
			
		}catch(Exception e){
			logger.error("Exception creating table "+table, e);
			throw e;
		} finally {
			closeStatement(statement);
		}
		
	}

	private void closeStatement(PreparedStatement statement) {
		if(statement!=null){
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private String getSqlResource(String table) throws Exception{
		InputStream input = this.getClass().getClassLoader().getResourceAsStream(SQL_PATH + table + ".sql");
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		StringBuilder builder = new StringBuilder();
		
		String line=null;
		while((line=reader.readLine())!=null){
		    builder.append(line).append("\n");
		}
		
		return builder.toString();		
	}
	
	

}

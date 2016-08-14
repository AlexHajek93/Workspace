package ers.service;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import ers.dao.ErsDAO;

public class ServiceLocator {
	public static DataSource getDatabase(){
 		try{
 			Properties environmentProps = new Properties();
 			environmentProps.load(
 					ErsDAO.class.getClassLoader()
 						.getResourceAsStream("jndi.properties")
 			);
 			Context ctxt = new InitialContext(environmentProps);
 			DataSource ds = (DataSource) ctxt.lookup("db/chinook");
 			return ds;
 		}catch(Exception e){
 			e.printStackTrace();
 			return null;
 		}
 	}
}

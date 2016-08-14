package com.revature.service;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.revature.dao.TrackDAO;

//Does all the lookups... usually remote services
//JNDI,CORBE,SOAP,REST,RMI,RPC,etc.
public class ServiceLocator {
	public static DataSource getChinookDatabase(){
 		try{
 			Properties environmentProps = new Properties();
 			environmentProps.load(
 					TrackDAO.class.getClassLoader()
 						.getResourceAsStream("jndi.properties")
 			);
 			Context ctxt = new InitialContext(environmentProps);
 							// ^^^ JNDI lookup obj 
 			DataSource ds = (DataSource) ctxt.lookup("db/chinook");
 			return ds;
 		}catch(Exception e){
 			e.printStackTrace();
 			return null;
 		}
 	}
}

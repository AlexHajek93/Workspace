package com.revature.log4j;

import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App{
		
	private static Logger log = Logger.getRootLogger();
	
  public static void main( String[] args )
  {
    log.trace("Doing Null Check"); 	
  	log.debug("Connected to DB");
    log.info("Hello World.");
  	log.warn("Attempted access to unauthorized resource");
  	log.error("Exception thrown... doing stuff to recover");
  	log.fatal("REALLY BAD STUFF... shutting down app gracefully");
  }
}

package com.LMS_API.utility;

	import org.apache.logging.log4j.LogManager;

	import org.apache.logging.log4j.Logger;

import io.restassured.response.Response;


	public class Loggerload {

	    private static Logger logger = LogManager.getLogger();

	    

	   	 public static void info(Response allPrograms) {

			 logger.info(allPrograms); 			

			 }

	   	public static void info(String string) {

			 logger.info(string); 			

			 }
	   	
		 public static void warn(String message) {

			 logger.warn(message);

			}

		 public static void error(String message) {

			 logger.error(message);

			}

		 public static void fatal(String message) {

			 logger.fatal(message);

			}

		 public static void debug(String message) {

			 logger.debug(message);

			}

	
}

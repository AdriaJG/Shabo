/**
 * 
 */
package com.shabo.api.security;

/**
 * @author Fenrir
 *
 */
public class Constants {
	// Spring Security
		public static final String LOGIN_URL = System.getenv("LOGIN_URL");
		public static final String REGISTER_URL = System.getenv("REGISTER_URL");
		public static final String HEADER_AUTHORIZACION_KEY = System.getenv("HEADER_AUTHORIZACION_KEY");
		public static final String TOKEN_BEARER_PREFIX = System.getenv("TOKEN_BEARER_PREFIX");

		// JWT

		public static final String ISSUER_INFO = System.getenv("ISSUER_INFO");
		public static final String SUPER_SECRET_KEY = System.getenv("SUPER_SECRET_KEY");
		public static final int TOKEN_EXPIRATION_TIME = Integer.valueOf(System.getenv("TOKEN_EXPIRATION_TIME")); // 10 da

		//Pusher
		
		public static final String CHAT_TABLE_NAME = System.getenv("CHAT_TABLE_NAME");

}

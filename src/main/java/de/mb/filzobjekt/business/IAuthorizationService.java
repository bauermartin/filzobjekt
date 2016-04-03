package de.mb.filzobjekt.business;

public interface IAuthorizationService {

	boolean loginAdmin(String username, String password);
	
	boolean checkToken(String token);

	String getToken(String username, String ip);
}

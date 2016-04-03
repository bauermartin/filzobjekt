package de.mb.filzobjekt.business.factory;

import de.mb.filzobjekt.business.AuthorizationService;
import de.mb.filzobjekt.business.IAuthorizationService;

/**
 * @author Martin Bauer (03.04.2016)
 *
 */
public class AuthorizationFactory {

	private static IAuthorizationService auth_service;

	public static synchronized IAuthorizationService getService() {
		if (auth_service == null) {
			auth_service = new AuthorizationService();
		}
		return auth_service;
	}

}

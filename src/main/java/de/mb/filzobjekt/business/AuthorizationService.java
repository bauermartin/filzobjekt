package de.mb.filzobjekt.business;

import java.util.Date;
import org.springframework.stereotype.Service;
import de.mb.filzobjekt.util.TokenFaktory;

/**
 * @author Martin Bauer (18.01.2016)
 *
 */
@Service
public class AuthorizationService implements IAuthorizationService {

	private static final TokenFaktory tFac = new TokenFaktory();

	@Override
	public boolean loginAdmin(String username, String password) {
		if (username.equals("test") && password.equals("1234")) {
			System.out.println("Credentials pass");
			return true;
		}
		System.out.println("Credentials fail");
		return false;
	}

	@Override
	public boolean checkToken(String token) {
		try {
			if (tFac.isValidToken(token)) {
				String values[] = tFac.getTokenParams(token);
				Date date = new Date();
				long currTime = date.getTime();
				if (Long.valueOf(values[2]).longValue() < currTime) {}
				String hashstring = tFac.hashToken(values[0], values[1], values[2]);
				if (!hashstring.equals(values[3])) {

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getToken(String username, String ip) {
		return tFac.generateToken(username, ip);
	}

}

package de.mb.filzobjekt.util;

import java.security.MessageDigest;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.codec.binary.Base64;

/**
 * @author Martin Bauer
 * 
 */
public class TokenFaktory {
	private static final String TOKEN_SEPERATOR = "#";
	private static Properties prop = new Properties();

	// generates token with key as parameter
	public static String hashToken(final String name, final String ip, final String timeToLive,
			final String key) throws Exception {
		final MessageDigest md = MessageDigest.getInstance("SHA-256");
		final String giantString = name + ip + timeToLive + prop.getProperty(key);
		md.digest(giantString.getBytes("UTF-8"));
		return Base64.encodeBase64String(md.digest());
	}

	public TokenFaktory() {
		try {
			prop.load(getClass().getClassLoader().getResourceAsStream("secret.properties"));
		} catch (Exception e) {}
	}

	public String generateToken(final String username, final String ip) {
		final Date date = new Date();
		final String timeToLive = Long.toString(date.getTime()
				+ Integer.parseInt(prop.getProperty("LIFETIME_IN_MINUTES")) * 1000 * 60);
		try {
			return Base64.encodeBase64String((username + TOKEN_SEPERATOR + ip + TOKEN_SEPERATOR
					+ timeToLive + TOKEN_SEPERATOR + hashToken(username, ip, timeToLive)).getBytes());
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getHashFormToken(final String token) {
		return getTokenParams(token)[3];
	}

	public String getIpFormToken(final String token) {
		return getTokenParams(token)[1];
	}

	public String getNameFormToken(final String token) {
		return getTokenParams(token)[0];
	}

	public String getTimeFormToken(final String token) {
		return getTokenParams(token)[2];
	}

	public String[] getTokenParams(final String token) {
		final byte[] tokenStringDec = Base64.decodeBase64(token);
		final String tokenString = new String(tokenStringDec);
		final String[] values = tokenString.split(TOKEN_SEPERATOR);
		return values;
	}

	// uses properties file as resource for keys
	public String hashToken(final String name, final String ip, final String timeToLive)
			throws Exception {
		final MessageDigest md = MessageDigest.getInstance("SHA-256");
		final String giantString = name + ip + timeToLive + prop.getProperty("SECRET_KEY");
		md.digest(giantString.getBytes());
		return Base64.encodeBase64String(md.digest());
	}

	public boolean isValidToken(String token) throws Exception {
		return token.equals(hashToken("", "", ""));
	}
}
